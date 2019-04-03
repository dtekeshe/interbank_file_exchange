package com.bsva.dmcs.operations.processes;

import static com.bsva.commonsv02.util.EndOfServiceUtils.sleep;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bsva.commonsv02.util.EndOfServiceException;
import com.bsva.commonsv02.util.NoFleetBillingTxnsException;
import com.bsva.dao.v02.CompanyParametersDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dao.v02.billing.FleetBillingResolvedDAO;
import com.bsva.dao.v02.endofservice.SubServiceStatusDAO;
import com.bsva.dao.v02.fileextract.PendingOutputFileCheckDAO;
import com.bsva.dcms.commons.fileextract.GenerateExtractedOutputFiles;
import com.bsva.dcms.commons.util.Utils;
import com.bsva.dmcs.fileextractv02.FileExtractProcess;
import com.bsva.dmcs.fileloadv02.billing.FleetBilateralBillingCalculator;
import com.bsva.dmcs.fileloadv02.dto.Service;
import com.bsva.dmcs.fileloadv02.dto.SubService;
import com.bsva.dmcs.fileloadv02.indexer.FleetBillingTxnsBinder;
import com.bsva.dmcs.fileloadv02.parsers.EndOfDayFileCopy;
import com.bsva.dmcs.fileloadv02.parsers.EndOfDayFileCopyCCR009;
import com.bsva.dmcs.operations.utils.Record98Builder;
import com.bsva.entities.v02.billing.FleetBillingEntity;
import com.bsva.entities.v02.endofday.EndOfDayBillingSummary_DAO;
import com.bsva.entities.v02.endofday.InputFileControlEOD_DAO;
import com.bsva.entities.v02.endofservice.InputFileControlEntity;
import com.bsva.entities.v02.outputcontrols.LastFileOutputControlKey;
import com.bsva.entities.v02.outputcontrols.OutputControlDayTotalEntity;
import com.bsva.entities.v02.settlement.CSO_CSR03031VisaReport_DAO;
import com.bsva.entities.v02.settlement.CSO_CSR303031McardReport_DAO;
import com.bsva.settlementv02.SettlementLoaderProcess;

/**
 * TODO Document
 */
public class EndOfService {

	private static final String EndOfService = "ENDOFSERVICE";

	private static final String processStatus = "C";

	private static boolean updateMonthlyTotals = true;

	public static void stop(String subServiceID) throws EndOfServiceException {

		// Ask Rinus on what to do at close of service.
		List<InputFileControlEntity> inputFileControlList = new InputFileControlEOD_DAO().getProcessStatus(subServiceID,
				processStatus);
		if (updateMonthlyTotals) {
			EndOfDayBillingSummary_DAO endOfDayBillingSummar = new EndOfDayBillingSummary_DAO();
			endOfDayBillingSummar.getMonthEndTable();
			updateMonthlyTotals = false;
		}
		/*if ("VISA CARD".equals(subServiceID)) {
			CSO_CSR03031VisaReport_DAO daoVisa = new CSO_CSR03031VisaReport_DAO();
			daoVisa.populateCSR3031VisaTable();
		}
		if ("MASTERCARD".equals(subServiceID)) {
			CSO_CSR303031McardReport_DAO doMcard = new CSO_CSR303031McardReport_DAO();
			doMcard.populateCSR3031McardTable();
		}*/

		if (inputFileControlList.size() > 0) {

			// FILE LOAD CLOSE
			// -------------------------------------------------------------------------------------------
			/*
			 * System.out.println("CLOSING FILE LOAD FOR SUB SERVICE : " + subServiceID + "."); String subServicePrefix
			 * = new DeliveryServiceDAO().filenamePrefixes().get(subServiceID); DeliveredFilesReaderDAO
			 * deliveredFilesReaderDAO = new DeliveredFilesReaderDAO(); while(
			 * deliveredFilesReaderDAO.pendingDeliveredFiles(subServicePrefix) ) {
			 * System.out.println("WAITING FOR FILE LOAD TO PROCESS " + subServiceID + " INPUT FILES."); // TODO timeout
			 * after 60 seconds sleep(15); } new SubServiceStatusDAO().updateStatus(subServiceID, "I", "C");
			 */

			// FLEET BILLING
			// --------------------------------------------------------------------------------------------
			if ("FLEET CARD".equals(subServiceID)) {
				try {
					// fleet billing bind
					new FleetBillingTxnsBinder().bind();

					// billing
					// get vat rate
					BigDecimal vatRate = new CompanyParametersDAO().companyParameters().getVatPercentage();

					FleetBillingResolvedDAO billingResolvedDAO = new FleetBillingResolvedDAO();

					// read records
					List<FleetBillingEntity> txns = billingResolvedDAO.billingRecords(subServiceID);

					// billing calculator
					List<Map<String, Object>> payload = new FleetBilateralBillingCalculator(Service.CARD,
							SubService.FLEET, vatRate).fleetBill(txns);

					// update CSO_TRANSACTIONS.
					billingResolvedDAO.update(payload);

				}
				catch (NoFleetBillingTxnsException e) {
					// spolog
				}
			}
			// FILE EXTRACT CLOSE
			// ----------------------------------------------------------------------------------------
			System.out.println("CLOSING FILE EXRACT FOR SUB SERVICE : " + subServiceID + ".");
			Utils.logSpolog("CLOSING FILE EXRACT FOR SUB SERVICE : " + subServiceID + ".", EndOfService);
			// stop file extract by changing status code to "C" i.e. Request Close
			new SubServiceStatusDAO().updateStatus(subServiceID, "O", "C");

			// build 98 records data
			// boolean created98recordData = build98RecordsData( subServiceID );
			// if ( ! created98recordData ) {
			// throw new EndOfServiceException( "FAILED TO BUILD 98 RECS FOR " + subServiceID );
			// }
			String serviceID = "CARD";
			Map<LastFileOutputControlKey, OutputControlDayTotalEntity> dayTotals = Record98Builder.build(serviceID,
					subServiceID);

			// file extract partial files
			new SubServiceStatusDAO().updateStatus(subServiceID, "O", "P");
			// wait until all files are extracted.
			PendingOutputFileCheckDAO pendingOutputFileCheckDAO = new PendingOutputFileCheckDAO();
			while (pendingOutputFileCheckDAO.pendingFiles(subServiceID)) {
				System.out.println("WAITING FOR PENDING " + subServiceID + " TO BE EXTRACTED.");
				Utils.logSpolog("WAITING FOR PENDING " + subServiceID + " TO BE EXTRACTED.", EndOfService);
				sleep(30);
			}

			new FileExtractProcess().endOfService(serviceID, subServiceID, dayTotals);

			// SETTLEMENT REPORTS
			// -------------------------------------------------------------------------------------
			System.out.println("PRINTING SETTLEMENT REPORTS FOR SUB SERVICE : " + subServiceID + ".");
			Utils.logSpolog("PRINTING SETTLEMENT REPORTS FOR SUB SERVICE : " + subServiceID + ".", EndOfService);
			new SettlementLoaderProcess().settle(subServiceID);

			EndOfDayFileCopy filecopy = new EndOfDayFileCopy();
			filecopy.copyReceiveFileToSendFolder(subServiceID);

			if ("FLEET CARD".equals(subServiceID)) {
				EndOfDayFileCopyCCR009 endOfDayFileCCR009 = new EndOfDayFileCopyCCR009();
				endOfDayFileCCR009.copyReceiveFileToSendFolder(subServiceID);
			}
			// CLOSE SERVICE
			// ------------------------------------------------------------------------------------------
			// stop file extract by changing status code to "C" i.e. Request Close
			new SubServiceStatusDAO().updateStatus(subServiceID, "O", "N");

			if ("VISA CARD".equals(subServiceID)) {
				GenerateExtractedOutputFiles generateExtractedOutputFiles = new GenerateExtractedOutputFiles();
				generateExtractedOutputFiles.writeVisaFile();
			}
		}
		else {
			Utils.logSpolog(
					"NO FILE EXTRACTION WILL BE DONE FOR : " + subServiceID + " PROCESS STATUS ARE STILL ON HOLD (H) .",
					EndOfService);
			System.out.println(
					"NO FILE EXTRACTION WILL BE DONE FOR : " + subServiceID + " PROCESS STATUS ARE STILL ON HOLD (H).");
		}

	}

	public static void main(String[] args) {
		try {
			stop("FLEET CARD");
		}
		catch (EndOfServiceException e) {
			e.printStackTrace();
		}
		/*
		 * if (args.length < 1) { System.out.println("Usage: close_service <subServiceID> "); System.exit(1); }
		 * 
		 * String subServiceID = args[0].toUpperCase(); System.out.println("PROCESSING REQUEST CLOSE FOR SUB SERVICE : "
		 * + subServiceID);
		 * 
		 * try { stop( subServiceID ); System.out.println("SUB SERVICE : " + subServiceID + " SUCCESSFULLY CLOSED."); }
		 * catch (EndOfServiceException e) { System.out.println("ERROR CLOSING SUB SERVICE : " + subServiceID + " : " +
		 * e.getMessage() ); }
		 */
	}
}

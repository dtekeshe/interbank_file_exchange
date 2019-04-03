package com.bsva.dmcs.reportv02.settlement;

import com.bsva.commonsv02.util.SettlementGenerationException;
import com.bsva.dao.v02.CCR00XDataDAO;
import com.bsva.dao.v02.CompanyParametersDAO;
import com.bsva.dao.v02.TxnGroupCodesDAO;
import com.bsva.dao.v02.settlement.CCR00XAcquirersDAO;
import com.bsva.dao.v02.settlement.CCR00XFinalTotalsDataDAO;
import com.bsva.dao.v02.settlement.CCR00XIssuersDAO;
import com.bsva.dao.v02.settlement.CR00XCardTypesDAO;
import com.bsva.dmcs.reportv02.commons.AddressWriter;
import com.bsva.dmcs.reportv02.commons.FileWriter;
import com.bsva.dmcs.reportv02.dto.TxnGroupTotalsDTO;
import com.bsva.dmcs.reportv02.util.Justification;
import com.bsva.dto.CCR00XDataDTO;
import com.bsva.dto.FileHeaderDTO;
import com.bsva.dto.FinalTotalsTxnGroup;
import com.bsva.dto.TxnGroup;
import com.bsva.entities.v02.members.MemberAddressEntity;
import com.bsva.entities.v02.params.CompanyParametersEntity;
import com.bsva.entities.v02.settlement.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * TODO Document
 */
public class CCR001ReportWriter extends FileWriter {

	private final static String REPORT_ID = "001";

	private final static String LINE_SEPARATOR = System.getProperty("line.separator");

	private final Date processDate;

	private final String subServiceID;

	private final Map<Integer, MemberAddressEntity> addresses;

	// summary page writer
	private final CCR001SummaryPageWriter ccr001SummaryPageWriter;

	private final CCR001FinalTotalsPageWriter ccr001FinalTotalsPageWriter;

	// Metadata
	private final static String PROCESS_NAME = "SETTLE";

	private final static String VERSION = "20";

	private final Set<Integer> txnGroupCodes;

	private final CompanyParametersEntity params;

	public final static List<Integer> SPLIT_TXNS;
	static {
		SPLIT_TXNS = Arrays.asList(new Integer[] { 8, 18, 28 });
	}

	public CCR001ReportWriter(Date processDate, String subServiceID, String reportFolder,
			Map<Integer, MemberAddressEntity> addresses) {

		super(subServiceID, reportFolder, REPORT_ID);

		this.processDate = processDate;
		this.subServiceID = subServiceID;
		this.addresses = addresses;

		ccr001SummaryPageWriter = new CCR001SummaryPageWriter(subServiceID, reportFolder);
		ccr001FinalTotalsPageWriter = new CCR001FinalTotalsPageWriter(subServiceID, reportFolder);

		txnGroupCodes = new TxnGroupCodesDAO().txnGroupCodes();
		params = new CompanyParametersDAO().companyParameters();
	}

	
	//CCR001 REPORTS
	public void write() throws SettlementGenerationException {

		// CCR005 is a report for issuers.
		// We sent it to issuers advising them of files acquired on their behalf

		CCR00XIssuersDAO ccr00XIssuersDAO = new CCR00XIssuersDAO();
		CR00XCardTypesDAO cr00XCardTypesDAO = new CR00XCardTypesDAO();
		CCR00XDataDAO ccr00XDataDAO = new CCR00XDataDAO();

		// get issuers
		List<IssuerEntity> issuers = ccr00XIssuersDAO.issuers(subServiceID);
		for (IssuerEntity issuer : issuers) {

			Integer issuerCode = issuer.getId().getIssuerCode();
			Integer pageNumber = 1;
			String filename = null;
			PrintWriter out = null;
			try {

				// create output file
				filename = ccr00xFilename(subServiceID, issuer.getMemberNumber());
				spolog("OPENING FILENAME: " + filename + ", TO " + issuer.getMemberName());
				String filepath = ccr00xFilepath(filename);
				out = new PrintWriter(filepath);

				// control header
				FileHeaderDTO header = defaultFileHeader();
				header.setFileDate(processDate);
				header.setOriginatorID(issuerCode);
				header.setRecordNumber("0132");
				header.setReportName("CCR005");
				header.setAcquirer(issuerCode);
				writeControlHeader(header, out);
				header.incrementRecordCount(1);

				// get acquirer address
				MemberAddressEntity issuerAddress = addresses.get(issuerCode);

				List<AcquirerEntity> acquirers = new CCR00XAcquirersDAO().acquirers(subServiceID, issuerCode);
				for (AcquirerEntity acquirer : acquirers) {

					Integer acquirerCode = acquirer.getId().getAcquirerCode();

					// get acquirer address
					MemberAddressEntity acquirerAddress = addresses.get(acquirerCode);

					spolog("EXTRACTING DATA FROM ISSUER : " + acquirer.getMemberName());

					// get card types for this acquirer / issuer pair
					List<CardTypesEntity> cardTypes = cr00XCardTypesDAO.cardTypes(subServiceID, acquirerCode,
							issuerCode);

					// for each card type
					for (CardTypesEntity entity : cardTypes) {

						Integer cardType = entity.getId().getCardType();
						String cardDescription = entity.getCardDescription();

						// file header
						writeFileHeader(params, header, cardDescription, pageNumber++, out);

						AddressWriter.write1(out, issuerAddress, acquirerAddress);
						header.incrementRecordCount(9);

						// write detail column header
						CCR001DetailWriter.writeColumnHeader(out);
						header.incrementRecordCount(4);

						// get settlement data
						Map<TxnGroup, List<CCR00XDataEntity>> ccr00XData = ccr00XDataDAO.ccr00XData("CARD",
								subServiceID, acquirerCode, issuerCode, cardType);

						// for each txn group code
						for (Integer txnGroupCode : txnGroupCodes) {

							TxnGroup txnGroup = new TxnGroup("CARD", subServiceID, acquirerCode, issuerCode,
									txnGroupCode);

							List<CCR00XDataEntity> txns = ccr00XData.get(txnGroup);

							// write each txn
							if (txns == null) {
								continue;
							}
							// check if is Bilateral Or Sarb Billing
							if (subServiceID.equals("VISA CARD") || subServiceID.equals("MASTERCARD")) {
								// write trxn Sarb
								CCR001DetailWriter.writeTxnSARBVMDetails(out, txns);
								// write txn group totals
								CCR001DetailWriter.writeTxnGroupUnderline(out);
								TxnGroupTotalsDTO txnGroupTotals = txnGroupTotals(txns);
								CCR001DetailWriter.writeTxnSARBVMSubTotals(out, "SUB TOTALS", txnGroupTotals);
							}
							else {
								// writing trxn bilateral
								CCR001DetailWriter.writeTxnDetails(out, txns);
								// write txn group totals
								CCR001DetailWriter.writeTxnGroupUnderline(out);
								TxnGroupTotalsDTO txnGroupTotals =  txnGroupTotals(txns);
								if(subServiceID.equals("FLEET CARD")){
									CCR001DetailWriter.writeTxnSubTotalsFleet(out, "SUB TOTALS", txnGroupTotals);
								}else{
									CCR001DetailWriter.writeTxnSubTotals(out, "SUB TOTALS", txnGroupTotals);
								}
							}

						}
						if (subServiceID.equals("VISA CARD") || subServiceID.equals("MASTERCARD")) {
							// write grand totals for Sarb Billing
							out.println();
							CCR001DetailWriter.writeTxnGroupUnderline(out);
							TxnGroupTotalsDTO grandTotals = grandTotals(ccr00XData.values());
							CCR001DetailWriter.writeTxnGrandSARBVMTotals(out, "GRAND TOTALS", grandTotals);

						}
						else {
							// write grand totals for Bilateral Billing
							out.println();
							CCR001DetailWriter.writeTxnGroupUnderline(out);
							TxnGroupTotalsDTO grandTotals = grandTotals(ccr00XData.values());
							CCR001DetailWriter.writeTxnGrandTotals(out, "GRAND TOTALS", grandTotals);

						}
					}

					// totals for this issuer, acquirer pair
					ccr001SummaryPageWriter.write(out, header, subServiceID, issuerCode, acquirerCode, acquirerAddress,
							issuerAddress, pageNumber++);
				}
				// final totals for this issuer
				// ccr00x data for issuer / acquirer pair
				Map<FinalTotalsTxnGroup, List<CCR00XFinalTotalsDataEntity>> ccr00xData = new CCR00XFinalTotalsDataDAO()
						.ccr00XData("CARD", subServiceID, issuerCode);
				ccr001FinalTotalsPageWriter.write(out, header, subServiceID, issuerCode, issuerAddress, ccr00xData,
						pageNumber++, REPORT_ID);
				// file trailer
				writeControlTrailer(header, out);

			}
			catch (FileNotFoundException e) {
				new SettlementGenerationException(e.getMessage());
			}
			finally {
				spolog("CLOSING FILENAME: " + filename);
				try {
					out.flush();
				}
				catch (Exception e) {
				}
				try {
					out.close();
				}
				catch (Exception e) {
				}
			}
		}
	}


	private TxnGroupTotalsDTO txnGroupTotals(List<CCR00XDataEntity> txns) {
		TxnGroupTotalsDTO totals = new TxnGroupTotalsDTO();
		for (CCR00XDataEntity txn : txns) {
			totals.addVolume(SPLIT_TXNS.contains(txn.getId().getTxnCode()) ? 0 : txn.getVolume());
			// SPLIT_TXNS.contains(txn.getId().getTxnCode()) ?"" : "" + txn.getVolume()), 10, ' ', Justification.RIGHT)
			totals.addTranValue(txn.getTranValue());
			totals.addBillingFee(txn.getBillingFee());
			totals.addBillingFeeAmount(txn.getBillingFeeAmount());
			totals.addBillingVAT(txn.getBillingVAT());
		}

		return totals;
	}

	private TxnGroupTotalsDTO grandTotals(Collection<List<CCR00XDataEntity>> ccr00xData) {

		TxnGroupTotalsDTO totals = new TxnGroupTotalsDTO();
		for (List<CCR00XDataEntity> txns : ccr00xData) {
			for (CCR00XDataEntity txn : txns) {
				totals.addVolume(SPLIT_TXNS.contains(txn.getId().getTxnCode()) ? 0 : txn.getVolume());
				totals.addTranValue(txn.getTranValue());
				totals.addBillingFee(txn.getBillingFee());
				totals.addBillingFeeAmount(txn.getBillingFeeAmount());
				totals.addBillingVAT(txn.getBillingVAT());
			}
		}

		return totals;
	}

	public void spolog(String message) {
		System.out.println(PROCESS_NAME + " " + VERSION + " " + message);
		// Utils.logSpolog(PROCESS_NAME + " " + VERSION + " " + message);
		// spoLog.log(PROCESS_NAME, VERSION, message);
	}

	private static Double abs(Double value) {
		return Math.abs(value);
	}

}

package com.bsva.settlementv02;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bsva.commonsv02.util.SPOLogger;
import com.bsva.commonsv02.util.SettlementGenerationException;
import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dao.v02.billing.BillingSummaryDAO;
import com.bsva.dao.v02.members.MemberAddressDAO;
import com.bsva.dao.v02.settlement.CsoSettlementMatrixDAO;
import com.bsva.dao.v02.settlement.CsvSettlementViewDAO;
import com.bsva.dao.v02.settlement.EndOfDaySettlementDAO;
import com.bsva.dcms.commons.dao.CSFMembersDAO;
import com.bsva.dcms.commons.dao.CsfCompanyParametersDAO;
import com.bsva.dcms.commons.dao.CsfDeliveryServicesDAO;
import com.bsva.dcms.commons.dao.CsoSystemParametersDAO;
import com.bsva.dcms.commons.dao.DelDeliveryFilesCCCDAO;
import com.bsva.dcms.commons.dto.CSFMembersDTO;
import com.bsva.dcms.commons.dto.CsfCompanyParametersDTO;
import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
import com.bsva.dcms.commons.dto.CsoSystemParametersDTO;
import com.bsva.dcms.commons.dto.DelDeliveryFilesCCCDTO;
import com.bsva.dcms.commons.dto.views.CsvSettlementViewDto;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.util.DateUtil;
import com.bsva.dcms.commons.util.Utils;
import com.bsva.dmcs.controller.AbstractProcess;
import com.bsva.dmcs.reportv02.settlement.CCR001ReportWriter;
import com.bsva.dmcs.reportv02.settlement.CCR002reports;
import com.bsva.dmcs.reportv02.settlement.CCR005ReportWriter;
import com.bsva.dmcs.reportv02.settlement.CCR009Reports;
import com.bsva.dmcs.reportv02.settlement.CCR016Reports;
import com.bsva.dmcs.reportv02.settlement.CCR017Reports;
import com.bsva.dmcs.reportv02.settlement.CCR020Reports;
import com.bsva.dmcs.reportv02.settlement.CCR021Reports;
import com.bsva.dmcs.reportv02.settlement.CCR03030VisaReports;
import com.bsva.dmcs.reportv02.settlement.CCR03031VisaReports;
import com.bsva.dmcs.reportv02.settlement.CCR030McardReports;
import com.bsva.dmcs.reportv02.settlement.CCR031McardReports;
import com.bsva.dmcs.reportv02.settlement.CCR14Reports;
import com.bsva.dmcs.reportv02.settlement.CCR15Reports;
import com.bsva.dmcs.reportv02.settlement.CCR420Reports;
import com.bsva.dmcs.reportv02.settlement.CSRLKUPReports;
import com.bsva.dmcs.reportv02.settlement.CSRMISCSVReport;
import com.bsva.dmcs.reportv02.settlement.CSRMISReport;
import com.bsva.dmcs.reportv02.settlement.CSRRATEReport;
import com.bsva.dmcs.reportv02.settlement.CVS_CSV_Reports;
import com.bsva.dmcs.reportv02.settlement.MonthEndReports;
import com.bsva.dmcs.settlement.load.SettlementValidatorException;
import com.bsva.dmcs.settlement.load.SettlementValidatorFactory;
import com.bsva.dmcs.settlement.load.Validator;
import com.bsva.entities.v02.members.MemberAddressEntity;
import com.bsva.entities.v02.settlement.CCR00XFinalTotalsDataSettleEntity;
import com.bsva.entities.v02.settlement.CsoSettlementMatrixEntity;
import com.bsva.entities.v02.settlement.CsoSettlementMatrixEntity_PK;
import com.bsva.entities.v02.settlement.CsvSettlementView;
import com.bsva.settlementv02.dto.ControlRecordDTO;
import com.bsva.settlementv02.dto.DetailRecordDTO;
import com.bsva.settlementv02.dto.TrailerRecordDTO;
import com.bsva.settlementv02.dto.SettlementLoader;
import com.bsva.settlementv02.dto.HeaderRecordDTO;

/**
 * @author AugustineA
 * @param <CSVReaderAcquirerIssuer>
 *
 */
public class SettlementLoaderProcess<CSVReaderAcquirerIssuer> extends AbstractProcess {

	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");

	// Metadata
	private final static String PROCESS_NAME = "SETTLE";

	private final static String VERSION = "20";

	private static final String SETTLEMENT_PROCESS_NAME = "SETTLE";

	private static final String EOD_PROCESS_NAME = "EOD";

	private static final String SERVICE = "CARD";

	private static final String SUB_SERVICE_NAME = "ALL";

	private static final String CARDSERVICEVISA = "VISA CARD";

	private static final String CARDSERVICEAMEX = "AMEX";

	private static final String CARDSERVICEDINNERS = "DINERS";

	private static final String CARDSERVICEMASTERCARD = "MASTERCARD";

	private static final String CARDSERVICEFLEET = "FLEET CARD";

	private List<CsvSettlementViewDto> listVISA = new ArrayList<>();

	private List<CsvSettlementViewDto> listMCI = new ArrayList<>();

	private List<CsvSettlementViewDto> listAMEX = new ArrayList<>();

	private List<CsvSettlementViewDto> listDINNERS = new ArrayList<>();

	private List<CsvSettlementViewDto> listFLEET = new ArrayList<>();

	private static String logPGM = "SETTLE";

	private final static SPOLogger SPO_LOGGER;

	private final static String REPORT_FOLDER;

	private final static String SEND_FOLDER;

	private boolean vmReport = true;

	private static DecimalFormat decimalf = new DecimalFormat(".##");

	static {

		Map<String, String> paths = new DirectoryDAO().directories();
		SPO_LOGGER = new SPOLogger(paths.get("SPOLOG"));
		REPORT_FOLDER = paths.get("REPORTS");
		SEND_FOLDER = paths.get("SEND");
	}

	@Override
	public void process() {
		// These calls will be made manually from the WEB.
		// and needs to run all the sub services and the settlement files.
		settle("VISA CARD");
		settle("MASTERCARD");
		settle("AMEX");
		settle("FLEET CARD");
		settle("DINERS");

	}

	//Used to write csv reports to the database table for interchange reports
	private static void writeFileToDB() {
		File source = new File(REPORT_FOLDER);
		File[] Files = source.listFiles();
		if (Files != null && Files.length > 0) {
			for (File file : Files) {
				String filePath = file.getPath();
				String fileName = file.getName();
				/*if ((fileName.startsWith("CCR030V") || fileName.startsWith("CCR031V"))) {
					com.bsva.dmcs.ccreports02.CSVReaderAcquirerIssuerVisa.writeCSVData(filePath);
				}*/
				//if ((fileName.startsWith("CCR030M") || fileName.startsWith("CCR031M"))) {
					//com.bsva.dmcs.ccreports02.CSVReaderAcquirerIssuerMcard.writeCSVData(filePath);
				//}
			}
		}
	}

	public void settle(String subServiceID) {
		/*
		 * try { CSFSubServicesDTO subService = new CSFSubServicesDTO(); subService.setActiveIndicator("Y");
		 * subService.setSubservice(subServiceID); CSFSubServicesDTO subServiceList = new
		 * CSFSubServicesDAO().retrieve(subService); if(subServiceList != null){
		 * if(!subServiceList.getSubservice().contains("VAL") || !subServiceList.getSubservice().contains("REP")) {
		 * execute(subServiceList); } } } catch (DAOException | ParseException e) { //TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		// get process date
		Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();

		spolog("PROCESSING " + subServiceID + " FOR PROCESS DATE : " + DATE_FORMAT.format(processDate) + ".");

		// try {

		// Create CCR001 Report
		Map<Integer, MemberAddressEntity> addresses = new MemberAddressDAO().memberAddresses(subServiceID);

		try {
			//The commented out portion was Used to plugin some test reports
			//new CCR018019Reports().writeCsvFile018(subServiceID);
			// writeFileToDB();
			/*System.out.println(".... ABOUT WRITING THE CCR030 And CCR031 CCR03031VisaReports REPORTS FOR : " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... ABOUT WRITING THE CCR030 And CCR031 CCR03031VisaReports REPORTS FOR : " + subServiceID);
			new CCR03031VisaReports().writeCsvFile31(subServiceID);
			System.out.println(".... FINISHED WRITING THE CCR030 And CCR031 CCR03031VisaReports REPORTS FOR : " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... FINISHED WRITING THE CCR030 And CCR031  CCR03031VisaReportsREPORTS FOR : " + subServiceID);
			
			System.out.println(".... ABOUT WRITING THE CCR030 And CCR031 CCR03030VisaReports REPORTS FOR : " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... ABOUT WRITING THE CCR030 And CCR031 CCR03030VisaReports REPORTS FOR : " + subServiceID);
			new CCR03030VisaReports().writeCsvFile30(subServiceID);
			System.out.println(".... FINISHED WRITING THE CCR030 And CCR031 CCR03030VisaReports REPORTS FOR : " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... FINISHED WRITING THE CCR030 And CCR03 CCR03030VisaReports1 REPORTS FOR : " + subServiceID);*/
			
			/*System.out.println(".... ABOUT WRITING THE CCR030 And CCR031 CCR030McardReports REPORTS FOR : " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... ABOUT WRITING THE CCR030 And CCR031 CCR030McardReports REPORTS FOR : " + subServiceID);
			new CCR030McardReports().writeCsvFile30(subServiceID);
			System.out.println(".... FINISHED WRITING THE CCR030 And CCR031 CCR030McardReports REPORTS FOR : " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... FINISHED WRITING THE CCR030 And CCR031 CCR030McardReports REPORTS FOR : " + subServiceID);
			
			System.out.println(".... ABOUT WRITING THE CCR030 And CCR031 CCR031McardReports REPORTS FOR : " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... ABOUT WRITING THE CCR030 And CCR031 CCR031McardReports REPORTS FOR : " + subServiceID);
			new CCR031McardReports().writeCsvFile31(subServiceID);
			System.out.println(".... FINISHED WRITING THE CCR030 And CCR031 CCR031McardReports REPORTS FOR : " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... FINISHED WRITING THE CCR030 And CCR031 CCR031McardReports REPORTS FOR : " + subServiceID);
			*/

			System.out.println(".... ABOUT WRITING THE CCR001 REPORTS " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... ABOUT WRITING THE CCR001 REPORTS " + subServiceID);
			new CCR001ReportWriter(processDate, subServiceID, REPORT_FOLDER, addresses).write();
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... COMPLETED WRITING CCR001 REPORTS " + subServiceID);
			System.out.println(".... FINISHED WRITING THE CCR001 REPORTS " + subServiceID);

			// Create CCR005
			System.out.println(".... ABOUT WRITING THE CCR005 REPORTS " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... ABOUT WRITING THE CCR005 REPORTS " + subServiceID);
			new CCR005ReportWriter(processDate, subServiceID, REPORT_FOLDER, addresses).write();
			SPO_LOGGER.log(PROCESS_NAME, VERSION,
					".... COMPLETED WRITING THE CCR005 REPORTS FOR SUBSERVICE :" + subServiceID);
			System.out.println(".... FINISHED WRITING THE CCR005 REPORTS " + subServiceID);
			if("FLEET CARD".equals(subServiceID)){
				System.out.println(".... ABOUT WRITING THE CCR009 REPORTS " + subServiceID);
				SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... ABOUT WRITING THE CCR009 REPORTS " + subServiceID);
				new CCR009Reports().writeReports(subServiceID);
				SPO_LOGGER.log(PROCESS_NAME, VERSION,".... COMPLETED WRITING THE CCR009 REPORTS FOR SUBSERVICE :" + subServiceID);
				System.out.println(".... FINISHED WRITING THE CCR009 REPORTS " + subServiceID);
			}

			System.out.println(".... ABOUT WRITING THE CCR002 REPORTS " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... ABOUT WRITING THE CCR002 REPORTS " + subServiceID);
			new CCR002reports().write(subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION,
					".... COMPLETED WRITING THE CCR002 REPORTS FOR SUBSERVICE :" + subServiceID);
			System.out.println(".... FINISHED WRITING THE CCR002 REPORTS " + subServiceID);

			System.out.println(".... ABOUT WRITING THE CCR014 REPORTS " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... ABOUT WRITING THE CCR014 REPORTS " + subServiceID);
			new CCR14Reports().writeCsvFile(subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION,
					".... COMPLETED WRITING THE CCR14 REPORTS FOR SUBSERVICE :" + subServiceID);
			System.out.println(".... FINISHED WRITING THE CCR014 REPORTS " + subServiceID);

			System.out.println(".... ABOUT WRITING THE CCR015 REPORTS " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... ABOUT WRITING THE CCR015 REPORTS " + subServiceID);
			new CCR15Reports().writeCsvFile(subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION,
					".... COMPLETED WRITING THE CCR15 REPORTS FOR SUBSERVICE :" + subServiceID);
			System.out.println(".... FINISHED WRITING THE CCR015 REPORTS " + subServiceID);

			System.out.println(".... ABOUT WRITING CCR016 REPORTS " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... ABOUT WRITING CCR016 REPORTS " + subServiceID);
			new CCR016Reports().writeCsvFile(subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION,
					".... COMPLETED WRITING THE CCR16 REPORTS FOR SUBSERVICE :" + subServiceID);
			System.out.println(".... FINISHED WRITING CCR016 REPORTS " + subServiceID);

			System.out.println(".... ABOUT WRITING THE CCR017 REPORTS " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... ABOUT WRITING THE CCR017 REPORTS " + subServiceID);
			new CCR017Reports().writeCsvFile(subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION,
					".... COMPLETED WRITING THE CCR017 REPORTS FOR SUBSERVICE :" + subServiceID);
			System.out.println(".... FINISHED WRITING THE CCR017 REPORTS " + subServiceID);

			SPO_LOGGER.log(PROCESS_NAME, VERSION,
					".... ABOUT WRITING THE SETTLEMENT  REPORTS FILE FOR : " + subServiceID);
			System.out.println(".... ABOUT WRITING THE SETTLEMENT REPORT " + subServiceID);
			
			execute("CARD", subServiceID);
			
			SPO_LOGGER.log(PROCESS_NAME, VERSION,
					".... COMPLETED WRITING SETTLEMENT REPORT FOR SUBSERVICE :" + subServiceID);
			System.out.println(".... FINISHED WRITING THE SETTLEMENT REPORT " + subServiceID);

			SPO_LOGGER.log(PROCESS_NAME, VERSION,
					"DELETEING TODAYS DATA AND DATA THAT IS MORE THAN 90 DAYS IN CSO_BILLING SUMMARY : "
							+ subServiceID);
			System.out.println(".... DELETEING TODAYS DATA AND DATA THAT IS MORE THAN 90 DAYS IN CSO_BILLING SUMMARY : "
					+ subServiceID);
			// used for testing
			// getData();

			SPO_LOGGER.log(PROCESS_NAME, VERSION,
					" WRITING TODAY'S DATA TO CSO_BILLING_SUMMARY FOR MONTH END REPORTS : " + subServiceID);
			System.out.println(
					".... WRITING TODAY'S DATA TO CSO_BILLING_SUMMARY FOR MONTH END REPORTS : " + subServiceID);
			CSRMISReport.writeCSRMISReport(subServiceID);
			CSRMISCSVReport.writeCSRMISCSVReport(subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION,
					".... COMPLETED WRITING THE CSRMIS REPORTS FOR SUBSERVICE :" + subServiceID);
			System.out.println(
					"....FINISHED WRITING TODAY'S DATA TO CSO_BILLING_SUMMARY FOR MONTH END REPORTS : " + subServiceID);

			System.out.println(".... ABOUT WRITING THE CCR020 REPORTS " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... ABOUT WRITING THE CCR020 REPORTS" + subServiceID);
			new CCR020Reports().writeCsvFile(subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION,
					".... COMPLETED WRITING THE CCR020 REPORTS FOR SUBSERVICE :" + subServiceID);
			System.out.println(".... FINISHED WRITING THE CCR020 REPORTS " + subServiceID);

			System.out.println(".... ABOUT WRITING THE CCR021 REPORT " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... ABOUT WRITING THE CCR021 REPORTS " + subServiceID);
			new CCR021Reports().writeCsvFile(subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION,
					".... COMPLETED WRITING THE CCR021 REPORTS FOR SUBSERVICE :" + subServiceID);
			System.out.println(".... FINISHED WRITING THE CCR021 REPORT " + subServiceID);

/*			System.out.println(".... ABOUT WRITING THE CCR420 REPORT " + subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... ABOUT WRITING THE CCR420 REPORTS FOR : " + subServiceID);
			new CCR420Reports().getData(subServiceID);
			SPO_LOGGER.log(PROCESS_NAME, VERSION,
					".... COMPLETED WRITING THE CCR420 REPORTS FOR SUBSERVICE :" + subServiceID);
			System.out.println(".... FINISHED WRITING THE CCR420 REPORT " + subServiceID);*/

			if ("MASTERCARD".equals(subServiceID)) {

				System.out.println(".... ABOUT WRITING THE CCR030 And CCR031 REPORTS FOR :" + subServiceID);
				SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... ABOUT WRITING THE CCR030 And CCR031 REPORTS FOR :" + subServiceID);
				//new CCR030McardReports().writeCsvFile(subServiceID);
				//new CCR031McardReports().writeCsvFile(subServiceID);
				new CCR030McardReports().writeCsvFile30(subServiceID);
				new CCR031McardReports().writeCsvFile31(subServiceID);
				SPO_LOGGER.log(PROCESS_NAME, VERSION,
						".... COMPLETED WRITING THE CCR030 And CCR031 REPORTS FOR SUBSERVICE :" + subServiceID);
				System.out.println(".... DONE WRITING THE CCR030 And CCR031 REPORTS FOR :" + subServiceID);
			}
			if ("VISA CARD".equals(subServiceID)) {
				System.out.println(".... ABOUT WRITING THE CCR030 And CCR031 REPORTS FOR : " + subServiceID);
				SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... ABOUT WRITING THE CCR030 And CCR031 REPORTS FOR : " + subServiceID);
				new CCR03031VisaReports().writeCsvFile31(subServiceID);
				new CCR03030VisaReports().writeCsvFile30(subServiceID);
				System.out.println(".... DONE WRITING THE CCR030 And CCR031 REPORTS FOR : " + subServiceID);
				SPO_LOGGER.log(PROCESS_NAME, VERSION,
						".... COMPLETED WRITING THE CCR030 And CCR031 REPORTS FOR SUBSERVICE :" + subServiceID);
				SPO_LOGGER.log(PROCESS_NAME, VERSION, ".... DONE WRITING THE CCR030 And CCR031 REPORTS FOR : " + subServiceID);
				SPO_LOGGER.log(PROCESS_NAME, VERSION,
						".... FINISHED WRITING ALL REPORTS   ============== ALL REPORTS COMPLETED ===============: "
								+ subServiceID);
			}
			// this was added not to run it twice for either visa or mastercard
			// Remember both sub service has to be loaded first before closing them.
			if (vmReport) {
				// generate Lookup Report
				// close so that it will not be run twice.
				System.out.println("..... ABOUT WRITING CSRLKUP REPORTS ......");
				SPO_LOGGER.log(PROCESS_NAME, VERSION, "..... ABOUT WRITING CSRLKUP REPORTS ......");
				CSRLKUPReports.writeReportFile();
				System.out.println("..... DONE WRITING CSRLKUP REPORTS ......");
				SPO_LOGGER.log(PROCESS_NAME, VERSION, ".....DONE WRITING CSRLKUP REPORTS ......");
				// generate CsrRate Report
				System.out.println("...... ABOUT WRITING CSRRATE REPORTS ......");
				SPO_LOGGER.log(PROCESS_NAME, VERSION, "...... ABOUT WRITING CSRRATE REPORTS ......");
				CSRRATEReport.writeReportFile();
				System.out.println("...... DONE WRITING CSRRATE REPORTS .......");
				SPO_LOGGER.log(PROCESS_NAME, VERSION, "...... DONE WRITING CSRRATE REPORTS .......");
				vmReport = false;
			}

			CVS_CSV_Reports csvCsrReports = new CVS_CSV_Reports();
			csvCsrReports.writeCVSCSVReport(subServiceID);
			MonthEndReports modReports = new MonthEndReports();
			modReports.writeReports();
			System.out.println(
					".... FINISHED WRITING ALL REPORTS   ============== ALL REPORTS COMPLETED ===============: "
							+ subServiceID);

		}
		catch (SettlementGenerationException | DAOException | ParseException  | IOException e) {// ParseException
			e.printStackTrace();
			Runtime.getRuntime().exit(0);
		}

	}

	/**
	 * @param subService
	 * @throws DAOException
	 * @throws ParseException Creates Settlement per subService
	 */
	// Method for doing settlements for all  sub services. 
	//As of this stage , do not touch the below as it works perfectly in settlement system.
	public void execute(String service, String subService) throws DAOException, ParseException {
		SPO_LOGGER.log(PROCESS_NAME, VERSION, " .... ABOUT WRITING SETTLEMENT FILE FOR  : " + subService);
		//List<CsvSettlementView> csvSettlementViewList = new CsvSettlementViewDAO().getCsvSettlementViewReports(service,
			//	subService);
		// get processing date
		CsoSystemParametersDTO csoSystemParametersDTO = new CsoSystemParametersDTO();
		csoSystemParametersDTO.setProcessActiveInd("Y");
		CsoSystemParametersDTO csoSystemParameter = new CsoSystemParametersDAO().retrieve(csoSystemParametersDTO);

		// get company details
		CsfCompanyParametersDTO csfCompanyParametersDTO = new CsfCompanyParametersDAO().retrieve(null);

		// get file name prefix
		CsfDeliveryServicesDTO param = new CsfDeliveryServicesDTO();

		param.setSubService(subService);
		param.setInwardOutwardInd("O");
		CsfDeliveryServicesDTO delService = new CsfDeliveryServicesDAO().retrieve(param);

		String fileNamePrefix = null;
		// file naming info was got from Manoj
		// if you want to change it , plaese consult Manoj for any queries
		if (subService.equals("MASTERCARD")) {
			fileNamePrefix = "SM";
		}
		else if (subService.equals("VISA CARD")) {
			fileNamePrefix = "SW";
		}
		else if (subService.equals("FLEET CARD")) {
			fileNamePrefix = "SF";
		}
		else if (subService.equals("DINERS")) {
			fileNamePrefix = "SE";
		}
		else if (subService.equals("AMEX")) {
			fileNamePrefix = "SB";
		}
		String dateToString = DateUtil.formatDate(csoSystemParameter.getProcessDate(), "yyyyMMdd");
		// String fileSeqNumber = "001";
		// String currency = "."+ csfCompanyParametersDTO.getCurrencyCode();

		String filename = fileNamePrefix + dateToString.substring(2, 8);

			HeaderRecordDTO header = new HeaderRecordDTO();

			header.setHeaderDetailInd("D");
			header.setHeaderService(service);

			if (subService.equals("MASTERCARD")) {
				header.setHeaderSubService("MCARD");
			}
			else if (subService.equals("AMEX")) {
				header.setHeaderSubService("AMEX");
			}
			else {
				header.setHeaderSubService(subService.substring(0, 5));
			}

			header.setHeaderCentre("JHB");
			header.setHeaderCurrency(csfCompanyParametersDTO.getCurrencyCode());
			header.setHeaderInputDate(dateToString);
			header.setHeaderInputDate(dateToString);
			header.setHeaderLiveInd(csoSystemParameter.getLiveTestCode());
			header.setHeaderMemberCntl("0001");
			String dateString = DateUtil.formatDate(csoSystemParameter.getProcessDate(), "yyyyMMdd");
			header.setHeaderSettlementDate(dateString);
			String headerDescription = "DMCS SETTLEMENT FOR " + subService + "SUBSERVICE";
			header.setHeaderDescription(headerDescription);
			String headerCurrDescription = "REPUBLIC OF SOUTH AFRICA - RANDS";
			header.setHeaderCurrDesc(headerCurrDescription);
			header.setHeaderAgreementNo("45");
			header.setHeaderEndOfService("N");
			header.setHeaderFiller("");

			List<DetailRecordDTO> details = new ArrayList<DetailRecordDTO>();
			String[] acquirerCode = {"1","2","3","9","10","16","33","39","50"};
			for (String acqCode : acquirerCode) {
				List<CCR00XFinalTotalsDataSettleEntity> settlementList = new EndOfDaySettlementDAO().ccr00XDataForAcquirerIssuer(subService,acqCode);
				for (CCR00XFinalTotalsDataSettleEntity retrievedViewList : settlementList) {
				String creditDebit = sign(retrievedViewList.getTranValue());
				
	        	double billFee = abs(retrievedViewList.getBillingFee());
	        	double billFeeAmount = abs(retrievedViewList.getBillingFeeAmount().doubleValue());
	        	double billVat = abs(retrievedViewList.getBillingVAT());
	        	double totalCharges = 0.00;
	        	double nett = 0.00;
	        	double nettAmount = 0.00;
	        	if("FLEET CARD".equals(retrievedViewList.getId().getSubService())){
					totalCharges = ((billFee) + billVat);
				}else{
					totalCharges = ((billFeeAmount + billFee) + billVat);
				}

				System.out.println("getTranValue : " + retrievedViewList.getTranValue().doubleValue());

	        	nettAmount = retrievedViewList.getTranValue().doubleValue() / 100.00;
				System.out.println("nettAmount : " + nettAmount);
				System.out.println("getBillingFeeAmount : " + retrievedViewList.getBillingFeeAmount().doubleValue());
				System.out.println("getBillingFee : " + retrievedViewList.getBillingFee());

				double n = nettAmount
								+ retrievedViewList.getBillingFeeAmount().doubleValue()
								+ retrievedViewList.getBillingVAT().doubleValue();
				System.out.println("n : " + n);

				Long longVal = (long)(n * 100.00);
				System.out.println("longVal : " + longVal);

				DecimalFormat decf = new DecimalFormat("#.##");
	            String strValue = String.valueOf(decf.format(nett)).replace(".", "");
	            BigDecimal bigNett = new BigDecimal(strValue);
	            // Long longVal = bigNett.longValue();
	             
				if ( longVal > 0){
					
					DetailRecordDTO detail = new DetailRecordDTO();

					detail.setSettleDetailInd("S");
					detail.setSettleDetailService("CARD");
					if (retrievedViewList.getId().getSubService().equals("MASTERCARD")) {
						detail.setSettleDetailSubService("MCARD");
					} else if (retrievedViewList.getId().getSubService().equals("AMEX")) {
						detail.setSettleDetailSubService("AMEX");
					} else {
						detail.setSettleDetailSubService(retrievedViewList.getId().getSubService().substring(0, 5));
					}
					detail.setSettleDetailCentre("JHB");
					detail.setSettleDetailCurrency("ZAR");
					detail.setSettleDetailAltCurrency("ZAR");
					detail.setSettleDetailRange(header.getHeaderMemberCntl());
					detail.setSettleDetailActionDate(dateToString);
					detail.setSettleDetailMemberIn(getMemberNo(Integer.valueOf(retrievedViewList.getAcquirerCode())));
					detail.setSettleDetailMemberOut(getMemberNo(retrievedViewList.getId().getIssuerCode()));
					detail.setSettleDetailVolume(String.valueOf(retrievedViewList.getVolume()));
					detail.setSettleDetailValue(String.valueOf(longVal).replace("-", ""));
					detail.setSettleDetailSign("DB");
					detail.setSettleDetailMemberCntl(header.getHeaderMemberCntl());
					detail.setSettleDetailFiller("");

					details.add(detail);
				} else {
					DetailRecordDTO detail = new DetailRecordDTO();

					detail.setSettleDetailInd("S");
					detail.setSettleDetailService("CARD");
					if (retrievedViewList.getId().getSubService().equals("MASTERCARD")) {
						detail.setSettleDetailSubService("MCARD");
					}
					else if (retrievedViewList.getId().getSubService().equals("AMEX")) {
						detail.setSettleDetailSubService("AMEX");
					}
					else {
						detail.setSettleDetailSubService(retrievedViewList.getId().getSubService().substring(0, 5));
					}
					detail.setSettleDetailCentre("JHB");
					detail.setSettleDetailCurrency("ZAR");
					detail.setSettleDetailAltCurrency("ZAR");
					detail.setSettleDetailRange(header.getHeaderMemberCntl());
					detail.setSettleDetailActionDate(dateToString);
					detail.setSettleDetailMemberIn(getMemberNo(retrievedViewList.getId().getIssuerCode()));
					detail.setSettleDetailMemberOut(getMemberNo(Integer.valueOf(retrievedViewList.getAcquirerCode())));
					detail.setSettleDetailVolume(String.valueOf(retrievedViewList.getVolume()));
					detail.setSettleDetailValue(String.valueOf(longVal).replace("-", ""));
					detail.setSettleDetailSign("DB");
					detail.setSettleDetailMemberCntl(header.getHeaderMemberCntl());
					detail.setSettleDetailFiller("");

					details.add(detail);					
				}
			  }
			}

			ControlRecordDTO controller = new ControlRecordDTO();

			controller.setControlInd("C");
			controller.setControlService(service);
			if (subService.equals("MASTERCARD")) {
				controller.setControlSubservice("MCARD");
			}
			else if (subService.equals("AMEX")) {
				controller.setControlSubservice("AMEX");
			}
			else {
				controller.setControlSubservice(subService.substring(0,5));
			}
			controller.setControlCurrency(csfCompanyParametersDTO.getCurrencyCode());
			controller.setControlMemberCntl(header.getHeaderMemberCntl());
			controller.setControlTime(Long.valueOf(leftPadZeros(DateUtil.formatDate(new Date(), "HHmmssS").substring(0, 8),8)));
			controller.setControlStatus("I");
			controller.setControlNoOfRecords(leftPadZeros(String.valueOf(details.size()),8));
			controller.setControlFiller("");

			TrailerRecordDTO trailer = new TrailerRecordDTO();

			trailer.setTrailerInd("T");
			trailer.setTrailerService(service);
			if (subService.equals("MASTERCARD")) {
				trailer.setTrailerSubService("MCARD");
			}
			else if (subService.equals("AMEX")) {
				trailer.setTrailerSubService("AMEX");
			}
			else {
				trailer.setTrailerSubService(subService.substring(0,5));
			}
			trailer.setTrailerCurrency(csfCompanyParametersDTO.getCurrencyCode());
			trailer.setTrailerMemberCntl(Integer.valueOf("9999"));
			trailer.setTrailerTime(Long.valueOf(leftPadZeros(DateUtil.formatDate(new Date(), "HHmmssS").substring(0, 8),8)));
			trailer.setTrailerStatus("I");
			trailer.setTrailerNoOfRecords(leftPadZeros(String.valueOf(details.size()+ 3),8));
			trailer.setTrailerFiller("");

			if (details.size() > 0) {

				Validator validator = SettlementValidatorFactory.getValidator();

				try {
					if (validator.validate(header, details, controller, trailer)) {
						String dir = BsvTableLookup.getInstance().getSendDir();
						SettlementLoader loader = new SettlementLoader(header, details, controller, trailer, filename,
								dir);

						loader.execute();
						insertIntoCsoSettlementMatrix(details);

						spolog("DONE PROCESSING  SETTLEMENT FILE FOR : " + controller.getControlSubservice());
						Utils.logSpolog("DONE PROCESSING  SETTLEMENT FILE FOR : " + controller.getControlSubservice(),
								PROCESS_NAME);
						SPO_LOGGER.log(PROCESS_NAME, VERSION,
								" .... FINISHED WRITING SETTLEMENT FILE FOR  : " + subService);
					}

				}
				catch (SettlementValidatorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
	}

	private void insertIntoCsoSettlementMatrix(List<DetailRecordDTO> details) {
		for (DetailRecordDTO detailRecordDTO : details) {
			CsoSettlementMatrixEntity csoSettlementMatrix = new CsoSettlementMatrixEntity();
			CsoSettlementMatrixEntity_PK csoSettlementMatrixPK = new CsoSettlementMatrixEntity_PK();
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
				String year = detailRecordDTO.getSettleDetailActionDate().substring(0, 4);
				String month = detailRecordDTO.getSettleDetailActionDate().substring(4, 6);
				String day = detailRecordDTO.getSettleDetailActionDate().substring(6, 8);

				String fullDate = year + "/" + month + "/" + day;

				Date dt = formatter.parse(fullDate);
				csoSettlementMatrixPK.setActionDate(dt);
			
			csoSettlementMatrixPK.setHomingBank(detailRecordDTO.getSettleDetailMemberIn().substring(2, 6));
			csoSettlementMatrixPK.setOriginatingBank(detailRecordDTO.getSettleDetailMemberOut().substring(2, 6));
			csoSettlementMatrixPK.setService(detailRecordDTO.getSettleDetailService());
			csoSettlementMatrixPK.setSettlementInd(detailRecordDTO.getSettleDetailInd());
			csoSettlementMatrixPK.setSubService(detailRecordDTO.getSettleDetailSubService());
			csoSettlementMatrix.setCsoSettlementMatrixEntity_PK(csoSettlementMatrixPK);
			csoSettlementMatrix.setBankOutputCreatedInd(detailRecordDTO.getSettleDetailInd());
			
			csoSettlementMatrix.setCrValue(detailRecordDTO.getSettleDetailValue().replace(".", ""));
			csoSettlementMatrix.setCrVolume(detailRecordDTO.getSettleDetailVolume());
			csoSettlementMatrix.setCurrencyCode(detailRecordDTO.getSettleDetailCurrency());
			
			csoSettlementMatrix.setDrValue(detailRecordDTO.getSettleDetailValue().replace(".", ""));
			csoSettlementMatrix.setDrVolume(detailRecordDTO.getSettleDetailVolume());
			csoSettlementMatrix.setPaymentStream(detailRecordDTO.getSettleDetailInd());
			csoSettlementMatrix.setStatusCode(detailRecordDTO.getSettleDetailInd());
			}
			catch (ParseException e) {
				e.printStackTrace();
			}

			new CsoSettlementMatrixDAO().insertDate(csoSettlementMatrix);
		}

	}

	public void spolog(String message) {

		// spoLog.log(PROCESS_NAME, VERSION, message);
		System.out.println(PROCESS_NAME + " " + VERSION + " " + message);
	}

	public final static void main(String[] args) throws DAOException, ParseException {
		/*
		 * try { new CCR420Reports().getData("AMEX"); } catch (FileNotFoundException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */
		// new SettlementLoaderProcess();
		// try {
		// new SettlementLoaderProcess().execute("CARD", "MASTERCARD");
		// new CCR009Reports().writeReports("MASTERCARD");

		/*
		 * try { new CCR420Reports().getData("MASTERCARD");
		 * 
		 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		// SettlementLoaderProcess.getData();
		// new CCR030Reports().writeCsvFile("MASTERCARD");
		// new SettlementLoaderProcess().settle("MASTERCARD");

	}

	@Override
	public void init() {

	}

	/**
	 * @param bankCode
	 * @return full member Number
	 */
	private String getMemberNo(int bankCode) {

		CSFMembersDTO parmObject = new CSFMembersDTO();
		parmObject.setBankCode(bankCode);

		CSFMembersDTO returnedObject = null;

		try {
			returnedObject = new CSFMembersDAO().retrieve(parmObject);

		}
		catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (returnedObject != null) {

			return returnedObject.getMemberNo();

		}
		return null;
	}

	private void loadDeliveryFiles(String fileName) {

		int maxPosition = 0;

		CsoSystemParametersDTO parmObject = new CsoSystemParametersDTO();
		parmObject.setProcessActiveInd("Y");

		try {
			CsoSystemParametersDTO csoSystemParametersDTO = new CsoSystemParametersDAO().retrieve(parmObject);

			List<DelDeliveryFilesCCCDTO> deliveryList = new DelDeliveryFilesCCCDAO().retrieveRelated(null);

			List<Integer> arrayList = new ArrayList<Integer>();

			if (deliveryList != null) {

				for (DelDeliveryFilesCCCDTO file : deliveryList) {

					arrayList.add(file.getPosition());
				}

				maxPosition = (int) Collections.max(arrayList) + 1;

			}
			else {

				maxPosition = maxPosition++;
			}

			DelDeliveryFilesCCCDTO delDeliveryFile = new DelDeliveryFilesCCCDTO();

			delDeliveryFile.setPosition(maxPosition);
			delDeliveryFile.setPrddate(
					Integer.valueOf(DateUtil.formatDate(csoSystemParametersDTO.getProcessDate(), "YYYYMMDD")));
			delDeliveryFile.setFileName(fileName);
			delDeliveryFile.setDeliveryStatus("Y");
			delDeliveryFile.setQueueFileName("");
			delDeliveryFile.setDeliveryTime(Integer.valueOf(leftPadZeros(DateUtil.formatDate(new Date(), "HHmmssS").substring(0, 8),8)));

			// check if file is already logged in delDelivery before inserting
			DelDeliveryFilesCCCDTO paramObj = new DelDeliveryFilesCCCDTO();
			paramObj.setFileName(fileName);

			DelDeliveryFilesCCCDTO fileNameCheck = new DelDeliveryFilesCCCDAO().retrieve(paramObj);

			if (fileNameCheck == null) {
				new DelDeliveryFilesCCCDAO().create(delDeliveryFile);
			}

		}
		catch (DAOException | NumberFormatException | ParseException e) {
			e.printStackTrace();
		}
	}

	public void getData() {

		Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();
		String date = processDate.toString().substring(0, 10);
		int result = new BillingSummaryDAO().updateData(date);
		new BillingSummaryDAO().getData();

		System.out.println("" + result);

	}
	
	/**
	 * @param str
	 * @param num
	 * @return
	 */
	public static String leftPadZeros(String str, int num) {
		return String.format("%1$" + num + "s", str).replace(' ', '0');
	}
	private static Double abs(Double value) {
	        return Math.abs(value);
	}
	
    private static String sign(Double value) {
        return value < 0.0 ? "-" : " ";
    }
}

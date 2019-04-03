//package com.bsva.dmcs.reports;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import java.util.Map.Entry;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.Marshaller;
//import javax.xml.bind.Unmarshaller;
//
//import org.apache.log4j.Logger;
//
//import com.bsva.dcms.commons.dao.CSFSubServicesDAO;
//import com.bsva.dcms.commons.dao.CsvCCR00XDataViewDAO;
//import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
//import com.bsva.dcms.commons.dto.CSFSubServicesDTO;
//import com.bsva.dcms.commons.dto.CSFTransactionTypesDTO;
//import com.bsva.dcms.commons.dto.views.CsvCcr00XDataViewDto;
//import com.bsva.dcms.commons.exceptions.DAOException;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dmcs.file.reports.CCR001AND5Reports;
//import com.bsva.dmcs.file.reports.CCR001AND5ReportsList;
//import com.bsva.dmcs.file.reports.FooterRecord;
//import com.bsva.dmcs.file.reports.FromAddress;
//import com.bsva.dmcs.file.reports.HeaderRecord;
//import com.bsva.dmcs.file.reports.ReportLine;
//import com.bsva.dmcs.file.reports.TaxInvoiceSubline;
//import com.bsva.dmcs.file.reports.TaxRegNumber;
//import com.bsva.dmcs.file.reports.ToAddress;
//import com.bsva.dmcs.file.reports.dto.ReportsSubline;
//
//
//
///**
// * @author AugustineA
// *
// */
//public class CCR005 {
//
//	private final static Map<String, String> SUB_SERVICE_MNEMONICS;
//	static {
//		SUB_SERVICE_MNEMONICS = new HashMap<>();
//		SUB_SERVICE_MNEMONICS.put("VISA CARD",       "V");
//		SUB_SERVICE_MNEMONICS.put("MASTERCARD",        "M");
//		SUB_SERVICE_MNEMONICS.put("DINERS",     "D");
//		SUB_SERVICE_MNEMONICS.put("AMEX",       "A");
//		SUB_SERVICE_MNEMONICS.put("FLEET CARD", "F");
//	}
//	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HHmmssSSS");
//	private String issuerMemberNo = "0";
//	public final static String NUMBER_FORMAT = "%1$,.2f";
//
//	private static Logger log = Logger.getLogger(CCR001.class);
//	private List<CSFMemberServiceDTO> csfMemberServiceList2 = new ArrayList<>();
//	private List<com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto> dtoListVisaCD = new ArrayList<>();
//	private List<com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto> dtoListMasterCardCD = new ArrayList<>();
//	private FileWriter fw = null ;
//	private BufferedWriter bw = null;
//	private int transValueCode = 0;
//	private int numberChangeBreak = 0;
//	private String  transValue = null;
//	private String transValueString = null;
//	private int acquirereMember = 0;
//	private int issuerMember = 0;
//	private static final String CARDSERVICEVISACREDIT = "VISA CARD";
//	private static final String CARDSERVICEVISADEBIT = "VISA DEBIT";
//	private static final String CARDSERVICEMASTERCARDCREDIT = "MASTERCARD";
//	private static final String CARDSERVICEMASTERCARDDEBIT = "MASTERDEBIT";
//
//	private static final String SUBTOTALS = "SUB TOTALS";
//	private int subTotalsCountCalc = 0;
//	private double subTotalsAmountCalc = 0.0;
//	private double subTotalsInterchangeCalc = 0.0;
//	private double subTotalsVatCalc = 0.0;
//	private double subTotalsTotalChargesCalc = 0.0;
//	private double subTotalsNetAmountCalc = 0.0;
//
//	private int grandTotalsCountCalc = 0;
//	private double grandTotalsAmountCalc = 0.0;
//	private double grandTotalsInterchangeCalc = 0.0;
//	private double grandTotalsVatCalc = 0.0;
//	private double grandTotalsTotalChargesCalc = 0.0;
//	private double grandTotalsNetAmountCalc = 0.0;
//
//	private int summaryTotalsCountCalc = 0;
//	private double summaryTotalsAmountCalc = 0.0;
//	private double summaryTotalsInterchangeCalc = 0.0;
//	private double summaryTotalsVatCalc = 0.0;
//	private double summaryTotalsTotalChargesCalc = 0.0;
//	private double summaryTotalsNetAmountCalc = 0.0;
//
//	private int reportSortSquence1 = 1;
//	private int reportSortSquence21 = 21;
//
//	public CCR005() {
//
//	}
//
//	public void getSubService() throws Exception{
//
//		try {
//
//			CSFSubServicesDTO subServiceDto = new CSFSubServicesDTO();
//			List<CSFSubServicesDTO> subServiceList = new CSFSubServicesDAO().retrieveRelated(subServiceDto);
//
//			for(CSFSubServicesDTO serviceDto : subServiceList){
//
//				if (serviceDto!=null){
//					String subServiceData = serviceDto.getSubservice();
//
//					if (subServiceData.equals("VISA CARD") || subServiceData.equals("MASTERCARD") && serviceDto.getActiveIndicator().equals("Y")) {
//						log.debug("subService " + subServiceData);
//						createBillingReports(subServiceData);
//					}
//
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public void createBillingReports(String subService) throws Exception {
//
//		CCR002 ccr002Report = null;
//		ccr002Report = new CCR002();
//		ccr002Report.printTextFile();
//		CCR005 ccr005 = new CCR005(subService,1);
//
//	}
//
//	 public List<com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto> filterListVISACard(List<com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto> list, String credit,String debit){
//
//		for (com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto csvCcr00XDataViewDto : list) {
//			  if(csvCcr00XDataViewDto.getCardDescription().equals(credit) ||csvCcr00XDataViewDto.getCardDescription().equals(debit)){
//			     dtoListVisaCD.add(csvCcr00XDataViewDto);
//			   }else if(csvCcr00XDataViewDto.getCardDescription().equals(CARDSERVICEMASTERCARDCREDIT) || csvCcr00XDataViewDto.getCardDescription().equals(CARDSERVICEVISACREDIT)){
//                   dtoListVisaCD.add(csvCcr00XDataViewDto);
//               }
//
//
//		}
//		return dtoListVisaCD;
//
//	}
//	public List<com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto> filterListCard(List<com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto> list, String credit,String debit){
//
//		for (com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto csvCcr00XDataViewDto : list) {
//
//				if(csvCcr00XDataViewDto.getCardDescription().equals(CARDSERVICEMASTERCARDDEBIT) || csvCcr00XDataViewDto.getCardDescription().equals(CARDSERVICEMASTERCARDCREDIT) || csvCcr00XDataViewDto.getCardDescription().equals(CARDSERVICEVISACREDIT) || csvCcr00XDataViewDto.getCardDescription().equals(CARDSERVICEVISADEBIT)){
//					dtoListVisaCD.add(csvCcr00XDataViewDto);
//				}
//
//		}
//		return dtoListVisaCD;
//
//	}
//
//	public List<com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto> filterListMASTERCard(List<com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto> list, String credit,String debit){
//
//		for (com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto csvCcr00XDataViewDto : list) {
//
//				if(csvCcr00XDataViewDto.getCardDescription().equals(credit) || csvCcr00XDataViewDto.getCardDescription().equals(debit) ){
//					dtoListMasterCardCD.add(csvCcr00XDataViewDto);
//				}
//
//		}
//		return dtoListMasterCardCD;
//
//	}
//
//
//	@SuppressWarnings("unused")
//	public CCR005(String subService,int oneOrFive) throws Exception {
//	try{
//		if (oneOrFive != 1 && oneOrFive != 5) {
//			return;
//		}
//		String processDate = BsvTableLookup.getInstance().getProcessDate();
//
//		CsvCCR00XDataViewDAO csvCcr00XDataViewDao = new CsvCCR00XDataViewDAO();
//		CsvCcr00XDataViewDto csvCcr00XDataViewDto = new CsvCcr00XDataViewDto();
//		List<com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto> dtoList = csvCcr00XDataViewDao.retrieveRelated();
//		//List<com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto> listVISA = filterListVISACard(dtoList,CARDSERVICEVISACREDIT ,CARDSERVICEVISADEBIT);
//		List<com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto> listVISA = filterListVISACard(dtoList,CARDSERVICEVISACREDIT,CARDSERVICEVISADEBIT);
//
//		//List<com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto> listMASTERCARD = filterListMASTERCard(dtoList,CARDSERVICEMASTERCARDCREDIT ,CARDSERVICEMASTERCARDDEBIT);
//		//List<com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto> listCARD = filterListCard(dtoList,CARDSERVICEMASTERCARDCREDIT ,CARDSERVICEMASTERCARDDEBIT);
//
//		//List<CsvCcr00XDataViewDto> dtoList = new CsvCcr00XDataView().execute();
//		List<CCR001AND5Reports> listData = new ArrayList<>();
//
//		FooterRecord footerRecord  = new FooterRecord();
//		HeaderRecord headerRecord = new HeaderRecord();
//		ReportsSubline reportsSub = new ReportsSubline();
//		TaxInvoiceSubline taxInvoice = new TaxInvoiceSubline();
//		TaxRegNumber taxRegNumber = new TaxRegNumber();
//		ReportLine reportLine = new ReportLine();
//		boolean boolHeader = true;
//		boolean boolFooter = true;
//		boolean boolBreakLine = true;
//		boolean addressBool = true;
//		SummaryPage summaryPage = new SummaryPage();
//		//for (com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto dto :listCARD ){//Looping through the reportsList
//		  for (com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto dto :listVISA ){//Looping through the reportsList
//
//			if (dto!= null) {
//				CCR001AND5Reports ccr001AND5Report = new CCR001AND5Reports();
//
//				if(addressBool){
//					CSFMemberServiceDTO csfMemberServiceDTO = getMembers(dto.getAcquirerBankCode());
//
//					FromAddress address = new FromAddress();
//					address.setAccountNumber(csfMemberServiceDTO.getAccountNumber());
//					address.setAcquirerInd(csfMemberServiceDTO.getAcquirerInd());
//					address.setBankCode(csfMemberServiceDTO.getBranchCode());
//					address.setContactName(csfMemberServiceDTO.getContactName());
//					address.setCountry(csfMemberServiceDTO.getCountry());
//					address.setInvoiceNoCCR001(String.valueOf(csfMemberServiceDTO.getInvoiceNoCCR001()));
//					address.setIssuerInd(csfMemberServiceDTO.getIssuerInd());
//					address.setMemberAddress1(csfMemberServiceDTO.getMemberAddress1());
//					address.setMemberAddress2(csfMemberServiceDTO.getMemberAddress2());
//					address.setMemberAddress3(csfMemberServiceDTO.getMemberAddress3());
//					address.setMemberAddress4(csfMemberServiceDTO.getMemberAddress4());
//					address.setMemberNo(csfMemberServiceDTO.getMemberNo());
//					address.setService(csfMemberServiceDTO.getService());
//					address.setSubService(dto.getSubService());
//					address.setTitle(csfMemberServiceDTO.getTitle());
//					address.setVatRegNumber(csfMemberServiceDTO.getVatRegNumber());
//
//					taxRegNumber.setTaxNumber("TAX INVOICE NUMBER:");
//					taxRegNumber.setCompanyRegNumber(String.valueOf(csfMemberServiceDTO.getInvoiceNoCCR001()));
//					taxRegNumber.setRegNumber("REG.NO.");
//					taxRegNumber.setNumber(csfMemberServiceDTO.getVatRegNumber());
//
//					ccr001AND5Report.setService(dto.getService());
//					ccr001AND5Report.setSubService(dto.getSubService());
//
//					taxInvoice.setService(dto.getService());
//					taxInvoice.setSubService(dto.getSubService());
//					taxInvoice.setLineReport("C R E D I T   C A R D   F E E   C A L C U L A T I O N   R E P O R T");
//
//					reportsSub.setCompName("BANKSERV");
//					reportsSub.setReportName("CCR001   :");
//					reportsSub.setBankersName("SOUTH AFRICAN BANKERS SERVICES COMPANY LIMITED");
//				    reportsSub.setProcessDate(processDate);
//					reportsSub.setPage("PAGE:-");
//
//					ccr001AND5Report.setReportsSub(reportsSub);
//
//					reportLine.setLine("-------------------------------------------------------------------------------------------------------------------------------------------------");
//					ccr001AND5Report.setReportLine(reportLine);
//
//					CSFMemberServiceDTO toCsfMemberServiceDTO = getMembers(dto.getIssuerBankCode());
//					ToAddress toaddress = new ToAddress();
//					toaddress.setAccountNumber(toCsfMemberServiceDTO.getAccountNumber());
//					toaddress.setAcquirerInd(toCsfMemberServiceDTO.getAcquirerInd());
//					toaddress.setBankCode(toCsfMemberServiceDTO.getBranchCode());
//					toaddress.setContactName(toCsfMemberServiceDTO.getContactName());
//					toaddress.setCountry(toCsfMemberServiceDTO.getCountry());
//					toaddress.setInvoiceNoCCR001(String.valueOf(toCsfMemberServiceDTO.getInvoiceNoCCR001()));
//					toaddress.setIssuerInd(toCsfMemberServiceDTO.getIssuerInd());
//					toaddress.setMemberAddress1(toCsfMemberServiceDTO.getMemberAddress1());
//					toaddress.setMemberAddress2(toCsfMemberServiceDTO.getMemberAddress2());
//					toaddress.setMemberAddress3(toCsfMemberServiceDTO.getMemberAddress3());
//					toaddress.setMemberAddress4(toCsfMemberServiceDTO.getMemberAddress4());
//					toaddress.setMemberNo(toCsfMemberServiceDTO.getMemberNo());
//					toaddress.setService(dto.getService());
//					toaddress.setSubService(dto.getSubService());
//					toaddress.setTitle(toCsfMemberServiceDTO.getTitle());
//					toaddress.setVatRegNumber(toCsfMemberServiceDTO.getVatRegNumber());
//
//					ccr001AND5Report.setFromAddres(address);
//					ccr001AND5Report.setToAddres(toaddress);
//					addressBool = false;
//
//				}
//				//setting Headers
//				headerRecord.setRecorIdentifier("01");
//				headerRecord.setOutputDate(processDate);
//				headerRecord.setServiceType(dto.getService());
//				headerRecord.setSubservice("REPORTS");
//				headerRecord.setBankMemberNumber("0002ACBJ");
//				headerRecord.setOriginator("");
//				headerRecord.setFileName("0001");
//				headerRecord.setFileNumber("     ");
//				headerRecord.setDataType("DATA");
//				headerRecord.setDataDirection("OUT");
//				headerRecord.setSettlementDate(processDate);
//				headerRecord.setTestLive("TEST01320002CCR005");
//				headerRecord.setRecordSize(String.valueOf(dtoList.size()));
//				headerRecord.setFiller("");
//
//				ccr001AND5Report.setHeaderRecord(headerRecord);
//
//				footerRecord.setRecorIdentifier("99");
//				footerRecord.setOutputDate(processDate);
//				footerRecord.setServiceType(dto.getService());
//				footerRecord.setSubServiceType("REPORTS");
//				footerRecord.setBankMemberNumber("000000");
//				footerRecord.setNumberOfTransmissionFiles("1767");
//				footerRecord.setNumberOfCreditRecords("00000000");
//				footerRecord.setNumberOfDebitRecords("       ");
//				footerRecord.setValueOfCreditRecords("        ");
//				footerRecord.setValueOfDebitRecords("        ");
//				footerRecord.setHashTotalOfAccount("        ");
//				footerRecord.setFiller("000000000000000000000000000000000000000000000000000000000000");
//				ccr001AND5Report.setFooterRecord(footerRecord);
//
//
//
//			 String breakTransactionValue = String.valueOf(dto.getTransactionCode());
//			 if(breakTransactionValue.length() == 2){
//			     transValue = breakTransactionValue.substring(1);
//		     }else if(breakTransactionValue.length() == 1){
//		    	 transValue = breakTransactionValue;
//		     }
//		    ccr001AND5Report.setTransactionTypeDecsription(dto.getTransactionDescription());
//		    ccr001AND5Report.setTransCount(String.valueOf(dto.getVolume()));
//		    ccr001AND5Report.setTransAmount(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(dto.getTransactionValue()))));
//		    ccr001AND5Report.setTransInterchange(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(dto.getBillingFee() + dto.getBillingFeeAmount()))));
//		    ccr001AND5Report.setTransVat(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(dto.getBillingVat()))));
//		    ccr001AND5Report.setTransTotalCharge(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(dto.getBillingVat() + dto.getBillingFee() + dto.getBillingFeeAmount()))));
//		    ccr001AND5Report.setTransNetAmount(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(dto.getBillingVat() + dto.getBillingFee() + dto.getBillingFeeAmount() + dto.getTransactionValue()))));
//		    ccr001AND5Report.setReportSortSequence(String.valueOf(dto.getReportSortSequence()));
//
//		    subTotalsCountCalc = subTotalsCountCalc + dto.getVolume();
//		    subTotalsAmountCalc = subTotalsAmountCalc + dto.getTransactionValue();
//		    subTotalsInterchangeCalc = subTotalsInterchangeCalc + dto.getBillingFee()+ dto.getBillingFeeAmount() ;
//			subTotalsVatCalc = subTotalsVatCalc + dto.getBillingVat();
//			subTotalsTotalChargesCalc = subTotalsTotalChargesCalc + dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			subTotalsNetAmountCalc = subTotalsNetAmountCalc + dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//
//			grandTotalsCountCalc = subTotalsCountCalc + dto.getVolume();
//			grandTotalsAmountCalc = subTotalsAmountCalc + dto.getTransactionValue();
//			grandTotalsInterchangeCalc = subTotalsInterchangeCalc + dto.getBillingFee()+ dto.getBillingFeeAmount() ;
//			grandTotalsVatCalc = subTotalsVatCalc + dto.getBillingVat();
//			grandTotalsTotalChargesCalc = subTotalsTotalChargesCalc + dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			grandTotalsNetAmountCalc = subTotalsNetAmountCalc + dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//
//			//summary
//			summaryTotalsCountCalc = summaryTotalsCountCalc + dto.getVolume();
//			summaryTotalsAmountCalc = summaryTotalsAmountCalc + dto.getTransactionValue();
//			summaryTotalsInterchangeCalc = summaryTotalsInterchangeCalc + dto.getBillingFee()+ dto.getBillingFeeAmount() ;
//			summaryTotalsVatCalc = summaryTotalsVatCalc + dto.getBillingVat();
//			summaryTotalsTotalChargesCalc = summaryTotalsTotalChargesCalc + dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			summaryTotalsNetAmountCalc = summaryTotalsNetAmountCalc + dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//
//			summaryPage.setCountValue(String.valueOf(summaryTotalsCountCalc));
//			summaryPage.setAmountValue(String.valueOf(new BigDecimal(summaryTotalsAmountCalc).setScale(2,BigDecimal.ROUND_HALF_UP)));
//			summaryPage.setInterchangeValue(String.valueOf(new BigDecimal(summaryTotalsInterchangeCalc).setScale(2,BigDecimal.ROUND_HALF_UP)));
//			summaryPage.setVatValue(String.valueOf(new BigDecimal(summaryTotalsVatCalc).setScale(2,BigDecimal.ROUND_HALF_UP)));
//			summaryPage.setTotalChargesValue(String.valueOf(new BigDecimal(summaryTotalsTotalChargesCalc).setScale(2,BigDecimal.ROUND_HALF_UP)));
//			summaryPage.setNetAmountValue(String.valueOf(new BigDecimal(summaryTotalsNetAmountCalc).setScale(2,BigDecimal.ROUND_HALF_UP)));
//
//			/*if(dto.getTransactionDescription().startsWith("REVERSAL")){
//				ccr001AND5Report.setUnderlines("-------------------");
//			}*/
//
//			int numChange = Integer.valueOf(transValue);
//
//			if(numChange != transValueCode && transValueCode != 0){
//				//Create a break line .
//				ccr001AND5Report.setUnderlines("-------------------");
//				//doing Sub Totals
//				ccr001AND5Report.setSubTotalsAll(SUBTOTALS);
//				ccr001AND5Report.setSubTotalsCount(String.valueOf(subTotalsCountCalc));
//				subTotalsCountCalc = 0;
//				ccr001AND5Report.setSubTotalsAmount(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(subTotalsAmountCalc))));
//				subTotalsAmountCalc = 0.0;
//				ccr001AND5Report.setSubTotalsInterchange(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(subTotalsInterchangeCalc))));
//				subTotalsInterchangeCalc = 0.0;
//				ccr001AND5Report.setSubTotalsVat(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(subTotalsVatCalc))));
//				subTotalsVatCalc = 0.0;
//				ccr001AND5Report.setSubTotalsTotalCharges(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(subTotalsTotalChargesCalc))));
//				subTotalsTotalChargesCalc = 0.0;
//				ccr001AND5Report.setSubTotalsNetAmount(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(subTotalsNetAmountCalc))));
//				subTotalsNetAmountCalc = 0.0;
//			}
//			if(reportSortSquence21 == dto.getReportSortSequence()){
//				//Create a break line .
//				ccr001AND5Report.setUnderlines("-------------------");
//				//doing Sub Totals
//				ccr001AND5Report.setSubTotalsAll(SUBTOTALS);
//				ccr001AND5Report.setSubTotalsCount(String.valueOf(subTotalsCountCalc));
//				subTotalsCountCalc = 0;
//				ccr001AND5Report.setSubTotalsAmount(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(subTotalsAmountCalc))));
//				subTotalsAmountCalc = 0.0;
//				ccr001AND5Report.setSubTotalsInterchange(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(subTotalsInterchangeCalc))));
//				subTotalsInterchangeCalc = 0.0;
//				ccr001AND5Report.setSubTotalsVat(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(subTotalsVatCalc))));
//				subTotalsVatCalc = 0.0;
//				ccr001AND5Report.setSubTotalsTotalCharges(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(subTotalsTotalChargesCalc))));
//				subTotalsTotalChargesCalc = 0.0;
//				ccr001AND5Report.setSubTotalsNetAmount(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(subTotalsNetAmountCalc))));
//				subTotalsNetAmountCalc = 0.0;
//				//Create a break line .
//				//reportLine.setLine("-------------------------------------------------------------------------------------------------------------------------------------------------");
//				ccr001AND5Report.setUnderlines("-------------------");
//				//ccr001AND5Report.setReportLine(reportLine);
//				ccr001AND5Report.setGrandTotalsName("GRAND TOTALS");
//				ccr001AND5Report.setGrandTotalsCountCalc(String.valueOf(grandTotalsCountCalc));
//				grandTotalsCountCalc = 0;
//				ccr001AND5Report.setGrandTotalsAmountCalc(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(grandTotalsAmountCalc))));
//				grandTotalsAmountCalc = 0.0;
//				ccr001AND5Report.setGrandTotalsInterchangeCalc(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(grandTotalsInterchangeCalc))));
//				grandTotalsInterchangeCalc = 0.0;
//				ccr001AND5Report.setGrandTotalsVatCalc(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(grandTotalsVatCalc))));
//				grandTotalsVatCalc = 0.0;
//				ccr001AND5Report.setGrandTotalsTotalChargesCalc(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(grandTotalsTotalChargesCalc))));
//				grandTotalsTotalChargesCalc =0.0;
//				ccr001AND5Report.setGrandTotalsNetAmountCalc(String.format(NUMBER_FORMAT, Double.parseDouble(String.valueOf(grandTotalsNetAmountCalc))));
//				grandTotalsNetAmountCalc = 0.0;
//
//				CSFMemberServiceDTO csfMemberServiceDTO = getMembers(dto.getAcquirerBankCode());
//
//				FromAddress address = new FromAddress();
//				address.setAccountNumber(csfMemberServiceDTO.getAccountNumber());
//				address.setAcquirerInd(csfMemberServiceDTO.getAcquirerInd());
//				address.setBankCode(csfMemberServiceDTO.getBranchCode());
//				address.setContactName(csfMemberServiceDTO.getContactName());
//				address.setCountry(csfMemberServiceDTO.getCountry());
//				address.setInvoiceNoCCR001(String.valueOf(csfMemberServiceDTO.getInvoiceNoCCR001()));
//				address.setIssuerInd(csfMemberServiceDTO.getIssuerInd());
//				address.setMemberAddress1(csfMemberServiceDTO.getMemberAddress1());
//				address.setMemberAddress2(csfMemberServiceDTO.getMemberAddress2());
//				address.setMemberAddress3(csfMemberServiceDTO.getMemberAddress3());
//				address.setMemberAddress4(csfMemberServiceDTO.getMemberAddress4());
//				address.setMemberNo(csfMemberServiceDTO.getMemberNo());
//				address.setService(csfMemberServiceDTO.getService());
//				address.setSubService(dto.getSubService());
//				address.setTitle(csfMemberServiceDTO.getTitle());
//				address.setVatRegNumber(csfMemberServiceDTO.getVatRegNumber());
//
//				taxRegNumber.setTaxNumber("TAX INVOICE NUMBER:");
//				taxRegNumber.setCompanyRegNumber(String.valueOf(csfMemberServiceDTO.getInvoiceNoCCR001()));
//				taxRegNumber.setRegNumber("REG.NO.");
//				taxRegNumber.setNumber(csfMemberServiceDTO.getVatRegNumber());
//
//				ccr001AND5Report.setService(dto.getService());
//				ccr001AND5Report.setSubService(dto.getSubService());
//
//				taxInvoice.setService(dto.getService());
//				taxInvoice.setSubService(dto.getSubService());
//				taxInvoice.setLineReport("C R E D I T   C A R D   F E E   C A L C U L A T I O N   R E P O R T");
//
//				reportsSub.setCompName("BANKSERV");
//				reportsSub.setReportName("CCR001   :");
//				reportsSub.setBankersName("SOUTH AFRICAN BANKERS SERVICES COMPANY LIMITED");
//			    reportsSub.setProcessDate(processDate);
//				reportsSub.setPage("PAGE:-");
//
//				ccr001AND5Report.setReportsSub(reportsSub);
//
//				reportLine.setLine("-------------------------------------------------------------------------------------------------------------------------------------------------");
//				ccr001AND5Report.setReportLine(reportLine);
//
//				CSFMemberServiceDTO toCsfMemberServiceDTO = getMembers(dto.getIssuerBankCode());
//				issuerMemberNo = toCsfMemberServiceDTO.getMemberNo();
//				ToAddress toaddress = new ToAddress();
//				toaddress.setAccountNumber(toCsfMemberServiceDTO.getAccountNumber());
//				toaddress.setAcquirerInd(toCsfMemberServiceDTO.getAcquirerInd());
//				toaddress.setBankCode(toCsfMemberServiceDTO.getBranchCode());
//				toaddress.setContactName(toCsfMemberServiceDTO.getContactName());
//				toaddress.setCountry(toCsfMemberServiceDTO.getCountry());
//				toaddress.setInvoiceNoCCR001(String.valueOf(toCsfMemberServiceDTO.getInvoiceNoCCR001()));
//				toaddress.setIssuerInd(toCsfMemberServiceDTO.getIssuerInd());
//				toaddress.setMemberAddress1(toCsfMemberServiceDTO.getMemberAddress1());
//				toaddress.setMemberAddress2(toCsfMemberServiceDTO.getMemberAddress2());
//				toaddress.setMemberAddress3(toCsfMemberServiceDTO.getMemberAddress3());
//				toaddress.setMemberAddress4(toCsfMemberServiceDTO.getMemberAddress4());
//				toaddress.setMemberNo(toCsfMemberServiceDTO.getMemberNo());
//				toaddress.setService(dto.getService());
//				toaddress.setSubService(dto.getSubService());
//				toaddress.setTitle(toCsfMemberServiceDTO.getTitle());
//				toaddress.setVatRegNumber(toCsfMemberServiceDTO.getVatRegNumber());
//
//				ccr001AND5Report.setFromAddres(address);
//				ccr001AND5Report.setToAddres(toaddress);
//			}
//			transValueCode = Integer.valueOf(transValue);
//			numChange = 0;
//			listData.add(ccr001AND5Report);
//			issuerMember = dto.getIssuerBankCode();
//			acquirereMember = dto.getAcquirerBankCode();
//			  if(dto.getAcquirerBankCode() != dto.getIssuerBankCode()){
//				  summaryPage.setCount("COUNT");
//				  summaryPage.setAmount("AMOUNT");
//				  summaryPage.setInterchange("INTERCHANGE");
//				  summaryPage.setVat("VAT");
//				  summaryPage.setTotalCharges("TOTAL CHARGES");
//				  summaryPage.setNetAmount("NETT AMOUNT");
//
//				  String cardDescription = dto.getTransactionDescription();
//				  switch (cardDescription) {
//			         case SummaryConstants.SALESDRAFTS:
//			        	 summaryPage.setSalesDraft(dto.getTransactionDescription());
//			        	 int volumes = dto.getVolume();
//			        	 summaryPage.setSalesDraftCount(String.valueOf(volumes + dto.getVolume()));
//			        	 double values = dto.getTransactionValue();
//			        	 summaryPage.setSalesDraftAmount(String.valueOf(+ values + dto.getTransactionValue()));
//			        	 double feeAmount = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 summaryPage.setSalesDraftInterChange(String.valueOf(feeAmount + (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 double vatAmount = dto.getBillingVat();
//			        	 summaryPage.setSalesDraftVat(String.valueOf(vatAmount + dto.getBillingVat()));
//			        	 double totalChanges = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 summaryPage.setSalesDraftTotalCharges(String.valueOf(totalChanges + (dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 double netAmount = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setSalesDraftNetAmount(String.valueOf(netAmount + (dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue())));
//			             break;
//
//			         case SummaryConstants.CHARGEBACKSSD:
//			        	 int volumes1 = dto.getVolume();
//			        	 double values1 = dto.getTransactionValue();
//			        	 double vatAmount1 = dto.getBillingVat();
//			        	 double totalChanges1 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount1 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 double feeAmount1 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 summaryPage.setChargeBacksSd(dto.getTransactionDescription());
//			        	 summaryPage.setChargeBacksSdCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setChargeBacksSdAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setChargeBacksSdVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setChargeBacksSdInterChange(String.valueOf(feeAmount1 + (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setChargeBacksSdTotalCharges(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setChargeBacksSdNetAmount(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			             break;
//
//			         case SummaryConstants.REVERSALSSD:
//			        	 int volumes2 = dto.getVolume();
//			        	 double values2 = dto.getTransactionValue();
//			        	 double feeAmount2 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount2 = dto.getBillingVat();
//			        	 double totalChanges2 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount2 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setReversalsSd(dto.getTransactionDescription());
//			        	 summaryPage.setReversalsSdCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setReversalsSdAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setReversalsSdVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setReversalsSdInterChange(String.valueOf(feeAmount2 + (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setReversalsSdTotalCharges(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setReversalsSdNetAmount(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			             break;
//
//			         case SummaryConstants.PURCHASEWCASH:
//			        	 int volumes3 = dto.getVolume();
//			        	 double values3 = dto.getTransactionValue();
//
//			        	 double feeAmount3 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount3 = dto.getBillingVat();
//			        	 double totalChanges3 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount3 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setPurchaseWCash(dto.getTransactionDescription());
//			        	 summaryPage.setPurchaseWCashCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setPurchaseWCashAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setPurchaseWCashVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setPurchaseWCashInterChange(String.valueOf(feeAmount3 + (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setPurchaseWCashTotalCharges(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setPurchaseWCashNetAmount(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			             break;
//
//			         case SummaryConstants.CHARGEBACKWCA:
//			        	 int volumes4 = dto.getVolume();
//			        	 double values4 = dto.getTransactionValue();
//			        	 double feeAmount4 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount4 = dto.getBillingVat();
//			        	 double totalChanges4 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount4 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setChargeBacksCa(dto.getTransactionDescription());
//			        	 summaryPage.setChargeBacksCaCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setChargeBacksCaAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setChargeBacksCaVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setChargeBacksCaInterChange(String.valueOf(feeAmount4 + (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setChargeBacksCaTotalCharges(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setChargeBacksCaNetAmount(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			        	 break;
//
//			         case SummaryConstants.REVERSALWCASH:
//			        	 summaryPage.setReversalCash(cardDescription);
//			        	 int volumes5 = dto.getVolume();
//			        	 double values5 = dto.getTransactionValue();
//			        	 double feeAmount5 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount5 = dto.getBillingVat();
//			        	 double totalChanges5 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount5 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setReversalWCash(dto.getTransactionDescription());
//			        	 summaryPage.setReversalWCashCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setReversalWCashAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setReversalWCashVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setReversalWCashInterChange(String.valueOf(feeAmount5 + (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setReversalWCashTotalCharges(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setReversalWCashNetAmount(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			        	 break;
//
//			         case SummaryConstants.CASHBACKONPR:
//			        	 int volumes6 = dto.getVolume();
//			        	 double values6 = dto.getTransactionValue();
//			        	 double feeAmount6 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount6 = dto.getBillingVat();
//			        	 double totalChanges6 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmoun6 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setCashBackOnPR(dto.getTransactionDescription());
//			        	 summaryPage.setCashBackOnPRCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setCashBackOnPRAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setCashBackOnPRVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setCashBackOnPRInterChange(String.valueOf(feeAmount6 + (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setCashBackOnPRTotalCharges(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setCashBackOnPRNetAmount(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			             break;
//
//			         case SummaryConstants.CASHBACKWPURC:
//			        	 int volumes7 = dto.getVolume();
//			        	 double values7 = dto.getTransactionValue();
//			        	 double feeAmount7 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount7 = dto.getBillingVat();
//			        	 double totalChanges7 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount7 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setCashBackWPurc(dto.getTransactionDescription());
//			        	 summaryPage.setCashBackWPurcCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setCashBackWPurcAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setCashBackWPurcVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setCashBackWPurcInterChange(String.valueOf(feeAmount7 + (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setCashBackWPurcTotalCharges(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setCashBackWPurcNetAmount(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			             break;
//
//			         case SummaryConstants.REVERSALWPURC:
//			        	 int volumes8 = dto.getVolume();
//			        	 double values8 = dto.getTransactionValue();
//			        	 double feeAmount8 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount8 = dto.getBillingVat();
//			        	 double totalChanges8 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount8 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setReversalWpurc(dto.getTransactionDescription());
//			        	 summaryPage.setReversalWpurcCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setReversalWpurcAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setReversalWpurcVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setReversalWpurcInterChange(String.valueOf(feeAmount8 + (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setReversalWpurcTotalCharges(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setReversalWpurcNetAmount(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			        	 break;
//
//			         case SummaryConstants.CASHBACKNOP:
//			        	 int volumes9 = dto.getVolume();
//			        	 double values9 = dto.getTransactionValue();
//			        	 double feeAmount9 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount9 = dto.getBillingVat();
//			        	 double totalChanges9 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmoun9t = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setCashBackNoP(dto.getTransactionDescription());
//			        	 summaryPage.setCashBackNoPCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setCashBackNoPAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setCashBackNoPVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setCashBackNoPInterChange(String.valueOf(feeAmount9 + (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setCashBackNoPTotalCharges(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setCashBackNoPNetAmount(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			             break;
//
//			         case SummaryConstants.CHARGEBACKCAS:
//			        	 int volumes10 = dto.getVolume();
//			        	 double values10 = dto.getTransactionValue();
//			        	 double feeAmount10 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount10 = dto.getBillingVat();
//			        	 double totalChanges10 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount10 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setChargeBackCas(dto.getTransactionDescription());
//			        	 summaryPage.setChargeBackCasCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setChargeBackCasAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setChargeBackCasVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setChargeBackCasInterChange(String.valueOf(feeAmount10 + (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setChargeBackCashTotalCharges(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setChargeBackCasNetAmount(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			             break;
//
//			         case SummaryConstants.REVERSALCASH:
//			        	 int volumes11 = dto.getVolume();
//			        	 double values11 = dto.getTransactionValue();
//			        	 double feeAmount11 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount11 = dto.getBillingVat();
//			        	 double totalChanges11 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount11 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setReversalCash(dto.getTransactionDescription());
//			        	 summaryPage.setReversalCashCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setReversalCashAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setReversalCashVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setReversalCashInterChange(String.valueOf(feeAmount11 + (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setReversalCashTotalCharges(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setReversalCashNetAmount(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			             break;
//
//			         case SummaryConstants.PETROLSALES:
//			        	 int volumes12 = dto.getVolume();
//			        	 double values12 = dto.getTransactionValue();
//			        	 double feeAmount12 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount12 = dto.getBillingVat();
//			        	 double totalChanges12 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount12 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setPetrolSales(dto.getTransactionDescription());
//			        	 summaryPage.setPetrolSalesCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setPetrolSalesAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setPetrolSalesVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setPetrolSalesInterChange(String.valueOf(feeAmount12 + (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setPetrolSalesTotalCharges(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setPetrolSalesNetAmount(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			             break;
//
//			         case SummaryConstants.CHARGEBACKSPS:
//			        	 int volumes13 = dto.getVolume();
//			        	 double values13 = dto.getTransactionValue();
//			        	 double feeAmount13 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount13 = dto.getBillingVat();
//			        	 double totalChanges13 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount13 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setChargeBacksPs(dto.getTransactionDescription());
//			        	 summaryPage.setChargeBacksPsCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setChargeBacksPsAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setChargeBacksPsVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setChargeBacksPsInterChange(String.valueOf(feeAmount13 + (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setChargeBacksPsTotalCharges(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setChargeBacksPsNetAmount(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			             break;
//
//			         case SummaryConstants.REVERSALSPS:
//			        	 int volumes14 = dto.getVolume();
//			        	 double values14 = dto.getTransactionValue();
//			        	 double feeAmount14 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount14 = dto.getBillingVat();
//			        	 double totalChanges14 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount14 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setReversalsPs(dto.getTransactionDescription());
//			        	 summaryPage.setReversalsPsCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setReversalsPsAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setReversalsPsVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setReversalsPsInterChange(String.valueOf(feeAmount14 + (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setReversalsPsTotalCharges(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setReversalsPsNetAmount(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			        	 break;
//
//			         case SummaryConstants.CREDITVOUCHERS:
//			        	 int volumes15 = dto.getVolume();
//			        	 double values15 = dto.getTransactionValue();
//			        	 double feeAmount15 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount15 = dto.getBillingVat();
//			        	 double totalChanges15 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount15 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setCreditVouchers(dto.getTransactionDescription());
//			        	 summaryPage.setCreditVouchersCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setCreditVouchersAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setCreditVouchersVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setCreditVouchersInterChange(String.valueOf(feeAmount15 += (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setCreditVouchersTotalCharges(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setCreditVouchersNetAmount(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			        	 break;
//
//			         case SummaryConstants.CHARGEBACKSCV:
//			        	 int volumes16 = dto.getVolume();
//			        	 double values16 = dto.getTransactionValue();
//			        	 double feeAmount16 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount16 = dto.getBillingVat();
//			        	 double totalChanges16 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount16 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setChargeBacksCv(dto.getTransactionDescription());
//			        	 summaryPage.setChargeBacksCvCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setChargeBacksCvAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setChargeBacksCvVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setChargeBacksCvInterChange(String.valueOf(feeAmount16 + (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setChargeBacksCvTotalCharges(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setChargeBacksCvNetAmount(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			             break;
//
//			         case SummaryConstants.REVERSALSCV:
//			        	 int volumes17 = dto.getVolume();
//			        	 double values17 = dto.getTransactionValue();
//			        	 double feeAmount17 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount17 = dto.getBillingVat();
//			        	 double totalChanges17 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount17 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setReversalsCv(dto.getTransactionDescription());
//			        	 summaryPage.setReversalsCvCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setReversalsCvAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setReversalsCvVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setReversalsCvInterChange(String.valueOf(feeAmount17 + (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setReversalsCvTotalCharges(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setReversalsCvNetAmount(String.valueOf(dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			             break;
//
//			         case SummaryConstants.CASHADVANCES:
//			        	 int volumes18 = dto.getVolume();
//			        	 double values18 = dto.getTransactionValue();
//			        	 double feeAmount18 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount18 = dto.getBillingVat();
//			        	 double totalChanges18 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount18 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setCashAdvances(dto.getTransactionDescription());
//			        	 summaryPage.setCashAdvancesCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setCashAdvancesAmount(String.valueOf(dto.getTransactionValue()));
//			        	 summaryPage.setCashAdvancesVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setCashAdvancesInterChange(String.valueOf(feeAmount18 += (feeAmount18+=dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setCashAdvancesTotalCharges(String.valueOf(totalChanges18+=dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setCashAdvancesNetAmount(String.valueOf(netAmount18 +=dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			        	 break;
//
//			         case SummaryConstants.CHARGEBACKSCA:
//			        	 int volumes19 = dto.getVolume();
//			        	 double values19 = dto.getTransactionValue();
//			        	 double feeAmount19 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount19 = dto.getBillingVat();
//			        	 double totalChanges19 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount19 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setChargeBacksCa(dto.getTransactionDescription());
//			        	 summaryPage.setChargeBacksCaCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setChargeBacksCaAmount(String.valueOf(feeAmount19 += dto.getTransactionValue()));
//			        	 summaryPage.setChargeBacksCaVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setChargeBacksCaInterChange(String.valueOf(feeAmount19 += (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setChargeBacksCaTotalCharges(String.valueOf(totalChanges19 += dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setChargeBacksCaNetAmount(String.valueOf(netAmount19 += dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			             break;
//
//			         case SummaryConstants.REVERSALSCA:
//			        	 int volumes20 = dto.getVolume();
//			        	 double values20 = dto.getTransactionValue();
//			        	 double feeAmount20 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double vatAmount20 = dto.getBillingVat();
//			        	 double totalChanges20 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount20 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setReversalsCa(dto.getTransactionDescription());
//			        	 summaryPage.setReversalsCaCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setReversalsCaAmount(String.valueOf(feeAmount20 += dto.getTransactionValue()));
//			        	 summaryPage.setReversalsCaVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setReversalsCaInterChange(String.valueOf(feeAmount20 += (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setReversalsCaTotalCharges(String.valueOf(totalChanges20 += dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setReversalsCaNetAmount(String.valueOf(netAmount20 += dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			        	 break;
//
//			         case SummaryConstants.SUBTOTALSCA:
//			        	 int volumes21 = dto.getVolume();
//			        	 double values21 = dto.getTransactionValue();
//			        	 double vatAmount21 = dto.getBillingVat();
//			        	 double totalChanges21 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 double netAmount21 = dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue();
//			        	 summaryPage.setSubTotalsCa(dto.getTransactionDescription());
//			        	 double feeAmount21 = dto.getBillingFee()+ dto.getBillingFeeAmount();
//			        	 summaryPage.setSubTotalsCaCount(String.valueOf(dto.getVolume()));
//			        	 summaryPage.setSubTotalsCaAmount(String.valueOf(feeAmount21 += dto.getTransactionValue()));
//			        	 summaryPage.setSubTotalsCaVat(String.valueOf(dto.getBillingVat()));
//			        	 summaryPage.setSubTotalsCaInterChange(String.valueOf(feeAmount21 += (dto.getBillingFee()+ dto.getBillingFeeAmount())));
//			        	 summaryPage.setSubTotalsCaTotalCharges(String.valueOf(totalChanges21 += dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()));
//			        	 summaryPage.setSubTotalsCaNetAmount(String.valueOf(netAmount21 += dto.getBillingVat()+dto.getBillingFee()+ dto.getBillingFeeAmount()+dto.getTransactionValue()));
//			             break;
//
//			         default:
//			             throw new IllegalArgumentException("Invalid Card Description for : "+ cardDescription);
//			      }
//			   }
//
//			}
//
//		}
//
//		CCR001AND5ReportsList ccr001AND5ReportsList = new CCR001AND5ReportsList();
//		ccr001AND5ReportsList.setCcr001AND5ReportList(listData);
//
//		JAXBContext jaxbContext = JAXBContext.newInstance(CCR001AND5ReportsList.class);
//		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		jaxbMarshaller.marshal(ccr001AND5ReportsList, System.out);
//		String filepath = BsvTableLookup.getInstance().getSendDir();
//		jaxbMarshaller.marshal(ccr001AND5ReportsList, new File(filepath+File.separator+"CCR005Reports.xml"));
//
//		JAXBContext jaxbContext2 = JAXBContext.newInstance(CCR001AND5ReportsList.class);
//		Unmarshaller jaxbUnmarshaller = jaxbContext2.createUnmarshaller();
//		CCR001AND5ReportsList reportList = (CCR001AND5ReportsList) jaxbUnmarshaller.unmarshal( new File(filepath+File.separator+"CCR005Reports.xml"));
//
//		fw = new FileWriter(filepath+File.separator+
//				"CCR005" +
//				SUB_SERVICE_MNEMONICS.get(subService) +  "." +
//				DATE_FORMAT.format(new Date()) + "." +
//				issuerMemberNo
//				, true);
//		bw= new BufferedWriter(fw);
//
//		HeaderRecord headerRecord2 = new HeaderRecord();
//		headerRecord2.setRecorIdentifier(headerRecord.getRecorIdentifier());
//		headerRecord2.setOutputDate(headerRecord.getOutputDate());
//		headerRecord2.setServiceType(headerRecord.getServiceType());
//		headerRecord2.setSubservice(headerRecord.getSubservice());
//		headerRecord2.setBankMemberNumber(headerRecord.getBankMemberNumber());
//		headerRecord2.setOriginator(headerRecord.getOriginator());
//		headerRecord2.setFileName(headerRecord.getFileName());
//		headerRecord2.setFileNumber(headerRecord.getFileNumber());
//		headerRecord2.setDataType(headerRecord.getDataType());
//		headerRecord2.setDataDirection(headerRecord.getDataDirection());
//		headerRecord2.setSettlementDate(headerRecord.getSettlementDate());
//		headerRecord2.setTestLive(headerRecord.getTestLive());
//		headerRecord2.setRecordSize(headerRecord.getRecordSize());
//		headerRecord2.setFiller(headerRecord.getFiller());
//		bw.write(headerRecord2.toString());
//		bw.newLine();
//		bw.flush();
//
//		boolean header = true;
//
//		for (CCR001AND5Reports ccr001and5Reports2 : reportList.getCcr001AND5ReportList()) {
//			CCR001AND5Reports ccr001AND5ReportsData = new CCR001AND5Reports();
//			try {
//				if(header){
//				TaxRegNumber taxRegNumber1 = new TaxRegNumber();
//				taxRegNumber1.setTaxNumber(taxRegNumber.getTaxNumber());
//				taxRegNumber1.setCompanyRegNumber(taxRegNumber.getCompanyRegNumber());
//				taxRegNumber1.setRegNumber(taxRegNumber.getRegNumber());
//				taxRegNumber1.setNumber(taxRegNumber.getNumber());
//				bw.write(taxRegNumber1.toString());
//				bw.newLine();
//				bw.newLine();
//				bw.flush();
//				TaxInvoiceSubline taxInvoiceSubline1 = new TaxInvoiceSubline();
//				taxInvoiceSubline1.setService(taxInvoice.getService());
//				taxInvoiceSubline1.setSubService(taxInvoice.getSubService());
//				taxInvoiceSubline1.setLineReport(taxInvoice.getLineReport());
//				bw.write(taxInvoiceSubline1.toString());
//				bw.newLine();
//				bw.newLine();
//				bw.flush();
//				ReportLine reportLine1 = new ReportLine();
//				reportLine1.setLine(reportLine.getLine());
//				bw.write(reportLine1.toString());
//				bw.newLine();
//				bw.flush();
//
//				ccr001AND5ReportsData.setTo(ccr001and5Reports2.getFromAddres().getContactName());
//				ccr001AND5ReportsData.setFrom(ccr001and5Reports2.getToAddres().getContactName());
//				bw.newLine();
//				ccr001AND5ReportsData.setToAddress(ccr001and5Reports2.getFromAddres().getMemberAddress1());
//				ccr001AND5ReportsData.setFromAddress(ccr001and5Reports2.getToAddres().getMemberAddress1());
//				bw.newLine();
//				ccr001AND5ReportsData.setToAddress2(ccr001and5Reports2.getFromAddres().getMemberAddress2());
//				ccr001AND5ReportsData.setFromAddress2(ccr001and5Reports2.getToAddres().getMemberAddress2());
//				bw.newLine();
//				ccr001AND5ReportsData.setToAddress3(ccr001and5Reports2.getFromAddres().getMemberAddress3());
//				ccr001AND5ReportsData.setFromAddress3(ccr001and5Reports2.getToAddres().getMemberAddress3());
//				bw.newLine();
//				ccr001AND5ReportsData.setToAddress4(ccr001and5Reports2.getFromAddres().getMemberAddress4());
//				ccr001AND5ReportsData.setFromAddress4(ccr001and5Reports2.getToAddres().getMemberAddress4());
//				bw.newLine();
//				ccr001AND5ReportsData.setToVatRegNo(ccr001and5Reports2.getFromAddres().getVatRegNumber());
//				ccr001AND5ReportsData.setFromVatRegNo(ccr001and5Reports2.getToAddres().getVatRegNumber());
//				bw.newLine();
//
//
//				ccr001AND5ReportsData.setCount("COUNT");
//				ccr001AND5ReportsData.setAmount("AMOUNT");
//				ccr001AND5ReportsData.setInterchange("INTERCHANGE");
//				ccr001AND5ReportsData.setVat("VAT");
//				ccr001AND5ReportsData.setTotalCharge("TOTAL CHARGES");
//				ccr001AND5ReportsData.setNetAmount("NETT AMOUNT");
//				header = false;
//				}
//				ccr001AND5ReportsData.setTransactionTypeDecsription(ccr001and5Reports2.getTransactionTypeDecsription());
//				ccr001AND5ReportsData.setTransCount(ccr001and5Reports2.getTransCount());
//				ccr001AND5ReportsData.setTransAmount(ccr001and5Reports2.getTransAmount());
//				ccr001AND5ReportsData.setTransInterchange(ccr001and5Reports2.getTransInterchange());
//				ccr001AND5ReportsData.setTransVat(ccr001and5Reports2.getTransVat());
//				ccr001AND5ReportsData.setTransTotalCharge(ccr001and5Reports2.getTransTotalCharge());
//				ccr001AND5ReportsData.setTransNetAmount(ccr001and5Reports2.getTransNetAmount());
//
//				ccr001AND5ReportsData.setUnderlines(ccr001and5Reports2.getUnderlines());
//
//				ccr001AND5ReportsData.setSubTotalsAll(ccr001and5Reports2.getSubTotalsAll());
//				ccr001AND5ReportsData.setSubTotalsCount(ccr001and5Reports2.getSubTotalsCount());
//				ccr001AND5ReportsData.setSubTotalsAmount(ccr001and5Reports2.getSubTotalsAmount());
//				ccr001AND5ReportsData.setSubTotalsInterchange(ccr001and5Reports2.getSubTotalsInterchange());
//				ccr001AND5ReportsData.setSubTotalsVat(ccr001and5Reports2.getSubTotalsVat());
//				ccr001AND5ReportsData.setSubTotalsTotalCharges(ccr001and5Reports2.getSubTotalsTotalCharges());
//				ccr001AND5ReportsData.setSubTotalsNetAmount(ccr001and5Reports2.getSubTotalsNetAmount());
//
//				ccr001AND5ReportsData.setUnderlines(ccr001and5Reports2.getUnderlines());
//
//				ccr001AND5ReportsData.setGrandTotalsName(ccr001and5Reports2.getGrandTotalsName());
//				ccr001AND5ReportsData.setGrandTotalsAll(ccr001and5Reports2.getGrandTotalsAll());
//				ccr001AND5ReportsData.setGrandTotalsCountCalc(ccr001and5Reports2.getGrandTotalsCountCalc());
//				ccr001AND5ReportsData.setGrandTotalsAmountCalc(ccr001and5Reports2.getGrandTotalsAmountCalc());
//				ccr001AND5ReportsData.setGrandTotalsInterchangeCalc(ccr001and5Reports2.getGrandTotalsInterchangeCalc());
//				ccr001AND5ReportsData.setGrandTotalsVatCalc(ccr001and5Reports2.getGrandTotalsVatCalc());
//				ccr001AND5ReportsData.setGrandTotalsTotalChargesCalc(ccr001and5Reports2.getGrandTotalsTotalChargesCalc());
//				ccr001AND5ReportsData.setGrandTotalsNetAmountCalc(ccr001and5Reports2.getGrandTotalsNetAmountCalc());
//
//
//				bw.write(ccr001AND5ReportsData.toString());
//				bw.flush();
//				String grandTotals = ccr001and5Reports2.getGrandTotalsName();
//				if(grandTotals != null){
//					if(grandTotals.equals("GRAND TOTALS")){//grandTotalsName){
//						TaxRegNumber taxRegNumber1 = new TaxRegNumber();
//						taxRegNumber1.setTaxNumber(taxRegNumber.getTaxNumber());
//						taxRegNumber1.setCompanyRegNumber(taxRegNumber.getCompanyRegNumber());
//						taxRegNumber1.setRegNumber(taxRegNumber.getRegNumber());
//						taxRegNumber1.setNumber(taxRegNumber.getNumber());
//						bw.write(taxRegNumber1.toString());
//						bw.newLine();
//						bw.newLine();
//						bw.flush();
//						TaxInvoiceSubline taxInvoiceSubline1 = new TaxInvoiceSubline();
//						taxInvoiceSubline1.setService(taxInvoice.getService());
//						taxInvoiceSubline1.setSubService(taxInvoice.getSubService());
//						taxInvoiceSubline1.setLineReport(taxInvoice.getLineReport());
//						bw.write(taxInvoiceSubline1.toString());
//						bw.newLine();
//						bw.newLine();
//						bw.flush();
//						ReportLine reportLine1 = new ReportLine();
//						reportLine1.setLine(reportLine.getLine());
//						bw.write(reportLine1.toString());
//						bw.newLine();
//						bw.flush();
//
//						ccr001AND5ReportsData.setTo(ccr001and5Reports2.getFromAddres().getContactName());
//						ccr001AND5ReportsData.setFrom(ccr001and5Reports2.getToAddres().getContactName());
//						bw.newLine();
//						ccr001AND5ReportsData.setToAddress(ccr001and5Reports2.getFromAddres().getMemberAddress1());
//						ccr001AND5ReportsData.setFromAddress(ccr001and5Reports2.getToAddres().getMemberAddress1());
//						bw.newLine();
//						ccr001AND5ReportsData.setToAddress2(ccr001and5Reports2.getFromAddres().getMemberAddress2());
//						ccr001AND5ReportsData.setFromAddress2(ccr001and5Reports2.getToAddres().getMemberAddress2());
//						bw.newLine();
//						ccr001AND5ReportsData.setToAddress3(ccr001and5Reports2.getFromAddres().getMemberAddress3());
//						ccr001AND5ReportsData.setFromAddress3(ccr001and5Reports2.getToAddres().getMemberAddress3());
//						bw.newLine();
//						ccr001AND5ReportsData.setToAddress4(ccr001and5Reports2.getFromAddres().getMemberAddress4());
//						ccr001AND5ReportsData.setFromAddress4(ccr001and5Reports2.getToAddres().getMemberAddress4());
//						bw.newLine();
//						ccr001AND5ReportsData.setToVatRegNo(ccr001and5Reports2.getFromAddres().getVatRegNumber());
//						ccr001AND5ReportsData.setFromVatRegNo(ccr001and5Reports2.getToAddres().getVatRegNumber());
//						bw.newLine();
//
//							ccr001AND5ReportsData.setCount("COUNT");
//							ccr001AND5ReportsData.setAmount("AMOUNT");
//							ccr001AND5ReportsData.setInterchange("INTERCHANGE");
//							ccr001AND5ReportsData.setVat("VAT");
//							ccr001AND5ReportsData.setTotalCharge("TOTAL CHARGES");
//							ccr001AND5ReportsData.setNetAmount("NETT AMOUNT");
//
//							bw.write(ccr001AND5ReportsData.toString());
//							bw.flush();
//
//							header = false;
//						}
//					}
//
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//			 SummaryPage page = new SummaryPage();
//
//			 page.setAmount("AMOUNT");
//			 page.setVat("VAT");
//			 page.setCount("COUNT");
//			 page.setTotalCharges("TOTAL CHARGES");
//			 page.setNetAmount("NETT AMOUNT");
//			 page.setInterchange("INTERCHANGE");
//
//			 page.setSalesDraft(summaryPage.getSalesDraft());
//			 page.setAmountValue(summaryPage.getAmountValue());
//			 page.setVatValue(summaryPage.getVatValue());
//			 page.setCountValue(summaryPage.getCountValue());
//			 page.setTotalChargesValue(summaryPage.getTotalChargesValue());
//			 page.setNetAmountValue(summaryPage.getNetAmountValue());
//			 page.setInterchangeValue(summaryPage.getInterchangeValue());
//
//			 page.setSalesDraft(summaryPage.getSalesDraft());
//			 page.setSalesDraftAmount(summaryPage.getSalesDraftAmount());
//			 page.setSalesDraftCount(summaryPage.getSalesDraftCount());
//			 page.setSalesDraftInterChange(summaryPage.getSalesDraftInterChange());
//			 page.setSalesDraftNetAmount(summaryPage.getSalesDraftNetAmount());
//			 page.setSalesDraftTotalCharges(summaryPage.getSalesDraftTotalCharges());
//			 page.setSalesDraftVat(summaryPage.getSalesDraftVat());
//
//			 //page.set
//			 page.setCashAdvances(summaryPage.getCashAdvances());
//			 page.setCashAdvancesAmount(summaryPage.getCashAdvancesAmount());
//			 page.setCashAdvancesCount(summaryPage.getCashAdvancesCount());
//			 page.setCashAdvancesInterChange(summaryPage.getCashAdvancesInterChange());
//			 page.setCashAdvancesNetAmount(summaryPage.getCashAdvancesNetAmount());
//			 page.setCashAdvancesTotalCharges(summaryPage.getCashAdvancesTotalCharges());
//			 page.setCashAdvancesVat(summaryPage.getCashAdvancesVat());
//
//			 page.setCashBackNoP(summaryPage.getCashBackNoP());
//			 page.setCashBackNoPAmount(summaryPage.getCashBackNoPAmount());
//			 page.setCashBackNoPCount(summaryPage.getCashBackNoPCount());
//			 page.setCashBackNoPInterChange(summaryPage.getCashBackNoPInterChange());
//			 page.setCashBackNoPNetAmount(summaryPage.getCashBackNoPTotalCharges());
//			 page.setCashBackNoPTotalCharges(summaryPage.getCashBackNoPTotalCharges());
//			 page.setCashBackNoPVat(summaryPage.getCashBackNoPVat());
//
//			 page.setCashBackOnPR(summaryPage.getCashBackOnPR());
//			 page.setCashBackOnPRAmount(summaryPage.getCashBackOnPRAmount());
//			 page.setCashBackOnPRCount(summaryPage.getCashBackOnPRCount());
//			 page.setCashBackOnPRInterChange(summaryPage.getCashBackOnPRInterChange());
//			 page.setCashBackOnPRNetAmount(summaryPage.getCashBackOnPRNetAmount());
//			 page.setCashBackOnPRTotalCharges(summaryPage.getCashBackOnPRTotalCharges());
//			 page.setCashBackOnPRVat(summaryPage.getCashBackOnPRVat());
//
//			 page.setCashBackWPurc(summaryPage.getCashBackWPurc());
//			 page.setCashBackWPurcAmount(summaryPage.getCashBackWPurcAmount());
//			 page.setCashBackWPurcCount(summaryPage.getCashBackWPurcCount());
//			 page.setCashBackWPurcInterChange(summaryPage.getCashBackWPurcInterChange());
//			 page.setCashBackWPurcNetAmount(summaryPage.getCashBackWPurcNetAmount());
//			 page.setCashBackWPurcTotalCharges(summaryPage.getCashBackWPurcTotalCharges());
//			 page.setCashBackWPurcVat(summaryPage.getCashBackWPurcVat());
//
//			 page.setChargeBackCas(summaryPage.getChargeBackCas());
//			 page.setChargeBackCasAmount(summaryPage.getChargeBackCasAmount());
//			 page.setChargeBackCasCount(summaryPage.getChargeBackCasCount());
//			 page.setChargeBackCashTotalCharges(summaryPage.getChargeBackCashTotalCharges());
//			 page.setChargeBackCasInterChange(summaryPage.getChargeBackCasInterChange());
//			 page.setChargeBackCasNetAmount(summaryPage.getChargeBackCasNetAmount());
//			 page.setChargeBackCasVat(summaryPage.getChargeBackCasVat());
//
//			 page.setChargeBacksCa(summaryPage.getChargeBacksCa());
//			 page.setChargeBacksCaAmount(summaryPage.getChargeBacksCaAmount());
//			 page.setChargeBacksCaCount(summaryPage.getChargeBacksCaCount());
//			 page.setChargeBacksCaInterChange(summaryPage.getChargeBacksCaInterChange());
//			 page.setChargeBacksCaNetAmount(summaryPage.getChargeBacksCaNetAmount());
//			 page.setChargeBacksCaTotalCharges(summaryPage.getChargeBacksCaTotalCharges());
//			 page.setChargeBacksCaVat(summaryPage.getChargeBacksCaVat());
//
//			 page.setChargeBacksCv(summaryPage.getChargeBacksCv());
//			 page.setChargeBacksCvAmount(summaryPage.getChargeBacksCvAmount());
//			 page.setChargeBacksCvCount(summaryPage.getChargeBacksCvCount());
//			 page.setChargeBacksCvInterChange(summaryPage.getChargeBacksCvInterChange());
//			 page.setChargeBacksCvNetAmount(summaryPage.getChargeBacksCvNetAmount());
//			 page.setChargeBacksCvTotalCharges(summaryPage.getChargeBacksCvTotalCharges());
//			 page.setChargeBacksCvVat(summaryPage.getChargeBacksCvVat());
//
//			 page.setReversalsPs(summaryPage.getReversalsPs());
//			 page.setReversalsPsAmount(summaryPage.getReversalsPsAmount());
//			 page.setReversalsPsCount(summaryPage.getReversalsPsCount());
//			 page.setReversalsPsInterChange(summaryPage.getReversalsPsInterChange());
//			 page.setReversalsPsNetAmount(summaryPage.getReversalsPsNetAmount());
//			 page.setReversalsPsTotalCharges(summaryPage.getReversalsPsTotalCharges());
//			 page.setReversalsPsVat(summaryPage.getReversalsPsVat());
//
//			 page.setChargeBacksSd(summaryPage.getChargeBacksSd());
//			 page.setChargeBacksSdAmount(summaryPage.getChargeBacksSdAmount());
//			 page.setChargeBacksSdCount(summaryPage.getChargeBacksSdCount());
//			 page.setChargeBacksSdInterChange(summaryPage.getChargeBacksSdInterChange());
//			 page.setChargeBacksSdNetAmount(summaryPage.getChargeBacksSdNetAmount());
//			 page.setChargeBacksSdTotalCharges(summaryPage.getChargeBacksSdTotalCharges());
//			 page.setChargeBacksSdVat(summaryPage.getChargeBacksSdVat());
//
//		 	bw.write(page.toString());
//		 	bw.flush();
//
//		 	FooterRecord footerRecord1 = new FooterRecord();
//			footerRecord1.setRecorIdentifier(footerRecord.getRecorIdentifier());
//			footerRecord1.setOutputDate(footerRecord.getOutputDate());
//			footerRecord1.setServiceType(footerRecord.getServiceType());
//			footerRecord1.setSubServiceType(footerRecord.getSubServiceType());
//			footerRecord1.setBankMemberNumber(footerRecord.getBankMemberNumber());
//			footerRecord1.setNumberOfTransmissionFiles(footerRecord.getNumberOfTransmissionFiles());
//			footerRecord1.setNumberOfCreditRecords(footerRecord.getNumberOfCreditRecords());
//			footerRecord1.setNumberOfDebitRecords(footerRecord.getNumberOfDebitRecords());
//			footerRecord1.setValueOfCreditRecords(footerRecord.getValueOfCreditRecords());
//			footerRecord1.setValueOfDebitRecords(footerRecord.getValueOfDebitRecords());
//			footerRecord1.setHashTotalOfAccount(footerRecord.getHashTotalOfAccount());
//			footerRecord1.setFiller(footerRecord.getFiller());
//
//			bw.write(footerRecord1.toString());
//			bw.flush();
//
//			try{
//				File file = new File(filepath+File.separator+
//						"CCR005" +
//						SUB_SERVICE_MNEMONICS.get(subService) +  "." +
//						DATE_FORMAT.format(new Date()) + "." +
//						issuerMemberNo
//						);
//				boolean bol = file.delete();
//				log.debug("Is File deleted :" + bol);
//
//			}catch(Exception ex){
//				log.debug(ex.getMessage());
//			}
//
//
//	    }
//		catch(Exception ex){
//			log.debug(ex.getMessage());
//		}
//		finally{
//		if (bw != null){
//				try {
//					bw.close();
//				} catch (IOException e) {
//					log.error(e.getMessage() , e);
//				}
//		}else if (fw != null){
//			try {
//				fw.close();
//			} catch (IOException e) {
//				log.error(e.getMessage() , e);
//			}
//		  }
//	  }
//
//	}
//
//
//		public CSFMemberServiceDTO getMembers(int oneOrfive){
//
//				CSFMemberServiceDTO csfMemberServiceDTO = new CSFMemberServiceDTO();
//				List<CSFMemberServiceDTO> csfMemberServiceList  = BsvTableLookup.getInstance().getCsfMemberService();
//				csfMemberServiceList2 = new ArrayList<>();
//				for(CSFMemberServiceDTO csfMemberService : csfMemberServiceList){
//					if (oneOrfive == csfMemberService.getBankCode() && (csfMemberService.getSubService().equals("VISA CARD"))) {
//					csfMemberServiceDTO.setAccountNumber(csfMemberService.getAccountNumber());
//					csfMemberServiceDTO.setAcquirerInd(csfMemberService.getAcquirerInd());
//					csfMemberServiceDTO.setBankCode(csfMemberService.getBankCode());
//					csfMemberServiceDTO.setBranchCode(csfMemberService.getBranchCode());
//					csfMemberServiceDTO.setContactName(csfMemberService.getContactName());
//					csfMemberServiceDTO.setCountry(csfMemberService.getCountry());
//					csfMemberServiceDTO.setCurrencyCodeValidationReq(csfMemberService.getCurrencyCodeValidationReq());
//					csfMemberServiceDTO.setExceptionReportInd(csfMemberService.getExceptionReportInd());
//					csfMemberServiceDTO.setHeader01RecordLength(csfMemberService.getHeader01RecordLength());
//					csfMemberServiceDTO.setInputCharset(csfMemberService.getInputCharset());
//					csfMemberServiceDTO.setInvoiceNoCCR001(csfMemberService.getInvoiceNoCCR001());
//					csfMemberServiceDTO.setIssuerInd(csfMemberService.getIssuerInd());
//					csfMemberServiceDTO.setMaxSizeTransFile(csfMemberService.getMaxSizeTransFile());
//					csfMemberServiceDTO.setMemberAddress1(csfMemberService.getMemberAddress1());
//					csfMemberServiceDTO.setMemberAddress2(csfMemberService.getMemberAddress2());
//					csfMemberServiceDTO.setMemberAddress3(csfMemberService.getMemberAddress3());
//					csfMemberServiceDTO.setMemberAddress4(csfMemberService.getMemberAddress4());
//					csfMemberServiceDTO.setMemberNo(csfMemberService.getMemberNo());
//					csfMemberServiceDTO.setOutputCharset(csfMemberService.getOutputCharset());
//					csfMemberServiceDTO.setMemberTapeid(csfMemberService.getMemberTapeid());
//					csfMemberServiceDTO.setOutputInd(csfMemberService.getOutputInd());
//					csfMemberServiceDTO.setService(csfMemberService.getService());
//					csfMemberServiceDTO.setSubService(csfMemberService.getSubService());
//					csfMemberServiceDTO.setTitle(csfMemberService.getTitle());
//					csfMemberServiceDTO.setTrailer98RecordLength(csfMemberService.getTrailer98RecordLength());
//					csfMemberServiceDTO.setTrailer99RecordLength(csfMemberService.getTrailer99RecordLength());
//					csfMemberServiceDTO.setVatRegNumber(csfMemberService.getVatRegNumber());
//
//					csfMemberServiceList2.add(csfMemberServiceDTO);
//					return csfMemberServiceDTO;
//				}
//			}
//					return csfMemberServiceDTO;
//		//fileName = "CCR00" + oneOrFive + subService.charAt(0) + procDate + "." + Utils.padZeroLeft(currIss + "", 4) +  ft.format(dNow) + ".xml";
//
//	}
//
//
//
//
//
//
//	public HashMap<String, String> getBankAddres() throws Exception {
//
//		HashMap<String,String> retHM = new HashMap<String,String>();
//
//		List<CSFMemberServiceDTO> dtolist = buildBankAddresReference();
//
//		for(CSFMemberServiceDTO dto : dtolist){
//			if (dto!=null) {
//				retHM.put("branch_code",  dto.getBranchCode());
//				retHM.put("account_no", dto.getAccountNumber());
//				retHM.put("contact_name", dto.getContactName());
//				retHM.put("mem_address1", dto.getMemberAddress1());
//				retHM.put("mem_address2", dto.getMemberAddress2());
//				retHM.put("mem_address3", dto.getMemberAddress3());
//				retHM.put("mem_address4", dto.getMemberAddress4());
//				retHM.put("vat_reg_no",   dto.getVatRegNumber());
//
//			} else {
//				retHM.put("branch_code", " ");
//				retHM.put("account_no", " ");
//				retHM.put("contact_name", " ");
//				retHM.put("mem_address1", " ");
//				retHM.put("mem_address2", " ");
//				retHM.put("mem_address3", " ");
//				retHM.put("mem_address4", " ");
//				retHM.put("vat_reg_no", " ");
//			}
//		}
//
//		return retHM;
//	}
//
//	public List<CSFMemberServiceDTO> buildBankAddresReference() throws DAOException{
//
//		for(CSFMemberServiceDTO csfMemberService : csfMemberServiceList2){
//
//			if (csfMemberService!=null){
//
//				csfMemberService.getBankCode();
//				csfMemberService.getBranchCode();
//				csfMemberService.getAccountNumber();
//				csfMemberService.getContactName();
//				csfMemberService.getMemberAddress1();
//				csfMemberService.getMemberAddress2();
//				csfMemberService.getMemberAddress3();
//				csfMemberService.getMemberAddress4();
//				csfMemberService.getVatRegNumber();
//			}
//		}
//		return csfMemberServiceList2;
//
//	}
//
//}
//

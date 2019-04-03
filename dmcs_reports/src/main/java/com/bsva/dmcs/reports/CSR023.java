//package com.bsva.dmcs.reports;
//
//import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
//import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.ScheduledFuture;
//import java.util.concurrent.TimeUnit;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerConfigurationException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.TransformerFactoryConfigurationError;
//
//import org.apache.log4j.Logger;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//
//import com.bsva.dcms.commons.dto.file.ErrorDTO;
//import com.bsva.dcms.commons.exceptions.DAOException;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dcms.commons.util.Csr023TotalCalculations;
//import com.bsva.dcms.commons.util.Utils;
//import com.bsva.entities.CsoInputFileControls;
//import java.io.File;
//
///*
// * This will contain the first 100 rejected transactions
// *
// */
//public class CSR023 implements DMCSReportInterface{
//
//	private ReportUtils ru = null;
//	private BsvTableLookup bsvTableInstance = BsvTableLookup.getInstance();
//	private Csr023TotalCalculations cso23TotCalculations = null;
//	private ErrorDTO errorDto;
//	private List<String> reportNames;
//	private String reportPath = null;
//	private Logger log = Logger.getLogger(CSR023.class);
//
//	public CSR023(Csr023TotalCalculations cso23TotCalculations){
//
//		this.ru = ReportUtils.getInstance(cso23TotCalculations.getProcessDate());
//		this.cso23TotCalculations = cso23TotCalculations;
//		this.reportNames = new ArrayList<String>();
//		this.reportPath = bsvTableInstance.getReportsDir();
//	}
//
//	public void build() throws ParserConfigurationException, TransformerConfigurationException, TransformerFactoryConfigurationError, DAOException{
//
//		log.debug("Building CSR023 report for " + cso23TotCalculations.getFileName());
//
//		DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
//        DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
//        Document doc = docBuilder.newDocument();
//
//        Transformer trans = TransformerFactory.newInstance().newTransformer();
//        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
//        trans.setOutputProperty(OutputKeys.INDENT, "yes");
//
//        String companyName = BsvTableLookup.getInstance().getCompanyName();
//        String companyRegNo = BsvTableLookup.getInstance().getRegistrationNumber();
//
//        String procDate = BsvTableLookup.getInstance().getProcessDate();
//        String procDateStr = procDate.substring(0,4) + File.separator + procDate.substring(4,6) +  File.separator + procDate.substring(6);
//
//        Element reportContentEl = doc.createElement("reportContent");
//
//        Element compName = doc.createElement("companyName");
//        compName.appendChild(ru.getTextEl(doc,companyName));
//        reportContentEl.appendChild(compName);
//
//        Element compRegNo = doc.createElement("CompanyRegNumber");
//        compRegNo.appendChild(ru.getTextEl(doc,companyRegNo));
//        reportContentEl.appendChild(compRegNo);
//
//        Element procDateEl = doc.createElement("processDate");
//        procDateEl.appendChild(ru.getTextEl(doc,procDateStr));
//        reportContentEl.appendChild(procDateEl);
//
//        Element procDateEl2 = doc.createElement("processDate2");
//        procDateEl2.appendChild(ru.getTextEl(doc,procDate));
//        reportContentEl.appendChild(procDateEl2);
//
//        Element fileOriginatorElement = doc.createElement("fileOriginatorID");
//        fileOriginatorElement.appendChild(ru.getTextEl(doc,String.format("%04d", cso23TotCalculations.getFileOriginatorID())));
//        reportContentEl.appendChild(fileOriginatorElement);
//
//        Element serviceEl = doc.createElement("service");
//        serviceEl.appendChild(ru.getTextEl(doc,cso23TotCalculations.getService()));
//        reportContentEl.appendChild(serviceEl);
//
//        Element subServEl = doc.createElement("subService");
//        log.debug("cso23TotCalculations.getSubService()"+ cso23TotCalculations.getSubService());
//        subServEl.appendChild(ru.getTextEl(doc,cso23TotCalculations.getSubService()));
//        reportContentEl.appendChild(subServEl);
//
//        Element fileNameEl = doc.createElement("bsvFileName");
//        fileNameEl.appendChild(ru.getTextEl(doc,cso23TotCalculations.getFileName()));
//        reportContentEl.appendChild(fileNameEl);
//
//        errorDto = cso23TotCalculations.getErrorDto();
//
//        Element lineCountEl = doc.createElement("lineCount");
//        lineCountEl.appendChild(ru.getTextEl(doc,String.format("%06d", errorDto.getErrorsList().size() + 31)));
//        reportContentEl.appendChild(lineCountEl);
//
//        if (errorDto != null) {
//            Element fileRejections = doc.createElement("fileRejections");
//
//            int errCounter = 0;
//            int errListSize = errorDto.getErrorsList().size();
//            if (errListSize > 100) {
//                errListSize = 100;  // we only need the first 100 for csr023
//            }
//
//            while (errCounter < errListSize ) {
//                fileRejections.appendChild(createErrorElement(doc , errCounter));
//                errCounter++;
//            }
//
//            reportContentEl.appendChild(fileRejections);
//            if (errCounter == 100) {
//                Element reportMessEl = doc.createElement("reportMessage");
//                reportMessEl.appendChild(ru.getTextEl(doc,"ERRORS PRINTED EXCEEDS 100 - VALIDATION WILL CONTINUE"));
//                reportContentEl.appendChild(reportMessEl);
//            }
//        }
//
//        Element totalAcceptedDebitVolume = doc.createElement("totAccDrVol");
//        totalAcceptedDebitVolume.appendChild(ru.getTextEl(doc,Utils.formatInteger(cso23TotCalculations.getTotAccDrVol(),13)));
//        reportContentEl.appendChild(totalAcceptedDebitVolume);
//
//        long debitValue = cso23TotCalculations.getTotAccDrVal();
//        Element totalAcceptedDebitValue = doc.createElement("totAccDrVal");
//        totalAcceptedDebitValue.appendChild(ru.getTextEl(doc,Utils.formatAmount(debitValue,18)));
//        reportContentEl.appendChild(totalAcceptedDebitValue);
//
//        Element totalRejectedDebitVolume = doc.createElement("totRejDrVol");
//        totalRejectedDebitVolume.appendChild(ru.getTextEl(doc,Utils.formatInteger(cso23TotCalculations.getTotRejDrVol(),13)));
//        reportContentEl.appendChild(totalRejectedDebitVolume);
//
//        long rejectDebitValue = cso23TotCalculations.getTotRejDrVal();
//        Element totalRejectedDebitValue = doc.createElement("totRejDrVal");
//        totalRejectedDebitValue.appendChild(ru.getTextEl(doc,Utils.formatAmount(rejectDebitValue,18)));
//        reportContentEl.appendChild(totalRejectedDebitValue);
//
//        Element totalAcceptedCreditVolume = doc.createElement("totAccCrVol");
//        totalAcceptedCreditVolume.appendChild(ru.getTextEl(doc,Utils.formatInteger(cso23TotCalculations.getTotAccCrVol(),13)));
//        reportContentEl.appendChild(totalAcceptedCreditVolume);
//
//        long creditValue = cso23TotCalculations.getTotAccCrVal();
//        Element totalAcceptedCreditValue = doc.createElement("totAccCrVal");
//        totalAcceptedCreditValue.appendChild(ru.getTextEl(doc,Utils.formatAmount(creditValue,18)));
//        reportContentEl.appendChild(totalAcceptedCreditValue);
//
//        Element totalRejectedCreditVolume = doc.createElement("totRejCrVol");
//        totalRejectedCreditVolume.appendChild(ru.getTextEl(doc,Utils.formatInteger(cso23TotCalculations.getTotRejCrVol(),13)));
//        reportContentEl.appendChild(totalRejectedCreditVolume);
//
//        long rejectCreditValue = cso23TotCalculations.getTotRejCrVal();
//        Element totalRejectedCreditValue = doc.createElement("totRejCrVal");
//        totalRejectedCreditValue.appendChild(ru.getTextEl(doc,Utils.formatAmount(rejectCreditValue,18)));
//        reportContentEl.appendChild(totalRejectedCreditValue);
//
//        Element totalAcceptedFinancialRecords = doc.createElement("totAccFinRecs");
//        totalAcceptedFinancialRecords.appendChild(ru.getTextEl(doc,Utils.formatInteger(cso23TotCalculations.getTotalAcceptedFinRecords(),13)));
//        reportContentEl.appendChild(totalAcceptedFinancialRecords);
//
//        Element totalRejFinancialRecords = doc.createElement("totRejFinRecs");
//        totalRejFinancialRecords.appendChild(ru.getTextEl(doc,Utils.formatInteger(cso23TotCalculations.getTotalRejectedFinRecords(),13)));
//        reportContentEl.appendChild(totalRejFinancialRecords);
//
//        Element totalAcceptedNonFinancialRecords = doc.createElement("totAccNonFinRecs");
//        totalAcceptedNonFinancialRecords.appendChild(ru.getTextEl(doc,Utils.formatInteger(cso23TotCalculations.getTotalAcceptedNonFinRecords(),13)));
//        reportContentEl.appendChild(totalAcceptedNonFinancialRecords);
//
//        Element totalRejNonFinancialRecords = doc.createElement("totRejNonFinRecs");
//        totalRejNonFinancialRecords.appendChild(ru.getTextEl(doc,Utils.formatInteger(cso23TotCalculations.getTotalRejectedNonFinRecords(),13)));
//        reportContentEl.appendChild(totalRejNonFinancialRecords);
//
//        Element totalNegRecords = doc.createElement("totNegativeRecords");
//        totalNegRecords.appendChild(ru.getTextEl(doc,Utils.formatInteger(cso23TotCalculations.getTotalNegativeCards(),13)));
//        reportContentEl.appendChild(totalNegRecords);
//
//        Element totalControlRecords = doc.createElement("totControlRecords");
//        totalControlRecords.appendChild(ru.getTextEl(doc,Utils.formatInteger(cso23TotCalculations.getTotalControlRecords(),13)));
//        reportContentEl.appendChild(totalControlRecords);
//
//        Element totalAcceptedRecords = doc.createElement("totAcceptedRecs");
//        totalAcceptedRecords.appendChild(ru.getTextEl(doc,Utils.formatInteger(cso23TotCalculations.getTotalAcceptedRecords(),13)));
//        reportContentEl.appendChild(totalAcceptedRecords);
//
//        Element totalRejectedRecords = doc.createElement("totRejectedRecs");
//        totalRejectedRecords.appendChild(ru.getTextEl(doc,Utils.formatInteger(cso23TotCalculations.getTotalRejectedRecords(),13)));
//        reportContentEl.appendChild(totalRejectedRecords);
//
//        doc.appendChild(reportContentEl);
//
//        //  String fileName = "CSR023" + cso23TotCalculations.getSubService().substring(0,1) + "."+ cso23TotCalculations.getFileName() + ".xml";
//        String fileName = "CSR023"+ "."+ cso23TotCalculations.getFileName() + ".xml";
//        if (reportPath == null) {
//            reportPath = cso23TotCalculations.getOutputDirectory();
//        }
//
//        reportNames = ru.writeReport(doc, reportContentEl, fileName, reportNames);
//
//	}
//
//	 private Element createErrorElement(Document doc , int index) {
//	        HashMap<String, String> tmpErr = errorDto.getNextValidationError(index);
//	        Element errorEl = doc.createElement("error");
//
//	        Element recordIdEl = doc.createElement("errorRecordId");
//	        recordIdEl.appendChild(ru.getTextEl(doc,(String)tmpErr.get("recordID")));
//	        errorEl.appendChild(recordIdEl);
//	        recordIdEl = null;
//
//	        Element recordNoEl = doc.createElement("errorRecordNo");
//	        recordNoEl.appendChild(ru.getTextEl(doc,(String)tmpErr.get("recordNo")));
//	        errorEl.appendChild(recordNoEl);
//	        recordNoEl = null;
//
//	        Element rejectNoEl = doc.createElement("errorRejNo");
//	        rejectNoEl.appendChild(ru.getTextEl(doc,(String)tmpErr.get("fieldNo")));
//	        errorEl.appendChild(rejectNoEl);
//	        rejectNoEl = null;
//
//	        Element errDescEl = doc.createElement("errorDescription");
//	        int errNo = Integer.parseInt(tmpErr.get("errorNo"));
//
//	        if (errNo != 0) {
//	            errDescEl.appendChild(ru.getTextEl(doc,
//	            		BsvTableLookup.getInstance().getCsfErrorCodes().get(String.valueOf(errNo)).getErrorMessage()));
//	        } else {
//	            errDescEl.appendChild(ru.getTextEl(doc,
//	                "Unknown Error"));
//	        }
//	        errorEl.appendChild(errDescEl);
//	        errDescEl = null;
//
//	        Element fieldContentEl = doc.createElement("fieldContent");
//	        fieldContentEl.appendChild(ru.getTextEl(doc,(String)tmpErr.get("fieldContent")));
//	        errorEl.appendChild(fieldContentEl);
//	        fieldContentEl = null;
//
//	        return errorEl;
//	    }
//
//	 @Override
//	public void printTextFile(){
//
//		 DMCSReportXML2TXTthread xml2txtLst = new DMCSReportXML2TXTthread(this);
//
//		 ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//		 ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(xml2txtLst,1,TimeUnit.SECONDS);
//
//		 DMCSReportXML2TXTthread xml2txtLst2 = new DMCSReportXML2TXTthread(this);
//	     new Thread(xml2txtLst2).start();
//	}
//
//	@Override
//	public List<String> getListOfReportNames() {
//		// TODO Auto-generated method stub
//		return reportNames;
//	}
//}

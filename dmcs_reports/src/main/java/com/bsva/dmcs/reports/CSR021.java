//package com.bsva.dmcs.reports;
//
//import org.apache.log4j.Logger;
//import org.w3c.dom.*;
//
//import com.bsva.dcms.commons.dto.file.ErrorDTO;
//import com.bsva.dcms.commons.dto.file.FileDTO;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dcms.commons.util.Utils;
//import java.io.File;
//
//import javax.xml.parsers.*;
//import javax.xml.transform.*;
//
//import java.util.*;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.ScheduledFuture;
//import java.util.concurrent.TimeUnit;
//import java.text.*;
//
///**
// *
// * @author RinusE
// * We produce this report when the entire file has been rejected e.g fatal error with the header/trailor of the file
// * It contains all the errors encountered in the file
// */
//public class CSR021 implements DMCSReportInterface {
//
//	private String reportPath = null;
//    private ReportUtils ru = null;
//    private List<String> reportNames;
//    private BsvTableLookup bsvTableInstance = BsvTableLookup.getInstance();
//    private ErrorDTO errorDto;
//    private FileDTO fileDto;
//    private Logger log = Logger.getLogger(CSR021.class);
//
//    public List<String> getListOfReportNames() {
//        return reportNames;
//    }
//    public void printTextFile(){
//
//   	 	DMCSReportXML2TXTthread xml2txtLst = new DMCSReportXML2TXTthread(this);
//
//   	 	ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//   	 	ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(xml2txtLst,1,TimeUnit.SECONDS);
//
////    	 DMCSReportXML2TXTthread xml2txtLst = new DMCSReportXML2TXTthread(this);
////	     new Thread(xml2txtLst).start();
//    }
//
//    public CSR021(FileDTO filedto){
//
//    	this.ru = ReportUtils.getInstance(bsvTableInstance.getProcessDate());
//    	this.reportPath = bsvTableInstance.getReportsDir();
//    	this.reportNames = new ArrayList<String>();
//    	this.fileDto = filedto;
//    }
//
//    public void build() throws ParserConfigurationException, TransformerConfigurationException, TransformerFactoryConfigurationError {
//
//    	log.debug("Building CSR021 report for " + fileDto.getFileName());
//
//        DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
//        DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
//        Document doc = docBuilder.newDocument();
//
//        Transformer trans = TransformerFactory.newInstance().newTransformer();
//        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
//        trans.setOutputProperty(OutputKeys.INDENT, "yes");
//
//        String companyName = bsvTableInstance.getCompanyName();
//        String companyRegNo = bsvTableInstance.getRegistrationNumber();
//
//        String procDate = bsvTableInstance.getProcessDate();
//        String procDateStr = procDate.substring(0,4) + File.separator + procDate.substring(4,6) + File.separator + procDate.substring(6);
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
//        Element serviceEl = doc.createElement("service");
//        serviceEl.appendChild(ru.getTextEl(doc,fileDto.getFileService()));
//        reportContentEl.appendChild(serviceEl);
//
//        Element subServEl = doc.createElement("subService");
//        subServEl.appendChild(ru.getTextEl(doc,fileDto.getFileSubService()));
//        reportContentEl.appendChild(subServEl);
//
//        Element fileNameEl = doc.createElement("bsvFileName");
//        fileNameEl.appendChild(ru.getTextEl(doc,fileDto.getFileName()));
//        reportContentEl.appendChild(fileNameEl);
//
//        errorDto = fileDto.getErrorDto();
//
//        if (errorDto != null) {
//            Element fileRejections = doc.createElement("fileRejectReason");
//
//            int errCounter = 0;
//            int errListSize = errorDto.getErrorsList().size();
//
//            while (errCounter < errListSize ) {
//                fileRejections.appendChild(createErrorElement(doc ,errCounter ));
//                errCounter++;
//            }
//
//            reportContentEl.appendChild(fileRejections);
//        }
//        doc.appendChild(reportContentEl);
//
//        String fileName = "CSR021" + fileDto.getFileSubService().substring(0,1) + "."
//                        + fileDto.getFileName() + ".xml";
//
//        if (reportPath == null) {
//            reportPath = bsvTableInstance.getReportsDir();
//        }
////        reportNames.add(reportPath + File.separator + fileName);
//        reportNames = ru.writeReport(doc , reportContentEl , fileName , reportNames);
//
//    }
//    private Element createErrorElement(Document doc , int index) {
//        HashMap<String, String> tmpErr = errorDto.getNextValidationError(index);
//        Element errorEl = doc.createElement("error");
//
//        Element recordIdEl = doc.createElement("errorRecordId");
//        recordIdEl.appendChild(ru.getTextEl(doc,(String)tmpErr.get("recordID")));
//        errorEl.appendChild(recordIdEl);
//        recordIdEl = null;
//
//        Element recordNoEl = doc.createElement("errorRecordNo");
//        recordNoEl.appendChild(ru.getTextEl(doc,(String)tmpErr.get("recordNo")));
//        errorEl.appendChild(recordNoEl);
//        recordNoEl = null;
//
//        Element rejectNoEl = doc.createElement("errorRejNo");
//        rejectNoEl.appendChild(ru.getTextEl(doc,(String)tmpErr.get("fieldNo")));
//        errorEl.appendChild(rejectNoEl);
//        rejectNoEl = null;
//
//        Element errDescEl = doc.createElement("errorDescription");
//        int errNo = Integer.parseInt(tmpErr.get("errorNo"));
//
//        if (errNo != 0) {
//            errDescEl.appendChild(ru.getTextEl(doc,
//            		bsvTableInstance.getCsfErrorCodes().get(String.valueOf(errNo)).getErrorMessage()));
//        } else {
//            errDescEl.appendChild(ru.getTextEl(doc,
//                "Unknown Error"));
//        }
//        errorEl.appendChild(errDescEl);
//        errDescEl = null;
//
//        Element fieldContentEl = doc.createElement("fieldContent");
//        fieldContentEl.appendChild(ru.getTextEl(doc,(String)tmpErr.get("fieldContent")));
//        errorEl.appendChild(fieldContentEl);
//        fieldContentEl = null;
//
//        return errorEl;
//    }
//}

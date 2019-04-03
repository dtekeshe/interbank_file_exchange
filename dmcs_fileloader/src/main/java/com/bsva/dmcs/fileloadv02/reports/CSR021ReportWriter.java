package com.bsva.dmcs.fileloadv02.reports;

import com.bsva.dmcs.fileloadv02.dto.CSR021Data;
import com.bsva.dmcs.fileloadv02.dto.ErrorDTO;
import com.bsva.dmcs.fileloadv02.dto.FileRejectReasonDTO;
import com.bsva.dmcs.fileloadv02.util.XMLGenerator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Generated when the entire file has been rejected
 * e.g fatal error with the header/trailer of the file
 *
 */
public class CSR021ReportWriter {

    private final String reportsPath;

    public CSR021ReportWriter(String reportsPath) {
        this.reportsPath = reportsPath;
    }

    public void write( String filename,
                      String serviceID,
                      String subServiceID,
                      List<ErrorDTO> errors,
                      String companyName,
                      String registrationNumber) {

        // TODO determine date
        Date processDate = null;

        CSR021Data csr021Data
                = new CSR021Data(
                            companyName,
                            registrationNumber,
                            processDate,
                            serviceID,
                            subServiceID,
                            filename,
                            new FileRejectReasonDTO(errors));

        XMLGenerator<CSR021Data> generator = new XMLGenerator();
        try {
            String reportName = csr021Filename(filename, subServiceID);

            generator.generate(reportsPath, reportName, csr021Data);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

//    private String reportPath = null;
//    private ReportUtils ru = null;
//    private List<String> reportNames;
//    private BsvTableLookup bsvTableInstance = BsvTableLookup.getInstance();
//    private ErrorDTO errorDto;
//    private FileDTO fileDto;
//
//    public List<String> getListOfReportNames() {
//        return reportNames;
//    }
//    public void printTextFile(){
//
//        DMCSReportXML2TXTthread xml2txtLst = new DMCSReportXML2TXTthread(this);
//
//        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(xml2txtLst,1, TimeUnit.SECONDS);
//
////    	 DMCSReportXML2TXTthread xml2txtLst = new DMCSReportXML2TXTthread(this);
////	     new Thread(xml2txtLst).start();
//    }
//
//    public CSR021ReportGenerator(FileDTO filedto){
//
//        this.ru = ReportUtils.getInstance(bsvTableInstance.getProcessDate());
//        this.reportPath = bsvTableInstance.getReportsDir();
//        this.reportNames = new ArrayList<String>();
//        this.fileDto = filedto;
//    }
//
//    public void build() throws ParserConfigurationException, TransformerConfigurationException, TransformerFactoryConfigurationError {
//
//        log.debug("Building CSR021 report for " + fileDto.getFileName());
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
//                + fileDto.getFileName() + ".xml";
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
//                    bsvTableInstance.getCsfErrorCodes().get(String.valueOf(errNo)).getErrorMessage()));
//        } else {
//            errDescEl.appendChild(ru.getTextEl(doc,
//                    "Unknown Error"));ErrorDTO
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

    public String csr021Filename(String filename, String subServiceID) {
        return "CSR021" + subServiceID.substring(0, 1) + "." + filename + ".xml";
    }

    public void generate(String filename, CSR021Data data) throws JAXBException {

        File file = new File(filename);
        JAXBContext context = JAXBContext.newInstance(CSR021Data.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(data, file);
    }
}

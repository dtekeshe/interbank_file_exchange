package com.bsva.dmcs.reports;

import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
import org.apache.log4j.Logger;
import org.w3c.dom.*;

import com.bsva.dcms.commons.dto.file.FileDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.util.Utils;
import java.io.File;

import javax.xml.parsers.*;
import javax.xml.transform.*;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author RinusE
 *
 */
public class CSR024 implements DMCSReportInterface {

    private String reportPath = null;
    private ReportUtils ru = null;
    private List<String> reportNames;
    private BsvTableLookup bsvTableInstance = BsvTableLookup.getInstance();
    private Logger log = Logger.getLogger(CSR024.class);

    private Element visaElement;
    private Element mastercardElement;
    private Element amexElement;
    private Element dinersElement;
    private Element fleetElement;
    private Element grandTotalsElement;

    private Integer subServiceFileTransTotal = 0;
    private Double subServiceFileTransValueTotal = 0.0;

    private Integer debitsVolume = 0;
    private Double debitsValue = 0.0;
    private Integer creditsVolume = 0;
    private Double creditsValue = 0.0;
    private Integer totalNumberOfFiles = 0;

    private List<CsoInputFileControlsDTO> visaControlsDTOList = new ArrayList<>();
    private List<CsoInputFileControlsDTO> mastercardControlsDTOList = new ArrayList<>();
    private List<CsoInputFileControlsDTO> amexControlsDTOList = new ArrayList<>();
    private List<CsoInputFileControlsDTO> dinersControlsDTOList = new ArrayList<>();
    private List<CsoInputFileControlsDTO> fleetControlsDTOList = new ArrayList<>();

    private String companyName = null;
    private String companyRegNo = null;
    private String procDateStr = null;

    @Override
    public List<String> getListOfReportNames() {
        return reportNames;
    }

    @Override
    public void printTextFile() {

        DMCSReportXML2TXTthread xml2txtLst = new DMCSReportXML2TXTthread(this);

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(xml2txtLst, 1, TimeUnit.SECONDS);

        DMCSReportXML2TXTthread xml2txtLst2 = new DMCSReportXML2TXTthread(this);
        new Thread(xml2txtLst2).start();

    }

    public CSR024() {
        this.ru = ReportUtils.getInstance(bsvTableInstance.getProcessDate());
        this.reportPath = bsvTableInstance.getReportsDir();
        this.reportNames = new ArrayList<String>();
    }

    public CSR024(FileDTO filedto) {

        this.ru = ReportUtils.getInstance(bsvTableInstance.getProcessDate());
        this.reportPath = bsvTableInstance.getReportsDir();
        this.reportNames = new ArrayList<String>();
    }

    public void build(String subService) throws ParserConfigurationException, TransformerConfigurationException, TransformerFactoryConfigurationError, DAOException {

        DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        trans.setOutputProperty(OutputKeys.INDENT, "yes");

        companyName = bsvTableInstance.getCompanyName();
        companyRegNo = bsvTableInstance.getRegistrationNumber();

        String procDate = bsvTableInstance.getProcessDate();
        procDateStr = procDate.substring(0, 4) + File.separator + procDate.substring(4, 6) + File.separator + procDate.substring(6);

        Element reportContentEl = doc.createElement("reportContent");

        Element compName = doc.createElement("companyName");
        compName.appendChild(ru.getTextEl(doc, companyName));
        reportContentEl.appendChild(compName);

        Element compRegNo = doc.createElement("CompanyRegNumber");
        compRegNo.appendChild(ru.getTextEl(doc, companyRegNo));
        reportContentEl.appendChild(compRegNo);

        Element procDateEl = doc.createElement("processDate");
        procDateEl.appendChild(ru.getTextEl(doc, procDateStr));
        reportContentEl.appendChild(procDateEl);

        Element serviceEl = doc.createElement("service");
        serviceEl.appendChild(ru.getTextEl(doc, "CARD"));
        reportContentEl.appendChild(serviceEl);

        Element subServEl = doc.createElement("subService");
        subServEl.appendChild(ru.getTextEl(doc, subService));
        reportContentEl.appendChild(subServEl);


        if ("VISA CARD".equals(subService)) {
            visaElement = doc.createElement("subServiceElement");
            reportContentEl.appendChild(visaElement);
            buildInputControlLists(subService);
            for (CsoInputFileControlsDTO controlsDTO : visaControlsDTOList) {
                visaElement.appendChild(createInputControlElement(doc, controlsDTO));
            }

            createVisaTotalsElement(doc);
            createGrandTotalsElement(doc);
            reportContentEl.appendChild(grandTotalsElement);
            doc.appendChild(reportContentEl);
            String fileName = "CSR024" + subService + "." + procDate + ".xml";
            if (reportPath == null) {
                reportPath = bsvTableInstance.getReportsDir();
            }
            reportNames = ru.writeReport(doc, reportContentEl, fileName, reportNames);
            //visaControlsDTOList.clear();
        }

        if ("MASTERCARD".equals(subService)) {
            mastercardElement = doc.createElement("subServiceElement");
            reportContentEl.appendChild(mastercardElement);
            buildInputControlLists(subService);
            for (CsoInputFileControlsDTO controlsDTO : mastercardControlsDTOList) {
                mastercardElement.appendChild(createInputControlElement(doc, controlsDTO));
            }
            createMasterCardTotalsElement(doc);
            createGrandTotalsElement(doc);
            reportContentEl.appendChild(grandTotalsElement);
            doc.appendChild(reportContentEl);
            String fileName = "CSR024" + subService + "." + procDate + ".xml";
            if (reportPath == null) {
                reportPath = bsvTableInstance.getReportsDir();
            }
            reportNames = ru.writeReport(doc, reportContentEl, fileName, reportNames);
            mastercardControlsDTOList.clear();
        }

        if ("DINERS".equals(subService)) {
            dinersElement = doc.createElement("subServiceElement");
            reportContentEl.appendChild(dinersElement);
            buildInputControlLists(subService);
            for (CsoInputFileControlsDTO controlsDTO : dinersControlsDTOList) {
                dinersElement.appendChild(createInputControlElement(doc, controlsDTO));
            }
            createDinersTotalsElement(doc);
            createGrandTotalsElement(doc);
            reportContentEl.appendChild(grandTotalsElement);
            doc.appendChild(reportContentEl);
            String fileName = "CSR024" + subService + "." + procDate + ".xml";
            if (reportPath == null) {
                reportPath = bsvTableInstance.getReportsDir();
            }
            reportNames = ru.writeReport(doc, reportContentEl, fileName, reportNames);
            dinersControlsDTOList.clear();
        }

        if ("AMEX".equals(subService)) {
            amexElement = doc.createElement("subServiceElement");
            reportContentEl.appendChild(amexElement);
            buildInputControlLists(subService);
            for (CsoInputFileControlsDTO controlsDTO : amexControlsDTOList) {
                amexElement.appendChild(createInputControlElement(doc, controlsDTO));
            }
            createAmexTotalsElement(doc);
            createGrandTotalsElement(doc);
            reportContentEl.appendChild(grandTotalsElement);
            doc.appendChild(reportContentEl);
            String fileName = "CSR024" + subService + "." + procDate + ".xml";
            if (reportPath == null) {
                reportPath = bsvTableInstance.getReportsDir();
            }
            reportNames = ru.writeReport(doc, reportContentEl, fileName, reportNames);
            amexControlsDTOList.clear();
        }

        if ("FLEET CARD".equals(subService)) {
            fleetElement = doc.createElement("subServiceElement");
            reportContentEl.appendChild(fleetElement);
            buildInputControlLists(subService);
            for (CsoInputFileControlsDTO controlsDTO : fleetControlsDTOList) {
                fleetElement.appendChild(createInputControlElement(doc, controlsDTO));
            }
            createFleetTotalsElement(doc);
            createGrandTotalsElement(doc);
            reportContentEl.appendChild(grandTotalsElement);
            doc.appendChild(reportContentEl);
            String fileName = "CSR024" + subService + "." + procDate + ".xml";
            if (reportPath == null) {
                reportPath = bsvTableInstance.getReportsDir();
            }
            reportNames = ru.writeReport(doc, reportContentEl, fileName, reportNames);
            fleetControlsDTOList.clear();
        }
    }

    public void buildInputControlLists(String subServ) throws ParserConfigurationException, TransformerConfigurationException, TransformerFactoryConfigurationError, DAOException {

        CsoInputFileControlsDAO csoInputFileControlsDAO = new CsoInputFileControlsDAO();
        CsoInputFileControlsDTO csoInputFileControlsDTO = new CsoInputFileControlsDTO();
        csoInputFileControlsDTO.setService("CARD");
        csoInputFileControlsDTO.setSubService(subServ);
        List<CsoInputFileControlsDTO> controlsDTOList = csoInputFileControlsDAO.retrieveRelated(csoInputFileControlsDTO);

        for (CsoInputFileControlsDTO controlsDTO : controlsDTOList) {
            if (subServ.equals(controlsDTO.getSubService()) && ("MASTERCARD".equals(subServ))) {
                mastercardControlsDTOList.add(controlsDTO);
                getControlValues(controlsDTO);
            }
            if (subServ.equals(controlsDTO.getSubService()) && ("VISA CARD".equals(subServ))) {
                //visaControlsDTOList.add(controlsDTO);
                getControlValues(controlsDTO);
            }
            if (subServ.equals(controlsDTO.getSubService()) && ("DINERS".equals(subServ))) {
                dinersControlsDTOList.add(controlsDTO);
                getControlValues(controlsDTO);
            }
            if (subServ.equals(controlsDTO.getSubService()) && ("AMEX".equals(subServ))) {
                amexControlsDTOList.add(controlsDTO);
                getControlValues(controlsDTO);
            }

            if (subServ.equals(controlsDTO.getSubService()) && ("FLEET CARD".equals(subServ))) {
                fleetControlsDTOList.add(controlsDTO);
                getControlValues(controlsDTO);
            }
        }
    }

    public void getControlValues(CsoInputFileControlsDTO controlsDTO) {

        visaControlsDTOList.add(controlsDTO);
        creditsValue = creditsValue + controlsDTO.getCreditValue();
        creditsVolume = creditsVolume + controlsDTO.getNumberCredits();
        debitsValue = debitsValue + controlsDTO.getDebitValue();
        debitsVolume = debitsVolume + controlsDTO.getNumberDebits();
        totalNumberOfFiles++;
        subServiceFileTransTotal = subServiceFileTransTotal + controlsDTO.getNumberOfRecs();
        subServiceFileTransValueTotal = subServiceFileTransValueTotal + (controlsDTO.getCreditValue() + controlsDTO.getDebitValue());

    }

    private void createVisaTotalsElement(Document doc) {

        Element visaFileTransTotal = doc.createElement("subServiceFileTransTotal");
        visaFileTransTotal.appendChild(ru.getTextEl(doc, String.valueOf(subServiceFileTransTotal)));
        visaElement.appendChild(visaFileTransTotal);
        visaFileTransTotal = null;

        Element visaFileTransValueTotal = doc.createElement("subServiceFileTransValueTotal");
        visaFileTransValueTotal.appendChild(ru.getTextEl(doc, Utils.formatAmount(subServiceFileTransValueTotal, 16)));
        visaElement.appendChild(visaFileTransValueTotal);
        visaFileTransValueTotal = null;

    }

    private Element createMasterCardTotalsElement(Document doc) {

        Element mastercardFileTransTotal = doc.createElement("subServiceFileTransTotal");
        mastercardFileTransTotal.appendChild(ru.getTextEl(doc, String.valueOf(subServiceFileTransTotal)));
        mastercardElement.appendChild(mastercardFileTransTotal);
        mastercardFileTransTotal = null;

        Element mastercardFileTransValueTotal = doc.createElement("subServiceFileTransValueTotal");
        mastercardFileTransValueTotal.appendChild(ru.getTextEl(doc, Utils.formatAmount(subServiceFileTransValueTotal, 16)));
        mastercardElement.appendChild(mastercardFileTransValueTotal);
        mastercardFileTransValueTotal = null;

        return mastercardElement;
    }

    private Element createDinersTotalsElement(Document doc) {

        Element dinersFileTransTotal = doc.createElement("subServiceFileTransTotal");
        dinersFileTransTotal.appendChild(ru.getTextEl(doc, String.valueOf(subServiceFileTransTotal)));
        dinersElement.appendChild(dinersFileTransTotal);
        dinersFileTransTotal = null;

        Element amexFileTransValueTotal = doc.createElement("subServiceFileTransValueTotal");
        amexFileTransValueTotal.appendChild(ru.getTextEl(doc, Utils.formatAmount(subServiceFileTransValueTotal, 16)));
        dinersElement.appendChild(amexFileTransValueTotal);
        amexFileTransValueTotal = null;

        return dinersElement;
    }

    private Element createAmexTotalsElement(Document doc) {

        Element amexFileTransTotal = doc.createElement("subServiceFileTransTotal");
        amexFileTransTotal.appendChild(ru.getTextEl(doc, String.valueOf(subServiceFileTransTotal)));
        amexElement.appendChild(amexFileTransTotal);
        amexFileTransTotal = null;

        Element amexFileTransValueTotal = doc.createElement("subServiceFileTransValueTotal");
        amexFileTransValueTotal.appendChild(ru.getTextEl(doc, Utils.formatAmount(subServiceFileTransValueTotal, 16)));
        amexElement.appendChild(amexFileTransValueTotal);
        amexFileTransValueTotal = null;

        return amexElement;
    }

     private Element createFleetTotalsElement(Document doc) {

        Element fleetFileTransTotal = doc.createElement("subServiceFileTransTotal");
        fleetFileTransTotal.appendChild(ru.getTextEl(doc, String.valueOf(subServiceFileTransTotal)));
        fleetElement.appendChild(fleetFileTransTotal);
        fleetFileTransTotal = null;

        Element fleetFileTransValueTotal = doc.createElement("subServiceFileTransValueTotal");
        fleetFileTransValueTotal.appendChild(ru.getTextEl(doc, Utils.formatAmount(subServiceFileTransValueTotal, 16)));
        fleetElement.appendChild(fleetFileTransValueTotal);
        fleetFileTransValueTotal = null;

        return fleetElement;
    }

    private Element createGrandTotalsElement(Document doc) {

        grandTotalsElement = doc.createElement("grandTotals");

        Element totalFileCount = doc.createElement("totalFileCount");
        totalFileCount.appendChild(ru.getTextEl(doc, String.valueOf(totalNumberOfFiles)));
        grandTotalsElement.appendChild(totalFileCount);
        totalFileCount = null;

        Element debitsVol = doc.createElement("debitsVolume");
        debitsVol.appendChild(ru.getTextEl(doc, String.valueOf(debitsVolume)));
        grandTotalsElement.appendChild(debitsVol);
        debitsVol = null;

        Element debitsVal = doc.createElement("debitsValue");
        debitsVal.appendChild(ru.getTextEl(doc, Utils.formatAmount(debitsValue, 16)));
        grandTotalsElement.appendChild(debitsVal);
        debitsVal = null;

        Element creditsVol = doc.createElement("creditsVolume");
        creditsVol.appendChild(ru.getTextEl(doc, String.valueOf(creditsVolume)));
        grandTotalsElement.appendChild(creditsVol);
        creditsVol = null;

        Element creditsVal = doc.createElement("creditsValue");
        creditsVal.appendChild(ru.getTextEl(doc, Utils.formatAmount(creditsValue, 16)));
        grandTotalsElement.appendChild(creditsVal);
        creditsVal = null;

        return grandTotalsElement;

    }

    private Element createInputControlElement(Document doc, CsoInputFileControlsDTO controlsDTO) {
    	java.text.NumberFormat nf;
		nf = java.text.NumberFormat.getInstance();
        Element controlElement = doc.createElement("inputControl");

        Element loaddate = doc.createElement("loaddate");
        controlElement.appendChild(loaddate);
        String loaderDate = controlsDTO.getFileRefNumber().substring(8);
        loaddate.appendChild(ru.getTextEl(doc,loaderDate));
        controlElement.appendChild(loaddate);
        loaddate = null;

        String filename = controlsDTO.getFileRefNumber().substring(0, 8);

        Element fileName = doc.createElement("filename");
        fileName.appendChild(ru.getTextEl(doc, filename));
        controlElement.appendChild(fileName);
        fileName = null;

        Element acq_name = doc.createElement("acq_name");
        acq_name.appendChild(ru.getTextEl(doc, filename));
        controlElement.appendChild(acq_name);
        acq_name = null;

        Element status = doc.createElement("status");
        status.appendChild(ru.getTextEl(doc, controlsDTO.getProcessStatus()));
        controlElement.appendChild(status);
        status = null;

        Element rejects = doc.createElement("rejects");
        rejects.appendChild(ru.getTextEl(doc, controlsDTO.getNumberOfRejects())); // using field to store the rejected error count for now
        controlElement.appendChild(rejects);
        rejects = null;

        Element noOfTransactions = doc.createElement("noOfTransactions");
        noOfTransactions.appendChild(ru.getTextEl(doc, padLeftString(String.valueOf(nf.format(controlsDTO.getNumberOfRecs())).replace(",", " "),6)));
        controlElement.appendChild(noOfTransactions);
        noOfTransactions = null;

        Element valueOfTransactions = doc.createElement("valueOfTransactions");
        double value = controlsDTO.getCreditValue() + controlsDTO.getDebitValue();
        valueOfTransactions.appendChild(ru.getTextEl(doc, Utils.formatAmount(value, 16)));
        controlElement.appendChild(valueOfTransactions);
        valueOfTransactions = null;

        Element numberOfNegatives = doc.createElement("numberOfNegatives");
        numberOfNegatives.appendChild(ru.getTextEl(doc, "" + padLeftString(String.valueOf(nf.format(controlsDTO.getNegativeCardCount())).replace(",", " "),6)));
        controlElement.appendChild(numberOfNegatives);
        numberOfNegatives = null;

        Element numberOfDuplicates = doc.createElement("numberOfDuplicates");
        numberOfDuplicates.appendChild(ru.getTextEl(doc, "" + padLeftString(String.valueOf(nf.format(controlsDTO.getNegativeDuplicateCount())).replace(",", " "),4)));
        controlElement.appendChild(numberOfDuplicates);
        numberOfDuplicates = null;

        Element controlSubService = doc.createElement("controlSubService");
        controlSubService.appendChild(ru.getTextEl(doc, controlsDTO.getSubService()));
        controlElement.appendChild(controlSubService);
        controlSubService = null;

        return controlElement;
    }
    
    /**
	 * @param str
	 * @param num
	 * @return
	 */
	public static String rightPadding(String str, int num) {
		return String.format("%1$-" + num + "s", str);
	}
	/**
	 * @param s
	 * @param n
	 * @return
	 */
	// used to format String for FileWriter
	public static String padLeftString(String s, int n) {
		return String.format("%0$" + n + "s", s).replace(' ', ' ');
	}

}

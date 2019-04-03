package com.bsva.dmcs.reports;

import java.io.*;

import org.apache.log4j.Logger;
import org.w3c.dom.*;

import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.util.Utils;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import java.util.*;

import za.co.bsv.bend.report.manager.ReportCreator;
import za.co.bsv.bend.report.manager.ReportCreatorConfiguration;

/**
 *
 * @author RinusE
 *
 */
public class ReportUtils {

    public static ReportUtils instance;
    private String procDate;
    private String procDateStr;
    private BsvTableLookup bsvTableInstance = BsvTableLookup.getInstance();
    private Transformer trans = null;

    private DOMSource source = null;
    private StringWriter sw = null;
    private StreamResult result = null;
    private String reportPath = null;
    private String debugString = "";

    private ReportCreatorConfiguration reportCreatorConfig = null;
    private InputStream is = null;
    private ReportCreator reportCreator = null;

    private Logger log = Logger.getLogger(ReportUtils.class);

    private ReportUtils(String inProcDate) {

        this.reportPath = bsvTableInstance.getReportsDir();
        this.procDate = inProcDate;
        this.procDateStr = procDate.substring(0, 4) + '/' + procDate.substring(4, 6) + '/' + procDate.substring(6);
        createBuilderTools();
    }

    ReportUtils() {

        this.reportPath = bsvTableInstance.getReportsDir();
        this.procDate = bsvTableInstance.getProcessDate();
        this.procDateStr = procDate.substring(0, 4) + '/' + procDate.substring(4, 6) + '/' + procDate.substring(6);
        createBuilderTools();
    }

    public static ReportUtils getInstance(String inProcDate) {
        if (instance == null) {
            return new ReportUtils(inProcDate);
        } else {
            return instance;
        }
    }

    public static ReportUtils getInstance() {
        if (instance == null) {
            return new ReportUtils();
        } else {
            return instance;
        }
    }

    private void createBuilderTools() {

        try {
            trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

        } catch (TransformerConfigurationException e) {
            // TODO Auto-generated catch block
            log.error(e.getMessage(), e);
        } catch (TransformerFactoryConfigurationError e) {
            // TODO Auto-generated catch block
            log.error(e.getMessage(), e);
        }
    }

    public Text getTextEl(Document doc, String elText) {

        Text newTextEl = null;
        if (elText == null) {
            newTextEl = doc.createTextNode("");
        } else {
            newTextEl = doc.createTextNode(elText);
        }
        return newTextEl;
    }

    public List<String> writeReport(Document doc, Element rootElement, String xmlFileName, List<String> reportFileNameList) {

        String completeFileName = null;

        if (reportFileNameList == null) {
            reportFileNameList = new ArrayList<>();
        }
        try {

            //init
            source = new DOMSource(doc);
            sw = new StringWriter();
            result = new StreamResult(sw);

            //transform
            trans.transform(source, result);

            //get file name
            if (reportPath != null) {
                completeFileName = reportPath + File.separator + xmlFileName;
            } else {

                if (reportFileNameList.size() > 0) {
                    completeFileName = (String) reportFileNameList.get(0);
                } else {
                    completeFileName = xmlFileName;
                }
            }

            reportFileNameList.add(completeFileName);  //CSR023 + subservice + inputfilename .xml

            // write contents out to xml file
            String xmlOutStr = sw.toString();
            String eol = System.getProperty("line.separator") == null ? "\n" : System.getProperty("line.separator");

            xmlOutStr = "<?xml version='1.0' encoding='UTF-8'?>" + eol
                    + //"<?xml-stylesheet type='text/xsl' href='ccr001.xsl'?>" +
                    eol + xmlOutStr;

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(completeFileName))) {;
                bw.write(xmlOutStr);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

            Utils.logSpolog("Created " + completeFileName + " for " + (completeFileName.split("\\."))[1], "");
            log.debug("Created " + completeFileName + " for " + (completeFileName.split("\\."))[1]);

            doc = null;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return reportFileNameList;
    }

    public void xmlFileNameListToTXTfiles(DMCSReportInterface repIntface) throws Exception {
        List<String> namesList = repIntface.getListOfReportNames();

        String repName;
        for (int i = 0; i < namesList.size(); i++) {
            repName = (String) namesList.get(i);
            xmlFileToTXTfile(repName);
        }
    }

    public void xmlFileToTXTfile(String inXmlFilename) throws Exception {

        log.debug("About to generate txt file name for xml file " + inXmlFilename);
        if (reportCreatorConfig == null) {
            reportCreatorConfig = new ReportCreatorConfiguration();
//	            is = this.getClass().getClassLoader().getResourceAsStream("TextStylesheets/default.properties");
            is = new FileInputStream(BsvTableLookup.getInstance().getAppsDir() + File.separator + "default_transformer.properties");
            reportCreator = reportCreatorConfig.loadConfigurationfile(is);
        }

        // input 1 - xml file
        File xmlFile = new File(inXmlFilename);

        //input 2 - get xsl stylesheet for this type of report - based on xml filename
        String repNme = xmlFile.getName(); //CSR023 + subservice + inputfilename.xml
        String[] split = repNme.split("\\.");
        String reportType = split[0].substring(0, 6).toLowerCase(); //e.g CSR023
        String xslFileName = reportType.toLowerCase() + "_txt.xsl";

        File xslFile = new File(BsvTableLookup.getInstance().getAppsDir() + File.separator + xslFileName);

        if (!xslFile.exists()) {
            log.debug(xslFileName + " Stylesheet not found");
            return;
        }

//        //create a txt report using xml and xsl as input
        byte[] xmldoc = getByteArray(xmlFile);
        byte[] xsldoc = getByteArray(xslFile);
        byte[] results = reportCreator.createDocument(xmldoc, xsldoc, "TXT");

        String strFileContent = new String(results);
        String txtFileName = inXmlFilename.replace(".xml", ".txt");
        File outputText = new File(txtFileName.replaceAll("\\s+",""));

        try (PrintWriter pwInput = new PrintWriter(outputText)) {;
            pwInput.print(strFileContent);
            pwInput.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        Utils.logSpolog("Created " + txtFileName + " for " + txtFileName.split("\\.")[1], "");
        log.debug("Created " + txtFileName + " for " + txtFileName.split("\\.")[1]);
    }

    public byte[] getByteArray(File file) throws Exception {
        byte[] retval = new byte[(int) file.length()];
        FileInputStream fin = new FileInputStream(file);
        fin.read(retval, 0, (int) file.length());
        fin.close();
        return retval;
    }

    public Element getNewEl(Document doc, Element inEl, String elName) {
        if (inEl == null) {
            Element outEl = doc.createElement(elName);
            return outEl;
        }
        return inEl;
    }
}

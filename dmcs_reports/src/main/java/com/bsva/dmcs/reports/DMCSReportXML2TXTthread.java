/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.dmcs.reports;

/**
 *
 * @author RinusE
 */
public class DMCSReportXML2TXTthread implements Runnable {
    private ReportUtils ru = null;
    private String xmlFileName = null;
    private DMCSReportInterface repInt = null;

    public DMCSReportXML2TXTthread(String inXmlFileName) {
        xmlFileName = inXmlFileName;
    }
    public DMCSReportXML2TXTthread(DMCSReportInterface report) {
        repInt = report;
    }

    public void run() {
        ru = ReportUtils.getInstance();
        try {
            if (repInt != null) {
                ru.xmlFileNameListToTXTfiles(repInt);
            }
            if (xmlFileName != null) {
                ru.xmlFileToTXTfile(xmlFileName);
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
    }
}

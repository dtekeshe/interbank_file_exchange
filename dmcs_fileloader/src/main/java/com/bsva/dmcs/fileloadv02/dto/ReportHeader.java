package com.bsva.dmcs.fileloadv02.dto;

import java.util.Date;

/**
 * TODO Document
 */
public class ReportHeader {

    private final String companyName;
    private final String companyRegNumber;
    private final Date processDate;
    private final String serviceID;
    private final String subServiceID;
    private final String filename;

    public ReportHeader( String companyName,
                         String companyRegNumber,
                         Date processDate,
                         String serviceID,
                         String subServiceID,
                         String filename) {

        this.companyName = companyName;
        this.companyRegNumber = companyRegNumber;
        this.processDate = processDate;
        this.serviceID = serviceID;
        this.subServiceID = subServiceID;
        this.filename = filename;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyRegNumber() {
        return companyRegNumber;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public String getServiceID() {
        return serviceID;
    }

    public String getSubServiceID() {
        return subServiceID;
    }

    public String getFilename() {
        return filename;
    }
}

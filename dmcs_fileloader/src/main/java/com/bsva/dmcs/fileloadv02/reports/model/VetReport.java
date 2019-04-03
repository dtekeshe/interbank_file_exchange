package com.bsva.dmcs.fileloadv02.reports.model;

import java.util.Date;
import java.util.List;

/**
 * TODO Document
 */
public class VetReport {

    private String reportContent;
    private String companyName;
    private String companyRegNumber;
    private Date processDate;
    private String serviceID;
    private String subServiceID;
    private String bsvFileName;

    private List<VetReportDetailRecord> fileRejections;

    private String reportMessage;

    private Long totAccDrVol;
    private Long totAccDrVal;
    private Long totRejDrVol;
    private Long totRejDrVal;
    private Long totAccCrVol;
    private Long totAccCrVal;
    private Long totRejCrVol;
    private Long totRejCrVal;
    private Long totAccFinRecs;
    private Long totRejFinRecs;
    private Long totAccNonFinRecs;
    private Long totRejNonFinRecs;
    private Long totNegativeRecords;
    private Long totControlRecords;
    private Long totAcceptedRecs;
    private Long totRejectedRecs;
}

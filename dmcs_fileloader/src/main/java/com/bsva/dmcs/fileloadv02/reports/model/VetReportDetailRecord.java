package com.bsva.dmcs.fileloadv02.reports.model;

/**
 * TODO Document
 */
public class VetReportDetailRecord {

    private String errorRecordId;
    private String errorRecordNo;
    private String errorRejNo;
    private String errorDescription;
    private String fieldContent;

    public String getErrorRecordId() {
        return errorRecordId;
    }

    public void setErrorRecordId(String errorRecordId) {
        this.errorRecordId = errorRecordId;
    }

    public String getErrorRecordNo() {
        return errorRecordNo;
    }

    public void setErrorRecordNo(String errorRecordNo) {
        this.errorRecordNo = errorRecordNo;
    }

    public String getErrorRejNo() {
        return errorRejNo;
    }

    public void setErrorRejNo(String errorRejNo) {
        this.errorRejNo = errorRejNo;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getFieldContent() {
        return fieldContent;
    }

    public void setFieldContent(String fieldContent) {
        this.fieldContent = fieldContent;
    }
}

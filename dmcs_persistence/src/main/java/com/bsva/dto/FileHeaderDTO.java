package com.bsva.dto;

import java.util.Date;

/**
 * TODO Document
 */
public class FileHeaderDTO {

   

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FileHeaderDTO [input=");
		builder.append(input);
		builder.append(inputLength);
		builder.append(fileSeqNumber);
		builder.append(recordID);
		builder.append(fileDate);
		builder.append(serviceID);
		builder.append(subServiceID);
		builder.append(originatorID);
		builder.append(validationCode);
		builder.append(filename);
		builder.append(destinationID);
		builder.append(contentType);
		builder.append(direction);
		builder.append(environment);
		builder.append(recordLength);
		builder.append(status);
		builder.append(recordCount);
		builder.append(reportName);
		builder.append(fileRefNumber);
		builder.append(acquirer);
		builder.append(recordNumber);
		builder.append(reportType);
		builder.append(mmnemonic);
		return builder.toString();
	}

	private String input;
    private Integer inputLength;
    private Long fileSeqNumber;
    private Integer recordID;
    private Date fileDate;
    private String serviceID;
    private String subServiceID;
    private Integer originatorID;
    private String validationCode;
    private String filename;
    private Integer destinationID;
    private ContentType contentType;
    private Direction direction;
    private Environment environment;
    private Integer recordLength;
    private String status;
    private Integer recordCount;
    private String reportName;
    private String fileRefNumber;
    private Integer acquirer;
    private String recordNumber;
    private String reportType;
    private String mmnemonic;

    public FileHeaderDTO() {
        recordCount = 0;
    }

    public String getMmnemonic() {
		return mmnemonic;
	}

	public void setMmnemonic(String mmnemonic) {
		this.mmnemonic = mmnemonic;
	}

	public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Integer getInputLength() {
        return inputLength;
    }

    public void setInputLength(Integer inputLength) {
        this.inputLength = inputLength;
    }

    public Long getFileSeqNumber() {
        return fileSeqNumber;
    }

    public void setFileSeqNumber(Long fileSeqNumber) {
        this.fileSeqNumber = fileSeqNumber;
    }

    public Integer getRecordID() {
        return recordID;
    }

    public void setRecordID(Integer recordID) {
        this.recordID = recordID;
    }

    public Date getFileDate() {
        return fileDate;
    }

    public void setFileDate(Date fileDate) {
        this.fileDate = fileDate;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getSubServiceID() {
        return subServiceID;
    }

    public void setSubServiceID(String subServiceID) {
        this.subServiceID = subServiceID;
    }

    public Integer getOriginatorID() {
        return originatorID;
    }

    public void setOriginatorID(Integer originatorID) {
        this.originatorID = originatorID;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(Integer destinationID) {
        this.destinationID = destinationID;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Integer getRecordLength() {
        return recordLength;
    }

    public Integer getAcquirer() {
		return acquirer;
	}

	public String getRecordNumber() {
		return recordNumber;
	}

	public String getReportType() {
		return reportType;
	}

	public void setAcquirer(Integer acquirer) {
		this.acquirer = acquirer;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public void setRecordLength(Integer recordLength) {
        this.recordLength = recordLength;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public void incrementRecordCount(Integer recordCount) {
        if (this.recordCount == null) {
            this.recordCount = 0;
        }
        this.recordCount += recordCount;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getFileRefNumber() {
        return fileRefNumber;
    }

    public void setFileRefNumber(String fileRefNumber) {
        this.fileRefNumber = fileRefNumber;
    }
}

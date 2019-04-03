package com.bsva.dmcs.reportv02.dto;

import com.bsva.dcms.commons.util.StringUtil;



public class FileHeaderDto {
	
	private String recordId;
	private String outputDate;
	private String service;
	private String subService;
	private String bankMemberNumber;
	private String originator;
	private String fileName;
	private String fileNumber;
	private String dataType;
	private String dataDirection;
	private String settlementDate;
	private String bankNumber;
	private String testLiveInd;
	private String number;
	private String bankCode;
	private String reportName;
	private String mmnemonic;
	
	public String getRecordId() {
		return recordId;
	}
	public String getOutputDate() {
		return outputDate;
	}
	public String getService() {
		return service;
	}
	public String getSubService() {
		return subService;
	}
	public String getBankMemberNumber() {
		return bankMemberNumber;
	}
	public String getOriginator() {
		return originator;
	}
	public String getFileName() {
		return fileName;
	}
	public String getFileNumber() {
		return fileNumber;
	}
	public String getDataType() {
		return dataType;
	}
	public String getDataDirection() {
		return dataDirection;
	}
	public String getSettlementDate() {
		return settlementDate;
	}
	public String getMmnemonic() {
		return mmnemonic;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public void setOutputDate(String outputDate) {
		this.outputDate = outputDate;
	}
	public void setService(String service) {
		this.service = service;
	}
	public void setSubService(String subService) {
		this.subService = subService;
	}
	public void setBankMemberNumber(String bankMemberNumber) {
		this.bankMemberNumber = bankMemberNumber;
	}
	public void setOriginator(String originator) {
		this.originator = originator;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public void setDataDirection(String dataDirection) {
		this.dataDirection = dataDirection;
	}
	public String getBankNumber() {
		return bankNumber;
	}
	public String getTestLiveInd() {
		return testLiveInd;
	}
	public String getNumber() {
		return number;
	}
	public String getBankCode() {
		return bankCode;
	}
	public String getReportName() {
		return reportName;
	}
	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}
	public void setTestLiveInd(String testLiveInd) {
		this.testLiveInd = testLiveInd;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}
	public void setMmnemonic(String mmnemonic) {
		this.mmnemonic = mmnemonic;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();		
		builder.append(recordId == null ? "" : StringUtil.leftJustify(String.valueOf(recordId),StringUtil.SPACE_STRING, 2));
		builder.append(outputDate == null ? "" : StringUtil.leftJustify(String.valueOf(outputDate),StringUtil.SPACE_STRING, 8));
		builder.append(service == null ? "" : StringUtil.leftJustify(String.valueOf(service),StringUtil.SPACE_STRING, 4));
		builder.append(subService == null ? "" : StringUtil.leftJustify(String.valueOf(subService),StringUtil.SPACE_STRING, 10));
		builder.append(bankMemberNumber == null ? "" : StringUtil.leftJustify(String.valueOf(bankMemberNumber),StringUtil.SPACE_STRING, 4));
		builder.append(originator == null ? "" : StringUtil.leftJustify(String.valueOf(originator),StringUtil.SPACE_STRING, 4));
		builder.append(fileName == null ? "" : StringUtil.leftJustify(String.valueOf(fileName),StringUtil.SPACE_STRING, 8));
		//builder.append(fileNumber == null ? "" : StringUtil.leftJustify(String.valueOf(fileNumber), StringUtil.SPACE_STRING, 3));
		builder.append(dataType == null ? "" : StringUtil.leftJustify(String.valueOf(dataType),StringUtil.SPACE_STRING, 4));
		builder.append(dataDirection == null ? "" : StringUtil.leftJustify(String.valueOf(dataDirection),StringUtil.SPACE_STRING, 3));
		if(settlementDate != null){
		builder.append(settlementDate == null ? "" : StringUtil.leftJustify(String.valueOf(settlementDate),StringUtil.SPACE_STRING, 8));
		}
		builder.append(testLiveInd == null ? "" : StringUtil.leftJustify(String.valueOf(testLiveInd),StringUtil.SPACE_STRING, 4));
		builder.append(number == null ? "" : StringUtil.leftJustify(String.valueOf(number),StringUtil.SPACE_STRING, 4));
		builder.append(bankCode == null ? "" : StringUtil.leftJustify(String.valueOf(bankCode),StringUtil.SPACE_STRING, 3));
		builder.append(reportName == null ? "" : StringUtil.leftJustify(String.valueOf(reportName),StringUtil.SPACE_STRING, 6));
		if(mmnemonic != null){
			builder.append(mmnemonic == null ? "" : StringUtil.leftJustify(String.valueOf(mmnemonic),StringUtil.SPACE_STRING, 1));
		}
		builder.append(System.lineSeparator());
		return builder.toString();
	}
	
	

}

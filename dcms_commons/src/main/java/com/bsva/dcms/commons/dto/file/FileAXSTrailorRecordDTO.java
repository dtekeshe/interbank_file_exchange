package com.bsva.dcms.commons.dto.file;

import com.bsva.dcms.commons.util.StringUtil;

public class FileAXSTrailorRecordDTO {

	private String recordId;
	private String outputDate;
	private String serviceType;
	private String subServiceType;
	private String bankMemberNumber;
	private String numberOfRecords;
	private String sourceIdentifier;
	private String encryptedWorkingKey;
	private String macOfHashTotal;
	private String hashtotalOfAccountNumbers;
	private String filler;
	private String record;
	private int lineNumber;
	private int recordOffset = 0; // transaction line number , 4 lines include one transaction, header + trailer
	private boolean isCurrentRecordValid = true;
	
	
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	
	public String getOutputDate() {
		return outputDate;
	}
	public void setOutputDate(String outputDate) {
		this.outputDate = outputDate;
	}
	
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	public String getSubServiceType() {
		return subServiceType;
	}
	public void setSubServiceType(String subServiceType) {
		this.subServiceType = subServiceType;
	}
	
	public String getBankMemberNumber() {
		return bankMemberNumber;
	}
	
	public void setBankMemberNumber(String bankMemberNumber) {
		this.bankMemberNumber = bankMemberNumber;
	}

	public String getNumberOfRecords() {
		return numberOfRecords;
	}
	public void setNumberOfRecords(String numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}
	
	public String getSourceIdentifier() {
		return sourceIdentifier;
	}
	public void setSourceIdentifier(String sourceIdentifier) {
		this.sourceIdentifier = sourceIdentifier;
	}
	
	public String getEncryptedWorkingKey() {
		return encryptedWorkingKey;
	}
	public void setEncryptedWorkingKey(String encryptedWorkingKey) {
		this.encryptedWorkingKey = encryptedWorkingKey;
	}
	
	public String getMacOfHashTotal() {
		return macOfHashTotal;
	}
	public void setMacOfHashTotal(String macOfHashTotal) {
		this.macOfHashTotal = macOfHashTotal;
	}
	
	public String getHashtotalOfAccountNumbers() {
		return hashtotalOfAccountNumbers;
	}
	public void setHashtotalOfAccountNumbers(String hashtotalOfAccountNumbers) {
		this.hashtotalOfAccountNumbers = hashtotalOfAccountNumbers;
	}
	
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	
	
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public int getRecordOffset() {
		return recordOffset;
	}
	public void setRecordOffset(int recordOffset) {
		this.recordOffset = recordOffset;
	}
	
	public boolean isCurrentRecordValid() {
		return isCurrentRecordValid;
	}
	public void setCurrentRecordValid(boolean isCurrentRecordValid) {
		this.isCurrentRecordValid = isCurrentRecordValid;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(recordId == null ? "" : StringUtil.leftJustify(recordId,StringUtil.SPACE_STRING, 2));
		builder.append(outputDate  == null ? "" : StringUtil.leftJustify(outputDate,StringUtil.ZERO_STRING, 8));
		builder.append(serviceType  == null ? "" : StringUtil.leftJustify(serviceType, StringUtil.SPACE_STRING, 4));
		builder.append(subServiceType  == null ? "" : StringUtil.leftJustify(subServiceType, StringUtil.SPACE_STRING, 10));
		builder.append(bankMemberNumber  == null ? "" : StringUtil.leftJustify(bankMemberNumber, StringUtil.ZERO_STRING, 4));
		builder.append(numberOfRecords  == null ? "" : StringUtil.leftJustify(numberOfRecords, StringUtil.ZERO_STRING, 6));
		builder.append(sourceIdentifier  == null ? "" : StringUtil.leftJustify(sourceIdentifier, StringUtil.SPACE_STRING, 8));
		builder.append(encryptedWorkingKey  == null ? "" : StringUtil.leftJustify(encryptedWorkingKey, StringUtil.SPACE_STRING, 16));
		builder.append(macOfHashTotal  == null ? "" : StringUtil.leftJustify(macOfHashTotal, StringUtil.SPACE_STRING, 16));
		builder.append(hashtotalOfAccountNumbers  == null ? "" : StringUtil.leftJustify(hashtotalOfAccountNumbers, StringUtil.ZERO_STRING, 16));
		builder.append(filler  == null ? "" : StringUtil.leftJustify(filler,StringUtil.SPACE_STRING, 82));
		
		return builder.toString();
	}
	

	
}

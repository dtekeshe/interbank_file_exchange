package com.bsva.dcms.commons.dto.file;

import com.bsva.dcms.commons.util.StringUtil;

//import com.github.ffpojo.metadata.positional.annotation.PositionalField;
//import com.github.ffpojo.metadata.positional.annotation.PositionalRecord;

public class FileEOS98RecordDTO {
	
	private String recordId;
	private String outputDate;
	private String serviceType;
	private String subServiceType;
	private String bankMemberNumber;
	private String transamissionFileCount;//noOfTransamissionFiles;
	private String creditRecordCount;//noOfCreditRecord;
	private String debitRecordCount;//noOfDebitRecods;
	private String valueOfCreditRecords;
	private String valueOfDebitRecords;
	private String hashTotalOfAccountNumber;
	private String filler ;
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
	

	public String getTransamissionFileCount() {
		return transamissionFileCount;
	}
	public String getCreditRecordCount() {
		return creditRecordCount;
	}
	public String getDebitRecordCount() {
		return debitRecordCount;
	}
	public void setTransamissionFileCount(String transamissionFileCount) {
		this.transamissionFileCount = transamissionFileCount;
	}
	public void setCreditRecordCount(String creditRecordCount) {
		this.creditRecordCount = creditRecordCount;
	}
	public void setDebitRecordCount(String debitRecordCount) {
		this.debitRecordCount = debitRecordCount;
	}
	
	public String getValueOfCreditRecords() {
		return valueOfCreditRecords;
	}
	public void setValueOfCreditRecords(String valueOfCreditRecords) {
		this.valueOfCreditRecords = valueOfCreditRecords;
	}

	public String getValueOfDebitRecords() {
		return valueOfDebitRecords;
	}
	public void setValueOfDebitRecords(String valueOfDebitRecords) {
		this.valueOfDebitRecords = valueOfDebitRecords;
	}
	
	public String getHashTotalOfAccountNumber() {
		return hashTotalOfAccountNumber;
	}
	public void setHashTotalOfAccountNumber(String hashTotalOfAccountNumber) {
		this.hashTotalOfAccountNumber = hashTotalOfAccountNumber;
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
		builder.append(recordId == null ? " " : StringUtil.leftJustify(recordId,StringUtil.SPACE_STRING, 2));
		builder.append(outputDate == null ? "" : StringUtil.leftJustify(outputDate,StringUtil.SPACE_STRING, 8));
		builder.append(serviceType == null ? "" : StringUtil.leftJustify(serviceType, StringUtil.SPACE_STRING, 4));
		builder.append(subServiceType == null ? "" : StringUtil.leftJustify(subServiceType, StringUtil.SPACE_STRING, 10));
		builder.append(bankMemberNumber == null ? "" : StringUtil.leftJustify(bankMemberNumber, StringUtil.SPACE_STRING, 4));
		builder.append(transamissionFileCount == null ? "" : StringUtil.leftJustify(transamissionFileCount, StringUtil.SPACE_STRING, 4));
		builder.append(creditRecordCount == null ? "" : StringUtil.leftJustify(creditRecordCount, StringUtil.ZERO_STRING, 8));
		builder.append(debitRecordCount == null ? "" : StringUtil.leftJustify(debitRecordCount, StringUtil.SPACE_STRING, 8));
		builder.append(valueOfCreditRecords == null ? "" : StringUtil.leftJustify(valueOfCreditRecords, StringUtil.ZERO_STRING, 16));
		builder.append(valueOfDebitRecords ==null ? "" : StringUtil.leftJustify(valueOfDebitRecords, StringUtil.ZERO_STRING, 16));
		builder.append(hashTotalOfAccountNumber == null ? "" : StringUtil.leftJustify(hashTotalOfAccountNumber, StringUtil.ZERO_STRING, 12));
		builder.append(filler == null ? "" : StringUtil.leftJustify(filler,StringUtil.SPACE_STRING, 76));
		return builder.toString();
	}
	
	
}

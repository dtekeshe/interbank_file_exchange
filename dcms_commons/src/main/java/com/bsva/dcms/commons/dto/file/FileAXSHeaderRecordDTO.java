package com.bsva.dcms.commons.dto.file;

import com.bsva.dcms.commons.util.StringUtil;

public class FileAXSHeaderRecordDTO {

	private String recordId;
	private String outputDate;
	private String serviceType;
	private String subServiceType;
	private String bankMemberNumber;
	private String originator;
	private String fileName;
	private String fileNumber;
	private String dataType;
	private String dataDirection;
	private String settlementDate;
	private String testLiveIndicator;
	private String recordLength;
	private String destinationBank;
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

	public String getOriginator() {
		return originator;
	}
	public void setOriginator(String originator) {
		this.originator = originator;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileNumber() {
		return fileNumber;
	}
	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}

	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataDirection() {
		return dataDirection;
	}
	public void setDataDirection(String dataDirection) {
		this.dataDirection = dataDirection;
	}

	public String getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}

	public String getTestLiveIndicator() {
		return testLiveIndicator;
	}
	public void setTestLiveIndicator(String testLiveIndicator) {
		this.testLiveIndicator = testLiveIndicator;
	}

	public String getRecordLength() {
		return recordLength;
	}
	public void setRecordLength(String recordLength) {
		this.recordLength = recordLength;
	}

	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
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

	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public String getDestinationBank() {
		return destinationBank;
	}
	public void setDestinationBank(String destinationBank) {
		this.destinationBank = destinationBank;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(recordId== null ? "" :StringUtil.leftJustify(recordId,StringUtil.SPACE_STRING, 2));
		builder.append(outputDate == null ? "" : StringUtil.leftJustify(outputDate,StringUtil.SPACE_STRING, 8));
		builder.append(serviceType == null ? "" : StringUtil.leftJustify(serviceType, StringUtil.SPACE_STRING, 4));
		builder.append(subServiceType == null ? "" : StringUtil.leftJustify(subServiceType, StringUtil.SPACE_STRING, 10));
		builder.append(bankMemberNumber ==null ? "" : StringUtil.leftJustify(bankMemberNumber, StringUtil.SPACE_STRING, 4));
		builder.append(originator == null ? "" : StringUtil.leftJustify(originator, StringUtil.SPACE_STRING, 4));
		builder.append(fileName == null ? "" : StringUtil.leftJustify(fileName, StringUtil.SPACE_STRING, 8));
		builder.append(fileNumber == null ? "" : StringUtil.leftJustify(fileNumber,StringUtil.SPACE_STRING, 4));
		builder.append(dataType  == null ? "" : StringUtil.leftJustify(dataType,StringUtil.SPACE_STRING, 4));
		builder.append(dataDirection== null ? "" : StringUtil.leftJustify(dataDirection, StringUtil.SPACE_STRING, 3));
		builder.append(settlementDate == null ? "" : StringUtil.leftJustify(settlementDate, StringUtil.SPACE_STRING, 8));
		builder.append(testLiveIndicator == null ? "" : StringUtil.leftJustify(testLiveIndicator, StringUtil.SPACE_STRING, 4));
		builder.append(recordLength == null ? "" : StringUtil.leftJustify(recordLength, StringUtil.SPACE_STRING, 4));
		builder.append(destinationBank == null ? "" : StringUtil.leftJustify(destinationBank, StringUtil.SPACE_STRING, 4));
		builder.append(filler == null ? "" : StringUtil.leftJustify(filler,StringUtil.SPACE_STRING, 101));
		/*builder.append(record);
		builder.append(lineNumber);
		builder.append(recordOffset);
		builder.append(isCurrentRecordValid);*/
		return builder.toString();
	}

	


}

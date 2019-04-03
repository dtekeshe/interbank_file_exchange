package com.bsva.dcms.commons.dto.file;

public class NegativeCardRecordDTO {
	
	private String transactionCode;
	private String destinationCode;
	private String sourceBin;
	private String transactionType;
	private String authCentreId;
	private String accountNumber;
	private String responseCode;
	private String purgeDate;
	private String regionCode;
	private String cardHolderName;
	private String lineAdvance;
	
	private String record;
	private int lineNumber;
	private int recordOffset = 0; // transaction line number , 4 lines include one transaction, header + trailer

	private boolean isCurrentRecordValid = true;
	public String getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
	public String getDestinationCode() {
		return destinationCode;
	}
	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}
	public String getSourceBin() {
		return sourceBin;
	}
	public void setSourceBin(String sourceBin) {
		this.sourceBin = sourceBin;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getAuthCentreId() {
		return authCentreId;
	}
	public void setAuthCentreId(String authCentreId) {
		this.authCentreId = authCentreId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getPurgeDate() {
		return purgeDate;
	}
	public void setPurgeDate(String purgeDate) {
		this.purgeDate = purgeDate;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getLineAdvance() {
		return lineAdvance;
	}
	public void setLineAdvance(String lineAdvance) {
		this.lineAdvance = lineAdvance;
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

}

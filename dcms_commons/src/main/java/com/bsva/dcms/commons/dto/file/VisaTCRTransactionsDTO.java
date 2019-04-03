package com.bsva.dcms.commons.dto.file;

public class VisaTCRTransactionsDTO {

	private String transactionCode;
	private String tranCodeQualifier;
	private String tcrNumber;
	
	private boolean isRecordValid = true;
	
	public String getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
	public String getTranCodeQualifier() {
		return tranCodeQualifier;
	}
	public void setTranCodeQualifier(String tranCodeQualifier) {
		this.tranCodeQualifier = tranCodeQualifier;
	}
	public String getTcrNumber() {
		return tcrNumber;
	}
	public void setTcrNumber(String tcrNumber) {
		this.tcrNumber = tcrNumber;
	}
	public boolean isRecordValid() {
		return isRecordValid;
	}
	public void setRecordValid(boolean isRecordValid) {
		this.isRecordValid = isRecordValid;
	}
	
}

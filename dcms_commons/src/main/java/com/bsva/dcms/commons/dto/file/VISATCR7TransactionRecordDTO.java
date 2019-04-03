package com.bsva.dcms.commons.dto.file;

import java.util.Date;

public class VISATCR7TransactionRecordDTO extends VisaTCRTransactionsDTO {

	private String transactionType;
	private String cardSequenceNumber;
	private String terminalTransactionDate;
	private String terminalCapabilityProfile;
	private String terminalCountryCode;
	private String terminalSerialNumber;
	private String unpredictableNumber;
	private String applicationTransactionCounter;
	private String applicationInterchangeProfile;
	private String cryptogram;
	private String issuerApplicationDataByte2;
	private String issuerApplicationDataByte3;
	private String terminalVerificationResults;
	private String issuerApplicationDataByte4_7;
	private String cryptogramAmount;
	private String issuerApplicationDataByte8;
	private String issuerApplicationDataByte9_16;
	private String issuerApplicationDataByte1;
	private String issuerApplicationDataByte17;
	private String issuerApplicationDataByte18_32;
	private String issuerScript1Results;
	private String fileName;
	private String record;
	private int lineNumber;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getCardSequenceNumber() {
		return cardSequenceNumber;
	}
	public void setCardSequenceNumber(String cardSequenceNumber) {
		this.cardSequenceNumber = cardSequenceNumber;
	}
	public String getTerminalTransactionDate() {
		return terminalTransactionDate;
	}
	public void setTerminalTransactionDate(String terminalTransactionDate) {
		this.terminalTransactionDate = terminalTransactionDate;
	}
	public String getTerminalCapabilityProfile() {
		return terminalCapabilityProfile;
	}
	public void setTerminalCapabilityProfile(String terminalCapabilityProfile) {
		this.terminalCapabilityProfile = terminalCapabilityProfile;
	}
	public String getTerminalCountryCode() {
		return terminalCountryCode;
	}
	public void setTerminalCountryCode(String terminalCountryCode) {
		this.terminalCountryCode = terminalCountryCode;
	}
	public String getTerminalSerialNumber() {
		return terminalSerialNumber;
	}
	public void setTerminalSerialNumber(String terminalSerialNumber) {
		this.terminalSerialNumber = terminalSerialNumber;
	}
	public String getUnpredictableNumber() {
		return unpredictableNumber;
	}
	public void setUnpredictableNumber(String unpredictableNumber) {
		this.unpredictableNumber = unpredictableNumber;
	}
	public String getApplicationTransactionCounter() {
		return applicationTransactionCounter;
	}
	public void setApplicationTransactionCounter(
			String applicationTransactionCounter) {
		this.applicationTransactionCounter = applicationTransactionCounter;
	}
	public String getApplicationInterchangeProfile() {
		return applicationInterchangeProfile;
	}
	public void setApplicationInterchangeProfile(
			String applicationInterchangeProfile) {
		this.applicationInterchangeProfile = applicationInterchangeProfile;
	}
	public String getCryptogram() {
		return cryptogram;
	}
	public void setCryptogram(String cryptogram) {
		this.cryptogram = cryptogram;
	}
	public String getIssuerApplicationDataByte2() {
		return issuerApplicationDataByte2;
	}
	public void setIssuerApplicationDataByte2(String issuerApplicationDataByte2) {
		this.issuerApplicationDataByte2 = issuerApplicationDataByte2;
	}
	public String getIssuerApplicationDataByte3() {
		return issuerApplicationDataByte3;
	}
	public void setIssuerApplicationDataByte3(String issuerApplicationDataByte3) {
		this.issuerApplicationDataByte3 = issuerApplicationDataByte3;
	}
	public String getTerminalVerificationResults() {
		return terminalVerificationResults;
	}
	public void setTerminalVerificationResults(String terminalVerificationResults) {
		this.terminalVerificationResults = terminalVerificationResults;
	}
	public String getIssuerApplicationDataByte4_7() {
		return issuerApplicationDataByte4_7;
	}
	public void setIssuerApplicationDataByte4_7(String issuerApplicationDataByte4_7) {
		this.issuerApplicationDataByte4_7 = issuerApplicationDataByte4_7;
	}
	public String getCryptogramAmount() {
		return cryptogramAmount;
	}
	public void setCryptogramAmount(String cryptogramAmount) {
		this.cryptogramAmount = cryptogramAmount;
	}
	public String getIssuerApplicationDataByte8() {
		return issuerApplicationDataByte8;
	}
	public void setIssuerApplicationDataByte8(String issuerApplicationDataByte8) {
		this.issuerApplicationDataByte8 = issuerApplicationDataByte8;
	}
	
	public String getIssuerApplicationDataByte9_16() {
		return issuerApplicationDataByte9_16;
	}
	public void setIssuerApplicationDataByte9_16(
			String issuerApplicationDataByte9_16) {
		this.issuerApplicationDataByte9_16 = issuerApplicationDataByte9_16;
	}
	public String getIssuerApplicationDataByte1() {
		return issuerApplicationDataByte1;
	}
	public void setIssuerApplicationDataByte1(String issuerApplicationDataByte1) {
		this.issuerApplicationDataByte1 = issuerApplicationDataByte1;
	}
	public String getIssuerApplicationDataByte17() {
		return issuerApplicationDataByte17;
	}
	public void setIssuerApplicationDataByte17(String issuerApplicationDataByte17) {
		this.issuerApplicationDataByte17 = issuerApplicationDataByte17;
	}
	public String getIssuerApplicationDataByte18_32() {
		return issuerApplicationDataByte18_32;
	}
	public void setIssuerApplicationDataByte18_32(
			String issuerApplicationDataByte18_32) {
		this.issuerApplicationDataByte18_32 = issuerApplicationDataByte18_32;
	}
	public String getIssuerScript1Results() {
		return issuerScript1Results;
	}
	public void setIssuerScript1Results(String issuerScript1Results) {
		this.issuerScript1Results = issuerScript1Results;
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
	
}

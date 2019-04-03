package com.bsva.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class TransactionDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long fileSystemSeqNumber;
	private long systemSeqNumber;
	private long recordNumber;
	private int transactionCode;
	private int cardType;
	private int issuerMember;
	private int acquirerMember;
	private int issuerBin;
	private int acquirerBin;
	private String processStatus;
	private long transactionAmount;
	private String cashbackPresent;
	private BigDecimal cashbackAmount;
	private long transactionTime;
	private long recordStartByte;
	private long recordEndByte;
	private String outputFilename;
	private int fileRecordCnt;
	private String fleetProduct;
	private String fleetSubProduct;
	private String accountNumber;
	private double billingFee;
	private double billingFeeAmount;
	private double billingVat;
	private double cbBillFee;
	private double cbBillFeeAmnt;
	private double cbBillVat;
	private String destReport;
	private String fleetCountTran;
	private int messageTypeInd;
	private int merchantCatCode;
	private int intchgRateDsgn;
	private int messageReasonCode;
	private int opfileNumSeq;
	private String extractInd;
	
	public TransactionDTO(){
		
	}
	
	
	public long getFileSystemSeqNumber() {
		return fileSystemSeqNumber;
	}
	public long getSystemSeqNumber() {
		return systemSeqNumber;
	}
	public long getRecordNumber() {
		return recordNumber;
	}
	public int getTransactionCode() {
		return transactionCode;
	}
	public int getCardType() {
		return cardType;
	}
	public int getIssuerMember() {
		return issuerMember;
	}
	public int getAcquirerMember() {
		return acquirerMember;
	}
	public int getIssuerBin() {
		return issuerBin;
	}
	public int getAcquirerBin() {
		return acquirerBin;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public long getTransactionAmount() {
		return transactionAmount;
	}
	public String getCashbackPresent() {
		return cashbackPresent;
	}
	public BigDecimal getCashbackAmount() {
		return cashbackAmount;
	}
	public long getTransactionTime() {
		return transactionTime;
	}
	public long getRecordStartByte() {
		return recordStartByte;
	}
	public long getRecordEndByte() {
		return recordEndByte;
	}
	public String getOutputFilename() {
		return outputFilename;
	}
	public int getFileRecordCnt() {
		return fileRecordCnt;
	}
	public String getFleetProduct() {
		return fleetProduct;
	}
	public String getFleetSubProduct() {
		return fleetSubProduct;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public double getBillingFee() {
		return billingFee;
	}
	public double getBillingFeeAmount() {
		return billingFeeAmount;
	}
	public double getBillingVat() {
		return billingVat;
	}
	public double getCbBillFee() {
		return cbBillFee;
	}
	public double getCbBillFeeAmnt() {
		return cbBillFeeAmnt;
	}
	public double getCbBillVat() {
		return cbBillVat;
	}
	public String getDestReport() {
		return destReport;
	}
	public String getFleetCountTran() {
		return fleetCountTran;
	}
	public int getMessageTypeInd() {
		return messageTypeInd;
	}
	public int getMerchantCatCode() {
		return merchantCatCode;
	}
	public int getIntchgRateDsgn() {
		return intchgRateDsgn;
	}
	public int getMessageReasonCode() {
		return messageReasonCode;
	}
	public int getOpfileNumSeq() {
		return opfileNumSeq;
	}
	public String getExtractInd() {
		return extractInd;
	}
	public void setFileSystemSeqNumber(long fileSystemSeqNumber) {
		this.fileSystemSeqNumber = fileSystemSeqNumber;
	}
	public void setSystemSeqNumber(long systemSeqNumber) {
		this.systemSeqNumber = systemSeqNumber;
	}
	public void setRecordNumber(long recordNumber) {
		this.recordNumber = recordNumber;
	}
	public void setTransactionCode(int transactionCode) {
		this.transactionCode = transactionCode;
	}
	public void setCardType(int cardType) {
		this.cardType = cardType;
	}
	public void setIssuerMember(int issuerMember) {
		this.issuerMember = issuerMember;
	}
	public void setAcquirerMember(int acquirerMember) {
		this.acquirerMember = acquirerMember;
	}
	public void setIssuerBin(int issuerBin) {
		this.issuerBin = issuerBin;
	}
	public void setAcquirerBin(int acquirerBin) {
		this.acquirerBin = acquirerBin;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public void setTransactionAmount(long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public void setCashbackPresent(String cashbackPresent) {
		this.cashbackPresent = cashbackPresent;
	}
	public void setCashbackAmount(BigDecimal cashbackAmount) {
		this.cashbackAmount = cashbackAmount;
	}
	public void setTransactionTime(long transactionTime) {
		this.transactionTime = transactionTime;
	}
	public void setRecordStartByte(long recordStartByte) {
		this.recordStartByte = recordStartByte;
	}
	public void setRecordEndByte(long recordEndByte) {
		this.recordEndByte = recordEndByte;
	}
	public void setOutputFilename(String outputFilename) {
		this.outputFilename = outputFilename;
	}
	public void setFileRecordCnt(int fileRecordCnt) {
		this.fileRecordCnt = fileRecordCnt;
	}
	public void setFleetProduct(String fleetProduct) {
		this.fleetProduct = fleetProduct;
	}
	public void setFleetSubProduct(String fleetSubProduct) {
		this.fleetSubProduct = fleetSubProduct;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setBillingFee(double billingFee) {
		this.billingFee = billingFee;
	}
	public void setBillingFeeAmount(double billingFeeAmount) {
		this.billingFeeAmount = billingFeeAmount;
	}
	public void setBillingVat(double billingVat) {
		this.billingVat = billingVat;
	}
	public void setCbBillFee(double cbBillFee) {
		this.cbBillFee = cbBillFee;
	}
	public void setCbBillFeeAmnt(double cbBillFeeAmnt) {
		this.cbBillFeeAmnt = cbBillFeeAmnt;
	}
	public void setCbBillVat(double cbBillVat) {
		this.cbBillVat = cbBillVat;
	}
	public void setDestReport(String destReport) {
		this.destReport = destReport;
	}
	public void setFleetCountTran(String fleetCountTran) {
		this.fleetCountTran = fleetCountTran;
	}
	public void setMessageTypeInd(int messageTypeInd) {
		this.messageTypeInd = messageTypeInd;
	}
	public void setMerchantCatCode(int merchantCatCode) {
		this.merchantCatCode = merchantCatCode;
	}
	public void setIntchgRateDsgn(int intchgRateDsgn) {
		this.intchgRateDsgn = intchgRateDsgn;
	}
	public void setMessageReasonCode(int messageReasonCode) {
		this.messageReasonCode = messageReasonCode;
	}
	public void setOpfileNumSeq(int opfileNumSeq) {
		this.opfileNumSeq = opfileNumSeq;
	}
	public void setExtractInd(String extractInd) {
		this.extractInd = extractInd;
	}
}

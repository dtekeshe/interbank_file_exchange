package com.bsva.dcms.commons.dto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CSOTransactionDTO implements java.io.Serializable, Cloneable {
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
	private String rateDesc;

	public long getFileSystemSeqNumber() {
		return this.fileSystemSeqNumber;
	}

	public void setFileSystemSeqNumber(long fileSystemSeqNumber) {
		this.fileSystemSeqNumber=fileSystemSeqNumber;
	}

	public long getSystemSeqNumber() {
		return this.systemSeqNumber;
	}

	public void setSystemSeqNumber(long systemSeqNumber) {
		this.systemSeqNumber=systemSeqNumber;
	}

	public long getRecordNumber() {
		return this.recordNumber;
	}

	public void setRecordNumber(long recordNumber) {
		this.recordNumber=recordNumber;
	}

	public int getTransactionCode() {
		return this.transactionCode;
	}

	public void setTransactionCode(int transactionCode) {
		this.transactionCode=transactionCode;
	}

	public int getCardType() {
		return this.cardType;
	}

	public void setCardType(int cardType) {
		this.cardType=cardType;
	}

	public int getIssuerMember() {
		return this.issuerMember;
	}

	public void setIssuerMember(int issuerMember) {
		this.issuerMember=issuerMember;
	}

	public int getAcquirerMember() {
		return this.acquirerMember;
	}

	public void setAcquirerMember(int acquirerMember) {
		this.acquirerMember=acquirerMember;
	}

	public int getIssuerBin() {
		return this.issuerBin;
	}

	public void setIssuerBin(int issuerBin) {
		this.issuerBin=issuerBin;
	}

	public int getAcquirerBin() {
		return this.acquirerBin;
	}

	public void setAcquirerBin(int acquirerBin) {
		this.acquirerBin=acquirerBin;
	}

	public String getProcessStatus() {
		return this.processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus=processStatus;
	}

	public long getTransactionAmount() {
		return this.transactionAmount;
	}

	public void setTransactionAmount(long transactionAmount) {
		this.transactionAmount=transactionAmount;
	}

	public String getCashbackPresent() {
		return this.cashbackPresent;
	}

	public void setCashbackPresent(String cashbackPresent) {
		this.cashbackPresent=cashbackPresent;
	}

	public BigDecimal getCashbackAmount() {
		return this.cashbackAmount;
	}

	public void setCashbackAmount(BigDecimal cashbackAmount) {
		this.cashbackAmount=cashbackAmount;
	}

	public long getTransactionTime() {
		return this.transactionTime;
	}

	public void setTransactionTime(long transactionTime) {
		this.transactionTime=transactionTime;
	}

	public long getRecordStartByte() {
		return this.recordStartByte;
	}

	public String getRateDesc() {
		return rateDesc;
	}

	public void setRateDesc(String rateDesc) {
		this.rateDesc = rateDesc;
	}

	public void setRecordStartByte(long recordStartByte) {
		this.recordStartByte=recordStartByte;
	}

	public long getRecordEndByte() {
		return this.recordEndByte;
	}

	public void setRecordEndByte(long recordEndByte) {
		this.recordEndByte=recordEndByte;
	}

	public String getOutputFilename() {
		return this.outputFilename;
	}

	public void setOutputFilename(String outputFilename) {
		this.outputFilename=outputFilename;
	}

	public int getFileRecordCnt() {
		return this.fileRecordCnt;
	}

	public void setFileRecordCnt(int fileRecordCnt) {
		this.fileRecordCnt=fileRecordCnt;
	}

	public String getFleetProduct() {
		return this.fleetProduct;
	}

	public void setFleetProduct(String fleetProduct) {
		this.fleetProduct=fleetProduct;
	}

	public String getFleetSubProduct() {
		return this.fleetSubProduct;
	}

	public void setFleetSubProduct(String fleetSubProduct) {
		this.fleetSubProduct=fleetSubProduct;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber=accountNumber;
	}

	public double getBillingFee() {
		return this.billingFee;
	}

	public void setBillingFee(double billingFee) {
		this.billingFee=billingFee;
	}

	public double getBillingFeeAmount() {
		return this.billingFeeAmount;
	}

	public void setBillingFeeAmount(double billingFeeAmount) {
		this.billingFeeAmount=billingFeeAmount;
	}

	public double getBillingVat() {
		return this.billingVat;
	}

	public void setBillingVat(double billingVat) {
		this.billingVat=billingVat;
	}

	public double getCbBillFee() {
		return this.cbBillFee;
	}

	public void setCbBillFee(double cbBillFee) {
		this.cbBillFee=cbBillFee;
	}

	public double getCbBillFeeAmnt() {
		return this.cbBillFeeAmnt;
	}

	public void setCbBillFeeAmnt(double cbBillFeeAmnt) {
		this.cbBillFeeAmnt=cbBillFeeAmnt;
	}

	public double getCbBillVat() {
		return this.cbBillVat;
	}

	public void setCbBillVat(double cbBillVat) {
		this.cbBillVat=cbBillVat;
	}

	public String getDestReport() {
		return this.destReport;
	}

	public void setDestReport(String destReport) {
		this.destReport=destReport;
	}

	public String getFleetCountTran() {
		return this.fleetCountTran;
	}

	public void setFleetCountTran(String fleetCountTran) {
		this.fleetCountTran=fleetCountTran;
	}

	public int getMessageTypeInd() {
		return this.messageTypeInd;
	}

	public void setMessageTypeInd(int messageTypeInd) {
		this.messageTypeInd=messageTypeInd;
	}

	public int getMerchantCatCode() {
		return this.merchantCatCode;
	}

	public void setMerchantCatCode(int merchantCatCode) {
		this.merchantCatCode=merchantCatCode;
	}

	public int getIntchgRateDsgn() {
		return this.intchgRateDsgn;
	}

	public void setIntchgRateDsgn(int intchgRateDsgn) {
		this.intchgRateDsgn=intchgRateDsgn;
	}

	public int getMessageReasonCode() {
		return this.messageReasonCode;
	}

	public void setMessageReasonCode(int messageReasonCode) {
		this.messageReasonCode=messageReasonCode;
	}

	public int getOpfileNumSeq() {
		return this.opfileNumSeq;
	}

	public void setOpfileNumSeq(int opfileNumSeq) {
		this.opfileNumSeq=opfileNumSeq;
	}

	public String getExtractInd() {
		return extractInd;
	}

	public void setExtractInd(String extractInd) {
		this.extractInd = extractInd;
	}

	/* Creates and returns a copy of this object. */
	public Object clone() {
		CSOTransactionDTO bean = new CSOTransactionDTO();
		bean.fileSystemSeqNumber = this.fileSystemSeqNumber;
		bean.systemSeqNumber = this.systemSeqNumber;
		bean.recordNumber = this.recordNumber;
		bean.transactionCode = this.transactionCode;
		bean.cardType = this.cardType;
		bean.issuerMember = this.issuerMember;
		bean.acquirerMember = this.acquirerMember;
		bean.issuerBin = this.issuerBin;
		bean.acquirerBin = this.acquirerBin;
		bean.processStatus = this.processStatus;
		bean.transactionAmount = this.transactionAmount;
		bean.cashbackPresent = this.cashbackPresent;
		bean.cashbackAmount = this.cashbackAmount;
		bean.transactionTime = this.transactionTime;
		bean.recordStartByte = this.recordStartByte;
		bean.recordEndByte = this.recordEndByte;
		bean.outputFilename = this.outputFilename;
		bean.fileRecordCnt = this.fileRecordCnt;
		bean.fleetProduct = this.fleetProduct;
		bean.fleetSubProduct = this.fleetSubProduct;
		bean.accountNumber = this.accountNumber;
		bean.billingFee = this.billingFee;
		bean.billingFeeAmount = this.billingFeeAmount;
		bean.billingVat = this.billingVat;
		bean.cbBillFee = this.cbBillFee;
		bean.cbBillFeeAmnt = this.cbBillFeeAmnt;
		bean.cbBillVat = this.cbBillVat;
		bean.destReport = this.destReport;
		bean.fleetCountTran = this.fleetCountTran;
		bean.messageTypeInd = this.messageTypeInd;
		bean.merchantCatCode = this.merchantCatCode;
		bean.intchgRateDsgn = this.intchgRateDsgn;
		bean.messageReasonCode = this.messageReasonCode;
		bean.opfileNumSeq = this.opfileNumSeq;
		bean.extractInd = this.extractInd;
		
		return bean;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append(fileSystemSeqNumber);
		builder.append(systemSeqNumber);
		builder.append(recordNumber);
		builder.append(transactionCode);
		builder.append(cardType);
		builder.append(issuerMember);
		builder.append(acquirerMember);
		builder.append(issuerBin);
		builder.append(acquirerBin);
		builder.append(processStatus);
		builder.append(transactionAmount);;
		builder.append(cashbackPresent);
		builder.append(cashbackAmount);
		builder.append(transactionTime);
		builder.append(recordStartByte);
		builder.append(recordEndByte);
		builder.append(outputFilename);
		builder.append(fileRecordCnt);
		builder.append(fleetProduct);
		builder.append(fleetSubProduct);
		builder.append(accountNumber);
		builder.append(billingFee);
		builder.append(billingFeeAmount);
		builder.append(billingVat);
		builder.append(cbBillFee);
		builder.append(cbBillFeeAmnt);
		builder.append(cbBillVat);
		builder.append(destReport);
		builder.append(fleetCountTran);
		builder.append(messageTypeInd);
		builder.append(merchantCatCode);
		builder.append(intchgRateDsgn);
		builder.append(messageReasonCode);
		builder.append(opfileNumSeq);
		builder.append(extractInd);
		
		return builder.toString();
	}
	
}

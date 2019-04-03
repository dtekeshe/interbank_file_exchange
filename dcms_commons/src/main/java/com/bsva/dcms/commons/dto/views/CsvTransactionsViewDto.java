package com.bsva.dcms.commons.dto.views;

import com.bsva.dcms.commons.dto.CSOTransactionDTO;


public class CsvTransactionsViewDto{

	private String fileRefNo;
	private String service;
	private String subService;
	private int acquirerMember;
	private int issuerMember;
	private int cardType;
	private String cashbackPresent;
	private int transactionCode = 0;
	private double cashbackAmount;
	private String transactionStatus ;
	private String fileStatus;
	private double transactionAmount;
	private int issuerBin ;
	private int acquirerBin;
	private long transactionSystemSeqNumber;
	private double billingFee;
	private double billingFeeAmount;
	private double billingVat;
	private double cashbackBillFee ;
	private double cashbackBillFeeAmnt;
	private double cashbackBillVat;
	private String fleetCountTran;
	private int messageTypeInd;
	private int merchantCatCode;
	private int interchangeRateDsgn;
	private int messageReasonCode;
	private String acquirerName = "";
	private String issuerName = "";
	private String cardDescription;
	private String transactionDescription ="" ;
	private int reportSortSequence = 0;
	private double interchangeFee;
	private double interchangeFeeAmount;
	private double inputVat;
	private String destReport;
	private int amountDirection;
	private double cashbackInterchangeFee;
	private double cashbackInterchangeFeeAmount;
	private double cashbackInputVat;
	private int cashbackAmountDirection;
	
	public CsvTransactionsViewDto(){
	}

	public String getFileRefNo() {
		return fileRefNo;
	}

	public void setFileRefNo(String fileRefNo) {
		this.fileRefNo = fileRefNo;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getSubService() {
		return subService;
	}

	public void setSubService(String subService) {
		this.subService = subService;
	}

	public int getAcquirerMember() {
		return acquirerMember;
	}

	public void setAcquirerMember(int acquirerMember) {
		this.acquirerMember = acquirerMember;
	}

	public int getIssuerMember() {
		return issuerMember;
	}

	public void setIssuerMember(int issuerMember) {
		this.issuerMember = issuerMember;
	}

	public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}

	public String getCashbackPresent() {
		return cashbackPresent;
	}

	public void setCashbackPresent(String cashbackPresent) {
		this.cashbackPresent = cashbackPresent;
	}

	public int getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(int transactionCode) {
		this.transactionCode = transactionCode;
	}

	public double getCashbackAmount() {
		return cashbackAmount;
	}

	public void setCashbackAmount(double cashbackAmount) {
		this.cashbackAmount = cashbackAmount;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public int getIssuerBin() {
		return issuerBin;
	}

	public void setIssuerBin(int issuerBin) {
		this.issuerBin = issuerBin;
	}

	public int getAcquirerBin() {
		return acquirerBin;
	}

	public void setAcquirerBin(int acquirerBin) {
		this.acquirerBin = acquirerBin;
	}

	public long getTransactionSystemSeqNumber() {
		return transactionSystemSeqNumber;
	}

	public void setTransactionSystemSeqNumber(long transactionSystemSeqNumber) {
		this.transactionSystemSeqNumber = transactionSystemSeqNumber;
	}

	public double getBillingFee() {
		return billingFee;
	}

	public void setBillingFee(double billingFee) {
		this.billingFee = billingFee;
	}

	public double getBillingFeeAmount() {
		return billingFeeAmount;
	}

	public void setBillingFeeAmount(double billingFeeAmount) {
		this.billingFeeAmount = billingFeeAmount;
	}

	public double getBillingVat() {
		return billingVat;
	}

	public void setBillingVat(double billingVat) {
		this.billingVat = billingVat;
	}

	public double getCashbackBillFee() {
		return cashbackBillFee;
	}

	public void setCashbackBillFee(double cashbackBillFee) {
		this.cashbackBillFee = cashbackBillFee;
	}

	public double getCashbackBillFeeAmnt() {
		return cashbackBillFeeAmnt;
	}

	public void setCashbackBillFeeAmnt(double cashbackBillFeeAmnt) {
		this.cashbackBillFeeAmnt = cashbackBillFeeAmnt;
	}

	public double getCashbackBillVat() {
		return cashbackBillVat;
	}

	public void setCashbackBillVat(double cashbackBillVat) {
		this.cashbackBillVat = cashbackBillVat;
	}

	public String getFleetCountTran() {
		return fleetCountTran;
	}

	public void setFleetCountTran(String fleetCountTran) {
		this.fleetCountTran = fleetCountTran;
	}

	public int getMessageTypeInd() {
		return messageTypeInd;
	}

	public void setMessageTypeInd(int messageTypeInd) {
		this.messageTypeInd = messageTypeInd;
	}

	public int getMerchantCatCode() {
		return merchantCatCode;
	}

	public void setMerchantCatCode(int merchantCatCode) {
		this.merchantCatCode = merchantCatCode;
	}

	public int getInterchangeRateDsgn() {
		return interchangeRateDsgn;
	}

	public void setInterchangeRateDsgn(int interchangeRateDsgn) {
		this.interchangeRateDsgn = interchangeRateDsgn;
	}

	public int getMessageReasonCode() {
		return messageReasonCode;
	}

	public void setMessageReasonCode(int messageReasonCode) {
		this.messageReasonCode = messageReasonCode;
	}

	public String getAcquirerName() {
		return acquirerName;
	}

	public void setAcquirerName(String acquirerName) {
		this.acquirerName = acquirerName;
	}

	public String getIssuerName() {
		return issuerName;
	}

	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}

	public String getCardDescription() {
		return cardDescription;
	}

	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public int getReportSortSequence() {
		return reportSortSequence;
	}

	public void setReportSortSequence(int reportSortSequence) {
		this.reportSortSequence = reportSortSequence;
	}

	public double getInterchangeFee() {
		return interchangeFee;
	}

	public void setInterchangeFee(double interchangeFee) {
		this.interchangeFee = interchangeFee;
	}

	public double getInterchangeFeeAmount() {
		return interchangeFeeAmount;
	}

	public void setInterchangeFeeAmount(double interchangeFeeAmount) {
		this.interchangeFeeAmount = interchangeFeeAmount;
	}

	public double getInputVat() {
		return inputVat;
	}

	public void setInputVat(double inputVat) {
		this.inputVat = inputVat;
	}

	public String getDestReport() {
		return destReport;
	}

	public void setDestReport(String destReport) {
		this.destReport = destReport;
	}

	public int getAmountDirection() {
		return amountDirection;
	}

	public void setAmountDirection(int amountDirection) {
		this.amountDirection = amountDirection;
	}

	public double getCashbackInterchangeFee() {
		return cashbackInterchangeFee;
	}

	public void setCashbackInterchangeFee(double cashbackInterchangeFee) {
		this.cashbackInterchangeFee = cashbackInterchangeFee;
	}

	public double getCashbackInterchangeFeeAmount() {
		return cashbackInterchangeFeeAmount;
	}

	public void setCashbackInterchangeFeeAmount(double cashbackInterchangeFeeAmount) {
		this.cashbackInterchangeFeeAmount = cashbackInterchangeFeeAmount;
	}

	public double getCashbackInputVat() {
		return cashbackInputVat;
	}

	public void setCashbackInputVat(double cashbackInputVat) {
		this.cashbackInputVat = cashbackInputVat;
	}

	public int getCashbackAmountDirection() {
		return cashbackAmountDirection;
	}

	public void setCashbackAmountDirection(int cashbackAmountDirection) {
		this.cashbackAmountDirection = cashbackAmountDirection;
	}	
}

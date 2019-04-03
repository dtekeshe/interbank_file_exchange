package com.bsva.dcms.commons.dto.views.temp;

public class CsvCcr00XDataViewDto {

	private String issuerMember;
	private int issuerBankCode;
	private String acquirerMember;
	private int acquirerBankCode;
	private String service;
	private String subService;
	private int cardType;
	private String cardDescription;
	private int transactionCode;
	private String transactionDescription;
	private int volume;
	private long transactionValue;
	private double billingFee;
	private double billingFeeAmount;
	private double billingVat;
	private int reportSortSequence;
	
	public String getIssuerMember() {
		return issuerMember;
	}
	public void setIssuerMember(String issuerMember) {
		this.issuerMember = issuerMember;
	}
	public int getIssuerBankCode() {
		return issuerBankCode;
	}
	public void setIssuerBankCode(int issuerBankCode) {
		this.issuerBankCode = issuerBankCode;
	}
	public String getAcquirerMember() {
		return acquirerMember;
	}
	public void setAcquirerMember(String acquirerMember) {
		this.acquirerMember = acquirerMember;
	}
	public int getAcquirerBankCode() {
		return acquirerBankCode;
	}
	public void setAcquirerBankCode(int acquirerBankCode) {
		this.acquirerBankCode = acquirerBankCode;
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
	public int getCardType() {
		return cardType;
	}
	public void setCardType(int cardType) {
		this.cardType = cardType;
	}
	public String getCardDescription() {
		return cardDescription;
	}
	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}
	public int getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(int transactionCode) {
		this.transactionCode = transactionCode;
	}
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public long getTransactionValue() {
		return transactionValue;
	}
	public void setTransactionValue(long transactionValue) {
		this.transactionValue = transactionValue;
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
	public int getReportSortSequence() {
		return reportSortSequence;
	}
	public void setReportSortSequence(int reportSortSequence) {
		this.reportSortSequence = reportSortSequence;
	}
	
}

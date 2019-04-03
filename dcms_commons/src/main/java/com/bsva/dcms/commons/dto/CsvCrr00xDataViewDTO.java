package com.bsva.dcms.commons.dto;

public class CsvCrr00xDataViewDTO {
	
	private String issuerCode;
	private String acquirerCode;
	private String cardType;
	private String transactionCode;
	private String issuerMember;
	private String acquirerMember;
	private String service;
	private String subService;
	private String cardDescription;
	private String transactionDescription;
	private double volume;
	private double tranValue;
	private double billingFee;
	private double billingFeeAmount;
	private double billingVat;
	private int reportSortSequence;
	
	
	public CsvCrr00xDataViewDTO() {
		super();
	}


	public String getIssuerCode() {
		return issuerCode;
	}


	public String getAcquirerCode() {
		return acquirerCode;
	}


	public String getCardType() {
		return cardType;
	}


	public String getTransactionCode() {
		return transactionCode;
	}


	public String getIssuerMember() {
		return issuerMember;
	}


	public String getAcquirerMember() {
		return acquirerMember;
	}


	public String getService() {
		return service;
	}


	public String getSubService() {
		return subService;
	}


	public String getCardDescription() {
		return cardDescription;
	}


	public String getTransactionDescription() {
		return transactionDescription;
	}


	public double getVolume() {
		return volume;
	}


	public double getTranValue() {
		return tranValue;
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


	public int getReportSortSequence() {
		return reportSortSequence;
	}


	public void setIssuerCode(String issuerCode) {
		this.issuerCode = issuerCode;
	}


	public void setAcquirerCode(String acquirerCode) {
		this.acquirerCode = acquirerCode;
	}


	public void setCardType(String cardType) {
		this.cardType = cardType;
	}


	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}


	public void setIssuerMember(String issuerMember) {
		this.issuerMember = issuerMember;
	}


	public void setAcquirerMember(String acquirerMember) {
		this.acquirerMember = acquirerMember;
	}


	public void setService(String service) {
		this.service = service;
	}


	public void setSubService(String subService) {
		this.subService = subService;
	}


	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}


	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}


	public void setVolume(double volume) {
		this.volume = volume;
	}


	public void setTranValue(double tranValue) {
		this.tranValue = tranValue;
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


	public void setReportSortSequence(int reportSortSequence) {
		this.reportSortSequence = reportSortSequence;
	}

}

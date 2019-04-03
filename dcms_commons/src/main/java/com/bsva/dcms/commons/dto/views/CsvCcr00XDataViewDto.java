package com.bsva.dcms.commons.dto.views;

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
	private double transactionValue;
	private double bilingFee;
	private double billingFeeAmount;
	private double billingVat;
	private int reportSortSequence;	
	private String destinationReport;
	private int issuerCode;
	private int acquirerCode;
	private String displayName;
			
	public CsvCcr00XDataViewDto() {
	}
	
	public String getDestinationReport() {
		return destinationReport;
	}
	public void setDestinationReport(String destinationReport) {
		this.destinationReport = destinationReport;
	}
	public int getIssuerCode() {
		return issuerCode;
	}
	public void setIssuerCode(int issuerCode) {
		this.issuerCode = issuerCode;
	}
	public int getAcquirerCode() {
		return acquirerCode;
	}
	public void setAcquirerCode(int acquirerCode) {
		this.acquirerCode = acquirerCode;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
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
	public double getTransactionValue() {
		return transactionValue;
	}
	public void setTransactionValue(double transactionValue) {
		this.transactionValue = transactionValue;
	}
	public double getBilingFee() {
		return bilingFee;
	}
	public void setBilingFee(double bilingFee) {
		this.bilingFee = bilingFee;
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

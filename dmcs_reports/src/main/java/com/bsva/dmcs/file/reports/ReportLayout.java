package com.bsva.dmcs.file.reports;

public class ReportLayout {

	
	private String issuerMember;
	private int issuerCode;
	private String acquirerMember;
	private int acquirerCode;
	private String subService;
	private String displayName;
	private int cardType;
	private String cardDescription;
	private int transactionCode;
	private String transactionDescription;
	private int reportSortSequence;
	private String service;
	
	public ReportLayout() {
	}

	public String getIssuerMember() {
		return issuerMember;
	}

	public void setIssuerMember(String issuerMember) {
		this.issuerMember = issuerMember;
	}

	public int getIssuerCode() {
		return issuerCode;
	}

	public void setIssuerCode(int issuerCode) {
		this.issuerCode = issuerCode;
	}

	public String getAcquirerMember() {
		return acquirerMember;
	}

	public void setAcquirerMember(String acquirerMember) {
		this.acquirerMember = acquirerMember;
	}

	public int getAcquirerCode() {
		return acquirerCode;
	}

	public void setAcquirerCode(int acquirerCode) {
		this.acquirerCode = acquirerCode;
	}

	public String getSubService() {
		return subService;
	}

	public void setSubService(String subService) {
		this.subService = subService;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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

	public int getReportSortSequence() {
		return reportSortSequence;
	}

	public void setReportSortSequence(int reportSortSequence) {
		this.reportSortSequence = reportSortSequence;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
}

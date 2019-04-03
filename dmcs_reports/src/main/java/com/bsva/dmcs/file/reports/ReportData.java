package com.bsva.dmcs.file.reports;


/**
 * @author AugustineA
 *
 */
public class ReportData {
	
	private int acquirerMember;
	private int issuerMember;
	private String service;
	private int cardType;
	private int transactionCode;
	private String destinationReport;
	private int volume;
	private double transactionAmount;
	private double billingFee;
	private double billingFeeAmount;
	private double billingVat;
	private int amountDirection;
	
	public ReportData() {
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

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}

	public int getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(int transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getDestinationReport() {
		return destinationReport;
	}

	public void setDestinationReport(String destinationReport) {
		this.destinationReport = destinationReport;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
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

	public int getAmountDirection() {
		return amountDirection;
	}

	public void setAmountDirection(int amountDirection) {
		this.amountDirection = amountDirection;
	}

}

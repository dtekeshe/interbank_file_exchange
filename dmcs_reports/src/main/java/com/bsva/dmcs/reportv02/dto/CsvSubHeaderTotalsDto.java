package com.bsva.dmcs.reportv02.dto;

public class CsvSubHeaderTotalsDto {
	
	private String processs;
	private String issuingMember;
	private String acquiringMember;
	private String cardType;
	private String cardDescription;
	private String rateDescriptor;
	private String transactionCode;
	private String transactionDescription;
	private String transactionValue;
	private String transactionVolume;
	private String interChangeFee;
	private String interChangePercent;
	private String interChangeVatl;
	
	public CsvSubHeaderTotalsDto(){
		
	}

	public String getProcesss() {
		return processs;
	}

	public String getIssuingMember() {
		return issuingMember;
	}

	public String getAcquiringMember() {
		return acquiringMember;
	}

	public String getCardType() {
		return cardType;
	}

	public String getCardDescription() {
		return cardDescription;
	}

	public String getRateDescriptor() {
		return rateDescriptor;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public String getTransactionValue() {
		return transactionValue;
	}

	public String getTransactionVolume() {
		return transactionVolume;
	}

	public String getInterChangeFee() {
		return interChangeFee;
	}

	public String getInterChangePercent() {
		return interChangePercent;
	}

	public String getInterChangeVatl() {
		return interChangeVatl;
	}

	public void setProcesss(String processs) {
		this.processs = processs;
	}

	public void setIssuingMember(String issuingMember) {
		this.issuingMember = issuingMember;
	}

	public void setAcquiringMember(String acquiringMember) {
		this.acquiringMember = acquiringMember;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}

	public void setRateDescriptor(String rateDescriptor) {
		this.rateDescriptor = rateDescriptor;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public void setTransactionValue(String transactionValue) {
		this.transactionValue = transactionValue;
	}

	public void setTransactionVolume(String transactionVolume) {
		this.transactionVolume = transactionVolume;
	}

	public void setInterChangeFee(String interChangeFee) {
		this.interChangeFee = interChangeFee;
	}

	public void setInterChangePercent(String interChangePercent) {
		this.interChangePercent = interChangePercent;
	}

	public void setInterChangeVatl(String interChangeVatl) {
		this.interChangeVatl = interChangeVatl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(processs == null ? "" : "");
		builder.append(issuingMember == null ? "" : "");
		builder.append(acquiringMember == null ? "" : "");
		builder.append(cardType == null ? "" : "");
		builder.append(cardDescription == null ? "" : "" );
		builder.append(rateDescriptor == null ? "" : "");
		builder.append(transactionCode == null ? "" : "");
		builder.append(transactionDescription == null ? "" : "");
		builder.append(transactionValue == null ? "" : "");
		builder.append(transactionVolume == null ? "" : "");
		builder.append(interChangeFee == null ? "" : "");
		builder.append(interChangePercent == null ? "" : "");
		builder.append(interChangeVatl == null ? "" : "");
		return builder.toString();
	}

}

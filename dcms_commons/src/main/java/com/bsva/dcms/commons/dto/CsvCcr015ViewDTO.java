package com.bsva.dcms.commons.dto;

public class CsvCcr015ViewDTO {

	private String processMonth;
	private String issuerBin;
	private String issuerMemberName;
	private int issuerMember;
	private String cardDescription;
	private int cardType;
	private String acquiringMemberName;
	private int acquiringMember;
	private String merchantCatCode;
	private int interchangeRateDesignator;
	private int itemCharge;
	private int itemChargeAmount;
	private String transactionDescription;
	private int volume;
	private int value;
	private int totalCost;
	
	public CsvCcr015ViewDTO() {
		super();
	}

	public CsvCcr015ViewDTO(String processMonth, String issuerBin, String issuerMemberName, int issuerMember,
			String cardDescription, int cardType, String acquiringMemberName, int acquiringMember,
			String merchantCatCode, int interchangeRateDesignator, int itemCharge, int itemChargeAmount,
			String transactionDescription, int volume, int value, int totalCost) {
		super();
		this.processMonth = processMonth;
		this.issuerBin = issuerBin;
		this.issuerMemberName = issuerMemberName;
		this.issuerMember = issuerMember;
		this.cardDescription = cardDescription;
		this.cardType = cardType;
		this.acquiringMemberName = acquiringMemberName;
		this.acquiringMember = acquiringMember;
		this.merchantCatCode = merchantCatCode;
		this.interchangeRateDesignator = interchangeRateDesignator;
		this.itemCharge = itemCharge;
		this.itemChargeAmount = itemChargeAmount;
		this.transactionDescription = transactionDescription;
		this.volume = volume;
		this.value = value;
		this.totalCost = totalCost;
	}

	public String getProcessMonth() {
		return processMonth;
	}

	public String getIssuerBin() {
		return issuerBin;
	}

	public String getIssuerMemberName() {
		return issuerMemberName;
	}

	public int getIssuerMember() {
		return issuerMember;
	}

	public String getCardDescription() {
		return cardDescription;
	}

	public int getCardType() {
		return cardType;
	}

	public String getAcquiringMemberName() {
		return acquiringMemberName;
	}

	public int getAcquiringMember() {
		return acquiringMember;
	}

	public String getMerchantCatCode() {
		return merchantCatCode;
	}

	public int getInterchangeRateDesignator() {
		return interchangeRateDesignator;
	}

	public int getItemCharge() {
		return itemCharge;
	}

	public int getItemChargeAmount() {
		return itemChargeAmount;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public int getVolume() {
		return volume;
	}

	public int getValue() {
		return value;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setProcessMonth(String processMonth) {
		this.processMonth = processMonth;
	}

	public void setIssuerBin(String issuerBin) {
		this.issuerBin = issuerBin;
	}

	public void setIssuerMemberName(String issuerMemberName) {
		this.issuerMemberName = issuerMemberName;
	}

	public void setIssuerMember(int issuerMember) {
		this.issuerMember = issuerMember;
	}

	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}

	public void setAcquiringMemberName(String acquiringMemberName) {
		this.acquiringMemberName = acquiringMemberName;
	}

	public void setAcquiringMember(int acquiringMember) {
		this.acquiringMember = acquiringMember;
	}

	public void setMerchantCatCode(String merchantCatCode) {
		this.merchantCatCode = merchantCatCode;
	}

	public void setInterchangeRateDesignator(int interchangeRateDesignator) {
		this.interchangeRateDesignator = interchangeRateDesignator;
	}

	public void setItemCharge(int itemCharge) {
		this.itemCharge = itemCharge;
	}

	public void setItemChargeAmount(int itemChargeAmount) {
		this.itemChargeAmount = itemChargeAmount;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
}

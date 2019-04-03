package com.bsva.dmcs.reportv02.dto;

public class Csv031SubHeaderDto {
	
	private String acquirer;
	private String issuer;
	private String cardType;
	private String cardNumber;
	private String transactionCode;
	private String processingCode;
	private String transactionDate;
	private String transactionTime;
	private String bankservRefNo;
	private String acqRefNo;
	private String posData;
	private String terminalCapability;
	private String cardPresent;
	private String serviceCode;
	private String ird;
	private String eCommerceInd;
	private String transactionAmount;
	private String cashBackAmount;
	private String merchantCategoryCode;
	private String sarbRateDescriptor;
	private String interchangeFee;
	private String interchangePercentageFee;
	private String interchangeVat;
	private String cashBackInterchangeFee;
	private String cashBackInterchange;
	private String cashBackInterchangeVat;
	private String terminalType;
	
	public Csv031SubHeaderDto(){
		
	}

	public String getIssuer() {
		return issuer;
	}

	public String getAcquirer() {
		return acquirer;
	}

	public String getCardType() {
		return cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public String getProcessingCode() {
		return processingCode;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public String getBankservRefNo() {
		return bankservRefNo;
	}

	public String getAcqRefNo() {
		return acqRefNo;
	}

	public String getPosData() {
		return posData;
	}

	public String getTerminalCapability() {
		return terminalCapability;
	}

	public String getCardPresent() {
		return cardPresent;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public String getIrd() {
		return ird;
	}

	public String geteCommerceInd() {
		return eCommerceInd;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public String getCashBackAmount() {
		return cashBackAmount;
	}

	public String getMerchantCategoryCode() {
		return merchantCategoryCode;
	}

	public String getSarbRateDescriptor() {
		return sarbRateDescriptor;
	}

	public String getInterchangeFee() {
		return interchangeFee;
	}

	public String getInterchangePercentageFee() {
		return interchangePercentageFee;
	}

	public String getInterchangeVat() {
		return interchangeVat;
	}

	public String getCashBackInterchangeFee() {
		return cashBackInterchangeFee;
	}

	public String getCashBackInterchange() {
		return cashBackInterchange;
	}

	public String getCashBackInterchangeVat() {
		return cashBackInterchangeVat;
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public void setAcquirer(String acquirer) {
		this.acquirer = acquirer;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public void setProcessingCode(String processingCode) {
		this.processingCode = processingCode;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public void setBanKservRefNo(String bankservRefNo) {
		this.bankservRefNo = bankservRefNo;
	}

	public void setAcqRefNo(String acqRefNo) {
		this.acqRefNo = acqRefNo;
	}

	public void setPosData(String posData) {
		this.posData = posData;
	}

	public void setTerminalCapability(String terminalCapability) {
		this.terminalCapability = terminalCapability;
	}

	public void setCardPresent(String cardPresent) {
		this.cardPresent = cardPresent;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public void setIrd(String ird) {
		this.ird = ird;
	}

	public void seteCommerceInd(String eCommerceInd) {
		this.eCommerceInd = eCommerceInd;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public void setCashBackAmount(String cashBackAmount) {
		this.cashBackAmount = cashBackAmount;
	}

	public void setMerchantCategoryCode(String merchantCategoryCode) {
		this.merchantCategoryCode = merchantCategoryCode;
	}

	public void setSarbRateDescriptor(String sarbRateDescriptor) {
		this.sarbRateDescriptor = sarbRateDescriptor;
	}

	public void setInterchangeFee(String interchangeFee) {
		this.interchangeFee = interchangeFee;
	}

	public void setInterchangePercentageFee(String interchangePercentageFee) {
		this.interchangePercentageFee = interchangePercentageFee;
	}

	public void setInterchangeVat(String interchangeVat) {
		this.interchangeVat = interchangeVat;
	}

	public void setCashBackInterchangeFee(String cashBackInterchangeFee) {
		this.cashBackInterchangeFee = cashBackInterchangeFee;
	}

	public void setCashBackInterchange(String cashBackInterchange) {
		this.cashBackInterchange = cashBackInterchange;
	}

	public void setCashBackInterchangeVat(String cashBackInterchangeVat) {
		this.cashBackInterchangeVat = cashBackInterchangeVat;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(acquirer == null ? "" : acquirer);
		builder.append(" , ");
		builder.append(issuer == null ? "" : issuer);
		builder.append(" , ");
		builder.append(cardType == null ? "" : cardType);
		builder.append(" , ");
		builder.append(cardNumber == null ? "" : cardNumber);
		builder.append(" , ");
		builder.append(transactionCode == null ? "" : transactionCode);
		builder.append(" , ");
		builder.append(processingCode == null ? "" : processingCode);
		builder.append(" , ");
		builder.append(transactionDate == null ? "" : transactionDate);
		builder.append(" , ");
		builder.append(transactionTime == null ? "" : transactionTime);
		builder.append(" , ");
		builder.append(bankservRefNo == null ? "" : bankservRefNo);
		builder.append(" , ");
		builder.append(acqRefNo == null ? "" : acqRefNo);
		builder.append(" , ");
		builder.append(posData == null ? "" : posData);
		builder.append(" , ");
		builder.append(terminalCapability == null ? "" : terminalCapability);
		builder.append(" , ");
		builder.append(cardPresent == null ? "" : cardPresent);
		builder.append(" , ");
		builder.append(serviceCode == null ? "" : serviceCode);
		builder.append(" , ");
		builder.append(ird == null ? "" : ird);
		builder.append(eCommerceInd == null ? "" : eCommerceInd);
		builder.append(" , ");
		builder.append(transactionAmount == null ? "" : transactionAmount);
		builder.append(" , ");
		builder.append(cashBackAmount == null ? "" : cashBackAmount);
		builder.append(" , ");
		builder.append(merchantCategoryCode == null ? "" : merchantCategoryCode);
		builder.append(" , ");
		builder.append(sarbRateDescriptor == null ? "" : sarbRateDescriptor);
		builder.append(" , ");
		builder.append(interchangeFee == null ? "" : interchangeFee);
		builder.append(" , ");
		builder.append(interchangePercentageFee == null ? "" : interchangePercentageFee);
		builder.append(" , ");
		builder.append(interchangeVat == null ? "" : interchangeVat);
		builder.append(" , ");
		builder.append(cashBackInterchangeFee == null ? "" : cashBackInterchangeFee);
		builder.append(" , ");
		builder.append(cashBackInterchange == null ? "" : cashBackInterchange);
		builder.append(" , ");
		builder.append(cashBackInterchangeVat == null ? "" : cashBackInterchangeVat);
		builder.append(" , ");
		builder.append(terminalType == null ? "" : terminalType);
		builder.append(System.lineSeparator());
		return builder.toString();
	}

}

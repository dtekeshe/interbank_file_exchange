package com.bsva.dto;

public class FleetBillingTxnDTO {

	private String serviceID;

	private String subServiceID;

	private Integer issuerCode;

	private Integer acquirerCode;

	private String accountNumber;

	private Integer txnCode;

	private Long txnDateTime;

	private String acquirerBin;

	private Integer cardType;

	private Long amount;

	private Long systemSequenceNumber;

	private Integer txnCount;

	public FleetBillingTxnDTO() {

	}

	public String getServiceID() {
		return serviceID;
	}

	public String getSubServiceID() {
		return subServiceID;
	}

	public Integer getIssuerCode() {
		return issuerCode;
	}

	public Integer getAcquirerCode() {
		return acquirerCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public Integer getTxnCode() {
		return txnCode;
	}

	public Long getTxnDateTime() {
		return txnDateTime;
	}

	public String getAcquirerBin() {
		return acquirerBin;
	}

	public Integer getCardType() {
		return cardType;
	}

	public Long getAmount() {
		return amount;
	}

	public Long getSystemSequenceNumber() {
		return systemSequenceNumber;
	}

	public Integer getTxnCount() {
		return txnCount;
	}

	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}

	public void setSubServiceID(String subServiceID) {
		this.subServiceID = subServiceID;
	}

	public void setIssuerCode(Integer issuerCode) {
		this.issuerCode = issuerCode;
	}

	public void setAcquirerCode(Integer acquirerCode) {
		this.acquirerCode = acquirerCode;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setTxnCode(Integer txnCode) {
		this.txnCode = txnCode;
	}

	public void setTxnDateTime(Long txnDateTime) {
		this.txnDateTime = txnDateTime;
	}

	public void setAcquirerBin(String acquirerBin) {
		this.acquirerBin = acquirerBin;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public void setSystemSequenceNumber(Long systemSequenceNumber) {
		this.systemSequenceNumber = systemSequenceNumber;
	}

	public void incrementTxnCount() {

		if (txnCount == null) {
			txnCount = 1;
		}
		else {
			txnCount = txnCount + 1;
		}
	}

	public void addAmount(Long amount) {

		if (amount == null) {
			return;
		}

		if (this.amount == null) {
			this.amount = 0L;
		}

		this.amount += amount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FleetBillingTxnDTO [serviceID=");
		builder.append(serviceID);
		builder.append(", subServiceID=");
		builder.append(subServiceID);
		builder.append(", issuerCode=");
		builder.append(issuerCode);
		builder.append(", acquirerCode=");
		builder.append(acquirerCode);
		builder.append(", accountNumber=");
		builder.append(accountNumber);
		builder.append(", txnCode=");
		builder.append(txnCode);
		builder.append(", txnDateTime=");
		builder.append(txnDateTime);
		builder.append(", acquirerBin=");
		builder.append(acquirerBin);
		builder.append(", cardType=");
		builder.append(cardType);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", systemSequenceNumber=");
		builder.append(systemSequenceNumber);
		builder.append(", txnCount=");
		builder.append(txnCount);
		builder.append("]");
		return builder.toString();
	}

	public void setTxnCount(Integer txnCount) {
		this.txnCount = txnCount;
	}

}

package com.bsva.dmcs.reportv02.dto;

public class CvsCsvChargeBackVisaDto {

	private String acquirerMember;
	private String issuerMember;
	private String transactionCode;
	private String accountNumber;
	private String mfFormat;
	private String mfAcquirer;
	private String mfDate;
	private String mfBatchNo;
	private String checkDigit;
	private String purchaseDate;
	private String amount;
	private String auth1;
	private String auth2;
	private String merchantName;
	private String merchantCity;
	private String merchantCountry;
	private String merchantType;
	private String reason;
	private String amount2;
	private String systemSeqNumber;
	private String reasonCode ;
	
	
	public CvsCsvChargeBackVisaDto(){
		
	}


	public String getAcquirerMember() {
		return acquirerMember;
	}


	public String getIssuerMember() {
		return issuerMember;
	}


	public String getTransactionCode() {
		return transactionCode;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public String getMfFormat() {
		return mfFormat;
	}


	public String getMfAcquirer() {
		return mfAcquirer;
	}


	public String getMfDate() {
		return mfDate;
	}


	public String getMfBatchNo() {
		return mfBatchNo;
	}


	public String getCheckDigit() {
		return checkDigit;
	}


	public String getPurchaseDate() {
		return purchaseDate;
	}


	public String getAmount() {
		return amount;
	}


	public String getAuth1() {
		return auth1;
	}


	public String getAuth2() {
		return auth2;
	}


	public String getMerchantName() {
		return merchantName;
	}


	public String getMerchantCity() {
		return merchantCity;
	}


	public String getMerchantCountry() {
		return merchantCountry;
	}


	public String getMerchantType() {
		return merchantType;
	}


	public String getReason() {
		return reason;
	}


	public String getAmount2() {
		return amount2;
	}


	public String getSystemSeqNumber() {
		return systemSeqNumber;
	}


	public String getReasonCode() {
		return reasonCode;
	}


	public void setAcquirerMember(String acquirerMember) {
		this.acquirerMember = acquirerMember;
	}


	public void setIssuerMember(String issuerMember) {
		this.issuerMember = issuerMember;
	}


	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public void setMfFormat(String mfFormat) {
		this.mfFormat = mfFormat;
	}


	public void setMfAcquirer(String mfAcquirer) {
		this.mfAcquirer = mfAcquirer;
	}


	public void setMfDate(String mfDate) {
		this.mfDate = mfDate;
	}


	public void setMfBatchNo(String mfBatchNo) {
		this.mfBatchNo = mfBatchNo;
	}


	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
	}


	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public void setAuth1(String auth1) {
		this.auth1 = auth1;
	}


	public void setAuth2(String auth2) {
		this.auth2 = auth2;
	}


	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}


	public void setMerchantCity(String merchantCity) {
		this.merchantCity = merchantCity;
	}


	public void setMerchantCountry(String merchantCountry) {
		this.merchantCountry = merchantCountry;
	}


	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public void setAmount2(String amount2) {
		this.amount2 = amount2;
	}


	public void setSystemSeqNumber(String systemSeqNumber) {
		this.systemSeqNumber = systemSeqNumber;
	}


	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(acquirerMember == null ? "": acquirerMember);//4
		builder.append(issuerMember == null ? "" : issuerMember);//4
		builder.append(transactionCode == null ? "" : transactionCode);//2
		builder.append(accountNumber == null ? "" : accountNumber);//16
		builder.append(mfFormat == null ? "" : mfFormat);//1
		builder.append(mfAcquirer == null ? "" : mfAcquirer);//4
		builder.append(mfDate == null ? "" : mfDate);//4
		builder.append(mfBatchNo == null ? "" : mfBatchNo);//11
		builder.append(checkDigit == null ? "" : checkDigit);//1
		builder.append(purchaseDate == null ? "" : purchaseDate);//4
		builder.append(amount == null ? "" : amount);//0
		builder.append(auth1 == null ? "" : auth1);//0
		builder.append(auth2 == null ? "" : auth2);//0
		builder.append(merchantName == null ? "" : merchantName);//
		builder.append(merchantCity == null ? "" : merchantCity);//
		builder.append(merchantCountry == null ? "" : merchantCountry);//
		builder.append(merchantType == null ? "" : merchantType);//
		builder.append(reason == null ? "" : merchantType);//
		builder.append(amount2 == null ? "" : amount2);//9
		builder.append(systemSeqNumber == null ? "" : systemSeqNumber);//9
		builder.append(reasonCode == null ? "" : reasonCode);//2
		
		
		return builder.toString();
	}
	
	
	
	/**
	 * @param str
	 * @param num
	 * @return
	 */
	public static String rightPadZeros(String str, int num) {
	    return String.format("%1$-" + num + "s", str).replace(' ', '0');
	}
	
	/**
	 * @param str
	 * @param num
	 * @return
	 */
	public static String leftPadZeros(String str, int num) {
	    return String.format("%1$" + num + "s", str).replace(' ', '0');
	}
	
	/**
	 * @param str
	 * @param num
	 * @return
	 */
	public static String rightPadding(String str, int num) {
	    return String.format("%1$-" + num + "s", str);
	}
	
	/**
	 * @param s
	 * @param n
	 * @return
	 */
	public static String padRight(String s, int n) {
	    return String.format("%1$" + n + "s", s);
	}
	
	/**
	 * @param s
	 * @param n
	 * @return
	 */
	public static String padLeftString(String s, int n) {
	   return String.format("%0$"+ n +"s", s);
	}
	
	/**
	 * @param s
	 * @param n
	 * @return
	 */
	public static String paddingLeft(String s, int n) {
	   return String.format("%1$"+ n + "s", s);
	}
	
	
}

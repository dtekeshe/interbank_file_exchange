package com.bsva.dmcs.reportv02.dto;

public class CvsCsvReportsDto {
	
	//Dto for the CVSCSV Reports properties
	private String acquirerMember;
	private String issuerMember;
	private String transactionCode;
	private String accountNumber;
	private String mfFormat;
	private String mfAcquirer;
	private String mfDate;
	private String mfbatchNumber;
	private String checkDigit;
	private String purchaseDate;
	private String amount;
	private String mcardAuth;
	private String cardAcceptorName;
	private String merchantType;
	private String reason;
	private String amount2;
	private String systemSeqNumber;
	private String usageCode;
	
	
	public CvsCsvReportsDto(){
		
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


	public String getMfbatchNumber() {
		return mfbatchNumber;
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


	public String getMcardAuth() {
		return mcardAuth;
	}


	public String getCardAcceptorName() {
		return cardAcceptorName;
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


	public String getUsageCode() {
		return usageCode;
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


	public void setMfbatchNumber(String mfbatchNumber) {
		this.mfbatchNumber = mfbatchNumber;
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


	public void setMcardAuth(String mcardAuth) {
		this.mcardAuth = mcardAuth;
	}


	public void setCardAcceptorName(String cardAcceptorName) {
		this.cardAcceptorName = cardAcceptorName;
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


	public void setUsageCode(String usageCode) {
		this.usageCode = usageCode;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(acquirerMember == null ? "" : acquirerMember);//
		builder.append(issuerMember == null ? "" : issuerMember);//
		builder.append(transactionCode == null ? "" : transactionCode);//
		builder.append(accountNumber == null ? "" : accountNumber);//
		builder.append(mfFormat == null ? "" : mfFormat);//
		builder.append(mfAcquirer == null ? "" : mfAcquirer);//
		builder.append(mfDate == null ? "" : mfDate);//
		builder.append(mfbatchNumber == null ? "" : mfbatchNumber);//
		builder.append(checkDigit == null ? "" : rightPadZeros(checkDigit,1));//1
		builder.append(purchaseDate == null ? "" : rightPadZeros(purchaseDate,4));//4
		builder.append(amount == null ? "" : rightPadZeros(amount,6));//
		builder.append(mcardAuth == null ? "" : rightPadZeros(mcardAuth,5));//
		builder.append(cardAcceptorName == null ? "" : cardAcceptorName);//
		builder.append(merchantType == null ? "" : merchantType);//
		builder.append(reason == null ? "" : reason);//
		builder.append(amount2 == null ? "" : amount2);//
		builder.append(systemSeqNumber == null ? "" : systemSeqNumber);//
		builder.append(usageCode == null ? "" : usageCode);//
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

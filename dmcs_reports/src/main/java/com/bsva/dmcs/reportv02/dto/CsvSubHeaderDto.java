package com.bsva.dmcs.reportv02.dto;

import java.math.BigDecimal;

public class CsvSubHeaderDto {
	
	private static final String COMMA_DELIMITER = ",";
	
	private String issuerBin;
	private String issuingMember;
	private String cardDescription;
	private String acquiringMember;
	private String merchantCategoryCode;
	private String interchangeRateDesignator;
	private String interchangeRate;
	private String interchangeAmount;
	private String transactionDescription;
	private String transaction_Volume;
	private String TransactionValue;
	private String InterchangeCost;
	
	public CsvSubHeaderDto(){
		
	}
	public String getIssuerBin() {
		return issuerBin;
	}
	public String getIssuingMember() {
		return issuingMember;
	}
	public String getCardDescription() {
		return cardDescription;
	}
	public String getAcquiringMember() {
		return acquiringMember;
	}
	public String getMerchantCategoryCode() {
		return merchantCategoryCode;
	}
	public String getInterchangeRateDesignator() {
		return interchangeRateDesignator;
	}
	public String getInterchangeRate() {
		return interchangeRate;
	}
	public String getInterchangeAmount() {
		return interchangeAmount;
	}
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public String getTransaction_Volume() {
		return transaction_Volume;
	}
	public String getTransactionValue() {
		return TransactionValue;
	}
	public String getInterchangeCost() {
		return InterchangeCost;
	}
	public void setIssuerBin(String issuerBin) {
		this.issuerBin = issuerBin;
	}
	public void setIssuingMember(String issuingMember) {
		this.issuingMember = issuingMember;
	}
	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}
	public void setAcquiringMember(String acquiringMember) {
		this.acquiringMember = acquiringMember;
	}
	public void setMerchantCategoryCode(String merchantCategoryCode) {
		this.merchantCategoryCode = merchantCategoryCode;
	}
	public void setInterchangeRateDesignator(String interchangeRateDesignator) {
		this.interchangeRateDesignator = interchangeRateDesignator;
	}
	public void setInterchangeRate(String interchangeRate) {
		this.interchangeRate = interchangeRate;
	}
	public void setInterchangeAmount(String interchangeAmount) {
		this.interchangeAmount = interchangeAmount;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	public void setTransaction_Volume(String transaction_Volume) {
		this.transaction_Volume = transaction_Volume;
	}
	public void setTransactionValue(String transactionValue) {
		TransactionValue = transactionValue;
	}
	public void setInterchangeCost(String interchangeCost) {
		InterchangeCost = interchangeCost;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(issuerBin == null ? issuerBin: issuerBin);
		builder.append(COMMA_DELIMITER);
		builder.append(issuingMember == null ? issuingMember: issuingMember);
		builder.append(COMMA_DELIMITER);
		builder.append(cardDescription == null ? cardDescription: cardDescription);
		builder.append(COMMA_DELIMITER);
		builder.append(acquiringMember == null ? acquiringMember: acquiringMember);
		builder.append(COMMA_DELIMITER);
		builder.append(merchantCategoryCode == null ? merchantCategoryCode: merchantCategoryCode);
		builder.append(COMMA_DELIMITER);
		builder.append(interchangeRateDesignator == null ? interchangeRateDesignator : interchangeRateDesignator);
		builder.append(COMMA_DELIMITER);
		builder.append(interchangeRate == null ? interchangeRate: interchangeRate);
		builder.append(COMMA_DELIMITER);
		builder.append(interchangeAmount == null ? interchangeAmount: interchangeAmount);
		builder.append(COMMA_DELIMITER);
		builder.append(transactionDescription == null ? transactionDescription: transactionDescription);
		builder.append(COMMA_DELIMITER);
		builder.append(transaction_Volume == null ? transaction_Volume: transaction_Volume);
		builder.append(COMMA_DELIMITER);
		builder.append(TransactionValue == null ? TransactionValue: TransactionValue);
		builder.append(COMMA_DELIMITER);
		builder.append(InterchangeCost == null ? InterchangeCost: InterchangeCost);
		builder.append(System.lineSeparator());
		return builder.toString();
	}
	
	/**
	 * @param str
	 * @return
	 */
	public static String  pader(Long str){
	    BigDecimal payments3 = new BigDecimal(str);
		BigDecimal payments24= new BigDecimal("100");
		payments3.toBigInteger().toString();
		String str1 = paddingLeft(String.format("%.2f",payments3.multiply(payments24)),16).replace('.',' ').substring(0, 14);
		String str3 = str1;	
		return paddingLeft(str3,17).substring(0, 16);
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
	public static String rightPadding(String str, int num) {
	    return String.format("%1$-" + num + "s", str);
	}
	
	/**
	 * @param s
	 * @param n
	 * @return
	 */
	public static String padLeft(String s, int n) {
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

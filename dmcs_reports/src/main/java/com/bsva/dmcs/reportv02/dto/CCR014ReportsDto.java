package com.bsva.dmcs.reportv02.dto;

public class CCR014ReportsDto {
	
	private static final String COMMA_DELIMITER = ",";
	private static final char QUOTE_DELIMITER = '"';
	
	private String issuerBin;	     
    private String issuingMemberName;
    private String cardDescription;    
    private String acquiringMember;
    private String itemCharge;	
    private String itemChargeAmount;    
    private String interchangeRateDesignator;  
    private String transactionDescription;
    private String totalCount;
    private String totalAmount;
    private String totalCost;
    private String merchantCatCode;
    
    public CCR014ReportsDto(){
    	
    }
    
	public String getIssuerBin() {
		return issuerBin;
	}
	public String getIssuingMember() {
		return issuingMemberName;
	}
	public String getCardDescription() {
		return cardDescription;
	}
	public String getAcquiringMember() {
		return acquiringMember;
	}
	public String getItemCharge() {
		return itemCharge;
	}
	public String getItemChargeAmount() {
		return itemChargeAmount;
	}
	public String getInterchangeRateDesignator() {
		return interchangeRateDesignator;
	}
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public String getTotalCost() {
		return totalCost;
	}
	public String getMerchantCatCode() {
		return merchantCatCode;
	}
	public void setIssuerBin(String issuerBin) {
		this.issuerBin = issuerBin;
	}
	public void setIssuingMember(String issuingMemberName) {
		this.issuingMemberName = issuingMemberName;
	}
	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}
	public void setAcquiringMember(String acquiringMember) {
		this.acquiringMember = acquiringMember;
	}
	public void setItemCharge(String itemCharge) {
		this.itemCharge = itemCharge;
	}
	public void setItemChargeAmount(String itemChargeAmount) {
		this.itemChargeAmount = itemChargeAmount;
	}
	public void setInterchangeRateDesignator(String interchangeRateDesignator) {
		this.interchangeRateDesignator = interchangeRateDesignator;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	public void setMerchantCatCode(String merchantCatCode) {
		this.merchantCatCode = merchantCatCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(issuerBin == null ? rightPadding(issuerBin,6) : rightPadding(issuerBin,6));
		builder.append(COMMA_DELIMITER);
		
		builder.append(issuingMemberName  == null ? rightPadding(issuingMemberName,30) : rightPadding(issuingMemberName,30));
		builder.append(COMMA_DELIMITER);
		
		builder.append(cardDescription == null ? rightPadding(cardDescription,30) : rightPadding(cardDescription,30));
		builder.append(COMMA_DELIMITER);
		
		builder.append(acquiringMember == null ? rightPadding(acquiringMember,30) : rightPadding(acquiringMember,30));
		builder.append(COMMA_DELIMITER);
		
		builder.append(merchantCatCode == null ? rightPadding(merchantCatCode,7) : rightPadding(merchantCatCode,7));
		builder.append(COMMA_DELIMITER);
		builder.append(interchangeRateDesignator == null ? rightPadding(interchangeRateDesignator,10) : rightPadding(interchangeRateDesignator,10));
		builder.append(COMMA_DELIMITER);
		builder.append(QUOTE_DELIMITER);
		builder.append(itemCharge == null ? padRight(itemCharge,9) : padRight(itemCharge,9));
		builder.append(QUOTE_DELIMITER);
		builder.append(COMMA_DELIMITER);
		
		builder.append(QUOTE_DELIMITER);
		builder.append(itemChargeAmount == null ? padRight(itemChargeAmount,9) : padRight(itemChargeAmount,9));
		builder.append(QUOTE_DELIMITER);
		builder.append(COMMA_DELIMITER);
		
		builder.append(QUOTE_DELIMITER);
		builder.append(transactionDescription == null ? rightPadding(transactionDescription,30) : rightPadding(transactionDescription,30));
		builder.append(QUOTE_DELIMITER);
		builder.append(COMMA_DELIMITER);
		
		builder.append(totalCount == null ? leftPadZeros(totalCount,9) : leftPadZeros(totalCount,9));
		builder.append(COMMA_DELIMITER);
		
		builder.append(QUOTE_DELIMITER);
		builder.append(totalAmount == null ? padRight(totalAmount,12) : padRight(totalAmount,12));
		builder.append(QUOTE_DELIMITER);
		
		builder.append(COMMA_DELIMITER);
		builder.append(QUOTE_DELIMITER);
		builder.append(totalCost == null ? padRight(totalCost,15) : padRight(totalCost,15));
		builder.append(QUOTE_DELIMITER);
		builder.append(COMMA_DELIMITER);
		builder.append(System.lineSeparator());
		return builder.toString();
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
	 * @param str
	 * @param num
	 * @return
	 */
	public static String rightPadding(String str, int num) {
	    return String.format("%1$-" + num + "s", str);
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
	public static String rightPadZeros(String str, int num) {
	    return String.format("%1$-" + num + "s", str).replace(' ', '0');
	}

}

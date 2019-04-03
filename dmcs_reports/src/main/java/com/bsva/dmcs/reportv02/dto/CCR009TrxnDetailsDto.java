package com.bsva.dmcs.reportv02.dto;

import java.math.BigDecimal;

public class CCR009TrxnDetailsDto {

	//private String trxnDescriptionHeader;
	//private String trxnCodeHeader;
	//private String trxnCountHeader;
	//private String trxnAmountHeader;
	
	private String trxnDescription;
	private String trxnCode;
	private String trxnCount;
	private String trxnAmount;
	//private String subTotalsCount;
	//private BigDecimal subTotalsAmount;
	//private String grandTotalsCount;
	//private BigDecimal grandTotalsAmount;
	//private String subTotals;
	//private String grandTotals;
	//private String underLine;

	
	
	
	public String getTrxnDescription() {
		return trxnDescription;
	}
	public String getTrxnCode() {
		return trxnCode;
	}
	public String getTrxnCount() {
		return trxnCount;
	}
	public String getTrxnAmount() {
		return trxnAmount;
	}
	public void setTrxnDescription(String trxnDescription) {
		this.trxnDescription = trxnDescription;
	}
	public void setTrxnCode(String trxnCode) {
		this.trxnCode = trxnCode;
	}
	public void setTrxnCount(String trxnCount) {
		this.trxnCount = trxnCount;
	}
	public void setTrxnAmount(String trxnAmount) {
		this.trxnAmount = trxnAmount;
	}
	/*public String getSubTotals() {
		return subTotals;
	}
	public String getGrandTotals() {
		return grandTotals;
	}
	public void setSubTotals(String subTotals) {
		this.subTotals = subTotals;
	}
	public void setGrandTotals(String grandTotals) {
		this.grandTotals = grandTotals;
	}
	public String getSubTotalsCount() {
		return subTotalsCount;
	}
	public BigDecimal getSubTotalsAmount() {
		return subTotalsAmount;
	}
	public String getGrandTotalsCount() {
		return grandTotalsCount;
	}
	public BigDecimal getGrandTotalsAmount() {
		return grandTotalsAmount;
	}
	public String getUnderLine() {
		return underLine;
	}
	public void setSubTotalsCount(String subTotalsCount) {
		this.subTotalsCount = subTotalsCount;
	}
	public void setSubTotalsAmount(BigDecimal subTotalsAmount) {
		this.subTotalsAmount = subTotalsAmount;
	}
	public void setGrandTotalsCount(String grandTotalsCount) {
		this.grandTotalsCount = grandTotalsCount;
	}
	public void setGrandTotalsAmount(BigDecimal grandTotalsAmount) {
		this.grandTotalsAmount = grandTotalsAmount;
	}
	public void setUnderLine(String underLine) {
		this.underLine = underLine;
	}*/
	/*public String getTrxnDescriptionHeader() {
		return trxnDescriptionHeader;
	}
	public String getTrxnCodeHeader() {
		return trxnCodeHeader;
	}
	public String getTrxnCountHeader() {
		return trxnCountHeader;
	}
	public String getTrxnAmountHeader() {
		return trxnAmountHeader;
	}
	public void setTrxnDescriptionHeader(String trxnDescriptionHeader) {
		this.trxnDescriptionHeader = trxnDescriptionHeader;
	}
	public void setTrxnCodeHeader(String trxnCodeHeader) {
		this.trxnCodeHeader = trxnCodeHeader;
	}
	public void setTrxnCountHeader(String trxnCountHeader) {
		this.trxnCountHeader = trxnCountHeader;
	}
	public void setTrxnAmountHeader(String trxnAmountHeader) {
		this.trxnAmountHeader = trxnAmountHeader;
	}*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		//builder.append(trxnDescriptionHeader == null ? "": rightPadding("",50));
		//builder.append(trxnCodeHeader == null ? "" : padRight("", 7) + rightPadding(trxnCodeHeader,20));
		//builder.append(trxnCountHeader == null ? "" : padRight("", 7) + rightPadding(trxnCountHeader,15));
		//builder.append(trxnAmountHeader == null ? "" : padRight("", 7) + rightPadding(trxnAmountHeader,20));
		//builder.append(System.lineSeparator());
		 //builder.append(System.lineSeparator());
		builder.append(trxnDescription == null ? "": rightPadding(trxnDescription,50));
		builder.append(trxnCode == null ? "" : padRight("", 7) + rightPadding(trxnCode,20));
		builder.append(trxnCount == null ? "" : padRight("", 7) + rightPadding(trxnCount,15));
		builder.append(trxnAmount == null ? "" : padRight("", 7) + rightPadding(trxnAmount,20));
		builder.append(System.lineSeparator());
		//builder.append(System.lineSeparator());
		//builder.append(subTotals == null ? "" : rightPadding(subTotals,50));
		//builder.append(subTotalsCount == null ? "" :rightPadding(subTotalsCount, 20));
		//builder.append(subTotalsAmount == null ? "" : rightPadding(String.valueOf(subTotalsAmount), 25));
		//builder.append(underLine == null ? "" : rightPadding(underLine, 13));
	    //builder.append(System.lineSeparator());
	    //builder.append(System.lineSeparator());
		//builder.append(grandTotals == null ? "" : rightPadding(grandTotals,50));
	    //builder.append(grandTotalsCount == null ? "" : rightPadding(grandTotalsCount,20));
	    //builder.append(grandTotalsAmount == null ? "" : rightPadding(String.valueOf(grandTotalsAmount),25));
	    //builder.append(underLine == null ? "" : rightPadding(underLine, 13));
		//builder.append(System.lineSeparator());
		return builder.toString();
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
	
}

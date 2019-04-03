package com.bsva.dmcs.reportv02.dto;

public class FileSubAddressDto {
	
	private String trxnCodeHeader;
	private String trxnCountHeader;
	private String trxnAmountHeader;
	public String getTrxnCodeHeader() {
		return trxnCodeHeader;
	}
	public String getTrxnCountHeader() {
		return trxnCountHeader;
	}
	public String getTrxnAmountHeader() {
		return trxnAmountHeader;
	}
	public void setTrxnCodeHeader(String trxnCodeHeader) {
		this.trxnCodeHeader = trxnCodeHeader;
	}
	public void setTrxnCountHeader(String trxnCountHeader) {
		this.trxnCountHeader = trxnCountHeader;
	}
	public void setTrxnAmountHeader(String trxnAmountHeader) {
		this.trxnAmountHeader = trxnAmountHeader;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(rightPadding("",50));
		builder.append(trxnCodeHeader == null ? "" : padRight("", 7) + rightPadding(trxnCodeHeader,20));
		builder.append(trxnCountHeader == null ? "" : padRight("", 7) + rightPadding(trxnCountHeader,15));
		builder.append(trxnAmountHeader == null ? "" : padRight("", 7) + rightPadding(trxnAmountHeader,20));
		builder.append(System.lineSeparator());
		return builder.toString();
	}
	

	/**
	 * @param s
	 * @param n
	 * @return
	 */
	// used to format String for FileWriter
	public static String padLeftString(String s, int n) {
		return String.format("%0$" + n + "s", s).replace(' ', '0');
	}
	
	/**
	 * @param s
	 * @param n
	 * @return
	 */
	// used to format String for FileWriter
	public static String padRightString(String s, int n) {
		return String.format("%0$" + n + "s", s).replace(' ', '0');
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

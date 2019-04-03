package com.bsva.dmcs.reportv02.dto;

public class FileReportDetailsAddress {
	//toAddress
	private String toAddressLine0;
	private String toAddressLine1;
	private String toAddressLine2;
	private String toAddressLine3;
	private String toAddressLine4;
	private String toAddressVat;
	//from Address
	private String fromAddressLine0;
	private String fromAddressLine1;
	private String fromAddressLine2;
	private String fromAddressLine3;
	private String fromAddressLine4;
	private String fromAddressVat;
	
	
	public String getToAddressLine0() {
		return toAddressLine0;
	}
	public String getToAddressLine1() {
		return toAddressLine1;
	}
	public String getToAddressLine2() {
		return toAddressLine2;
	}
	public String getToAddressLine3() {
		return toAddressLine3;
	}
	public String getToAddressLine4() {
		return toAddressLine4;
	}
	public String getFromAddressLine0() {
		return fromAddressLine0;
	}
	public String getFromAddressLine1() {
		return fromAddressLine1;
	}
	public String getFromAddressLine2() {
		return fromAddressLine2;
	}
	public String getFromAddressLine3() {
		return fromAddressLine3;
	}
	public String getFromAddressLine4() {
		return fromAddressLine4;
	}
	public void setToAddressLine0(String toAddressLine0) {
		this.toAddressLine0 = toAddressLine0;
	}
	public void setToAddressLine1(String toAddressLine1) {
		this.toAddressLine1 = toAddressLine1;
	}
	public void setToAddressLine2(String toAddressLine2) {
		this.toAddressLine2 = toAddressLine2;
	}
	public void setToAddressLine3(String toAddressLine3) {
		this.toAddressLine3 = toAddressLine3;
	}
	public void setToAddressLine4(String toAddressLine4) {
		this.toAddressLine4 = toAddressLine4;
	}
	public void setFromAddressLine0(String fromAddressLine0) {
		this.fromAddressLine0 = fromAddressLine0;
	}
	public void setFromAddressLine1(String fromAddressLine1) {
		this.fromAddressLine1 = fromAddressLine1;
	}
	public void setFromAddressLine2(String fromAddressLine2) {
		this.fromAddressLine2 = fromAddressLine2;
	}
	public void setFromAddressLine3(String fromAddressLine3) {
		this.fromAddressLine3 = fromAddressLine3;
	}
	public void setFromAddressLine4(String fromAddressLine4) {
		this.fromAddressLine4 = fromAddressLine4;
	}
	public String getToAddressVat() {
		return toAddressVat;
	}
	public String getFromAddressVat() {
		return fromAddressVat;
	}
	public void setToAddressVat(String toAddressVat) {
		this.toAddressVat = toAddressVat;
	}
	public void setFromAddressVat(String fromAddressVat) {
		this.fromAddressVat = fromAddressVat;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(toAddressLine0 == null ? "" : rightPadding(toAddressLine0,70));
		builder.append(fromAddressLine0 == null ? "" : rightPadding(fromAddressLine0,25));
		builder.append(System.lineSeparator());
		builder.append(toAddressLine1 == null ? "" :  padRight("",7)+ rightPadding(toAddressLine1,70));
		builder.append(fromAddressLine1 == null ? "" : rightPadding(fromAddressLine1,25));
		builder.append(System.lineSeparator());
		builder.append(toAddressLine2 == null ? "" :  padRight("",7)+ rightPadding(toAddressLine2,70));
		builder.append(fromAddressLine2 == null ? "" :rightPadding(fromAddressLine2,25));
		builder.append(System.lineSeparator());
		builder.append(toAddressLine3 == null ? "" :  padRight("",7)+ rightPadding(toAddressLine3,70));
		builder.append(fromAddressLine3 == null ? "" :rightPadding(fromAddressLine3,25));
		builder.append(System.lineSeparator());
		builder.append(toAddressLine4 == null ? "" :  padRight("",7)+ rightPadding(toAddressLine4,70));
		builder.append(fromAddressLine4 == null ? "" :rightPadding(fromAddressLine4,25));
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		builder.append(toAddressVat == null ? "" :   padRight("",7)+ rightPadding(toAddressVat,70));
		builder.append(fromAddressVat == null ? "" : rightPadding(fromAddressVat,25));
		builder.append(System.lineSeparator());
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

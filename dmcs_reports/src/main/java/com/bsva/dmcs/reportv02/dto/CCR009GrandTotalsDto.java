package com.bsva.dmcs.reportv02.dto;

public class CCR009GrandTotalsDto {

	private String grandTotalsText;
	private String topUnderLine;
	private String grandTotals;
	private String dounUnderLine;
	private String grandTotalsCount;

	public String getGrandTotalsText() {
		return grandTotalsText;
	}
	public String getTopUnderLine() {
		return topUnderLine;
	}
	public String getGrandTotals() {
		return grandTotals;
	}
	public String getDounUnderLine() {
		return dounUnderLine;
	}
	public String getGrandTotalsCount() {
		return grandTotalsCount;
	}
	public void setGrandTotalsText(String grandTotalsText) {
		this.grandTotalsText = grandTotalsText;
	}
	public void setTopUnderLine(String topUnderLine) {
		this.topUnderLine = topUnderLine;
	}
	public void setGrandTotals(String grandTotals) {
		this.grandTotals = grandTotals;
	}
	public void setDounUnderLine(String dounUnderLine) {
		this.dounUnderLine = dounUnderLine;
	}
	public void setGrandTotalsCount(String grandTotalsCount) {
		this.grandTotalsCount = grandTotalsCount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(grandTotalsText == null ? "": rightPadding("",50));
		builder.append(topUnderLine == null ? "" : padRight("", 7) + rightPadding("",20));
		builder.append(grandTotals  == null ? "" : padRight("", 7) + rightPadding("",15));
		builder.append(topUnderLine  == null ? "" : padRight("", 5) + rightPadding(topUnderLine,20));
		builder.append(System.lineSeparator());
		builder.append(grandTotals == null ? "" : rightPadding(grandTotalsText,42)+padRight("", 32) + padRight(grandTotalsCount, 14)+padRight("", 17) +rightPadding(grandTotals,20));
		builder.append(System.lineSeparator());
		builder.append(dounUnderLine == null ? "" : padRight("", 104) + rightPadding(dounUnderLine,20));
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

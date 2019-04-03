package com.bsva.dmcs.reportv02.dto;

public class CCR009SubTotals {
	
	private String subTotalsText;
	private String topUnderLine;
	private String subTotals;
	private String dounUnderLine;
	private String subTotalsCount;
	
	
	public String getTopUnderLine() {
		return topUnderLine;
	}
	public String getSubTotals() {
		return subTotals;
	}
	public String getDounUnderLine() {
		return dounUnderLine;
	}
	public void setTopUnderLine(String topUnderLine) {
		this.topUnderLine = topUnderLine;
	}
	public void setSubTotals(String subTotals) {
		this.subTotals = subTotals;
	}
	public void setDounUnderLine(String dounUnderLine) {
		this.dounUnderLine = dounUnderLine;
	}
	public String getSubTotalsText() {
		return subTotalsText;
	}
	public void setSubTotalsText(String subTotalsText) {
		this.subTotalsText = subTotalsText;
	}
	public String getSubTotalsCount() {
		return subTotalsCount;
	}
	public void setSubTotalsCount(String subTotalsCount) {
		this.subTotalsCount = subTotalsCount;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(subTotalsText == null ? "": rightPadding("",50));
		builder.append(topUnderLine == null ? "" : padRight("", 7) + rightPadding("",20));
		builder.append(subTotals == null ? "" : padRight("", 7) + rightPadding("",15));
		builder.append(topUnderLine == null ? "" : padRight("", 5) + rightPadding(topUnderLine,20));
		builder.append(System.lineSeparator());
		builder.append(subTotals == null ? "" : rightPadding(subTotalsText,42)+padRight("", 32) + padRight(subTotalsCount, 14)+padRight("", 17) +rightPadding(subTotals,20));
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

package com.bsva.dmcs.reportv02.dto;

public class CSRMISFileTotalsDto {
	
	private String membernameUnderLine;
	private String subServiceUnderLine;
	private String volumeUnderLine;
	private String valueBelowUnderLine;
	private String bsvRevenueBelowUnderLine;
	private String volumeAboveUnderLine;
	private String valueAboveUnderLine;
	private String bsvRevenueAboveUnderLine;

	private String memberGrandTotal;
	private String volumeBelowGrandTotal;
	private String valueBelowGrandTotal;
	private String bsvRevenueBelowGrandTotal;
	private String volumeAboveGrandTotal;
	private String valueAboveGrandTotal;
	private String bsvRevenueAboveGrandTotal;
	
	
	
	
	
	public String getMembernameUnderLine() {
		return membernameUnderLine;
	}

	public String getSubServiceUnderLine() {
		return subServiceUnderLine;
	}

	public String getVolumeUnderLine() {
		return volumeUnderLine;
	}

	public String getValueBelowUnderLine() {
		return valueBelowUnderLine;
	}

	public String getBsvRevenueBelowUnderLine() {
		return bsvRevenueBelowUnderLine;
	}

	public String getVolumeAboveUnderLine() {
		return volumeAboveUnderLine;
	}

	public String getValueAboveUnderLine() {
		return valueAboveUnderLine;
	}

	public String getBsvRevenueAboveUnderLine() {
		return bsvRevenueAboveUnderLine;
	}

	public void setMembernameUnderLine(String membernameUnderLine) {
		this.membernameUnderLine = membernameUnderLine;
	}

	public void setSubServiceUnderLine(String subServiceUnderLine) {
		this.subServiceUnderLine = subServiceUnderLine;
	}

	public void setVolumeUnderLine(String volumeUnderLine) {
		this.volumeUnderLine = volumeUnderLine;
	}

	public void setValueBelowUnderLine(String valueBelowUnderLine) {
		this.valueBelowUnderLine = valueBelowUnderLine;
	}

	public void setBsvRevenueBelowUnderLine(String bsvRevenueBelowUnderLine) {
		this.bsvRevenueBelowUnderLine = bsvRevenueBelowUnderLine;
	}

	public void setVolumeAboveUnderLine(String volumeAboveUnderLine) {
		this.volumeAboveUnderLine = volumeAboveUnderLine;
	}

	public void setValueAboveUnderLine(String valueAboveUnderLine) {
		this.valueAboveUnderLine = valueAboveUnderLine;
	}

	public void setBsvRevenueAboveUnderLine(String bsvRevenueAboveUnderLine) {
		this.bsvRevenueAboveUnderLine = bsvRevenueAboveUnderLine;
	}

	public String getMemberGrandTotal() {
		return memberGrandTotal;
	}

	public String getVolumeBelowGrandTotal() {
		return volumeBelowGrandTotal;
	}

	public String getValueBelowGrandTotal() {
		return valueBelowGrandTotal;
	}

	public String getBsvRevenueBelowGrandTotal() {
		return bsvRevenueBelowGrandTotal;
	}

	public String getVolumeAboveGrandTotal() {
		return volumeAboveGrandTotal;
	}

	public String getValueAboveGrandTotal() {
		return valueAboveGrandTotal;
	}

	public String getBsvRevenueAboveGrandTotal() {
		return bsvRevenueAboveGrandTotal;
	}

	public void setMemberGrandTotal(String memberGrandTotal) {
		this.memberGrandTotal = memberGrandTotal;
	}

	public void setVolumeBelowGrandTotal(String volumeBelowGrandTotal) {
		this.volumeBelowGrandTotal = volumeBelowGrandTotal;
	}

	public void setValueBelowGrandTotal(String valueBelowGrandTotal) {
		this.valueBelowGrandTotal = valueBelowGrandTotal;
	}

	public void setBsvRevenueBelowGrandTotal(String bsvRevenueBelowGrandTotal) {
		this.bsvRevenueBelowGrandTotal = bsvRevenueBelowGrandTotal;
	}

	public void setVolumeAboveGrandTotal(String volumeAboveGrandTotal) {
		this.volumeAboveGrandTotal = volumeAboveGrandTotal;
	}

	public void setValueAboveGrandTotal(String valueAboveGrandTotal) {
		this.valueAboveGrandTotal = valueAboveGrandTotal;
	}

	public void setBsvRevenueAboveGrandTotal(String bsvRevenueAboveGrandTotal) {
		this.bsvRevenueAboveGrandTotal = bsvRevenueAboveGrandTotal;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(membernameUnderLine == null ? "" : rightPadding("", 2)+rightPadding(membernameUnderLine, 6));
		builder.append(subServiceUnderLine == null ? "" : rightPadding("", 2)+rightPadding(subServiceUnderLine, 18));
		builder.append(volumeUnderLine == null ? "" : rightPadding("", 2)+rightPadding(volumeUnderLine, 10));
		builder.append(valueBelowUnderLine == null ? "" : rightPadding("", 2)+rightPadding(valueBelowUnderLine, 10));
		builder.append(bsvRevenueBelowUnderLine == null ? "" : rightPadding("", 2)+rightPadding(bsvRevenueBelowUnderLine, 13));
		builder.append(volumeAboveUnderLine == null ? "" : rightPadding("", 1)+rightPadding(volumeAboveUnderLine, 9));
		builder.append(valueAboveUnderLine == null ? "" : rightPadding("", 2)+rightPadding(valueAboveUnderLine, 13));
		builder.append(bsvRevenueAboveUnderLine == null ? "" : rightPadding("", 2)+rightPadding(bsvRevenueAboveUnderLine, 13));
		
		builder.append(System.lineSeparator());
		
		builder.append(memberGrandTotal == null ? "" : rightPadding("", 2)+rightPadding(memberGrandTotal, 16));
		builder.append(volumeBelowGrandTotal == null ? "" : rightPadding("", 22)+rightPadding(volumeBelowGrandTotal, 10));
		builder.append(valueBelowGrandTotal == null ? "" : rightPadding("", 2)+rightPadding(valueBelowGrandTotal, 14));
		builder.append(bsvRevenueBelowGrandTotal == null ? "" : rightPadding("", 2)+rightPadding(bsvRevenueBelowGrandTotal, 11));
		builder.append(volumeAboveGrandTotal == null ? "" : rightPadding("", 3)+rightPadding(volumeAboveGrandTotal, 8));
		builder.append(valueAboveGrandTotal == null ? "" : rightPadding("", 5)+rightPadding(valueAboveGrandTotal, 8));
		builder.append(bsvRevenueAboveGrandTotal == null ? "" : rightPadding("", 7)+rightPadding(bsvRevenueAboveGrandTotal, 11));
		
		builder.append(System.lineSeparator());
	
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

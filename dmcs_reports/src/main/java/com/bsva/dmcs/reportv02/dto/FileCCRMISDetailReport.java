package com.bsva.dmcs.reportv02.dto;

public class FileCCRMISDetailReport {

	private String memberNameText;
	private String memberGrandTotal;
	private String volumeText;
	private String volumeBelowGrandTotal;
	private String valueBelowText;
	private String valueBelowGrandTotal;
	private String bsvRevenueBelowText;
	private String bsvRevenueBelowGrandTotal;
	private String volumeAboveText;
	private String volumeAboveGrandTotal;
	private String valueAboveText;
	private String valueAboveGrandTotal;
	private String bsvRevenueAboveText;
	private String bsvRevenueAboveGrandTotal;
	private String subServiceText;
	
	
	public String getMemberNameText() {
		return memberNameText;
	}
	public String getMemberGrandTotal() {
		return memberGrandTotal;
	}
	public String getVolumeText() {
		return volumeText;
	}
	public String getVolumeBelowGrandTotal() {
		return volumeBelowGrandTotal;
	}
	public String getValueBelowText() {
		return valueBelowText;
	}
	public String getValueBelowGrandTotal() {
		return valueBelowGrandTotal;
	}
	public String getBsvRevenueBelowText() {
		return bsvRevenueBelowText;
	}
	public String getBsvRevenueBelowGrandTotal() {
		return bsvRevenueBelowGrandTotal;
	}
	public String getVolumeAboveText() {
		return volumeAboveText;
	}
	public String getVolumeAboveGrandTotal() {
		return volumeAboveGrandTotal;
	}
	public String getValueAboveText() {
		return valueAboveText;
	}
	public String getValueAboveGrandTotal() {
		return valueAboveGrandTotal;
	}
	public String getBsvRevenueAboveText() {
		return bsvRevenueAboveText;
	}
	public String getBsvRevenueAboveGrandTotal() {
		return bsvRevenueAboveGrandTotal;
	}
	public void setMemberNameText(String memberNameText) {
		this.memberNameText = memberNameText;
	}
	public void setMemberGrandTotal(String memberGrandTotal) {
		this.memberGrandTotal = memberGrandTotal;
	}
	public void setVolumeText(String volumeText) {
		this.volumeText = volumeText;
	}
	public void setVolumeBelowGrandTotal(String volumeBelowGrandTotal) {
		this.volumeBelowGrandTotal = volumeBelowGrandTotal;
	}
	public void setValueBelowText(String valueBelowText) {
		this.valueBelowText = valueBelowText;
	}
	public void setValueBelowGrandTotal(String valueBelowGrandTotal) {
		this.valueBelowGrandTotal = valueBelowGrandTotal;
	}
	public void setBsvRevenueBelowText(String bsvRevenueBelowText) {
		this.bsvRevenueBelowText = bsvRevenueBelowText;
	}
	public void setBsvRevenueBelowGrandTotal(String bsvRevenueBelowGrandTotal) {
		this.bsvRevenueBelowGrandTotal = bsvRevenueBelowGrandTotal;
	}
	public void setVolumeAboveText(String volumeAboveText) {
		this.volumeAboveText = volumeAboveText;
	}
	public void setVolumeAboveGrandTotal(String volumeAboveGrandTotal) {
		this.volumeAboveGrandTotal = volumeAboveGrandTotal;
	}
	public void setValueAboveText(String valueAboveText) {
		this.valueAboveText = valueAboveText;
	}
	public void setValueAboveGrandTotal(String valueAboveGrandTotal) {
		this.valueAboveGrandTotal = valueAboveGrandTotal;
	}
	public void setBsvRevenueAboveText(String bsvRevenueAboveText) {
		this.bsvRevenueAboveText = bsvRevenueAboveText;
	}
	public void setBsvRevenueAboveGrandTotal(String bsvRevenueAboveGrandTotal) {
		this.bsvRevenueAboveGrandTotal = bsvRevenueAboveGrandTotal;
	}
	public String getSubServiceText() {
		return subServiceText;
	}
	public void setSubServiceText(String subServiceText) {
		this.subServiceText = subServiceText;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(memberNameText == null ? "" : rightPadding("", 2)+rightPadding(memberNameText, 6));
		builder.append(subServiceText == null ? "" : rightPadding("", 2)+rightPadding(subServiceText, 22));
		builder.append(volumeText == null ? "" : rightPadding("", 8)+rightPadding(volumeText, 10));
		builder.append(valueBelowText == null ? "" : rightPadding("", 2)+rightPadding(valueBelowText, 14));
		builder.append(bsvRevenueBelowText == null ? "" : rightPadding("", 2)+rightPadding(bsvRevenueBelowText, 13));
		builder.append(volumeAboveText == null ? "" : rightPadding("", 1)+rightPadding(volumeAboveText, 11));
		builder.append(valueAboveText == null ? "" : rightPadding("", 2)+rightPadding(valueAboveText, 17));
		builder.append(bsvRevenueAboveText == null ? "" : rightPadding("", 2)+rightPadding(bsvRevenueAboveText, 13));
		
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

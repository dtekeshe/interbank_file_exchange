package com.bsva.dmcs.reportv02.dto;

public class FileCSRMISSubHeaderDto {
	
	private String reportName;
	private String monthtoDateString;
	private String summaryHeader;
	
	private String memberNameHeader;
	private String subMember;
	private String membernameUnderLine;
	
	private String subService;
	private String subServiceUnderLine;
	
	private String subServiceText;
	
	private String volumeBelow;
	private String subVolume;
	private String volumeUnderLine;
	
	private String valueBelow;
	private String subValue;
	private String valueBelowUnderLine;
	
	private String bsvRevenueBelow;
	private String subbsvRevenueBelow;
	private String bsvRevenueBelowUnderLine;
	
	private String volumeAbove;
	private String subVolumeAbove;
	private String volumeAboveUnderLine;
	
	private String valueAbove;
	private String subValueAbove;
	private String valueAboveUnderLine;	
	
	private String bsvRevenueAbove;
	private String subBsvRevenueAbove;
	private String bsvRevenueAboveUnderLine;
	
	
	
	
	
	public String getReportName() {
		return reportName;
	}
	public String getMonthtoDateString() {
		return monthtoDateString;
	}
	public String getSummaryHeader() {
		return summaryHeader;
	}
	public String getMemberNameHeader() {
		return memberNameHeader;
	}
	public String getMembernameUnderLine() {
		return membernameUnderLine;
	}
	public String getSubService() {
		return subService;
	}
	public String getSubServiceUnderLine() {
		return subServiceUnderLine;
	}
	public String getSubServiceText() {
		return subServiceText;
	}
	public String getVolumeBelow() {
		return volumeBelow;
	}
	public String getVolumeUnderLine() {
		return volumeUnderLine;
	}
	public String getValueBelow() {
		return valueBelow;
	}
	public String getValueBelowUnderLine() {
		return valueBelowUnderLine;
	}
	public String getBsvRevenueBelow() {
		return bsvRevenueBelow;
	}
	public String getBsvRevenueBelowUnderLine() {
		return bsvRevenueBelowUnderLine;
	}
	public String getVolumeAbove() {
		return volumeAbove;
	}
	public String getVolumeAboveUnderLine() {
		return volumeAboveUnderLine;
	}
	public String getValueAbove() {
		return valueAbove;
	}
	public String getValueAboveUnderLine() {
		return valueAboveUnderLine;
	}
	public String getBsvRevenueAbove() {
		return bsvRevenueAbove;
	}
	public String getBsvRevenueAboveUnderLine() {
		return bsvRevenueAboveUnderLine;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public void setMonthtoDateString(String monthtoDateString) {
		this.monthtoDateString = monthtoDateString;
	}
	public void setSummaryHeader(String summaryHeader) {
		this.summaryHeader = summaryHeader;
	}
	public void setMemberNameHeader(String memberNameHeader) {
		this.memberNameHeader = memberNameHeader;
	}
	public void setMembernameUnderLine(String membernameUnderLine) {
		this.membernameUnderLine = membernameUnderLine;
	}
	public void setSubService(String subService) {
		this.subService = subService;
	}
	public void setSubServiceUnderLine(String subServiceUnderLine) {
		this.subServiceUnderLine = subServiceUnderLine;
	}
	public void setSubServiceText(String subServiceText) {
		this.subServiceText = subServiceText;
	}
	public void setVolumeBelow(String volumeBelow) {
		this.volumeBelow = volumeBelow;
	}
	public void setVolumeUnderLine(String volumeUnderLine) {
		this.volumeUnderLine = volumeUnderLine;
	}
	public void setValueBelow(String valueBelow) {
		this.valueBelow = valueBelow;
	}
	public void setValueBelowUnderLine(String valueBelowUnderLine) {
		this.valueBelowUnderLine = valueBelowUnderLine;
	}
	public void setBsvRevenueBelow(String bsvRevenueBelow) {
		this.bsvRevenueBelow = bsvRevenueBelow;
	}
	public void setBsvRevenueBelowUnderLine(String bsvRevenueBelowUnderLine) {
		this.bsvRevenueBelowUnderLine = bsvRevenueBelowUnderLine;
	}
	public void setVolumeAbove(String volumeAbove) {
		this.volumeAbove = volumeAbove;
	}
	public void setVolumeAboveUnderLine(String volumeAboveUnderLine) {
		this.volumeAboveUnderLine = volumeAboveUnderLine;
	}
	public void setValueAbove(String valueAbove) {
		this.valueAbove = valueAbove;
	}
	public void setValueAboveUnderLine(String valueAboveUnderLine) {
		this.valueAboveUnderLine = valueAboveUnderLine;
	}
	
	public void setBsvRevenueAbove(String bsvRevenueAbove) {
		this.bsvRevenueAbove = bsvRevenueAbove;
	}
	public void setBsvRevenueAboveUnderLine(String bsvRevenueAboveUnderLine) {
		this.bsvRevenueAboveUnderLine = bsvRevenueAboveUnderLine;
	}
	
	public String getSubMember() {
		return subMember;
	}
	public String getSubVolume() {
		return subVolume;
	}
	public String getSubValue() {
		return subValue;
	}
	public String getSubbsvRevenueBelow() {
		return subbsvRevenueBelow;
	}
	public String getSubVolumeAbove() {
		return subVolumeAbove;
	}
	public String getSubValueAbove() {
		return subValueAbove;
	}
	public String getSubBsvRevenueAbove() {
		return subBsvRevenueAbove;
	}
	public void setSubMember(String subMember) {
		this.subMember = subMember;
	}
	public void setSubVolume(String subVolume) {
		this.subVolume = subVolume;
	}
	public void setSubValue(String subValue) {
		this.subValue = subValue;
	}
	public void setSubbsvRevenueBelow(String subbsvRevenueBelow) {
		this.subbsvRevenueBelow = subbsvRevenueBelow;
	}
	public void setSubVolumeAbove(String subVolumeAbove) {
		this.subVolumeAbove = subVolumeAbove;
	}
	public void setSubValueAbove(String subValueAbove) {
		this.subValueAbove = subValueAbove;
	}
	public void setSubBsvRevenueAbove(String subBsvRevenueAbove) {
		this.subBsvRevenueAbove = subBsvRevenueAbove;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(reportName == null ? "" : rightPadding(reportName, 78));		
		builder.append(System.lineSeparator());		
		builder.append(monthtoDateString == null ? "" : rightPadding(monthtoDateString, 55));
		builder.append(System.lineSeparator());		
		builder.append(summaryHeader == null ? "" : rightPadding(summaryHeader, 42));
		
		builder.append(System.lineSeparator());
		
		builder.append(memberNameHeader == null ? "" : rightPadding("", 2)+rightPadding(memberNameHeader, 6) );
		builder.append(subService == null ? "" : rightPadding("", 2)+rightPadding(subService, 22));
		builder.append(volumeBelow == null ? "" : rightPadding("", 8)+rightPadding(volumeBelow, 10));
		builder.append(valueBelow == null ? "" : rightPadding("", 2)+rightPadding(valueBelow, 14));
		builder.append(bsvRevenueBelow == null ? "" : rightPadding("", 2)+rightPadding(bsvRevenueBelow, 13));
		builder.append(volumeAbove == null ? "" : rightPadding("", 1)+rightPadding(volumeAbove, 11));
		builder.append(valueAbove == null ? "" : rightPadding("", 2)+rightPadding(valueAbove, 17));
		builder.append(bsvRevenueAbove == null ? "" : rightPadding("", 2)+rightPadding(bsvRevenueAbove, 13));
		
		builder.append(System.lineSeparator());
		
		builder.append(subMember == null ? "" : rightPadding("", 2)+rightPadding(subMember, 6));
		builder.append("" == null ? "" : rightPadding("", 2)+rightPadding("", 22));
		builder.append(subVolume == null ? "" : rightPadding("", 8)+rightPadding(subVolume, 10));
		builder.append(subValue == null ? "" : rightPadding("", 2)+rightPadding(subValue, 14));
		builder.append(subbsvRevenueBelow == null ? "" : rightPadding("", 2)+rightPadding(subbsvRevenueBelow, 13));
		builder.append(subValueAbove == null ? "" : rightPadding("", 1)+rightPadding(subValueAbove, 11));
		builder.append(subValueAbove == null ? "" : rightPadding("", 2)+rightPadding(subValueAbove, 17));
		builder.append(subBsvRevenueAbove  == null ? "" : rightPadding("", 2)+rightPadding(subBsvRevenueAbove, 13));
		
		builder.append(System.lineSeparator());
		
		
		builder.append(membernameUnderLine == null ? "" : rightPadding("", 2)+rightPadding(membernameUnderLine, 6));
		builder.append(subServiceUnderLine == null ? "" : rightPadding("", 2)+rightPadding(subServiceUnderLine, 18));
		builder.append(volumeUnderLine == null ? "" : rightPadding("", 2)+rightPadding(volumeUnderLine, 10));
		builder.append(valueBelowUnderLine == null ? "" : rightPadding("", 2)+rightPadding(valueBelowUnderLine, 10));
		builder.append(bsvRevenueBelowUnderLine == null ? "" : rightPadding("", 2)+rightPadding(bsvRevenueBelowUnderLine, 13));
		builder.append(volumeAboveUnderLine == null ? "" : rightPadding("", 1)+rightPadding(volumeAboveUnderLine, 9));
		builder.append(valueAboveUnderLine == null ? "" : rightPadding("", 2)+rightPadding(valueAboveUnderLine, 13));
		builder.append(bsvRevenueAboveUnderLine == null ? "" : rightPadding("", 2)+rightPadding(bsvRevenueAboveUnderLine, 13));
		
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

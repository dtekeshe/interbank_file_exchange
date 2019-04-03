package com.bsva.dmcs.file.reports;

public class CCR420TransReportsHeader {
	
	private String headerRecordCount;
	private String headerTransAmount;
	
	
	public CCR420TransReportsHeader() {
		super();
	}


	public String getHeaderRecordCount() {
		return headerRecordCount;
	}


	public String getHeaderTransAmount() {
		return headerTransAmount;
	}


	public void setHeaderRecordCount(String headerRecordCount) {
		this.headerRecordCount = headerRecordCount;
	}


	public void setHeaderTransAmount(String headerTransAmount) {
		this.headerTransAmount = headerTransAmount;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(headerTransAmount == null ? rightPadding(" ",35) :rightPadding(headerTransAmount,35));
		builder.append(headerRecordCount == null ? rightPadding(" ",35) :rightPadding(headerRecordCount,35));
		return builder.toString();
	}
	
	public static String rightPadZeros(String str, int num) {
	    return String.format("%1$-" + num + "s", str).replace(' ', ' ');
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

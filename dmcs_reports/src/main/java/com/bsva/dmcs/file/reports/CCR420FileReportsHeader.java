package com.bsva.dmcs.file.reports;



public class CCR420FileReportsHeader {
	
	private String headerRefNumber;
	private String headerOutputDate;
	private String headerNumberOfRecords;
	private String headerProcessStatus;
	private String headerSystemSeqNuber;
	
	
	public CCR420FileReportsHeader() {
		super();
	}


	public String getHeaderRefNumber() {
		return headerRefNumber;
	}


	public String getHeaderOutputDate() {
		return headerOutputDate;
	}


	public String getHeaderNumberOfRecords() {
		return headerNumberOfRecords;
	}


	public String getHeaderProcessStatus() {
		return headerProcessStatus;
	}


	public String getHeaderSystemSeqNuber() {
		return headerSystemSeqNuber;
	}


	public void setHeaderRefNumber(String headerRefNumber) {
		this.headerRefNumber = headerRefNumber;
	}


	public void setHeaderOutputDate(String headerOutputDate) {
		this.headerOutputDate = headerOutputDate;
	}


	public void setHeaderNumberOfRecords(String headerNumberOfRecords) {
		this.headerNumberOfRecords = headerNumberOfRecords;
	}


	public void setHeaderProcessStatus(String headerProcessStatus) {
		this.headerProcessStatus = headerProcessStatus;
	}


	public void setHeaderSystemSeqNuber(String headerSystemSeqNuber) {
		this.headerSystemSeqNuber = headerSystemSeqNuber;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(headerRefNumber == null ? rightPadding(" ",35) :rightPadding(headerRefNumber,35));
		builder.append(headerOutputDate == null ? rightPadding(" ",35) :rightPadding(headerOutputDate,35));
		builder.append(headerNumberOfRecords == null ? rightPadding(" ",35) :rightPadding(headerNumberOfRecords,35));
		builder.append(headerProcessStatus == null ? rightPadding(" ",35) :rightPadding(headerProcessStatus,35));
		builder.append(headerSystemSeqNuber == null ? rightPadding(" ",35) :rightPadding(headerSystemSeqNuber,35));
		
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

package com.bsva.dmcs.file.reports;

public class CCR420FileReportsDto {
	
	private String fileRefNumber;
	private String fileOutputDate;
	private String fileNumberOfRecords;
	private String fileProcessStatus;
	private String fileSystemSeqNuber;
	
	
	public CCR420FileReportsDto() {
		super();
	}


	public String getFileRefNumber() {
		return fileRefNumber;
	}


	public String getFileOutputDate() {
		return fileOutputDate;
	}


	public String getFileNumberOfRecords() {
		return fileNumberOfRecords;
	}


	public String getFileProcessStatus() {
		return fileProcessStatus;
	}


	public String getFileSystemSeqNuber() {
		return fileSystemSeqNuber;
	}


	public void setFileRefNumber(String fileRefNumber) {
		this.fileRefNumber = fileRefNumber;
	}


	public void setFileOutputDate(String fileOutputDate) {
		this.fileOutputDate = fileOutputDate;
	}


	public void setFileNumberOfRecords(String fileNumberOfRecords) {
		this.fileNumberOfRecords = fileNumberOfRecords;
	}


	public void setFileProcessStatus(String fileProcessStatus) {
		this.fileProcessStatus = fileProcessStatus;
	}


	public void setFileSystemSeqNuber(String fileSystemSeqNuber) {
		this.fileSystemSeqNuber = fileSystemSeqNuber;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(fileRefNumber == null ? rightPadding(" ",25) :rightPadding(fileRefNumber,25));
		builder.append(fileOutputDate == null ? rightPadding(" ",25) :rightPadding(fileOutputDate,25));
		builder.append(fileNumberOfRecords == null ? rightPadding(" ",25) :rightPadding(fileNumberOfRecords,25));
		builder.append(fileProcessStatus == null ? rightPadding(" ",25) :rightPadding(fileProcessStatus,25));
		builder.append(fileSystemSeqNuber == null ? rightPadding(" ",25) :rightPadding(fileSystemSeqNuber,25));
		
		
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

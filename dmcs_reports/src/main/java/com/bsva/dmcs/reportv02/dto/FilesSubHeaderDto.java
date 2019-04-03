package com.bsva.dmcs.reportv02.dto;

public class FilesSubHeaderDto {
	
	private String bankName;
	private String reportName;
	private String timeStamp;
	private String bankLongName;
	private String date;
	private String page;
	private String pageNumber;
	private String registration;
	
	
	
	//public static String ccr00xFilepath(String filename) {
	//	return REPORT_FOLDER + FILE_SEPARATOR + filename;
	//}

	public String getBankName() {
		return bankName;
	}

	public String getReportName() {
		return reportName;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public String getBankLongName() {
		return bankLongName;
	}

	public String getDate() {
		return date;
	}

	public String getPage() {
		return page;
	}

	public String getPageNumber() {
		return pageNumber;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setBankLongName(String bankLongName) {
		this.bankLongName = bankLongName;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(bankName == null ? "" :rightPadding(bankName, 8));
		builder.append(reportName == null ? "" : rightPadding(reportName,10));
		builder.append(timeStamp == null ? "" : rightPadding(timeStamp, 26));
		builder.append(bankLongName == null ? "" : rightPadding(bankLongName, 62));
		builder.append(date == null ? "" : rightPadding(date, 14));
		builder.append(page == null ? "" : rightPadding(page, 11));
		builder.append(pageNumber == null ? "" : rightPadding(pageNumber, 2));
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		builder.append(registration == null ? "" : rightPadding("", 76)+ rightPadding(registration, 22));
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



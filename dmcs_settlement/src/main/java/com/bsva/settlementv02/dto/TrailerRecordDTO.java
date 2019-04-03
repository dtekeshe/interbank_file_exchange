package com.bsva.settlementv02.dto;


public class TrailerRecordDTO {
	
	private String trailerInd;
	private String trailerService;
	private String trailerSubService;
	private String trailerCurrency;
	private int    trailerMemberCntl;
	private Long   trailerTime;
	private String trailerStatus;
	private String    trailerNoOfRecords;
	private String trailerFiller;
	
	public String getTrailerInd() {
		return trailerInd;
	}
	public void setTrailerInd(String trailerInd) {
		this.trailerInd = trailerInd;
	}
	public String getTrailerService() {
		return trailerService;
	}
	public void setTrailerService(String trailerService) {
		this.trailerService = trailerService;
	}
	public String getTrailerSubService() {
		return trailerSubService;
	}
	public void setTrailerSubService(String trailerSubService) {
		this.trailerSubService = trailerSubService;
	}
	public String getTrailerCurrency() {
		return trailerCurrency;
	}
	public void setTrailerCurrency(String trailerCurrency) {
		this.trailerCurrency = trailerCurrency;
	}
	public int getTrailerMemberCntl() {
		return trailerMemberCntl;
	}
	public void setTrailerMemberCntl(int trailerMemberCntl) {
		this.trailerMemberCntl = trailerMemberCntl;
	}
	public Long getTrailerTime() {
		return trailerTime;
	}
	public void setTrailerTime(Long trailerTime) {
		this.trailerTime = trailerTime;
	}
	public String getTrailerStatus() {
		return trailerStatus;
	}
	public void setTrailerStatus(String trailerStatus) {
		this.trailerStatus = trailerStatus;
	}
	public String getTrailerNoOfRecords() {
		return volumeZeroFiler(trailerNoOfRecords);
	}
	public void setTrailerNoOfRecords(String trailerNoOfRecords) {
		this.trailerNoOfRecords = trailerNoOfRecords;
	}
	public String getTrailerFiller() {
		return trailerFiller;
	}
	public void setTrailerFiller(String trailerFiller) {
		this.trailerFiller = trailerFiller;
	}
	public String volumeZeroFiler(String value){
		return String.format("%08d",Long.valueOf(value));	
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(trailerInd  == null ? "": rightPadding(trailerInd,1));
		builder.append(trailerService  == null ? "": rightPadding(trailerService,5));
		builder.append(trailerSubService == null ? "": rightPadding(trailerSubService,5));
		builder.append(trailerCurrency == null ? "": rightPadding(trailerCurrency,3));
		builder.append(trailerMemberCntl == 0 ? "0": rightPadding(String.valueOf(trailerMemberCntl),4));
		builder.append(trailerTime == null ?"": rightPadding(String.valueOf(trailerTime),8));
		builder.append(trailerStatus == null ?"": rightPadding(trailerStatus,1));
		builder.append(trailerNoOfRecords == null ?"":rightPadding(trailerNoOfRecords,8));
		//builder.append(trailerFiller == null ?"":trailerFiller);
		return builder.toString();
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
	 * @param str
	 * @param num
	 * @return
	 */
	public static String rightPadding(String str, int num) {
		return String.format("%1$-" + num + "s", str);
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
	public static String rightPadZeros(String str, int num) {
		return String.format("%1$-" + num + "s", str).replace(' ', '0');
	}


}

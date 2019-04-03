package com.bsva.settlementv02.dto;


public class ControlRecordDTO {
	
	private String controlInd;
	private String controlService;
	private String controlSubservice;
	private String controlCurrency;
	private String controlMemberCntl;
	private Long controlTime;
	private String controlStatus;
	private String controlNoOfRecords;
	private String controlFiller;
	
	public String getControlInd() {
		return controlInd;
	}
	public void setControlInd(String controlInd) {
		this.controlInd = controlInd;
	}
	public String getControlService() {
		return controlService;
	}
	public void setControlService(String controlService) {
		this.controlService = controlService;
	}
	public String getControlSubservice() {
		return controlSubservice;
	}
	public void setControlSubservice(String controlSubservice) {
		this.controlSubservice = controlSubservice;
	}
	public String getControlCurrency() {
		return controlCurrency;
	}
	public void setControlCurrency(String controlCurrency) {
		this.controlCurrency = controlCurrency;
	}
	public String getControlMemberCntl() {
		return controlMemberCntl;
	}
	public void setControlMemberCntl(String controlMemberCntl) {
		this.controlMemberCntl = controlMemberCntl;
	}
	public Long getControlTime() {
		return controlTime;
	}
	public void setControlTime(Long controlTime) {
		this.controlTime = controlTime;
	}
	public String getControlStatus() {
		return controlStatus;
	}
	public void setControlStatus(String controlStatus) {
		this.controlStatus = controlStatus;
	}
	public String getControlNoOfRecords() {
		return volumeZeroFiler(controlNoOfRecords);
	}
	public void setControlNoOfRecords(String controlNoOfRecords) {
		this.controlNoOfRecords = controlNoOfRecords;
	}
	public String getControlFiller() {
		return controlFiller;
	}
	public void setControlFiller(String controlFiller) {
		this.controlFiller = controlFiller;
	}

	public String volumeZeroFiler(String value){
		return String.format("%08d",Long.valueOf(value));	
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(controlInd == null ? "" : rightPadding(controlInd,1));
		builder.append(controlService == null ? "" : rightPadding(controlService,5));
		builder.append(controlSubservice == null ? "" :  rightPadding(controlSubservice,5));
		builder.append(controlCurrency == null ? "" : rightPadding(controlCurrency,3));
		builder.append(controlMemberCntl == null ? "" :  rightPadding(controlMemberCntl,4));
		builder.append(controlTime == null ? "" :  rightPadding(String.valueOf(controlTime),8));
		builder.append(controlStatus == null ? "" :  rightPadding(controlStatus,1));
		builder.append(controlNoOfRecords == null ? "" :  rightPadding(controlNoOfRecords,8));
		//builder.append(controlFiller == null ? "" :  controlFiller);
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
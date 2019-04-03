package com.bsva.settlementv02.dto;


public class DetailRecordDTO {
	
	private String settleDetailInd;
	private String settleDetailService;
	private String settleDetailSubService;
	private String settleDetailCentre;
	private String settleDetailCurrency;
	private String settleDetailAltCurrency;
	private String settleDetailRange;
	private String settleDetailActionDate;
	private String settleDetailMemberIn;
	private String SettleDetailMemberOut;
	private String settleDetailVolume;
	private String settleDetailValue;
	private String settleDetailSign;
	private String settleDetailMemberCntl;
	private String settleDetailFiller;
	
	public String getSettleDetailInd() {
		return settleDetailInd;
	}
	public void setSettleDetailInd(String settleDetailInd) {
		this.settleDetailInd = settleDetailInd;
	}
	
	public String getSettleDetailService() {
		return settleDetailService;
	}
	public void setSettleDetailService(String settleDetailService) {
		this.settleDetailService = settleDetailService;
	}
	
	public String getSettleDetailSubService() {
		return settleDetailSubService;
	}
	public void setSettleDetailSubService(String settleDetailSubService) {
		this.settleDetailSubService = settleDetailSubService;
	}
	
	public String getSettleDetailCentre() {
		return settleDetailCentre;
	}
	public void setSettleDetailCentre(String settleDetailCentre) {
		this.settleDetailCentre = settleDetailCentre;
	}
	
	public String getSettleDetailCurrency() {
		return settleDetailCurrency;
	}
	public void setSettleDetailCurrency(String settleDetailCurrency) {
		this.settleDetailCurrency = settleDetailCurrency;
	}
	
	public String getSettleDetailAltCurrency() {
		return settleDetailAltCurrency;
	}
	public void setSettleDetailAltCurrency(String settleDetailAltCurrency) {
		this.settleDetailAltCurrency = settleDetailAltCurrency;
	}
	
	public String getSettleDetailRange() {
		return settleDetailRange;
	}
	public void setSettleDetailRange(String settleDetailRange) {
		this.settleDetailRange = settleDetailRange;
	}
	
	public String getSettleDetailActionDate() {
		return settleDetailActionDate;
	}
	public void setSettleDetailActionDate(String settleDetailActionDate) {
		this.settleDetailActionDate = settleDetailActionDate;
	}
	
	public String getSettleDetailMemberIn() {
		return settleDetailMemberIn;
	}
	public void setSettleDetailMemberIn(String settleDetailMemberIn) {
		this.settleDetailMemberIn = settleDetailMemberIn;
	}
	
	public String getSettleDetailMemberOut() {
		return SettleDetailMemberOut;
	}
	public void setSettleDetailMemberOut(String settleDetailMemberOut) {
		SettleDetailMemberOut = settleDetailMemberOut;
	}
	
	public String getSettleDetailVolume() {
		return volumeZeroFiler(settleDetailVolume);
	}
	public void setSettleDetailVolume(String settleDetailVolume) {
		this.settleDetailVolume = settleDetailVolume;
	}
	
	public String getSettleDetailValue() {
		return valueZeroFiler(settleDetailValue);
	}
	public void setSettleDetailValue(String settleDetailValue) {
		this.settleDetailValue = settleDetailValue;
	}
	
	public String getSettleDetailSign() {
		return settleDetailSign;
	}
	public void setSettleDetailSign(String settleDetailSign) {
		this.settleDetailSign = settleDetailSign;
	}
	
	public String getSettleDetailMemberCntl() {
		return settleDetailMemberCntl;
	}
	public void setSettleDetailMemberCntl(String settleDetailMemberCntl) {
		this.settleDetailMemberCntl = settleDetailMemberCntl;
	}
	
	public String getSettleDetailFiller() {
		return settleDetailFiller;
	}
	public void setSettleDetailFiller(String settleDetailFiller) {
		this.settleDetailFiller = settleDetailFiller;
	}
	
	public String valueZeroFiler(String value){
		return String.format("%014d",Long.valueOf(value)).replace(".", "");	
	}

	public String volumeZeroFiler(String value){
		return String.format("%08d",Long.valueOf(value));	
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(settleDetailInd == null ? "" : rightPadding(settleDetailInd,1));
		builder.append(settleDetailService == null ? "" : rightPadding(settleDetailService,5));
		builder.append(settleDetailSubService == null ? "" : rightPadding(settleDetailSubService,5));
		builder.append(settleDetailCentre == null ? "" : rightPadding(settleDetailCentre,3));
		builder.append(settleDetailCurrency == null ? "" : rightPadding(settleDetailCurrency,3));
		builder.append(settleDetailAltCurrency == null ? "" : rightPadding(settleDetailAltCurrency,3));
		builder.append(settleDetailRange == null ? "" : rightPadding(settleDetailRange,4));
		builder.append(settleDetailActionDate == null ? "" : rightPadding(settleDetailActionDate,8));
		builder.append(settleDetailMemberIn == null ? "" : rightPadding(settleDetailMemberIn,6));
		builder.append(SettleDetailMemberOut == null ? "" : rightPadding(SettleDetailMemberOut,6));
		builder.append(settleDetailVolume == null ? "" : leftPadZeros(settleDetailVolume,8));
		builder.append(settleDetailValue == null ? "" : leftPadZeros(settleDetailValue,14));
		builder.append(settleDetailSign == null ? "" : rightPadding(settleDetailSign,2));
		builder.append(settleDetailMemberCntl == null ? "" : rightPadding(settleDetailMemberCntl,4));
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

package com.bsva.settlementv02.dto;


public class HeaderRecordDTO {
	
	private String headerDetailInd;
	private String headerService;
	private String headerSubService;
	private String headerCentre;
	private String headerCurrency;
	private String headerSettlementDate;
	private String headerInputDate;
	private String headerLiveInd;
	private String headerMemberCntl;
	private String headerDescription;
	private String headerCurrDesc;
	private String headerAgreementNo;
	private String headerEndOfService;
	private String headerFiller;
	
	
	public String getHeaderDetailInd() {
		return headerDetailInd;
	}
	
	public void setHeaderDetailInd(String headerDetailInd) {
		this.headerDetailInd = headerDetailInd;
	}
	
	public String getHeaderService() {
		return headerService;
	}
	public void setHeaderService(String headerService) {
		this.headerService = headerService;
	}
	public String getHeaderSubService() {
		return headerSubService;
	}

	public void setHeaderSubService(String headerSubService) {
		this.headerSubService = headerSubService;
	}
	public String getHeaderCentre() {
		return headerCentre;
	}

	public void setHeaderCentre(String headerCentre) {
		this.headerCentre = headerCentre;
	}
	public String getHeaderCurrency() {
		return headerCurrency;
	}
	public void setHeaderCurrency(String headerCurrency) {
		this.headerCurrency = headerCurrency;
	}
	
	public String getHeaderSettlementDate() {
		return headerSettlementDate;
	}
	public void setHeaderSettlementDate(String headerSettlementDate) {
		this.headerSettlementDate = headerSettlementDate;
	}
	
	public String getHeaderInputDate() {
		return headerInputDate;
	}
	public void setHeaderInputDate(String headerInputDate) {
		this.headerInputDate = headerInputDate;
	}
	
	public String getHeaderLiveInd() {
		return headerLiveInd;
	}
	public void setHeaderLiveInd(String headerLiveInd) {
		this.headerLiveInd = headerLiveInd;
	}
	
	public String getHeaderMemberCntl() {
		return headerMemberCntl;
	}
	public void setHeaderMemberCntl(String headerMemberCntl) {
		this.headerMemberCntl = headerMemberCntl;
	}
	
	public String getHeaderDescription() {
		return headerDescription;
	}
	public void setHeaderDescription(String headerDescription) {
		this.headerDescription = headerDescription;
	}
	
	public String getHeaderCurrDesc() {
		return headerCurrDesc;
	}
	public void setHeaderCurrDesc(String headerCurrDesc) {
		this.headerCurrDesc = headerCurrDesc;
	}
	public String getHeaderAgreementNo() {
		return headerAgreementNo;
	}
	public void setHeaderAgreementNo(String headerAgreementNo) {
		this.headerAgreementNo = headerAgreementNo;
	}
	public String getHeaderEndOfService() {
		return headerEndOfService;
	}
	public void setHeaderEndOfService(String headerEndOfService) {
		this.headerEndOfService = headerEndOfService;
	}
	public String getHeaderFiller() {
		return headerFiller;
	}
	public void setHeaderFiller(String headerFiller) {
		this.headerFiller = headerFiller;
	}
	//DCARD VISA JHBZAR2018110120181130L0001DMCS SETTLEMENT FOR VISA CARDSUBSERVICE           REPUBLIC OF SOUTH AFRICA - RANDS                  45N
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(headerDetailInd == null ?"": rightPadding(headerDetailInd,1));
		builder.append(headerService == null ?"": rightPadding(headerService,5));
		builder.append(headerSubService == null ?"": rightPadding(headerSubService,5));
		builder.append(headerCentre == null ?"": padRight(headerCentre,3));
		builder.append(headerCurrency == null ?"": rightPadding(headerCurrency,3));
		builder.append(headerSettlementDate == null ?"": rightPadding(headerSettlementDate,8));
		builder.append(headerInputDate == null ?"": rightPadding(headerInputDate,8));
		builder.append(headerLiveInd == null ?"": rightPadding(headerLiveInd,1));
		builder.append(headerMemberCntl == null ?"": rightPadding(headerMemberCntl,4));
		builder.append(headerDescription == null ?"": rightPadding(headerDescription,50));
		builder.append(headerCurrDesc == null ?"": rightPadding(headerCurrDesc,50));
		builder.append(headerAgreementNo == null ?"": rightPadding(headerAgreementNo,2));
		builder.append(headerEndOfService == null ?"": rightPadding(headerEndOfService,1));
		//builder.append(headerFiller == null ?"": headerFiller);
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

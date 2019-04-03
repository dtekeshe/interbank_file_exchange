package com.bsva.dmcs.reportv02.dto;

public class FileDistributionReportDto {

	private String regNo;
	private String internal;
	private String trxnDisReport;
	private String trxnCarriedForward;
	private String trxnCarriedForwardDate;
	private String debitUnderLine;
	private String creditUnderLine;
	private String service;
	private String subService;
	private String typeCode;
	private String creditVolume;
	private String creditValue;
	private String underService;
	private String underSubService;
	private String underTypeCode;
	private String underDebitVolume ;
	private String underDebitValue;
	
	private String NoService;
	private String paymentSubService;
	private String paymentDebitVolume;
	private String paymentDebitValue;
	
	
	
	public String getUnderTypeCode() {
		return underTypeCode;
	}

	public void setUnderTypeCode(String underTypeCode) {
		this.underTypeCode = underTypeCode;
	}

	public String getDebitUnderLine() {
		return debitUnderLine;
	}

	public String getCreditUnderLine() {
		return creditUnderLine;
	}

	public void setDebitUnderLine(String debitUnderLine) {
		this.debitUnderLine = debitUnderLine;
	}

	public void setCreditUnderLine(String creditUnderLine) {
		this.creditUnderLine = creditUnderLine;
	}

	public String getRegNo() {
		return regNo;
	}

	public String getInternal() {
		return internal;
	}

	public String getTrxnDisReport() {
		return trxnDisReport;
	}

	public String getTrxnCarriedForward() {
		return trxnCarriedForward;
	}

	public String getTrxnCarriedForwardDate() {
		return trxnCarriedForwardDate;
	}

	public String getService() {
		return service;
	}

	public String getSubService() {
		return subService;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public String getCreditVolume() {
		return creditVolume;
	}

	public String getCreditValue() {
		return creditValue;
	}

	public String getUnderService() {
		return underService;
	}

	public String getUnderSubService() {
		return underSubService;
	}

	public String getUnderDebitVolume() {
		return underDebitVolume;
	}

	public String getUnderDebitValue() {
		return underDebitValue;
	}


	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public void setInternal(String internal) {
		this.internal = internal;
	}

	public void setTrxnDisReport(String trxnDisReport) {
		this.trxnDisReport = trxnDisReport;
	}

	public void setTrxnCarriedForward(String trxnCarriedForward) {
		this.trxnCarriedForward = trxnCarriedForward;
	}

	public void setTrxnCarriedForwardDate(String trxnCarriedForwardDate) {
		this.trxnCarriedForwardDate = trxnCarriedForwardDate;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setSubService(String subService) {
		this.subService = subService;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public void setCreditVolume(String creditVolume) {
		this.creditVolume = creditVolume;
	}

	public void setCreditValue(String creditValue) {
		this.creditValue = creditValue;
	}
	public void setUnderService(String underService) {
		this.underService = underService;
	}

	public void setUnderSubService(String underSubService) {
		this.underSubService = underSubService;
	}

	public void setUnderDebitVolume(String underDebitVolume) {
		this.underDebitVolume = underDebitVolume;
	}

	public void setUnderDebitValue(String underDebitValue) {
		this.underDebitValue = underDebitValue;
	}

	public String getNoService() {
		return NoService;
	}

	public String getPaymentSubService() {
		return paymentSubService;
	}

	public String getPaymentDebitVolume() {
		return paymentDebitVolume;
	}

	public String getPaymentDebitValue() {
		return paymentDebitValue;
	}


	public void setNoService(String noService) {
		NoService = noService;
	}

	public void setPaymentSubService(String paymentSubService) {
		this.paymentSubService = paymentSubService;
	}

	public void setPaymentDebitVolume(String paymentDebitVolume) {
		this.paymentDebitVolume = paymentDebitVolume;
	}

	public void setPaymentDebitValue(String paymentDebitValue) {
		this.paymentDebitValue = paymentDebitValue;
	}


	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append(regNo == null ? "" :rightPadding("", 54)+ rightPadding(regNo, 26));
		builder.append(System.lineSeparator());
		builder.append(internal == null ? "" : rightPadding(internal, 39));
		builder.append(trxnDisReport == null ? "" : rightPadding(trxnDisReport, 98));
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		
		builder.append(trxnCarriedForward == null ? "" : rightPadding("", 44)+rightPadding(trxnCarriedForward, 33));
		builder.append(trxnCarriedForwardDate == null ? "" : rightPadding(trxnCarriedForwardDate, 11));
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		
		builder.append(debitUnderLine == null ? "" : rightPadding("",55)+rightPadding(debitUnderLine, 7));
		builder.append(creditUnderLine == null ? "" : rightPadding("",25)+rightPadding(creditUnderLine, 7));
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		
		builder.append(service == null ? "" : rightPadding(service,8));
		builder.append(subService == null ? "" : rightPadding("", 10)+ rightPadding(subService, 11));
		builder.append(typeCode == null ? "" : rightPadding("", 3)+ rightPadding(typeCode, 9));
		builder.append(creditVolume == null ? "" : rightPadding("", 6)+ rightPadding(creditVolume, 10));
		builder.append(creditValue == null ? "" :  rightPadding("", 6)+ rightPadding(creditValue, 10));
		builder.append(System.lineSeparator());
		
		builder.append(underService == null ? "" : rightPadding(underService,7));
		builder.append(underSubService == null ? "" : rightPadding("", 12)+ rightPadding(underSubService, 1));
		builder.append(underTypeCode == null ? "" : rightPadding("", 2)+rightPadding(underTypeCode,10));
		builder.append(underDebitVolume == null ? "" : rightPadding("", 2)+ rightPadding(underDebitVolume, 9));
		builder.append(underDebitValue == null ? "" : rightPadding("", 2)+ rightPadding(underDebitValue, 10));
		builder.append(System.lineSeparator());
		
		builder.append(NoService == null ? "" : rightPadding(NoService,19));
		builder.append(paymentSubService == null ? "" : rightPadding(paymentSubService, 11));
		builder.append(paymentDebitVolume == null ? "" : rightPadding("", 15) +rightPadding(paymentDebitVolume, 16));
		builder.append(paymentDebitValue == null ? "" : rightPadding(paymentDebitValue, 16));
		
		
		builder.append(System.lineSeparator());
		
		return builder.toString();
	}

	/**
	 * @param s
	 * @param n
	 * @return
	 */
	// used to format String for FileWriter
	public static String padLeftString(String s, int n) {
		return String.format("%0$" + n + "s", s).replace(' ', '0');
	}
	
	/**
	 * @param s
	 * @param n
	 * @return
	 */
	// used to format String for FileWriter
	public static String padRightString(String s, int n) {
		return String.format("%0$" + n + "s", s).replace(' ', '0');
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
}

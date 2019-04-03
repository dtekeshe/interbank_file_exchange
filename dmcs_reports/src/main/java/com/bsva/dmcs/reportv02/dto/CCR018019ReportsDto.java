package com.bsva.dmcs.reportv02.dto;

public class CCR018019ReportsDto {

	private String issuerMember;

	private String acquirerMember;

	private String cardType;

	private String transactionCode;

	private String acqBin;

	private String volume;

	private String value;

	private String nettInterChange;

	private String nettVat;

	private String reportNumber;

	public CCR018019ReportsDto() {

	}

	public String getIssuerMember() {
		return issuerMember;
	}

	public String getAcquirerMember() {
		return acquirerMember;
	}

	public String getCardType() {
		return cardType;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public String getAcqBin() {
		return acqBin;
	}

	public String getVolume() {
		return volume;
	}

	public String getValue() {
		return value;
	}

	public String getNettInterChange() {
		return nettInterChange;
	}

	public String getNettVat() {
		return nettVat;
	}

	public void setIssuerMember(String issuerMember) {
		this.issuerMember = issuerMember;
	}

	public void setAcquirerMember(String acquirerMember) {
		this.acquirerMember = acquirerMember;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public void setAcqBin(String acqBin) {
		this.acqBin = acqBin;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setNettInterChange(String nettInterChange) {
		this.nettInterChange = nettInterChange;
	}

	public void setNettVat(String nettVat) {
		this.nettVat = nettVat;
	}

	public String getReportNumber() {
		return reportNumber;
	}

	public void setReportNumber(String reportNumber) {
		this.reportNumber = reportNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		if (reportNumber.equals("018")) {
			builder.append(issuerMember == null ? "" : leftPadZeros(issuerMember, 4));
			builder.append(",");
			builder.append(acquirerMember == null ? "" : leftPadZeros(acquirerMember, 4));
			builder.append(",");
		}
		else {
			builder.append(acquirerMember == null ? "" : leftPadZeros(acquirerMember, 4));
			builder.append(",");
			builder.append(issuerMember == null ? "" : leftPadZeros(issuerMember, 4));
			builder.append(",");
		}
		builder.append(cardType == null ? "" : leftPadZeros(cardType, 2));
		builder.append(",");
		builder.append(transactionCode == null ? "" : leftPadZeros(transactionCode, 2));
		builder.append(",");
		builder.append(acqBin == null ? "" : leftPadZeros(acqBin, 6));
		builder.append(",");
		builder.append(volume == null ? "" : padRight(volume, 10));
		builder.append(",");
		builder.append(value == null ? "" : padRight(value, 15));
		builder.append(",");
		builder.append(nettInterChange == null ? "" : padRight(nettInterChange, 12));
		builder.append(",");
		builder.append(nettVat == null ? "" : padRight(nettVat, 10));
		builder.append(System.lineSeparator());
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

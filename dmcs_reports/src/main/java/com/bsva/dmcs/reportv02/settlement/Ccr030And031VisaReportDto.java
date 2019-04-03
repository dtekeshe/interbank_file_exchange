package com.bsva.dmcs.reportv02.settlement;

public class Ccr030And031VisaReportDto {

	private String systemSeqNumber;

	private String acquirer;

	private String issuer;

	private String cardType;

	private String reportString;

	private String reportName;

	public Ccr030And031VisaReportDto() {

	}

	

	public String getSystemSeqNumber() {
		return systemSeqNumber;
	}



	public String getAcquirer() {
		return acquirer;
	}



	public String getIssuer() {
		return issuer;
	}



	public String getCardType() {
		return cardType;
	}



	public String getReportString() {
		return reportString;
	}



	public String getReportName() {
		return reportName;
	}



	public void setSystemSeqNumber(String systemSeqNumber) {
		this.systemSeqNumber = systemSeqNumber;
	}



	public void setAcquirer(String acquirer) {
		this.acquirer = acquirer;
	}



	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}



	public void setCardType(String cardType) {
		this.cardType = cardType;
	}



	public void setReportString(String reportString) {
		this.reportString = reportString;
	}



	public void setReportName(String reportName) {
		this.reportName = reportName;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (reportName.equals("031")) {
			builder.append(acquirer == null ? "" : acquirer);
			builder.append(",");
			builder.append(issuer == null ? "" : issuer);
		}
		else {
			builder.append(issuer == null ? "" : issuer);
			builder.append(",");
			builder.append(acquirer == null ? "" : acquirer);
		}
		builder.append(",");
		builder.append(reportString == null ? "" : reportString.substring(10));
		builder.append(System.lineSeparator());
		return builder.toString();
	}

}

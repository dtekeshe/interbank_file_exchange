package com.bsva.dmcs.reportv02.dto;

public class CsvSarbTotalsDto {
	
	private String processDate;
	private String acquirerMember;
	private String csvString;
	
	
	public CsvSarbTotalsDto() {
	}

	public CsvSarbTotalsDto(String acquirerMember, String csvString) {
		super();
		this.acquirerMember = acquirerMember;
		this.csvString = csvString;
	}

	public String getAcquirerMember() {
		return acquirerMember;
	}

	public String getCsvString() {
		return csvString;
	}

	public void setAcquirerMember(String acquirerMember) {
		this.acquirerMember = acquirerMember;
	}

	public void setCsvString(String csvString) {
		this.csvString = csvString;
	}
	
	public void setProcessDate(String processDate){
		this.processDate = processDate;
	}
	
	public String getProcessDate(){
		return processDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		char charac = '"';
		builder.append(charac);
		builder.append(processDate == null ? "" : processDate);
		builder.append(charac);
		builder.append(",");
		builder.append(charac);
		builder.append(acquirerMember== null ? "" : acquirerMember);
		builder.append(csvString == null ? "" : csvString);
		builder.append(System.lineSeparator());
		return builder.toString();
	}

}

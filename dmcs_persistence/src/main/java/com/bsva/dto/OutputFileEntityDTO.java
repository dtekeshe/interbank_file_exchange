package com.bsva.dto;

public class OutputFileEntityDTO {

	private String bankCode;
	private String originatingBank;
	private String fullFileIndicator;
	private String recordCount;
	private String hashTotal;
	private String statusCode;
	private String service;
	private String subService;
	private String fileNameDescription;
	private String lasteFileIndicator;
	private String seqNumber;
	private String drValue;
	private String distributionCode;
	private long drValueForDay;
	private long recordCountForDay;
	private String originatingMember;
	private String fileNamePrefix;
	
	public OutputFileEntityDTO(){
		
	}
	
	public String getSeqNumber() {
		return seqNumber;
	}

	public void setSeqNumber(String seqNumber) {
		this.seqNumber = seqNumber;
	}

	public String getBankCode() {
		return bankCode;
	}
	public String getOriginatingBank() {
		return originatingBank;
	}
	public String getFullFileIndicator() {
		return fullFileIndicator;
	}
	public String getRecordCount() {
		return recordCount;
	}
	public String getHashTotal() {
		return hashTotal;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public String getService() {
		return service;
	}
	public String getSubService() {
		return subService;
	}
	public String getFileNameDescription() {
		return fileNameDescription;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public void setOriginatingBank(String originatingBank) {
		this.originatingBank = originatingBank;
	}
	public void setFullFileIndicator(String fullFileIndicator) {
		this.fullFileIndicator = fullFileIndicator;
	}
	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}
	public void setHashTotal(String hashTotal) {
		this.hashTotal = hashTotal;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public void setService(String service) {
		this.service = service;
	}
	public void setSubService(String subService) {
		this.subService = subService;
	}
	public void setFileNameDescription(String fileNameDescription) {
		this.fileNameDescription = fileNameDescription;
	}

	public String getLasteFileIndicator() {
		return lasteFileIndicator;
	}

	public void setLasteFileIndicator(String lasteFileIndicator) {
		this.lasteFileIndicator = lasteFileIndicator;
	}

	public String getDrValue() {
		return drValue;
	}

	public void setDrValue(String drValue) {
		this.drValue = drValue;
	}

	public long getDrValueForDay() {
		return drValueForDay;
	}

	public long getRecordCountForDay() {
		return recordCountForDay;
	}

	public void setDrValueForDay(long drValueForDay) {
		this.drValueForDay = drValueForDay;
	}

	public void setRecordCountForDay(long recordCountForDay) {
		this.recordCountForDay = recordCountForDay;
	}

	public String getOriginatingMember() {
		return originatingMember;
	}

	public void setOriginatingMember(String originatingMember) {
		this.originatingMember = originatingMember;
	}

	public String getDistributionCode() {
		return distributionCode;
	}

	public void setDistributionCode(String distributionCode) {
		this.distributionCode = distributionCode;
	}

	public String getFileNamePrefix() {
		return fileNamePrefix;
	}

	public void setFileNamePrefix(String fileNamePrefix) {
		this.fileNamePrefix = fileNamePrefix;
	}

}

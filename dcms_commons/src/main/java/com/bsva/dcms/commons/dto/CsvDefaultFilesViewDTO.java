package com.bsva.dcms.commons.dto;

public class CsvDefaultFilesViewDTO {
	private int bankCode;
	private String destBankId;
	private int originatingBank;
	private String originatingId;
	private String filePrefix;
	private String service;
	private String subService;
	private int   seq;
	private String lastFileInd;
	
	
	public int getBankCode() {
		return bankCode;
	}
	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
	}
	public String getDestBankId() {
		return destBankId;
	}
	public void setDestBankId(String destBankId) {
		this.destBankId = destBankId;
	}
	public int getOriginatingBank() {
		return originatingBank;
	}
	public void setOriginatingBank(int originatingBank) {
		this.originatingBank = originatingBank;
	}
	public String getOriginatingId() {
		return originatingId;
	}
	public void setOriginatingId(String originatingId) {
		this.originatingId = originatingId;
	}
	public String getFilePrefix() {
		return filePrefix;
	}
	public void setFilePrefix(String filePrefix) {
		this.filePrefix = filePrefix;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getSubService() {
		return subService;
	}
	public void setSubService(String subService) {
		this.subService = subService;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getLastFileInd() {
		return lastFileInd;
	}
	public void setLastFileInd(String lastFileInd) {
		this.lastFileInd = lastFileInd;
	}
	

}

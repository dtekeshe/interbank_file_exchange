package com.bsva.dmcs.fileloadv02.dto;

import java.util.Date;


public class FileFooterDto {
	
	
	
	
	private String recordId;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FileFooterDto [recordId=");
		builder.append(recordId);
		builder.append(outputDate);
		builder.append(service);
		builder.append(subService);
		builder.append(serviceCode);
		builder.append(counterNumber);
		builder.append(padzeroOne);
		builder.append(paddAllEmpty);
		builder.append(padAllZero);
		builder.append(footerTextString);
		return builder.toString();
	}
	private Date outputDate;
	private String service;
	private String subService;
	private String serviceCode;
	private String counterNumber;
	private String padzeroOne;
	private String paddAllEmpty;
	private String padAllZero;
	private String status;
	private String footerTextString;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRecordId() {
		return recordId;
	}
	public Date getOutputDate() {
		return outputDate;
	}
	public String getService() {
		return service;
	}
	public String getSubService() {
		return subService;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public String getCounterNumber() {
		return counterNumber;
	}
	public String getPadzeroOne() {
		return padzeroOne;
	}
	public String getPaddAllEmpty() {
		return paddAllEmpty;
	}
	public String getPadAllZero() {
		return padAllZero;
	}
	public String getFooterTextString() {
		return footerTextString;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public void setOutputDate(Date outputDate) {
		this.outputDate = outputDate;
	}
	public void setService(String service) {
		this.service = service;
	}
	public void setSubService(String subService) {
		this.subService = subService;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public void setCounterNumber(String counterNumber) {
		this.counterNumber = counterNumber;
	}
	public void setPadzeroOne(String padzeroOne) {
		this.padzeroOne = padzeroOne;
	}
	public void setPaddAllEmpty(String paddAllEmpty) {
		this.paddAllEmpty = paddAllEmpty;
	}
	public void setPadAllZero(String padAllZero) {
		this.padAllZero = padAllZero;
	}
	public void setFooterTextString(String footerTextString) {
		this.footerTextString = footerTextString;
	}
	
	
	

}

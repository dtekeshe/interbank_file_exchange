package com.bsva.dmcs.reportv02.dto;

import com.bsva.dcms.commons.util.StringUtil;

public class FileFooterDto {
	
	private String recordId;
	private String outputDate;
	private String service;
	private String subService;
	private String serviceCode;
	private String counterNumber;
	private String padzeroOne;
	private String paddAllEmpty;
	private String padAllZero;
	private String footerTextString;
	
	
	public String getRecordId() {
		return recordId;
	}
	public String getOutputDate() {
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
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public void setOutputDate(String outputDate) {
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
	public String getFooterTextString() {
		return footerTextString;
	}
	public void setFooterTextString(String footerTextString) {
		this.footerTextString = footerTextString;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if(footerTextString != null){
		builder.append(footerTextString == null ? "" : StringUtil.leftJustify(String.valueOf(footerTextString),StringUtil.SPACE_STRING, 80));
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		}
		builder.append(recordId == null ? "" : StringUtil.leftJustify(String.valueOf(recordId),StringUtil.SPACE_STRING, 2));
		builder.append(outputDate == null ? "" : StringUtil.leftJustify(String.valueOf(outputDate),StringUtil.SPACE_STRING, 8));
		builder.append(service == null ? "" : StringUtil.leftJustify(String.valueOf(service),StringUtil.SPACE_STRING, 4));
		builder.append(subService == null ? "" : StringUtil.leftJustify(String.valueOf(subService),StringUtil.SPACE_STRING, 10));
		builder.append(serviceCode == null ? "" : StringUtil.rightJustify(String.valueOf(serviceCode),StringUtil.ZERO_STRING, 4));
		builder.append(counterNumber == null ? "" : StringUtil.leftJustify(String.valueOf(counterNumber),StringUtil.ZERO_STRING, 6));
		builder.append(padzeroOne == null ? "" : StringUtil.leftJustify(String.valueOf(padzeroOne),StringUtil.ZERO_STRING, 8));
		builder.append(paddAllEmpty == null ? "" : StringUtil.leftJustify(String.valueOf(paddAllEmpty),StringUtil.SPACE_STRING, 32));
		builder.append(padAllZero == null ? "" : StringUtil.leftJustify(String.valueOf(padAllZero),StringUtil.ZERO_STRING, 58));
		return builder.toString();
	}

}

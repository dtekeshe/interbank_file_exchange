package com.bsva.dcms.commons.dto.views;

import java.util.Date;

public class CsvSettlementViewDto {
	
	private int originatingBank;
	private int homingBank;
	private Date processDate;
	private String service;
	private String subService;
	private String settlementName;
	private String paymentStream;
	private String currencyCode;
	private String statusCode;
	private String settlementInd;
	private int crVolume;
	private double crValue;
	private int drVolume;
	private double drValue;
	
	public int getOriginatingBank() {
		return originatingBank;
	}
	public void setOriginatingBank(int originatingBank) {
		this.originatingBank = originatingBank;
	}
	public int getHomingBank() {
		return homingBank;
	}
	public void setHomingBank(int homingBank) {
		this.homingBank = homingBank;
	}
	public Date getProcessDate() {
		return processDate;
	}
	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
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
	public String getSettlementName() {
		return settlementName;
	}
	public void setSettlementName(String settlementName) {
		this.settlementName = settlementName;
	}
	public String getPaymentStream() {
		return paymentStream;
	}
	public void setPaymentStream(String paymentStream) {
		this.paymentStream = paymentStream;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getSettlementInd() {
		return settlementInd;
	}
	public void setSettlementInd(String settlementInd) {
		this.settlementInd = settlementInd;
	}
	public int getCrVolume() {
		return crVolume;
	}
	public void setCrVolume(int crVolume) {
		this.crVolume = crVolume;
	}
	public double getCrValue() {
		return crValue;
	}
	public void setCrValue(double crValue) {
		this.crValue = crValue;
	}
	public int getDrVolume() {
		return drVolume;
	}
	public void setDrVolume(int drVolume) {
		this.drVolume = drVolume;
	}
	public double getDrValue() {
		return drValue;
	}
	public void setDrValue(double drValue) {
		this.drValue = drValue;
	}
	
}

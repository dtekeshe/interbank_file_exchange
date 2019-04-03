package com.bsva.dcms.commons.dto;

import java.util.Date;



/**
 * @author AugustineA
 *
 */
public class SettlementViewsDTO {

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
	private int drVolume;
	private double crValue;
	private double drValue;
	
	public SettlementViewsDTO() {
		super();
	}

	public SettlementViewsDTO(int originatingBank, int homingBank,
			Date processDate, String service, String subService,
			String settlementName, String paymentStream, String currencyCode,
			String statusCode, String settlementInd, int crVolume,
			int drVolume, double crValue, double drValue) {
		super();
		this.originatingBank = originatingBank;
		this.homingBank = homingBank;
		this.processDate = processDate;
		this.service = service;
		this.subService = subService;
		this.settlementName = settlementName;
		this.paymentStream = paymentStream;
		this.currencyCode = currencyCode;
		this.statusCode = statusCode;
		this.settlementInd = settlementInd;
		this.crVolume = crVolume;
		this.drVolume = drVolume;
		this.crValue = crValue;
		this.drValue = drValue;
	}

	public int getOriginatingBank() {
		return originatingBank;
	}

	public int getHomingBank() {
		return homingBank;
	}

	public Date getProcessDate() {
		return processDate;
	}

	public String getService() {
		return service;
	}

	public String getSubService() {
		return subService;
	}

	public String getSettlementName() {
		return settlementName;
	}

	public String getPaymentStream() {
		return paymentStream;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getSettlementInd() {
		return settlementInd;
	}

	public int getCrVolume() {
		return crVolume;
	}

	public int getDrVolume() {
		return drVolume;
	}

	public double getCrValue() {
		return crValue;
	}

	public double getDrValue() {
		return drValue;
	}

	public void setOriginatingBank(int originatingBank) {
		this.originatingBank = originatingBank;
	}

	public void setHomingBank(int homingBank) {
		this.homingBank = homingBank;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setSubService(String subService) {
		this.subService = subService;
	}

	public void setSettlementName(String settlementName) {
		this.settlementName = settlementName;
	}

	public void setPaymentStream(String paymentStream) {
		this.paymentStream = paymentStream;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public void setSettlementInd(String settlementInd) {
		this.settlementInd = settlementInd;
	}

	public void setCrVolume(int crVolume) {
		this.crVolume = crVolume;
	}

	public void setDrVolume(int drVolume) {
		this.drVolume = drVolume;
	}

	public void setCrValue(double crValue) {
		this.crValue = crValue;
	}

	public void setDrValue(double drValue) {
		this.drValue = drValue;
	}
	
}

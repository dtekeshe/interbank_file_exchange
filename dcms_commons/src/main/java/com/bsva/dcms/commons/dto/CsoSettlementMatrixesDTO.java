package com.bsva.dcms.commons.dto;
import java.io.Serializable;
import java.util.Date;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoSettlementMatrixesDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int originatingBank;
	private Date actionDate;
	private int homingBank;
	private String service;
	private String subService;
	private String currencyCode;
	private String statusCode;
	private String settlementInd;
	private String bankOutputCreatedInd;
	private int crVolume;
	private int drVolume;
	private double crValue;
	private double drValue;
	private String paymentStream;

	public int getOriginatingBank() {
		return this.originatingBank;
	}

	public void setOriginatingBank(int originatingBank) {
		this.originatingBank=originatingBank;
	}

	public Date getActionDate() {
		return this.actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate=actionDate;
	}

	public int getHomingBank() {
		return this.homingBank;
	}

	public void setHomingBank(int homingBank) {
		this.homingBank=homingBank;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service=service;
	}

	public String getSubService() {
		return this.subService;
	}

	public void setSubService(String subService) {
		this.subService=subService;
	}

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode=currencyCode;
	}

	public String getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode=statusCode;
	}

	public String getSettlementInd() {
		return this.settlementInd;
	}

	public void setSettlementInd(String settlementInd) {
		this.settlementInd=settlementInd;
	}

	public String getBankOutputCreatedInd() {
		return this.bankOutputCreatedInd;
	}

	public void setBankOutputCreatedInd(String bankOutputCreatedInd) {
		this.bankOutputCreatedInd=bankOutputCreatedInd;
	}

	public int getCrVolume() {
		return this.crVolume;
	}

	public void setCrVolume(int crVolume) {
		this.crVolume=crVolume;
	}

	public int getDrVolume() {
		return this.drVolume;
	}

	public void setDrVolume(int drVolume) {
		this.drVolume=drVolume;
	}

	public double getCrValue() {
		return this.crValue;
	}

	public void setCrValue(double crValue) {
		this.crValue=crValue;
	}

	public double getDrValue() {
		return this.drValue;
	}

	public void setDrValue(double drValue) {
		this.drValue=drValue;
	}

	public String getPaymentStream() {
		return this.paymentStream;
	}

	public void setPaymentStream(String paymentStream) {
		this.paymentStream=paymentStream;
	}
}

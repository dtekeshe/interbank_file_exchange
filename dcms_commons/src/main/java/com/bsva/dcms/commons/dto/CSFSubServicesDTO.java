package com.bsva.dcms.commons.dto;

import java.io.Serializable;
import java.util.Date;

public class CSFSubServicesDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String service;
	private String subservice;
	private String activeIndicator;
	private String paymentStream;
	private String description;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDate;
	private int inputSla;
	private int settleSla;
	private int outputSla;
	private String displayName;
	private String settlementName;


	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getSubservice() {
		return subservice;
	}
	public void setSubservice(String subservice) {
		this.subservice = subservice;
	}
	public String getActiveIndicator() {
		return activeIndicator;
	}
	public void setActiveIndicator(String activeIndicator) {
		this.activeIndicator = activeIndicator;
	}
	public String getPaymentStream() {
		return paymentStream;
	}
	public void setPaymentStream(String paymentStream) {
		this.paymentStream = paymentStream;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public int getInputSla() {
		return inputSla;
	}
	public void setInputSla(int inputSla) {
		this.inputSla = inputSla;
	}
	public int getSettleSla() {
		return settleSla;
	}
	public void setSettleSla(int settleSla) {
		this.settleSla = settleSla;
	}
	public int getOutputSla() {
		return outputSla;
	}
	public void setOutputSla(int outputSla) {
		this.outputSla = outputSla;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getSettlementName() {
		return settlementName;
	}
	public void setSettlementName(String settlementName) {
		this.settlementName = settlementName;
	}
}

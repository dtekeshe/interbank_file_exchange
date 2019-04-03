package com.bsva.dcms.commons.dto;

import java.util.Date;

public class CSFCardTypesDTO  {
	
	private int cardType;
	private String cardDescription;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDate;
	private String subService;
	private double pasaPaymentLimit;
	
	public int getCardType() {
		return cardType;
	}
	public void setCardType(int cardType) {
		this.cardType = cardType;
	}
	
	public String getCardDescription() {
		return cardDescription;
	}
	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
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
	public String getSubService() {
		return subService;
	}
	public void setSubService(String subService) {
		this.subService = subService;
	}
	public double getPasaPaymentLimit() {
		return pasaPaymentLimit;
	}
	public void setPasaPaymentLimit(double pasaPaymentLimit) {
		this.pasaPaymentLimit = pasaPaymentLimit;
	}

}

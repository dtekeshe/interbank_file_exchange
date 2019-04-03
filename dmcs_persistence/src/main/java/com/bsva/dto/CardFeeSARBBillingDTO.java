package com.bsva.dto;

import java.sql.Date;

public class CardFeeSARBBillingDTO {

	
    private String rateDescriptor;
    private Double debitRate;
    private Double debitPercent;
    private Double creditRate;
    private Double creditPercent;
    private Double oldDebitRate;
    private Double oldDebitPercent;
    private Double oldCreditRate;
    private Double oldCreditPercent;
    private Date changeOverDate;
    
	public CardFeeSARBBillingDTO() {
		
	}

	public CardFeeSARBBillingDTO(String rateDescriptor, Double debitRate, Double debitPercent, Double creditRate,
			Double creditPercent, Double oldDebitRate, Double oldDebitPercent, Double oldCreditRate,
			Double oldCreditPercent, Date changeOverDate) {
		super();
		this.rateDescriptor = rateDescriptor;
		this.debitRate = debitRate;
		this.debitPercent = debitPercent;
		this.creditRate = creditRate;
		this.creditPercent = creditPercent;
		this.oldDebitRate = oldDebitRate;
		this.oldDebitPercent = oldDebitPercent;
		this.oldCreditRate = oldCreditRate;
		this.oldCreditPercent = oldCreditPercent;
		this.changeOverDate = changeOverDate;
	}

	public String getRateDescriptor() {
		return rateDescriptor;
	}

	public Double getDebitRate() {
		return debitRate;
	}

	public Double getDebitPercent() {
		return debitPercent;
	}

	public Double getCreditRate() {
		return creditRate;
	}

	public Double getCreditPercent() {
		return creditPercent;
	}

	public Double getOldDebitRate() {
		return oldDebitRate;
	}

	public Double getOldDebitPercent() {
		return oldDebitPercent;
	}

	public Double getOldCreditRate() {
		return oldCreditRate;
	}

	public Double getOldCreditPercent() {
		return oldCreditPercent;
	}

	public Date getChangeOverDate() {
		return changeOverDate;
	}

	public void setRateDescriptor(String rateDescriptor) {
		this.rateDescriptor = rateDescriptor;
	}

	public void setDebitRate(Double debitRate) {
		this.debitRate = debitRate;
	}

	public void setDebitPercent(Double debitPercent) {
		this.debitPercent = debitPercent;
	}

	public void setCreditRate(Double creditRate) {
		this.creditRate = creditRate;
	}

	public void setCreditPercent(Double creditPercent) {
		this.creditPercent = creditPercent;
	}

	public void setOldDebitRate(Double oldDebitRate) {
		this.oldDebitRate = oldDebitRate;
	}

	public void setOldDebitPercent(Double oldDebitPercent) {
		this.oldDebitPercent = oldDebitPercent;
	}

	public void setOldCreditRate(Double oldCreditRate) {
		this.oldCreditRate = oldCreditRate;
	}

	public void setOldCreditPercent(Double oldCreditPercent) {
		this.oldCreditPercent = oldCreditPercent;
	}

	public void setChangeOverDate(Date changeOverDate) {
		this.changeOverDate = changeOverDate;
	}
    
    
}

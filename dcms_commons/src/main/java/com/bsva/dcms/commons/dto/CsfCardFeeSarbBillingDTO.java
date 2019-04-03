package com.bsva.dcms.commons.dto;

import java.io.Serializable;

/**
 *
 * @author SimphiweT
 */
public class CsfCardFeeSarbBillingDTO implements Serializable, Cloneable  {
    
    private String rateDescriptor;
    private Integer debitRate;    
    private Double debitPercent;
    private Integer creditRate;    
    private Double creditPercent;    
    private Integer oldDebitRate;    
    private Double oldDebitPercent;    
    private Integer oldCreditRate;    
    private Double oldCreditPercent;    
    private String changeOverDate;

    public CsfCardFeeSarbBillingDTO() {        
    }

    public String getRateDescriptor() {
        return rateDescriptor;
    }

    public void setRateDescriptor(String rateDescriptor) {
        this.rateDescriptor = rateDescriptor;
    }

    public Integer getDebitRate() {
        return debitRate;
    }

    public void setDebitRate(Integer debitRate) {
        this.debitRate = debitRate;
    }

    public Double getDebitPercent() {
        return debitPercent;
    }

    public void setDebitPercent(Double debitPercent) {
        this.debitPercent = debitPercent;
    }

    public Integer getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(Integer creditRate) {
        this.creditRate = creditRate;
    }

    public Double getCreditPercent() {
        return creditPercent;
    }

    public void setCreditPercent(Double creditPercent) {
        this.creditPercent = creditPercent;
    }

    public Integer getOldDebitRate() {
        return oldDebitRate;
    }

    public void setOldDebitRate(Integer oldDebitRate) {
        this.oldDebitRate = oldDebitRate;
    }

    public Double getOldDebitPercent() {
        return oldDebitPercent;
    }

    public void setOldDebitPercent(Double oldDebitPercent) {
        this.oldDebitPercent = oldDebitPercent;
    }

    public Integer getOldCreditRate() {
        return oldCreditRate;
    }

    public void setOldCreditRate(Integer oldCreditRate) {
        this.oldCreditRate = oldCreditRate;
    }

    public Double getOldCreditPercent() {
        return oldCreditPercent;
    }

    public void setOldCreditPercent(Double oldCreditPercent) {
        this.oldCreditPercent = oldCreditPercent;
    }

    public String getChangeOverDate() {
        return changeOverDate;
    }

    public void setChangeOverDate(String changeOverDate) {
        this.changeOverDate = changeOverDate;
    }
    
    
    
}

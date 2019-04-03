package com.bsva.dcms.commons.dto;

import java.io.Serializable;

/**
 *
 * @author SimphiweT
 */
public class CsvSarbBillingViewDTO implements Serializable  {
    
    private String rateDescriptor;
    private long cardType;
    private Integer billingRate;    
    private Double billingPercent;

    public String getRateDescriptor() {
        return rateDescriptor;
    }

    public void setRateDescriptor(String rateDescriptor) {
        this.rateDescriptor = rateDescriptor;
    }

    public long getCardType() {
        return cardType;
    }

    public void setCardType(long cardType) {
        this.cardType = cardType;
    }

    public Integer getBillingRate() {
        return billingRate;
    }

    public void setBillingRate(Integer billingRate) {
        this.billingRate = billingRate;
    }

    public Double getBillingPercent() {
        return billingPercent;
    }

    public void setBillingPercent(Double billingPercent) {
        this.billingPercent = billingPercent;
    }
    
    
    
}

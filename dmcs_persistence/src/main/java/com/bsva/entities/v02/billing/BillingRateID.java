package com.bsva.entities.v02.billing;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class BillingRateID implements Serializable {

    @Column(name = "RATE_DESCRIPTOR")
    private String rateDescriptor;

    @Column(name = "CARD_TYPE")
    private Integer cardType;

    public BillingRateID() {
    }

    public BillingRateID(String rateDescriptor, Integer cardType) {
        this.rateDescriptor = rateDescriptor;
        this.cardType = cardType;
    }

    public String getRateDescriptor() {
        return rateDescriptor;
    }

    public void setRateDescriptor(String rateDescriptor) {
        this.rateDescriptor = rateDescriptor;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillingRateID that = (BillingRateID) o;

        if (rateDescriptor != null ? !rateDescriptor.equals(that.rateDescriptor) : that.rateDescriptor != null)
            return false;
        return !(cardType != null ? !cardType.equals(that.cardType) : that.cardType != null);

    }

    @Override
    public int hashCode() {
        int result = rateDescriptor != null ? rateDescriptor.hashCode() : 0;
        result = 31 * result + (cardType != null ? cardType.hashCode() : 0);
        return result;
    }
}

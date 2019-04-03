package com.bsva.entities.v02.billing;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class BillingRate implements Serializable {

    @EmbeddedId
    private BillingRateID id;

    @Column(name = "BILLING_RATE")
    private BigDecimal rate;

    @Column(name = "BILLING_PERCENT")
    private BigDecimal percentage;


    public BillingRateID getId() {
        return id;
    }

    public void setId(BillingRateID id) {
        this.id = id;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal billingRate) {
        this.rate = billingRate;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal billingPercentage) {
        this.percentage = billingPercentage;
    }
}

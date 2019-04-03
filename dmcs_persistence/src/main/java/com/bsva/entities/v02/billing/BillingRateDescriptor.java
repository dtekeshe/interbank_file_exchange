package com.bsva.entities.v02.billing;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class BillingRateDescriptor implements Serializable {

    @EmbeddedId
    private BillingKey id;

    @Column(name = "RATE_DESCRIPTOR")
    private String rateDescriptor;

    public BillingKey getId() {
        return id;
    }

    public void setId(BillingKey id) {
        this.id = id;
    }

    public String getRateDescriptor() {
        return rateDescriptor;
    }

    public void setRateDescriptor(String rateDescriptor) {
        this.rateDescriptor = rateDescriptor;
    }
}

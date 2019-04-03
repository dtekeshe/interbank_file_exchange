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
public class FleetBillingEntity implements Serializable {

    @EmbeddedId
    private FleetBillingKey id;
    @Column( name = "TXN_COUNT")
    private Integer txnCount;
    @Column( name = "TXN_AMOUNT")
    private Double txnAmount;

    public FleetBillingKey getId() {
        return id;
    }

    public void setId(FleetBillingKey id) {
        this.id = id;
    }

    public Double getTxnAmount() {
        return txnAmount;
    }

    public void setTxnAmount(Double txnAmount) {
        this.txnAmount = txnAmount;
    }
}

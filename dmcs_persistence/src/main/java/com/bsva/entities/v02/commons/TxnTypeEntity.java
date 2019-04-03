package com.bsva.entities.v02.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class TxnTypeEntity implements Serializable {

    @Id
    @Column(name = "TRANSACTION_CODE")
    private Integer txnCode;
    @Column(name = "AMOUNT_DIRECTION")
    private Integer amountDirection;
    @Column(name = "FEE_DIRECTION")
    private Integer feeDirection;
    @Column(name = "VAT_DIRECTION")
    private Integer vatDirection;

    public Integer getTxnCode() {
        return txnCode;
    }

    public void setTxnCode(Integer txnCode) {
        this.txnCode = txnCode;
    }

    public Integer getAmountDirection() {
        return amountDirection;
    }

    public void setAmountDirection(Integer amountDirection) {
        this.amountDirection = amountDirection;
    }

    public Integer getFeeDirection() {
        return feeDirection;
    }

    public void setFeeDirection(Integer feeDirection) {
        this.feeDirection = feeDirection;
    }

    public Integer getVatDirection() {
        return vatDirection;
    }

    public void setVatDirection(Integer vatDirection) {
        this.vatDirection = vatDirection;
    }
}

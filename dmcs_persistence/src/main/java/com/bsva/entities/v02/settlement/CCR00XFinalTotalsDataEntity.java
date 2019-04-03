package com.bsva.entities.v02.settlement;

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
public class CCR00XFinalTotalsDataEntity implements Serializable {

    @EmbeddedId
    private CCR00XFinalTotalsDataKey id;

    @Column(name = "ISSUER_MEMBER")
    private String issuer_member;
    @Column(name = "TRANSACTION_DESCRIPTION")
    private String txnDescription;
    @Column(name = "VOLUME")
    private Long volume;
    @Column(name = "TRAN_VALUE")
    private Double tranValue;
    @Column(name = "BILLING_FEE")
    private Double billingFee;
    @Column(name = "BILLING_FEE_AMOUNT")
    private Double billingFeeAmount;
    @Column(name = "BILLING_VAT")
    private Double billingVAT;

    public CCR00XFinalTotalsDataKey getId() {
        return id;
    }

    public void setId(CCR00XFinalTotalsDataKey id) {
        this.id = id;
    }

    public String getIssuer_member() {
        return issuer_member;
    }

    public void setIssuer_member(String issuer_member) {
        this.issuer_member = issuer_member;
    }

    public String getTxnDescription() {
        return txnDescription;
    }

    public void setTxnDescription(String txnDescription) {
        this.txnDescription = txnDescription;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Double getTranValue() {
        return tranValue;
    }

    public void setTranValue(Double tranValue) {
        this.tranValue = tranValue;
    }

    public Double getBillingFee() {
        return billingFee;
    }

    public void setBillingFee(Double billingFee) {
        this.billingFee = billingFee;
    }

    public Double getBillingFeeAmount() {
        return billingFeeAmount;
    }

    public void setBillingFeeAmount(Double billingFeeAmount) {
        this.billingFeeAmount = billingFeeAmount;
    }

    public Double getBillingVAT() {
        return billingVAT;
    }

    public void setBillingVAT(Double billingVAT) {
        this.billingVAT = billingVAT;
    }
  }

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
public class CCR00XDataEntity implements Serializable {

    @EmbeddedId
    private CCR00XDataKey id;

    @Column(name = "ISSUER_MEMBER")
    private String issuer_member;

    @Column(name = "ACQUIRER_MEMBER")
    private String acquirerMember;


    @Column(name = "TRANSACTION_DESCRIPTION")
    private String txnDescription;
    @Column(name = "CARD_TYPE")
    private Integer cardType;
    @Column(name = "CARD_DESCRIPTION")
    private String cardDescription;
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
    @Column(name = "REPORT_SORT_SEQUENCE")
    private Long reportSortSequence;

    public CCR00XDataKey getId() {
        return id;
    }

    public void setId(CCR00XDataKey id) {
        this.id = id;
    }

    public String getIssuer_member() {
        return issuer_member;
    }

    public void setIssuer_member(String issuer_member) {
        this.issuer_member = issuer_member;
    }

    public String getAcquirerMember() {
        return acquirerMember;
    }

    public void setAcquirerMember(String acquirerMember) {
        this.acquirerMember = acquirerMember;
    }

    public String getTxnDescription() {
        return txnDescription;
    }

    public void setTxnDescription(String txnDescription) {
        this.txnDescription = txnDescription;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
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

    public Long getReportSortSequence() {
        return reportSortSequence;
    }

    public void setReportSortSequence(Long reportSortSequence) {
        this.reportSortSequence = reportSortSequence;
    }
}

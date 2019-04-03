package com.bsva.entities.v02.billing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.sql.Date;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class CardFeeSARBBillingEntity implements Serializable {

    @Id
    @Column(name = "RATE_DESCRIPTOR")
    private String rateDescriptor;
    @Column(name = "DEBIT_RATE")
    private Double debitRate;
    @Column(name = "DEBIT_PERCENT")
    private Double debitPercent;
    @Column(name = "CREDIT_RATE")
    private Double creditRate;
    @Column(name = "CREDIT_PERCENT")
    private Double creditPercent;
    @Column(name = "OLD_DEBIT_RATE")
    private Double oldDebitRate;
    @Column(name = "OLD_DEBIT_PERCENT")
    private Double oldDebitPercent;
    @Column(name = "OLD_CREDIT_RATE")
    private Double oldCreditRate;
    @Column(name = "OLD_CREDIT_PERCENT")
    private Double oldCreditPercent;
    @Column(name = "CHANGE_OVER_DATE")
    private Date changeOverDate;

    public String getRateDescriptor() {
        return rateDescriptor;
    }

    public void setRateDescriptor(String rateDescriptor) {
        this.rateDescriptor = rateDescriptor;
    }

    public Double getDebitRate() {
        return debitRate;
    }

    public void setDebitRate(Double debitRate) {
        this.debitRate = debitRate;
    }

    public Double getDebitPercent() {
        return debitPercent;
    }

    public void setDebitPercent(Double debitPercent) {
        this.debitPercent = debitPercent;
    }

    public Double getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(Double creditRate) {
        this.creditRate = creditRate;
    }

    public Double getCreditPercent() {
        return creditPercent;
    }

    public void setCreditPercent(Double creditPercent) {
        this.creditPercent = creditPercent;
    }

    public Double getOldDebitRate() {
        return oldDebitRate;
    }

    public void setOldDebitRate(Double oldDebitRate) {
        this.oldDebitRate = oldDebitRate;
    }

    public Double getOldDebitPercent() {
        return oldDebitPercent;
    }

    public void setOldDebitPercent(Double oldDebitPercent) {
        this.oldDebitPercent = oldDebitPercent;
    }

    public Double getOldCreditRate() {
        return oldCreditRate;
    }

    public void setOldCreditRate(Double oldCreditRate) {
        this.oldCreditRate = oldCreditRate;
    }

    public Double getOldCreditPercent() {
        return oldCreditPercent;
    }

    public void setOldCreditPercent(Double oldCreditPercent) {
        this.oldCreditPercent = oldCreditPercent;
    }

    public Date getChangeOverDate() {
        return changeOverDate;
    }

    public void setChangeOverDate(Date changeOverDate) {
        this.changeOverDate = changeOverDate;
    }
}

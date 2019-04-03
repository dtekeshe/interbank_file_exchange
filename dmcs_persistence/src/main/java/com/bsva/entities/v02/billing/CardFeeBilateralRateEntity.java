package com.bsva.entities.v02.billing;

import com.bsva.entities.v02.billing.BilateralBillingKey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TODO Document
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@DynamicUpdate
public class CardFeeBilateralRateEntity implements Serializable {

    @EmbeddedId
    private BilateralBillingKey bilateralBillingKey;

    @Column(name = "INTERCHANGE_FEE")
    private BigDecimal percentage;

    @Column(name = "INTERCHANGE_FEE_AMOUNT")
    private BigDecimal rate;

    @Column(name = "INPUT_VAT")
    private BigDecimal vat;
    
    @Column(name = "AMOUNT_DIRECTION")
    private Integer amountDirection;

    public BilateralBillingKey getBilateralBillingKey() {
        return bilateralBillingKey;
    }

    public void setBilateralBillingKey(BilateralBillingKey bilateralBillingKey) {
        this.bilateralBillingKey = bilateralBillingKey;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal interchangeFee) {
        this.percentage = interchangeFee;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal interchangeFeeAmount) {
        this.rate = interchangeFeeAmount;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

	public Integer getAmountDirection() {
		return amountDirection;
	}

	public void setAmountDirection(Integer amountDirection) {
		this.amountDirection = amountDirection;
	}
}

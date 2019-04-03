package com.bsva.dmcs.fileloadv02.model;

import java.math.BigDecimal;

/**
 * Billing Information
 */
public class BillingData {

    private String rateDescriptor;

    private Long percentFee;
    private Long flatFee;
    private Double vat;

    private Long cashBackPercentFee;
    private Long cashBackFlatFee;
    private Double cashBackVAT;

    public BillingData( ) {

        this.percentFee = 0L;
        this.flatFee = 0L;
        this.vat = 0.0;
        this.cashBackPercentFee = 0L;
        this.cashBackFlatFee = 0L;
        this.cashBackVAT = 0.0;
    }

    public BillingData( String rateDescriptor,
                        Long percentFee,
                        Long flatFee,
                        Double vat,
                        Long cashBackPercentFee,
                        Long cashBackFlatFee,
                        Double cashBackVAT) {
        this.rateDescriptor = rateDescriptor;
        this.percentFee = percentFee;
        this.flatFee = flatFee;
        this.vat = vat;
        this.cashBackPercentFee = cashBackPercentFee;
        this.cashBackFlatFee = cashBackFlatFee;
        this.cashBackVAT = cashBackVAT;
    }

    public String getRateDescriptor() {
        return rateDescriptor;
    }

    public void setRateDescriptor(String rateDescriptor) {
        this.rateDescriptor = rateDescriptor;
    }

    public Long getPercentFee() {
        return percentFee;
    }

    public void setPercentFee(Long percentFee) {
        this.percentFee = percentFee;
    }

    public Long getFlatFee() {
        return flatFee;
    }

    public void setFlatFee(Long flatFee) {
        this.flatFee = flatFee;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public Long getCashBackPercentFee() {
        return cashBackPercentFee;
    }

    public void setCashBackPercentFee(Long cashBackPercentFee) {
        this.cashBackPercentFee = cashBackPercentFee;
    }

    public Long getCashBackFlatFee() {
        return cashBackFlatFee;
    }

    public void setCashBackFlatFee(Long cashBackFlatFee) {
        this.cashBackFlatFee = cashBackFlatFee;
    }

    public Double getCashBackVAT() {
        return cashBackVAT;
    }

    public void setCashBackVAT(Double cashBackVAT) {
        this.cashBackVAT = cashBackVAT;
    }

    public Double getTransactionFee() {
       Double fee =
               (this.flatFee != null ? this.flatFee : 0L)
                    + ( percentFee != null ? percentFee : 0L )
                    + ( vat != null ? vat : 0L);

        return fee;
    }
}

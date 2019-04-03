package com.bsva.dmcs.fileloadv02.dto;

import java.math.BigDecimal;

/**
 * TODO document
 */
public class CardFeeBilateralRate {

    private final BigDecimal interchangeFee;
    private final BigDecimal interchangeFeeAmount;
    private final BigDecimal vat;

    public CardFeeBilateralRate(BigDecimal interchangeFee,
                                BigDecimal interchangeFeeAmount,
                                BigDecimal vat) {

        this.interchangeFee = interchangeFee;
        this.interchangeFeeAmount = interchangeFeeAmount;
        this.vat = vat;
    }

    public BigDecimal getInterchangeFee() {
        return interchangeFee;
    }

    public BigDecimal getInterchangeFeeAmount() {
        return interchangeFeeAmount;
    }

    public BigDecimal getVat() {
        return vat;
    }
}

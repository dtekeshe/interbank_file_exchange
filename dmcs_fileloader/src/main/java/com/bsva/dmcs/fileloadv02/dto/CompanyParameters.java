package com.bsva.dmcs.fileloadv02.dto;

import java.math.BigDecimal;

/**
 */
public class CompanyParameters {
    private final BigDecimal vatPercentage;

    public CompanyParameters(BigDecimal vatPercentage) {
        this.vatPercentage = vatPercentage;
    }

    public BigDecimal getVatPercentage() {
        return vatPercentage;
    }
}

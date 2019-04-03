package com.bsva.dto;

import java.math.BigDecimal;

/**
 * TODO Document
 */
public class StatementDTO {

    private Integer interchangeInstitionCode;
    private String interchangeInstitionName;
    private BigDecimal acquiringInterchangeFee;
    private BigDecimal issuingInterchangeFee;

    public Integer getInterchangeInstitionCode() {
        return interchangeInstitionCode;
    }

    public void setInterchangeInstitionCode(Integer interchangeInstitionCode) {
        this.interchangeInstitionCode = interchangeInstitionCode;
    }

    public String getInterchangeInstitionName() {
        return interchangeInstitionName;
    }

    public void setInterchangeInstitionName(String interchangeInstitionName) {
        this.interchangeInstitionName = interchangeInstitionName;
    }

    public BigDecimal getAcquiringInterchangeFee() {
        return acquiringInterchangeFee;
    }

    public void addAcquiringInterchangeFee(Double acquiringInterchangeFee) {
        if (this.acquiringInterchangeFee == null ) {
            this.acquiringInterchangeFee = BigDecimal.ZERO;
        }
        this.acquiringInterchangeFee.add(
                acquiringInterchangeFee != null ? new BigDecimal(acquiringInterchangeFee) : BigDecimal.ZERO);
    }

    public BigDecimal getIssuingInterchangeFee() {
        return issuingInterchangeFee;
    }

    public void addIssuingInterchangeFee(Double issuingInterchangeFee) {
        if (this.issuingInterchangeFee == null) {
            this.issuingInterchangeFee = BigDecimal.ZERO;
        }
        this.issuingInterchangeFee.add(
                issuingInterchangeFee != null ? new BigDecimal(issuingInterchangeFee) : BigDecimal.ZERO);
    }
}

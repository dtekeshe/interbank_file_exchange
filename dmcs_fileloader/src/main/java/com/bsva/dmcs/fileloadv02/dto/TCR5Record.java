package com.bsva.dmcs.fileloadv02.dto;

/**
 * TODO Document
 */
public class TCR5Record extends TCRRecord {
    private String interchangeSign;
    private Long interchangeFee;
    private Long authAmount;
    private String authCurrency;

    public void setInterchangeSign(String interchangeSign) {
        this.interchangeSign = interchangeSign;
    }

    public String getInterchangeSign() {
        return interchangeSign;
    }

    public void setInterchangeFee(Long interchangeFee) {
        this.interchangeFee = interchangeFee;
    }

    public Long getInterchangeFee() {
        return interchangeFee;
    }

    public void setAuthAmount(Long authAmount) {
        this.authAmount = authAmount;
    }

    public Long getAuthAmount() {
        return authAmount;
    }

    public void setAuthCurrency(String authCurrency) {
        this.authCurrency = authCurrency;
    }

    public String getAuthCurrency() {
        return authCurrency;
    }
}

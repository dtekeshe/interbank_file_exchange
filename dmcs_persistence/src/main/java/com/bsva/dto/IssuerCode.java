package com.bsva.dto;

/**
 * A Value Object that makes read map structure easier
 */
public class IssuerCode {

    private final Integer issuerCode;
    private String fullBankCode;
    private String bankName;

    public IssuerCode(Integer issuerCode) {
        this.issuerCode = issuerCode;
    }

    public static IssuerCode issuerCode(Integer issuerCode) {
        return new IssuerCode(issuerCode);
    }

    public Integer getIssuerCode() {
        return issuerCode;
    }

    public String getFullBankCode() {
        return fullBankCode;
    }

    public void setFullBankCode(String fullBankCode) {
        this.fullBankCode = fullBankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IssuerCode that = (IssuerCode) o;

        return !(issuerCode != null ? !issuerCode.equals(that.issuerCode) : that.issuerCode != null);

    }

    @Override
    public int hashCode() {
        return issuerCode != null ? issuerCode.hashCode() : 0;
    }
}

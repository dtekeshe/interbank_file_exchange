package com.bsva.dmcs.dto;

import java.io.Serializable;

/**
 * TODO Document
 */
public class AcquirerIssuerPair implements Serializable {

    private final Integer acquirerCode;
    private final Integer issuerCode;

    public AcquirerIssuerPair(Integer acquirerCode,
                              Integer issuerCode) {

        this.acquirerCode = acquirerCode;
        this.issuerCode = issuerCode;
    }

    public Integer getAcquirerCode() {
        return acquirerCode;
    }

    public Integer getIssuerCode() {
        return issuerCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AcquirerIssuerPair that = (AcquirerIssuerPair) o;

        if (acquirerCode != null ? !acquirerCode.equals(that.acquirerCode) : that.acquirerCode != null) return false;
        return !(issuerCode != null ? !issuerCode.equals(that.issuerCode) : that.issuerCode != null);

    }

    @Override
    public int hashCode() {
        int result = acquirerCode != null ? acquirerCode.hashCode() : 0;
        result = 31 * result + (issuerCode != null ? issuerCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AcquirerIssuerPair{" +
                "acquirerCode=" + acquirerCode +
                ", issuerCode=" + issuerCode +
                '}';
    }
}

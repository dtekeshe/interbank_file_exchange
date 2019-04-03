package com.bsva.entities.v02.settlement;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * TODO Document
 */
public class CardTypeKey implements Serializable {

    @Column(name = "SUB_SERVICE")
    private String subServiceID;
    @Column(name = "ACQUIRER_CODE")
    private Integer acquirerCode;
    @Column(name = "ISSUER_CODE")
    private Integer issuerCode;
    @Column(name = "CARD_TYPE")
    private Integer cardType;

    public String getSubServiceID() {
        return subServiceID;
    }

    public void setSubServiceID(String subServiceID) {
        this.subServiceID = subServiceID;
    }

    public Integer getAcquirerCode() {
        return acquirerCode;
    }

    public void setAcquirerCode(Integer acquirerCode) {
        this.acquirerCode = acquirerCode;
    }

    public Integer getIssuerCode() {
        return issuerCode;
    }

    public void setIssuerCode(Integer issuerCode) {
        this.issuerCode = issuerCode;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardTypeKey that = (CardTypeKey) o;

        if (subServiceID != null
                ? !subServiceID.equals(that.subServiceID) : that.subServiceID != null) return false;
        if (acquirerCode != null
                ? !acquirerCode.equals(that.acquirerCode) : that.acquirerCode != null) return false;
        if (issuerCode != null
                ? !issuerCode.equals(that.issuerCode) : that.issuerCode != null) return false;
        return !(cardType != null ? !cardType.equals(that.cardType) : that.cardType != null);

    }

    @Override
    public int hashCode() {
        int result = subServiceID != null ? subServiceID.hashCode() : 0;
        result = 31 * result + (acquirerCode != null ? acquirerCode.hashCode() : 0);
        result = 31 * result + (issuerCode != null ? issuerCode.hashCode() : 0);
        result = 31 * result + (cardType != null ? cardType.hashCode() : 0);
        return result;
    }
}

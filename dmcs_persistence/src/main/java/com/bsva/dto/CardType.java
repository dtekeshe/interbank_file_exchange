package com.bsva.dto;

/**
 * A Value Object that makes read map structure easier
 */
public class CardType {

    private final Integer issuerCode;

    public CardType(Integer issuerCode) {
        this.issuerCode = issuerCode;
    }

    public Integer getIssuerCode() {
        return issuerCode;
    }
}

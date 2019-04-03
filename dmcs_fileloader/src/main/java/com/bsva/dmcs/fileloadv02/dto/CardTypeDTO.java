package com.bsva.dmcs.fileloadv02.dto;

import java.math.BigDecimal;

/**
 *
 */
public class CardTypeDTO {

    private final Integer cardType;
    private final String description;
    private final BigDecimal pasaLimit;

    public CardTypeDTO(Integer cardType, String description, BigDecimal pasaLimit) {
        this.cardType = cardType;
        this.description = description;
        this.pasaLimit = pasaLimit;
    }

    public Integer getCardType() {
        return cardType;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPasaLimit() {
        return pasaLimit;
    }
}

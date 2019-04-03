package com.bsva.entities.v02.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class CardTypeEntity implements Serializable {


    @Id
    @Column(name = "CARD_TYPE")
    private Integer cardType;

    @Column ( name = "CARD_DESCRIPTION")
    private String cardDescription;

    @Column( name = "PASA_PAYMENT_LIMIT")
    private BigDecimal pasaPaymentLimit;

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }

    public BigDecimal getPasaPaymentLimit() {
        return pasaPaymentLimit;
    }

    public void setPasaPaymentLimit(BigDecimal pasaPaymentLimit) {
        this.pasaPaymentLimit = pasaPaymentLimit;
    }
}

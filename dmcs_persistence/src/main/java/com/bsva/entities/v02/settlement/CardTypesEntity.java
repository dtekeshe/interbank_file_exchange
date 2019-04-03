package com.bsva.entities.v02.settlement;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class CardTypesEntity implements Serializable {

    @EmbeddedId
    private CardTypeKey id;
    @Column(name = "CARD_DESCRIPTION")
    private String cardDescription;

    public CardTypeKey getId() {
        return id;
    }

    public void setId(CardTypeKey id) {
        this.id = id;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }
}

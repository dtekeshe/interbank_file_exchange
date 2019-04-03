package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.commons.CardTypeEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class CardTypesDAO extends AbstractDao<CardTypeEntity, Void> {

    private final static String CARD_TYPES_SQL =
            " SELECT CARD_TYPE, CARD_DESCRIPTION, PASA_PAYMENT_LIMIT " +
            "   FROM CSF_CARD_TYPES ";

    public Map<Integer, CardTypeEntity> cardTypes() {

        // execute
        List<CardTypeEntity> entities
                = list(CARD_TYPES_SQL, CardTypeEntity.class);

        // prepare result
        Map<Integer, CardTypeEntity> cardTypes = new HashMap<>();
        for (CardTypeEntity entity : entities) {
            cardTypes.put(entity.getCardType(), entity);
        }

        return cardTypes;
    }
}

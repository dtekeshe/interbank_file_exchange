package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.commons.CardTypeEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class SubServiceCardTypesDAO extends AbstractDao<CardTypeEntity, Void> {

    private final static String CARD_TYPES_SQL =
            " SELECT CARD_TYPE, CARD_DESCRIPTION, PASA_PAYMENT_LIMIT " +
            "   FROM CSF_CARD_TYPES " +
            "  WHERE ACTIVE_IND = 'Y' " +
            "    AND SUB_SERVICE = :subServiceID ";

    public List<CardTypeEntity> cardTypes(String subServiceID) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("subServiceID", subServiceID);

        // execute
        List<CardTypeEntity> cardTypes
                = list(CARD_TYPES_SQL, params, CardTypeEntity.class);

        return cardTypes;
    }
}

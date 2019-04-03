package com.bsva.dao.v02.settlement;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.settlement.CardTypesEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class CR00XCardTypesDAO extends AbstractDao<CardTypesEntity, Void> {
    
    private final static String CR00X_CARD_TYPES_SQL = 
            "   SELECT SUB_SERVICE, ACQUIRER_CODE, ISSUER_CODE, CARD_TYPE, CARD_DESCRIPTION                         " +
            "     FROM CSV_CCR00X_DATA_VIEW                                                                         " +
            "    WHERE SUB_SERVICE = :subServiceID                                                                  " +
            "      AND ACQUIRER_CODE = :acquirerCode                                                                " +
            "      AND ISSUER_CODE = :issuerCode                                                                    " +
            " GROUP BY SUB_SERVICE, ACQUIRER_CODE, ISSUER_CODE, CARD_TYPE, CARD_DESCRIPTION                         " +
            " ORDER BY CARD_TYPE                                                                                    ";
    
    private final static String CR00X_CARD_TYPES_SQL_FLEET = 
            "   SELECT SUB_SERVICE, ACQUIRER_CODE, ISSUER_CODE, CARD_TYPE, CARD_DESCRIPTION                         " +
            "     FROM CSV_FLEET_BILL_VIEW                                                                         " +
            "    WHERE SUB_SERVICE = :subServiceID                                                                  " +
            "      AND ACQUIRER_CODE = :acquirerCode                                                                " +
            "      AND ISSUER_CODE = :issuerCode                                                                    " +
            " GROUP BY SUB_SERVICE, ACQUIRER_CODE, ISSUER_CODE, CARD_TYPE, CARD_DESCRIPTION                         " +
            " ORDER BY CARD_TYPE                                                                                    ";

    public List<CardTypesEntity> cardTypes(String subServiceID, Integer acquirerCode, Integer issuerCode) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("subServiceID", subServiceID );
        params.put("acquirerCode", acquirerCode );
        params.put("issuerCode", issuerCode );

        // execute
        List<CardTypesEntity> cardTypes = null;
        
        if("FLEET CARD".equals(subServiceID)){
        	cardTypes = list(CR00X_CARD_TYPES_SQL_FLEET, params, CardTypesEntity.class);
        }else{
        	cardTypes = list(CR00X_CARD_TYPES_SQL, params, CardTypesEntity.class);
        }

        return cardTypes;
    }
}

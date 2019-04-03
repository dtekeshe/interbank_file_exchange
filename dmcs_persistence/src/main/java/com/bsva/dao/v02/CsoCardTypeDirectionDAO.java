package com.bsva.dao.v02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.billing.CsfCardTypesDirection;

public class CsoCardTypeDirectionDAO extends AbstractDao<CsfCardTypesDirection, Void> {

	    private final static String CARDTYPE_DIRECTORY_SQL =
	            "SELECT CARD_TYPE, CARD_DIRECTION " +
	            "  FROM CSF_CARD_TYPES_DIRECTION ";

	    public Map<Short, String> getCardTypes() {

	        // execute
	        List<CsfCardTypesDirection> entities
	                = list(CARDTYPE_DIRECTORY_SQL, CsfCardTypesDirection.class);

	        // prepare result
	        Map<Short, String> directoriesCardType = new HashMap<>();

	        for (CsfCardTypesDirection cardTypeDirectory : entities ) {

	            try {

	            	directoriesCardType.put(cardTypeDirectory.getCardType(),cardTypeDirectory.getCardDirection());
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        return directoriesCardType;
	    }
}
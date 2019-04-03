package com.bsva.dao.v02.members;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.billing.CsfCardTypes_Entity;

public class Csf_Card_Types_DAO extends AbstractDao<CsfCardTypes_Entity, Void> {
	
	
	private final static String CSF_CARD_TYPE_SQL = "SELECT CARD_TYPE, CARD_DESCRIPTION, ACTIVE_IND FROM CSF_CARD_TYPES WHERE ACTIVE_IND =  'Y' AND CARD_TYPE =:cardType";
	
	 public List<CsfCardTypes_Entity> getCardTypes(String cardType) {

	        // prepare params to set parameters
	        Map<String, Object> params = new HashMap<>();
	       // params.put("subServiceID", subServiceID);
	        params.put("cardType", cardType);

	        // execute
	        List<CsfCardTypes_Entity> entities
	                = list(CSF_CARD_TYPE_SQL,params , CsfCardTypes_Entity.class);



	        return entities;
	    }

	 private final static String CSF_CARD_TYPE_QUERY_SQL = "SELECT CARD_TYPE, CARD_DESCRIPTION, ACTIVE_IND FROM CSF_CARD_TYPES ";
		
	 public List<CsfCardTypes_Entity> getAllCardTypes() {

	        // prepare params to set parameters
	        Map<String, Object> params = new HashMap<>();
	       // params.put("subServiceID", subServiceID);
	        //params.put("cardType", cardType);

	        // execute
	        List<CsfCardTypes_Entity> entities
	                = list(CSF_CARD_TYPE_QUERY_SQL, CsfCardTypes_Entity.class);



	        return entities;
	    }
}

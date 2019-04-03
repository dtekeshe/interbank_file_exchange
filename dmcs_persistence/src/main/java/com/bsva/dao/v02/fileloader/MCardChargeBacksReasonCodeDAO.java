package com.bsva.dao.v02.fileloader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.entities.v02.loader.McardChargeBacksEntity_PK;
import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.loader.McardChargeBacksEntity;

public class MCardChargeBacksReasonCodeDAO extends AbstractDao<McardChargeBacksEntity,Void>{

	
	  private final static String MCARD_REASON_CODE_SQL =

	            "       SELECT   MESSAGE_TYPE_IND, FUNCTION_CODE ,REASON_CODE " +
	            "         FROM CSF_CHGBACK_RSN_CODES_MCARD   " ;
	  
	  private final static String MCARD_REASON_CODE_COUNT_SQL = "SELECT * FROM CSF_CHGBACK_RSN_CODES_MCARD  WHERE MESSAGE_TYPE_IND =:messageTypeIndicator AND FUNCTION_CODE =:functionCode AND REASON_CODE =:reasonCode";

	    
	    public Map<McardChargeBacksEntity_PK, McardChargeBacksEntity> getMCardReasonCodes() {

	        // execute
	        List<McardChargeBacksEntity> entities
	                = list(MCARD_REASON_CODE_SQL, McardChargeBacksEntity.class);
	        // prepare result
	        Map<McardChargeBacksEntity_PK, McardChargeBacksEntity> reasonCodes = new HashMap<>();
	        for (McardChargeBacksEntity entity : entities) {
	        	reasonCodes.put(entity.getMcardID(), entity);
	        }

	        return reasonCodes;
	    }
	    
	    public List<McardChargeBacksEntity> fetchReasonCodes(Integer messageTypeIndicator,Integer functionCode, Integer reasonCode) {

	    	// prepare params
	        Map<String, Object> params = new HashMap<>();
	        params.put("messageTypeIndicator", messageTypeIndicator);
	        params.put("functionCode", functionCode);
	        params.put("reasonCode", reasonCode);
	        // execute
	        List<McardChargeBacksEntity> cardTypes
	                = list(MCARD_REASON_CODE_COUNT_SQL, params, McardChargeBacksEntity.class);

	        return cardTypes;
	    }
}

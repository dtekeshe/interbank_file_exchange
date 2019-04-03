package com.bsva.dao.v02.members;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.CsrMisEntity;
import com.bsva.entities.v02.billing.CsfCardTypes_Entity;


public class CsrMisEntityDAO extends AbstractDao<CsrMisEntity, Void>{
	
	
	private final static String CSO_BILLING_SUMMARY_FETCH_SQL_QUERY = 
            "SELECT PROCESS_DATE,SERVICE,SUB_SERVICE , VOLUME, VALUE, ISSUING_MEMBER,"
            + "  VOLUME_ABOVE,VALUE_ABOVE,VOLUME_BELOW,VALUE_BELOW,CARD_TYPE "
            + " FROM CSO_BILLING_SUMMARY ";//WHERE SUB_SERVICE =:subServiceID ";// AND PROCESS_DATE =:TO_DATE(processDate,'YYYYMMDD')";
	
	
	

    public List<CsrMisEntity> getAllData(){//,String processDat) {

        // prepare params to set parameters
        //Map<String, Object> params = new HashMap<>();
        //params.put("subServiceID", subServiceID);
        //params.put("processDate", processDat);

        // execute
        List<CsrMisEntity> entities
                = list(CSO_BILLING_SUMMARY_FETCH_SQL_QUERY, CsrMisEntity.class);



        return entities;
    }
    
   
}



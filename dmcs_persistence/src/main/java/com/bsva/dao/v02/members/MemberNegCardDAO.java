package com.bsva.dao.v02.members;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.MemberNegCardEntity;

public class MemberNegCardDAO extends AbstractDao<MemberNegCardEntity, Void> {

	    private final static String MEMBERS_SQL =
	            " SELECT BANK_CODE, NEG_CARD_DATA_REQUIRED " +
	                    "   FROM CSF_MEMBERS ";

	    public List<MemberNegCardEntity> memberNegCard() {

	        // prepare params
	        Map<String, Object> params = new HashMap<>();
	       // params.put("bankCode", bankCode);

	        // execute
	        List<MemberNegCardEntity> entities
	                = list(MEMBERS_SQL, MemberNegCardEntity.class);

	        // prepare result
	        /*Map<Integer, String> memberNegCardReg = new HashMap<>();
	        for (MemberNegCardEntity entity : entities) {
	        	if(entity.getNegCardDataRequired().equalsIgnoreCase("Y")){
	        		memberNegCardReg.put(entity.getBankCode(),entity.getNegCardDataRequired());
	        	}
	        }*/

	        return entities;
	    }
	}

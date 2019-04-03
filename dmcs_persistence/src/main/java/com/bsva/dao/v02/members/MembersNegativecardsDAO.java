package com.bsva.dao.v02.members;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bsva.dao.AbstractDao;
import com.bsva.dto.CsoNegativeCardsDTO;
import com.bsva.entities.CsoNegativeCardsEntity;

public class MembersNegativecardsDAO extends AbstractDao<CsoNegativeCardsEntity,String>{

	private final static String NEGATIVE_FILE_SQL =
            " SELECT FILE_REF_NUMBER , SYSTEM_SEQ_NUMBER, TRANSACTION_CODE," +
	        " DEST_BIN_NUMBER , SOURCE_BIN_NUMBER, TRANS_SEQ_NUMBER, TRANSACTION_TYPE, AUTH_CENTRE, NEGATIVE_ACC_NUMBER, RESPONSE_CODE, PURGE_DATE," +
            " REGION_CODE, CARDHOLDER_NAME, ACQUIRER"+
            "  FROM CSO_NEGATIVE_CARDS  WHERE ACQUIRER = :acquirer ";

    public Set<CsoNegativeCardsDTO> getFileDetailsFor(String acquirer) {

    	// preparing params
    	Map<String, Object> params = new HashMap<>();
    	params.put("acquirer", acquirer);    	
        // execute
    	List<CsoNegativeCardsEntity> entities
                = list(NEGATIVE_FILE_SQL, params, CsoNegativeCardsEntity.class);
    	
    	// preparing result
    	Set<CsoNegativeCardsDTO> result = new HashSet<>();
    	if(!entities.isEmpty() && entities.size() > 0 ){
	    	for (CsoNegativeCardsEntity entity : entities) {
	    		CsoNegativeCardsDTO dto = new CsoNegativeCardsDTO();
	    		dto.setAcquirer(entity.getAcquirer());
	    		dto.setAuthCenter(entity.getAuthCenter());
	    		dto.setCardHolderName(entity.getCardHolderName());
	    		dto.setDestBinNumber(entity.getDestBinNumber());
	    		dto.setNegativeAccNumber(entity.getNegativeAccNumber());
	    		dto.setPurgeDate(entity.getPurgeDate());
	    		dto.setRegionCode(entity.getRegionCode());
	    		dto.setResponseCode(entity.getRegionCode());
	    		dto.setSourceBinNumber(entity.getSourceBinNumber());
	    		dto.setSystemSeqNumber(entity.getSystemSeqNumber());
	    		dto.setTransactionType(entity.getTransactionType());
	    		dto.setTransactoionCode(entity.getTransactoionCode());
	    		dto.setTransSeqNumber(entity.getTransSeqNumber());
	    		result.add(dto);
	    	}
	    	return result;
    	}
    	
        return null;
    }
}


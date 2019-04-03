package com.bsva.dao.v02.members;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.members.MemberParamKey;
import com.bsva.entities.v02.members.MemberParamsEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class MemberServicesDAO extends AbstractDao<MemberParamsEntity, Void> {

    private static final String MEMBER_FILE_LIMIT_SQL =
            " SELECT SERVICE, SUB_SERVICE, BANK_CODE, MAX_SIZE_TRANS_FILE " +
            "   FROM CSF_MEMBER_SERVICE ";
    
    private static final String MEMBER_BANKCODE_SQL =
            " SELECT SERVICE, SUB_SERVICE, BANK_CODE, MAX_SIZE_TRANS_FILE " +
            "   FROM CSF_MEMBER_SERVICE ";

    public Map<MemberParamKey, Long> memberFileLimits() {

        // execute
        List<MemberParamsEntity> entities
                = list(MEMBER_FILE_LIMIT_SQL, MemberParamsEntity.class);

        // prepare result
        Map<MemberParamKey, Long> params = new HashMap<>();
        for (MemberParamsEntity entity : entities) {
            params.put(entity.getId(), entity.getMaxFileSize());
        }

        return params;
    }
    
    public List<Integer> getbankCode(){
    	
    	// execute
        List<MemberParamsEntity> entities
                = list(MEMBER_FILE_LIMIT_SQL, MemberParamsEntity.class);

        List<Integer> data = new ArrayList<Integer>();
        // prepare result
        for (MemberParamsEntity entity : entities) {
        	data.add(entity.getId().getBankCode());
        }

        return data;
    }
}

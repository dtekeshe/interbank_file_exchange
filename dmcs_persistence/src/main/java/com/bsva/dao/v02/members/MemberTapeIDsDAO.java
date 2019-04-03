package com.bsva.dao.v02.members;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.members.MemberTapeIDEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class MemberTapeIDsDAO extends AbstractDao<MemberTapeIDEntity, Void> {

    private final static String MEMBERS_SQL =
            " SELECT S.BANK_CODE, S.MEMBER_TAPE_ID, S.MEMBER_NO AS FULL_BANK_CODE " +
                    "   FROM CSF_MEMBER_SERVICE S " +
                    "  WHERE SUB_SERVICE = :subServiceID ";

    public Map<String, Integer> memberTapeIds(String subServiceID) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("subServiceID", subServiceID);

        // execute
        List<MemberTapeIDEntity> entities
                = list(MEMBERS_SQL, params, MemberTapeIDEntity.class);

        // prepare result
        Map<String, Integer> memberTapeIds = new HashMap<>();
        for (MemberTapeIDEntity entity : entities) {
            memberTapeIds.put(entity.getMemberTapeId(), entity.getFullBankCode());
        }

        return memberTapeIds;
    }
}

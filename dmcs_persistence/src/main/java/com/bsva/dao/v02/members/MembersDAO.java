package com.bsva.dao.v02.members;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.members.MemberEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class MembersDAO extends AbstractDao<MemberEntity, Void> {

    private final static String MEMBERS_SQL =
            " SELECT S.BANK_CODE, S.MEMBER_TAPE_ID, S.MEMBER_NO AS FULL_BANK_CODE,TIERED_ITEM_CHARGE,TIERED_ITEM_CHARGE_BELOW,TIERED_ITEM_CHARGE_ABOVE ," +    
            " M.MAX_FILE_SIZE , M.MEMBER_NAME " +            		
            "   FROM CSF_MEMBER_SERVICE S " +
            "   JOIN CSF_MEMBERS M " +
            "     ON S.BANK_CODE = M.BANK_CODE " +
            "  ORDER BY S.MEMBER_NO ";

    public Map<Integer, Integer> memberCodes() {

        // execute
        List<MemberEntity> entities = list(MEMBERS_SQL, MemberEntity.class);

        // prepare result
        Map<Integer, Integer> memberCodes = new HashMap<>();
        for (MemberEntity entity : entities) {
            memberCodes.put(entity.getBankCode(), entity.getFullBankCode());
        }

        return memberCodes;
    }


    public Map<String, Integer> memberTapeIds() {

        // execute
        List<MemberEntity> entities = list(MEMBERS_SQL, MemberEntity.class);

        // prepare result
        Map<String, Integer> memberTapeIds = new HashMap<>();
        for (MemberEntity entity : entities) {
            memberTapeIds.put(entity.getMemberTapeId(), entity.getFullBankCode());
        }

        return memberTapeIds;
    }
    
    public Map<String, String> memberTieredItem() {

        // execute
        List<MemberEntity> entities = list(MEMBERS_SQL, MemberEntity.class);

        // prepare result
        Map<String, String> memberCodes = new HashMap<>();
        for (MemberEntity entity : entities) {
            memberCodes.put(entity.getTieredItemCharged(), entity.getTieredItemChargeAbove());
        }

        return memberCodes;
    }
}

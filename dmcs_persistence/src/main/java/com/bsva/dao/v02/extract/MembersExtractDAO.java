package com.bsva.dao.v02.extract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.members.MembersExtractEntity;


public class MembersExtractDAO  extends AbstractDao<MembersExtractEntity, Void> {

	    private final static String MEMBERS_SQL =
	            " SELECT S.BANK_CODE, S.MEMBER_TAPE_ID, S.MEMBER_NO AS FULL_BANK_CODE, " +
	            "   S.MAX_SIZE_TRANS_FILE AS MAX_FILE_SIZE, M.MEMBER_NAME " +
	            "   FROM CSF_MEMBER_SERVICE S " +
	            "   JOIN CSF_MEMBERS M " +
	            "   ON S.BANK_CODE = M.BANK_CODE " +
	            "   ORDER BY S.MEMBER_NO ";
	    private final static String MEMBERS_MMEMONIC_SQL =
	            " SELECT S.BANK_CODE, S.MEMBER_TAPE_ID, S.MEMBER_NO AS FULL_BANK_CODE, " +
	            "   S.MAX_SIZE_TRANS_FILE AS MAX_FILE_SIZE, M.MEMBER_NAME ,M.MNEMONIC_MEMBER_NAME" +
	            "   FROM CSF_MEMBER_SERVICE S " +
	            "   JOIN CSF_MEMBERS M " +
	            "   ON S.BANK_CODE = M.BANK_CODE " +
	            "   ORDER BY S.MEMBER_NO ";

	    public Map<Integer, Integer> memberCodes() {

	        // execute
	        List<MembersExtractEntity> entities = list(MEMBERS_SQL, MembersExtractEntity.class);

	        // prepare result
	        Map<Integer, Integer> memberCodes = new HashMap<>();
	        for (MembersExtractEntity entity : entities) {
	            memberCodes.put(entity.getBankCode(), entity.getFullBankCode());
	        }

	        return memberCodes;
	    }
	    
	    public Map<Integer, String> mnemonicMemberNameCodes() {

	        // execute
	        List<MembersExtractEntity> entities = list(MEMBERS_MMEMONIC_SQL, MembersExtractEntity.class);

	        // prepare result
	        Map<Integer,String> memberCodes = new HashMap<>();
	        for (MembersExtractEntity entity : entities) {
	            memberCodes.put(entity.getBankCode(),entity.getMmemonicMemberName());
	        }

	        return memberCodes;
	    }

	    public Map<String, Integer> memberTapeIds() {

	        // execute
	        List<MembersExtractEntity> entities = list(MEMBERS_SQL, MembersExtractEntity.class);

	        // prepare result
	        Map<String, Integer> memberTapeIds = new HashMap<>();
	        for (MembersExtractEntity entity : entities) {
	            memberTapeIds.put(entity.getMemberTapeId(), entity.getFullBankCode());
	        }

	        return memberTapeIds;
	    }
	}

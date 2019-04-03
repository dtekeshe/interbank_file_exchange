package com.bsva.entities.v02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.billing.MemberServiceEntity;

public class CsfMemberService_DAO extends AbstractDao<MemberServiceEntity, Void>{

	private final static String CSF_MEMBERS_SQL = "SELECT BANK_CODE, MNEMONIC_MEMBER_NAME, MEMBER_NAME,"
			+ " MEMBER_TAPE_ID, FULL_BANK_CODE,MEMBER_NO,  MAX_FILE_SIZE FROM CSF_MEMBERS WHERE BANK_CODE =:bankCode ";
	
	 public List<MemberServiceEntity> getMemberTypes(String bankCode) {

	        // prepare params to set parameters
	        Map<String, Object> params = new HashMap<>();
	        params.put("bankCode", bankCode);

	        // execute
	        List<MemberServiceEntity> entities
	                = list(CSF_MEMBERS_SQL,params , MemberServiceEntity.class);



	        return entities;
	    }
	 
	 private final static String ALL_CSF_MEMBERS_SQL = "SELECT BANK_CODE, MNEMONIC_MEMBER_NAME, MEMBER_NAME,"
				+ " MEMBER_TAPE_ID, FULL_BANK_CODE,MEMBER_NO,  MAX_FILE_SIZE FROM CSF_MEMBERS ";
	 
	 private final static String ONE_CSF_MEMBERS_SQL = "SELECT BANK_CODE, MNEMONIC_MEMBER_NAME, MEMBER_NAME,"
				+ " MEMBER_TAPE_ID, FULL_BANK_CODE,MEMBER_NO,  MAX_FILE_SIZE FROM CSF_MEMBERS  WHERE BANK_CODE = :bankCode";
		
		 public List<MemberServiceEntity> getMemberTypes() {

		        
		        // execute
		        List<MemberServiceEntity> entities
		                = list(ALL_CSF_MEMBERS_SQL,MemberServiceEntity.class);



		        return entities;
		    }
		 
		 public MemberServiceEntity getMemberTypesSingle(String bankCode) {

		        Map<String,Object> params = new HashMap<String, Object>();
		        params.put("bankCode", bankCode);
		        // execute
		        MemberServiceEntity entities
		                = uniqueResult(ONE_CSF_MEMBERS_SQL,params,MemberServiceEntity.class);



		        return entities;
		    }
}

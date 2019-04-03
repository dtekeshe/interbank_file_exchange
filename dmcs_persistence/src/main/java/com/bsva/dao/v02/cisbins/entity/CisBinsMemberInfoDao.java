package com.bsva.dao.v02.cisbins.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;

public class CisBinsMemberInfoDao extends AbstractDao<CisBinsMemberInfoEntity, Void> {

	private final static String BANK_CODE_SQL = 
	"SELECT DISTINCT(B.MEMBER_NAME),A.BANK_CODE,A.VAT_REG_NUMBER FROM CSF_MEMBERS B,CSF_MEMBER_SERVICE A WHERE  A.BANK_CODE = B.BANK_CODE AND A.VAT_REG_NUMBER IS NOT NULL  ORDER BY BANK_CODE ASC ";
	public Map<String,Object> returnMembers() {

		Map<String,Object> mapData = new HashMap<String,Object>();
		
		// execute
		List<CisBinsMemberInfoEntity> entities = list(BANK_CODE_SQL, CisBinsMemberInfoEntity.class);

		// prepare result
		for (CisBinsMemberInfoEntity entity : entities) {
			
			mapData.put(entity.getBankCode(),entity);
		}

		return mapData;
	}
}

package com.bsva.dao.v02.members;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.members.NegCardEntity;

public class NegCardDAO extends AbstractDao<NegCardEntity, Void>{
	
	
	private static String NEGATIVE_CARD_SQL_QUERY = "SELECT FILE_REF_NUMBER,SYSTEM_SEQ_NUMBER, TRANSACTION_CODE FROM  CSO_NEGATIVE_CARDS";
	
	
	public List<NegCardEntity> getListNegativeCards(){
		List<NegCardEntity> listData = new ArrayList<NegCardEntity>();
		
		Map<String,Object> params = new HashMap<String, Object>();
		
		List<NegCardEntity>  entitiesList = list(NEGATIVE_CARD_SQL_QUERY, NegCardEntity.class);
		for (NegCardEntity negCardEntity : entitiesList) {
			listData.add(negCardEntity);
		}
		return listData;
	}
			

}

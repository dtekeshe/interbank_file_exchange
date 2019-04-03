package com.bsva.entities.v02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;

public class IssuerAcquirerPair_DAO extends AbstractDao<IssuerAcquirerCombEntity, Void> {
	

	private static final String MEMBERS_COMBINATION = "SELECT ACQUIRER_MEMBER, ISSUER_MEMBER from CSO_PAYMENT_INSTRUCTIONS_VISA "
			+ " WHERE ACQUIRER_MEMBER = :acquirer AND ISSUER_MEMBER = :issuermember AND ACQUIRER_MEMBER is not null "
			+ " group by ACQUIRER_MEMBER,ISSUER_MEMBER "
			+ " ORDER BY ACQUIRER_MEMBER DESC ";
    
	
	
	
	public Map<String , String> getIssuerAcquirerPair(String acquirer, String issuermember){
		Map<String , String> issAcqPair = new HashMap<>();
		 Map<String , Object> params = new HashMap<>();
		 params.put("acquirer", acquirer);
		 params.put("issuermember", issuermember);
		 
		 List<IssuerAcquirerCombEntity> listData = list(MEMBERS_COMBINATION,params,IssuerAcquirerCombEntity.class);
		  if(listData.size() > 0){
			  for (IssuerAcquirerCombEntity issuerAcquirerCombEntity : listData) {
				  issAcqPair.put(issuerAcquirerCombEntity.getAcquirer(), issuerAcquirerCombEntity.getIssuermember());
			 }
		  }		 
				 
		 return issAcqPair;
	 }

}

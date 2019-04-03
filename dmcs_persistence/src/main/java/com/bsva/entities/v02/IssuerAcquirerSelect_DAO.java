package com.bsva.entities.v02;

import java.util.List;

import com.bsva.dao.AbstractDao;

public class IssuerAcquirerSelect_DAO extends AbstractDao<IssuerAcquirerEntity, Void>{
	
	
	private static final String SELECT_ACQUIRER_ISSUERS = " SELECT ISSUER_MEMBER,ACQUIRER_MEMBER,STATUS FROM CSO_ACQUIRER_ISSUER_PAIR ";
	
	
	private static final String DELETEA_CSO_ACQUIRER_ISSUER_PAIR = "DELETE FROM CSO_ACQUIRER_ISSUER_PAIR";
	
	
	
	 public List<IssuerAcquirerEntity> getIssuerAcquirerMember() {
	    // execute
	    List<IssuerAcquirerEntity> entities
	                = list(SELECT_ACQUIRER_ISSUERS,IssuerAcquirerEntity.class);

	      return entities;
	}
	 
	 
	 public void deleteData(){
		 
		 deleteTruncate(DELETEA_CSO_ACQUIRER_ISSUER_PAIR);
	 }
	
	 
	

}

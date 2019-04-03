package com.bsva.entities.v02;

import java.util.List;

import com.bsva.dao.AbstractDao;

public class CsoMemberMcard_DAO extends AbstractDao<CsoPaymentMcardEntity, Void> {
	
	private static final String SELECT_MASTER_CARD_QUERY = " SELECT ISSUER_MEMBER,ACQUIRER_MEMBER  FROM CSO_PAYMENT_INSTRUCTIONS_MCARD "+    
	          " WHERE ((( RECORD_ID IN (14,15,16,17)         "+  
	          "    OR ( TRANSACTION_CODE IN (14,15,16,17)))  "+
	          "    AND FINANCIAL_INDICATOR = 'Y')            "+
	          "   OR ( TRANSACTION_CODE IN (51, 52, 53)))    "+
	          "    AND PROCESS_STATUS = 'C'                  "+           
	          "  GROUP BY ISSUER_MEMBER,ACQUIRER_MEMBER      ";
	
	
	 public List<CsoPaymentMcardEntity> getMasterCard() {
	    // execute
	    List<CsoPaymentMcardEntity> entities
	                = list(SELECT_MASTER_CARD_QUERY,CsoPaymentMcardEntity.class);

	  return entities;
}

}

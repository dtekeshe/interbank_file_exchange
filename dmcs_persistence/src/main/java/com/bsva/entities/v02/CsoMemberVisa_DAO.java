package com.bsva.entities.v02;

import java.util.List;

import com.bsva.dao.AbstractDao;

public class CsoMemberVisa_DAO extends AbstractDao<CsoPaymentVisaEntity, Void>{
	
	
	private static final String SELECT_VISA_CARD_QUERY = " SELECT ISSUER_MEMBER , ACQUIRER_MEMBER  FROM  CSO_PAYMENT_INSTRUCTIONS_VISA  "+  
            " WHERE PROCESS_STATUS = 'C'                "+        
            " AND (FINANCIAL_INDICATOR = 'Y'            "+
            " AND TRANSACTION_CODE IN                   "+ 
            " (14,15,16,17))                          "+  
            " GROUP BY ISSUER_MEMBER , ACQUIRER_MEMBER  ";
	
	 public List<CsoPaymentVisaEntity> getVisaCard() {
		    // execute
		    List<CsoPaymentVisaEntity> entities
		                = list(SELECT_VISA_CARD_QUERY,CsoPaymentVisaEntity.class);

		  return entities;
	}

}

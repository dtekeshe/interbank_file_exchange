package com.bsva.dao.v02.fileextract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;

public class paymentInstVISADAO extends AbstractDao<PaymentInstVISAEntity, Void> {
	
	private static String PAY_INST_VISA_QUERY = "SELECT SYSTEM_GEN_SEQ_NUMBER ,TRANSACTION_CODE_NUMBER "
			+ ",FILE_REF_NUMBER, SERVICE ,SUB_SERVICE ,FILENAME_DESCRIPTION FROM CSO_PAYMENT_INSTRUCTIONS_VISA WHERE FILE_REF_NUMBER = :fileRefNumber";
	
	
	public List<PaymentInstVISAEntity> getAllNegFiles(String fileRefNumber){
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("fileRefNumber", fileRefNumber);		
		List<PaymentInstVISAEntity>  listData = new ArrayList<PaymentInstVISAEntity>();
		List<PaymentInstVISAEntity> entities = list(PAY_INST_VISA_QUERY,params, PaymentInstVISAEntity.class);
		for (PaymentInstVISAEntity paymentInstVISAEntity : entities) {
			listData.add(paymentInstVISAEntity);
		}
		return listData;
	}

}

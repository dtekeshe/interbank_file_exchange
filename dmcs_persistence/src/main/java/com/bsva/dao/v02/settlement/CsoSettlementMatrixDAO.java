package com.bsva.dao.v02.settlement;

import java.util.HashMap;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.settlement.CsoSettlementMatrixEntity;

public class CsoSettlementMatrixDAO extends AbstractDao<CsoSettlementMatrixEntity, Void> {
	
	private final static String SETTLEMENT_MATRIX_SQL_INSERT = " INSERT INTO CSO_SETTLEMENT_MATRIXES("
				+ " ORIGINATING_BANK,ACTION_DATE,HOMING_BANK,SERVICE,SUB_SERVICE,CURRENCY_CODE,STATUS_CODE,SETTLEMENT_IND,"
				+ " BANK_OUTPUT_CREATED_IND,CR_VOLUME,DR_VOLUME,CR_VALUE,DR_VALUE,PAYMENT_STREAM)"
				+ " VALUES(:originatingBank,:actionDate,:homingBank,:service,:subService,:currencyCode,"
				+ ":statusCode,:settlementInd,:bankOutputCreatedInd,:crVolume,:drVolume,:crValue,:drValue,:paymentStream)";
	
	
   public int insertDate(CsoSettlementMatrixEntity entity){
	  
	   Map<String,Object> params = new HashMap<String, Object>();
	   params.put("originatingBank", entity.getCsoSettlementMatrixEntity_PK().getOriginatingBank());
	   params.put("homingBank", entity.getCsoSettlementMatrixEntity_PK().getHomingBank());
	   params.put("service", entity.getCsoSettlementMatrixEntity_PK().getService());
	   params.put("subService", entity.getCsoSettlementMatrixEntity_PK().getSubService());
	   params.put("settlementInd", entity.getCsoSettlementMatrixEntity_PK().getSettlementInd());
	   params.put("actionDate", entity.getCsoSettlementMatrixEntity_PK().getActionDate());
	   
	   params.put("currencyCode", entity.getCurrencyCode());
	   params.put("statusCode", entity.getStatusCode());
	   params.put("bankOutputCreatedInd", entity.getBankOutputCreatedInd());
	   params.put("crVolume", entity.getCrVolume());
	   params.put("crValue", entity.getCrValue());
	   params.put("drVolume", entity.getDrVolume());
	   params.put("drValue", entity.getDrValue());
	   params.put("paymentStream", entity.getPaymentStream());
	   
	   int numberOfRecords = executeUpdate(SETTLEMENT_MATRIX_SQL_INSERT,params);
	   
	   return numberOfRecords;
	   
   }
	

}

package com.bsva.dao.v02.settlement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.settlement.CCR00XFinalTotalsDataSettleEntity;

public class EndOfDaySettlementDAO extends AbstractDao<CCR00XFinalTotalsDataSettleEntity, Void>{
	
	private final static String SETTLEMENT_FINAL_TOTALS_ACQUIRER_DATA_SQL = "   SELECT SUB_SERVICE, ACQUIRER_CODE AS ACQUIRER_CODE,ISSUER_CODE AS ISSUER_CODE, ACQUIRER_MEMBER AS ISSUER_MEMBER,  "
			+ "          TRANSACTION_CODE,TRANSACTION_DESCRIPTION,                                                    "
			+ "          SUM(VOLUME) AS VOLUME, SUM(TRAN_VALUE) AS TRAN_VALUE, SUM(BILLING_FEE) AS BILLING_FEE,       "
			+ "          SUM(BILLING_FEE_AMOUNT) AS BILLING_FEE_AMOUNT, SUM(BILLING_VAT) AS BILLING_VAT               "
			+ "     FROM CSV_CCR00X_DATA_VIEW                                                                         "
			+ "    WHERE  SUB_SERVICE   = :subServiceID                                                               "
			+ "      AND ACQUIRER_CODE   = :acquirerBankCode     													  "
			+ "      AND ISSUER_CODE NOT IN(:acquirerBankCode)  													  "			
			+ "      AND VOLUME > 0                                                     							  "
			+ "    GROUP BY SUB_SERVICE, ACQUIRER_CODE,ISSUER_CODE, ACQUIRER_MEMBER, TRANSACTION_CODE, TRANSACTION_DESCRIPTION    "
			+ " ORDER BY TRANSACTION_CODE                                                                             ";

	// USED TO WRITE FLEET REPORTS
	private final static String SETTLEMENT_FINAL_TOTALS_ACQUIRER_FLEET_DATA_SQL = "   SELECT SUB_SERVICE, ACQUIRER_CODE AS ACQUIRER_CODE,ISSUER_CODE AS ISSUER_CODE, ACQUIRER_MEMBER AS ISSUER_MEMBER, "
			+ "          TRANSACTION_CODE,TRANSACTION_DESCRIPTION,                                                   		 "
			+ "          SUM(VOLUME) AS VOLUME, SUM(TRAN_VALUE) AS TRAN_VALUE, SUM(BILLING_FEE_AMOUNT) AS BILLING_FEE,       "
			+ "          SUM(BILLING_FEE) AS BILLING_FEE_AMOUNT, SUM(BILLING_VAT) AS BILLING_VAT               				 "
			+ "     FROM CSV_FLEET_BILL_VIEW                                                                          		 "
			+ "    WHERE SUB_SERVICE   = :subServiceID                                                               		 "
			+ "      AND ACQUIRER_CODE   = :acquirerBankCode                                                          		 "
			+ "		 AND ISSUER_CODE NOT IN (:acquirerBankCode)                                                      		 "
			+ "		  AND VOLUME > 0    																					 "
			+ "    GROUP BY SUB_SERVICE, ACQUIRER_CODE, ISSUER_CODE, ACQUIRER_MEMBER, TRANSACTION_CODE, TRANSACTION_DESCRIPTION    "
			+ " ORDER BY TRANSACTION_CODE                                                                             ";
	
	public List<CCR00XFinalTotalsDataSettleEntity> ccr00XDataForAcquirer(String subServiceID) {

		// prepare params
		Map<String, Object> params = new HashMap<>();
		//params.put("serviceID", serviceID);
		params.put("subServiceID", subServiceID);
		//params.put("acquirerBankCode", acquirerBankCode);

		// execute
		List<CCR00XFinalTotalsDataSettleEntity> entities = null;
		if (subServiceID.equals("FLEET CARD")) {
				entities = list(SETTLEMENT_FINAL_TOTALS_ACQUIRER_FLEET_DATA_SQL, params,CCR00XFinalTotalsDataSettleEntity.class);
		}
		else {
			entities = list(SETTLEMENT_FINAL_TOTALS_ACQUIRER_DATA_SQL, params, CCR00XFinalTotalsDataSettleEntity.class);
		}

		return entities;
	}
	public List<CCR00XFinalTotalsDataSettleEntity> ccr00XDataForAcquirerIssuer(String subServiceID,String acquirerBankCode) {

		// prepare params
		Map<String, Object> params = new HashMap<>();
		//params.put("serviceID", serviceID);
		params.put("subServiceID", subServiceID);
		params.put("acquirerBankCode", acquirerBankCode);

		// execute
		List<CCR00XFinalTotalsDataSettleEntity> entities = null;
		if (subServiceID.equals("FLEET CARD")) {
				entities = list(SETTLEMENT_FINAL_TOTALS_ACQUIRER_FLEET_DATA_SQL, params,CCR00XFinalTotalsDataSettleEntity.class);
		}
		else {
			entities = list(SETTLEMENT_FINAL_TOTALS_ACQUIRER_DATA_SQL, params, CCR00XFinalTotalsDataSettleEntity.class);
		}

		return entities;
	}
}

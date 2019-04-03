package com.bsva.dao.v02.settlement;

import com.bsva.dao.AbstractDao;
import com.bsva.dao.v02.TxnGroupCodesDAO;
import com.bsva.dto.TxnGroup;
import com.bsva.entities.v02.settlement.CCR00XDataEntity;
import com.bsva.entities.v02.settlement.CCR00XSummaryDataEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class CCR00XSummaryDataDAO extends AbstractDao<CCR00XSummaryDataEntity, Void> {

	private final Map<Integer, Integer> txnGroupCodes;

	/*
	 * CCR00X report groups txns but there is no group info in the database This da
	 */

	public CCR00XSummaryDataDAO() {
		txnGroupCodes = new TxnGroupCodesDAO().txnCodeGroupMap();
	}

	private final static String SETTLEMENT_SUMMARY_DATA_SQL = "SELECT SUB_SERVICE, ISSUER_CODE, ISSUER_MEMBER, ACQUIRER_CODE, ACQUIRER_MEMBER,                        "
			+ "          TRANSACTION_CODE,TRANSACTION_DESCRIPTION,                                                    "
			+ "          SUM(VOLUME) AS VOLUME, SUM(TRAN_VALUE) AS TRAN_VALUE, SUM(BILLING_FEE) AS BILLING_FEE,       "
			+ "          SUM(BILLING_FEE_AMOUNT) AS BILLING_FEE_AMOUNT, SUM(BILLING_VAT) AS BILLING_VAT               "
			+ "    FROM CSV_CCR00X_DATA_VIEW                                                                          "
			+ "    WHERE SERVICE       = :serviceID                                                                   "
			+ "      AND SUB_SERVICE   = :subServiceID                                                                "
			+ "      AND ISSUER_CODE   = :issuerBankCode                                                              "
			+ "      AND ACQUIRER_CODE = :acquirerBankCode                                                            "
			+ "    GROUP BY SUB_SERVICE, ISSUER_CODE, ISSUER_MEMBER, ACQUIRER_CODE, ACQUIRER_MEMBER,                  "
			+ "               TRANSACTION_CODE, TRANSACTION_DESCRIPTION                                               "
			+ " ORDER BY ISSUER_CODE, ACQUIRER_CODE, TRANSACTION_CODE                                                 ";

	private final static String SETTLEMENT_SUMMARY_FLEET_DATA_SQL = "SELECT SUB_SERVICE, ISSUER_CODE, ISSUER_MEMBER, ACQUIRER_CODE, ACQUIRER_MEMBER,                        "
			+ "          TRANSACTION_CODE,TRANSACTION_DESCRIPTION,                                                    "
			+ "          SUM(VOLUME) AS VOLUME, SUM(TRAN_VALUE) AS TRAN_VALUE, SUM(BILLING_FEE) AS BILLING_FEE,       "
			+ "          SUM(BILLING_FEE_AMOUNT) AS BILLING_FEE_AMOUNT, SUM(BILLING_VAT) AS BILLING_VAT               "
			+ "    FROM CSV_FLEET_BILL_VIEW                                                                          "
			+ "    WHERE SERVICE       = :serviceID                                                                   "
			+ "      AND SUB_SERVICE   = :subServiceID                                                                "
			+ "      AND ISSUER_CODE   = :issuerBankCode                                                              "
			+ "      AND ACQUIRER_CODE = :acquirerBankCode                                                            "
			+ "    GROUP BY SUB_SERVICE, ISSUER_CODE, ISSUER_MEMBER, ACQUIRER_CODE, ACQUIRER_MEMBER,                  "
			+ "               TRANSACTION_CODE, TRANSACTION_DESCRIPTION                                               "
			+ " ORDER BY ISSUER_CODE, ACQUIRER_CODE, TRANSACTION_CODE                                                 ";

	public Map<TxnGroup, List<CCR00XSummaryDataEntity>> ccr00XData(String serviceID, String subServiceID,
			Integer issuerBankCode, Integer acquirerBankCode) {

		// prepare params
		Map<String, Object> params = new HashMap<>();
		params.put("serviceID", serviceID);
		params.put("subServiceID", subServiceID);
		params.put("issuerBankCode", issuerBankCode);
		params.put("acquirerBankCode", acquirerBankCode);

		// execute
		List<CCR00XSummaryDataEntity> entities = null;
		if (subServiceID.equals("FLEET CARD")) {
			entities = list(SETTLEMENT_SUMMARY_FLEET_DATA_SQL, params, CCR00XSummaryDataEntity.class);
		}
		else {
			entities = list(SETTLEMENT_SUMMARY_DATA_SQL, params, CCR00XSummaryDataEntity.class);
		}

		// prepare result
		Map<TxnGroup, List<CCR00XSummaryDataEntity>> ccr00XData = new HashMap<>();

		for (CCR00XSummaryDataEntity entity : entities) {

			Integer txnCode = entity.getId().getTxnCode();
			Integer txnGroupCode = txnGroupCodes.get(txnCode);

			TxnGroup txnGroup = new TxnGroup(serviceID, subServiceID, entity.getId().getIssuerCode(),
					entity.getId().getAcquirerCode(), txnGroupCode);

			List<CCR00XSummaryDataEntity> txnGroupData = ccr00XData.get(txnGroup);
			if (txnGroupData == null) {
				txnGroupData = new ArrayList<>();
				ccr00XData.put(txnGroup, txnGroupData);
			}
			txnGroupData.add(entity);
		}

		return ccr00XData;
	}
}

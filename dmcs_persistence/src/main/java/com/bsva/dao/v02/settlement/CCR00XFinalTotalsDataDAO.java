package com.bsva.dao.v02.settlement;

import com.bsva.dao.AbstractDao;
import com.bsva.dao.v02.TxnGroupCodesDAO;
import com.bsva.dto.FinalTotalsTxnGroup;
import com.bsva.dto.TxnGroup;
import com.bsva.entities.v02.settlement.CCR00XFinalTotalsDataEntity;
import com.bsva.entities.v02.settlement.CCR00XSummaryDataEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class CCR00XFinalTotalsDataDAO extends AbstractDao<CCR00XFinalTotalsDataEntity, Void> {

	private final Map<Integer, Integer> txnGroupCodes;

	/*
	 * CCR00X report groups txns but there is no group info in the database This da
	 */

	public CCR00XFinalTotalsDataDAO() {
		txnGroupCodes = new TxnGroupCodesDAO().txnCodeGroupMap();
	}

	private final static String SETTLEMENT_FINAL_TOTALS_ISSUER_DATA_SQL = "   SELECT SUB_SERVICE, ISSUER_CODE, ISSUER_MEMBER,                                       "
			+ "          TRANSACTION_CODE,TRANSACTION_DESCRIPTION,                                                    "
			+ "          SUM(VOLUME) AS VOLUME, SUM(TRAN_VALUE) AS TRAN_VALUE, SUM(BILLING_FEE) AS BILLING_FEE,       "
			+ "          SUM(BILLING_FEE_AMOUNT) AS BILLING_FEE_AMOUNT, SUM(BILLING_VAT) AS BILLING_VAT               "
			+ "     FROM CSV_CCR00X_DATA_VIEW                                                                         "
			+ "    WHERE SERVICE       = :serviceID                                                                   "
			+ "      AND SUB_SERVICE   = :subServiceID                                                                "
			+ "      AND ISSUER_CODE   = :issuerBankCode      														  "
			+ "		 AND ACQUIRER_CODE NOT IN(:issuerBankCode)                                                        "
			+ "    GROUP BY SUB_SERVICE, ISSUER_CODE, ISSUER_MEMBER, TRANSACTION_CODE, TRANSACTION_DESCRIPTION        "
			+ " ORDER BY TRANSACTION_CODE                                                                             ";

	private final static String SETTLEMENT_FINAL_TOTALS_ACQUIRER_DATA_SQL = "   SELECT SUB_SERVICE, ACQUIRER_CODE AS ISSUER_CODE, ACQUIRER_MEMBER AS ISSUER_MEMBER,  "
			+ "          TRANSACTION_CODE,TRANSACTION_DESCRIPTION,                                                    "
			+ "          SUM(VOLUME) AS VOLUME, SUM(TRAN_VALUE) AS TRAN_VALUE, SUM(BILLING_FEE) AS BILLING_FEE,       "
			+ "          SUM(BILLING_FEE_AMOUNT) AS BILLING_FEE_AMOUNT, SUM(BILLING_VAT) AS BILLING_VAT               "
			+ "     FROM CSV_CCR00X_DATA_VIEW                                                                         "
			+ "    WHERE SERVICE       = :serviceID                                                                   "
			+ "      AND SUB_SERVICE   = :subServiceID                                                                "
			+ "      AND ACQUIRER_CODE   = :acquirerBankCode     													  "
			+ "      AND ISSUER_CODE NOT IN(:acquirerBankCode)                                                        "
			+ "    GROUP BY SUB_SERVICE, ACQUIRER_CODE, ACQUIRER_MEMBER, TRANSACTION_CODE, TRANSACTION_DESCRIPTION    "
			+ " ORDER BY TRANSACTION_CODE                                                                             ";

	// USED TO WRITE FLEET REPORTS
	private final static String SETTLEMENT_FINAL_TOTALS_ISSUER_FLEET_DATA_SQL = "   SELECT SUB_SERVICE, ISSUER_CODE, ISSUER_MEMBER,                                    "
			+ "          TRANSACTION_CODE,TRANSACTION_DESCRIPTION,                                                    "
			+ "          SUM(VOLUME) AS VOLUME, SUM(TRAN_VALUE) AS TRAN_VALUE, SUM(BILLING_FEE_AMOUNT) AS BILLING_FEE,       "
			+ "          SUM(BILLING_FEE) AS BILLING_FEE_AMOUNT, SUM(BILLING_VAT) AS BILLING_VAT               "
			+ "     FROM CSV_FLEET_BILL_VIEW                                                                          "
			+ "    WHERE SERVICE       = :serviceID                                                                   "
			+ "      AND SUB_SERVICE   = :subServiceID                                                                "
			+ "      AND ISSUER_CODE   = :issuerBankCode                                                              "
			+ "      AND ACQUIRER_CODE NOT IN(:issuerBankCode)                                                        "
			+ "    GROUP BY SUB_SERVICE, ISSUER_CODE, ISSUER_MEMBER, TRANSACTION_CODE, TRANSACTION_DESCRIPTION        "
			+ " ORDER BY TRANSACTION_CODE                                                                             ";

	// USED TO WRITE FLEET REPORTS
	private final static String SETTLEMENT_FINAL_TOTALS_ACQUIRER_FLEET_DATA_SQL = "   SELECT SUB_SERVICE, ACQUIRER_CODE AS ISSUER_CODE, ACQUIRER_MEMBER AS ISSUER_MEMBER, "
			+ "          TRANSACTION_CODE,TRANSACTION_DESCRIPTION,                                                    "
			+ "          SUM(VOLUME) AS VOLUME, SUM(TRAN_VALUE) AS TRAN_VALUE, SUM(BILLING_FEE_AMOUNT) AS BILLING_FEE,       "
			+ "          SUM(BILLING_FEE) AS BILLING_FEE_AMOUNT, SUM(BILLING_VAT) AS BILLING_VAT               "
			+ "     FROM CSV_FLEET_BILL_VIEW                                                                          "
			+ "    WHERE SERVICE       = :serviceID                                                                   "
			+ "      AND SUB_SERVICE   = :subServiceID                                                                "
			+ "      AND ACQUIRER_CODE   = :acquirerBankCode                                                          "
			+ "		 AND ISSUER_CODE NOT IN (:acquirerBankCode)                                                       "
			+ "    GROUP BY SUB_SERVICE, ACQUIRER_CODE, ACQUIRER_MEMBER, TRANSACTION_CODE, TRANSACTION_DESCRIPTION    "
			+ " ORDER BY TRANSACTION_CODE                                                                             ";

	public Map<FinalTotalsTxnGroup, List<CCR00XFinalTotalsDataEntity>> ccr00XData(String serviceID, String subServiceID,
			Integer issuerBankCode) {

		// prepare params
		Map<String, Object> params = new HashMap<>();
		params.put("serviceID", serviceID);
		params.put("subServiceID", subServiceID);
		params.put("issuerBankCode", issuerBankCode);

		// execute
		List<CCR00XFinalTotalsDataEntity> entities = null;
		if (subServiceID.equals("FLEET CARD")) {
			try {
				entities = list(SETTLEMENT_FINAL_TOTALS_ISSUER_FLEET_DATA_SQL, params,
						CCR00XFinalTotalsDataEntity.class);
			}
			catch (Exception ex) {
				System.out.println("Error :" + ex.getMessage());
				ex.printStackTrace();
			}
		}
		else {
			entities = list(SETTLEMENT_FINAL_TOTALS_ISSUER_DATA_SQL, params, CCR00XFinalTotalsDataEntity.class);
		}

		// prepare result
		Map<FinalTotalsTxnGroup, List<CCR00XFinalTotalsDataEntity>> ccr00XData = new HashMap<>();

		for (CCR00XFinalTotalsDataEntity entity : entities) {

			Integer txnCode = entity.getId().getTxnCode();
			Integer txnGroupCode = txnGroupCodes.get(txnCode);

			FinalTotalsTxnGroup txnGroup = new FinalTotalsTxnGroup(serviceID, subServiceID,
					entity.getId().getIssuerCode(), txnGroupCode);

			List<CCR00XFinalTotalsDataEntity> txnGroupData = ccr00XData.get(txnGroup);
			if (txnGroupData == null) {
				txnGroupData = new ArrayList<>();
				ccr00XData.put(txnGroup, txnGroupData);
			}
			txnGroupData.add(entity);
		}

		return ccr00XData;
	}

	public Map<FinalTotalsTxnGroup, List<CCR00XFinalTotalsDataEntity>> ccr00XDataForAcquirer(String serviceID,
			String subServiceID, Integer acquirerBankCode) {

		// prepare params
		Map<String, Object> params = new HashMap<>();
		params.put("serviceID", serviceID);
		params.put("subServiceID", subServiceID);
		params.put("acquirerBankCode", acquirerBankCode);

		// execute
		List<CCR00XFinalTotalsDataEntity> entities = null;
		if (subServiceID.equals("FLEET CARD")) {
			try {
				entities = list(SETTLEMENT_FINAL_TOTALS_ACQUIRER_FLEET_DATA_SQL, params,
						CCR00XFinalTotalsDataEntity.class);
			}
			catch (Exception ex) {
				System.out.println("Error Occured" + ex.getMessage());
				ex.printStackTrace();
			}
		}
		else {
			entities = list(SETTLEMENT_FINAL_TOTALS_ACQUIRER_DATA_SQL, params, CCR00XFinalTotalsDataEntity.class);
		}

		// prepare result
		Map<FinalTotalsTxnGroup, List<CCR00XFinalTotalsDataEntity>> ccr00XData = new HashMap<>();

		for (CCR00XFinalTotalsDataEntity entity : entities) {

			Integer txnCode = entity.getId().getTxnCode();
			Integer txnGroupCode = txnGroupCodes.get(txnCode);

			FinalTotalsTxnGroup txnGroup = new FinalTotalsTxnGroup(serviceID, subServiceID,
					entity.getId().getIssuerCode(), txnGroupCode);

			List<CCR00XFinalTotalsDataEntity> txnGroupData = ccr00XData.get(txnGroup);
			if (txnGroupData == null) {
				txnGroupData = new ArrayList<>();
				ccr00XData.put(txnGroup, txnGroupData);
			}
			txnGroupData.add(entity);
		}

		return ccr00XData;
	}
}

package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.dto.IssuerCode;
import com.bsva.dto.TxnGroup;
import com.bsva.entities.v02.settlement.CCR00XDataEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class CCR00XDataDAO extends AbstractDao<CCR00XDataEntity, Void> {

	private final Map<Integer, Integer> txnGroupCodes;

	/*
	 * CCR00X report groups txns but there is no group info in the database This da
	 */

	public CCR00XDataDAO() {
		txnGroupCodes = new TxnGroupCodesDAO().txnCodeGroupMap();
	}

	private final static String SETTLEMENT_DATA_SQL =

			"   SELECT ISSUER_CODE, ISSUER_MEMBER, ACQUIRER_CODE, ACQUIRER_MEMBER, SUB_SERVICE,                     "
					+ "          TRANSACTION_CODE,TRANSACTION_DESCRIPTION,                                                    "
					+ "          CARD_TYPE, CARD_DESCRIPTION,                                                                 "
					+ "          VOLUME, TRAN_VALUE, BILLING_FEE, BILLING_FEE_AMOUNT, BILLING_VAT, REPORT_SORT_SEQUENCE       "
					+ "     FROM CSV_CCR00X_DATA_VIEW                                                                         "
					+ "    WHERE SERVICE = :serviceID                                                                         "
					+ "      AND SUB_SERVICE   = :subServiceID                                                                "
					+ "      AND ISSUER_CODE   = :issuerBankCode                                                              "
					+ "      AND ACQUIRER_CODE = :acquirerBankCode                                                            "
					+ "      AND CARD_TYPE     = :cardType                                                                    "
					+ " ORDER BY ISSUER_CODE, ACQUIRER_CODE, CARD_TYPE, REPORT_SORT_SEQUENCE                                  ";

	private final static String SETTLEMENT_FLEET_DATA_SQL =

			"   SELECT  ISSUER_CODE,ISSUER_MEMBER, ACQUIRER_CODE, ACQUIRER_MEMBER, SUB_SERVICE,                    		      "
					+ "          TRANSACTION_CODE,TRANSACTION_DESCRIPTION,                                                    "
					+ "          CARD_TYPE, CARD_DESCRIPTION,                                                                 "
					+ "          VOLUME, TRAN_VALUE, BILLING_FEE AS BILLING_FEE_AMOUNT, BILLING_FEE_AMOUNT AS BILLING_FEE, BILLING_VAT, REPORT_SORT_SEQUENCE       "
					+ "     FROM CSV_FLEET_BILL_VIEW                                                                          "
					+ "    WHERE SERVICE = :serviceID                                                                         "
					+ "      AND SUB_SERVICE   = :subServiceID                                                                "
					+ "      AND ISSUER_CODE   = :issuerBankCode                                                              "
					+ "      AND ACQUIRER_CODE = :acquirerBankCode                                                            "
					+ "      AND CARD_TYPE     = :cardType                                                                    "
					+ " ORDER BY ISSUER_CODE, ACQUIRER_CODE, CARD_TYPE, REPORT_SORT_SEQUENCE                                  ";

	public Map<TxnGroup, List<CCR00XDataEntity>> ccr00XData(String serviceID, String subServiceID,
			Integer acquirerBankCode, Integer issuerBankCode, Integer cardType) {

		// prepare params
		Map<String, Object> params = new HashMap<>();
		params.put("serviceID", serviceID);
		params.put("subServiceID", subServiceID);
		params.put("issuerBankCode", issuerBankCode);
		params.put("acquirerBankCode", acquirerBankCode);
		params.put("cardType", cardType);

		// execute
		List<CCR00XDataEntity> entities;
		// prepare result
		Map<TxnGroup, List<CCR00XDataEntity>> ccr00XData = new HashMap<>();
		try {
			if (subServiceID.equals("FLEET CARD")) {
				entities = list(SETTLEMENT_FLEET_DATA_SQL, params, CCR00XDataEntity.class);
			}
			else {
				entities = list(SETTLEMENT_DATA_SQL, params, CCR00XDataEntity.class);
			}

			for (CCR00XDataEntity entity : entities) {

				Integer txnCode = entity.getId().getTxnCode();
				Integer txnGroupCode = txnGroupCodes.get(txnCode);

				TxnGroup txnGroup = new TxnGroup(serviceID, subServiceID, entity.getId().getAcquirerCode(),
						entity.getId().getIssuerCode(), txnGroupCode);

				List<CCR00XDataEntity> txnGroupData = ccr00XData.get(txnGroup);
				if (txnGroupData == null) {
					txnGroupData = new ArrayList<>();
					ccr00XData.put(txnGroup, txnGroupData);
				}
				txnGroupData.add(entity);
			}
			
			

		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return ccr00XData;
	}

	public Map<IssuerCode, List<CCR00XDataEntity>> ccr002Data(String serviceID, String subServiceID,
			Integer issuerBankCode, Integer acquirerBankCode, Integer cardType) {

		return null;
	}
}
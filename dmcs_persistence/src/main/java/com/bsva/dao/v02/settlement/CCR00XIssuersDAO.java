package com.bsva.dao.v02.settlement;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.settlement.IssuerEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class CCR00XIssuersDAO extends AbstractDao<IssuerEntity, Void> {

	private final static String CCR00X_ISSUERS_SQL_1 = "   SELECT SUB_SERVICE, ISSUER_CODE, MEMBER_NO, ISSUER_MEMBER ,MNEMONIC_MEMBER_NAME                     "
			+ "     FROM CSV_CCR00X_DATA_VIEW D                                                                       "
			+ "     JOIN CSF_MEMBERS M                                                                                "
			+ "       ON (D.ISSUER_CODE = M.BANK_CODE)                                                                "
			+ "    WHERE SERVICE = 'CARD'                                                                             "
			+ "      AND SUB_SERVICE = :subServiceID                                                                  ";
	private final static String CCR00X_ISSUERS_GROUP_BY_SQL = " GROUP BY SUB_SERVICE, ISSUER_CODE, MEMBER_NO, ISSUER_MEMBER , MNEMONIC_MEMBER_NAME                    "
			+ "   HAVING SUM(VOLUME) > 0                                                                              ";
	
	

	private final static String CCR00X_ISSUERS_FOR_GIVEN_ACQUIRER_SQL = "   SELECT SUB_SERVICE, ISSUER_CODE, MEMBER_NO, ISSUER_MEMBER ,MNEMONIC_MEMBER_NAME                     "
			+ "     FROM CSV_CCR00X_DATA_VIEW D                                                                       "
			+ "     JOIN CSF_MEMBERS M                                                                                "
			+ "       ON (D.ISSUER_CODE = M.BANK_CODE)                                                                "
			+ "    WHERE ACQUIRER_CODE = :acquirerCode                                                                "
			+ "      AND SERVICE = 'CARD'                                                                             "
			+ "      AND SUB_SERVICE = :subServiceID                                                                  "
			+ " GROUP BY SUB_SERVICE, ISSUER_CODE, MEMBER_NO, ISSUER_MEMBER ,MNEMONIC_MEMBER_NAME                     "
			+ "   HAVING SUM(VOLUME) > 0                                                                              ";

	// USED FOR FLEET CARD
	private final static String CCR00X_ISSUERS_FLEET_SQL = "   SELECT SUB_SERVICE, ISSUER_CODE, MEMBER_NO, ISSUER_MEMBER ,MNEMONIC_MEMBER_NAME                     "
			+ "     FROM CSV_FLEET_BILL_VIEW D                                                                       "
			+ "     JOIN CSF_MEMBERS M                                                                                "
			+ "       ON (D.ISSUER_CODE = M.BANK_CODE)                                                                "
			+ "    WHERE SERVICE = 'CARD'                                                                             "
			+ "      AND SUB_SERVICE = :subServiceID                                                                  "
			+ " GROUP BY SUB_SERVICE, ISSUER_CODE, MEMBER_NO, ISSUER_MEMBER , MNEMONIC_MEMBER_NAME                    "
			+ "   HAVING SUM(VOLUME) > 0                                                                              ";

	// USED FOR FLEET CARD
	private final static String CCR00X_ISSUERS_FOR_GIVEN_ACQUIRER_FLEET_SQL = "   SELECT SUB_SERVICE, ISSUER_CODE, MEMBER_NO, ISSUER_MEMBER ,MNEMONIC_MEMBER_NAME                     "
			+ "     FROM CSV_FLEET_BILL_VIEW D                                                                       "
			+ "     JOIN CSF_MEMBERS M                                                                                "
			+ "       ON (D.ISSUER_CODE = M.BANK_CODE)                                                                "
			+ "    WHERE ACQUIRER_CODE = :acquirerCode                                                                "
			+ "      AND SERVICE = 'CARD'                                                                             "
			+ "      AND SUB_SERVICE = :subServiceID                                                                  "
			+ " GROUP BY SUB_SERVICE, ISSUER_CODE, MEMBER_NO, ISSUER_MEMBER ,MNEMONIC_MEMBER_NAME                     "
			+ "   HAVING SUM(VOLUME) > 0                                                                              ";

	public List<IssuerEntity> issuers(String subServiceID, Integer acquirerCode) {

		// prepare params
		Map<String, Object> params = new HashMap<>();
		params.put("acquirerCode", acquirerCode);
		params.put("subServiceID", subServiceID);

		// execute
		List<IssuerEntity> issuers = null;

		if (subServiceID.endsWith("FLEET CARD")) {
			issuers = list(CCR00X_ISSUERS_FOR_GIVEN_ACQUIRER_FLEET_SQL, params, IssuerEntity.class);
		}
		else {
			issuers = list(CCR00X_ISSUERS_FOR_GIVEN_ACQUIRER_SQL, params, IssuerEntity.class);
		}

		return issuers;
	}

	public List<IssuerEntity> issuers(String subServiceID) {

		// prepare params
		Map<String, Object> params = new HashMap<>();
		params.put("subServiceID", subServiceID);
		
		String sql = CCR00X_ISSUERS_SQL_1  +
				( "MASTERCARD".equals(subServiceID) ?
						" AND D.ISSUER_CODE <> 9 " : " ") +
				CCR00X_ISSUERS_GROUP_BY_SQL;

		// execute
		List<IssuerEntity> issuers = null;
		if (subServiceID.equals("FLEET CARD")) {
			issuers = list(CCR00X_ISSUERS_FLEET_SQL, params, IssuerEntity.class);
		}
		else {
			issuers = list(sql, params, IssuerEntity.class);
		}

		return issuers;
	}
}

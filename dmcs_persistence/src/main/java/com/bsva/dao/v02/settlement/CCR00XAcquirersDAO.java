package com.bsva.dao.v02.settlement;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.settlement.AcquirerEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class CCR00XAcquirersDAO extends AbstractDao<AcquirerEntity, Void> {
    
    private final static String CCR00X_ACQUIRERS_SQL =
            "   SELECT SUB_SERVICE, ACQUIRER_CODE, MEMBER_NO, ACQUIRER_MEMBER                                       " +
            "     FROM CSV_CCR00X_DATA_VIEW D                                                                       " +
            "     JOIN CSF_MEMBERS M                                                                                " +
            "       ON (D.ACQUIRER_CODE = M.BANK_CODE)                                                              " +
            "    WHERE SUB_SERVICE = :subServiceID                                                                  " +
            " GROUP BY SUB_SERVICE, ACQUIRER_CODE, MEMBER_NO, ACQUIRER_MEMBER                                       " +
            "   HAVING SUM(VOLUME) > 0                                                                              " +
            " ORDER BY ACQUIRER_CODE                                                                                ";

    private final static String CCR00X_ACQUIRERS__FOR_GIVE_ISSUER_SQL =
            "   SELECT SUB_SERVICE, ACQUIRER_CODE, MEMBER_NO, ACQUIRER_MEMBER                                       " +
            "     FROM CSV_CCR00X_DATA_VIEW D                                                                       " +
            "     JOIN CSF_MEMBERS M                                                                                " +
            "       ON (D.ACQUIRER_CODE = M.BANK_CODE)                                                              " +
            "    WHERE SUB_SERVICE = :subServiceID                                                                  " +
            "      AND ISSUER_CODE = :issuerCode                                                                    " +
            " GROUP BY SUB_SERVICE, ACQUIRER_CODE, MEMBER_NO, ACQUIRER_MEMBER                                       " +
            "   HAVING SUM(VOLUME) > 0                                                                              " +
            " ORDER BY ACQUIRER_CODE                                                                                ";
    
    private final static String CCR00X_ACQUIRERS_SQL_FLEET =
            "   SELECT SUB_SERVICE, ACQUIRER_CODE, MEMBER_NO, ACQUIRER_MEMBER                                       " +
            "     FROM CSV_FLEET_BILL_VIEW D                                                                        " +
            "     JOIN CSF_MEMBERS M                                                                                " +
            "       ON (D.ACQUIRER_CODE = M.BANK_CODE)                                                              " +
            "    WHERE SUB_SERVICE = :subServiceID                                                                  " +
            " GROUP BY SUB_SERVICE, ACQUIRER_CODE, MEMBER_NO, ACQUIRER_MEMBER                                       " +
            "   HAVING SUM(VOLUME) > 0                                                                              " +
            " ORDER BY ACQUIRER_CODE                                                                                ";

    private final static String CCR00X_ACQUIRERS__FOR_GIVE_ISSUER_SQL_FLEET =
            "   SELECT SUB_SERVICE, ACQUIRER_CODE, MEMBER_NO, ACQUIRER_MEMBER                                       " +
            "     FROM CSV_FLEET_BILL_VIEW D                                                                        " +
            "     JOIN CSF_MEMBERS M                                                                                " +
            "       ON (D.ACQUIRER_CODE = M.BANK_CODE)                                                              " +
            "    WHERE SUB_SERVICE = :subServiceID                                                                  " +
            "      AND ISSUER_CODE = :issuerCode                                                                    " +
            " GROUP BY SUB_SERVICE, ACQUIRER_CODE, MEMBER_NO, ACQUIRER_MEMBER                                       " +
            "   HAVING SUM(VOLUME) > 0                                                                              " +
            " ORDER BY ACQUIRER_CODE                                                                                ";

    public List<AcquirerEntity> acquirers(String subServiceID) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("subServiceID", subServiceID);

        // execute
        List<AcquirerEntity> acquirers = null;
        if("FLEET CARD".equals(subServiceID)){
        	acquirers   = list(CCR00X_ACQUIRERS_SQL_FLEET, params, AcquirerEntity.class);
        }else{
        	 acquirers   = list(CCR00X_ACQUIRERS_SQL, params, AcquirerEntity.class);
        }

        return acquirers;
    }

    public List<AcquirerEntity> acquirers(String subServiceID, Integer issuerCode) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("subServiceID", subServiceID);
        params.put("issuerCode", issuerCode);

        // execute
        List<AcquirerEntity> acquirers = null;
        
        if("FLEET CARD".equals(subServiceID)){
        	acquirers = list(CCR00X_ACQUIRERS__FOR_GIVE_ISSUER_SQL_FLEET, params, AcquirerEntity.class);
        }else{
        	acquirers = list(CCR00X_ACQUIRERS__FOR_GIVE_ISSUER_SQL, params, AcquirerEntity.class);
        }

        return acquirers;
    }
}

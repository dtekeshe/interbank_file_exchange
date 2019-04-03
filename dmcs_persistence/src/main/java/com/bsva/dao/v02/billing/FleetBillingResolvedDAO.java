package com.bsva.dao.v02.billing;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.billing.FleetBillingEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class FleetBillingResolvedDAO extends AbstractDao<FleetBillingEntity, Void> {

    private final static String FLEET_BILLING_RESOLVED_CLEANUP_SQL =
            "   DELETE FROM CSO_FLEET_BIND_RESOLVED                                                                 ";

    private final static String FLEET_BILLING_RESOLVED_SQL =
            "   SELECT  TRAN_SYSTEM_SEQ_NUMBER, ISS AS ISSUER_CODE, ACQ AS ACQUIRER_CODE,                           " +
            "           TX_CDE AS TXN_CODE, CARD_TYPE, TX_CNT AS TXN_COUNT, AMOUNT AS TXN_AMOUNT                    " +
            "     FROM CSO_FLEET_BIND_RESOLVED                                                                      " +
            "    WHERE SERVICE = 'CARD'                                                                             " +
            "      AND SUB_SERVICE = :subServiceID                                                                  ";

    private final static String BILLING_RATE_UPDATE_SQL =
            "   UPDATE CSO_TRANSACTIONS SET                                                                         " +
            "             BILLING_FEE = :billingFee,                                                                " +
            "             BILLING_FEE_AMOUNT = :billingFeeAmount,                                                   " +
            "             BILLING_VAT = :billingVat,                                                                " +
            "             RATE_DESC = :rateDescriptor,                                                              " +
            "             FLEET_COUNT_TRAN = :fleetCountTran                                                        " +
            "    WHERE SYSTEM_SEQ_NUMBER = :systemSeqNumber                                                         ";

    public List<FleetBillingEntity> billingRecords( String subServiceID ) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("subServiceID", subServiceID);

        // execute
        List<FleetBillingEntity> records
                = list(FLEET_BILLING_RESOLVED_SQL, params, FleetBillingEntity.class);

        return records;
    }

    public void update(List<Map<String, Object>> payload ) {

        executeUpdate(BILLING_RATE_UPDATE_SQL, payload);
    }

    public void cleanup() {

        // empty params
        Map<String, Object> emptyParams = new HashMap<>();

        // execute
        executeUpdate(FLEET_BILLING_RESOLVED_CLEANUP_SQL, emptyParams);
    }
}

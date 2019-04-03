package com.bsva.dao.v02.endofservice;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.endofservice.AcquirerIssuerDayTotalEntity;
import com.bsva.entities.v02.endofservice.AcquirerIssuerPairKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class AcquirerIssuerDayTotalDAO extends AbstractDao<AcquirerIssuerDayTotalEntity, Void> {

    // sum record_count and dr_value for each acquirer / issuer paid
    private final static String DAY_TOTALS_SQL =

         "  SELECT ORIGINATING_MEMBER, BANK_CODE, SERVICE, SUB_SERVICE,                                             " +
         "          SUM(RECORD_COUNT) AS RECORD_COUNT_FOR_DAY,                                                      " +
         "          SUM(DR_VALUE) AS DR_VALUE_FOR_DAY                                                               " +
         "    FROM CSO_OUTPUT_CONTROLS                                                                              " +
         "   GROUP BY ORIGINATING_MEMBER, BANK_CODE, SERVICE, SUB_SERVICE                                           " +
         "   ORDER BY ORIGINATING_MEMBER, BANK_CODE, SERVICE, SUB_SERVICE                                           ";

    public Map<AcquirerIssuerPairKey, AcquirerIssuerDayTotalEntity> dayTotals() {

        // execute
        List<AcquirerIssuerDayTotalEntity> entities = list(DAY_TOTALS_SQL, AcquirerIssuerDayTotalEntity.class);

        // prepare result
        Map<AcquirerIssuerPairKey, AcquirerIssuerDayTotalEntity> totals = new HashMap<>();

        for ( AcquirerIssuerDayTotalEntity entity : entities ) {
            totals.put(entity.getId(), entity);
        }

        return totals;
    }
}

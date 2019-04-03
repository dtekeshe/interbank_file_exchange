package com.bsva.dao.v02.endofservice;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.outputcontrols.OutputControlDayTotalEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class Record98BuilderDayTotalsDAO extends AbstractDao<OutputControlDayTotalEntity, Void> {

    private final static String DAY_TOTALS_SQL =

            "    SELECT  SERVICE, SUB_SERVICE,                                                                      " +
            "            BANK_CODE AS ISSUING_BANK_CODE,                                                            " +
            "            FILENAME_PREFIX, DISTRIBUTION_CODE,                                                        " +
            "            COUNT(*) AS FILE_COUNT,                                                                    " +
            "            SUM(CR_VOLUME) AS CR_VOLUME, SUM(CR_VALUE) AS CR_VALUE,                                    " +
            "            SUM(DR_VOLUME) AS DR_VOLUME, SUM(DR_VALUE) AS DR_VALUE                                     " +
            "       FROM CSO_OUTPUT_CONTROLS                                                                        " +
            "      WHERE SERVICE = :serviceID                                                                       " +
            "        AND SUB_SERVICE = :subServiceID                                                                " +
            "   GROUP BY SERVICE, SUB_SERVICE, BANK_CODE, FILENAME_PREFIX, DISTRIBUTION_CODE                        ";

    public List<OutputControlDayTotalEntity> daysTotals(String serviceID, String subServiceID) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("serviceID", serviceID);
        params.put("subServiceID", subServiceID);

        // execute
        List<OutputControlDayTotalEntity> dayTotals
                = list(DAY_TOTALS_SQL, params, OutputControlDayTotalEntity.class);

        return dayTotals;
    }
}

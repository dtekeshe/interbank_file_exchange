package com.bsva.dao.v02.endofservice;

import com.bsva.dao.AbstractDao;
import com.bsva.dto.OriginDestinationPair;
import com.bsva.entities.v02.outputcontrols.OutputControlDayTotalEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class Record98BuilderUpdateDAO extends AbstractDao<Void, Void> {

    private final static String LAST_FILE_INDICATOR_UPDATE_SQL =
            "   UPDATE CSO_OUTPUT_CONTROLS                                                                          " +
            "      SET LAST_FILE_INDICATOR = 'N'                                                                    " +
            "    WHERE SERVICE     = :serviceID                                                                     " +
            "      AND SUB_SERVICE = :subServiceID                                                                  ";

    private final static String UPDATE_LAST_FILE_SQL =

            "   UPDATE CSO_OUTPUT_CONTROLS                                                                          " +
            "      SET LAST_FILE_INDICATOR  = 'Y'                                                                   " +
            "    WHERE BANK_CODE    = :destBankCode                                                                 " +
            "      AND SERVICE      = :serviceID                                                                    " +
            "      AND SUB_SERVICE  = :subServiceID                                                                 " +
            "      AND SEQ_NUMBER   = :seqNumber                                                                    ";

    public void setDefaultLastFileIndicators(String serviceID, String subServiceID) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("serviceID",   serviceID );
        params.put("subServiceID",      subServiceID);

        executeUpdate(LAST_FILE_INDICATOR_UPDATE_SQL, params);
    }

    public void updateDayTotals(List<OutputControlDayTotalEntity> dayTotals) {

        // prepare params
        List<Map<String, Object>> paramsList = new ArrayList<>();
        for (OutputControlDayTotalEntity dayTotal : dayTotals) {
            Map<String, Object> params = new HashMap<>();
            params.put("destBankCode",   dayTotal.getId().getIssuingBankCode() );
            params.put("serviceID",      dayTotal.getId().getServiceID() );
            params.put("subServiceID",   dayTotal.getId().getSubServiceID() );
            params.put("seqNumber",      dayTotal.getSeqNumber());
            paramsList.add(params);
        }

        // execute
        executeUpdate(UPDATE_LAST_FILE_SQL, paramsList);
    }
}

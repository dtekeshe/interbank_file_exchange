package com.bsva.dao.v02.endofservice;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.endofservice.AcquirerIssuerPairKey;

import java.util.HashMap;
import java.util.Map;

/**
 *  update record_count and dr_value with day's totals
 *  set LAST_FILE_INDICATOR = 'Y'
 */
public class AcquirerIssuerLastFileUpdateDAO extends AbstractDao<Void, Void>{

    // update last file status
    private final static String LAST_FILE_UPDATE_SQL =

            " UPDATE CSO_OUTPUT_CONTROLS  " +
            "    SET LAST_FILE_INDICATOR = 'Y', " +
            "    RECORD_COUNT_FOR_DAY = :recordCountForDay, " +
            "    DR_VALUE_FOR_DAY = :drValueForDay," +
            "    RECORD_COUNT = :recordCount "+
            " WHERE ORIGINATING_MEMBER = :acquirerCode " +
            "   AND BANK_CODE = :issuerCode " +
            "   AND SERVICE = :serviceID " +
            "   AND SUB_SERVICE = :subServiceID " +
            "   AND SEQ_NUMBER = :seqNumber ";

    public void update(long recordCountForDay, double drValueForDay, AcquirerIssuerPairKey id, String seqNumber ) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("recordCountForDay", recordCountForDay);
        params.put("drValueForDay", drValueForDay);
        params.put("acquirerCode", id.getAcquirerCode());
        params.put("issuerCode",   id.getIssuerCode());
        params.put("serviceID",    id.getServiceID());
        params.put("subServiceID", id.getSubServiceID());
        params.put("seqNumber",    seqNumber);
        params.put("recordCount",    2);

        // execute
       int value =  executeUpdate(LAST_FILE_UPDATE_SQL, params);
       System.out.println("Int Value is : "+ value);
    }
}

package com.bsva.dao.v02.endofservice;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.endofservice.AcquirerIssuerPairKey;

import java.util.HashMap;
import java.util.Map;

/**
 *  update record_count and dr_value with day's totals
 *  set LAST_FILE_INDICATOR = 'Y'
 */
public class AcquirerIssuerLastFileInsertDAO extends AbstractDao<Void, Void>{

    // update last file status
    private final static String LAST_FILE_INSERT_SQL =

            "       INSERT INTO CSO_OUTPUT_CONTROLS ( " +
            "               SERVICE, SUB_SERVICE, ORIGINATING_MEMBER, BANK_CODE,             " +
            "               FILENAME_DESCRIPTION, FILENAME_PREFIX, SEQ_NUMBER, LAST_FILE_INDICATOR , " +
            "               RECORD_COUNT, DR_VALUE, RECORD_COUNT_FOR_DAY, DR_VALUE_FOR_DAY,  " +
            "               FULLFILEIND, DISTRIBUTION_CODE )   " +
            "       VALUES( :serviceID, :subServiceID, :acquirerCode,  :issuerCode, " +
            "               :filename, :filePrefix, :seqNumber,:lastFileIndicator  " +
            "               :recordCount, :drValue, :recordCountForDay, :drValueForDay,     " +
            "               :fullFileInd,:distributionCode )   ";


    public void insert( AcquirerIssuerPairKey id,String seqNumber, String filename,String filenamePrefix,long recordCountForDay, double drValueForDay,String distributionCode,String lastFileIndicator) {
     try{
        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("serviceID",         id.getServiceID());
        params.put("subServiceID",      id.getSubServiceID());
        params.put("acquirerCode",      id.getAcquirerCode());
        params.put("issuerCode",        id.getIssuerCode());
        params.put("filename",          filename);
        params.put("filePrefix",        filenamePrefix);
        params.put("seqNumber",         seqNumber);
        params.put("lastFileIndicator", lastFileIndicator);
        params.put("recordCount",       0);
        params.put("drValue",           0.0);
        params.put("recordCountForDay", recordCountForDay);
        params.put("drValueForDay",     drValueForDay);  
        params.put("fullFileInd",       "N");
        params.put("distributionCode",  distributionCode);
        
       // params.put("recordCount",       0);

        // execute
        executeUpdate(LAST_FILE_INSERT_SQL, params);

     }catch(Exception ex){
    	 ex.getMessage();
    	 ex.printStackTrace();
     }
    }
}

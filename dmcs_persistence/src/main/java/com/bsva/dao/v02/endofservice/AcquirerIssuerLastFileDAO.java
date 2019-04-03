package com.bsva.dao.v02.endofservice;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.endofservice.AcquirerIssuerLastFileEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Document
 */
public class AcquirerIssuerLastFileDAO extends AbstractDao<AcquirerIssuerLastFileEntity, Void> {

    // get last file for each acquirer / issuer pair
    private final static String LAST_FILES_SQL =

            " SELECT ORIGINATING_MEMBER, BANK_CODE, SERVICE, SUB_SERVICE, FILENAME_DESCRIPTION,DISTRIBUTION_CODE,FILENAME_PREFIX,   " +
            "        MAX(SEQ_NUMBER) AS LAST_SEQ_NUMBER                                                             " +
            "  FROM CSO_OUTPUT_CONTROLS                                                                             " +
            " GROUP BY ORIGINATING_MEMBER, BANK_CODE, SERVICE, SUB_SERVICE ,FILENAME_DESCRIPTION,DISTRIBUTION_CODE,FILENAME_PREFIX  " +
            " ORDER BY ORIGINATING_MEMBER, BANK_CODE, SERVICE, SUB_SERVICE ,FILENAME_DESCRIPTION,DISTRIBUTION_CODE,FILENAME_PREFIX  ";

    public List<AcquirerIssuerLastFileEntity> lastFiles() {
    	List<AcquirerIssuerLastFileEntity> lastFiles = new ArrayList<AcquirerIssuerLastFileEntity>();
     try{
        // execute
    	 lastFiles = list(LAST_FILES_SQL, AcquirerIssuerLastFileEntity.class);

       // return lastFiles;
     }catch(Exception ex){
    	 ex.getMessage();
     }
     return lastFiles;
    }
}

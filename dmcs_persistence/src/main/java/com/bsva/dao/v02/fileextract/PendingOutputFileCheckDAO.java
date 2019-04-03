package com.bsva.dao.v02.fileextract;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.outputcontrols.OutputFileEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class PendingOutputFileCheckDAO extends AbstractDao<OutputFileEntity, Void>{

    private final static String PENDING_OUTPUT_FILE_CHECK_SQL =

            " SELECT SERVICE, SUB_SERVICE, FILENAME_DESCRIPTION, BANK_CODE,ORIGINATING_MEMBER,                      " +
            "		 FULLFILEIND, RECORD_COUNT, SEQ_NUMBER, HASH_TOTAL_99,                                          " +
            "        STATUS_CODE,LAST_FILE_INDICATOR,DR_VALUE ,RECORD_COUNT_FOR_DAY,DR_VALUE_FOR_DAY                " +
            "   FROM CSO_OUTPUT_CONTROLS                                                                            " +
            "  WHERE STATUS_CODE = 'O'                                                                              " +
            "    AND FULLFILEIND = 'F'                                                                              " +
            "    AND SUB_SERVICE = :subServiceID ";

    public boolean pendingFiles( String subServiceID ) {

        Map<String, Object> params = new HashMap<>();
        params.put("subServiceID", subServiceID);

        List<OutputFileEntity> entities
                = list(PENDING_OUTPUT_FILE_CHECK_SQL, params, OutputFileEntity.class);

        return entities.size() > 0;
    }
}

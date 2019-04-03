package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.loader.PendingFileCountEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Document
 */
public class OutputControlsDAO extends AbstractDao<PendingFileCountEntity, Void> {

    private final static String PENDING_FILE_COUNT_SQL =
            " SELECT SUB_SERVICE, COUNT(*) AS UN_EXTRACTED_FILE_COUNT " +
            "   FROM CSO_OUTPUT_CONTROLS " +
            "  WHERE SERVICE = 'CARD' " +
            "    AND SUB_SERVICE = :subServiceID " +
            "    AND ( FULLFILEIND = 'N' " +
            "          OR FULLFILEIND = 'F' ) " +
            "  GROUP BY SUB_SERVICE ";

    public Boolean hasPendingFiles(String subServiceID) throws Exception {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("subServiceID", subServiceID);

        // execute
        PendingFileCountEntity pendingFileCount
                = uniqueResult(PENDING_FILE_COUNT_SQL, params, PendingFileCountEntity.class);

        return pendingFileCount != null && pendingFileCount.getUnExtractFileCount() > 0;
    }
}

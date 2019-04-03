package com.bsva.dao.v02.extract;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.extract.OutputControlsEntity;
import com.bsva.entities.v02.extract.OutputFilePK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class OutputFileReaderDAO extends AbstractDao<OutputControlsEntity, Void> {

	private final static String OUTPUT_FILES_SQL =

            "   SELECT  ORIGINATING_MEMBER AS ORIGIN_BANK_CODE, BANK_CODE AS DEST_BANK_CODE,                       " +
            "           SERVICE AS SERVICE_ID, SUB_SERVICE AS SUB_SERVICE_ID, SEQ_NUMBER,                          " +
            "           FILENAME_DESCRIPTION AS FILENAME, FILENAME_PREFIX, LAST_FILE_INDICATOR,                    " +
            "           RECORD_COUNT, DISTRIBUTION_CODE                                                            " +
            "     FROM  CSO_OUTPUT_CONTROLS                                                                        ";

    private final static String FULL_OUTPUT_FILES_SQL =

                OUTPUT_FILES_SQL +
            "   WHERE FULLFILEIND = 'F'                                                                             ";

    private final static String PARTIAL_OUTPUT_FILES_SQL =

                OUTPUT_FILES_SQL +
            "   WHERE SERVICE = :serviceID                                                                          " +
            "     AND SUB_SERVICE = :subServiceID                                                                   " +
            "     AND FULLFILEIND IN ('N', 'D')                                                                     ";

    private final static String OUTPUT_FILES_UPDATE_SQL =

            "   UPDATE CSO_OUTPUT_CONTROLS                                                                          " +
            "      SET FULLFILEIND = 'C'                                                                            " +
            "   WHERE ORIGINATING_MEMBER = :originBankCode                                                          " +
            "     AND BANK_CODE   = :destBankCode                                                                   " +
            "     AND SERVICE     = :serviceID                                                                      " +
            "     AND SUB_SERVICE = :subServiceID                                                                   " +
            "     AND SEQ_NUMBER  = :seqNumber                                                                      ";


    public List<OutputControlsEntity> pendingFullFiles() {

        // execute
        List<OutputControlsEntity> outputFiles =
                     list(FULL_OUTPUT_FILES_SQL, OutputControlsEntity.class);

        return outputFiles != null ? outputFiles : new ArrayList<OutputControlsEntity>();
    }


    public List<OutputControlsEntity> pendingPartialFiles( String serviceID,
                                                       String subServiceID) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("serviceID", serviceID);
        params.put("subServiceID", subServiceID);

        // execute
        List<OutputControlsEntity> outputFiles =
                list(PARTIAL_OUTPUT_FILES_SQL, params, OutputControlsEntity.class);

        return outputFiles;
    }

    public void updateOutputFile(OutputFilePK id) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("originBankCode", id.getOriginBankCode());
        params.put("destBankCode", id.getDestBankCode());
        params.put("serviceID", id.getServiceID());
        params.put("subServiceID", id.getSubServiceID());
        params.put("seqNumber", id.getSeqNumber());

        // execute
        executeUpdate(OUTPUT_FILES_UPDATE_SQL, params);
    }
}

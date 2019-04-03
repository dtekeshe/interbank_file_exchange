package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.commons.ProgramAlreadyRunFlagEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Document
 */
public class ProgramControlsDAO extends AbstractDao<ProgramAlreadyRunFlagEntity, Void> {

    private final static String PROGRAM_ALREADY_SQL =
            "  SELECT ARB_DATA                                                                                      " +
            "    FROM CSO_PROGRAM_CONTROLS                                                                          " +
            "   WHERE SERVICE_CODE = 'CARD'                                                                         " +
            "     AND STATUS = 'A'                                                                                  " +
            "     AND PROGRAM_NAME = :programName                                                                   " +
            "     AND SUB_SERVICE_CODE = :subServiceID                                                              " +
            "     AND ARB_DATA = :arbData                                                                           " +
            "   GROUP BY ARB_DATA                                                                                   ";

    private final static String START_OF_PROGRAM_LOG_SQL =
            "    INSERT INTO CSO_PROGRAM_CONTROLS                                                                   " +
            "                ( PROGRAM_NAME, SERVICE_CODE, SUB_SERVICE_CODE, STATUS, ARB_DATA,                      " +
            "                  EXECUTION_AVERAGE, SEQ_NO )                                                          " +
            "    VALUES (:programName, 'CARD', :subServiceID, 'A', :arbData, 0, 0 )                                 ";

    public Boolean programAlreadyRun(String programName, String subServiceID, String arbData) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("programName", programName);
        params.put("subServiceID", subServiceID);
        params.put("arbData", arbData);

        // execute
        ProgramAlreadyRunFlagEntity result
                = uniqueResult(PROGRAM_ALREADY_SQL, params, ProgramAlreadyRunFlagEntity.class);

        return result != null;
    }

    public void logStartOfProgram(String programName, String subServiceID, String arbData) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("programName", programName);
        params.put("subServiceID", subServiceID);
        params.put("arbData", arbData);

        // execute
        executeUpdate(START_OF_PROGRAM_LOG_SQL, params);
    }
}

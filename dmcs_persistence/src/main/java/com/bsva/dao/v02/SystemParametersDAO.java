package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.params.SystemParametersEntity;

/**
 * TODO Document
 */
public class SystemParametersDAO extends AbstractDao<SystemParametersEntity, Void> {

    private final static String SYSTEM_PARAMETERS_SQL =
            "   SELECT (SELECT PROCESS_DATE FROM CSO_SYSTEM_PARAMETERS) AS PROCESS_DATE,                           " +
            "          (SELECT SYSTEM_STATUS from SITE_CONTROLS) AS LIVE_TEST_CODE                                 " +
            "    FROM DUAL                                                                                         ";

    private final static String SYSTEM_PARAMETERS_SQL1 = "SELECT A.PROCESS_DATE AS PROCESS_DATE, B.SYSTEM_STATUS AS LIVE_TEST_CODE FROM CSO_SYSTEM_PARAMETERS A ,SITE_CONTROLS B WHERE A.PROCESS_ACTIVE_IND = 'Y'";
    public SystemParametersEntity systemParameters() {

        // execute
        SystemParametersEntity systemParametersEntity
                = uniqueResult(SYSTEM_PARAMETERS_SQL1, SystemParametersEntity.class);

        // prepair result
        return systemParametersEntity;
    }
    
    private final static String DATE_HOLD_OVER = 
    		"SELECT to_char(PROCESS_DATE,'YYYYMMDD') as PROCDATE " +
            " FROM CSO_SYSTEM_PARAMETERS " +
            " WHERE PROCESS_ACTIVE_IND = 'Y' or " +
            " PROCESS_ACTIVE_IND = 'H'";           

    public SystemParametersEntity systemParametersHold() {

        // execute
        SystemParametersEntity systemParametersEntity
                = uniqueResult(DATE_HOLD_OVER, SystemParametersEntity.class);

        // prepair result
        return systemParametersEntity;
    }
}

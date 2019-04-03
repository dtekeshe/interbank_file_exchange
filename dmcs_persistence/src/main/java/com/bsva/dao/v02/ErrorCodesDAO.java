package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.commons.ErrorEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class ErrorCodesDAO extends AbstractDao<ErrorEntity, Void> {

    private final static String ERROR_CODES_SQL =
                "   SELECT ERROR_CODE, ERROR_MESSAGE " +
                "     FROM CSF_ERROR_CODES ";

    public Map<Integer, String> errorCodes() {

        // execute
        List<ErrorEntity> entities = list(ERROR_CODES_SQL, ErrorEntity.class);

        // prepare result
        Map<Integer, String> errorCodes = new HashMap<>();
        for (ErrorEntity entity : entities) {
            errorCodes.put(entity.getErrorCode(), entity.getErrorDescription());
        }

        return errorCodes;
    }
}

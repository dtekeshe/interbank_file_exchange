package com.bsva.dao.v02.endofservice;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.endofservice.SubServiceStatusEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Document
 */
public class SubServiceStatusDAO extends AbstractDao<SubServiceStatusEntity, Void> {
    
    private final static String SUB_SERVICE_STATUS_SQL =
            " SELECT SUB_SERVICE, INWARD_OUTWARD_IND, ACTIVE_INDICATOR                                              " +
            "  FROM CSF_DELIVERY_SERVICES                                                                           " +
            " WHERE SUB_SERVICE = :subServiceID                                                                     " +
            "   AND INWARD_OUTWARD_IND = :direction                                                                 ";

    private final static String SUB_SERVICE_STATUS_UPDATE_SQL =
            " UPDATE CSF_DELIVERY_SERVICES                                                                          " +
            "    SET ACTIVE_INDICATOR = :statusCode                                                                 " +
            "  WHERE SUB_SERVICE = :subServiceID                                                                    " +
            "    AND INWARD_OUTWARD_IND = :direction                                                                ";

    public String status(String subServiceID, String direction) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("subServiceID", subServiceID);
        params.put("direction", direction);

        // execute
        SubServiceStatusEntity entity
                = uniqueResult(SUB_SERVICE_STATUS_SQL, params, SubServiceStatusEntity.class);

        String statusCode = entity.getStatusCode();

        return statusCode;
    }

    public boolean updateStatus(String subServiceID, String direction, String statusCode) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("subServiceID", subServiceID);
        params.put("direction", direction);
        params.put("statusCode", statusCode);

        // execute
        int result = executeUpdate(SUB_SERVICE_STATUS_UPDATE_SQL, params);

        return result > 0;
    }
}

package com.bsva.dao.v02.common;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.commons.DeliveryServiceEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Document
 */
public class DeliveryServiceDAO extends AbstractDao<DeliveryServiceEntity, Void> {

    private final static String DELIVERY_SERVICE_SQL =

            "   SELECT SERVICE AS SERVICE_ID, SUB_SERVICE AS SUB_SERVICE_ID,                                        " +
            "          INWARD_OUTWARD_IND AS DIRECTION, ACTIVE_INDICATOR AS IS_ACTIVE                               " +
            "     FROM CSF_DELIVERY_SERVICES                                                                        " +
            "    WHERE SUB_SERVICE = :subServiceID                                                                  " +
            "      AND INWARD_OUTWARD_IND = :direction                                                              ";

    public Boolean isActive( String subServiceID, String direction) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("subServiceID", subServiceID);
        params.put("direction", direction);

        // execute
        DeliveryServiceEntity service
                = uniqueResult(DELIVERY_SERVICE_SQL, params, DeliveryServiceEntity.class);

        return service.isActive();
    }
}

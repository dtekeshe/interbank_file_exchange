package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.loader.ServiceTypeEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class ServiceTypesDAO extends AbstractDao<ServiceTypeEntity, Void> {

    private final static String SERVICE_TYPES_SQL =
            "SELECT FILENAME_PREFIX, SERVICE, SUB_SERVICE, FILE_INDEXER_NAME, FILE_LOADER_NAME, " +
            "       FILE_BILLING_CALCULATOR_NAME, TXN_RECORD_PARSER_NAME " +
            "  FROM CSF_DELIVERY_SERVICES " +
            " WHERE INWARD_OUTWARD_IND = 'I' " +
            "   AND ACTIVE_INDICATOR = 'Y' ";

    public Map<String, ServiceTypeEntity> serviceTypes() {

        // execute
        List<ServiceTypeEntity> entities
                = list(SERVICE_TYPES_SQL, ServiceTypeEntity.class);

        // prepare result
        Map<String, ServiceTypeEntity> serviceTypes = new HashMap<>();
        for (ServiceTypeEntity serviceTypeEntity : entities) {
            serviceTypes.put(serviceTypeEntity.getFilenamePrefix(), serviceTypeEntity);
        }

        return serviceTypes;
    }
}

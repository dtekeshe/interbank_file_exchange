package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.loader.FilenamePrefixEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class DeliveryServiceDAO extends AbstractDao<FilenamePrefixEntity, Void> {

    private final static String FILENAME_PREFIX_SQL =
            " SELECT SUB_SERVICE, FILENAME_PREFIX " +
            "  FROM  CSF_DELIVERY_SERVICES " +
            " WHERE INWARD_OUTWARD_IND = 'O'";

    public Map<String, String> filenamePrefixes() {

        // execute
        List<FilenamePrefixEntity> entities
                = list(FILENAME_PREFIX_SQL, FilenamePrefixEntity.class);

        // prepare result
        Map<String, String> prefixes = new HashMap<>();
        for ( FilenamePrefixEntity entity : entities ) {
            prefixes.put(entity.getSubService(), entity.getFilenamePrefix());
        }

        return prefixes;
    }
}

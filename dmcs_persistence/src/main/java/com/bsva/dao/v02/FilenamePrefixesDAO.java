package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.loader.FilenamePrefixEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class FilenamePrefixesDAO extends AbstractDao<FilenamePrefixEntity, Void> {

    private final static String OUT_FILENAME_PREFIX_SQL =
            " SELECT SUB_SERVICE, FILENAME_PREFIX " +
            "  FROM  CSF_DELIVERY_SERVICES " +
            " WHERE INWARD_OUTWARD_IND = 'O'";

    private final static String IN_FILENAME_PREFIX_SQL =
            " SELECT SUB_SERVICE, FILENAME_PREFIX " +
                    "  FROM  CSF_DELIVERY_SERVICES " +
                    " WHERE INWARD_OUTWARD_IND = 'I'";

    public Map<String, String> outFilenamePrefixes() {

        // execute
        List<FilenamePrefixEntity> entities
                = list(OUT_FILENAME_PREFIX_SQL, FilenamePrefixEntity.class);

        // prepare result
        Map<String, String> prefixes = new HashMap<>();
        for ( FilenamePrefixEntity entity : entities ) {
            prefixes.put(entity.getSubService(), entity.getFilenamePrefix());
        }

        return prefixes;
    }

    public Map<String, String> inFilenamePrefixes() {

        // execute
        List<FilenamePrefixEntity> entities
                = list(IN_FILENAME_PREFIX_SQL, FilenamePrefixEntity.class);

        // prepare result
        Map<String, String> prefixes = new HashMap<>();
        for ( FilenamePrefixEntity entity : entities ) {
            prefixes.put(entity.getSubService(), entity.getFilenamePrefix());
        }

        return prefixes;
    }
}

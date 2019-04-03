package com.bsva.dao.v02.fileloader;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.loader.FilenamePrefixEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class FilenamePrefixesDAO extends AbstractDao<FilenamePrefixEntity, Void> {

    private final static String FILENAME_PREFFIX_SQL =

            "       SELECT SUB_SERVICE, FILENAME_PREFIX                                                             " +
            "         FROM CSF_DELIVERY_SERVICES                                                                    " +
            "        WHERE ACTIVE_INDICATOR = 'Y'                                                                   " +
            "          AND INWARD_OUTWARD_IND = :direction                                                          ";

    public Map<String, String> filenamePrefixes(String direction) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("direction",direction);

        // execute
        List<FilenamePrefixEntity> entities
                = list(FILENAME_PREFFIX_SQL, params, FilenamePrefixEntity.class);

        // prepare result
        Map<String, String> prefixes = new HashMap<>();
        for (FilenamePrefixEntity entity : entities) {
            prefixes.put(entity.getSubService(), entity.getFilenamePrefix());
        }

        return prefixes;
    }
}

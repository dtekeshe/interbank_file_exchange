package com.bsva.dao.v02.startofday;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.startofday.DefaultOutputFileCountEntity;
import com.bsva.entities.v02.startofday.SubServiceKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class DefaultOutputFileCountDAO extends AbstractDao<DefaultOutputFileCountEntity, Void> {

    private final static String DEFAULT_OUTPUT_FILES_SQL =
            "   SELECT SERVICE AS SERVICE_ID, SUB_SERVICE AS SUB_SERVICE_ID, DEFAULT_COUNT                          " +
            "     FROM CSO_OUTPUT_FILE_DEFAULT_CNT_V2                                                               ";

    /**
     * TODO Document
     *
     * @return
     */
    public Map<SubServiceKey, Integer> defaultFileCountForSubService() {

        // execute
        List<DefaultOutputFileCountEntity> entities
                = list(DEFAULT_OUTPUT_FILES_SQL, DefaultOutputFileCountEntity.class);

        // prepare result
        Map<SubServiceKey, Integer> fileCount = new HashMap<>();
        for (DefaultOutputFileCountEntity entity : entities) {
            fileCount.put(entity.getId(), entity.getDefaultCount());
        }

        return fileCount;
    }
}

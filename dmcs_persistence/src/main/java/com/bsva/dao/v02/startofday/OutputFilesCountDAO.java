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
public class OutputFilesCountDAO extends AbstractDao<DefaultOutputFileCountEntity, Void> {

    private final static String OUTPUT_FILE_COUNT_SQL =
            "   SELECT SERVICE AS SERVICE_ID, SUB_SERVICE AS SUB_SERVICE_ID, COUNT(*) AS DEFAULT_COUNT              " +
            "     FROM CSO_OUTPUT_CONTROLS                                                                      " +
            " GROUP BY SERVICE, SUB_SERVICE                                                                          ";

    /**
     * TODO Document
     * 
     * @return
     */
    public Map<SubServiceKey, Integer> fileCountForSubService() {

        // execute
        List<DefaultOutputFileCountEntity> entities
                = list(OUTPUT_FILE_COUNT_SQL, DefaultOutputFileCountEntity.class);

        // prepare result
        Map<SubServiceKey, Integer> fileCount = new HashMap<>();
        for (DefaultOutputFileCountEntity entity : entities) {
            fileCount.put(entity.getId(), entity.getDefaultCount());
        }

        return fileCount;
    }
}

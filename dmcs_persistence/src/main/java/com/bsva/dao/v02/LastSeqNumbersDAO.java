package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.loader.LastSeqNumberEntity;
import com.bsva.entities.v02.loader.LastSeqNumberKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class LastSeqNumbersDAO extends AbstractDao<LastSeqNumberEntity, Void>{

    private final static String LAST_SEQ_NUMBERS_SQL =
            "   SELECT EXTERNAL_FILENAME_PREFIX, DISTRIBUTION_CODE, LAST_SEQ_NUMBER_USED " +
            "     FROM CSO_SEQ_NUMBERS ";

    private final static String LAST_SEQ_NUMBERS_UPDATE_SQL =
            "     UPDATE CSO_SEQ_NUMBERS " +
                    "        SET LAST_SEQ_NUMBER_USED = :lastSeqNumber " +
                    "     WHERE EXTERNAL_FILENAME_PREFIX = :externalFilenamePrefix " +
                    "       AND DISTRIBUTION_CODE = :distributionCode ";

    // read
    public Map<LastSeqNumberKey, Long> lastSeqNumbers() {

        // execute
        List<LastSeqNumberEntity> entities
                = list(LAST_SEQ_NUMBERS_SQL, LastSeqNumberEntity.class);

        // prepare result
        Map<LastSeqNumberKey, Long> lastSeqNumbers = new HashMap<>();

        for (LastSeqNumberEntity entity : entities) {
            lastSeqNumbers.put(entity.getId(), entity.getLastSeqNumber());
        }

        return lastSeqNumbers;
    }


    public void updateLastSeqNumbers(Map<LastSeqNumberKey, Long> lastSeqNumbers) {

        // update if exists
        for (LastSeqNumberKey key : lastSeqNumbers.keySet()) {

            Map<String, Object> params = new HashMap<>();
            params.put("lastSeqNumber", lastSeqNumbers.get(key));
            params.put("externalFilenamePrefix", key.getExternalFilenamePrefix());
            params.put("distributionCode", key.getDistributionCode());

            executeUpdate(LAST_SEQ_NUMBERS_UPDATE_SQL, params);
        }
    }
}

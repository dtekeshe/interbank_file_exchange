package com.bsva.dao.v02.startofday;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.loader.LastSeqNumberKey;
import com.bsva.entities.v02.startofday.SeqNumberEntity;
import com.bsva.entities.v02.startofday.SeqNumberKey;

import java.util.*;

/**
 * TODO Document
 */
public class SeqNumbersDAO extends AbstractDao<Void, Void> {
	
	private final static String LAST_SEQ_NUMBERS_SQL =
            "   SELECT EXTERNAL_FILENAME_PREFIX, DISTRIBUTION_CODE, LAST_SEQ_NUMBER_USED " +
            "     FROM CSO_SEQ_NUMBERS ";

    private final static String SEQ_NUMBER_SQL =
            "   INSERT INTO CSO_SEQ_NUMBERS ( " +
                    " DISTRIBUTION_CODE, LAST_SEQ_NUMBER_USED, EXTERNAL_FILENAME_PREFIX)    " +
            "   VALUES ( :distributionCode, :lastSeqNumber,:filenamePrefix )";
    
    private final static String LAST_SEQ_NUMBERS_UPDATE_SQL =
            "     UPDATE CSO_SEQ_NUMBERS " +
                    "        SET LAST_SEQ_NUMBER_USED = :lastSeqNumber " +
                    "     WHERE EXTERNAL_FILENAME_PREFIX = :externalFilenamePrefix " +
                    "       AND DISTRIBUTION_CODE = :distributionCode ";
    
    // read
    /*public Map<SeqNumberKey, Long> lastSeqNumbers() {

        // execute
        List<SeqNumberEntity> entities
                = list(LAST_SEQ_NUMBERS_SQL, SeqNumberEntity.class);

        // prepare result
        Map<SeqNumberKey, SeqNumberEntity> lastSeqNumbers = new HashMap<>();

        for (SeqNumberEntity entity : entities) {
        	SeqNumberKey seqNumberKey = new SeqNumberKey(entity.getId().getDestDistCode(),entity.getId().getFilenamePrefix());
            lastSeqNumbers.put(seqNumberKey,entity);
        }

        return lastSeqNumbers;
    }*/

    //Used to insert a new record to the Cso_SeqNumber Table
    public void insert(Collection<SeqNumberEntity> seqNumbers) {

        // prepare params
        List<Map<String, Object>> payload = new ArrayList<>();
        for (SeqNumberEntity seqNumber : seqNumbers) {
            Map<String, Object> params = new HashMap<>();
            params.put("filenamePrefix", (seqNumber.getId().getFilenamePrefix()== null ? "CR" : seqNumber.getId().getFilenamePrefix()));
            params.put("distributionCode", seqNumber.getId().getDestDistCode());
            params.put("lastSeqNumber", seqNumber.getSeqNumber());
            payload.add(params);
        }

        // execute
        executeUpdate(SEQ_NUMBER_SQL, payload);
    }

    //Used to update lastSeqNumber Used in the Cso_seqNumber.
    public void updateLastSeqNumbers(Integer lastSeqNumber,String externalFileNamePrefix,String distributionCode) {

            // update if exists
            Map<String, Object> params = new HashMap<>();
            params.put("lastSeqNumber", lastSeqNumber);
            params.put("externalFilenamePrefix", externalFileNamePrefix);
            params.put("distributionCode",distributionCode);

         int num =   executeUpdate(LAST_SEQ_NUMBERS_UPDATE_SQL, params);
        
    }
}

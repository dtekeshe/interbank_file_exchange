package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.loader.SequenceEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO Document
 */
public class SequenceReaderDAO extends AbstractDao<SequenceEntity, Void> {

    private final static String READ_SEQUENCES_SQL =
            " SELECT DMCS_SEQ_NAME, DMCS_SEQ_VALUE " +
            "   FROM DMCS_SEQ_STORE ";

    // read
    public Map<String, AtomicLong> sequences() {

        // execute
        List<SequenceEntity> entities
                = list(READ_SEQUENCES_SQL, SequenceEntity.class);

        // prepare result
        Map<String, AtomicLong> sequences = new HashMap<>();
        for (SequenceEntity sequenceEntity : entities) {
            sequences.put(sequenceEntity.getName(), new AtomicLong(sequenceEntity.getValue()));
        }

        return sequences;
    }
}

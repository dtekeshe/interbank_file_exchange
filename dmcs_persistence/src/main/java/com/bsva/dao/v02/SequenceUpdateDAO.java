package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO Document
 */
public class SequenceUpdateDAO extends AbstractDao<Void, Void> {

    private final String UPDATE_SEQUENCES_SQL =
            " UPDATE DMCS_SEQ_STORE " +
            "    SET DMCS_SEQ_VALUE = :value " +
            "  WHERE DMCS_SEQ_NAME  = :key ";

    // bulk update
    public List<Integer> update( Map<String, AtomicLong> sequences ) {

        // build payload
        List<Map<String, Object>> payload = new ArrayList<>();

        for (String key : sequences.keySet()) {
            AtomicLong value = sequences.get(key);
            Map<String, Object> params = new HashMap<>();
            params.put("key", key);
            params.put("value", value.longValue());

            payload.add(params);
        }

        // execute
        List<Integer> result = executeUpdate(UPDATE_SEQUENCES_SQL, payload);

        return result;
    }

    // update single
    public List<Integer> update( String keyName, Long keyValue ) {

        // prepare params
        Map<String, AtomicLong> sequences = new HashMap<>();
        sequences.put(keyName, new AtomicLong(keyValue));

        // execute
        List<Integer> result = update(sequences);

        return result;
    }
}

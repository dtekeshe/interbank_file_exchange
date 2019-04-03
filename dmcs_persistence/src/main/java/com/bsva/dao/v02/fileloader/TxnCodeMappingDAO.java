package com.bsva.dao.v02.fileloader;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.loader.TxnCodeMappingEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class TxnCodeMappingDAO extends AbstractDao<TxnCodeMappingEntity, Void> {

    private final static String TXN_CODE_MAPPING_SQL =
            "   SELECT TXN_CODE, STANDARD_TXN_CODE                                                                  " +
            "     FROM CSO_TXN_CODE_MAPPING                                                                         ";

    public Map<String, Integer> txnCodeMap() {

        // execute
        List<TxnCodeMappingEntity> entities
                = list(TXN_CODE_MAPPING_SQL, TxnCodeMappingEntity.class);

        // prepare result
        Map<String, Integer> txnCodeMap = new HashMap<>();
        for (TxnCodeMappingEntity entity : entities) {
            txnCodeMap.put(entity.getTxnCode(), entity.getStandardTxnCode());
        }

        return txnCodeMap;
    }
}

package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.commons.TxnGroupCodeEntity;

import java.util.*;

/**
 * TODO Document
 */
public class TxnGroupCodesDAO extends AbstractDao<TxnGroupCodeEntity, Void> {

    private final static String TXN_GROUP_CODES_SQL =
            " SELECT TRANSACTION_CODE, TRANSACTION_GROUP_CODE    " +
            "   FROM CSF_TRANSACTION_GROUPS    " +
             "  GROUP BY TRANSACTION_CODE , TRANSACTION_GROUP_CODE " +
            "  ORDER BY TRANSACTION_CODE ";

    public Map<Integer, Integer> txnCodeGroupMap() {

        // execute
        List<TxnGroupCodeEntity> entities
                = list(TXN_GROUP_CODES_SQL, TxnGroupCodeEntity.class);

        // prepare result
        Map<Integer, Integer> txnGroupCodes = new HashMap<>();
        for (TxnGroupCodeEntity entity : entities) {
            txnGroupCodes.put(entity.getTxnCode(), entity.getTxnGroupCode());
        }

        return txnGroupCodes;
    }

    public Set<Integer> txnGroupCodes() {
        Map<Integer, Integer> map = txnCodeGroupMap();

        Set<Integer> txnGroupCodes = new TreeSet<>();
        for (Integer txnCode : map.keySet()) {
            txnGroupCodes.add(map.get(txnCode));
        }

        return txnGroupCodes;
    }
}

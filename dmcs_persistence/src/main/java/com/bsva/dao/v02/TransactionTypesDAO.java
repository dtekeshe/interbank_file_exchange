package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.commons.TxnTypeEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class TransactionTypesDAO extends AbstractDao<TxnTypeEntity, Void> {

    private final static String TXN_TYPES_SQL =
                        " SELECT TRANSACTION_CODE, AMOUNT_DIRECTION, FEE_DIRECTION, VAT_DIRECTION                   " +
                        "   FROM CSF_TRANSACTION_TYPES                                                              " +
                        "  WHERE TRANSACTION_CODE <> 99                                                             ";

    public Integer[] txnTypes() {

        // execute
        List<TxnTypeEntity> entities
                = list(TXN_TYPES_SQL, TxnTypeEntity.class);

        // prepare result
        Integer[] txnTypes = new Integer[entities.size()];
        int idx = 0;
        for (TxnTypeEntity entity : entities) {
            txnTypes[idx++] = entity.getTxnCode();
        }

        return txnTypes;
    }

    public Map<Integer, TxnTypeEntity> txnTypeEntities() {

        // execute
        List<TxnTypeEntity> entities
                = list(TXN_TYPES_SQL, TxnTypeEntity.class);

        // prepare result
        Map<Integer, TxnTypeEntity> txnTypes = new HashMap<>();
        for (TxnTypeEntity entity : entities) {
            txnTypes.put(entity.getTxnCode(), entity);
        }

        return txnTypes;
    }
}

package com.bsva.dmcs.reportv02.util;

import com.bsva.dmcs.dto.TxnGroupTotals;
import com.bsva.dto.TxnGroup;
import com.bsva.entities.v02.settlement.CCR00XDataEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * TODO Document
 */
public class MathUtils {

    public Map<TxnGroup, TxnGroupTotals> ccr00xTxnGroupTotals( Map<TxnGroup,
                                                                   List<CCR00XDataEntity>> txnGroupData) {

        Map<TxnGroup, TxnGroupTotals> totals = new HashMap<>();

        Set<TxnGroup> txnGroupCodes = txnGroupData.keySet();
        for (TxnGroup txnGroupCode : txnGroupCodes) {
            List<CCR00XDataEntity> txns = txnGroupData.get(txnGroupCode);
            for (CCR00XDataEntity txn : txns) {

            }
        }

        return totals;
    }
}

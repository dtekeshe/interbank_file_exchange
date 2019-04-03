package com.bsva.dmcs.fileloadv02.util;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO document
 */
public class TransactionCodeUtils {

    private static final Integer BASE_10 = 10;

    private static final Map<Integer, Integer> TXN_CODES_WITH_CASHBACK_AND_PURCHASE;
    private static final Map<Integer, Integer> TXN_CODES_WITH_CASHBACK_ONLY;
    private static final Map<Integer, Integer> TXN_CODES_BILATERAL;

    static {

        // 1  -  9, CASHBACK NO PURCHASE
        // 10 - 19, CASHBACK WITH PURCHASE
        // 20 - 29, REVERSAL WITH PURCHASE

        TXN_CODES_WITH_CASHBACK_AND_PURCHASE = new HashMap<>();
        TXN_CODES_WITH_CASHBACK_AND_PURCHASE.put(1,   3);
        TXN_CODES_WITH_CASHBACK_AND_PURCHASE.put(10, 13);
        TXN_CODES_WITH_CASHBACK_AND_PURCHASE.put(20, 23);

        TXN_CODES_WITH_CASHBACK_ONLY = new HashMap<>();
        TXN_CODES_WITH_CASHBACK_ONLY.put(1,   2);
        TXN_CODES_WITH_CASHBACK_ONLY.put(10, 12);
        TXN_CODES_WITH_CASHBACK_ONLY.put(20, 22);

        TXN_CODES_BILATERAL = new HashMap<>();
        TXN_CODES_BILATERAL.put(1,   8);
        TXN_CODES_BILATERAL.put(10, 18);
        TXN_CODES_BILATERAL.put(20, 28);
    }

    /**
     * Transaction code for looking up CSF_CARD_TRANSACTION_TYPES
     *
     * @param transactionCode - un-normalized transaction code
     * @param withCashback
     * @param pureCashBack
     * @return normalized transaction code
     */
    public static Integer cardTransactionType( Integer transactionCode,
                                                    boolean withCashback,
                                                    boolean pureCashBack ) {

        Integer floor = MathUtils.floor(transactionCode, BASE_10);
        if (withCashback) {
            return pureCashBack ?
                        TXN_CODES_WITH_CASHBACK_ONLY.get(floor) :
                            TXN_CODES_WITH_CASHBACK_AND_PURCHASE.get(floor);
        } else {
            return transactionCode;
        }
    }


    public static Integer bilateralTransactionCode(Integer transactionCode) {
        Integer floor = MathUtils.floor(transactionCode, BASE_10);
        return TXN_CODES_BILATERAL.get( floor );
    }

    public static Boolean isNegativeRecord(Integer txnCode) {
        return txnCode == 41;
    }
}

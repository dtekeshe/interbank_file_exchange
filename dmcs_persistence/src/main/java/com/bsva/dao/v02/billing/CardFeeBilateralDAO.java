package com.bsva.dao.v02.billing;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.billing.BilateralBillingKey;
import com.bsva.entities.v02.billing.CardFeeBilateralRateEntity;

import java.util.*;

/**
 * TODO document
 */
public class CardFeeBilateralDAO extends AbstractDao<CardFeeBilateralRateEntity, Void> {

    private static final String CARD_FEE_BILATERAL_SQL =
            " SELECT ISSUING_MEMBER, ACQUIRING_MEMBER, TRANSACTION_CODE, CARD_TYPE, " +
            "        INTERCHANGE_FEE, INTERCHANGE_FEE_AMOUNT, INPUT_VAT , AMOUNT_DIRECTION " +
            "   FROM CSF_CARD_FEE_BILATERAL ";
           // "  WHERE TRANSACTION_CODE IN ( :applicableTransactionCodes ) ";

    public Map<BilateralBillingKey, CardFeeBilateralRateEntity> applicableBilateralRatesMap(
                    List<Integer> applicableBilateralCodes) {

        // prepare params
        String csv = commandSeperatedValues(applicableBilateralCodes);
        Map<String, Object> params = new HashMap<>();
       // params.put("applicableTransactionCodes", csv);

        // execute
        List<CardFeeBilateralRateEntity> entities
                = super.list(CARD_FEE_BILATERAL_SQL, params, CardFeeBilateralRateEntity.class);

        // prepare result
        Map<BilateralBillingKey, CardFeeBilateralRateEntity> result = new HashMap<>();
        for (CardFeeBilateralRateEntity entity : entities) {
            BilateralBillingKey key = entity.getBilateralBillingKey();
            if ( ! applicableBilateralCodes.contains(key.getTransactionCode())) {
                continue;
            }
            result.put(key, entity);
        }

        return result;
    }

    private static String commandSeperatedValues(List<Integer> list) {
        StringBuffer buffer = new StringBuffer("");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            buffer.append(iterator.next());
            if (iterator.hasNext()) {
                buffer.append(",");
            }
        }
        return buffer.toString();
    }
}

package com.bsva.dao.v02.billing;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.billing.CardFeeSARBBillingEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class CardFeeSARBBillingDAO extends AbstractDao<CardFeeSARBBillingEntity, Void> {
    
    private final static String CARD_FEE_SARB_BILLING_SQL =
            "       SELECT RATE_DESCRIPTOR, DEBIT_RATE, DEBIT_PERCENT, CREDIT_RATE, CREDIT_PERCENT,                 " +
            "               OLD_DEBIT_RATE, OLD_DEBIT_PERCENT, OLD_CREDIT_RATE, OLD_CREDIT_PERCENT,                 " +
            "               CHANGE_OVER_DATE                                                                        " +
            "         FROM CSF_CARD_FEE_SARB_BILLING                                                                ";

    public Map<String, CardFeeSARBBillingEntity> cardFeeSARBBillingRates() {

        List<CardFeeSARBBillingEntity> entities
                = list(CARD_FEE_SARB_BILLING_SQL, CardFeeSARBBillingEntity.class);

        // prepare result
        Map<String, CardFeeSARBBillingEntity> rates = new HashMap<>();
        for (CardFeeSARBBillingEntity entity : entities ) {
            rates.put(entity.getRateDescriptor(), entity);
        }

        return rates;
    }
}

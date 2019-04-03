package com.bsva.dao.v02.billing;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.billing.BilateralBillingKey;
import com.bsva.entities.v02.billing.CardFeeBilateralRateEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class BilateralRatesDAO extends AbstractDao<CardFeeBilateralRateEntity, Void> {

    private static final String BILTERAL_RATES_SQL =
            "SELECT ISSUING_MEMBER, ACQUIRING_MEMBER, TRANSACTION_CODE, CARD_TYPE, " +
            "       INTERCHANGE_FEE, INTERCHANGE_FEE_AMOUNT, INPUT_VAT ,AMOUNT_DIRECTION " +
            "  FROM CSF_CARD_FEE_BILATERAL ";

    public Map<BilateralBillingKey, CardFeeBilateralRateEntity> billingRates() {

        // execute
        List<CardFeeBilateralRateEntity> entities
                = list(BILTERAL_RATES_SQL, CardFeeBilateralRateEntity.class);

        // prepare result
        Map<BilateralBillingKey, CardFeeBilateralRateEntity> rates = new HashMap<>();
        for (CardFeeBilateralRateEntity entity : entities) {
            rates.put(entity.getBilateralBillingKey(), entity);
        }

        return rates;
    }
}

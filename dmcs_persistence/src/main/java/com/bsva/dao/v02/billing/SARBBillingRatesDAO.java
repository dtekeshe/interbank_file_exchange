package com.bsva.dao.v02.billing;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.billing.BillingRate;
import com.bsva.entities.v02.billing.BillingRateID;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class SARBBillingRatesDAO extends AbstractDao<BillingRate, Void> {

    private final static String SARB_BILLING_RATES_SQL
            = " SELECT RATE_DESCRIPTOR, CARD_TYPE, BILLING_RATE, BILLING_PERCENT " +
              " FROM CSV_SARB_BILLING_VIEW ";

    public Map<BillingRateID, BillingRate> billingRates() {

        // execute
        List<BillingRate> entities
                = list(SARB_BILLING_RATES_SQL, BillingRate.class);

        // prepare result
        Map<BillingRateID, BillingRate> rates = new HashMap<>();
        for (BillingRate entity : entities) {
            rates.put(entity.getId(), entity);
        }

        return rates;
    }
    
}

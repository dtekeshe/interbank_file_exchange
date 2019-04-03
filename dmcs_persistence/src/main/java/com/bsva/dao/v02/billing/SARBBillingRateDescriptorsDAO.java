package com.bsva.dao.v02.billing;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.billing.BillingRateDescriptor;
import com.bsva.entities.v02.billing.BillingKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class SARBBillingRateDescriptorsDAO extends AbstractDao<BillingRateDescriptor, Void> {

    private final static String BILLING_RATES_SQL
            = " SELECT POS_ENTRY_MODE, CHIP_CARD, TERMINAL_CAPABILITY, E_COMM_IND, CARD_PRESENT,  RATE_DESCRIPTOR " +
              "   FROM CSF_CARD_RATE_LOOKUP " +
              " WHERE SERVICE = :serviceID " +
              "   AND SUB_SERVICE = :subServiceID ";

    public Map<BillingKey, String> billingRateDescriptors(String serviceID, String subServiceID) {

        // params
        Map<String, Object> params = new HashMap<>();
        params.put("serviceID", serviceID);
        params.put("subServiceID", subServiceID);

        // execute
        List<BillingRateDescriptor> entities
                = list(BILLING_RATES_SQL, params, BillingRateDescriptor.class);

        // prepare result
        Map<BillingKey, String> rates = new HashMap<>();
        for (BillingRateDescriptor entity : entities) {
            rates.put(entity.getId(), entity.getRateDescriptor());
        }

        return rates;
    }
}

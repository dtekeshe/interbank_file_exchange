package com.bsva.dao.v02.settlement;

import java.util.List;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.settlement.CsrRateEntity;

/**
 * @author AugustineA
 *
 */
public class CSRRATE_DAO extends AbstractDao<CsrRateEntity,Void>{
	
	//This is for only Visa and Mastercard Files Reports(Sarb Billing)
    private final static String CARD_RATES_VIEW_SQL = 
            " SELECT * FROM  CSV_PAYMENT_RATES_VIEW ";
    // this is used to generate cardRate Reports.
    public List<CsrRateEntity> cardRateView() {

        // execute and return Data
        List<CsrRateEntity> cardTypes
                = list(CARD_RATES_VIEW_SQL, CsrRateEntity.class);
        //return Data to the method that calls it.
        return cardTypes;
    }
}

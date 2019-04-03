package com.bsva.dmcs.fileloadv02.billing;

import com.bsva.dao.v02.TransactionTypesDAO;
import com.bsva.dao.v02.billing.BilateralRatesDAO;
import com.bsva.dao.v02.billing.FleetBillingResolvedDAO;
import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
import com.bsva.dmcs.fileloadv02.dto.Service;
import com.bsva.dmcs.fileloadv02.dto.SubService;
import com.bsva.dmcs.fileloadv02.model.BillingData;
import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.entities.v02.billing.BilateralBillingKey;
import com.bsva.entities.v02.billing.CardFeeBilateralRateEntity;
import com.bsva.entities.v02.billing.FleetBillingEntity;
import com.bsva.entities.v02.commons.TxnTypeEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class FleetBilateralBillingCalculator extends BillingCalculator {


    private final static Map<BilateralBillingKey, CardFeeBilateralRateEntity> CARD_FEE_BILTERAL_DATA_MAP;

    static {
        CARD_FEE_BILTERAL_DATA_MAP = new BilateralRatesDAO().billingRates();
    }

    private static final BigDecimal BIG_DECIMAL_100 = new BigDecimal(100);

    private final BigDecimal vatRate;
    private final Map<Integer, TxnTypeEntity> txnTypes;

    public FleetBilateralBillingCalculator(
                                        Service service,
                                        SubService subService,
                                        BigDecimal vatRate) {
        this.vatRate = vatRate;
        txnTypes = new TransactionTypesDAO().txnTypeEntities();
    }

    public List<Map<String, Object>> fleetBill(List<FleetBillingEntity> txns) {



        // SQL update payload
        List<Map<String, Object>> payload = new ArrayList<>();

        for (FleetBillingEntity record : txns ) {

            BilateralBillingKey billingKey
                    = new BilateralBillingKey(
                            record.getId().getIssuerCode(),
                            record.getId().getAcquirerCode(),
                            record.getId().getTxnCode(),
                            record.getId().getCardType() );

            // billing rate
            CardFeeBilateralRateEntity rate = CARD_FEE_BILTERAL_DATA_MAP.get(billingKey);
            Long txnAmount = record.getTxnAmount().longValue();

            // txn type details
            TxnTypeEntity txnType = txnTypes.get(record.getId().getTxnCode());
            Integer percentageFeeDirection = txnType.getFeeDirection();
            Integer flatFeeDirection = txnType.getAmountDirection();
            Integer vatDirection = txnType.getVatDirection();

            // calculations
            long percentageFee = billateralPercentageFee(txnAmount, rate.getPercentage(), rate.getAmountDirection());
            long flatFee = fleetFlatFee(txnAmount, rate.getRate(), rate.getAmountDirection());
            double flatFees = (flatFee);
            
            BigDecimal flatBd = new BigDecimal(flatFees).setScale(2,RoundingMode.HALF_UP);
            Map<String, Object> params = new HashMap<>();
            params.put("systemSeqNumber", record.getId().getSystemSeqNumber());
            params.put("billingFee", percentageFee);
            params.put("billingFeeAmount", (flatBd.divide(BIG_DECIMAL_100).setScale(2,RoundingMode.HALF_UP).doubleValue()));
            params.put("billingVat", billateralVat( percentageFee + flatBd.setScale(2,RoundingMode.HALF_UP).doubleValue(), rate.getVat(), rate.getAmountDirection()));
            params.put("rateDescriptor", "BILATERAL");
            params.put("fleetCountTran", "Y");

            payload.add(params);
        }

        return payload;
    }


    public void bill(List<FileDetailDTO> payment) {
    }
}

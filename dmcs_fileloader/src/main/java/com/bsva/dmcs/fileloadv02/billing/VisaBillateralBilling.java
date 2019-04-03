package com.bsva.dmcs.fileloadv02.billing;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.bsva.dao.v02.TransactionTypesDAO;
import com.bsva.dao.v02.billing.BilateralRatesDAO;
import com.bsva.dmcs.fileloadv02.dto.Service;
import com.bsva.dmcs.fileloadv02.dto.SubService;
import com.bsva.dmcs.fileloadv02.model.BillingData;
import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.entities.v02.billing.BilateralBillingKey;
import com.bsva.entities.v02.billing.CardFeeBilateralRateEntity;
import com.bsva.entities.v02.commons.TxnTypeEntity;

public class VisaBillateralBilling extends BillingCalculator {

	private final static Map<BilateralBillingKey, CardFeeBilateralRateEntity> CARD_FEE_BILTERAL_DATA_MAP;

    static {
        CARD_FEE_BILTERAL_DATA_MAP = new BilateralRatesDAO().billingRates();
    }

    private static final BigDecimal BIG_DECIMAL_100 = new BigDecimal(100);

    private final BigDecimal vatRate;
    private final Map<Integer, TxnTypeEntity> txnTypes;

    @SuppressWarnings("unused")
    public VisaBillateralBilling( Service service,
                                       SubService subService,
                                       BigDecimal vatRate) {
        this.vatRate = vatRate;
        txnTypes = new TransactionTypesDAO().txnTypeEntities();
    }

    /*
    private static Map<BilateralBillingKey, CardFeeBilateralRateEntity> init() {

        Map<BilateralBillingKey, CardFeeBilateralRateEntity> map = new HashMap<>();

        // TODO populate
        try {
            List<CsfCardFeeBilateralDTO> bilaterals = new CsfCardFeeBilateralDAO().retrieveRelated(null);
            for (CsfCardFeeBilateralDTO bilateral : bilaterals) {
                CardFeeBilateralRateEntity entity = new CardFeeBilateralRateEntity();

                BilateralBillingKey key = new BilateralBillingKey();
                key.setAcquirerBankCode(bilateral.getAcquiringMember());
                key.setIssuerBankCode(bilateral.getIssuingMember());
                key.setCardType(bilateral.getCardType());
                key.setTransactionCode(bilateral.getTransactionCode());

                entity.setBilateralBillingKey(key);
                entity.setPercentage(new BigDecimal("" + bilateral.getInterchangeFee()));
                entity.setRate(new BigDecimal("" + bilateral.getInterchangeFeeAmount()));
                entity.setVat(new BigDecimal("" + bilateral.getInputVat()));

                map.put(key, entity);
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }

        return map;
    }
    */

    @Override
    public void bill(List<FileDetailDTO> payLines) {

        FileDetailDTO payment = payLines.get(0);
        if (!"C".equals(payment.getStatus())) {
            return;
        }

        boolean hasCashBack = payLines.get(1).hasCashBack();
        Long amount = payment.getAmount();

        Long cashBackAmount= payLines.size() > 1 ?  payLines.get(1).getCashbackAmount() : 0L;

        // is pure cash back ?
        boolean pureCashBack = hasCashBack && isPureCashBack( amount, cashBackAmount );

        // calculate purchase portion
        Long purchasePortion = pureCashBack ? 0L : purchasePortion( amount, cashBackAmount );

        // normalise transaction to card transaction type
        Integer txnCode = payment.getBillingTxnCode() != null ? payment.getBillingTxnCode() : payment.getTxnCode();
        //Integer cardTransactionType = cardTransactionType( txnCode, hasCashBack, pureCashBack );

        // bilateral transaction code
        //Integer bilateralTransactionCode = TransactionCodeUtils.bilateralTransactionCode(cardTransactionType);

        BilateralBillingKey billingKey = new BilateralBillingKey(payment.getIssuerCode(), payment.getAcquirerCode(), txnCode, payment.getCardType() ); // TODO Check with Rinus

        // billing rate
        CardFeeBilateralRateEntity rate = CARD_FEE_BILTERAL_DATA_MAP.get(billingKey);

        TxnTypeEntity txnType = txnTypes.get(txnCode);

        Integer percentageFeeDirection = txnType.getFeeDirection();
        Integer flatFeeDirection = txnType.getAmountDirection();
        Integer vatDirection = txnType.getVatDirection();

        //There is no cash Back portion for cash Advanced
        //So for Cash Advanced use the Amount this was said by Rinus eckard on this day 22nd March 2018
        //So from this Day , the cash Advances with is the Amount.
        long percentageFee =  percentageFeeVisa(amount, rate.getPercentage(), percentageFeeDirection);
        long flatFee = flatFee(amount, rate.getRate(), flatFeeDirection);
        
        long cashPercent = flatFeePercent(amount, rate, flatFeeDirection,percentageFee,flatFee);

        BillingData billingData =
            new BillingData(
                    "BILATERAL",
                    // purchase portion
                    percentageFee, flatFee,
                     vat( percentageFee + flatFee, vatRate, vatDirection),

                    // cash back portion

                    // Bilateral billing is for AMEX, DINNERS and FLEET for now
                    // These card types doesn't support Cash back
                    // VISA and MCI supports cash back but they will use SARB for SA product
                    // DRC product will use Bilateral for VISA and MCI but we still need to
                    // confirm if they do cash back in that country.
                    // This functionality was not ported from the old code because
                    // the cash back calculation was missing
                    0L, 0L, 0.0 );

        payment.setBillingData( billingData );
    }


}

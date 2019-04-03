package com.bsva.dmcs.fileloadv02.billing;

import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.dmcs.fileloadv02.util.MathUtils;
import com.bsva.dmcs.fileloadv02.util.TransactionCodeUtils;
import com.bsva.entities.v02.billing.CardFeeBilateralRateEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
/*
 * 
1, On this Day 19th of March 2018
2, Zonia and Rinus confirmed that Vat will be Calculated and rounded off at transaction Lavel.
 * */
public abstract class BillingCalculator {

    private static final BigDecimal BIG_DECIMAL_100 = new BigDecimal(100);
    private static final BigDecimal BIG_DECIMAL_1000 = new BigDecimal(1000);
    
    public abstract void bill(List<FileDetailDTO> payment);

    /**
     * TODO Document
     *
     * @param transactionAmount
     * @param cashBackAmount
     * @return
     */
    protected boolean isPureCashBack( Long transactionAmount, Long cashBackAmount) {
        return MathUtils.isPureCashBack(transactionAmount, cashBackAmount);
    }

    /**
     * TODO Document
     *
     * @param transactionAmount
     * @param cashBackAmount
     * @return
     */
    protected Long purchasePortion(Long transactionAmount, Long cashBackAmount) {

        return MathUtils.purchasePortion(transactionAmount, cashBackAmount);
    }

    /**
     * TODO Document
     *
     * @param transactionCode
     * @param withCashBack
     * @param pureCashBack
     * @return
     */
    protected Integer cardTransactionType(Integer transactionCode, boolean withCashBack, boolean pureCashBack) {

        Integer cardTransactionType
                = TransactionCodeUtils.cardTransactionType(transactionCode, withCashBack, pureCashBack);

        return cardTransactionType;
    }

    public static Long flatFee(Long purchaseAmount, BigDecimal rate, Integer flatFeeDirection) {

        if ((purchaseAmount == 0L) || rate == null) {
            return 0L;
        }

        return rate.multiply(BIG_DECIMAL_100).longValue() * flatFeeDirection;
    }
    
    public static Long flatFeePercent(Long purchaseAmount, CardFeeBilateralRateEntity rate, Integer flatFeeDirection,Long percentageFees,Long flatFee) {

        if ((purchaseAmount == 0L) || rate == null) {
            return 0L;
        }
        BigDecimal decimalRate = new BigDecimal(flatFee.doubleValue()).divide(BIG_DECIMAL_100);
        BigDecimal percentageFee = new BigDecimal(percentageFees.doubleValue()).divide(BIG_DECIMAL_100);
        
        BigDecimal billingFee =
                (new BigDecimal(purchaseAmount).multiply( percentageFee.divide( BIG_DECIMAL_100 )));
                        //.divide(BIG_DECIMAL_100)
                        //.setScale(2,RoundingMode.HALF_UP);
        BigDecimal addValues = billingFee.add(decimalRate);
        
        Long vatAmount =  addValues.multiply(BIG_DECIMAL_100).longValue() * flatFeeDirection;
        Long totalVlue = vatAmount + addValues.longValue();
        
        return totalVlue;
    }
    
    public static Long fleetFlatFee(Long purchaseAmount, BigDecimal rate, Integer flatFeeDirection) {

        if ((purchaseAmount == 0L) || rate == null) {
            return 0L;
        }
        BigDecimal billingFee =
                (new BigDecimal(purchaseAmount).multiply( rate.divide( BIG_DECIMAL_100 ) ))
                        .divide(BIG_DECIMAL_100)
                        .setScale(2,RoundingMode.HALF_UP);

        return rate.multiply(BIG_DECIMAL_100).longValue() * flatFeeDirection;
    }

    public static Long percentageFee(Long amount, BigDecimal percentage, Integer percentageFeeDirection) {

        if (amount == 0 || percentage == null) {
            return 0L;
        }

        BigDecimal billingFee =
                (new BigDecimal(amount).multiply( percentage.divide( BIG_DECIMAL_100 ) ))
                        .divide(BIG_DECIMAL_100)
                        .setScale(2,RoundingMode.HALF_UP);

        return billingFee.multiply(BIG_DECIMAL_100).longValue() * percentageFeeDirection;
    }
    public static Long percentageFeeVisa(Long amount, BigDecimal percentage, Integer percentageFeeDirection) {

        if (amount == 0 || percentage == null) {
            return 0L;
        }

        BigDecimal billingFee =
                (new BigDecimal(amount).multiply( percentage.divide( BIG_DECIMAL_100 ) ))
                        .divide(BIG_DECIMAL_100)
                        .setScale(2,RoundingMode.HALF_UP);

        return billingFee.multiply(BIG_DECIMAL_100).longValue() * percentageFeeDirection;
    }
    public static Long billateralPercentageFee(Long amount, BigDecimal percentage, Integer percentageFeeDirection) {

        if (amount == 0 || percentage == null) {
            return 0L;
        }

        BigDecimal billingFee =
                (new BigDecimal(amount).multiply( percentage.divide( BIG_DECIMAL_100 ) ))
                        .divide(BIG_DECIMAL_100);

        return billingFee.multiply(BIG_DECIMAL_100).longValue() * percentageFeeDirection;
    }
  
    public static Double billateralVat(double fee, BigDecimal vatRate, Integer vatDirection) {

        if ( fee == 0.0) {
            return 0.0;
        }
        BigDecimal vat = (new BigDecimal(fee).multiply( vatRate.divide(BIG_DECIMAL_100)))
        		.divide(BIG_DECIMAL_100)
                .setScale(2,RoundingMode.HALF_UP);
        return  abs(vat.doubleValue()) * vatDirection;
    }
    

    public static Double vat(Long fee, BigDecimal vatRate, Integer vatDirection) {

        if ( fee == null) {
            return 0.0;
        }

        BigDecimal vat = (new BigDecimal(fee).multiply( vatRate.divide(BIG_DECIMAL_100)))
        		.divide(BIG_DECIMAL_100)
                .setScale(2,RoundingMode.HALF_UP);

        return  vat.doubleValue();// * vatDirection;
    }
    public static Double cashBackVat(Long fee, BigDecimal vatRate, Integer vatDirection) {

        if ( fee == null) {
            return 0.0;
        }

        BigDecimal vat = (new BigDecimal(fee).multiply( vatRate.divide(BIG_DECIMAL_100)))
        		.divide(BIG_DECIMAL_100)
                .setScale(2,RoundingMode.HALF_UP);

        return  vat.doubleValue();// * vatDirection ;
    }
  

    private static Double abs(Double value) {
        return Math.abs(value);
    }
}

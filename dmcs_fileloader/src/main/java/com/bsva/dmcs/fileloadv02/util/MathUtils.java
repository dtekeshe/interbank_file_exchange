package com.bsva.dmcs.fileloadv02.util;

import java.math.BigDecimal;

/**
 *
 */
public class MathUtils {

    public static boolean isNumber(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        int i = 0;
        if (string.charAt(0) == '-') {
            if (string.length() > 1) {
                i++;
            } else {
                return false;
            }
        }
        for (; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static Integer floor(int value, int base) {
        int result = (value / base) * base;
        return result > 0 ? result : 1;
    }

    /**
     * Determine if transaction amount contains purchase portion
     *
     * @param transactionAmount
     * @param cashBackAmount
     * @return has purchase portion
     */
    public static boolean isPureCashBack(Long transactionAmount, Long cashBackAmount) {

        if ( cashBackAmount == null ) {
            return false;
        }
        if(transactionAmount == null){
        	return true;
        }
        return cashBackAmount.longValue() ==  transactionAmount.longValue();
    }

    /**
     * Calculate purchase portion
     *
     * @param transactionAmount
     * @param cashBackAmount
     * @return
     */
    public static Long purchasePortion(Long transactionAmount, Long cashBackAmount) {
        if (transactionAmount == null) {
            transactionAmount = 0L;
        }
        if (cashBackAmount == null) {
            cashBackAmount = 0L;
        }
        return transactionAmount - cashBackAmount;
    }
}

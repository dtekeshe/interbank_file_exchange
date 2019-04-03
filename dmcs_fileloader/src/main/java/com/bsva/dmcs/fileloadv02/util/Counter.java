package com.bsva.dmcs.fileloadv02.util;

/**
 *
 */
public class Counter {

    public static long numberOfRecs = 0;
    
    public static long numberOfFinancialRecs = 0;

    public static long numberOfDebits = 0;
    public static long debitValue = 0;

    public static long numberOfCredits = 0;
    public static long creditValue = 0;

    public static long numberOfRejectedDebits = 0;
    public static long debitRejectedValue = 0;

    public static long numberOfRejectedCredits = 0;
    public static long creditRejectedValue = 0;
    public static long negativeCardCount = 0;
    public static long negativeDuplicateCount = 0;

    public static void reset() {
        numberOfRecs = 0;
        numberOfDebits = 0;
        debitValue = 0;
        numberOfCredits = 0;
        creditValue = 0;
        numberOfRejectedDebits = 0;
        debitRejectedValue = 0;
        numberOfRejectedCredits = 0;
        creditRejectedValue = 0;
        numberOfFinancialRecs = 0;
    }
}

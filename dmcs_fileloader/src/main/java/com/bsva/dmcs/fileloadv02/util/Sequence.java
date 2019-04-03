package com.bsva.dmcs.fileloadv02.util;

/**
 *
 */
public class Sequence {
    public static long fileSystemSeqNumber = 0L;;
    public static long seedCsoTransactionSeq = 0L;; //      = sequences.get("TRANSACTIONS.SYSTEM_SEQ_NUMBER") + 1;
    public static long  seedCsoPaymentInstructionsVISA = 0L; // = sequences.get("PAYMENT_VISA.INPUT_SEQ_NUMBER") + 1;
    public static long  errorSystemSeqNumber = 0L; // = sequences.get("TRAN_ERRORS.ERROR_SEQ_NUMBER") + 1;
}

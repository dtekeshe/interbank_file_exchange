package com.bsva.dmcs.fileloadv02.util;

import com.bsva.dmcs.fileloadv02.model.TCRCode;
import com.bsva.dmcs.fileloadv02.model.VISAFileHeader;
import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.dto.FileStats;
import com.bsva.dto.Filename;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class FileIndexerUtils {

    public final static String PATH_SEPARATOR = System.getProperty("path.separator");
    private static String receiveFolder = null;
    private static String indexFolder = null;
    static {
        // file folders
//        try {
//            Map<String, String> paths = new DirectoryDAO().directories();
//            receiveFolder = paths.get("RECEIVE_PATH");
//            indexFolder = paths.get("FILE_LOADER_INDEX");
//        } catch (UnknownHostException e) {
//            // TODO Handle expection
//            e.printStackTrace();
//        }
    }

    private static final List<Integer> knownTransactionTypes;
    static {
        knownTransactionTypes = new ArrayList<>();
        knownTransactionTypes.add(4);
        knownTransactionTypes.add(5);
        knownTransactionTypes.add(6);
    }

    private static Integer[] debitTransactionCodes;
    static {
        debitTransactionCodes = new Integer[]{4, 5, 7, 14, 15, 17, 26};
    }

    private final static int START_OF_TRAILER_INDICATOR;
    static {
        START_OF_TRAILER_INDICATOR = 92;
    }

    /*
    public static TCRType tcrType(String line) {

        if (line == null) {
            return TCRType.END_OF_FILE;
        }

        Integer transactionCode = line.length() > 1  ? parseInt(line.substring(0, 2).trim()) : -1;

        if (transactionCode == 1) {
            return TCRType.HEADER;
        }

        if ( ! knownTransactionCode(transactionCode) ) {
            return TCRType.UNKNOWN;
        }

        String txnQualifier = line.length() > 3 ? line.substring(2, 4).trim()  : "";

        switch (txnQualifier) {
            case "00":
                return TCRType.FINANCIAL;
            case "01":
            case "03":
            case "05":
            case "07":
                return TCRType.NON_FINANCIAL;
            default:
                String txnCode = line.length() > 1 ? line.substring(0, 2).trim() : "";
                switch (txnCode) {
                    case "92":
                        return TCRType.CONTROL_REC_92;
                    case "98":
                        return TCRType.CONTROL_REC_98;
                    case "99":
                        return TCRType.CONTROL_REC_99;
                    default:
                        return TCRType.UNKNOWN;
                }
        }
    }

    public static boolean knownTransactionCode(Integer transactionCode) {

        return knownTransactionTypes.contains(transactionCode);
    }
    */

    public static String inputPath(String filename) {
        String inputPath = receiveFolder + PATH_SEPARATOR + filename;
        return inputPath;
    }

    public static String indexPath(String filename) {
        String indexPath = indexFolder + PATH_SEPARATOR + filename + ".dat";
        return indexPath;
    }

    public static String parseTxnID(String line) {
        return line.substring(0, 4);
    }

    public static boolean endOfTxns(int txnType) {
        return txnType == START_OF_TRAILER_INDICATOR;
    }

    public static boolean paymentLinesExist(List<FileDetailDTO> paymentLines) {
        return paymentLines.size() > 0;
    }

    /*
    public static BillingData billingData(
                                    TCR payment,
                                    MemberInfoDTO issuingMember,
                                    MemberInfoDTO acquiringMember,
                                    BillingCalculator billingCalculator) {

        // billing key
        BilateralBillingKey bilateralBillingKey
                = new BilateralBillingKey(
                            issuingMember.getBankCode(),
                            acquiringMember.getBankCode(),
                            payment.getTxnCode(),
                            issuingMember.getCardType());

        // billing data
        BigDecimal transactionAmount = payment.getTransactionAmountInBigDecimal();
        BigDecimal cashbackAmount = payment.getCashbackAmountInBigDecimal();
        boolean withCashback = payment.hasCashback();

        return billingCalculator.bill(bilateralBillingKey, transactionAmount, cashbackAmount, withCashback);
    }
    */

    /*
    public static void update(TCR payment,
                        MemberInfoDTO acquiringMember,
                        MemberInfoDTO issuingMember) {
        payment.setAcquiringMember(acquiringMember);
        payment.setIssuingMember(issuingMember);
        payment.setMemberRole(issuingMember.getMemberRole());
    }
    */

    public static void updateCounters(List<FileDetailDTO> paymentLines, FileStats fileStats) {

        for (FileDetailDTO payment : paymentLines) {
            if ( payment.getTcrCode() == TCRCode.TCR0 ) {
                updateCounters(payment, fileStats);

                if ("C".equals(payment.getStatus())) {
                    fileStats.addAcceptedFinRecCount(1L);
                } else {
                    fileStats.addRejectedFinRecCount(1L);
                }
            } else {
                if ("C".equals(payment.getStatus())) {
                    fileStats.addAcceptedNonFinRecCount(1L);
                } else {
                    fileStats.addRejectedNonFinRecCount(1L);
                }
            }
        }
    }

    public static void updateOutputControlCounters(FileDetailDTO payment, Filename filename) {

        boolean isDebit = BinarySearch.search(payment.getTxnCode(), debitTransactionCodes);
        if (isDebit) {
            filename.incrementOutputFileDrVolume();
            filename.incrementOutputFileDrValue((double)payment.getAmount() / 100);
        } else {
            filename.incrementOutputFileCrVolume();
            filename.incrementOutputFileCrValue((double) payment.getAmount() / 100);
        }
    }

    public static void updateCounters(FileDetailDTO payment, FileStats fileStats) {

        // update counters
        ++Counter.numberOfRecs;
        //boolean isDebit = BinarySearch.search(payment.getTxnCode(),debitTransactionCodes);
        Integer txnCode = payment.getBillingTxnCode();
        if (txnCode == null) {
        	txnCode = payment.getTxnCode();
        }
        
        boolean isDebit = BinarySearch.search(txnCode, debitTransactionCodes);

        Long amount = payment.getAmount();
        if (amount == null) {
            amount = 0L;
        }

        if (isDebit) {
            if ("C".equals(payment.getStatus())) {
                ++Counter.numberOfDebits;
                fileStats.addAcceptedDebitsVolume(1L);
                Counter.debitValue += amount.doubleValue();
                fileStats.addAcceptedDebitsValue(amount.doubleValue());
            } else {
                ++Counter.numberOfRejectedDebits;
                fileStats.addRejectedDebitsVolume(1L);
                Counter.debitRejectedValue += amount.doubleValue();
                fileStats.addRejectedDebitsValue(amount.doubleValue());
            }
        } else {
            if ("C".equals(payment.getStatus())) {
                ++Counter.numberOfCredits;
                fileStats.addAcceptedCreditsVolume(1L);
                Counter.creditValue += payment.getAmount().doubleValue();
                fileStats.addAcceptedCreditsValue(payment.getAmount().doubleValue());
            } else {
                ++Counter.numberOfRejectedCredits;
                fileStats.addRejectedCreditsVolume(1L);
                Counter.creditRejectedValue += payment.getAmount().doubleValue();
                fileStats.addRejectedCreditsValue(payment.getAmount().doubleValue());
            }
        }
    }

    public static void updateFileHeaderRecord(VISAFileHeader header, String outFilepath) {
        try {
            RandomAccessFile file = new RandomAccessFile(outFilepath, "rw");
            file.seek(0);
            if (header != null) {
                file.write(header.toString().getBytes());
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateTxns(List<FileDetailDTO> paymentLines, boolean isValid) {
        String tcr0status = paymentLines.get(0).getStatus();
        for (FileDetailDTO paymentLine : paymentLines) {
            paymentLine.setStatus( isValid ? tcr0status : "R");
        }
    }

    public static Integer memberCode(String filename, Map<String, Integer> memberTapeIds) {
        String tapeId = filename.substring(2, 4);
        return memberTapeIds.get(tapeId);
    }
}

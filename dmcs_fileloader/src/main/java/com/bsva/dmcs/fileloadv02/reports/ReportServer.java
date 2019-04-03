package com.bsva.dmcs.fileloadv02.reports;

import static com.bsva.dmcs.fileloadv02.util.TransactionCodeUtils.isNegativeRecord;

import com.bsva.dmcs.fileloadv02.dto.FileStatsCount;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Document
 */
public class ReportServer {

    private final Map<Integer, FileStatsCount> fileStatsCounter;

    public ReportServer(Map<Integer, FileStatsCount> fileStatsCounter) {
        this.fileStatsCounter = fileStatsCounter;
    }

    /**
     * Increment file header record counters
     *
     * @param txnCode
     * @param isAccepted
     */
    public void setHeaderRecordCount(Integer txnCode, Boolean isAccepted) {

        FileStatsCount counter = fileStatsCounter.get(txnCode);

        if ( isAccepted ){
            counter.incrementFinancialRecordCount();
        } else {
            counter.incrementRejectedFinancialRecordCount();
        }
    }

    /**
     * Increment detail record counters
     *
     * @param txnCode
     * @param txnQualifier
     * @param amount
     * @param nonFinancialCount
     * @param isAccepted
     */
    public void setDetailRecordCount( Integer txnCode,
                                      Byte txnQualifier,
                                      Long amount,
                                      Long nonFinancialCount,
                                      Boolean isAccepted ) {

        FileStatsCount counter = fileStatsCounter.get(txnCode);

        if (isNegativeRecord(txnCode) ) {
            // negative record
        } else {
            // non negative record
            if (isAccepted) {
                if (txnQualifier == 0) {
                    // financial record
                    counter.incrementFinancialRecordCount();
                    counter.incrementFinancialRecordAmount(amount);
                } else {
                    // non financial reocrd
                    counter.incrementNonFinancialRecordCount(nonFinancialCount);
                    counter.incrementNonFinancialRecordAmount(amount);
                }
            } else {
                // rejected record
                if (txnQualifier == 0) {
                    // financial record
                    counter.incrementRejectedFinancialRecordCount();
                    counter.incrementRejectedFinancialRecordAmount(amount);
                } else {
                    // non financial reocrd
                    counter.incrementRejectedNonFinancialRecordCount(nonFinancialCount);
                    counter.incrementRejectedNonFinancialRecordAmount(amount);
                }
            }
        }
    }

    public void calculateTotals() {

        Map<String, Long> totals = new HashMap<>();

        for (FileStatsCount stats : fileStatsCounter.values()) {

            // totAccFinRecs
            Long totAccFinRecs = totals.get("totAccFinRecs");
            if (totAccFinRecs == null) {
                totals.put("totAccFinRecs", stats.getFinancialRecordCount());
            } else {
                totAccFinRecs += stats.getFinancialRecordCount();
                totals.put("totAccFinRecs", totAccFinRecs);
            }

            // totRejFinRecs
            Long totRejFinRecs = totals.get("totRejFinRecs");
            if (totRejFinRecs == null) {
                totals.put("totRejFinRecs", stats.getRejectedFinancialRecordCount());
            } else {
                totRejFinRecs += stats.getRejectedFinancialRecordCount();
                totals.put("totRejFinRecs", totRejFinRecs);
            }

            // totAccNonFinRecs
            Long totAccNonFinRecs = totals.get("totAccNonFinRecs");
            if (totAccNonFinRecs == null) {
                totals.put("totAccNonFinRecs", stats.getNonFinancialRecordCount());
            } else {
                totAccNonFinRecs += stats.getNonFinancialRecordCount();
                totals.put("totAccNonFinRecs", totAccNonFinRecs);
            }

            // totRejNonFinRecs
            Long totRejNonFinRecs = totals.get("totRejNonFinRecs");
            if (totRejNonFinRecs == null) {
                totals.put("totRejNonFinRecs", stats.getRejectedNonFinancialRecordCount());
            } else {
                totRejNonFinRecs += stats.getRejectedNonFinancialRecordCount();
                totals.put("totAccFinRecs", totRejNonFinRecs);
            }

            // totNegativeRecords
            Long totNegativeRecords = totals.get("totNegativeRecords");
            if (totNegativeRecords == null) {
                totals.put("totNegativeRecords", stats.getNegativeRecordCount());
            } else {
                totNegativeRecords += stats.getNegativeRecordCount();
                totals.put("totNegativeRecords", totNegativeRecords);
            }

            /* TODO
            // totAccFinRecs
            Long totControlRecords = totals.get("totAccFinRecs");
            if (totAccFinRecs == null) {
                totals.put("totAccFinRecs", stats.getFinancialRecordCount());
            } else {
                totAccFinRecs += stats.getFinancialRecordCount();
                totals.put("totAccFinRecs", totAccFinRecs);
            }
            */
        }

        // totAcceptedRecs
        Long totAccFinRecs = totals.get("totAccFinRecs");
        if (totAccFinRecs == null) {
            totAccFinRecs = 0L;
        }

        Long totAccNonFinRecs = totals.get("totAccNonFinRecs");
        if (totAccNonFinRecs == null) {
            totAccNonFinRecs = 0L;
        }
        totals.put("totAcceptedRecs", (totAccFinRecs + totAccNonFinRecs));

        // totRejectedRecs
        Long totRejFinRecs = totals.get("totRejFinRecs");
        if (totRejFinRecs == null) {
            totRejFinRecs = 0L;
        }

        Long totRejNonFinRecs = totals.get("totRejNonFinRecs");
        if (totRejNonFinRecs == null) {
            totRejNonFinRecs = 0L;
        }
        totals.put("totRejectedRecs", (totRejFinRecs + totRejNonFinRecs));
    }

    public Map<Integer, FileStatsCount> getFileStatsCounter() {
        return fileStatsCounter;
    }
}

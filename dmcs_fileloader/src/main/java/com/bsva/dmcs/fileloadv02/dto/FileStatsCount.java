package com.bsva.dmcs.fileloadv02.dto;

/**
 * TODO Document
 */
public class FileStatsCount {

    private final Integer txnCode;

    private Long financialRecordCount;
    private Long financialRecordAmount;

    private Long nonFinancialRecordCount;
    private Long nonFinancialRecordAmount;

    private Long rejectedFinancialRecordCount;
    private Long rejectedFinancialRecordAmount;

    private Long rejectedNonFinancialRecordCount;
    private Long rejectedNonFinancialRecordAmount;

    private Long negativeRecordCount;

    public FileStatsCount(Integer txnCode) {
        this.txnCode = txnCode;
    }

    public Integer getTxnCode() {
        return txnCode;
    }

    public Long getFinancialRecordCount() {
        return financialRecordCount;
    }

    public void incrementFinancialRecordCount() {
        ++this.financialRecordCount;
    }

    public void incrementFinancialRecordCount(Long count) {
        this.financialRecordCount += count;
    }

    public Long getNonFinancialRecordCount() {
        return nonFinancialRecordCount;
    }

    public void incrementNonFinancialRecordCount(Long count) {
        this.nonFinancialRecordCount += count;
    }

    public void incrementNonFinancialRecordAmount(Long amount){
        this.nonFinancialRecordAmount += amount;
    }

    public Long getFinancialRecordAmount() {
        return financialRecordAmount;
    }

    public void incrementFinancialRecordAmount(Long amount) {
        this.financialRecordAmount += amount;
    }

    public Long getRejectedFinancialRecordCount() {
        return rejectedFinancialRecordCount;
    }

    public void incrementRejectedFinancialRecordCount() {
        ++this.rejectedFinancialRecordCount;
    }

    public void incrementRejectedFinancialRecordCount(Long count) {
        this.rejectedFinancialRecordCount += count;
    }

    public Long getRejectedNonFinancialRecordCount() {
        return rejectedNonFinancialRecordCount;
    }

    public void incrementRejectedNonFinancialRecordCount() {
        ++this.rejectedNonFinancialRecordCount;
    }

    public void incrementRejectedNonFinancialRecordCount(Long count) {
        this.rejectedNonFinancialRecordCount += count;
    }

    public Long getRejectedFinancialRecordAmount() {
        return rejectedFinancialRecordAmount;
    }

    public void incrementRejectedFinancialRecordAmount(Long amount) {
        this.rejectedFinancialRecordAmount += amount;
    }

    public Long getRejectedNonFinancialRecordAmount() {
        return rejectedNonFinancialRecordAmount;
    }

    public void incrementRejectedNonFinancialRecordAmount(Long amount) {
        this.rejectedNonFinancialRecordAmount += amount;
    }

    public Long getNegativeRecordCount() {
        return negativeRecordCount;
    }

    public void setNegativeRecordCount(Long negativeRecordCount) {
        this.negativeRecordCount = negativeRecordCount;
    }
}

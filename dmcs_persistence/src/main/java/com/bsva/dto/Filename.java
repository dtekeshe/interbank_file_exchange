package com.bsva.dto;

/**
 * Filename caller should use
 * How many objects the caller can apply the given filename
 */
public class Filename {

    private final String filename;
    // maximum transactions that can use this finaname
    private final Long maxTransactionCount;
    // how many transaction have used this filename
    private Long transactionCount;
    // transactions total amount
    private Double txnAmount;
    // seq number
    private Long seqNumber;
    // mark this file for some action
    private String actionRequired;

    private Long outputFileCrVolume;
    private Double outputFileCrValue;
    private Long outputFileDrVolume;
    private Double outputFileDrValue;

    public Filename( String filename,
                     Long maxTransactionCount,
                     Long transactionCount,
                     Long seqNumber,
                     Long outputFileCrVolume,
                     Double outputFileCrValue,
                     Long outputFileDrVolume,
                     Double outputFileDrValue) {
        this.filename = filename;
        this.maxTransactionCount = maxTransactionCount;
        this.transactionCount = transactionCount;
        this.seqNumber = seqNumber;
        this.outputFileCrVolume = outputFileCrVolume;
        this.outputFileCrValue = outputFileCrValue;
        this.outputFileDrVolume = outputFileDrVolume;
        this.outputFileDrValue = outputFileDrValue;
    }

    public String getFilename() {
        return filename;
    }

    public Long getMaxTransactionCount() {
        return maxTransactionCount;
    }

    public Long getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(Long transactionCount) {
        this.transactionCount = transactionCount;
    }

    public Long getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(Long seqNumber) {
        this.seqNumber = seqNumber;
    }

    public Double getTxnAmount() {
        return txnAmount;
    }

    public void addTxnAmount(double txnAmount) {
        if (this.txnAmount == null) {
            this.txnAmount = 0.0;
        }
        this.txnAmount += txnAmount;
    }

    public String getActionRequired() {
        return actionRequired;
    }

    public void setActionRequired(String actionRequired) {
        this.actionRequired = actionRequired;
    }

    public long getOutputFileCrVolume() {
        return outputFileCrVolume != null ? outputFileCrVolume.longValue() : 0L;
    }

    public void setOutputFileCrVolume(Long outputFileCrVolume) {
        this.outputFileCrVolume = outputFileCrVolume;
    }

    public void incrementOutputFileCrVolume() {
        if (this.outputFileCrVolume == null) {
            this.outputFileCrVolume = 0L;
        }
        ++this.outputFileCrVolume;
    }

    public double getOutputFileCrValue() {
        return outputFileCrValue != null ? outputFileCrValue.doubleValue() : 0.0;
    }

    public void setOutputFileCrValue(Double outputFileCrValue) {
        this.outputFileCrValue = outputFileCrValue;
    }

    public void incrementOutputFileCrValue(Double outputFileCrValue) {
        if (this.outputFileCrValue == null) {
            this.outputFileCrValue = 0.0;
        }
        this.outputFileCrValue += outputFileCrValue;
    }

    public Long getOutputFileDrVolume() {
        return outputFileDrVolume != null ? outputFileDrVolume.longValue() : 0L;
    }

    public void setOutputFileDrVolume(Long outputFileDrVolume) {
        this.outputFileDrVolume = outputFileDrVolume;
    }

    public void incrementOutputFileDrVolume() {
        if (this.outputFileDrVolume == null) {
            this.outputFileDrVolume = 0L;
        }
        ++this.outputFileDrVolume;
    }

    public Double getOutputFileDrValue() {
        return outputFileDrValue != null ? outputFileDrValue.doubleValue() : 0.0;
    }

    public void setOutputFileDrValue(Double outputFileDrValue) {
        this.outputFileDrValue = outputFileDrValue;
    }

    public void incrementOutputFileDrValue(Double outputFileDrValue) {
        if (this.outputFileDrValue == null) {
            this.outputFileDrValue = 0.0;
        }
        this.outputFileDrValue += outputFileDrValue;
    }
}

package com.bsva.dmcs.fileloadv02.dto;

/**
 * TODO Document
 */
public class NegativeRecordDTO implements Comparable<NegativeRecordDTO> {

    private final Integer fileRefNumber;
    private Integer systemSeqNumber;
    private final String transactionCode;
    private final String destBinNumber;
    private final String sourceBinNumber;
    private Integer transSeqNumber;
    private final Integer transactionType;
    private final Integer authCentre;
    private final String negativeAccNumber;
    private final String responseCode;
    private final Integer purgeDate;
    private final String regionCode;
    private final String cardHolderName;
    private final Integer acquirer;

    public NegativeRecordDTO( Integer fileRefNumber,
                              String transactionCode,
                              String destBinNumber,
                              String sourceBinNumber,
                              Integer transactionType,
                              Integer authCentre,
                              String negativeAccNumber,
                              String responseCode,
                              Integer purgeDate,
                              String regionCode,
                              String cardHolderName,
                              Integer acquirer) {

        this.fileRefNumber = fileRefNumber;
        this.transactionCode = transactionCode;
        this.destBinNumber = destBinNumber;
        this.sourceBinNumber = sourceBinNumber;
        this.transactionType = transactionType;
        this.authCentre = authCentre;
        this.negativeAccNumber = negativeAccNumber;
        this.responseCode = responseCode;
        this.purgeDate = purgeDate;
        this.regionCode = regionCode;
        this.cardHolderName = cardHolderName;
        this.acquirer = acquirer;
    }

    public Integer getFileRefNumber() {
        return fileRefNumber;
    }

    public Integer getSystemSeqNumber() {
        return systemSeqNumber;
    }

    public void setSystemSeqNumber(Integer systemSeqNumber) {
        this.systemSeqNumber = systemSeqNumber;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public String getDestBinNumber() {
        return destBinNumber;
    }

    public String getSourceBinNumber() {
        return sourceBinNumber;
    }

    public Integer getTransSeqNumber() {
        return transSeqNumber;
    }

    public void setTransSeqNumber(Integer transSeqNumber) {
        this.transSeqNumber = transSeqNumber;
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public Integer getAuthCentre() {
        return authCentre;
    }

    public String getNegativeAccNumber() {
        return negativeAccNumber;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public Integer getPurgeDate() {
        return purgeDate;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public Integer getAcquirer() {
        return acquirer;
    }

    @Override
    public int compareTo(NegativeRecordDTO o) {
        return this.getNegativeAccNumber().compareTo(o.getNegativeAccNumber());
    }
}

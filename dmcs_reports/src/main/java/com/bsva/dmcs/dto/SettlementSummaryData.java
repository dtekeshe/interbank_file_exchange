package com.bsva.dmcs.dto;

import static com.bsva.dmcs.reports.SummaryPage.*;

/**
 * TODO Document
 */
public class SettlementSummaryData {

    private final AcquirerIssuerPair pair;

    private String acquirerMember;
    private String issuerMember;

    private Integer transactionCode = 0;
    private String  transactionDescription;

    private Long volume = 0L;
    private Long tranValue = 0L;
    private double billingFee = 0;
    private double billingFeeAmount = 0;
    private double billingVat = 0;

    public SettlementSummaryData(AcquirerIssuerPair pair) {
        this.pair = pair;
    }

    public Integer getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(Integer transactionCode) {
        this.transactionCode = transactionCode;
    }

    public AcquirerIssuerPair getPair() {
        return pair;
    }

    public Long getVolume() {
        return volume;
    }

    public void addVolume(Long volume) {
        if (volume == null) {
            return;
        }
        this.volume += ( (this.volume != null ? this.volume : 0) + volume );
    }

    public Long getTranValue() {
        return tranValue;
    }

    public void setTranValue(Long tranValue) {
        this.tranValue += ( (this.tranValue != null ? this.tranValue : 0) + tranValue );
    }

    public double getBillingFee() {
        return billingFee;
    }

    public void addBillingFee(Double billingFee) {
        if (billingFee == null) {
            return;
        }
        this.billingFee += billingFee.doubleValue();
    }

    public double getBillingFeeAmount() {
        return billingFeeAmount;
    }

    public void addBillingFeeAmount(Double billingFeeAmount) {
        if (billingFeeAmount == null) {
            return;
        }
        this.billingFeeAmount += billingFeeAmount.doubleValue();
    }

    public double getBillingVat() {
        return billingVat;
    }

    public void addBillingVat(Double billingVat) {
        if (billingVat == null) {
            return;
        }
        this.billingVat += billingVat.doubleValue();
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public String getIssuerMember() {
        return issuerMember;
    }

    public void setIssuerMember(String issuerMember) {
        this.issuerMember = issuerMember;
    }

    public String getAcquirerMember() {
        return acquirerMember;
    }

    public void setAcquirerMember(String acquirerMember) {
        this.acquirerMember = acquirerMember;
    }

    /*
    @Override
    public String toString() {

        String s =
                format( payment.getInput(), 168, ' ', Justification.LEFT) +
                        format("" + header.getFileSystemSeqNumber(), 10, ' ', Justification.LEFT) +
                        format("" + payment.getTxnSeqNumber(), 11, ' ', Justification.LEFT) +
                        format("" + header.getServiceId(), 4, ' ', Justification.LEFT) +
                        format("" + header.getSubServiceId(), 6, ' ', Justification.LEFT) +
                        format("" + payment.getLineID(), 10, ' ', Justification.LEFT) +
                        format("" + payment.getAcquirerCode(), 6, ' ', Justification.RIGHT) +
                        format("" + payment.getIssuerCode(), 6, ' ', Justification.RIGHT) +
                        format("" + payment.getCardType(), 2, ' ', Justification.RIGHT) +
                        format("" + payment.getLineID(), 10, ' ', Justification.RIGHT) +
                        format(filename, 8, ' ', Justification.LEFT) +

        return "SettlementSummaryData{" +
                "pair=" + pair +
                ", acquirerMember='" + acquirerMember + '\'' +
                ", issuerMember='" + issuerMember + '\'' +
                ", transactionCode=" + transactionCode +
                ", transactionDescription='" + transactionDescription + '\'' +
                ", volume=" + volume +
                ", tranValue=" + tranValue +
                ", billingFee=" + billingFee +
                ", billingFeeAmount=" + billingFeeAmount +
                ", billingVat=" + billingVat +
                '}';


    }
    */
}

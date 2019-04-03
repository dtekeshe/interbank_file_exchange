package com.bsva.dto;

import java.util.Date;

/**
 * TODO Document
 */
public class FleetBindResolvedDTO {

    private final String serviceID;
    private final String subServiceID;
    private final Integer issuerCode;
    private final Integer acquirerCode;
    private final String accountNumber;
    private final Integer issuerBin;
    private final Integer acquirerBin;
    private final Integer txnCode;
    private final Long txnDateTime;
    private final Integer cardType;
    private final Long fileSystemSeqNumber;
    private final Long txnSystemSeqNumber;
    private final Date processDate;
    private Integer txnCount;
    private Long amount;

    public FleetBindResolvedDTO( String serviceID,
                                 String subServiceID,
                                 Integer issuerCode,
                                 Integer acquirerCode,
                                 String accountNumber,
                                 Integer issuerBin,
                                 Integer acquirerBin,
                                 Integer txnCode,
                                 Long txnDateTime,
                                 Integer cardType,
                                 Long fileSystemSeqNumber,
                                 Long txnSystemSeqNumber,
                                 Date processDate) {
        this.serviceID = serviceID;
        this.subServiceID = subServiceID;
        this.issuerCode = issuerCode;
        this.acquirerCode = acquirerCode;
        this.accountNumber = accountNumber;
        this.issuerBin = issuerBin;
        this.acquirerBin = acquirerBin;
        this.txnCode = txnCode;
        this.txnDateTime = txnDateTime;
        this.cardType = cardType;
        this.fileSystemSeqNumber = fileSystemSeqNumber;
        this.txnSystemSeqNumber = txnSystemSeqNumber;
        this.processDate = processDate;
    }

    public String getServiceID() {
        return serviceID;
    }

    public String getSubServiceID() {
        return subServiceID;
    }

    public Integer getIssuerCode() {
        return issuerCode;
    }

    public Integer getAcquirerCode() {
        return acquirerCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Integer getIssuerBin() {
        return issuerBin;
    }

    public Integer getAcquirerBin() {
        return acquirerBin;
    }

    public Integer getTxnCode() {
        return txnCode;
    }

    public Long getTxnDateTime() {
        return txnDateTime;
    }

    public Integer getCardType() {
        return cardType;
    }

    public Long getFileSystemSeqNumber() {
        return fileSystemSeqNumber;
    }

    public Long getTxnSystemSeqNumber() {
        return txnSystemSeqNumber;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public Integer getTxnCount() {
        return txnCount;
    }

    public void setTxnCount(Integer txnCount) {
        this.txnCount = txnCount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}

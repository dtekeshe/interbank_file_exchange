package com.bsva.entities.v02.settlement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@DynamicUpdate
public class CsoTransactionsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "FILE_SYSTEM_SEQ_NUMBER")
    private String fileSystemSeqNumber;
    @Column(name = "SYSTEM_SEQ_NUMBER")
    private Long systemSeqNumber;
    @Column(name = "RECORD_NUMBER")
    private Long recordNumber;
    @Column(name = "TRANSACTION_CODE")
    private Short transactionCode;
    @Column(name = "CARD_TYPE")
    private Short cardType;
    @Column(name = "ISSUER_MEMBER")
    private Short issuerMember;
    @Column(name = "ACQUIRER_MEMBER")
    private Short acquirerMember;
    @Column(name = "ISSUER_BIN")
    private Integer issuerBin;
    @Column(name = "ACQUIRER_BIN")
    private Integer acquirerBin;
    @Column(name = "PROCESS_STATUS")
    private String processStatus;
    @Column(name = "TRANSACTION_AMOUNT")
    private Long transactionAmount;
    @Column(name = "CASHBACK_PRESENT")
    private String cashbackPresent;
    @Column(name = "CASHBACK_AMOUNT")
    private BigDecimal cashbackAmount;
    @Column(name = "TRANSACTION_TIME")
    private Long transactionTime;
    @Column(name = "RECORD_START_BYTE")
    private BigInteger recordStartByte;
    @Column(name = "RECORD_END_BYTE")
    private BigInteger recordEndByte;
    @Column(name = "OUTPUT_FILENAME")
    private String outputFilename;
    @Column(name = "FILE_RECORD_CNT")
    private Short fileRecordCnt;
    @Column(name = "FLEET_PRODUCT")
    private String fleetProduct;
    @Column(name = "FLEET_SUB_PRODUCT")
    private String fleetSubProduct;
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name = "BILLING_FEE")
    private BigDecimal billingFee;
    @Column(name = "BILLING_FEE_AMOUNT")
    private BigDecimal billingFeeAmount;
    @Column(name = "BILLING_VAT")
    private BigDecimal billingVat;
    @Column(name = "CB_BILL_FEE")
    private BigDecimal cbBillFee;
    @Column(name = "CB_BILL_FEE_AMNT")
    private BigDecimal cbBillFeeAmnt;
    @Column(name = "CB_BILL_VAT")
    private BigDecimal cbBillVat;
    @Column(name = "DEST_REPORT")
    private String destReport;
    @Column(name = "FLEET_COUNT_TRAN")
    private String fleetCountTran;
    @Column(name = "MESSAGE_TYPE_IND")
    private Short messageTypeInd;
    @Column(name = "MERCHANT_CAT_CODE")
    private Short merchantCatCode;
    @Column(name = "INTCHG_RATE_DSGN")
    private Short intchgRateDsgn;
    @Column(name = "MESSAGE_REASON_CODE")
    private Short messageReasonCode;
    @Column(name = "OPFILE_NUM_SEQ")
    private Integer opfileNumSeq;
    @Size(max = 1)
    @Column(name = "EXTRACTIND")
    private String extractind;

    public CsoTransactionsEntity() {
    }

    public CsoTransactionsEntity(Long systemSeqNumber) {
        this.systemSeqNumber = systemSeqNumber;
    }

    public CsoTransactionsEntity(Long systemSeqNumber, String fileSystemSeqNumber, Long recordNumber, Short transactionCode, Short cardType, String processStatus, Long transactionAmount, String cashbackPresent, BigDecimal cashbackAmount, BigInteger recordStartByte, BigInteger recordEndByte, Short fileRecordCnt, String fleetCountTran, Integer opfileNumSeq) {
        this.systemSeqNumber = systemSeqNumber;
        this.fileSystemSeqNumber = fileSystemSeqNumber;
        this.recordNumber = recordNumber;
        this.transactionCode = transactionCode;
        this.cardType = cardType;
        this.processStatus = processStatus;
        this.transactionAmount = transactionAmount;
        this.cashbackPresent = cashbackPresent;
        this.cashbackAmount = cashbackAmount;
        this.recordStartByte = recordStartByte;
        this.recordEndByte = recordEndByte;
        this.fileRecordCnt = fileRecordCnt;
        this.fleetCountTran = fleetCountTran;
        this.opfileNumSeq = opfileNumSeq;
    }

    public String getFileSystemSeqNumber() {
        return fileSystemSeqNumber;
    }

    public void setFileSystemSeqNumber(String fileSystemSeqNumber) {
        this.fileSystemSeqNumber = fileSystemSeqNumber;
    }

    public Long getSystemSeqNumber() {
        return systemSeqNumber;
    }

    public void setSystemSeqNumber(Long systemSeqNumber) {
        this.systemSeqNumber = systemSeqNumber;
    }

    public long getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(Long recordNumber) {
        this.recordNumber = recordNumber;
    }

    public short getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(Short transactionCode) {
        this.transactionCode = transactionCode;
    }

    public short getCardType() {
        return cardType;
    }

    public void setCardType(Short cardType) {
        this.cardType = cardType;
    }

    public Short getIssuerMember() {
        return issuerMember;
    }

    public void setIssuerMember(Short issuerMember) {
        this.issuerMember = issuerMember;
    }

    public Short getAcquirerMember() {
        return acquirerMember;
    }

    public void setAcquirerMember(Short acquirerMember) {
        this.acquirerMember = acquirerMember;
    }

    public Integer getIssuerBin() {
        return issuerBin;
    }

    public void setIssuerBin(Integer issuerBin) {
        this.issuerBin = issuerBin;
    }

    public Integer getAcquirerBin() {
        return acquirerBin;
    }

    public void setAcquirerBin(Integer acquirerBin) {
        this.acquirerBin = acquirerBin;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public Long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getCashbackPresent() {
        return cashbackPresent;
    }

    public void setCashbackPresent(String cashbackPresent) {
        this.cashbackPresent = cashbackPresent;
    }

    public BigDecimal getCashbackAmount() {
        return cashbackAmount;
    }

    public void setCashbackAmount(BigDecimal cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }

    public Long getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Long transactionTime) {
        this.transactionTime = transactionTime;
    }

    public BigInteger getRecordStartByte() {
        return recordStartByte;
    }

    public void setRecordStartByte(BigInteger recordStartByte) {
        this.recordStartByte = recordStartByte;
    }

    public BigInteger getRecordEndByte() {
        return recordEndByte;
    }

    public void setRecordEndByte(BigInteger recordEndByte) {
        this.recordEndByte = recordEndByte;
    }

    public String getOutputFilename() {
        return outputFilename;
    }

    public void setOutputFilename(String outputFilename) {
        this.outputFilename = outputFilename;
    }

    public short getFileRecordCnt() {
        return fileRecordCnt;
    }

    public void setFileRecordCnt(Short fileRecordCnt) {
        this.fileRecordCnt = fileRecordCnt;
    }

    public String getFleetProduct() {
        return fleetProduct;
    }

    public void setFleetProduct(String fleetProduct) {
        this.fleetProduct = fleetProduct;
    }

    public String getFleetSubProduct() {
        return fleetSubProduct;
    }

    public void setFleetSubProduct(String fleetSubProduct) {
        this.fleetSubProduct = fleetSubProduct;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBillingFee() {
        return billingFee;
    }

    public void setBillingFee(BigDecimal billingFee) {
        this.billingFee = billingFee;
    }

    public BigDecimal getBillingFeeAmount() {
        return billingFeeAmount;
    }

    public void setBillingFeeAmount(BigDecimal billingFeeAmount) {
        this.billingFeeAmount = billingFeeAmount;
    }

    public BigDecimal getBillingVat() {
        return billingVat;
    }

    public void setBillingVat(BigDecimal billingVat) {
        this.billingVat = billingVat;
    }

    public BigDecimal getCbBillFee() {
        return cbBillFee;
    }

    public void setCbBillFee(BigDecimal cbBillFee) {
        this.cbBillFee = cbBillFee;
    }

    public BigDecimal getCbBillFeeAmnt() {
        return cbBillFeeAmnt;
    }

    public void setCbBillFeeAmnt(BigDecimal cbBillFeeAmnt) {
        this.cbBillFeeAmnt = cbBillFeeAmnt;
    }

    public BigDecimal getCbBillVat() {
        return cbBillVat;
    }

    public void setCbBillVat(BigDecimal cbBillVat) {
        this.cbBillVat = cbBillVat;
    }

    public String getDestReport() {
        return destReport;
    }

    public void setDestReport(String destReport) {
        this.destReport = destReport;
    }

    public String getFleetCountTran() {
        return fleetCountTran;
    }

    public void setFleetCountTran(String fleetCountTran) {
        this.fleetCountTran = fleetCountTran;
    }

    public Short getMessageTypeInd() {
        return messageTypeInd;
    }

    public void setMessageTypeInd(Short messageTypeInd) {
        this.messageTypeInd = messageTypeInd;
    }

    public Short getMerchantCatCode() {
        return merchantCatCode;
    }

    public void setMerchantCatCode(Short merchantCatCode) {
        this.merchantCatCode = merchantCatCode;
    }

    public Short getIntchgRateDsgn() {
        return intchgRateDsgn;
    }

    public void setIntchgRateDsgn(Short intchgRateDsgn) {
        this.intchgRateDsgn = intchgRateDsgn;
    }

    public Short getMessageReasonCode() {
        return messageReasonCode;
    }

    public void setMessageReasonCode(Short messageReasonCode) {
        this.messageReasonCode = messageReasonCode;
    }

    public int getOpfileNumSeq() {
        return opfileNumSeq;
    }

    public void setOpfileNumSeq(Integer opfileNumSeq) {
        this.opfileNumSeq = opfileNumSeq;
    }

    public String getExtractind() {
        return extractind;
    }

    public void setExtractind(String extractind) {
        this.extractind = extractind;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (systemSeqNumber != null ? systemSeqNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoTransactionsEntity)) {
            return false;
        }
        CsoTransactionsEntity other = (CsoTransactionsEntity) object;
        if ((this.systemSeqNumber == null && other.systemSeqNumber != null) || (this.systemSeqNumber != null && !this.systemSeqNumber.equals(other.systemSeqNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoTransactions[ systemSeqNumber=" + systemSeqNumber + " ]";
    }

}

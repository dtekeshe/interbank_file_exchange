package com.bsva.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSO_TRANSACTIONS")
@NamedQueries({
    @NamedQuery(name = "CsoTransactions.findAll", query = "SELECT c FROM CsoTransactions c"),
    @NamedQuery(name = "CsoTransactions.findByFileSystemSeqNumber", query = "SELECT c FROM CsoTransactions c WHERE c.fileSystemSeqNumber = :fileSystemSeqNumber"),
    @NamedQuery(name = "CsoTransactions.findBySystemSeqNumber", query = "SELECT c FROM CsoTransactions c WHERE c.systemSeqNumber = :systemSeqNumber"),
    @NamedQuery(name = "CsoTransactions.findByRecordNumber", query = "SELECT c FROM CsoTransactions c WHERE c.recordNumber = :recordNumber"),
    @NamedQuery(name = "CsoTransactions.findByTransactionCode", query = "SELECT c FROM CsoTransactions c WHERE c.transactionCode = :transactionCode"),
    @NamedQuery(name = "CsoTransactions.findByCardType", query = "SELECT c FROM CsoTransactions c WHERE c.cardType = :cardType"),
    @NamedQuery(name = "CsoTransactions.findByIssuerMember", query = "SELECT c FROM CsoTransactions c WHERE c.issuerMember = :issuerMember"),
    @NamedQuery(name = "CsoTransactions.findByAcquirerMember", query = "SELECT c FROM CsoTransactions c WHERE c.acquirerMember = :acquirerMember"),
    @NamedQuery(name = "CsoTransactions.findByIssuerBin", query = "SELECT c FROM CsoTransactions c WHERE c.issuerBin = :issuerBin"),
    @NamedQuery(name = "CsoTransactions.findByAcquirerBin", query = "SELECT c FROM CsoTransactions c WHERE c.acquirerBin = :acquirerBin"),
    @NamedQuery(name = "CsoTransactions.findByProcessStatus", query = "SELECT c FROM CsoTransactions c WHERE c.processStatus = :processStatus"),
    @NamedQuery(name = "CsoTransactions.findByTransactionAmount", query = "SELECT c FROM CsoTransactions c WHERE c.transactionAmount = :transactionAmount"),
    @NamedQuery(name = "CsoTransactions.findByCashbackPresent", query = "SELECT c FROM CsoTransactions c WHERE c.cashbackPresent = :cashbackPresent"),
    @NamedQuery(name = "CsoTransactions.findByCashbackAmount", query = "SELECT c FROM CsoTransactions c WHERE c.cashbackAmount = :cashbackAmount"),
    @NamedQuery(name = "CsoTransactions.findByTransactionTime", query = "SELECT c FROM CsoTransactions c WHERE c.transactionTime = :transactionTime"),
    @NamedQuery(name = "CsoTransactions.findByRecordStartByte", query = "SELECT c FROM CsoTransactions c WHERE c.recordStartByte = :recordStartByte"),
    @NamedQuery(name = "CsoTransactions.findByRecordEndByte", query = "SELECT c FROM CsoTransactions c WHERE c.recordEndByte = :recordEndByte"),
    @NamedQuery(name = "CsoTransactions.findByOutputFilename", query = "SELECT c FROM CsoTransactions c WHERE c.outputFilename = :outputFilename"),
    @NamedQuery(name = "CsoTransactions.findByFileRecordCnt", query = "SELECT c FROM CsoTransactions c WHERE c.fileRecordCnt = :fileRecordCnt"),
    @NamedQuery(name = "CsoTransactions.findByFleetProduct", query = "SELECT c FROM CsoTransactions c WHERE c.fleetProduct = :fleetProduct"),
    @NamedQuery(name = "CsoTransactions.findByFleetSubProduct", query = "SELECT c FROM CsoTransactions c WHERE c.fleetSubProduct = :fleetSubProduct"),
    @NamedQuery(name = "CsoTransactions.findByAccountNumber", query = "SELECT c FROM CsoTransactions c WHERE c.accountNumber = :accountNumber"),
    @NamedQuery(name = "CsoTransactions.findByBillingFee", query = "SELECT c FROM CsoTransactions c WHERE c.billingFee = :billingFee"),
    @NamedQuery(name = "CsoTransactions.findByBillingFeeAmount", query = "SELECT c FROM CsoTransactions c WHERE c.billingFeeAmount = :billingFeeAmount"),
    @NamedQuery(name = "CsoTransactions.findByBillingVat", query = "SELECT c FROM CsoTransactions c WHERE c.billingVat = :billingVat"),
    @NamedQuery(name = "CsoTransactions.findByCbBillFee", query = "SELECT c FROM CsoTransactions c WHERE c.cbBillFee = :cbBillFee"),
    @NamedQuery(name = "CsoTransactions.findByCbBillFeeAmnt", query = "SELECT c FROM CsoTransactions c WHERE c.cbBillFeeAmnt = :cbBillFeeAmnt"),
    @NamedQuery(name = "CsoTransactions.findByCbBillVat", query = "SELECT c FROM CsoTransactions c WHERE c.cbBillVat = :cbBillVat"),
    @NamedQuery(name = "CsoTransactions.findByDestReport", query = "SELECT c FROM CsoTransactions c WHERE c.destReport = :destReport"),
    @NamedQuery(name = "CsoTransactions.findByFleetCountTran", query = "SELECT c FROM CsoTransactions c WHERE c.fleetCountTran = :fleetCountTran"),
    @NamedQuery(name = "CsoTransactions.findByMessageTypeInd", query = "SELECT c FROM CsoTransactions c WHERE c.messageTypeInd = :messageTypeInd"),
    @NamedQuery(name = "CsoTransactions.findByMerchantCatCode", query = "SELECT c FROM CsoTransactions c WHERE c.merchantCatCode = :merchantCatCode"),
    @NamedQuery(name = "CsoTransactions.findByIntchgRateDsgn", query = "SELECT c FROM CsoTransactions c WHERE c.intchgRateDsgn = :intchgRateDsgn"),
    @NamedQuery(name = "CsoTransactions.findByMessageReasonCode", query = "SELECT c FROM CsoTransactions c WHERE c.messageReasonCode = :messageReasonCode"),
    @NamedQuery(name = "CsoTransactions.findByOpfileNumSeq", query = "SELECT c FROM CsoTransactions c WHERE c.opfileNumSeq = :opfileNumSeq"),
    @NamedQuery(name = "CsoTransactions.findByExtractind", query = "SELECT c FROM CsoTransactions c WHERE c.extractind = :extractind")})
@DynamicUpdate
public class CsoTransactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "FILE_SYSTEM_SEQ_NUMBER")
    private String fileSystemSeqNumber;
     @Id

    // @GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "CSO_TX_SEQ"))
    //@SequenceGenerator(name="generator", sequenceName="CSO_TX_SEQ",allocationSize=1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    //@Basic(optional = false)


    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="generator")
//    @SequenceGenerator(name="generator", sequenceName="CSO_TX_SEQ", allocationSize=0)
     // enhance table strategy
//    @GenericGenerator(
//            name = "dmcsSequenceStore",
//            strategy = "enhanced-table",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(
//                            name = "table_name",
//                            value = "DMCS_SEQ_STORE"
//                    )
//            })

    @Column(name = "SYSTEM_SEQ_NUMBER")
    @TableGenerator(
            name = "dmcsSequenceStore",
            table="DMCS_SEQ_STORE",
            pkColumnName = "DMCS_SEQ_NAME",
            pkColumnValue = "TRANSACTIONS.SYSTEM_SEQ_NUMBER",
            valueColumnName = "DMCS_SEQ_VALUE",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "dmcsSequenceStore")
    private Long systemSeqNumber;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "RECORD_NUMBER")
    private Long recordNumber;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "TRANSACTION_CODE")
    private Short transactionCode;
    @Basic(optional = false)
    // @NotNull
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
    @Basic(optional = false)
    // @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PROCESS_STATUS")
    private String processStatus;
    @Basic(optional = false)
    // @NotNull
    @Column(name = "TRANSACTION_AMOUNT")
    private Long transactionAmount;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CASHBACK_PRESENT")
    private String cashbackPresent;
    @Basic(optional = false)
    // @NotNull
    @Column(name = "CASHBACK_AMOUNT")
    private BigDecimal cashbackAmount;
    @Column(name = "TRANSACTION_TIME")
    private Long transactionTime;
    @Basic(optional = false)
    // @NotNull
    @Column(name = "RECORD_START_BYTE")
    private BigInteger recordStartByte;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "RECORD_END_BYTE")
    private BigInteger recordEndByte;
    @Size(max = 8)
    @Column(name = "OUTPUT_FILENAME")
    private String outputFilename;
    @Basic(optional = false)
    // @NotNull
    @Column(name = "FILE_RECORD_CNT")
    private Short fileRecordCnt;
    @Size(max = 1)
    @Column(name = "FLEET_PRODUCT")
    private String fleetProduct;
    @Size(max = 2)
    @Column(name = "FLEET_SUB_PRODUCT")
    private String fleetSubProduct;
    @Size(max = 19)
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
    @Size(max = 1)
    @Column(name = "DEST_REPORT")
    private String destReport;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 1)
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
    @Basic(optional = false)
    //@NotNull
    @Column(name = "OPFILE_NUM_SEQ")
    private Integer opfileNumSeq;
    @Size(max = 1)
    @Column(name = "EXTRACTIND")
    private String extractind;
    @Size(max = 10)
    @Column(name = "RATE_DESC")
    private String rateDesc;

    public CsoTransactions() {
    }

    public CsoTransactions(Long systemSeqNumber) {
        this.systemSeqNumber = systemSeqNumber;
    }

    public CsoTransactions(Long systemSeqNumber, String fileSystemSeqNumber, Long recordNumber, Short transactionCode, Short cardType, String processStatus, Long transactionAmount, String cashbackPresent, BigDecimal cashbackAmount, BigInteger recordStartByte, BigInteger recordEndByte, Short fileRecordCnt, String fleetCountTran, Integer opfileNumSeq) {
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
    

    public String getRateDesc() {
        return rateDesc;
    }

    public void setRateDesc(String rateDesc) {
        this.rateDesc = rateDesc;
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
        if (!(object instanceof CsoTransactions)) {
            return false;
        }
        CsoTransactions other = (CsoTransactions) object;
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

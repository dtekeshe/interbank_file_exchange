/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSO_PAYMENT_INSTRUCTIONS_VISA")
@NamedQueries({
    @NamedQuery(name = "CsoPaymentInstructionsVisa.findAll", query = "SELECT c FROM CsoPaymentInstructionsVisa c"),
    @NamedQuery(name = "CsoPaymentInstructionsVisa.findByCashbackPurchase", query = "SELECT c FROM CsoPaymentInstructionsVisa c WHERE c.cashbackPurchase = :cashbackPurchase"),
    @NamedQuery(name = "CsoPaymentInstructionsVisa.findByCashbackPurchaseAmnt", query = "SELECT c FROM CsoPaymentInstructionsVisa c WHERE c.cashbackPurchaseAmnt = :cashbackPurchaseAmnt")})
@DynamicUpdate
public class CsoPaymentInstructionsVisa implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsoPaymentInstructionsVisaPK csoPaymentInstructionsVisaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "FILE_REF_NUMBER")
    private String fileRefNumber;
    @Size(max = 4)
    @Column(name = "SERVICE")
    private String service;
    @Size(max = 10)
    @Column(name = "SUB_SERVICE")
    private String subService;
    @Column(name = "ACQUIRER_MEMBER")
    private String acquirerMember;
    @Column(name = "ISSUER_MEMBER")
    private String issuerMember;
    @Size(max = 16)
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VISA_AMOUNT")
    private BigDecimal visaAmount;
    @Size(max = 1)
    @Column(name = "FINANCIAL_INDICATOR")
    private String financialIndicator;
    @Size(max = 2)
    @Column(name = "TRANSACTION_CODE")
    private String transactionCode;
    @Column(name = "TRANSACTION_CODE_QUALIFIER")
    private Short transactionCodeQualifier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 168)
    @Column(name = "CARD_TRANSACTION")
    private String cardTransaction;
    @Size(max = 1)
    @Column(name = "PROCESS_STATUS")
    private String processStatus;
    @Column(name = "SETTLEMENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date settlementDate;
    @Column(name = "OUTPUT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date outputDate;
    @Column(name = "EXCHANGE_RATE")
    private Long exchangeRate;
    @Size(max = 3)
    @Column(name = "ACQUIRER_COUNTRY_CODE")
    private String acquirerCountryCode;
    @Size(max = 3)
    @Column(name = "ISSUER_COUNTRY_CODE")
    private String issuerCountryCode;
    @Size(max = 3)
    @Column(name = "XBORDER_ISSUER_COUNTRY_CODE")
    private String xborderIssuerCountryCode;
    @Column(name = "XBORDER_ISSUER_MEMBER")
    private Short xborderIssuerMember;
    @Size(max = 2)
    @Column(name = "CARD_TYPE")
    private String cardType;
    @Size(max = 8)
    @Column(name = "FILENAME_DESCRIPTION")
    private String filenameDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CASHBACK_PURCHASE")
    private String cashbackPurchase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CASHBACK_PURCHASE_AMNT")
    private BigDecimal cashbackPurchaseAmnt;
    @Column(name = "POS_ENTRY_MODE")
    private String posEntryMode;
    @Column(name = "CHIP_CARD")
    private String chipCard;
    @Column(name = "TERMINAL_CAPABILITY")
    private String terminalCapability;
    @Column(name = "ECOMM_IND")
    private String ecommInd;
    @Column(name = "CARD_PRESENT")
    private String cardPresent;
    @Column(name = "RATE_DESC")
    private String rateDesc;
    @Column(name = "INTERCHANGE_FEE")
    private Double interchangeFee;
    @Column(name = "INTERCHANGE_PERC")
    private Double interchangePerc;
    @Column(name = "INTERCHANGE_VAT")
    private Double interchangeVat;
    @Column(name = "CASHBACK_IC_FEE")
    private Double cashbackIcFee;
    @Column(name = "CASHBACK_IC_PERC")
    private Double cashbackIcPerc;
    @Column(name = "CASHBACK_IC_VAT")
    private Double cashbackIcVat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INPUT_SEQ_NUMBER")
    private long inputSeqNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "INPUT_FILE_IDENTIFIER")
    private String inputFileIdentifier;
    

    public CsoPaymentInstructionsVisa() {
    }

    public CsoPaymentInstructionsVisa(CsoPaymentInstructionsVisaPK csoPaymentInstructionsVisaPK) {
        this.csoPaymentInstructionsVisaPK = csoPaymentInstructionsVisaPK;
    }

    public CsoPaymentInstructionsVisa(CsoPaymentInstructionsVisaPK csoPaymentInstructionsVisaPK, String fileRefNumber, String systemGenSeqNumber, String cardTransaction, String cashbackPurchase, BigDecimal cashbackPurchaseAmnt) {
        this.csoPaymentInstructionsVisaPK = csoPaymentInstructionsVisaPK;
        this.fileRefNumber = fileRefNumber;
        this.cardTransaction = cardTransaction;
        this.cashbackPurchase = cashbackPurchase;
        this.cashbackPurchaseAmnt = cashbackPurchaseAmnt;
    }

    public CsoPaymentInstructionsVisa(long inputSeqNumber, String transactionCodeNumber) {
        this.csoPaymentInstructionsVisaPK = new CsoPaymentInstructionsVisaPK();
    }

    public CsoPaymentInstructionsVisaPK getCsoPaymentInstructionsVisaPK() {
        return csoPaymentInstructionsVisaPK;
    }

    public void setCsoPaymentInstructionsVisaPK(CsoPaymentInstructionsVisaPK csoPaymentInstructionsVisaPK) {
        this.csoPaymentInstructionsVisaPK = csoPaymentInstructionsVisaPK;
    }

    public String getFileRefNumber() {
        return fileRefNumber;
    }

    public void setFileRefNumber(String fileRefNumber) {
        this.fileRefNumber = fileRefNumber;
    }
    public long getInputSeqNumber() {
        return inputSeqNumber;
    }

    public void setInputSeqNumber(long inputSeqNumber) {
        this.inputSeqNumber = inputSeqNumber;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSubService() {
        return subService;
    }

    public void setSubService(String subService) {
        this.subService = subService;
    }

    public String getAcquirerMember() {
        return acquirerMember;
    }

    public void setAcquirerMember(String acquirerMember) {
        this.acquirerMember = acquirerMember;
    }

    public String getIssuerMember() {
        return issuerMember;
    }

    public void setIssuerMember(String issuerMember) {
        this.issuerMember = issuerMember;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getVisaAmount() {
        return visaAmount;
    }

    public void setVisaAmount(BigDecimal visaAmount) {
        this.visaAmount = visaAmount;
    }

    public String getFinancialIndicator() {
        return financialIndicator;
    }

    public void setFinancialIndicator(String financialIndicator) {
        this.financialIndicator = financialIndicator;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public Short getTransactionCodeQualifier() {
        return transactionCodeQualifier;
    }

    public void setTransactionCodeQualifier(Short transactionCodeQualifier) {
        this.transactionCodeQualifier = transactionCodeQualifier;
    }

    public String getInputFileIdentifier() {
        return inputFileIdentifier;
    }

    public void setInputFileIdentifier(String inputFileIdentifier) {
        this.inputFileIdentifier = inputFileIdentifier;
    }

    public String getCardTransaction() {
        return cardTransaction;
    }

    public void setCardTransaction(String cardTransaction) {
        this.cardTransaction = cardTransaction;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public Date getOutputDate() {
        return outputDate;
    }

    public void setOutputDate(Date outputDate) {
        this.outputDate = outputDate;
    }

    public Long getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Long exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getAcquirerCountryCode() {
        return acquirerCountryCode;
    }

    public void setAcquirerCountryCode(String acquirerCountryCode) {
        this.acquirerCountryCode = acquirerCountryCode;
    }

    public String getIssuerCountryCode() {
        return issuerCountryCode;
    }

    public void setIssuerCountryCode(String issuerCountryCode) {
        this.issuerCountryCode = issuerCountryCode;
    }

    public String getXborderIssuerCountryCode() {
        return xborderIssuerCountryCode;
    }

    public void setXborderIssuerCountryCode(String xborderIssuerCountryCode) {
        this.xborderIssuerCountryCode = xborderIssuerCountryCode;
    }

    public Short getXborderIssuerMember() {
        return xborderIssuerMember;
    }

    public void setXborderIssuerMember(Short xborderIssuerMember) {
        this.xborderIssuerMember = xborderIssuerMember;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getFilenameDescription() {
        return filenameDescription;
    }

    public void setFilenameDescription(String filenameDescription) {
        this.filenameDescription = filenameDescription;
    }

    public String getCashbackPurchase() {
        return cashbackPurchase;
    }

    public void setCashbackPurchase(String cashbackPurchase) {
        this.cashbackPurchase = cashbackPurchase;
    }

    public BigDecimal getCashbackPurchaseAmnt() {
        return cashbackPurchaseAmnt;
    }

    public void setCashbackPurchaseAmnt(BigDecimal cashbackPurchaseAmnt) {
        this.cashbackPurchaseAmnt = cashbackPurchaseAmnt;
    }

    public String getPosEntryMode() {
        return posEntryMode;
    }

    public void setPosEntryMode(String posEntryMode) {
        this.posEntryMode = posEntryMode;
    }

    public String getChipCard() {
        return chipCard;
    }

    public void setChipCard(String chipCard) {
        this.chipCard = chipCard;
    }

    public String getTerminalCapability() {
        return terminalCapability;
    }

    public void setTerminalCapability(String terminalCapability) {
        this.terminalCapability = terminalCapability;
    }

    public String getEcommInd() {
        return ecommInd;
    }

    public void setEcommInd(String ecommInd) {
        this.ecommInd = ecommInd;
    }

    public String getCardPresent() {
        return cardPresent;
    }

    public void setCardPresent(String cardPresent) {
        this.cardPresent = cardPresent;
    }

    public String getRateDesc() {
        return rateDesc;
    }

    public void setRateDesc(String rateDesc) {
        this.rateDesc = rateDesc;
    }

    public Double getInterchangeFee() {
        return interchangeFee;
    }

    public void setInterchangeFee(Double interchangeFee) {
        this.interchangeFee = interchangeFee;
    }

    public Double getInterchangePerc() {
        return interchangePerc;
    }

    public void setInterchangePerc(Double interchangePerc) {
        this.interchangePerc = interchangePerc;
    }

    public Double getInterchangeVat() {
        return interchangeVat;
    }

    public void setInterchangeVat(Double interchangeVat) {
        this.interchangeVat = interchangeVat;
    }

    public Double getCashbackIcFee() {
        return cashbackIcFee;
    }

    public void setCashbackIcFee(Double cashbackIcFee) {
        this.cashbackIcFee = cashbackIcFee;
    }

    public Double getCashbackIcPerc() {
        return cashbackIcPerc;
    }

    public void setCashbackIcPerc(Double cashbackIcPerc) {
        this.cashbackIcPerc = cashbackIcPerc;
    }

    public Double getCashbackIcVat() {
        return cashbackIcVat;
    }

    public void setCashbackIcVat(Double cashbackIcVat) {
        this.cashbackIcVat = cashbackIcVat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csoPaymentInstructionsVisaPK != null ? csoPaymentInstructionsVisaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoPaymentInstructionsVisa)) {
            return false;
        }
        CsoPaymentInstructionsVisa other = (CsoPaymentInstructionsVisa) object;
        if ((this.csoPaymentInstructionsVisaPK == null && other.csoPaymentInstructionsVisaPK != null) || (this.csoPaymentInstructionsVisaPK != null && !this.csoPaymentInstructionsVisaPK.equals(other.csoPaymentInstructionsVisaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoPaymentInstructionsVisa[ csoPaymentInstructionsVisaPK=" + csoPaymentInstructionsVisaPK + " ]";
    }
    
}

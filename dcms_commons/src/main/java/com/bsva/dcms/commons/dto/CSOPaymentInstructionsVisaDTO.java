package com.bsva.dcms.commons.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Nombuyiselo Mbangula <nombuyiselom@bankservafrica.com>
 */
public class CSOPaymentInstructionsVisaDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String fileRefNumber;
    private int systemGenSeqNumber;
    private String service;
    private String subService;
    private int acquierMember;
    private int issuerMember;
    private String accountNumber;
    private int visaAmount;
    private String financialIndicator;
    private String transactionCode;
    private int transactionCodeQualifier;
    private int transactionCodeNumber;
    private int inputSeqNumber;
    private String cardTransaction;
    private String processStatus;
    private String inputFileIdentifier;
    private Date settlementDate;
    private Date outputDate;
    private int exchangeRate;
    private String acquierCountryCode;
    private String issuerCountryCode;
    private String xborderCountryCode;
    private int xborderIssuerMember;
    private String cardType;
    private String filenameDescription;
    private String cashbackPurchase;
    private int cashbackPurchaseAmnt;
    // SARB Billing Values        
    private String posEntryMode;
    private String chipCard;
    private String terminalCapability;
    private String ecommInd;
    private String cardPresent;
    private String rateDesc;
    private Double interchangeFee;
    private Double interchangePerc;
    private Double interchasngeVat;
    private Double cashbackIcFee;
    private Double cashbackIcPerc;
    private Double cashbackIcVat;
    private String feeDataPresent;
    private String sarbBilling;
    private String posEntryModeIn;
    private String terminalCapabilityIn;
    private String eCommIndIn;
    private String cardholderIndIn;

    public String getFileRefNumber() {
        return fileRefNumber;
    }

    public void setFileRefNumber(String fileRefNumber) {
        this.fileRefNumber = fileRefNumber;
    }

    public int getSystemGenSeqNumber() {
        return systemGenSeqNumber;
    }

    public void setSystemGenSeqNumber(int systemGenSeqNumber) {
        this.systemGenSeqNumber = systemGenSeqNumber;
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

    public int getAcquierMember() {
        return acquierMember;
    }

    public void setAcquierMember(int acquierMember) {
        this.acquierMember = acquierMember;
    }

    public int getIssuerMember() {
        return issuerMember;
    }

    public void setIssuerMember(int issuerMember) {
        this.issuerMember = issuerMember;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getVisaAmount() {
        return visaAmount;
    }

    public void setVisaAmount(int visaAmount) {
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

    public int getTransactionCodeQualifier() {
        return transactionCodeQualifier;
    }

    public void setTransactionCodeQualifier(int transactionCodeQualifier) {
        this.transactionCodeQualifier = transactionCodeQualifier;
    }

    public int getTransactionCodeNumber() {
        return transactionCodeNumber;
    }

    public void setTransactionCodeNumber(int transactionCodeNumber) {
        this.transactionCodeNumber = transactionCodeNumber;
    }

    public int getInputSeqNumber() {
        return inputSeqNumber;
    }

    public void setInputSeqNumber(int inputSeqNumber) {
        this.inputSeqNumber = inputSeqNumber;
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

    public String getInputFileIdentifier() {
        return inputFileIdentifier;
    }

    public void setInputFileIdentifier(String inputFileIdentifier) {
        this.inputFileIdentifier = inputFileIdentifier;
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

    public int getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(int exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getAcquierCountryCode() {
        return acquierCountryCode;
    }

    public void setAcquierCountryCode(String acquierCountryCode) {
        this.acquierCountryCode = acquierCountryCode;
    }

    public String getIssuerCountryCode() {
        return issuerCountryCode;
    }

    public void setIssuerCountryCode(String issuerCountryCode) {
        this.issuerCountryCode = issuerCountryCode;
    }

    public String getXborderCountryCode() {
        return xborderCountryCode;
    }

    public void setXborderCountryCode(String xborderCountryCode) {
        this.xborderCountryCode = xborderCountryCode;
    }

    public int getXborderIssuerMember() {
        return xborderIssuerMember;
    }

    public void setXborderIssuerMember(int xborderIssuerMember) {
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

    public int getCashbackPurchaseAmnt() {
        return cashbackPurchaseAmnt;
    }

    public void setCashbackPurchaseAmnt(int cashbackPurchaseAmnt) {
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

    public Double getInterchasngeVat() {
        return interchasngeVat;
    }

    public void setInterchasngeVat(Double interchasngeVat) {
        this.interchasngeVat = interchasngeVat;
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

    public String getFeeDataPresent() {
        return feeDataPresent;
    }

    public void setFeeDataPresent(String feeDataPresent) {
        this.feeDataPresent = feeDataPresent;
    }

    public String getSarbBilling() {
        return sarbBilling;
    }

    public void setSarbBilling(String sarbBilling) {
        this.sarbBilling = sarbBilling;
    }

    public String getPosEntryModeIn() {
        return posEntryModeIn;
    }

    public void setPosEntryModeIn(String posEntryModeIn) {
        this.posEntryModeIn = posEntryModeIn;
    }

    public String getTerminalCapabilityIn() {
        return terminalCapabilityIn;
    }

    public void setTerminalCapabilityIn(String terminalCapabilityIn) {
        this.terminalCapabilityIn = terminalCapabilityIn;
    }

    public String getECommIndIn() {
        return eCommIndIn;
    }

    public void setECommIndIn(String eCommIndIn) {
        this.eCommIndIn = eCommIndIn;
    }

    public String getCardholderIndIn() {
        return cardholderIndIn;
    }

    public void setCardholderIndIn(String cardholderIndIn) {
        this.cardholderIndIn = cardholderIndIn;
    }
    
    

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(fileRefNumber);
        builder.append(systemGenSeqNumber);
        builder.append(service);
        builder.append(subService);
        builder.append(acquierMember);
        builder.append(issuerMember);
        builder.append(accountNumber);
        builder.append(visaAmount);
        builder.append(financialIndicator);
        builder.append(transactionCode);
        builder.append(transactionCodeQualifier);
        builder.append(transactionCodeNumber);
        builder.append(inputSeqNumber);
        builder.append(cardTransaction);
        builder.append(processStatus);
        builder.append(inputFileIdentifier);
        builder.append(settlementDate);
        builder.append(outputDate);
        builder.append(exchangeRate);
        builder.append(acquierCountryCode);
        builder.append(issuerCountryCode);
        builder.append(xborderCountryCode);
        builder.append(xborderIssuerMember);
        builder.append(cardType);
        builder.append(filenameDescription);
        builder.append(cashbackPurchase);
        builder.append(cashbackPurchaseAmnt);
        return builder.toString();
    }

}

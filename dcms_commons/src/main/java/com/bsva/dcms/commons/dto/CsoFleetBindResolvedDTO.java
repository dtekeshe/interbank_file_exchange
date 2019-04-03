package com.bsva.dcms.commons.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 * 
* Created By BSVATools
 */
public class CsoFleetBindResolvedDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private short iss;
    private short acq;
    private String accNo;
    private short txCde;
    private BigDecimal amount;
    private long txDateTime;
    private String service;
    private String subService;
    private short cardType;
    private String product;
    private String subProduct;
    private short txCnt;
    private long acquirerBin;
    private long issuerBin;
    private Date processDate;
    private long fileSystemSeqNumber;
    private long tranSystemSeqNumber;

    

    public String getAccNo() {
        return this.accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    
    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getTxDateTime() {
        return this.txDateTime;
    }

    public void setTxDateTime(long txDateTime) {
        this.txDateTime = txDateTime;
    }

    public String getService() {
        return this.service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSubService() {
        return this.subService;
    }

    public void setSubService(String subService) {
        this.subService = subService;
    }   

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSubProduct() {
        return this.subProduct;
    }

    public void setSubProduct(String subProduct) {
        this.subProduct = subProduct;
    }

    public long getIssuerBin() {
        return issuerBin;
    }

    public void setIssuerBin(long issuerBin) {
        this.issuerBin = issuerBin;
    }

    public long getAcquirerBin() {
        return this.acquirerBin;
    }

    public void setAcquirerBin(long acquirerBin) {
        this.acquirerBin = acquirerBin;
    }

    public Date getProcessDate() {
        return this.processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public long getFileSystemSeqNumber() {
        return this.fileSystemSeqNumber;
    }

    public void setFileSystemSeqNumber(long fileSystemSeqNumber) {
        this.fileSystemSeqNumber = fileSystemSeqNumber;
    }

    public long getTranSystemSeqNumber() {
        return this.tranSystemSeqNumber;
    }

    public void setTranSystemSeqNumber(long tranSystemSeqNumber) {
        this.tranSystemSeqNumber = tranSystemSeqNumber;
    }

    public short getIss() {
        return iss;
    }

    public void setIss(short iss) {
        this.iss = iss;
    }

    public short getAcq() {
        return acq;
    }

    public void setAcq(short acq) {
        this.acq = acq;
    }

    public short getTxCde() {
        return txCde;
    }

    public void setTxCde(short txCde) {
        this.txCde = txCde;
    }

    public short getCardType() {
        return cardType;
    }

    public void setCardType(short cardType) {
        this.cardType = cardType;
    }

    public short getTxCnt() {
        return txCnt;
    }

    public void setTxCnt(short txCnt) {
        this.txCnt = txCnt;
    }
    
    

}

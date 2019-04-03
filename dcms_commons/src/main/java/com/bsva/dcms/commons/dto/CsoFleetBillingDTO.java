package com.bsva.dcms.commons.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class CsoFleetBillingDTO implements Serializable {

    private short iss;
    private short acq;
    private short txCde;
    private long txDateTime;
    private String service;
    private String subService;
    private String accNo;
    private BigDecimal amount;
    private long acqRefNo;
    private int cardType;
    private String product;
    private String subProduct;
    private Short txCnt;
    private long fileRefNumber;
    private long tranSystemSeqNumber;

    public CsoFleetBillingDTO() {

    }

    public short getIss() {
        return iss;
    }

    public short getAcq() {
        return acq;
    }

    public short getTxCde() {
        return txCde;
    }

    public long getTxDateTime() {
        return txDateTime;
    }

    public String getService() {
        return service;
    }

    public String getSubService() {
        return subService;
    }

    public String getAccNo() {
        return accNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public long getAcqRefNo() {
        return acqRefNo;
    }

    public int getCardType() {
        return cardType;
    }

    public String getProduct() {
        return product;
    }

    public String getSubProduct() {
        return subProduct;
    }

    public Short getTxCnt() {
        return txCnt;
    }

    public long getFileRefNumber() {
        return fileRefNumber;
    }

    public void setIss(short iss) {
        this.iss = iss;
    }

    public void setAcq(short acq) {
        this.acq = acq;
    }

    public void setTxCde(short txCde) {
        this.txCde = txCde;
    }

    public void setTxDateTime(long txDateTime) {
        this.txDateTime = txDateTime;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setSubService(String subService) {
        this.subService = subService;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setAcqRefNo(long acqRefNo) {
        this.acqRefNo = acqRefNo;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setSubProduct(String subProduct) {
        this.subProduct = subProduct;
    }

    public void setTxCnt(Short txCnt) {
        this.txCnt = txCnt;
    }

    public void setFileRefNumber(long fileRefNumber) {
        this.fileRefNumber = fileRefNumber;
    }

    public long getTranSystemSeqNumber() {
        return tranSystemSeqNumber;
    }

    public void setTranSystemSeqNumber(long tranSystemSeqNumber) {
        this.tranSystemSeqNumber = tranSystemSeqNumber;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoFleetBillingDTO)) {
            return false;
        }
        CsoFleetBillingDTO other = (CsoFleetBillingDTO) object;
        if (!(this.txDateTime == other.txDateTime)) {
            return false;
        }
        return true;
    }

}

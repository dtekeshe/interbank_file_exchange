package com.bsva.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSO_FLEET_BILLING")
@NamedQueries({
    @NamedQuery(name = "CsoFleetBilling.findAll", query = "SELECT c FROM CsoFleetBilling c"),
    @NamedQuery(name = "CsoFleetBilling.findByIss", query = "SELECT c FROM CsoFleetBilling c WHERE c.iss = :iss"),
    @NamedQuery(name = "CsoFleetBilling.findByAcq", query = "SELECT c FROM CsoFleetBilling c WHERE c.acq = :acq"),
    @NamedQuery(name = "CsoFleetBilling.findByAccNo", query = "SELECT c FROM CsoFleetBilling c WHERE c.accNo = :accNo"),
    @NamedQuery(name = "CsoFleetBilling.findByTxCde", query = "SELECT c FROM CsoFleetBilling c WHERE c.txCde = :txCde"),
    @NamedQuery(name = "CsoFleetBilling.findByAmount", query = "SELECT c FROM CsoFleetBilling c WHERE c.amount = :amount"),
    @NamedQuery(name = "CsoFleetBilling.findByTxDateTime", query = "SELECT c FROM CsoFleetBilling c WHERE c.txDateTime = :txDateTime"),
    @NamedQuery(name = "CsoFleetBilling.findByAcqRefNo", query = "SELECT c FROM CsoFleetBilling c WHERE c.acqRefNo = :acqRefNo"),
    @NamedQuery(name = "CsoFleetBilling.findByService", query = "SELECT c FROM CsoFleetBilling c WHERE c.service = :service"),
    @NamedQuery(name = "CsoFleetBilling.findBySubService", query = "SELECT c FROM CsoFleetBilling c WHERE c.subService = :subService"),
    @NamedQuery(name = "CsoFleetBilling.findByCardType", query = "SELECT c FROM CsoFleetBilling c WHERE c.cardType = :cardType"),
    @NamedQuery(name = "CsoFleetBilling.findByProduct", query = "SELECT c FROM CsoFleetBilling c WHERE c.product = :product"),
    @NamedQuery(name = "CsoFleetBilling.findBySubProduct", query = "SELECT c FROM CsoFleetBilling c WHERE c.subProduct = :subProduct"),
    @NamedQuery(name = "CsoFleetBilling.findByTxCnt", query = "SELECT c FROM CsoFleetBilling c WHERE c.txCnt = :txCnt"),
    @NamedQuery(name = "CsoFleetBilling.findByFileRefNumber", query = "SELECT c FROM CsoFleetBilling c WHERE c.fileRefNumber = :fileRefNumber")})
@DynamicUpdate
public class CsoFleetBilling implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISS")
    private short iss;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACQ")
    private short acq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 19)
    @Column(name = "ACC_NO")
    private String accNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TX_CDE")
    private short txCde;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TX_DATE_TIME")
    private long txDateTime;
    @Column(name = "ACQ_REF_NO")
    private long acqRefNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "SERVICE")
    private String service;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SUB_SERVICE")
    private String subService;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CARD_TYPE")
    private int cardType;
    @Size(max = 1)
    @Column(name = "PRODUCT")
    private String product;
    @Size(max = 2)
    @Column(name = "SUB_PRODUCT")
    private String subProduct;
    @Column(name = "TX_CNT")
    private Short txCnt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FILE_REF_NUMBER")
    private long fileRefNumber;
    @Id
    @Column(name = "TRAN_SYSTEM_SEQ_NUMBER")
    private long tranSystemSeqNumber;

   

	public CsoFleetBilling() {
    }

    public CsoFleetBilling(long acqRefNo) {
        this.acqRefNo = acqRefNo;
    }

    public CsoFleetBilling(long acqRefNo, short iss, short acq, String accNo, short txCde, BigDecimal amount, long txDateTime, String service, String subService, int cardType, long fileRefNumber,long tranSystemSeqNumber) {
        this.acqRefNo = acqRefNo;
        this.iss = iss;
        this.acq = acq;
        this.accNo = accNo;
        this.txCde = txCde;
        this.amount = amount;
        this.txDateTime = txDateTime;
        this.service = service;
        this.subService = subService;
        this.cardType = cardType;
        this.fileRefNumber = fileRefNumber;
        this.tranSystemSeqNumber = tranSystemSeqNumber;
    }
    
    public long getTranSystemSeqNumber() {
		return tranSystemSeqNumber;
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

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public short getTxCde() {
        return txCde;
    }

    public void setTxCde(short txCde) {
        this.txCde = txCde;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getTxDateTime() {
        return txDateTime;
    }

    public void setTxDateTime(long txDateTime) {
        this.txDateTime = txDateTime;
    }

    public long getAcqRefNo() {
        return acqRefNo;
    }

    public void setAcqRefNo(long acqRefNo) {
        this.acqRefNo = acqRefNo;
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

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(String subProduct) {
        this.subProduct = subProduct;
    }

    public Short getTxCnt() {
        return txCnt;
    }

    public void setTxCnt(Short txCnt) {
        this.txCnt = txCnt;
    }

    public long getFileRefNumber() {
        return fileRefNumber;
    }

    public void setFileRefNumber(long fileRefNumber) {
        this.fileRefNumber = fileRefNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acqRefNo != 0 ? 0 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoFleetBilling)) {
            return false;
        }
        CsoFleetBilling other = (CsoFleetBilling) object;
        if ((this.acqRefNo > 0 && other.acqRefNo != 0)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.entities.CsoFleetBilling[ acqRefNo=" + acqRefNo + " ]";
    }
    
}

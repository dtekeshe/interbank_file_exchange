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
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSO_FLEET_BIND_RESOLVED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsoFleetBindResolved.findAll", query = "SELECT c FROM CsoFleetBindResolved c"),
    @NamedQuery(name = "CsoFleetBindResolved.findByIss", query = "SELECT c FROM CsoFleetBindResolved c WHERE c.csoFleetBindResolvedPK.iss = :iss"),
    @NamedQuery(name = "CsoFleetBindResolved.findByAcq", query = "SELECT c FROM CsoFleetBindResolved c WHERE c.csoFleetBindResolvedPK.acq = :acq"),
    @NamedQuery(name = "CsoFleetBindResolved.findByAccNo", query = "SELECT c FROM CsoFleetBindResolved c WHERE c.accNo = :accNo"),
    @NamedQuery(name = "CsoFleetBindResolved.findByTxCde", query = "SELECT c FROM CsoFleetBindResolved c WHERE c.csoFleetBindResolvedPK.txCde = :txCde"),
    @NamedQuery(name = "CsoFleetBindResolved.findByAmount", query = "SELECT c FROM CsoFleetBindResolved c WHERE c.amount = :amount"),
    @NamedQuery(name = "CsoFleetBindResolved.findByTxDateTime", query = "SELECT c FROM CsoFleetBindResolved c WHERE c.csoFleetBindResolvedPK.txDateTime = :txDateTime"),
    @NamedQuery(name = "CsoFleetBindResolved.findByService", query = "SELECT c FROM CsoFleetBindResolved c WHERE c.csoFleetBindResolvedPK.service = :service"),
    @NamedQuery(name = "CsoFleetBindResolved.findBySubService", query = "SELECT c FROM CsoFleetBindResolved c WHERE c.csoFleetBindResolvedPK.subService = :subService"),
    @NamedQuery(name = "CsoFleetBindResolved.findByCardType", query = "SELECT c FROM CsoFleetBindResolved c WHERE c.cardType = :cardType"),
    @NamedQuery(name = "CsoFleetBindResolved.findByProduct", query = "SELECT c FROM CsoFleetBindResolved c WHERE c.product = :product"),
    @NamedQuery(name = "CsoFleetBindResolved.findBySubProduct", query = "SELECT c FROM CsoFleetBindResolved c WHERE c.subProduct = :subProduct"),
    @NamedQuery(name = "CsoFleetBindResolved.findByTxCnt", query = "SELECT c FROM CsoFleetBindResolved c WHERE c.txCnt = :txCnt"),
    @NamedQuery(name = "CsoFleetBindResolved.findByAcquirerBin", query = "SELECT c FROM CsoFleetBindResolved c WHERE c.acquirerBin = :acquirerBin"),
    @NamedQuery(name = "CsoFleetBindResolved.findByProcessDate", query = "SELECT c FROM CsoFleetBindResolved c WHERE c.processDate = :processDate"),
    @NamedQuery(name = "CsoFleetBindResolved.findByFileSystemSeqNumber", query = "SELECT c FROM CsoFleetBindResolved c WHERE c.fileSystemSeqNumber = :fileSystemSeqNumber"),
    @NamedQuery(name = "CsoFleetBindResolved.findByTranSystemSeqNumber", query = "SELECT c FROM CsoFleetBindResolved c WHERE c.tranSystemSeqNumber = :tranSystemSeqNumber"),
    @NamedQuery(name = "CsoFleetBindResolved.findByIssuerBin", query = "SELECT c FROM CsoFleetBindResolved c WHERE c.issuerBin = :issuerBin")}) 
@DynamicUpdate
public class CsoFleetBindResolved implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsoFleetBindResolvedPK csoFleetBindResolvedPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 19)
    @Column(name = "ACC_NO")
    private String accNo;
    //@Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CARD_TYPE")
    private short cardType;
    @Size(max = 1)
    @Column(name = "PRODUCT")
    private String product;
    @Size(max = 2)
    @Column(name = "SUB_PRODUCT")
    private String subProduct;
    @Column(name = "TX_CNT")
    private short txCnt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACQUIRER_BIN")
    private long acquirerBin;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "PROCESS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date processDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FILE_SYSTEM_SEQ_NUMBER")
    private long fileSystemSeqNumber;
    @Column(name = "TRAN_SYSTEM_SEQ_NUMBER")
    private long tranSystemSeqNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISSUER_BIN")
    private long issuerBin;

    public CsoFleetBindResolved() {
    }

    public CsoFleetBindResolved(CsoFleetBindResolvedPK csoFleetBindResolvedPK) {
        this.csoFleetBindResolvedPK = csoFleetBindResolvedPK;
    }

    public CsoFleetBindResolved(CsoFleetBindResolvedPK csoFleetBindResolvedPK, String accNo, BigDecimal amount, short cardType, long acquirerBin, Date processDate, long fileSystemSeqNumber) {
        this.csoFleetBindResolvedPK = csoFleetBindResolvedPK;
        this.accNo = accNo;
        this.amount = amount;
        this.cardType = cardType;
        this.acquirerBin = acquirerBin;
        this.processDate = processDate;
        this.fileSystemSeqNumber = fileSystemSeqNumber;
    }

    public CsoFleetBindResolved(short iss, short acq, short txCde, long txDateTime, String service, String subService) {
        this.csoFleetBindResolvedPK = new CsoFleetBindResolvedPK(iss, acq, txCde, txDateTime, service, subService);
    }

    public CsoFleetBindResolvedPK getCsoFleetBindResolvedPK() {
        return csoFleetBindResolvedPK;
    }

    public void setCsoFleetBindResolvedPK(CsoFleetBindResolvedPK csoFleetBindResolvedPK) {
        this.csoFleetBindResolvedPK = csoFleetBindResolvedPK;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public short getCardType() {
        return cardType;
    }

    public void setCardType(short cardType) {
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

    public short getTxCnt() {
        return txCnt;
    }

    public void setTxCnt(short txCnt) {
        this.txCnt = txCnt;
    }

    public long getAcquirerBin() {
        return acquirerBin;
    }

    public void setAcquirerBin(long acquirerBin) {
        this.acquirerBin = acquirerBin;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public long getFileSystemSeqNumber() {
        return fileSystemSeqNumber;
    }

    public void setFileSystemSeqNumber(long fileSystemSeqNumber) {
        this.fileSystemSeqNumber = fileSystemSeqNumber;
    }

    public long getTranSystemSeqNumber() {
        return tranSystemSeqNumber;
    }

    public void setTranSystemSeqNumber(long tranSystemSeqNumber) {
        this.tranSystemSeqNumber = tranSystemSeqNumber;
    }

    public long getIssuerBin() {
        return issuerBin;
    }

    public void setIssuerBin(long issuerBin) {
        this.issuerBin = issuerBin;
    }
        

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csoFleetBindResolvedPK != null ? csoFleetBindResolvedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoFleetBindResolved)) {
            return false;
        }
        CsoFleetBindResolved other = (CsoFleetBindResolved) object;
        if ((this.csoFleetBindResolvedPK == null && other.csoFleetBindResolvedPK != null) || (this.csoFleetBindResolvedPK != null && !this.csoFleetBindResolvedPK.equals(other.csoFleetBindResolvedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.entities.CsoFleetBindResolved[ csoFleetBindResolvedPK=" + csoFleetBindResolvedPK + " ]";
    }
    
}

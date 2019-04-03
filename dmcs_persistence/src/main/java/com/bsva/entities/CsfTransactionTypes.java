package com.bsva.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author SimphiweT
 */
@Entity
@Table(name = "csf_transaction_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsfTransactionTypes.findAll", query = "SELECT c FROM CsfTransactionTypes c"),
    @NamedQuery(name = "CsfTransactionTypes.findByTransactionCode", query = "SELECT c FROM CsfTransactionTypes c WHERE c.transactionCode = :transactionCode"),
    @NamedQuery(name = "CsfTransactionTypes.findByCreatedBy", query = "SELECT c FROM CsfTransactionTypes c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CsfTransactionTypes.findByCreatedDate", query = "SELECT c FROM CsfTransactionTypes c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "CsfTransactionTypes.findByFinancialInd", query = "SELECT c FROM CsfTransactionTypes c WHERE c.financialInd = :financialInd"),
    @NamedQuery(name = "CsfTransactionTypes.findByModifiedBy", query = "SELECT c FROM CsfTransactionTypes c WHERE c.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "CsfTransactionTypes.findByModifiedDate", query = "SELECT c FROM CsfTransactionTypes c WHERE c.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "CsfTransactionTypes.findByReportSortSequence", query = "SELECT c FROM CsfTransactionTypes c WHERE c.reportSortSequence = :reportSortSequence"),
    @NamedQuery(name = "CsfTransactionTypes.findByTransactionDescription", query = "SELECT c FROM CsfTransactionTypes c WHERE c.transactionDescription = :transactionDescription")})
@DynamicUpdate
public class CsfTransactionTypes implements Serializable {
    @Column(name = "AMOUNT_DIRECTION")
    private Integer amountDirection;
    @Column(name = "FEE_DIRECTION")
    private Integer feeDirection;
    @Column(name = "VAT_DIRECTION")
    private Integer vatDirection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TRANSACTION_CODE")
    private Short transactionCode;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "FINANCIAL_IND")
    private String financialInd;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Basic(optional = false)
    @Column(name = "REPORT_SORT_SEQUENCE")
    private short reportSortSequence;
    @Column(name = "TRANSACTION_DESCRIPTION")
    private String transactionDescription;

    public CsfTransactionTypes() {
    }

    public CsfTransactionTypes(Short transactionCode) {
        this.transactionCode = transactionCode;
    }

    public CsfTransactionTypes(Short transactionCode, short reportSortSequence) {
        this.transactionCode = transactionCode;
        this.reportSortSequence = reportSortSequence;
    }

    public Short getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(Short transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getFinancialInd() {
        return financialInd;
    }

    public void setFinancialInd(String financialInd) {
        this.financialInd = financialInd;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public short getReportSortSequence() {
        return reportSortSequence;
    }

    public void setReportSortSequence(short reportSortSequence) {
        this.reportSortSequence = reportSortSequence;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionCode != null ? transactionCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfTransactionTypes)) {
            return false;
        }
        CsfTransactionTypes other = (CsfTransactionTypes) object;
        if ((this.transactionCode == null && other.transactionCode != null) || (this.transactionCode != null && !this.transactionCode.equals(other.transactionCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.dmcs.dmcs_entities.CsfTransactionTypes[ transactionCode=" + transactionCode + " ]";
    }

    public Integer getAmountDirection() {
        return amountDirection;
    }

    public void setAmountDirection(Integer amountDirection) {
        this.amountDirection = amountDirection;
    }

    public Integer getFeeDirection() {
        return feeDirection;
    }

    public void setFeeDirection(Integer feeDirection) {
        this.feeDirection = feeDirection;
    }

    public Integer getVatDirection() {
        return vatDirection;
    }

    public void setVatDirection(Integer vatDirection) {
        this.vatDirection = vatDirection;
    }       
}

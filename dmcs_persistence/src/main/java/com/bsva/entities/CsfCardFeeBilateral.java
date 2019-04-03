package com.bsva.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CSF_CARD_FEE_BILATERAL")
@NamedQueries({
    @NamedQuery(name = "CsfCardFeeBilateral.findAll", query = "SELECT c FROM CsfCardFeeBilateral c"),
    @NamedQuery(name = "CsfCardFeeBilateral.findByTransactionCode", query = "SELECT c FROM CsfCardFeeBilateral c WHERE c.csfCardFeeBilateralPK.transactionCode = :transactionCode"),
    @NamedQuery(name = "CsfCardFeeBilateral.findByInterchangeFee", query = "SELECT c FROM CsfCardFeeBilateral c WHERE c.interchangeFee = :interchangeFee"),
    @NamedQuery(name = "CsfCardFeeBilateral.findByInterchangeFeeAmount", query = "SELECT c FROM CsfCardFeeBilateral c WHERE c.interchangeFeeAmount = :interchangeFeeAmount"),
    @NamedQuery(name = "CsfCardFeeBilateral.findByInputVat", query = "SELECT c FROM CsfCardFeeBilateral c WHERE c.inputVat = :inputVat"),
    @NamedQuery(name = "CsfCardFeeBilateral.findByBillIndicator", query = "SELECT c FROM CsfCardFeeBilateral c WHERE c.billIndicator = :billIndicator"),
    @NamedQuery(name = "CsfCardFeeBilateral.findByActiveIndicator", query = "SELECT c FROM CsfCardFeeBilateral c WHERE c.activeIndicator = :activeIndicator"),
    @NamedQuery(name = "CsfCardFeeBilateral.findByCreatedBy", query = "SELECT c FROM CsfCardFeeBilateral c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CsfCardFeeBilateral.findByCreatedDate", query = "SELECT c FROM CsfCardFeeBilateral c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "CsfCardFeeBilateral.findByModifiedBy", query = "SELECT c FROM CsfCardFeeBilateral c WHERE c.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "CsfCardFeeBilateral.findByModifiedDate", query = "SELECT c FROM CsfCardFeeBilateral c WHERE c.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "CsfCardFeeBilateral.findByCountryCode", query = "SELECT c FROM CsfCardFeeBilateral c WHERE c.countryCode = :countryCode"),
    @NamedQuery(name = "CsfCardFeeBilateral.findByIssuingMember", query = "SELECT c FROM CsfCardFeeBilateral c WHERE c.csfCardFeeBilateralPK.issuingMember = :issuingMember"),
    @NamedQuery(name = "CsfCardFeeBilateral.findByAcquiringMember", query = "SELECT c FROM CsfCardFeeBilateral c WHERE c.csfCardFeeBilateralPK.acquiringMember = :acquiringMember"),
    @NamedQuery(name = "CsfCardFeeBilateral.findByAmountDirection", query = "SELECT c FROM CsfCardFeeBilateral c WHERE c.amountDirection = :amountDirection"),        
    //@NamedQuery(name = "CsfCardFeeBilateral.findForCsfCardFeeBilateralDAO", query = "SELECT c FROM CsfCardFeeBilateral c WHERE  c.csfCardFeeBilateralPK.transactionCode = :transactionCode  AND " + "c.csfCardFeeBilateralPK.issuingMember = :issuingMember AND " + "c.csfCardFeeBilateralPK.acquiringMember = :acquiringMember " + "c.cardType = :cardType"),		
    @NamedQuery(name = "CsfCardFeeBilateral.findByDestReport", query = "SELECT c FROM CsfCardFeeBilateral c WHERE c.destReport = :destReport")})
@DynamicUpdate
public class CsfCardFeeBilateral implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsfCardFeeBilateralPK csfCardFeeBilateralPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "INTERCHANGE_FEE")
    private BigDecimal interchangeFee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INTERCHANGE_FEE_AMOUNT")
    private BigDecimal interchangeFeeAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INPUT_VAT")
    private BigDecimal inputVat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "BILL_INDICATOR")
    private String billIndicator;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ACTIVE_INDICATOR")
    private String activeIndicator;
    @Size(max = 30)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 30)
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Size(max = 3)
    @Column(name = "COUNTRY_CODE")
    private String countryCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT_DIRECTION")
    private Short amountDirection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "DEST_REPORT")
    private String destReport;   
    @ManyToOne(optional = false)
    @JoinColumn(name = "CARD_TYPE", referencedColumnName = "CARD_TYPE")    
    private CsfCardTypes cardType;

    public CsfCardFeeBilateral() {
    }

    public CsfCardFeeBilateral(CsfCardFeeBilateralPK csfCardFeeBilateralPK) {
        this.csfCardFeeBilateralPK = csfCardFeeBilateralPK;
    }

    public CsfCardFeeBilateral(CsfCardFeeBilateralPK csfCardFeeBilateralPK, BigDecimal interchangeFee, BigDecimal interchangeFeeAmount, BigDecimal inputVat, String billIndicator, String activeIndicator, Short amountDirection, String destReport) {
        this.csfCardFeeBilateralPK = csfCardFeeBilateralPK;
        this.interchangeFee = interchangeFee;
        this.interchangeFeeAmount = interchangeFeeAmount;
        this.inputVat = inputVat;
        this.billIndicator = billIndicator;
        this.activeIndicator = activeIndicator;
        this.amountDirection = amountDirection;
        this.destReport = destReport;
    }

    public CsfCardFeeBilateral(String transactionCode, String issuingMember, String acquiringMember) {
        this.csfCardFeeBilateralPK = new CsfCardFeeBilateralPK(transactionCode, issuingMember, acquiringMember);
    }

    public CsfCardFeeBilateralPK getCsfCardFeeBilateralPK() {
        return csfCardFeeBilateralPK;
    }

    public void setCsfCardFeeBilateralPK(CsfCardFeeBilateralPK csfCardFeeBilateralPK) {
        this.csfCardFeeBilateralPK = csfCardFeeBilateralPK;
    }

    public BigDecimal getInterchangeFee() {
        return interchangeFee;
    }

    public void setInterchangeFee(BigDecimal interchangeFee) {
        this.interchangeFee = interchangeFee;
    }

    public BigDecimal getInterchangeFeeAmount() {
        return interchangeFeeAmount;
    }

    public void setInterchangeFeeAmount(BigDecimal interchangeFeeAmount) {
        this.interchangeFeeAmount = interchangeFeeAmount;
    }

    public BigDecimal getInputVat() {
        return inputVat;
    }

    public void setInputVat(BigDecimal inputVat) {
        this.inputVat = inputVat;
    }

    public String getBillIndicator() {
        return billIndicator;
    }

    public void setBillIndicator(String billIndicator) {
        this.billIndicator = billIndicator;
    }

    public String getActiveIndicator() {
        return activeIndicator;
    }

    public void setActiveIndicator(String activeIndicator) {
        this.activeIndicator = activeIndicator;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Short getAmountDirection() {
        return amountDirection;
    }

    public void setAmountDirection(Short amountDirection) {
        this.amountDirection = amountDirection;
    }

    public String getDestReport() {
        return destReport;
    }

    public void setDestReport(String destReport) {
        this.destReport = destReport;
    }

   /* public byte[] getCsfmember2() {
        return csfmember2;
    }

    public void setCsfmember2(byte[] csfmember2) {
        this.csfmember2 = csfmember2;
    }

    public CsfTransactionTypes getTransactionCode1() {
        return transactionCode1;
    }

    public void setTransactionCode1(CsfTransactionTypes transactionCode1) {
        this.transactionCode1 = transactionCode1;
    }

    public CsfTransactionTypes getCsfTransactionTypes() {
        return csfTransactionTypes;
    }

    public void setCsfTransactionTypes(CsfTransactionTypes csfTransactionTypes) {
        this.csfTransactionTypes = csfTransactionTypes;
    }

    public CsfMembers getCsfMembers() {
        return csfMembers;
    }

    public void setCsfMembers(CsfMembers csfMembers) {
        this.csfMembers = csfMembers;
    }

    public CsfMembers getCsfMembers1() {
        return csfMembers1;
    }

    public void setCsfMembers1(CsfMembers csfMembers1) {
        this.csfMembers1 = csfMembers1;
    }

    public CsfMembers getAcquiringMember2() {
        return acquiringMember2;
    }

    public void setAcquiringMember2(CsfMembers acquiringMember2) {
        this.acquiringMember2 = acquiringMember2;
    }

    public CsfMembers getIssuingMember1() {
        return issuingMember1;
    }

    public void setIssuingMember1(CsfMembers issuingMember1) {
        this.issuingMember1 = issuingMember1;
    }*/

    public CsfCardTypes getCardType() {
        return cardType;
    }

    public void setCardType(CsfCardTypes cardType) {
        this.cardType = cardType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csfCardFeeBilateralPK != null ? csfCardFeeBilateralPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfCardFeeBilateral)) {
            return false;
        }
        CsfCardFeeBilateral other = (CsfCardFeeBilateral) object;
        if ((this.csfCardFeeBilateralPK == null && other.csfCardFeeBilateralPK != null) || (this.csfCardFeeBilateralPK != null && !this.csfCardFeeBilateralPK.equals(other.csfCardFeeBilateralPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfCardFeeBilateral[ csfCardFeeBilateralPK=" + csfCardFeeBilateralPK + " ]";
    }
    
}

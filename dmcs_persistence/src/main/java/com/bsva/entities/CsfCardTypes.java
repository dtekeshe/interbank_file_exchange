/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "CSF_CARD_TYPES")
@NamedQueries({
    @NamedQuery(name = "CsfCardTypes.findAll", query = "SELECT c FROM CsfCardTypes c"),
    @NamedQuery(name = "CsfCardTypes.findByCardType", query = "SELECT c FROM CsfCardTypes c WHERE c.cardType = :cardType"),
    @NamedQuery(name = "CsfCardTypes.findByCardDescription", query = "SELECT c FROM CsfCardTypes c WHERE c.cardDescription = :cardDescription"),
    @NamedQuery(name = "CsfCardTypes.findByCreatedBy", query = "SELECT c FROM CsfCardTypes c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CsfCardTypes.findByCreatedDate", query = "SELECT c FROM CsfCardTypes c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "CsfCardTypes.findByModifiedBy", query = "SELECT c FROM CsfCardTypes c WHERE c.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "CsfCardTypes.findByModifiedDate", query = "SELECT c FROM CsfCardTypes c WHERE c.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "CsfCardTypes.findBySubService", query = "SELECT c FROM CsfCardTypes c WHERE c.subService = :subService"),
    @NamedQuery(name = "CsfCardTypes.findByPasaPaymentLimit", query = "SELECT c FROM CsfCardTypes c WHERE c.pasaPaymentLimit = :pasaPaymentLimit")})
@DynamicUpdate
public class CsfCardTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CARD_TYPE")
    private Short cardType;
    @Size(max = 30)
    @Column(name = "CARD_DESCRIPTION")
    private String cardDescription;
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
    @Size(max = 10)
    @Column(name = "SUB_SERVICE")
    private String subService;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PASA_PAYMENT_LIMIT")
    private BigDecimal pasaPaymentLimit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardType")
    private List<CsfCardFeeBilateral> csfCardFeeBilateralList = new ArrayList<>(0);

    public CsfCardTypes() {
    }

    public CsfCardTypes(Short cardType) {
        this.cardType = cardType;
    }

    public CsfCardTypes(Short cardType, BigDecimal pasaPaymentLimit) {
        this.cardType = cardType;
        this.pasaPaymentLimit = pasaPaymentLimit;
    }

    public Short getCardType() {
        return cardType;
    }

    public void setCardType(Short cardType) {
        this.cardType = cardType;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
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

    public String getSubService() {
        return subService;
    }

    public void setSubService(String subService) {
        this.subService = subService;
    }

    public BigDecimal getPasaPaymentLimit() {
        return pasaPaymentLimit;
    }

    public void setPasaPaymentLimit(BigDecimal pasaPaymentLimit) {
        this.pasaPaymentLimit = pasaPaymentLimit;
    }

    public List<CsfCardFeeBilateral> getCsfCardFeeBilateralList() {
        return csfCardFeeBilateralList;
    }

    public void setCsfCardFeeBilateralList(List<CsfCardFeeBilateral> csfCardFeeBilateralList) {
        this.csfCardFeeBilateralList = csfCardFeeBilateralList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardType != null ? cardType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfCardTypes)) {
            return false;
        }
        CsfCardTypes other = (CsfCardTypes) object;
        if ((this.cardType == null && other.cardType != null) || (this.cardType != null && !this.cardType.equals(other.cardType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfCardTypes[ cardType=" + cardType + " ]";
    }
    
}

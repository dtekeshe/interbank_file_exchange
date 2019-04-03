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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CIS_BINS")
@NamedQueries({
    @NamedQuery(name = "CisBins.findAll", query = "SELECT c FROM CisBins c"),
    @NamedQuery(name = "CisBins.findByBinNo", query = "SELECT c FROM CisBins c WHERE c.binNo = :binNo"),
    @NamedQuery(name = "CisBins.findByBinDescription", query = "SELECT c FROM CisBins c WHERE c.binDescription = :binDescription"),
    @NamedQuery(name = "CisBins.findByBankCode", query = "SELECT c FROM CisBins c WHERE c.bankCode = :bankCode"),
    @NamedQuery(name = "CisBins.findByCardType", query = "SELECT c FROM CisBins c WHERE c.cardType = :cardType"),
    @NamedQuery(name = "CisBins.findByLimit1", query = "SELECT c FROM CisBins c WHERE c.limit1 = :limit1"),
    @NamedQuery(name = "CisBins.findByLimit2", query = "SELECT c FROM CisBins c WHERE c.limit2 = :limit2"),
    @NamedQuery(name = "CisBins.findByFloorLimit", query = "SELECT c FROM CisBins c WHERE c.floorLimit = :floorLimit"),
    @NamedQuery(name = "CisBins.findByRouting", query = "SELECT c FROM CisBins c WHERE c.routing = :routing"),
    @NamedQuery(name = "CisBins.findByCreatedBy", query = "SELECT c FROM CisBins c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CisBins.findByCreatedDate", query = "SELECT c FROM CisBins c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "CisBins.findByModifiedBy", query = "SELECT c FROM CisBins c WHERE c.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "CisBins.findByModifiedDate", query = "SELECT c FROM CisBins c WHERE c.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "CisBins.findByDeletionDate", query = "SELECT c FROM CisBins c WHERE c.deletionDate = :deletionDate"),
    @NamedQuery(name = "CisBins.findByCurrencyCode", query = "SELECT c FROM CisBins c WHERE c.currencyCode = :currencyCode"),
    @NamedQuery(name = "CisBins.findBySubService", query = "SELECT c FROM CisBins c WHERE c.subService = :subService"),
    @NamedQuery(name = "CisBins.findByOldCardType", query = "SELECT c FROM CisBins c WHERE c.oldCardType = :oldCardType"),
    @NamedQuery(name = "CisBins.findByFuelAllowed", query = "SELECT c FROM CisBins c WHERE c.fuelAllowed = :fuelAllowed"),
    @NamedQuery(name = "CisBins.findByIssAcqBoth", query = "SELECT c FROM CisBins c WHERE c.issAcqBoth = :issAcqBoth"),
    @NamedQuery(name = "CisBins.findByLiveDate", query = "SELECT c FROM CisBins c WHERE c.liveDate = :liveDate")})
public class CisBins implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "BIN_NO")
    private String binNo;
    @Size(max = 30)
    @Column(name = "BIN_DESCRIPTION")
    private String binDescription;
    @Column(name = "BANK_CODE")
    private Short bankCode;
    @Size(max = 2)
    @Column(name = "CARD_TYPE")
    private String cardType;
    @Column(name = "LIMIT_1")
    private BigDecimal limit1;
    @Column(name = "LIMIT_2")
    private BigDecimal limit2;
    @Column(name = "FLOOR_LIMIT")
    private BigDecimal floorLimit;
    @Column(name = "ROUTING")
    private Short routing;
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
    @Size(max = 8)
    @Column(name = "DELETION_DATE")
    private String deletionDate;
    @Size(max = 3)
    @Column(name = "CURRENCY_CODE")
    private String currencyCode;
    @Size(max = 10)
    @Column(name = "SUB_SERVICE")
    private String subService;
    @Size(max = 2)
    @Column(name = "OLD_CARD_TYPE")
    private String oldCardType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "FUEL_ALLOWED")
    private String fuelAllowed;
    @Size(max = 1)
    @Column(name = "ISS_ACQ_BOTH")
    private String issAcqBoth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LIVE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date liveDate;

    public CisBins() {
    }

    public CisBins(String binNo) {
        this.binNo = binNo;
    }

    public CisBins(String binNo, String fuelAllowed, Date liveDate) {
        this.binNo = binNo;
        this.fuelAllowed = fuelAllowed;
        this.liveDate = liveDate;
    }

    public String getBinNo() {
        return binNo;
    }

    public void setBinNo(String binNo) {
        this.binNo = binNo;
    }

    public String getBinDescription() {
        return binDescription;
    }

    public void setBinDescription(String binDescription) {
        this.binDescription = binDescription;
    }

    public Short getBankCode() {
        return bankCode;
    }

    public void setBankCode(Short bankCode) {
        this.bankCode = bankCode;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public BigDecimal getLimit1() {
        return limit1;
    }

    public void setLimit1(BigDecimal limit1) {
        this.limit1 = limit1;
    }

    public BigDecimal getLimit2() {
        return limit2;
    }

    public void setLimit2(BigDecimal limit2) {
        this.limit2 = limit2;
    }

    public BigDecimal getFloorLimit() {
        return floorLimit;
    }

    public void setFloorLimit(BigDecimal floorLimit) {
        this.floorLimit = floorLimit;
    }

    public Short getRouting() {
        return routing;
    }

    public void setRouting(Short routing) {
        this.routing = routing;
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

    public String getDeletionDate() {
        return deletionDate;
    }

    public void setDeletionDate(String deletionDate) {
        this.deletionDate = deletionDate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getSubService() {
        return subService;
    }

    public void setSubService(String subService) {
        this.subService = subService;
    }

    public String getOldCardType() {
        return oldCardType;
    }

    public void setOldCardType(String oldCardType) {
        this.oldCardType = oldCardType;
    }

    public String getFuelAllowed() {
        return fuelAllowed;
    }

    public void setFuelAllowed(String fuelAllowed) {
        this.fuelAllowed = fuelAllowed;
    }

    public String getIssAcqBoth() {
        return issAcqBoth;
    }

    public void setIssAcqBoth(String issAcqBoth) {
        this.issAcqBoth = issAcqBoth;
    }

    public Date getLiveDate() {
        return liveDate;
    }

    public void setLiveDate(Date liveDate) {
        this.liveDate = liveDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (binNo != null ? binNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CisBins)) {
            return false;
        }
        CisBins other = (CisBins) object;
        if ((this.binNo == null && other.binNo != null) || (this.binNo != null && !this.binNo.equals(other.binNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CisBins[ binNo=" + binNo + " ]";
    }
    
}

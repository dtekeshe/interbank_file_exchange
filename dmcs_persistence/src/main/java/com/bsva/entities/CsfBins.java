package com.bsva.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CSF_BINS")
@NamedQueries({
    @NamedQuery(name = "CsfBins.findAll", query = "SELECT c FROM CsfBins c"),
    @NamedQuery(name = "CsfBins.findByBinNo", query = "SELECT c FROM CsfBins c WHERE c.binNo = :binNo"),
    @NamedQuery(name = "CsfBins.findByBinDescription", query = "SELECT c FROM CsfBins c WHERE c.binDescription = :binDescription"),
    @NamedQuery(name = "CsfBins.findByCardType", query = "SELECT c FROM CsfBins c WHERE c.cardType = :cardType"),
    @NamedQuery(name = "CsfBins.findByLimit1", query = "SELECT c FROM CsfBins c WHERE c.limit1 = :limit1"),
    @NamedQuery(name = "CsfBins.findByLimit2", query = "SELECT c FROM CsfBins c WHERE c.limit2 = :limit2"),
    @NamedQuery(name = "CsfBins.findByFloorLimit", query = "SELECT c FROM CsfBins c WHERE c.floorLimit = :floorLimit"),
    @NamedQuery(name = "CsfBins.findByRouting", query = "SELECT c FROM CsfBins c WHERE c.routing = :routing"),
    @NamedQuery(name = "CsfBins.findByCreatedBy", query = "SELECT c FROM CsfBins c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CsfBins.findByCreatedDate", query = "SELECT c FROM CsfBins c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "CsfBins.findByModifiedBy", query = "SELECT c FROM CsfBins c WHERE c.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "CsfBins.findByModifiedDate", query = "SELECT c FROM CsfBins c WHERE c.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "CsfBins.findBySubService", query = "SELECT c FROM CsfBins c WHERE c.subService = :subService"),
    @NamedQuery(name = "CsfBins.findByFirstDeletionDate", query = "SELECT c FROM CsfBins c WHERE c.firstDeletionDate = :firstDeletionDate"),
    @NamedQuery(name = "CsfBins.findByDaysBeforefirstDeletionDate", query = "SELECT c FROM CsfBins c WHERE c.daysBeforefirstDeletionDate = :daysBeforefirstDeletionDate"),
    @NamedQuery(name = "CsfBins.findByFinalDeletionDate", query = "SELECT c FROM CsfBins c WHERE c.finalDeletionDate = :finalDeletionDate"),
    @NamedQuery(name = "CsfBins.findByDaysBeforefinalDeletionDate", query = "SELECT c FROM CsfBins c WHERE c.daysBeforefinalDeletionDate = :daysBeforefinalDeletionDate"),
    @NamedQuery(name = "CsfBins.findByActiveInd", query = "SELECT c FROM CsfBins c WHERE c.activeInd = :activeInd"),
    @NamedQuery(name = "CsfBins.findByAcqIssBoth", query = "SELECT c FROM CsfBins c WHERE c.acqIssBoth = :acqIssBoth")})
public class CsfBins implements Serializable {
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
    @Size(max = 2)
    @Column(name = "CARD_TYPE")
    private String cardType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
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
    @Size(max = 1)
    @Column(name = "SUB_SERVICE")
    private String subService;
    @Column(name = "FIRST_DELETION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstDeletionDate;
    @Column(name = "DAYS_BEFOREFIRST_DELETION_DATE")
    private Short daysBeforefirstDeletionDate;
    @Column(name = "FINAL_DELETION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalDeletionDate;
    @Column(name = "DAYS_BEFOREFINAL_DELETION_DATE")
    private Short daysBeforefinalDeletionDate;
    @Size(max = 1)
    @Column(name = "ACTIVE_IND")
    private String activeInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ACQ_ISS_BOTH")
    private String acqIssBoth;
    @ManyToOne
    @JoinColumn(name = "BANK_CODE", referencedColumnName = "BANK_CODE")
    private CsfMembers bankCode;

    public CsfBins() {
    }

    public CsfBins(String binNo) {
        this.binNo = binNo;
    }

    public CsfBins(String binNo, String acqIssBoth) {
        this.binNo = binNo;
        this.acqIssBoth = acqIssBoth;
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

    public String getSubService() {
        return subService;
    }

    public void setSubService(String subService) {
        this.subService = subService;
    }

    public Date getFirstDeletionDate() {
        return firstDeletionDate;
    }

    public void setFirstDeletionDate(Date firstDeletionDate) {
        this.firstDeletionDate = firstDeletionDate;
    }

    public Short getDaysBeforefirstDeletionDate() {
        return daysBeforefirstDeletionDate;
    }

    public void setDaysBeforefirstDeletionDate(Short daysBeforefirstDeletionDate) {
        this.daysBeforefirstDeletionDate = daysBeforefirstDeletionDate;
    }

    public Date getFinalDeletionDate() {
        return finalDeletionDate;
    }

    public void setFinalDeletionDate(Date finalDeletionDate) {
        this.finalDeletionDate = finalDeletionDate;
    }

    public Short getDaysBeforefinalDeletionDate() {
        return daysBeforefinalDeletionDate;
    }

    public void setDaysBeforefinalDeletionDate(Short daysBeforefinalDeletionDate) {
        this.daysBeforefinalDeletionDate = daysBeforefinalDeletionDate;
    }

    public String getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(String activeInd) {
        this.activeInd = activeInd;
    }

    public String getAcqIssBoth() {
        return acqIssBoth;
    }

    public void setAcqIssBoth(String acqIssBoth) {
        this.acqIssBoth = acqIssBoth;
    }

    public CsfMembers getBankCode() {
        return bankCode;
    }

    public void setBankCode(CsfMembers bankCode) {
        this.bankCode = bankCode;
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
        if (!(object instanceof CsfBins)) {
            return false;
        }
        CsfBins other = (CsfBins) object;
        if ((this.binNo == null && other.binNo != null) || (this.binNo != null && !this.binNo.equals(other.binNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfBins[ binNo=" + binNo + " ]";
    }
    
}

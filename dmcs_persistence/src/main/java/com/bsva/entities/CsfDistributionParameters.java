/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
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
@Table(name = "CSF_DISTRIBUTION_PARAMETERS")
@NamedQueries({
    @NamedQuery(name = "CsfDistributionParameters.findAll", query = "SELECT c FROM CsfDistributionParameters c"),
    @NamedQuery(name = "CsfDistributionParameters.findByBankCode", query = "SELECT c FROM CsfDistributionParameters c WHERE c.csfDistributionParametersPK.bankCode = :bankCode"),
    @NamedQuery(name = "CsfDistributionParameters.findByReportName", query = "SELECT c FROM CsfDistributionParameters c WHERE c.csfDistributionParametersPK.reportName = :reportName"),
    @NamedQuery(name = "CsfDistributionParameters.findByMediaType", query = "SELECT c FROM CsfDistributionParameters c WHERE c.mediaType = :mediaType"),
    @NamedQuery(name = "CsfDistributionParameters.findBySubService", query = "SELECT c FROM CsfDistributionParameters c WHERE c.subService = :subService"),
    @NamedQuery(name = "CsfDistributionParameters.findByStatusCode", query = "SELECT c FROM CsfDistributionParameters c WHERE c.statusCode = :statusCode"),
    @NamedQuery(name = "CsfDistributionParameters.findByBankDestination", query = "SELECT c FROM CsfDistributionParameters c WHERE c.bankDestination = :bankDestination"),
    @NamedQuery(name = "CsfDistributionParameters.findByCreatedBy", query = "SELECT c FROM CsfDistributionParameters c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CsfDistributionParameters.findByCreatedDate", query = "SELECT c FROM CsfDistributionParameters c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "CsfDistributionParameters.findByModifiedBy", query = "SELECT c FROM CsfDistributionParameters c WHERE c.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "CsfDistributionParameters.findByModifiedDate", query = "SELECT c FROM CsfDistributionParameters c WHERE c.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "CsfDistributionParameters.findByInwardOutwardInd", query = "SELECT c FROM CsfDistributionParameters c WHERE c.inwardOutwardInd = :inwardOutwardInd")})
@DynamicUpdate
public class CsfDistributionParameters implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsfDistributionParametersPK csfDistributionParametersPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "MEDIA_TYPE")
    private String mediaType;
    @Size(max = 10)
    @Column(name = "SUB_SERVICE")
    private String subService;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STATUS_CODE")
    private String statusCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "BANK_DESTINATION")
    private String bankDestination;
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
    @Column(name = "INWARD_OUTWARD_IND")
    private String inwardOutwardInd;
    @JoinColumn(name = "SERVICE", referencedColumnName = "SERVICE_CODE")
    @ManyToOne
    private CsfSystemService service;

    public CsfDistributionParameters() {
    }

    public CsfDistributionParameters(CsfDistributionParametersPK csfDistributionParametersPK) {
        this.csfDistributionParametersPK = csfDistributionParametersPK;
    }

    public CsfDistributionParameters(CsfDistributionParametersPK csfDistributionParametersPK, String mediaType, String statusCode, String bankDestination) {
        this.csfDistributionParametersPK = csfDistributionParametersPK;
        this.mediaType = mediaType;
        this.statusCode = statusCode;
        this.bankDestination = bankDestination;
    }

    public CsfDistributionParameters(short bankCode, String reportName) {
        this.csfDistributionParametersPK = new CsfDistributionParametersPK(bankCode, reportName);
    }

    public CsfDistributionParametersPK getCsfDistributionParametersPK() {
        return csfDistributionParametersPK;
    }

    public void setCsfDistributionParametersPK(CsfDistributionParametersPK csfDistributionParametersPK) {
        this.csfDistributionParametersPK = csfDistributionParametersPK;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getSubService() {
        return subService;
    }

    public void setSubService(String subService) {
        this.subService = subService;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getBankDestination() {
        return bankDestination;
    }

    public void setBankDestination(String bankDestination) {
        this.bankDestination = bankDestination;
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

    public String getInwardOutwardInd() {
        return inwardOutwardInd;
    }

    public void setInwardOutwardInd(String inwardOutwardInd) {
        this.inwardOutwardInd = inwardOutwardInd;
    }

    public CsfSystemService getService() {
        return service;
    }

    public void setService(CsfSystemService service) {
        this.service = service;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csfDistributionParametersPK != null ? csfDistributionParametersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfDistributionParameters)) {
            return false;
        }
        CsfDistributionParameters other = (CsfDistributionParameters) object;
        if ((this.csfDistributionParametersPK == null && other.csfDistributionParametersPK != null) || (this.csfDistributionParametersPK != null && !this.csfDistributionParametersPK.equals(other.csfDistributionParametersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfDistributionParameters[ csfDistributionParametersPK=" + csfDistributionParametersPK + " ]";
    }
    
}

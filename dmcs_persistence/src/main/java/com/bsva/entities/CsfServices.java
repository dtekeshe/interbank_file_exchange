/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CSF_SERVICES")
@NamedQueries({
    @NamedQuery(name = "CsfServices.findAll", query = "SELECT c FROM CsfServices c"),
    @NamedQuery(name = "CsfServices.findByServiceCode", query = "SELECT c FROM CsfServices c WHERE c.csfServicesPK.serviceCode = :serviceCode"),
    @NamedQuery(name = "CsfServices.findByServiceName", query = "SELECT c FROM CsfServices c WHERE c.csfServicesPK.serviceName = :serviceName"),
    @NamedQuery(name = "CsfServices.findByActiveIndicator", query = "SELECT c FROM CsfServices c WHERE c.activeIndicator = :activeIndicator"),
    @NamedQuery(name = "CsfServices.findByCreatedBy", query = "SELECT c FROM CsfServices c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CsfServices.findByCreatedDate", query = "SELECT c FROM CsfServices c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "CsfServices.findByModifiedBy", query = "SELECT c FROM CsfServices c WHERE c.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "CsfServices.findByModifiedDate", query = "SELECT c FROM CsfServices c WHERE c.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "CsfServices.findByInputSla", query = "SELECT c FROM CsfServices c WHERE c.inputSla = :inputSla"),
    @NamedQuery(name = "CsfServices.findBySettleSla", query = "SELECT c FROM CsfServices c WHERE c.settleSla = :settleSla"),
    @NamedQuery(name = "CsfServices.findByOutputSla", query = "SELECT c FROM CsfServices c WHERE c.outputSla = :outputSla")})
@DynamicUpdate
public class CsfServices implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsfServicesPK csfServicesPK;
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
    @Column(name = "INPUT_SLA")
    private Short inputSla;
    @Column(name = "SETTLE_SLA")
    private Short settleSla;
    @Column(name = "OUTPUT_SLA")
    private Short outputSla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "csfServices")
    private List<CsfMemberService> csfMemberServiceList;
    @OneToMany(mappedBy = "csfServices1")
    private List<CsfMemberService> csfMemberServiceList1;
    @JoinColumn(name = "SERVICE_CODE1", referencedColumnName = "SERVICE_CODE")
    @ManyToOne
    private CsfSystemService serviceCode1;
    @JoinColumn(name = "SERVICE_CODE", referencedColumnName = "SERVICE_CODE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CsfSystemService csfSystemService;

    public CsfServices() {
    }

    public CsfServices(CsfServicesPK csfServicesPK) {
        this.csfServicesPK = csfServicesPK;
    }

    public CsfServices(CsfServicesPK csfServicesPK, String activeIndicator) {
        this.csfServicesPK = csfServicesPK;
        this.activeIndicator = activeIndicator;
    }

    public CsfServices(String serviceCode, String serviceName) {
        this.csfServicesPK = new CsfServicesPK(serviceCode, serviceName);
    }

    public CsfServicesPK getCsfServicesPK() {
        return csfServicesPK;
    }

    public void setCsfServicesPK(CsfServicesPK csfServicesPK) {
        this.csfServicesPK = csfServicesPK;
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

    public Short getInputSla() {
        return inputSla;
    }

    public void setInputSla(Short inputSla) {
        this.inputSla = inputSla;
    }

    public Short getSettleSla() {
        return settleSla;
    }

    public void setSettleSla(Short settleSla) {
        this.settleSla = settleSla;
    }

    public Short getOutputSla() {
        return outputSla;
    }

    public void setOutputSla(Short outputSla) {
        this.outputSla = outputSla;
    }

    public List<CsfMemberService> getCsfMemberServiceList() {
        return csfMemberServiceList;
    }

    public void setCsfMemberServiceList(List<CsfMemberService> csfMemberServiceList) {
        this.csfMemberServiceList = csfMemberServiceList;
    }

    public List<CsfMemberService> getCsfMemberServiceList1() {
        return csfMemberServiceList1;
    }

    public void setCsfMemberServiceList1(List<CsfMemberService> csfMemberServiceList1) {
        this.csfMemberServiceList1 = csfMemberServiceList1;
    }

    public CsfSystemService getServiceCode1() {
        return serviceCode1;
    }

    public void setServiceCode1(CsfSystemService serviceCode1) {
        this.serviceCode1 = serviceCode1;
    }

    public CsfSystemService getCsfSystemService() {
        return csfSystemService;
    }

    public void setCsfSystemService(CsfSystemService csfSystemService) {
        this.csfSystemService = csfSystemService;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csfServicesPK != null ? csfServicesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfServices)) {
            return false;
        }
        CsfServices other = (CsfServices) object;
        if ((this.csfServicesPK == null && other.csfServicesPK != null) || (this.csfServicesPK != null && !this.csfServicesPK.equals(other.csfServicesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfServices[ csfServicesPK=" + csfServicesPK + " ]";
    }
    
}

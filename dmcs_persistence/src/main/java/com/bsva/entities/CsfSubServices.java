/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "CSF_SUB_SERVICES")
@NamedQueries({
    @NamedQuery(name = "CsfSubServices.findAll", query = "SELECT c FROM CsfSubServices c"),
    @NamedQuery(name = "CsfSubServices.findByService", query = "SELECT c FROM CsfSubServices c WHERE c.csfSubServicesPK.service = :service"),
    @NamedQuery(name = "CsfSubServices.findBySubService", query = "SELECT c FROM CsfSubServices c WHERE c.csfSubServicesPK.subService = :subService"),
    @NamedQuery(name = "CsfSubServices.findByActiveIndicator", query = "SELECT c FROM CsfSubServices c WHERE c.activeIndicator = :activeIndicator"),
    @NamedQuery(name = "CsfSubServices.findByPaymentStream", query = "SELECT c FROM CsfSubServices c WHERE c.paymentStream = :paymentStream"),
    @NamedQuery(name = "CsfSubServices.findByDescription", query = "SELECT c FROM CsfSubServices c WHERE c.description = :description"),
    @NamedQuery(name = "CsfSubServices.findByCreatedBy", query = "SELECT c FROM CsfSubServices c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CsfSubServices.findByCreatedDate", query = "SELECT c FROM CsfSubServices c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "CsfSubServices.findByModifiedBy", query = "SELECT c FROM CsfSubServices c WHERE c.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "CsfSubServices.findByModifiedDate", query = "SELECT c FROM CsfSubServices c WHERE c.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "CsfSubServices.findByInputSla", query = "SELECT c FROM CsfSubServices c WHERE c.inputSla = :inputSla"),
    @NamedQuery(name = "CsfSubServices.findBySettleSla", query = "SELECT c FROM CsfSubServices c WHERE c.settleSla = :settleSla"),
    @NamedQuery(name = "CsfSubServices.findByOutputSla", query = "SELECT c FROM CsfSubServices c WHERE c.outputSla = :outputSla"),
    @NamedQuery(name = "CsfSubServices.findByDisplayName", query = "SELECT c FROM CsfSubServices c WHERE c.displayName = :displayName"),
    @NamedQuery(name = "CsfSubServices.findBySettlementName", query = "SELECT c FROM CsfSubServices c WHERE c.settlementName = :settlementName")})
@DynamicUpdate
public class CsfSubServices implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsfSubServicesPK csfSubServicesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ACTIVE_INDICATOR")
    private String activeIndicator;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PAYMENT_STREAM")
    private String paymentStream;
    @Size(max = 30)
    @Column(name = "DESCRIPTION")
    private String description;
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
    @Size(max = 10)
    @Column(name = "DISPLAY_NAME")
    private String displayName;
    @Size(max = 5)
    @Column(name = "SETTLEMENT_NAME")
    private String settlementName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SERVICE1", referencedColumnName = "SERVICE_CODE")    
    private CsfSystemService service1;
   /* @ManyToOne(optional = false)
    @JoinColumn(name = "SERVICE", referencedColumnName = "SERVICE_CODE", insertable = false, updatable = false)    
    private CsfSystemService csfSystemService;
*/
    public CsfSubServices() {
    }

    public CsfSubServices(CsfSubServicesPK csfSubServicesPK) {
        this.csfSubServicesPK = csfSubServicesPK;
    }

    public CsfSubServices(CsfSubServicesPK csfSubServicesPK, String activeIndicator, String paymentStream) {
        this.csfSubServicesPK = csfSubServicesPK;
        this.activeIndicator = activeIndicator;
        this.paymentStream = paymentStream;
    }

    public CsfSubServices(String service, String subService) {
        this.csfSubServicesPK = new CsfSubServicesPK(service, subService);
    }

    public CsfSubServicesPK getCsfSubServicesPK() {
        return csfSubServicesPK;
    }

    public void setCsfSubServicesPK(CsfSubServicesPK csfSubServicesPK) {
        this.csfSubServicesPK = csfSubServicesPK;
    }

    public String getActiveIndicator() {
        return activeIndicator;
    }

    public void setActiveIndicator(String activeIndicator) {
        this.activeIndicator = activeIndicator;
    }

    public String getPaymentStream() {
        return paymentStream;
    }

    public void setPaymentStream(String paymentStream) {
        this.paymentStream = paymentStream;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getSettlementName() {
        return settlementName;
    }

    public void setSettlementName(String settlementName) {
        this.settlementName = settlementName;
    }

    public CsfSystemService getService1() {
        return service1;
    }

    public void setService1(CsfSystemService service1) {
        this.service1 = service1;
    }

    /*public CsfSystemService getCsfSystemService() {
        return csfSystemService;
    }

    public void setCsfSystemService(CsfSystemService csfSystemService) {
        this.csfSystemService = csfSystemService;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csfSubServicesPK != null ? csfSubServicesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfSubServices)) {
            return false;
        }
        CsfSubServices other = (CsfSubServices) object;
        if ((this.csfSubServicesPK == null && other.csfSubServicesPK != null) || (this.csfSubServicesPK != null && !this.csfSubServicesPK.equals(other.csfSubServicesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfSubServices[ csfSubServicesPK=" + csfSubServicesPK + " ]";
    }
    
}

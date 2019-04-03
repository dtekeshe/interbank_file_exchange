/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSO_SYSTEM_CONTROLS")
@NamedQueries({
    @NamedQuery(name = "CsoSystemControls.findAll", query = "SELECT c FROM CsoSystemControls c"),
    @NamedQuery(name = "CsoSystemControls.findByProcessDate", query = "SELECT c FROM CsoSystemControls c WHERE c.csoSystemControlsPK.processDate = :processDate"),
    @NamedQuery(name = "CsoSystemControls.findBySystemFunction", query = "SELECT c FROM CsoSystemControls c WHERE c.csoSystemControlsPK.systemFunction = :systemFunction"),
    @NamedQuery(name = "CsoSystemControls.findByService", query = "SELECT c FROM CsoSystemControls c WHERE c.csoSystemControlsPK.service = :service"),
    @NamedQuery(name = "CsoSystemControls.findBySubService", query = "SELECT c FROM CsoSystemControls c WHERE c.csoSystemControlsPK.subService = :subService"),
    @NamedQuery(name = "CsoSystemControls.findByOutputDate", query = "SELECT c FROM CsoSystemControls c WHERE c.outputDate = :outputDate"),
    @NamedQuery(name = "CsoSystemControls.findByEffectiveActionDate", query = "SELECT c FROM CsoSystemControls c WHERE c.effectiveActionDate = :effectiveActionDate"),
    @NamedQuery(name = "CsoSystemControls.findByDbVolume", query = "SELECT c FROM CsoSystemControls c WHERE c.dbVolume = :dbVolume"),
    @NamedQuery(name = "CsoSystemControls.findByDbAmount", query = "SELECT c FROM CsoSystemControls c WHERE c.dbAmount = :dbAmount"),
    @NamedQuery(name = "CsoSystemControls.findByCrVolume", query = "SELECT c FROM CsoSystemControls c WHERE c.crVolume = :crVolume"),
    @NamedQuery(name = "CsoSystemControls.findByCrAmount", query = "SELECT c FROM CsoSystemControls c WHERE c.crAmount = :crAmount")})
@DynamicUpdate
public class CsoSystemControls implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsoSystemControlsPK csoSystemControlsPK;
    @Column(name = "OUTPUT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date outputDate;
    @Column(name = "EFFECTIVE_ACTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date effectiveActionDate;
    @Column(name = "DB_VOLUME")
    private Long dbVolume;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DB_AMOUNT")
    private BigDecimal dbAmount;
    @Column(name = "CR_VOLUME")
    private Long crVolume;
    @Column(name = "CR_AMOUNT")
    private BigDecimal crAmount;

    public CsoSystemControls() {
    }

    public CsoSystemControls(CsoSystemControlsPK csoSystemControlsPK) {
        this.csoSystemControlsPK = csoSystemControlsPK;
    }

    public CsoSystemControls(Date processDate, String systemFunction, String service, String subService) {
        this.csoSystemControlsPK = new CsoSystemControlsPK(processDate, systemFunction, service, subService);
    }

    public CsoSystemControlsPK getCsoSystemControlsPK() {
        return csoSystemControlsPK;
    }

    public void setCsoSystemControlsPK(CsoSystemControlsPK csoSystemControlsPK) {
        this.csoSystemControlsPK = csoSystemControlsPK;
    }

    public Date getOutputDate() {
        return outputDate;
    }

    public void setOutputDate(Date outputDate) {
        this.outputDate = outputDate;
    }

    public Date getEffectiveActionDate() {
        return effectiveActionDate;
    }

    public void setEffectiveActionDate(Date effectiveActionDate) {
        this.effectiveActionDate = effectiveActionDate;
    }

    public Long getDbVolume() {
        return dbVolume;
    }

    public void setDbVolume(Long dbVolume) {
        this.dbVolume = dbVolume;
    }

    public BigDecimal getDbAmount() {
        return dbAmount;
    }

    public void setDbAmount(BigDecimal dbAmount) {
        this.dbAmount = dbAmount;
    }

    public Long getCrVolume() {
        return crVolume;
    }

    public void setCrVolume(Long crVolume) {
        this.crVolume = crVolume;
    }

    public BigDecimal getCrAmount() {
        return crAmount;
    }

    public void setCrAmount(BigDecimal crAmount) {
        this.crAmount = crAmount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csoSystemControlsPK != null ? csoSystemControlsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoSystemControls)) {
            return false;
        }
        CsoSystemControls other = (CsoSystemControls) object;
        if ((this.csoSystemControlsPK == null && other.csoSystemControlsPK != null) || (this.csoSystemControlsPK != null && !this.csoSystemControlsPK.equals(other.csoSystemControlsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoSystemControls[ csoSystemControlsPK=" + csoSystemControlsPK + " ]";
    }
    
}

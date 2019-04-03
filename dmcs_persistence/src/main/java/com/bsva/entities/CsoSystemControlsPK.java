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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AugustineA
 */
@Embeddable
public class CsoSystemControlsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROCESS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date processDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SYSTEM_FUNCTION")
    private String systemFunction;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "SERVICE")
    private String service;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SUB_SERVICE")
    private String subService;

    public CsoSystemControlsPK() {
    }

    public CsoSystemControlsPK(Date processDate, String systemFunction, String service, String subService) {
        this.processDate = processDate;
        this.systemFunction = systemFunction;
        this.service = service;
        this.subService = subService;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getSystemFunction() {
        return systemFunction;
    }

    public void setSystemFunction(String systemFunction) {
        this.systemFunction = systemFunction;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSubService() {
        return subService;
    }

    public void setSubService(String subService) {
        this.subService = subService;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (processDate != null ? processDate.hashCode() : 0);
        hash += (systemFunction != null ? systemFunction.hashCode() : 0);
        hash += (service != null ? service.hashCode() : 0);
        hash += (subService != null ? subService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoSystemControlsPK)) {
            return false;
        }
        CsoSystemControlsPK other = (CsoSystemControlsPK) object;
        if ((this.processDate == null && other.processDate != null) || (this.processDate != null && !this.processDate.equals(other.processDate))) {
            return false;
        }
        if ((this.systemFunction == null && other.systemFunction != null) || (this.systemFunction != null && !this.systemFunction.equals(other.systemFunction))) {
            return false;
        }
        if ((this.service == null && other.service != null) || (this.service != null && !this.service.equals(other.service))) {
            return false;
        }
        if ((this.subService == null && other.subService != null) || (this.subService != null && !this.subService.equals(other.subService))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoSystemControlsPK[ processDate=" + processDate + ", systemFunction=" + systemFunction + ", service=" + service + ", subService=" + subService + " ]";
    }
    
}

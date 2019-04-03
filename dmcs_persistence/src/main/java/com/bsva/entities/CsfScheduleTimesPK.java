package com.bsva.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AugustineA
 */
@Embeddable
public class CsfScheduleTimesPK implements Serializable {
    @Column(name = "PROCESS")
    private String process;
    @Column(name = "SERVICE")
    private String service;
    @Column(name = "SUB_SERVICE")
    private String subService;
    

    public CsfScheduleTimesPK() {
    }

    public CsfScheduleTimesPK(String process, String service, String subService) {
        this.process = process;
        this.service = service;
        this.subService = subService;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
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
        hash += (process != null ? process.hashCode() : 0);
        hash += (service != null ? service.hashCode() : 0);
        hash += (subService != null ? subService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfScheduleTimesPK)) {
            return false;
        }
        CsfScheduleTimesPK other = (CsfScheduleTimesPK) object;
        if ((this.process == null && other.process != null) || (this.process != null && !this.process.equals(other.process))) {
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
        return "com.bsva.dmcs.entities.CsfScheduleTimesPK[ process=" + process + ", service=" + service + ", subService=" + subService + " ]";
    }       
}

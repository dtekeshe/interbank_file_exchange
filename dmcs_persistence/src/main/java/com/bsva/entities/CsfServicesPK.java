/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class CsfServicesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "SERVICE_CODE")
    private String serviceCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SERVICE_NAME")
    private String serviceName;

    public CsfServicesPK() {
    }

    public CsfServicesPK(String serviceCode, String serviceName) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceCode != null ? serviceCode.hashCode() : 0);
        hash += (serviceName != null ? serviceName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfServicesPK)) {
            return false;
        }
        CsfServicesPK other = (CsfServicesPK) object;
        if ((this.serviceCode == null && other.serviceCode != null) || (this.serviceCode != null && !this.serviceCode.equals(other.serviceCode))) {
            return false;
        }
        if ((this.serviceName == null && other.serviceName != null) || (this.serviceName != null && !this.serviceName.equals(other.serviceName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfServicesPK[ serviceCode=" + serviceCode + ", serviceName=" + serviceName + " ]";
    }
    
}

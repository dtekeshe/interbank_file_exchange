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
public class CsoFleetBindResolvedPK implements Serializable {
    @Basic(optional = false)
    //@NotNull
    @Column(name = "ISS")
    private short iss;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "ACQ")
    private short acq;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "TX_CDE")
    private short txCde;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "TX_DATE_TIME")
    private long txDateTime;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 4)
    @Column(name = "SERVICE")
    private String service;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SUB_SERVICE")
    private String subService;

    public CsoFleetBindResolvedPK() {
    }

    public CsoFleetBindResolvedPK(short iss, short acq, short txCde, long txDateTime, String service, String subService) {
        this.iss = iss;
        this.acq = acq;
        this.txCde = txCde;
        this.txDateTime = txDateTime;
        this.service = service;
        this.subService = subService;
    }

    public short getIss() {
        return iss;
    }

    public void setIss(short iss) {
        this.iss = iss;
    }

    public short getAcq() {
        return acq;
    }

    public void setAcq(short acq) {
        this.acq = acq;
    }

    public short getTxCde() {
        return txCde;
    }

    public void setTxCde(short txCde) {
        this.txCde = txCde;
    }

    public long getTxDateTime() {
        return txDateTime;
    }

    public void setTxDateTime(long txDateTime) {
        this.txDateTime = txDateTime;
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
        hash += (int) iss;
        hash += (int) acq;
        hash += (int) txCde;
        hash += (int) txDateTime;
        hash += (service != null ? service.hashCode() : 0);
        hash += (subService != null ? subService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoFleetBindResolvedPK)) {
            return false;
        }
        CsoFleetBindResolvedPK other = (CsoFleetBindResolvedPK) object;
        if (this.iss != other.iss) {
            return false;
        }
        if (this.acq != other.acq) {
            return false;
        }
        if (this.txCde != other.txCde) {
            return false;
        }
        if (this.txDateTime != other.txDateTime) {
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
        return "com.bsva.entities.CsoFleetBindResolvedPK[ iss=" + iss + ", acq=" + acq + ", txCde=" + txCde + ", txDateTime=" + txDateTime + ", service=" + service + ", subService=" + subService + " ]";
    }
    
}

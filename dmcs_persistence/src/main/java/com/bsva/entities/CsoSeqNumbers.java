/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSO_SEQ_NUMBERS")
@NamedQueries({
    @NamedQuery(name = "CsoSeqNumbers.findAll", query = "SELECT c FROM CsoSeqNumbers c"),
    @NamedQuery(name = "CsoSeqNumbers.findByExternalFilenamePrefix", query = "SELECT c FROM CsoSeqNumbers c WHERE c.csoSeqNumbersPK.externalFilenamePrefix = :externalFilenamePrefix"),
    @NamedQuery(name = "CsoSeqNumbers.findByDistributionCode", query = "SELECT c FROM CsoSeqNumbers c WHERE c.csoSeqNumbersPK.distributionCode = :distributionCode"),
    @NamedQuery(name = "CsoSeqNumbers.findByLastSeqNumberUsed", query = "SELECT c FROM CsoSeqNumbers c WHERE c.lastSeqNumberUsed = :lastSeqNumberUsed")})
@DynamicUpdate
public class CsoSeqNumbers implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsoSeqNumbersPK csoSeqNumbersPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LAST_SEQ_NUMBER_USED")
    private short lastSeqNumberUsed;

    public CsoSeqNumbers() {
    }

    public CsoSeqNumbers(CsoSeqNumbersPK csoSeqNumbersPK) {
        this.csoSeqNumbersPK = csoSeqNumbersPK;
    }

    public CsoSeqNumbers(CsoSeqNumbersPK csoSeqNumbersPK, short lastSeqNumberUsed) {
        this.csoSeqNumbersPK = csoSeqNumbersPK;
        this.lastSeqNumberUsed = lastSeqNumberUsed;
    }

    public CsoSeqNumbers(String externalFilenamePrefix, String distributionCode) {
        this.csoSeqNumbersPK = new CsoSeqNumbersPK(externalFilenamePrefix, distributionCode);
    }

    public CsoSeqNumbersPK getCsoSeqNumbersPK() {
        return csoSeqNumbersPK;
    }

    public void setCsoSeqNumbersPK(CsoSeqNumbersPK csoSeqNumbersPK) {
        this.csoSeqNumbersPK = csoSeqNumbersPK;
    }

    public short getLastSeqNumberUsed() {
        return lastSeqNumberUsed;
    }

    public void setLastSeqNumberUsed(short lastSeqNumberUsed) {
        this.lastSeqNumberUsed = lastSeqNumberUsed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csoSeqNumbersPK != null ? csoSeqNumbersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoSeqNumbers)) {
            return false;
        }
        CsoSeqNumbers other = (CsoSeqNumbers) object;
        if ((this.csoSeqNumbersPK == null && other.csoSeqNumbersPK != null) || (this.csoSeqNumbersPK != null && !this.csoSeqNumbersPK.equals(other.csoSeqNumbersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoSeqNumbers[ csoSeqNumbersPK=" + csoSeqNumbersPK + " ]";
    }
    
}

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
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSO_PAYMENT_MCARD_PDS")
@NamedQueries({
    @NamedQuery(name = "CsoPaymentMcardPds.findAll", query = "SELECT c FROM CsoPaymentMcardPds c"),
    @NamedQuery(name = "CsoPaymentMcardPds.findBySystemSeqNumber", query = "SELECT c FROM CsoPaymentMcardPds c WHERE c.csoPaymentMcardPdsPK.systemSeqNumber = :systemSeqNumber"),
    @NamedQuery(name = "CsoPaymentMcardPds.findByPdsNumber", query = "SELECT c FROM CsoPaymentMcardPds c WHERE c.csoPaymentMcardPdsPK.pdsNumber = :pdsNumber"),
    @NamedQuery(name = "CsoPaymentMcardPds.findByPdsLength", query = "SELECT c FROM CsoPaymentMcardPds c WHERE c.pdsLength = :pdsLength"),
    @NamedQuery(name = "CsoPaymentMcardPds.findByPdsData", query = "SELECT c FROM CsoPaymentMcardPds c WHERE c.pdsData = :pdsData")})
@DynamicUpdate
public class CsoPaymentMcardPds implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsoPaymentMcardPdsPK csoPaymentMcardPdsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PDS_LENGTH")
    private short pdsLength;
    @Size(max = 999)
    @Column(name = "PDS_DATA")
    private String pdsData;

    public CsoPaymentMcardPds() {
    }

    public CsoPaymentMcardPds(CsoPaymentMcardPdsPK csoPaymentMcardPdsPK) {
        this.csoPaymentMcardPdsPK = csoPaymentMcardPdsPK;
    }

    public CsoPaymentMcardPds(CsoPaymentMcardPdsPK csoPaymentMcardPdsPK, short pdsLength) {
        this.csoPaymentMcardPdsPK = csoPaymentMcardPdsPK;
        this.pdsLength = pdsLength;
    }

    public CsoPaymentMcardPds(long systemSeqNumber, short pdsNumber) {
        this.csoPaymentMcardPdsPK = new CsoPaymentMcardPdsPK(systemSeqNumber, pdsNumber);
    }

    public CsoPaymentMcardPdsPK getCsoPaymentMcardPdsPK() {
        return csoPaymentMcardPdsPK;
    }

    public void setCsoPaymentMcardPdsPK(CsoPaymentMcardPdsPK csoPaymentMcardPdsPK) {
        this.csoPaymentMcardPdsPK = csoPaymentMcardPdsPK;
    }

    public short getPdsLength() {
        return pdsLength;
    }

    public void setPdsLength(short pdsLength) {
        this.pdsLength = pdsLength;
    }

    public String getPdsData() {
        return pdsData;
    }

    public void setPdsData(String pdsData) {
        this.pdsData = pdsData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csoPaymentMcardPdsPK != null ? csoPaymentMcardPdsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoPaymentMcardPds)) {
            return false;
        }
        CsoPaymentMcardPds other = (CsoPaymentMcardPds) object;
        if ((this.csoPaymentMcardPdsPK == null && other.csoPaymentMcardPdsPK != null) || (this.csoPaymentMcardPdsPK != null && !this.csoPaymentMcardPdsPK.equals(other.csoPaymentMcardPdsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoPaymentMcardPds[ csoPaymentMcardPdsPK=" + csoPaymentMcardPdsPK + " ]";
    }
    
}

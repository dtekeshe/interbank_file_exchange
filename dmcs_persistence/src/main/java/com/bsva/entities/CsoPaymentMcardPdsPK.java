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

/**
 *
 * @author AugustineA
 */
@Embeddable
public class CsoPaymentMcardPdsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "SYSTEM_SEQ_NUMBER")
    private long systemSeqNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PDS_NUMBER")
    private short pdsNumber;

    public CsoPaymentMcardPdsPK() {
    }

    public CsoPaymentMcardPdsPK(long systemSeqNumber, short pdsNumber) {
        this.systemSeqNumber = systemSeqNumber;
        this.pdsNumber = pdsNumber;
    }

    public long getSystemSeqNumber() {
        return systemSeqNumber;
    }

    public void setSystemSeqNumber(long systemSeqNumber) {
        this.systemSeqNumber = systemSeqNumber;
    }

    public short getPdsNumber() {
        return pdsNumber;
    }

    public void setPdsNumber(short pdsNumber) {
        this.pdsNumber = pdsNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) systemSeqNumber;
        hash += (int) pdsNumber;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoPaymentMcardPdsPK)) {
            return false;
        }
        CsoPaymentMcardPdsPK other = (CsoPaymentMcardPdsPK) object;
        if (this.systemSeqNumber != other.systemSeqNumber) {
            return false;
        }
        if (this.pdsNumber != other.pdsNumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoPaymentMcardPdsPK[ systemSeqNumber=" + systemSeqNumber + ", pdsNumber=" + pdsNumber + " ]";
    }
    
}

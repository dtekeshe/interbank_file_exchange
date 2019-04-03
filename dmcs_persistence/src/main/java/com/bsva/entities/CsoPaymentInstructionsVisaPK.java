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
public class CsoPaymentInstructionsVisaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "SYSTEM_GEN_SEQ_NUMBER")
    private long systemGenSeqNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTION_CODE_NUMBER")
    private short transactionCodeNumber;

    public CsoPaymentInstructionsVisaPK() {
    }

    public CsoPaymentInstructionsVisaPK(long systemGenSeqNumber, short transactionCodeNumber) {
        this.systemGenSeqNumber = systemGenSeqNumber;
        this.transactionCodeNumber = transactionCodeNumber;
    }

    public long getSystemGenSeqNumber() {
        return systemGenSeqNumber;
    }

    public void setSystemGenSeqNumber(long systemGenSeqNumber) {
        this.systemGenSeqNumber = systemGenSeqNumber;
    }

    public short getTransactionCodeNumber() {
        return transactionCodeNumber;
    }

    public void setTransactionCodeNumber(short transactionCodeNumber) {
        this.transactionCodeNumber = transactionCodeNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) systemGenSeqNumber;
        hash += (int) transactionCodeNumber;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoPaymentInstructionsVisaPK)) {
            return false;
        }
        CsoPaymentInstructionsVisaPK other = (CsoPaymentInstructionsVisaPK) object;
        if (this.systemGenSeqNumber != other.systemGenSeqNumber) {
            return false;
        }
        if (this.transactionCodeNumber != other.transactionCodeNumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.entities.CsoPaymentInstructionsVisaPK[ systemGenSeqNumber=" + systemGenSeqNumber + ", transactionCodeNumber=" + transactionCodeNumber + " ]";
    }
    
}

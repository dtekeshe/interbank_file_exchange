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
public class CsoPaymentInstructionsMcardPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "FILE_REF_NUMBER1")
    private String fileRefNumber1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SYSTEM_SEQ_NUMBER2")
    private long systemSeqNumber2;

    public CsoPaymentInstructionsMcardPK() {
    }

    public CsoPaymentInstructionsMcardPK(String fileRefNumber1, long systemSeqNumber2) {
        this.fileRefNumber1 = fileRefNumber1;
        this.systemSeqNumber2 = systemSeqNumber2;
    }

    public String getFileRefNumber1() {
        return fileRefNumber1;
    }

    public void setFileRefNumber1(String fileRefNumber1) {
        this.fileRefNumber1 = fileRefNumber1;
    }

    public long getSystemSeqNumber2() {
        return systemSeqNumber2;
    }

    public void setSystemSeqNumber2(long systemSeqNumber2) {
        this.systemSeqNumber2 = systemSeqNumber2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fileRefNumber1 != null ? fileRefNumber1.hashCode() : 0);
        hash += (int) systemSeqNumber2;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoPaymentInstructionsMcardPK)) {
            return false;
        }
        CsoPaymentInstructionsMcardPK other = (CsoPaymentInstructionsMcardPK) object;
        if ((this.fileRefNumber1 == null && other.fileRefNumber1 != null) || (this.fileRefNumber1 != null && !this.fileRefNumber1.equals(other.fileRefNumber1))) {
            return false;
        }
        if (this.systemSeqNumber2 != other.systemSeqNumber2) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoPaymentInstructionsMcardPK[ fileRefNumber1=" + fileRefNumber1 + ", systemSeqNumber2=" + systemSeqNumber2 + " ]";
    }
    
}

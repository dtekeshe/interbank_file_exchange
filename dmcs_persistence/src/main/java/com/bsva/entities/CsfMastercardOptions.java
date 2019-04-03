/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSF_MASTERCARD_OPTIONS")
@NamedQueries({
    @NamedQuery(name = "CsfMastercardOptions.findAll", query = "SELECT c FROM CsfMastercardOptions c"),
    @NamedQuery(name = "CsfMastercardOptions.findByBankCode", query = "SELECT c FROM CsfMastercardOptions c WHERE c.bankCode = :bankCode"),
    @NamedQuery(name = "CsfMastercardOptions.findByRecordReadStartByte", query = "SELECT c FROM CsfMastercardOptions c WHERE c.recordReadStartByte = :recordReadStartByte"),
    @NamedQuery(name = "CsfMastercardOptions.findByRecordWriteStartByte", query = "SELECT c FROM CsfMastercardOptions c WHERE c.recordWriteStartByte = :recordWriteStartByte"),
    @NamedQuery(name = "CsfMastercardOptions.findByEolPresent", query = "SELECT c FROM CsfMastercardOptions c WHERE c.eolPresent = :eolPresent"),
    @NamedQuery(name = "CsfMastercardOptions.findByBitmapBinaryText", query = "SELECT c FROM CsfMastercardOptions c WHERE c.bitmapBinaryText = :bitmapBinaryText")})
@DynamicUpdate
public class CsfMastercardOptions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BANK_CODE")
    private Short bankCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECORD_READ_START_BYTE")
    private short recordReadStartByte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECORD_WRITE_START_BYTE")
    private short recordWriteStartByte;
    //@Lob
    @Column(name = "RECORD_LEAD_BYTES")
    private byte[] recordLeadBytes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EOL_PRESENT")
    private String eolPresent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "BITMAP_BINARY_TEXT")
    private String bitmapBinaryText;
    /*@OneToOne(optional = false)
    @JoinColumn(name = "BANK_CODE", referencedColumnName = "BANK_CODE", insertable = false, updatable = false)
    private CsfMembers csfMembers;*/

    public CsfMastercardOptions() {
    }

    public CsfMastercardOptions(Short bankCode) {
        this.bankCode = bankCode;
    }

    public CsfMastercardOptions(Short bankCode, short recordReadStartByte, short recordWriteStartByte, String eolPresent, String bitmapBinaryText) {
        this.bankCode = bankCode;
        this.recordReadStartByte = recordReadStartByte;
        this.recordWriteStartByte = recordWriteStartByte;
        this.eolPresent = eolPresent;
        this.bitmapBinaryText = bitmapBinaryText;
    }

    public Short getBankCode() {
        return bankCode;
    }

    public void setBankCode(Short bankCode) {
        this.bankCode = bankCode;
    }

    public short getRecordReadStartByte() {
        return recordReadStartByte;
    }

    public void setRecordReadStartByte(short recordReadStartByte) {
        this.recordReadStartByte = recordReadStartByte;
    }

    public short getRecordWriteStartByte() {
        return recordWriteStartByte;
    }

    public void setRecordWriteStartByte(short recordWriteStartByte) {
        this.recordWriteStartByte = recordWriteStartByte;
    }

    public byte[] getRecordLeadBytes() {
        return recordLeadBytes;
    }

    public void setRecordLeadBytes(byte[] recordLeadBytes) {
        this.recordLeadBytes = recordLeadBytes;
    }

    public String getEolPresent() {
        return eolPresent;
    }

    public void setEolPresent(String eolPresent) {
        this.eolPresent = eolPresent;
    }

    public String getBitmapBinaryText() {
        return bitmapBinaryText;
    }

    public void setBitmapBinaryText(String bitmapBinaryText) {
        this.bitmapBinaryText = bitmapBinaryText;
    }

   /* public CsfMembers getCsfMembers() {
        return csfMembers;
    }

    public void setCsfMembers(CsfMembers csfMembers) {
        this.csfMembers = csfMembers;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankCode != null ? bankCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfMastercardOptions)) {
            return false;
        }
        CsfMastercardOptions other = (CsfMastercardOptions) object;
        if ((this.bankCode == null && other.bankCode != null) || (this.bankCode != null && !this.bankCode.equals(other.bankCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfMastercardOptions[ bankCode=" + bankCode + " ]";
    }
    
}

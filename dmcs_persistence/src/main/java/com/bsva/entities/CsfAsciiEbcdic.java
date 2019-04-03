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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSF_ASCII_EBCDIC")
@NamedQueries({
    @NamedQuery(name = "CsfAsciiEbcdic.findAll", query = "SELECT c FROM CsfAsciiEbcdic c"),
    @NamedQuery(name = "CsfAsciiEbcdic.findByDecimalVal", query = "SELECT c FROM CsfAsciiEbcdic c WHERE c.decimalVal = :decimalVal"),
    @NamedQuery(name = "CsfAsciiEbcdic.findByAsciiChar", query = "SELECT c FROM CsfAsciiEbcdic c WHERE c.asciiChar = :asciiChar"),
    @NamedQuery(name = "CsfAsciiEbcdic.findByEbcdicChar", query = "SELECT c FROM CsfAsciiEbcdic c WHERE c.ebcdicChar = :ebcdicChar"),
    @NamedQuery(name = "CsfAsciiEbcdic.findByEbcdicInt", query = "SELECT c FROM CsfAsciiEbcdic c WHERE c.ebcdicInt = :ebcdicInt")})
public class CsfAsciiEbcdic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DECIMAL_VAL")
    private Short decimalVal;
    @Size(max = 1)
    @Column(name = "ASCII_CHAR")
    private String asciiChar;
    @Size(max = 1)
    @Column(name = "EBCDIC_CHAR")
    private String ebcdicChar;
    @Column(name = "EBCDIC_INT")
    private Short ebcdicInt;

    public CsfAsciiEbcdic() {
    }

    public CsfAsciiEbcdic(Short decimalVal) {
        this.decimalVal = decimalVal;
    }

    public Short getDecimalVal() {
        return decimalVal;
    }

    public void setDecimalVal(Short decimalVal) {
        this.decimalVal = decimalVal;
    }

    public String getAsciiChar() {
        return asciiChar;
    }

    public void setAsciiChar(String asciiChar) {
        this.asciiChar = asciiChar;
    }

    public String getEbcdicChar() {
        return ebcdicChar;
    }

    public void setEbcdicChar(String ebcdicChar) {
        this.ebcdicChar = ebcdicChar;
    }

    public Short getEbcdicInt() {
        return ebcdicInt;
    }

    public void setEbcdicInt(Short ebcdicInt) {
        this.ebcdicInt = ebcdicInt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (decimalVal != null ? decimalVal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfAsciiEbcdic)) {
            return false;
        }
        CsfAsciiEbcdic other = (CsfAsciiEbcdic) object;
        if ((this.decimalVal == null && other.decimalVal != null) || (this.decimalVal != null && !this.decimalVal.equals(other.decimalVal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfAsciiEbcdic[ decimalVal=" + decimalVal + " ]";
    }
    
}

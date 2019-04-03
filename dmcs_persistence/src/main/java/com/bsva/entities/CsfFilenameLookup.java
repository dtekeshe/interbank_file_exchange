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

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSF_FILENAME_LOOKUP")
@NamedQueries({
    @NamedQuery(name = "CsfFilenameLookup.findAll", query = "SELECT c FROM CsfFilenameLookup c"),
    @NamedQuery(name = "CsfFilenameLookup.findByNumIndex", query = "SELECT c FROM CsfFilenameLookup c WHERE c.numIndex = :numIndex"),
    @NamedQuery(name = "CsfFilenameLookup.findByAlphaSeq", query = "SELECT c FROM CsfFilenameLookup c WHERE c.alphaSeq = :alphaSeq")})
@DynamicUpdate
public class CsfFilenameLookup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_INDEX")
    private Long numIndex;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ALPHA_SEQ")
    private String alphaSeq;

    public CsfFilenameLookup() {
    }

    public CsfFilenameLookup(String alphaSeq) {
        this.alphaSeq = alphaSeq;
    }

    public CsfFilenameLookup(String alphaSeq, Long numIndex) {
        this.alphaSeq = alphaSeq;
        this.numIndex = numIndex;
    }

    public Long getNumIndex() {
        return numIndex;
    }

    public void setNumIndex(Long numIndex) {
        this.numIndex = numIndex;
    }

    public String getAlphaSeq() {
        return alphaSeq;
    }

    public void setAlphaSeq(String alphaSeq) {
        this.alphaSeq = alphaSeq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alphaSeq != null ? alphaSeq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfFilenameLookup)) {
            return false;
        }
        CsfFilenameLookup other = (CsfFilenameLookup) object;
        if ((this.alphaSeq == null && other.alphaSeq != null) || (this.alphaSeq != null && !this.alphaSeq.equals(other.alphaSeq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfFilenameLookup[ alphaSeq=" + alphaSeq + " ]";
    }
    
}

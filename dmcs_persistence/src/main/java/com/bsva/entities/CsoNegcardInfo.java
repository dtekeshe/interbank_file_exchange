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
@Table(name = "CSO_NEGCARD_INFO")
@NamedQueries({
    @NamedQuery(name = "CsoNegcardInfo.findAll", query = "SELECT c FROM CsoNegcardInfo c"),
    @NamedQuery(name = "CsoNegcardInfo.findByFileOriginator", query = "SELECT c FROM CsoNegcardInfo c WHERE c.csoNegcardInfoPK.fileOriginator = :fileOriginator"),
    @NamedQuery(name = "CsoNegcardInfo.findByNegCardCount", query = "SELECT c FROM CsoNegcardInfo c WHERE c.negCardCount = :negCardCount"),
    @NamedQuery(name = "CsoNegcardInfo.findByCountOutputDate", query = "SELECT c FROM CsoNegcardInfo c WHERE c.negCardCount = :negCardCount"),
    @NamedQuery(name = "CsoNegcardInfo.findByOutputDate", query = "SELECT c FROM CsoNegcardInfo c WHERE c.csoNegcardInfoPK.outputDate = :outputDate")})
@DynamicUpdate
public class CsoNegcardInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsoNegcardInfoPK csoNegcardInfoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NEG_CARD_COUNT")
    private long negCardCount;

    public CsoNegcardInfo() {
    }

    public CsoNegcardInfo(CsoNegcardInfoPK csoNegcardInfoPK) {
        this.csoNegcardInfoPK = csoNegcardInfoPK;
    }

    public CsoNegcardInfo(CsoNegcardInfoPK csoNegcardInfoPK, long negCardCount) {
        this.csoNegcardInfoPK = csoNegcardInfoPK;
        this.negCardCount = negCardCount;
    }

    public CsoNegcardInfo(String fileOriginator, String outputDate) {
        this.csoNegcardInfoPK = new CsoNegcardInfoPK(fileOriginator, outputDate);
    }

    public CsoNegcardInfoPK getCsoNegcardInfoPK() {
        return csoNegcardInfoPK;
    }

    public void setCsoNegcardInfoPK(CsoNegcardInfoPK csoNegcardInfoPK) {
        this.csoNegcardInfoPK = csoNegcardInfoPK;
    }

    public long getNegCardCount() {
        return negCardCount;
    }

    public void setNegCardCount(long negCardCount) {
        this.negCardCount = negCardCount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csoNegcardInfoPK != null ? csoNegcardInfoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoNegcardInfo)) {
            return false;
        }
        CsoNegcardInfo other = (CsoNegcardInfo) object;
        if ((this.csoNegcardInfoPK == null && other.csoNegcardInfoPK != null) || (this.csoNegcardInfoPK != null && !this.csoNegcardInfoPK.equals(other.csoNegcardInfoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoNegcardInfo[ csoNegcardInfoPK=" + csoNegcardInfoPK + " ]";
    }
    
}

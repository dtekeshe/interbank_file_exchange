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
public class CsoSeqNumbersPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "EXTERNAL_FILENAME_PREFIX")
    private String externalFilenamePrefix;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "DISTRIBUTION_CODE")
    private String distributionCode;

    public CsoSeqNumbersPK() {
    }

    public CsoSeqNumbersPK(String externalFilenamePrefix, String distributionCode) {
        this.externalFilenamePrefix = externalFilenamePrefix;
        this.distributionCode = distributionCode;
    }

    public String getExternalFilenamePrefix() {
        return externalFilenamePrefix;
    }

    public void setExternalFilenamePrefix(String externalFilenamePrefix) {
        this.externalFilenamePrefix = externalFilenamePrefix;
    }

    public String getDistributionCode() {
        return distributionCode;
    }

    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (externalFilenamePrefix != null ? externalFilenamePrefix.hashCode() : 0);
        hash += (distributionCode != null ? distributionCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoSeqNumbersPK)) {
            return false;
        }
        CsoSeqNumbersPK other = (CsoSeqNumbersPK) object;
        if ((this.externalFilenamePrefix == null && other.externalFilenamePrefix != null) || (this.externalFilenamePrefix != null && !this.externalFilenamePrefix.equals(other.externalFilenamePrefix))) {
            return false;
        }
        if ((this.distributionCode == null && other.distributionCode != null) || (this.distributionCode != null && !this.distributionCode.equals(other.distributionCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoSeqNumbersPK[ externalFilenamePrefix=" + externalFilenamePrefix + ", distributionCode=" + distributionCode + " ]";
    }
    
}

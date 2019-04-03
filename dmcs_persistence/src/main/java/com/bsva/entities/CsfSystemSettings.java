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
@Table(name = "CSF_SYSTEM_SETTINGS")
@NamedQueries({
    @NamedQuery(name = "CsfSystemSettings.findAll", query = "SELECT c FROM CsfSystemSettings c"),
    @NamedQuery(name = "CsfSystemSettings.findBySettingCode", query = "SELECT c FROM CsfSystemSettings c WHERE c.settingCode = :settingCode"),
    @NamedQuery(name = "CsfSystemSettings.findBySettingValue", query = "SELECT c FROM CsfSystemSettings c WHERE c.settingValue = :settingValue"),
    @NamedQuery(name = "CsfSystemSettings.findBySettingDescription", query = "SELECT c FROM CsfSystemSettings c WHERE c.settingDescription = :settingDescription")})
@DynamicUpdate
public class CsfSystemSettings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SETTING_CODE")
    private String settingCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SETTING_VALUE")
    private String settingValue;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SETTING_DESCRIPTION")
    private String settingDescription;

    public CsfSystemSettings() {
    }

    public CsfSystemSettings(String settingDescription) {
        this.settingDescription = settingDescription;
    }

    public CsfSystemSettings(String settingDescription, String settingCode, String settingValue) {
        this.settingDescription = settingDescription;
        this.settingCode = settingCode;
        this.settingValue = settingValue;
    }

    public String getSettingCode() {
        return settingCode;
    }

    public void setSettingCode(String settingCode) {
        this.settingCode = settingCode;
    }

    public String getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }

    public String getSettingDescription() {
        return settingDescription;
    }

    public void setSettingDescription(String settingDescription) {
        this.settingDescription = settingDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (settingDescription != null ? settingDescription.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfSystemSettings)) {
            return false;
        }
        CsfSystemSettings other = (CsfSystemSettings) object;
        if ((this.settingDescription == null && other.settingDescription != null) || (this.settingDescription != null && !this.settingDescription.equals(other.settingDescription))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfSystemSettings[ settingDescription=" + settingDescription + " ]";
    }
    
}

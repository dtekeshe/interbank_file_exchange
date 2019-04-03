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
public class CsoProgramControlsPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PROGRAM_NAME")
    private String programName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ARB_DATA")
    private String arbData;

    public CsoProgramControlsPK() {
    }

    public CsoProgramControlsPK(String programName, String arbData) {
        this.programName = programName;
        this.arbData = arbData;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getArbData() {
        return arbData;
    }

    public void setArbData(String arbData) {
        this.arbData = arbData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programName != null ? programName.hashCode() : 0);
        hash += (arbData != null ? arbData.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoProgramControlsPK)) {
            return false;
        }
        CsoProgramControlsPK other = (CsoProgramControlsPK) object;
        if ((this.programName == null && other.programName != null) || (this.programName != null && !this.programName.equals(other.programName))) {
            return false;
        }
        if ((this.arbData == null && other.arbData != null) || (this.arbData != null && !this.arbData.equals(other.arbData))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoProgramControlsPK[ programName=" + programName + ", arbData=" + arbData + " ]";
    }
    
}

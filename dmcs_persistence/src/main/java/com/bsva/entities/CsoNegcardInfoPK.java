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
public class CsoNegcardInfoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "FILE_ORIGINATOR")
    private String fileOriginator;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "OUTPUT_DATE")
    private String outputDate;

    public CsoNegcardInfoPK() {
    }

    public CsoNegcardInfoPK(String fileOriginator, String outputDate) {
        this.fileOriginator = fileOriginator;
        this.outputDate = outputDate;
    }

    public String getFileOriginator() {
        return fileOriginator;
    }

    public void setFileOriginator(String fileOriginator) {
        this.fileOriginator = fileOriginator;
    }

    public String getOutputDate() {
        return outputDate;
    }

    public void setOutputDate(String outputDate) {
        this.outputDate = outputDate;
    }

   

  

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileOriginator == null) ? 0 : fileOriginator.hashCode());
		result = prime * result + ((outputDate == null) ? 0 : outputDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CsoNegcardInfoPK other = (CsoNegcardInfoPK) obj;
		if (fileOriginator == null) {
			if (other.fileOriginator != null)
				return false;
		} else if (!fileOriginator.equals(other.fileOriginator))
			return false;
		if (outputDate == null) {
			if (other.outputDate != null)
				return false;
		} else if (!outputDate.equals(other.outputDate))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoNegcardInfoPK[ fileOriginator=" + fileOriginator + ", outputDate=" + outputDate + " ]";
    }
    
}

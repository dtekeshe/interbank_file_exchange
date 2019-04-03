/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSV_DEFAULT_FILES_VIEW")
@DynamicUpdate
public class CsvDefaultFilesView implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected CsvDefaultFilesViewPK CsvDefaultFilesViewPK;        
    @Size(max = 2)
    @Column(name = "DEST_BANK_ID")
    private String destBankId;
    @Column(name = "ORIGINATING_ID")
    private String originatingId;
    @Size(max = 2)
    @Column(name = "FILENAME_PREFIX")
    private String filenamePrefix;
 

    public CsvDefaultFilesView(com.bsva.entities.CsvDefaultFilesViewPK csvDefaultFilesViewPK, String destBankId,
			String originatingId, String filenamePrefix) {
		super();
		CsvDefaultFilesViewPK = csvDefaultFilesViewPK;
		this.destBankId = destBankId;
		this.originatingId = originatingId;
		this.filenamePrefix = filenamePrefix;
	}

	public CsvDefaultFilesView() {
    }
    
    public CsvDefaultFilesView(CsvDefaultFilesViewPK csvDefaultFilesViewPK) {
    }

    public CsvDefaultFilesViewPK getCsvDefaultFilesViewPK() {
		return CsvDefaultFilesViewPK;
	}

	public void setCsvDefaultFilesViewPK(CsvDefaultFilesViewPK csvDefaultFilesViewPK) {
		CsvDefaultFilesViewPK = csvDefaultFilesViewPK;
	}

	public String getDestBankId() {
        return destBankId;
    }

    public void setDestBankId(String destBankId) {
        this.destBankId = destBankId;
    }

    public String getOriginatingId() {
        return originatingId;
    }

    public void setOriginatingId(String originatingId) {
        this.originatingId = originatingId;
    }

    public String getFilenamePrefix() {
        return filenamePrefix;
    }

    public void setFilenamePrefix(String filenamePrefix) {
        this.filenamePrefix = filenamePrefix;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CsvDefaultFilesViewPK == null) ? 0 : CsvDefaultFilesViewPK.hashCode());
		result = prime * result + ((destBankId == null) ? 0 : destBankId.hashCode());
		result = prime * result + ((filenamePrefix == null) ? 0 : filenamePrefix.hashCode());
		result = prime * result + ((originatingId == null) ? 0 : originatingId.hashCode());
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
		CsvDefaultFilesView other = (CsvDefaultFilesView) obj;
		if (CsvDefaultFilesViewPK == null) {
			if (other.CsvDefaultFilesViewPK != null)
				return false;
		} else if (!CsvDefaultFilesViewPK.equals(other.CsvDefaultFilesViewPK))
			return false;
		if (destBankId == null) {
			if (other.destBankId != null)
				return false;
		} else if (!destBankId.equals(other.destBankId))
			return false;
		if (filenamePrefix == null) {
			if (other.filenamePrefix != null)
				return false;
		} else if (!filenamePrefix.equals(other.filenamePrefix))
			return false;
		if (originatingId == null) {
			if (other.originatingId != null)
				return false;
		} else if (!originatingId.equals(other.originatingId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsvDefaultFilesView [CsvDefaultFilesViewPK=");
		builder.append(CsvDefaultFilesViewPK);
		builder.append(", destBankId=");
		builder.append(destBankId);
		builder.append(", originatingId=");
		builder.append(originatingId);
		builder.append(", filenamePrefix=");
		builder.append(filenamePrefix);
		builder.append("]");
		return builder.toString();
	}

   
    
}

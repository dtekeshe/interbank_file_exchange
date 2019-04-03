package com.bsva.entities.v02.loader;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class FilePDSEntity implements Serializable {


	@Id
    @Column(name = "SYSTEM_SEQ_NUMBER")
    private String systemSeqNumber;
	@Column(name = "PDS_NUMBER")
	private String pdsNumber;	
	@Column(name = "PDS_LENGTH")
	private String pdslength;
	@Column(name = "PDS_DATA")
	private String pdsData;
	
	
	public String getSystemSeqNumber() {
		return systemSeqNumber;
	}
	public String getPdsNumber() {
		return pdsNumber;
	}
	public String getPdslength() {
		return pdslength;
	}
	public String getPdsData() {
		return pdsData;
	}
	public void setSystemSeqNumber(String systemSeqNumber) {
		this.systemSeqNumber = systemSeqNumber;
	}
	public void setPdsNumber(String pdsNumber) {
		this.pdsNumber = pdsNumber;
	}
	public void setPdslength(String pdslength) {
		this.pdslength = pdslength;
	}
	public void setPdsData(String pdsData) {
		this.pdsData = pdsData;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pdsData == null) ? 0 : pdsData.hashCode());
		result = prime * result + ((pdsNumber == null) ? 0 : pdsNumber.hashCode());
		result = prime * result + ((pdslength == null) ? 0 : pdslength.hashCode());
		result = prime * result + ((systemSeqNumber == null) ? 0 : systemSeqNumber.hashCode());
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
		FilePDSEntity other = (FilePDSEntity) obj;
		if (pdsData == null) {
			if (other.pdsData != null)
				return false;
		} else if (!pdsData.equals(other.pdsData))
			return false;
		if (pdsNumber == null) {
			if (other.pdsNumber != null)
				return false;
		} else if (!pdsNumber.equals(other.pdsNumber))
			return false;
		if (pdslength == null) {
			if (other.pdslength != null)
				return false;
		} else if (!pdslength.equals(other.pdslength))
			return false;
		if (systemSeqNumber == null) {
			if (other.systemSeqNumber != null)
				return false;
		} else if (!systemSeqNumber.equals(other.systemSeqNumber))
			return false;
		return true;
	}

	
}

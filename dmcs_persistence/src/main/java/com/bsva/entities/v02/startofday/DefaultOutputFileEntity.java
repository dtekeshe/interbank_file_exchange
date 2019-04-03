package com.bsva.entities.v02.startofday;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class DefaultOutputFileEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
    private DefaultOutputFileKey id;
    @Column(name = "DEST_BANK_ID")
    private String destBankID;
    @Column(name = "ORIGIN_BANK_ID")
    private String originBankID;
    
    public DefaultOutputFileEntity(){
    	
    }

	public DefaultOutputFileEntity(DefaultOutputFileKey id, String destBankID, String originBankID) {
		super();
		this.id = id;
		this.destBankID = destBankID;
		this.originBankID = originBankID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DefaultOutputFileKey getId() {
		return id;
	}

	public String getDestBankID() {
		return destBankID;
	}

	public String getOriginBankID() {
		return originBankID;
	}

	public void setId(DefaultOutputFileKey id) {
		this.id = id;
	}

	public void setDestBankID(String destBankID) {
		this.destBankID = destBankID;
	}

	public void setOriginBankID(String originBankID) {
		this.originBankID = originBankID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destBankID == null) ? 0 : destBankID.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((originBankID == null) ? 0 : originBankID.hashCode());
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
		DefaultOutputFileEntity other = (DefaultOutputFileEntity) obj;
		if (destBankID == null) {
			if (other.destBankID != null)
				return false;
		}
		else if (!destBankID.equals(other.destBankID))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		if (originBankID == null) {
			if (other.originBankID != null)
				return false;
		}
		else if (!originBankID.equals(other.originBankID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DefaultOutputFileEntity [id=");
		builder.append(id);
		builder.append(", destBankID=");
		builder.append(destBankID);
		builder.append(", originBankID=");
		builder.append(originBankID);
		builder.append("]");
		return builder.toString();
	}

	
	
}

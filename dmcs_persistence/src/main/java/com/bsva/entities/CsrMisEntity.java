package com.bsva.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name = "CSO_BILLING_SUMMARY")
@DynamicUpdate
public class CsrMisEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CsrMisEntity_PK csrMisEntity_PK;
	@Column(name = "SERVICE")
	private String service;
	@Column(name = "VOLUME")
	private String volume;
	@Column(name = "VALUE")
	private String value;
	@Column(name = "VOLUME_BELOW")
	private String volumeBelow;
	@Column(name = "VALUE_BELOW")
	private String valueBelow;
	@Column(name = "VOLUME_ABOVE")
	private String volumeAbove;
	@Column(name = "VALUE_ABOVE")
	private String valueAbove;
	
	public CsrMisEntity(){
		
	}
	
	public CsrMisEntity(CsrMisEntity_PK csrMisEntity_PK, String service, String volume, String value,
			String volumeBelow, String valueBelow, String volumeAbove, String valueAbove) {
		super();
		this.csrMisEntity_PK = csrMisEntity_PK;
		this.service = service;
		this.volume = volume;
		this.value = value;
		this.volumeBelow = volumeBelow;
		this.valueBelow = valueBelow;
		this.volumeAbove = volumeAbove;
		this.valueAbove = valueAbove;
	}

	public CsrMisEntity_PK getCsrMisEntity_PK() {
		return csrMisEntity_PK;
	}

	public String getService() {
		return service;
	}

	public String getVolume() {
		return volume;
	}

	public String getValue() {
		return value;
	}

	public String getVolumeBelow() {
		return volumeBelow;
	}

	public String getValueBelow() {
		return valueBelow;
	}

	public String getVolumeAbove() {
		return volumeAbove;
	}

	public String getValueAbove() {
		return valueAbove;
	}

	public void setCsrMisEntity_PK(CsrMisEntity_PK csrMisEntity_PK) {
		this.csrMisEntity_PK = csrMisEntity_PK;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setVolumeBelow(String volumeBelow) {
		this.volumeBelow = volumeBelow;
	}

	public void setValueBelow(String valueBelow) {
		this.valueBelow = valueBelow;
	}

	public void setVolumeAbove(String volumeAbove) {
		this.volumeAbove = volumeAbove;
	}

	public void setValueAbove(String valueAbove) {
		this.valueAbove = valueAbove;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((csrMisEntity_PK == null) ? 0 : csrMisEntity_PK.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((valueAbove == null) ? 0 : valueAbove.hashCode());
		result = prime * result + ((valueBelow == null) ? 0 : valueBelow.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
		result = prime * result + ((volumeAbove == null) ? 0 : volumeAbove.hashCode());
		result = prime * result + ((volumeBelow == null) ? 0 : volumeBelow.hashCode());
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
		CsrMisEntity other = (CsrMisEntity) obj;
		if (csrMisEntity_PK == null) {
			if (other.csrMisEntity_PK != null)
				return false;
		} else if (!csrMisEntity_PK.equals(other.csrMisEntity_PK))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (valueAbove == null) {
			if (other.valueAbove != null)
				return false;
		} else if (!valueAbove.equals(other.valueAbove))
			return false;
		if (valueBelow == null) {
			if (other.valueBelow != null)
				return false;
		} else if (!valueBelow.equals(other.valueBelow))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		if (volumeAbove == null) {
			if (other.volumeAbove != null)
				return false;
		} else if (!volumeAbove.equals(other.volumeAbove))
			return false;
		if (volumeBelow == null) {
			if (other.volumeBelow != null)
				return false;
		} else if (!volumeBelow.equals(other.volumeBelow))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsrMisEntity [csrMisEntity_PK=");
		builder.append(csrMisEntity_PK);
		builder.append(", service=");
		builder.append(service);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", value=");
		builder.append(value);
		builder.append(", volumeBelow=");
		builder.append(volumeBelow);
		builder.append(", valueBelow=");
		builder.append(valueBelow);
		builder.append(", volumeAbove=");
		builder.append(volumeAbove);
		builder.append(", valueAbove=");
		builder.append(valueAbove);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}

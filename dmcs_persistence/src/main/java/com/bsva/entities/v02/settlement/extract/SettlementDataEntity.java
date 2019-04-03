package com.bsva.entities.v02.settlement.extract;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class SettlementDataEntity implements Serializable {

	@EmbeddedId
	private SettlementDataKey id;
	@Column(name = "DR_VOLUME")
	private Long dbVolume;
	@Column(name = "DR_VALUE")
	private Double dbValue;
	@Column(name = "CR_VOLUME")
	private Long crVolume;
	@Column(name = "CR_VALUE")
	private Double crValue;
	@Column(name = "CURRENCY_CODE")
	private String currencyCode;

	public SettlementDataKey getId() {
		return id;
	}

	public void setId(SettlementDataKey id) {
		this.id = id;
	}

	public Long getDbVolume() {
		return dbVolume;
	}

	public void setDbVolume(Long dbVolume) {
		this.dbVolume = dbVolume;
	}

	public Double getDbValue() {
		return dbValue;
	}

	public void setDbValue(Double dbValue) {
		this.dbValue = dbValue;
	}

	public Long getCrVolume() {
		return crVolume;
	}

	public void setCrVolume(Long crVolume) {
		this.crVolume = crVolume;
	}

	public Double getCrValue() {
		return crValue;
	}

	public void setCrValue(Double crValue) {
		this.crValue = crValue;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crValue == null) ? 0 : crValue.hashCode());
		result = prime * result + ((crVolume == null) ? 0 : crVolume.hashCode());
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((dbValue == null) ? 0 : dbValue.hashCode());
		result = prime * result + ((dbVolume == null) ? 0 : dbVolume.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SettlementDataEntity other = (SettlementDataEntity) obj;
		if (crValue == null) {
			if (other.crValue != null)
				return false;
		} else if (!crValue.equals(other.crValue))
			return false;
		if (crVolume == null) {
			if (other.crVolume != null)
				return false;
		} else if (!crVolume.equals(other.crVolume))
			return false;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (dbValue == null) {
			if (other.dbValue != null)
				return false;
		} else if (!dbValue.equals(other.dbValue))
			return false;
		if (dbVolume == null) {
			if (other.dbVolume != null)
				return false;
		} else if (!dbVolume.equals(other.dbVolume))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SettlementDataEntity [id=");
		builder.append(id);
		builder.append(", dbVolume=");
		builder.append(dbVolume);
		builder.append(", dbValue=");
		builder.append(dbValue);
		builder.append(", crVolume=");
		builder.append(crVolume);
		builder.append(", crValue=");
		builder.append(crValue);
		builder.append(", currencyCode=");
		builder.append(currencyCode);
		builder.append("]");
		return builder.toString();
	}
}

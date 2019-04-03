package com.bsva.entities.v02.loader;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CSF_CHGBACK_RSN_CODES_MCARD")
public class McardChargeBacksEntity {
	
	@EmbeddedId
	private McardChargeBacksEntity_PK mcardID;
	
	@Column(name="REASON_CODE")
    private Integer reasonCode;
	
	public McardChargeBacksEntity() {
	}

	public McardChargeBacksEntity(McardChargeBacksEntity_PK mcardID, Integer reasonCode) {
		this.mcardID = mcardID;
		this.reasonCode = reasonCode;
	}

	public McardChargeBacksEntity_PK getMcardID() {
		return mcardID;
	}

	public Integer getReasonCode() {
		return reasonCode;
	}

	public void setMcardID(McardChargeBacksEntity_PK mcardID) {
		this.mcardID = mcardID;
	}

	public void setReasonCode(Integer reasonCode) {
		this.reasonCode = reasonCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mcardID == null) ? 0 : mcardID.hashCode());
		result = prime * result + ((reasonCode == null) ? 0 : reasonCode.hashCode());
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
		McardChargeBacksEntity other = (McardChargeBacksEntity) obj;
		if (mcardID == null) {
			if (other.mcardID != null)
				return false;
		}
		else if (!mcardID.equals(other.mcardID))
			return false;
		if (reasonCode == null) {
			if (other.reasonCode != null)
				return false;
		}
		else if (!reasonCode.equals(other.reasonCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("McardChargeBacksEntity [mcardID=");
		builder.append(mcardID);
		builder.append(", reasonCode=");
		builder.append(reasonCode);
		builder.append("]");
		return builder.toString();
	}

}

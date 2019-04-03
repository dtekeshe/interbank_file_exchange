package com.bsva.entities.v02.loader;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CSF_CHGBACK_RSN_CODES_VISA")
public class VisaChargeBacksEntity {

	@Id
	@Column(name="REASON_CODE")
	private String reasonCode;

	public VisaChargeBacksEntity(){
		
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		VisaChargeBacksEntity other = (VisaChargeBacksEntity) obj;
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
		builder.append("VisaChargeBacksEntity [reasonCode=");
		builder.append(reasonCode);
		builder.append("]");
		return builder.toString();
	}



}

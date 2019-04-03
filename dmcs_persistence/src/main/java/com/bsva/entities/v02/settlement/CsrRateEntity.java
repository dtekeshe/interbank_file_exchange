package com.bsva.entities.v02.settlement;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author AugustineA
 *
 */
@Entity
@Table(name="CSV_PAYMENT_RATES_VIEW")
public class CsrRateEntity {

	@EmbeddedId
	private CsrRateEntityKey id;
	
	@Column(name="SUB_SERVICE")
	private String subServices;

	public CsrRateEntity(){
		
	}

	public CsrRateEntityKey getId() {
		return id;
	}

	public String getSubServices() {
		return subServices;
	}

	public void setId(CsrRateEntityKey id) {
		this.id = id;
	}

	public void setSubServices(String subServices) {
		this.subServices = subServices;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((subServices == null) ? 0 : subServices.hashCode());
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
		CsrRateEntity other = (CsrRateEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		if (subServices == null) {
			if (other.subServices != null)
				return false;
		}
		else if (!subServices.equals(other.subServices))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsrRateEntity [id=");
		builder.append(id);
		builder.append(", subServices=");
		builder.append(subServices);
		builder.append("]");
		return builder.toString();
	}
	
}

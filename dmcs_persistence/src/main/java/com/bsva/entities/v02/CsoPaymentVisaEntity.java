package com.bsva.entities.v02;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "CSO_PAYMENT_INSTRUCTIONS_VISA")
@DynamicUpdate
public class CsoPaymentVisaEntity implements Serializable{
   
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private CsoPaymentVisaEntity_PK id;
	
	public CsoPaymentVisaEntity(){
		
	}

	public CsoPaymentVisaEntity_PK getId() {
		return id;
	}

	public void setId(CsoPaymentVisaEntity_PK id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		CsoPaymentVisaEntity other = (CsoPaymentVisaEntity) obj;
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
		builder.append("CsoPaymentVisaEntity [id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	
}

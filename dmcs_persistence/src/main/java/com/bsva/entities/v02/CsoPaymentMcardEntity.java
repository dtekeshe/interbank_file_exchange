package com.bsva.entities.v02;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "CSO_PAYMENT_INSTRUCTIONS_MCARD")
@DynamicUpdate
public class CsoPaymentMcardEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CsoPaymentMcardEntity_PK id;
	
	public CsoPaymentMcardEntity(){
		
	}

	public CsoPaymentMcardEntity_PK getId() {
		return id;
	}

	public void setId(CsoPaymentMcardEntity_PK id) {
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
		CsoPaymentMcardEntity other = (CsoPaymentMcardEntity) obj;
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
		builder.append("CsoPaymentMcardEntity [id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	

	
	
}

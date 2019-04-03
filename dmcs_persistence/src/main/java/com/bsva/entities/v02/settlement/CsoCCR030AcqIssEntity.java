package com.bsva.entities.v02.settlement;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class CsoCCR030AcqIssEntity {

	@EmbeddedId
	CsoCCR030AcqIssEntityKey id;
	
	public CsoCCR030AcqIssEntity(){
		
	}

	public CsoCCR030AcqIssEntityKey getId() {
		return id;
	}


	public void setId(CsoCCR030AcqIssEntityKey id) {
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
		CsoCCR030AcqIssEntity other = (CsoCCR030AcqIssEntity) obj;
		
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsoCCR030AcqIssMcardEntity [id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	
}

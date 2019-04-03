package com.bsva.entities.v02;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name = "CSO_ACQUIRER_ISSUER_PAIR")
@DynamicUpdate
public class IssuerAcquirerEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private IssuerAcquirerEntity_PK id;
	@Column(name = "STATUS")
	private String status;
	
	
	public IssuerAcquirerEntity(){
		
	}


	/**
	 * @param id
	 * @param status
	 */
	public IssuerAcquirerEntity(IssuerAcquirerEntity_PK id, String status) {
		this.id = id;
		this.status = status;
	}


	public IssuerAcquirerEntity_PK getId() {
		return id;
	}


	public String getStatus() {
		return status;
	}


	public void setId(IssuerAcquirerEntity_PK id) {
		this.id = id;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		IssuerAcquirerEntity other = (IssuerAcquirerEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append(status);
		return builder.toString();
	}

}

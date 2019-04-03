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
@Table(name="CSF_CARD_RATE_LOOKUP")
public class CsrlkUpEntity {
	@EmbeddedId
	private CsrlkUpEntityKey Id;
	@Column(name="SERVICE")
	private String service;
	@Column(name="SUB_SERVICE")
	private String subService;
	
	public CsrlkUpEntity(){
		
	}

	public CsrlkUpEntityKey getId() {
		return Id;
	}

	public String getService() {
		return service;
	}

	public String getSubService() {
		return subService;
	}

	public void setId(CsrlkUpEntityKey Id) {
		this.Id = Id;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setSubService(String subService) {
		this.subService = subService;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result + ((subService == null) ? 0 : subService.hashCode());
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
		CsrlkUpEntity other = (CsrlkUpEntity) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		}
		else if (!Id.equals(other.Id))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		}
		else if (!service.equals(other.service))
			return false;
		if (subService == null) {
			if (other.subService != null)
				return false;
		}
		else if (!subService.equals(other.subService))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsrlkUpEntity [Id=");
		builder.append(Id);
		builder.append(", service=");
		builder.append(service);
		builder.append(", subService=");
		builder.append(subService);
		builder.append("]");
		return builder.toString();
	}
	
	

}

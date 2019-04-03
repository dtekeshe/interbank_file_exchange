package com.bsva.entities.v02.outputcontrols;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OutputFileKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name= "SERVICE")
	private String service;
	@Column(name="SUB_SERVICE")
	private String subService;
	@Column(name="FILENAME_DESCRIPTION")
	private String fileNameDescription;
	
	
	public String getService() {
		return service;
	}
	public String getSubService() {
		return subService;
	}
	public String getFileNameDescription() {
		return fileNameDescription;
	}
	public void setService(String service) {
		this.service = service;
	}
	public void setSubService(String subService) {
		this.subService = subService;
	}
	public void setFileNameDescription(String fileNameDescription) {
		this.fileNameDescription = fileNameDescription;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileNameDescription == null) ? 0 : fileNameDescription.hashCode());
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
		OutputFileKey other = (OutputFileKey) obj;
		if (fileNameDescription == null) {
			if (other.fileNameDescription != null)
				return false;
		} else if (!fileNameDescription.equals(other.fileNameDescription))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (subService == null) {
			if (other.subService != null)
				return false;
		} else if (!subService.equals(other.subService))
			return false;
		return true;
	}
	

}

package com.bsva.dao.v02.fileextract;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="CSO_PAYMENT_INSTRUCTIONS_VISA")
@DynamicUpdate
public class PaymentInstVISAEntity  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PaymentInstVISA_PK pkId;
	
	@Column(name="FILE_REF_NUMBER")
	private String fileRefNumber;
	@Column(name = "SERVICE")
	private String service;
	@Column(name="SUB_SERVICE")
	private String subService;
	@Column(name="FILENAME_DESCRIPTION")
	private String fileNameDescription;
	
	public PaymentInstVISAEntity(){
		
	}

	public PaymentInstVISAEntity(PaymentInstVISA_PK pkId, String fileRefNumber, String service, String subService,
			String fileNameDescription) {
		super();
		this.pkId = pkId;
		this.fileRefNumber = fileRefNumber;
		this.service = service;
		this.subService = subService;
		this.fileNameDescription = fileNameDescription;
	}

	public PaymentInstVISA_PK getPkId() {
		return pkId;
	}

	public String getFileRefNumber() {
		return fileRefNumber;
	}

	public String getService() {
		return service;
	}

	public String getSubService() {
		return subService;
	}

	public String getFileNameDescription() {
		return fileNameDescription;
	}

	public void setPkId(PaymentInstVISA_PK pkId) {
		this.pkId = pkId;
	}

	public void setFileRefNumber(String fileRefNumber) {
		this.fileRefNumber = fileRefNumber;
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
		result = prime * result + ((fileRefNumber == null) ? 0 : fileRefNumber.hashCode());
		result = prime * result + ((pkId == null) ? 0 : pkId.hashCode());
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
		PaymentInstVISAEntity other = (PaymentInstVISAEntity) obj;
		if (fileNameDescription == null) {
			if (other.fileNameDescription != null)
				return false;
		} else if (!fileNameDescription.equals(other.fileNameDescription))
			return false;
		if (fileRefNumber == null) {
			if (other.fileRefNumber != null)
				return false;
		} else if (!fileRefNumber.equals(other.fileRefNumber))
			return false;
		if (pkId == null) {
			if (other.pkId != null)
				return false;
		} else if (!pkId.equals(other.pkId))
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaymentInstVISAEntity [pkId=");
		builder.append(pkId);
		builder.append(", fileRefNumber=");
		builder.append(fileRefNumber);
		builder.append(", service=");
		builder.append(service);
		builder.append(", subService=");
		builder.append(subService);
		builder.append(", fileNameDescription=");
		builder.append(fileNameDescription);
		builder.append("]");
		return builder.toString();
	}

}

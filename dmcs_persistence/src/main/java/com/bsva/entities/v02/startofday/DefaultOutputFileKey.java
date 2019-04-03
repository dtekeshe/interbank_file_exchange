package com.bsva.entities.v02.startofday;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class DefaultOutputFileKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "SERVICE_ID")
    private String serviceID;
    @Column(name = "SUB_SERVICE_ID")
    private String subServiceID;
    @Column(name = "DEST_BANK_CODE")
    private Integer destBankCode;
    @Column(name = "ORIGIN_BANK_CODE")
    private Integer originBankCode;
    @Column(name = "FILENAME_PREFIX")
    private String filenamePrefix;
    @Transient
    private Integer seqNumber;
    @Transient
    private String filenameDescription;
    
    public DefaultOutputFileKey(){
    	
    }

	public String getServiceID() {
		return serviceID;
	}

	public String getSubServiceID() {
		return subServiceID;
	}

	public Integer getDestBankCode() {
		return destBankCode;
	}

	public Integer getOriginBankCode() {
		return originBankCode;
	}

	public String getFilenamePrefix() {
		return filenamePrefix;
	}

	public Integer getSeqNumber() {
		return seqNumber;
	}

	public String getFilenameDescription() {
		return filenameDescription;
	}

	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}

	public void setSubServiceID(String subServiceID) {
		this.subServiceID = subServiceID;
	}

	public void setDestBankCode(Integer destBankCode) {
		this.destBankCode = destBankCode;
	}

	public void setOriginBankCode(Integer originBankCode) {
		this.originBankCode = originBankCode;
	}

	public void setFilenamePrefix(String filenamePrefix) {
		this.filenamePrefix = filenamePrefix;
	}

	public void setSeqNumber(Integer seqNumber) {
		this.seqNumber = seqNumber;
	}

	public void setFilenameDescription(String filenameDescription) {
		this.filenameDescription = filenameDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destBankCode == null) ? 0 : destBankCode.hashCode());
		result = prime * result + ((filenameDescription == null) ? 0 : filenameDescription.hashCode());
		result = prime * result + ((filenamePrefix == null) ? 0 : filenamePrefix.hashCode());
		result = prime * result + ((originBankCode == null) ? 0 : originBankCode.hashCode());
		result = prime * result + ((seqNumber == null) ? 0 : seqNumber.hashCode());
		result = prime * result + ((serviceID == null) ? 0 : serviceID.hashCode());
		result = prime * result + ((subServiceID == null) ? 0 : subServiceID.hashCode());
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
		DefaultOutputFileKey other = (DefaultOutputFileKey) obj;
		if (destBankCode == null) {
			if (other.destBankCode != null)
				return false;
		}
		else if (!destBankCode.equals(other.destBankCode))
			return false;
		if (filenameDescription == null) {
			if (other.filenameDescription != null)
				return false;
		}
		else if (!filenameDescription.equals(other.filenameDescription))
			return false;
		if (filenamePrefix == null) {
			if (other.filenamePrefix != null)
				return false;
		}
		else if (!filenamePrefix.equals(other.filenamePrefix))
			return false;
		if (originBankCode == null) {
			if (other.originBankCode != null)
				return false;
		}
		else if (!originBankCode.equals(other.originBankCode))
			return false;
		if (seqNumber == null) {
			if (other.seqNumber != null)
				return false;
		}
		else if (!seqNumber.equals(other.seqNumber))
			return false;
		if (serviceID == null) {
			if (other.serviceID != null)
				return false;
		}
		else if (!serviceID.equals(other.serviceID))
			return false;
		if (subServiceID == null) {
			if (other.subServiceID != null)
				return false;
		}
		else if (!subServiceID.equals(other.subServiceID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DefaultOutputFileKey [serviceID=");
		builder.append(serviceID);
		builder.append(", subServiceID=");
		builder.append(subServiceID);
		builder.append(", destBankCode=");
		builder.append(destBankCode);
		builder.append(", originBankCode=");
		builder.append(originBankCode);
		builder.append(", filenamePrefix=");
		builder.append(filenamePrefix);
		builder.append(", seqNumber=");
		builder.append(seqNumber);
		builder.append(", filenameDescription=");
		builder.append(filenameDescription);
		builder.append("]");
		return builder.toString();
	}

	
	
}

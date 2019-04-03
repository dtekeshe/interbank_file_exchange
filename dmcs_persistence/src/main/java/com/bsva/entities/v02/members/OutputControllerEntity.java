package com.bsva.entities.v02.members;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name="CSO_OUTPUT_CONTROLS")
@DynamicUpdate
public class OutputControllerEntity {
    @Id
	@Column(name="FILENAME_DESCRIPTION")
	private String fileNameDescription;
	@Column(name="SERVICE")
	private String service;
	@Column(name="SUB_SERVICE")
	private String subService;
	@Column(name="DISTRIBUTION_CODE")
	private String distributionCode;
	@Column(name="FILENAME_PREFIX")
	private String fileNamePrefix;
	@Column(name="FULLFILEIND")
	private String fullFileIndicator; 
	@Column(name="ORIGINATING_MEMBER")
	private String originatingMember;
	@Column(name="BANK_CODE")
	private String bankCode;
	@Column(name="CR_VOLUME")
	private String crVolume;
	@Column(name="DR_VOLUME")
	private String drVolume;
	@Column(name="CR_VALUE")
	private String crValue;
	@Column(name="DR_VALUE")
	private String drValue;
	@Column(name="RECORD_COUNT")
	private String recordCount;
	@Column(name="SEQ_NUMBER")
	private String seqNumber;
	
	public OutputControllerEntity(){
		
	}

	public String getFileNameDescription() {
		return fileNameDescription;
	}

	public String getService() {
		return service;
	}

	public String getSubService() {
		return subService;
	}

	public String getDistributionCode() {
		return distributionCode;
	}

	public String getFileNamePrefix() {
		return fileNamePrefix;
	}

	public String getFullFileIndicator() {
		return fullFileIndicator;
	}

	public String getOriginatingMember() {
		return originatingMember;
	}

	public String getBankCode() {
		return bankCode;
	}

	public String getCrVolume() {
		return crVolume;
	}

	public String getDrVolume() {
		return drVolume;
	}

	public String getCrValue() {
		return crValue;
	}

	public String getDrValue() {
		return drValue;
	}

	public String getRecordCount() {
		return recordCount;
	}

	public String getSeqNumber() {
		return seqNumber;
	}

	public void setFileNameDescription(String fileNameDescription) {
		this.fileNameDescription = fileNameDescription;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setSubService(String subService) {
		this.subService = subService;
	}

	public void setDistributionCode(String distributionCode) {
		this.distributionCode = distributionCode;
	}

	public void setFileNamePrefix(String fileNamePrefix) {
		this.fileNamePrefix = fileNamePrefix;
	}

	public void setFullFileIndicator(String fullFileIndicator) {
		this.fullFileIndicator = fullFileIndicator;
	}

	public void setOriginatingMember(String originatingMember) {
		this.originatingMember = originatingMember;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public void setCrVolume(String crVolume) {
		this.crVolume = crVolume;
	}

	public void setDrVolume(String drVolume) {
		this.drVolume = drVolume;
	}

	public void setCrValue(String crValue) {
		this.crValue = crValue;
	}

	public void setDrValue(String drValue) {
		this.drValue = drValue;
	}

	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}

	public void setSeqNumber(String seqNumber) {
		this.seqNumber = seqNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankCode == null) ? 0 : bankCode.hashCode());
		result = prime * result + ((crValue == null) ? 0 : crValue.hashCode());
		result = prime * result + ((crVolume == null) ? 0 : crVolume.hashCode());
		result = prime * result + ((distributionCode == null) ? 0 : distributionCode.hashCode());
		result = prime * result + ((drValue == null) ? 0 : drValue.hashCode());
		result = prime * result + ((drVolume == null) ? 0 : drVolume.hashCode());
		result = prime * result + ((fileNameDescription == null) ? 0 : fileNameDescription.hashCode());
		result = prime * result + ((fileNamePrefix == null) ? 0 : fileNamePrefix.hashCode());
		result = prime * result + ((fullFileIndicator == null) ? 0 : fullFileIndicator.hashCode());
		result = prime * result + ((originatingMember == null) ? 0 : originatingMember.hashCode());
		result = prime * result + ((recordCount == null) ? 0 : recordCount.hashCode());
		result = prime * result + ((seqNumber == null) ? 0 : seqNumber.hashCode());
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
		OutputControllerEntity other = (OutputControllerEntity) obj;
		if (bankCode == null) {
			if (other.bankCode != null)
				return false;
		} else if (!bankCode.equals(other.bankCode))
			return false;
		if (crValue == null) {
			if (other.crValue != null)
				return false;
		} else if (!crValue.equals(other.crValue))
			return false;
		if (crVolume == null) {
			if (other.crVolume != null)
				return false;
		} else if (!crVolume.equals(other.crVolume))
			return false;
		if (distributionCode == null) {
			if (other.distributionCode != null)
				return false;
		} else if (!distributionCode.equals(other.distributionCode))
			return false;
		if (drValue == null) {
			if (other.drValue != null)
				return false;
		} else if (!drValue.equals(other.drValue))
			return false;
		if (drVolume == null) {
			if (other.drVolume != null)
				return false;
		} else if (!drVolume.equals(other.drVolume))
			return false;
		if (fileNameDescription == null) {
			if (other.fileNameDescription != null)
				return false;
		} else if (!fileNameDescription.equals(other.fileNameDescription))
			return false;
		if (fileNamePrefix == null) {
			if (other.fileNamePrefix != null)
				return false;
		} else if (!fileNamePrefix.equals(other.fileNamePrefix))
			return false;
		if (fullFileIndicator == null) {
			if (other.fullFileIndicator != null)
				return false;
		} else if (!fullFileIndicator.equals(other.fullFileIndicator))
			return false;
		if (originatingMember == null) {
			if (other.originatingMember != null)
				return false;
		} else if (!originatingMember.equals(other.originatingMember))
			return false;
		if (recordCount == null) {
			if (other.recordCount != null)
				return false;
		} else if (!recordCount.equals(other.recordCount))
			return false;
		if (seqNumber == null) {
			if (other.seqNumber != null)
				return false;
		} else if (!seqNumber.equals(other.seqNumber))
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
		builder.append("OutputControllerEntity [fileNameDescription=");
		builder.append(fileNameDescription);
		builder.append(", service=");
		builder.append(service);
		builder.append(", subService=");
		builder.append(subService);
		builder.append(", distributionCode=");
		builder.append(distributionCode);
		builder.append(", fileNamePrefix=");
		builder.append(fileNamePrefix);
		builder.append(", fullFileIndicator=");
		builder.append(fullFileIndicator);
		builder.append(", originatingMember=");
		builder.append(originatingMember);
		builder.append(", bankCode=");
		builder.append(bankCode);
		builder.append(", crVolume=");
		builder.append(crVolume);
		builder.append(", drVolume=");
		builder.append(drVolume);
		builder.append(", crValue=");
		builder.append(crValue);
		builder.append(", drValue=");
		builder.append(drValue);
		builder.append(", recordCount=");
		builder.append(recordCount);
		builder.append(", seqNumber=");
		builder.append(seqNumber);
		builder.append("]");
		return builder.toString();
	}

	
}
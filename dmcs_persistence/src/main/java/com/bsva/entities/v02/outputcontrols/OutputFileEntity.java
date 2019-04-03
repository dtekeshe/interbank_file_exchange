package com.bsva.entities.v02.outputcontrols;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class OutputFileEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private OutputFileKey  id;
	@Column(name= "BANK_CODE")
	private String bankCode;
	
	@Column(name = "FILENAME_PREFIX")
	private String filenamePrefix;
	
	@Column(name= "ORIGINATING_MEMBER")
	private String originatingMember;
	
	@Column(name= "FULLFILEIND")
	private String fullFileIndicator;
	
	@Column(name = "DISTRIBUTION_CODE")
	private String distributionCode;
	
	@Column(name= "RECORD_COUNT")
	private String recordCount;
	
	@Column(name= "SEQ_NUMBER")
	private String seqNumber;
	
	@Column(name= "HASH_TOTAL_99")
	private String hashTotal;
	
	@Column(name= "STATUS_CODE")
	private String statusCode;
	
	@Column(name= "LAST_FILE_INDICATOR")
	private String lasteFileIndicator;
	
	@Column(name= "DR_VALUE")
	private String drvalue;
	
	@Column(name = "RECORD_COUNT_FOR_DAY")
    private Long recordCountForDay;
	
    @Column(name = "DR_VALUE_FOR_DAY")
    private Long drValueForDay;
	

	public OutputFileKey getId() {
		return id;
	}

	public void setId(OutputFileKey id) {
		this.id = id;
	}

	public String getBankCode() {
		return bankCode;
	}

	public String getOriginatingMember() {
		return originatingMember;
	}

	public String getFullFileIndicator() {
		return fullFileIndicator;
	}

	public String getRecordCount() {
		return recordCount;
	}

	public String getHashTotal() {
		return hashTotal;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public void setOriginatingMember(String originatingMember) {
		this.originatingMember = originatingMember;
	}

	public void setFullFileIndicator(String fullFileIndicator) {
		this.fullFileIndicator = fullFileIndicator;
	}

	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}

	public String getSeqNumber() {
		return seqNumber;
	}

	public void setSeqNumber(String seqNumber) {
		this.seqNumber = seqNumber;
	}

	public void setHashTotal(String hashTotal) {
		this.hashTotal = hashTotal;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getLasteFileIndicator() {
		return lasteFileIndicator;
	}

	public void setLasteFileIndicator(String lasteFileIndicator) {
		this.lasteFileIndicator = lasteFileIndicator;
	}

	public String getDrvalue() {
		return drvalue;
	}

	public void setDrvalue(String drvalue) {
		this.drvalue = drvalue;
	}

	public Long getRecordCountForDay() {
		return recordCountForDay;
	}

	public Long getDrValueForDay() {
		return drValueForDay;
	}

	public void setRecordCountForDay(Long recordCountForDay) {
		this.recordCountForDay = recordCountForDay;
	}

	public void setDrValueForDay(Long drValueForDay) {
		this.drValueForDay = drValueForDay;
	}

	public String getFilenamePrefix() {
		return filenamePrefix;
	}

	public void setFilenamePrefix(String filenamePrefix) {
		this.filenamePrefix = filenamePrefix;
	}

	public String getDistributionCode() {
		return distributionCode;
	}

	public void setDistributionCode(String distributionCode) {
		this.distributionCode = distributionCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankCode == null) ? 0 : bankCode.hashCode());
		result = prime * result + ((distributionCode == null) ? 0 : distributionCode.hashCode());
		result = prime * result + ((drValueForDay == null) ? 0 : drValueForDay.hashCode());
		result = prime * result + ((drvalue == null) ? 0 : drvalue.hashCode());
		result = prime * result + ((filenamePrefix == null) ? 0 : filenamePrefix.hashCode());
		result = prime * result + ((fullFileIndicator == null) ? 0 : fullFileIndicator.hashCode());
		result = prime * result + ((hashTotal == null) ? 0 : hashTotal.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lasteFileIndicator == null) ? 0 : lasteFileIndicator.hashCode());
		result = prime * result + ((originatingMember == null) ? 0 : originatingMember.hashCode());
		result = prime * result + ((recordCount == null) ? 0 : recordCount.hashCode());
		result = prime * result + ((recordCountForDay == null) ? 0 : recordCountForDay.hashCode());
		result = prime * result + ((seqNumber == null) ? 0 : seqNumber.hashCode());
		result = prime * result + ((statusCode == null) ? 0 : statusCode.hashCode());
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
		OutputFileEntity other = (OutputFileEntity) obj;
		if (bankCode == null) {
			if (other.bankCode != null)
				return false;
		} else if (!bankCode.equals(other.bankCode))
			return false;
		if (distributionCode == null) {
			if (other.distributionCode != null)
				return false;
		} else if (!distributionCode.equals(other.distributionCode))
			return false;
		if (drValueForDay == null) {
			if (other.drValueForDay != null)
				return false;
		} else if (!drValueForDay.equals(other.drValueForDay))
			return false;
		if (drvalue == null) {
			if (other.drvalue != null)
				return false;
		} else if (!drvalue.equals(other.drvalue))
			return false;
		if (filenamePrefix == null) {
			if (other.filenamePrefix != null)
				return false;
		} else if (!filenamePrefix.equals(other.filenamePrefix))
			return false;
		if (fullFileIndicator == null) {
			if (other.fullFileIndicator != null)
				return false;
		} else if (!fullFileIndicator.equals(other.fullFileIndicator))
			return false;
		if (hashTotal == null) {
			if (other.hashTotal != null)
				return false;
		} else if (!hashTotal.equals(other.hashTotal))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lasteFileIndicator == null) {
			if (other.lasteFileIndicator != null)
				return false;
		} else if (!lasteFileIndicator.equals(other.lasteFileIndicator))
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
		if (recordCountForDay == null) {
			if (other.recordCountForDay != null)
				return false;
		} else if (!recordCountForDay.equals(other.recordCountForDay))
			return false;
		if (seqNumber == null) {
			if (other.seqNumber != null)
				return false;
		} else if (!seqNumber.equals(other.seqNumber))
			return false;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OutputFileEntity [id=");
		builder.append(id);
		builder.append(", bankCode=");
		builder.append(bankCode);
		builder.append(", filenamePrefix=");
		builder.append(filenamePrefix);
		builder.append(", originatingMember=");
		builder.append(originatingMember);
		builder.append(", fullFileIndicator=");
		builder.append(fullFileIndicator);
		builder.append(", distributionCode=");
		builder.append(distributionCode);
		builder.append(", recordCount=");
		builder.append(recordCount);
		builder.append(", seqNumber=");
		builder.append(seqNumber);
		builder.append(", hashTotal=");
		builder.append(hashTotal);
		builder.append(", statusCode=");
		builder.append(statusCode);
		builder.append(", lasteFileIndicator=");
		builder.append(lasteFileIndicator);
		builder.append(", drvalue=");
		builder.append(drvalue);
		builder.append(", recordCountForDay=");
		builder.append(recordCountForDay);
		builder.append(", drValueForDay=");
		builder.append(drValueForDay);
		builder.append("]");
		return builder.toString();
	}


	

}

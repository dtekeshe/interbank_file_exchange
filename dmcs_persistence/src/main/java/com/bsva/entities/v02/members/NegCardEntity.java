package com.bsva.entities.v02.members;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="CSO_NEGATIVE_CARDS")
@DynamicUpdate
public class NegCardEntity {
	
	@Column(name = "FILE_REF_NUMBER")
	private String fileRefNumber;
	@Id
	@Column(name="SYSTEM_SEQ_NUMBER")
	private String sysSeqNumber;
	@Column(name="TRANSACTION_CODE")
	private String transCode;
	
	public NegCardEntity(){
		
	}

	public String getFileRefNumber() {
		return fileRefNumber;
	}

	public String getSysSeqNumber() {
		return sysSeqNumber;
	}

	public String getTransCode() {
		return transCode;
	}

	public void setFileRefNumber(String fileRefNumber) {
		this.fileRefNumber = fileRefNumber;
	}

	public void setSysSeqNumber(String sysSeqNumber) {
		this.sysSeqNumber = sysSeqNumber;
	}

	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileRefNumber == null) ? 0 : fileRefNumber.hashCode());
		result = prime * result + ((sysSeqNumber == null) ? 0 : sysSeqNumber.hashCode());
		result = prime * result + ((transCode == null) ? 0 : transCode.hashCode());
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
		NegCardEntity other = (NegCardEntity) obj;
		if (fileRefNumber == null) {
			if (other.fileRefNumber != null)
				return false;
		} else if (!fileRefNumber.equals(other.fileRefNumber))
			return false;
		if (sysSeqNumber == null) {
			if (other.sysSeqNumber != null)
				return false;
		} else if (!sysSeqNumber.equals(other.sysSeqNumber))
			return false;
		if (transCode == null) {
			if (other.transCode != null)
				return false;
		} else if (!transCode.equals(other.transCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NegCardEntity [fileRefNumber=");
		builder.append(fileRefNumber);
		builder.append(", sysSeqNumber=");
		builder.append(sysSeqNumber);
		builder.append(", transCode=");
		builder.append(transCode);
		builder.append("]");
		return builder.toString();
	}
	
	

}

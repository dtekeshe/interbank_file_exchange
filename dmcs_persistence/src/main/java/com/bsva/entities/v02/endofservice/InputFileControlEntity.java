package com.bsva.entities.v02.endofservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


@NamedQueries({
@NamedQuery(name="inputFile.findAll",
            query="SELECT s FROM InputFileControlEntity s")})

@Entity
@Table(name="CSO_INPUT_FILE_CONTROLS")
@DynamicUpdate
public class InputFileControlEntity{
	
	
	@Column(name="FILE_REF_NUMBER")
	@Id
	private String filename;
	@Column(name="SYSTEM_SEQ_NUMBER")
	private String systemSeqNumber;
	@Column(name="PROCESS_STATUS")
	private String processStatus;
	
	public InputFileControlEntity(){
		
	}

	public InputFileControlEntity(String filename, String systemSeqNumber, String processStatus) {
		super();
		this.filename = filename;
		this.systemSeqNumber = systemSeqNumber;
		this.processStatus = processStatus;
	}

	public String getFilename() {
		return filename;
	}

	public String getSystemSeqNumber() {
		return systemSeqNumber;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setSystemSeqNumber(String systemSeqNumber) {
		this.systemSeqNumber = systemSeqNumber;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filename == null) ? 0 : filename.hashCode());
		result = prime * result + ((processStatus == null) ? 0 : processStatus.hashCode());
		result = prime * result + ((systemSeqNumber == null) ? 0 : systemSeqNumber.hashCode());
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
		InputFileControlEntity other = (InputFileControlEntity) obj;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		if (processStatus == null) {
			if (other.processStatus != null)
				return false;
		} else if (!processStatus.equals(other.processStatus))
			return false;
		if (systemSeqNumber == null) {
			if (other.systemSeqNumber != null)
				return false;
		} else if (!systemSeqNumber.equals(other.systemSeqNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InputFileControlEntity [filename=");
		builder.append(filename);
		builder.append(", systemSeqNumber=");
		builder.append(systemSeqNumber);
		builder.append(", processStatus=");
		builder.append(processStatus);
		builder.append("]");
		return builder.toString();
	}

	

}

package com.bsva.entities.v02.loader;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CSO_FILE_SEQ")
public class CsoFileSeqEntity {
	
	
	@Column(name="FILE_SEQUENCE")
	private Integer fileSequence;
	@Id
	@Column(name="FILE_NAME")
	private String fileName;
	
	public CsoFileSeqEntity(){
		
	}

	public Integer getFileSequence() {
		return fileSequence;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileSequence(Integer fileSequence) {
		this.fileSequence = fileSequence;
	}

	public void setFileNamme(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((fileSequence == null) ? 0 : fileSequence.hashCode());
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
		CsoFileSeqEntity other = (CsoFileSeqEntity) obj;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		}
		else if (!fileName.equals(other.fileName))
			return false;
		if (fileSequence == null) {
			if (other.fileSequence != null)
				return false;
		}
		else if (!fileSequence.equals(other.fileSequence))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsoFileSeqEntity [fileSequence=");
		builder.append(fileSequence);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}

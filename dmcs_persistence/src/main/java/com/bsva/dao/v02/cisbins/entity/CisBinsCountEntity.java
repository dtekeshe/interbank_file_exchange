package com.bsva.dao.v02.cisbins.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CisBinsCountEntity {
	@Id
	@Column(name="TOT_COUNT")
	private String binTotalNumber;
	@Column(name="FINALLY_DEL")
	private String binDeleted;
	@Column(name="DEL_CYCLE")
	private String deletionCycle;
	@Column(name="TO_BE_DELTED")
	private String setForDeletion;
	@Column(name="ACT_BINS")
	private String activeBins;
	
	public CisBinsCountEntity(){
		
	}

	public String getBinTotalNumber() {
		return binTotalNumber;
	}

	public String getBinDeleted() {
		return binDeleted;
	}

	public String getDeletionCycle() {
		return deletionCycle;
	}

	public String getSetForDeletion() {
		return setForDeletion;
	}

	public String getActiveBins() {
		return activeBins;
	}

	public void setBinTotalNumber(String binTotalNumber) {
		this.binTotalNumber = binTotalNumber;
	}

	public void setBinDeleted(String binDeleted) {
		this.binDeleted = binDeleted;
	}

	public void setDeletionCycle(String deletionCycle) {
		this.deletionCycle = deletionCycle;
	}

	public void setSetForDeletion(String setForDeletion) {
		this.setForDeletion = setForDeletion;
	}

	public void setActiveBins(String activeBins) {
		this.activeBins = activeBins;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activeBins == null) ? 0 : activeBins.hashCode());
		result = prime * result + ((binDeleted == null) ? 0 : binDeleted.hashCode());
		result = prime * result + ((binTotalNumber == null) ? 0 : binTotalNumber.hashCode());
		result = prime * result + ((deletionCycle == null) ? 0 : deletionCycle.hashCode());
		result = prime * result + ((setForDeletion == null) ? 0 : setForDeletion.hashCode());
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
		CisBinsCountEntity other = (CisBinsCountEntity) obj;
		if (activeBins == null) {
			if (other.activeBins != null)
				return false;
		}
		else if (!activeBins.equals(other.activeBins))
			return false;
		if (binDeleted == null) {
			if (other.binDeleted != null)
				return false;
		}
		else if (!binDeleted.equals(other.binDeleted))
			return false;
		if (binTotalNumber == null) {
			if (other.binTotalNumber != null)
				return false;
		}
		else if (!binTotalNumber.equals(other.binTotalNumber))
			return false;
		if (deletionCycle == null) {
			if (other.deletionCycle != null)
				return false;
		}
		else if (!deletionCycle.equals(other.deletionCycle))
			return false;
		if (setForDeletion == null) {
			if (other.setForDeletion != null)
				return false;
		}
		else if (!setForDeletion.equals(other.setForDeletion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CisBinsCountEntity [binTotalNumber=");
		builder.append(binTotalNumber);
		builder.append(", binDeleted=");
		builder.append(binDeleted);
		builder.append(", deletionCycle=");
		builder.append(deletionCycle);
		builder.append(", setForDeletion=");
		builder.append(setForDeletion);
		builder.append(", activeBins=");
		builder.append(activeBins);
		builder.append("]");
		return builder.toString();
	}

	
}

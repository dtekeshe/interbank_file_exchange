package com.bsva.dao.v02.cisbins.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class CisBinsEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="BIN_NO")
	private String binNo;
	@Column(name="DELETION_DATE")
	private String DeletionDate;
	@Column(name="PROCESS_DATE")
	private String ProcessDate;
	@Column(name="MONTHS_UNTIL_CIS_BIN_DELETION")
	private String monthsUntilCisBinDeletion;
	@Column(name="PROCESS_ACTIVE_IND")
	private String processActiveInd;
	@Column(name="BANK_CODE")
	private String bankCode;
	@Column(name="BIN_DESCRIPTION")
	private String binDescription;
	@Column(name="CARD_TYPE")
	private String cardType;
	@Column(name="OLD_CARD_TYPE")
	private String oldCardType;
	@Column(name="FUEL_ALLOWED")
	private String fuelAllowed;
	@Column(name="ISS_ACQ_BOTH")
	private String issAcqBoth;
	@Column(name="LIVE_DATE")
	private String liveDate;
	
	
	public CisBinsEntity(){
		
	}
	
	public void setLiveDate(String liveDate) {
		this.liveDate = liveDate;
	}
	
	public String getLiveDate() {
		return liveDate;
	}


	public String getBinNo() {
		return binNo;
	}


	public String getDeletionDate() {
		return DeletionDate;
	}


	public String getProcessDate() {
		return ProcessDate;
	}


	public String getMonthsUntilCisBinDeletion() {
		return monthsUntilCisBinDeletion;
	}


	public String getProcessActiveInd() {
		return processActiveInd;
	}


	public String getBankCode() {
		return bankCode;
	}


	public String getBinDescription() {
		return binDescription;
	}


	public String getCardType() {
		return cardType;
	}


	public String getOldCardType() {
		return oldCardType;
	}


	public String getFuelAllowed() {
		return fuelAllowed;
	}


	public String getIssAcqBoth() {
		return issAcqBoth;
	}


	public void setBinNo(String binNo) {
		this.binNo = binNo;
	}


	public void setDeletionDate(String deletionDate) {
		DeletionDate = deletionDate;
	}


	public void setProcessDate(String processDate) {
		ProcessDate = processDate;
	}


	public void setMonthsUntilCisBinDeletion(String monthsUntilCisBinDeletion) {
		this.monthsUntilCisBinDeletion = monthsUntilCisBinDeletion;
	}


	public void setProcessActiveInd(String processActiveInd) {
		this.processActiveInd = processActiveInd;
	}


	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}


	public void setBinDescription(String binDescription) {
		this.binDescription = binDescription;
	}


	public void setCardType(String cardType) {
		this.cardType = cardType;
	}


	public void setOldCardType(String oldCardType) {
		this.oldCardType = oldCardType;
	}


	public void setFuelAllowed(String fuelAllowed) {
		this.fuelAllowed = fuelAllowed;
	}


	public void setIssAcqBoth(String issAcqBoth) {
		this.issAcqBoth = issAcqBoth;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DeletionDate == null) ? 0 : DeletionDate.hashCode());
		result = prime * result + ((ProcessDate == null) ? 0 : ProcessDate.hashCode());
		result = prime * result + ((bankCode == null) ? 0 : bankCode.hashCode());
		result = prime * result + ((binDescription == null) ? 0 : binDescription.hashCode());
		result = prime * result + ((binNo == null) ? 0 : binNo.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((fuelAllowed == null) ? 0 : fuelAllowed.hashCode());
		result = prime * result + ((issAcqBoth == null) ? 0 : issAcqBoth.hashCode());
		result = prime * result + ((monthsUntilCisBinDeletion == null) ? 0 : monthsUntilCisBinDeletion.hashCode());
		result = prime * result + ((oldCardType == null) ? 0 : oldCardType.hashCode());
		result = prime * result + ((processActiveInd == null) ? 0 : processActiveInd.hashCode());
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
		CisBinsEntity other = (CisBinsEntity) obj;
		if (DeletionDate == null) {
			if (other.DeletionDate != null)
				return false;
		}
		else if (!DeletionDate.equals(other.DeletionDate))
			return false;
		if (ProcessDate == null) {
			if (other.ProcessDate != null)
				return false;
		}
		else if (!ProcessDate.equals(other.ProcessDate))
			return false;
		if (bankCode == null) {
			if (other.bankCode != null)
				return false;
		}
		else if (!bankCode.equals(other.bankCode))
			return false;
		if (binDescription == null) {
			if (other.binDescription != null)
				return false;
		}
		else if (!binDescription.equals(other.binDescription))
			return false;
		if (binNo == null) {
			if (other.binNo != null)
				return false;
		}
		else if (!binNo.equals(other.binNo))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		}
		else if (!cardType.equals(other.cardType))
			return false;
		if (fuelAllowed == null) {
			if (other.fuelAllowed != null)
				return false;
		}
		else if (!fuelAllowed.equals(other.fuelAllowed))
			return false;
		if (issAcqBoth == null) {
			if (other.issAcqBoth != null)
				return false;
		}
		else if (!issAcqBoth.equals(other.issAcqBoth))
			return false;
		if (monthsUntilCisBinDeletion == null) {
			if (other.monthsUntilCisBinDeletion != null)
				return false;
		}
		else if (!monthsUntilCisBinDeletion.equals(other.monthsUntilCisBinDeletion))
			return false;
		if (oldCardType == null) {
			if (other.oldCardType != null)
				return false;
		}
		else if (!oldCardType.equals(other.oldCardType))
			return false;
		if (processActiveInd == null) {
			if (other.processActiveInd != null)
				return false;
		}
		else if (!processActiveInd.equals(other.processActiveInd))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CisBinsEntity [binNo=");
		builder.append(binNo);
		builder.append(", DeletionDate=");
		builder.append(DeletionDate);
		builder.append(", ProcessDate=");
		builder.append(ProcessDate);
		builder.append(", monthsUntilCisBinDeletion=");
		builder.append(monthsUntilCisBinDeletion);
		builder.append(", processActiveInd=");
		builder.append(processActiveInd);
		builder.append(", bankCode=");
		builder.append(bankCode);
		builder.append(", binDescription=");
		builder.append(binDescription);
		builder.append(", cardType=");
		builder.append(cardType);
		builder.append(", oldCardType=");
		builder.append(oldCardType);
		builder.append(", fuelAllowed=");
		builder.append(fuelAllowed);
		builder.append(", issAcqBoth=");
		builder.append(issAcqBoth);
		builder.append(", liveDate=");
		builder.append(liveDate);
		builder.append("]");
		return builder.toString();
	}

	

}

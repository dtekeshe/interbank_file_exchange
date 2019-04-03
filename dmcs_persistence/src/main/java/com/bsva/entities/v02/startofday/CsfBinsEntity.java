package com.bsva.entities.v02.startofday;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CSF_BINS")
public class CsfBinsEntity {
	
	@EmbeddedId
	private CsfBinsEntityPK csfBinsEntityPK;
	@Column(name="BIN_DESCRIPTION")
	private String binDescription;
	@Column(name="LIMIT_1")
	private String limit1;
	@Column(name="LIMIT_2")
	private String limit2;
	@Column(name="FLOOR_LIMIT")
	private String floorLimit;
	@Column(name="ROUTING")
	private String routing;
	@Column(name="FIRST_DELETION_DATE")
	private String firstDeletionDate;
	@Column(name="DAYS_BEFOREFIRST_DELETION_DATE")
	private String daysbeforeFirstDeletion;
	@Column(name="FINAL_DELETION_DATE")
	private String finalDeletion;
	@Column(name="DAYS_BEFOREFINAL_DELETION_DATE")
	private String DaysBeforeFinalDeletion;
	@Column(name="BIN_ACTIVE_IND")
	private String binActiveInd;
	@Column(name="ISS_ACQ_BOTH")
	private String issAcqBoth;
	@Column(name="FUEL_ALLOWED")
	private String fuelAllowed;
	
	public CsfBinsEntity(){
		
	}

	public CsfBinsEntityPK getCsfBinsEntityPK() {
		return csfBinsEntityPK;
	}

	public String getBinDescription() {
		return binDescription;
	}

	public String getLimit1() {
		return limit1;
	}

	public String getLimit2() {
		return limit2;
	}

	public String getFloorLimit() {
		return floorLimit;
	}

	public String getRouting() {
		return routing;
	}

	public String getFirstDeletionDate() {
		return firstDeletionDate;
	}

	public String getDaysbeforeFirstDeletion() {
		return daysbeforeFirstDeletion;
	}

	public String getFinalDeletion() {
		return finalDeletion;
	}

	public String getDaysBeforeFinalDeletion() {
		return DaysBeforeFinalDeletion;
	}

	public String getBinActiveInd() {
		return binActiveInd;
	}

	public String getIssAcqBoth() {
		return issAcqBoth;
	}

	public String getFuelAllowed() {
		return fuelAllowed;
	}

	public void setCsfBinsEntityPK(CsfBinsEntityPK csfBinsEntityPK) {
		this.csfBinsEntityPK = csfBinsEntityPK;
	}

	public void setBinDescription(String binDescription) {
		this.binDescription = binDescription;
	}

	public void setLimit1(String limit1) {
		this.limit1 = limit1;
	}

	public void setLimit2(String limit2) {
		this.limit2 = limit2;
	}

	public void setFloorLimit(String floorLimit) {
		this.floorLimit = floorLimit;
	}

	public void setRouting(String routing) {
		this.routing = routing;
	}

	public void setFirstDeletionDate(String firstDeletionDate) {
		this.firstDeletionDate = firstDeletionDate;
	}

	public void setDaysbeforeFirstDeletion(String daysbeforeFirstDeletion) {
		this.daysbeforeFirstDeletion = daysbeforeFirstDeletion;
	}

	public void setFinalDeletion(String finalDeletion) {
		this.finalDeletion = finalDeletion;
	}

	public void setDaysBeforeFinalDeletion(String daysBeforeFinalDeletion) {
		DaysBeforeFinalDeletion = daysBeforeFinalDeletion;
	}

	public void setBinActiveInd(String binActiveInd) {
		this.binActiveInd = binActiveInd;
	}

	public void setIssAcqBoth(String issAcqBoth) {
		this.issAcqBoth = issAcqBoth;
	}

	public void setFuelAllowed(String fuelAllowed) {
		this.fuelAllowed = fuelAllowed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DaysBeforeFinalDeletion == null) ? 0 : DaysBeforeFinalDeletion.hashCode());
		result = prime * result + ((binActiveInd == null) ? 0 : binActiveInd.hashCode());
		result = prime * result + ((binDescription == null) ? 0 : binDescription.hashCode());
		result = prime * result + ((csfBinsEntityPK == null) ? 0 : csfBinsEntityPK.hashCode());
		result = prime * result + ((daysbeforeFirstDeletion == null) ? 0 : daysbeforeFirstDeletion.hashCode());
		result = prime * result + ((finalDeletion == null) ? 0 : finalDeletion.hashCode());
		result = prime * result + ((firstDeletionDate == null) ? 0 : firstDeletionDate.hashCode());
		result = prime * result + ((floorLimit == null) ? 0 : floorLimit.hashCode());
		result = prime * result + ((fuelAllowed == null) ? 0 : fuelAllowed.hashCode());
		result = prime * result + ((issAcqBoth == null) ? 0 : issAcqBoth.hashCode());
		result = prime * result + ((limit1 == null) ? 0 : limit1.hashCode());
		result = prime * result + ((limit2 == null) ? 0 : limit2.hashCode());
		result = prime * result + ((routing == null) ? 0 : routing.hashCode());
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
		CsfBinsEntity other = (CsfBinsEntity) obj;
		if (DaysBeforeFinalDeletion == null) {
			if (other.DaysBeforeFinalDeletion != null)
				return false;
		}
		else if (!DaysBeforeFinalDeletion.equals(other.DaysBeforeFinalDeletion))
			return false;
		if (binActiveInd == null) {
			if (other.binActiveInd != null)
				return false;
		}
		else if (!binActiveInd.equals(other.binActiveInd))
			return false;
		if (binDescription == null) {
			if (other.binDescription != null)
				return false;
		}
		else if (!binDescription.equals(other.binDescription))
			return false;
		if (csfBinsEntityPK == null) {
			if (other.csfBinsEntityPK != null)
				return false;
		}
		else if (!csfBinsEntityPK.equals(other.csfBinsEntityPK))
			return false;
		if (daysbeforeFirstDeletion == null) {
			if (other.daysbeforeFirstDeletion != null)
				return false;
		}
		else if (!daysbeforeFirstDeletion.equals(other.daysbeforeFirstDeletion))
			return false;
		if (finalDeletion == null) {
			if (other.finalDeletion != null)
				return false;
		}
		else if (!finalDeletion.equals(other.finalDeletion))
			return false;
		if (firstDeletionDate == null) {
			if (other.firstDeletionDate != null)
				return false;
		}
		else if (!firstDeletionDate.equals(other.firstDeletionDate))
			return false;
		if (floorLimit == null) {
			if (other.floorLimit != null)
				return false;
		}
		else if (!floorLimit.equals(other.floorLimit))
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
		if (limit1 == null) {
			if (other.limit1 != null)
				return false;
		}
		else if (!limit1.equals(other.limit1))
			return false;
		if (limit2 == null) {
			if (other.limit2 != null)
				return false;
		}
		else if (!limit2.equals(other.limit2))
			return false;
		if (routing == null) {
			if (other.routing != null)
				return false;
		}
		else if (!routing.equals(other.routing))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsfBinsEntity [csfBinsEntityPK=");
		builder.append(csfBinsEntityPK);
		builder.append(", binDescription=");
		builder.append(binDescription);
		builder.append(", limit1=");
		builder.append(limit1);
		builder.append(", limit2=");
		builder.append(limit2);
		builder.append(", floorLimit=");
		builder.append(floorLimit);
		builder.append(", routing=");
		builder.append(routing);
		builder.append(", firstDeletionDate=");
		builder.append(firstDeletionDate);
		builder.append(", daysbeforeFirstDeletion=");
		builder.append(daysbeforeFirstDeletion);
		builder.append(", finalDeletion=");
		builder.append(finalDeletion);
		builder.append(", DaysBeforeFinalDeletion=");
		builder.append(DaysBeforeFinalDeletion);
		builder.append(", binActiveInd=");
		builder.append(binActiveInd);
		builder.append(", issAcqBoth=");
		builder.append(issAcqBoth);
		builder.append(", fuelAllowed=");
		builder.append(fuelAllowed);
		builder.append("]");
		return builder.toString();
	}
	

}

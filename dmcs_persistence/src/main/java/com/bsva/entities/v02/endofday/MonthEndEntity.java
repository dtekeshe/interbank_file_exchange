package com.bsva.entities.v02.endofday;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
@Entity
public class MonthEndEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="MONTH")
	private String month;
	@EmbeddedId
	private MonthEndEntityKey entityId;
	@Column(name="VALUE_ABOVE")
	private String valueAbove;
	@Column(name="VALUE_BELOW")
	private String valueBelow;
	@Column(name="VOLUME_ABOVE")
	private String volumeAbove;
	@Column(name="VOLUME_BELOW")
	private String volumeBelow;
	@Column(name="CHARGE_ABOVE")
	private String chargeAbove;
	@Column(name="CHARGE_BELOW")
	private String chargeBelow;
	@Column(name="TOTAL_CHARGE")
	private String totalCharge;
	@Column(name="TIERED_ITEM_CHARGE_ABOVE")
	private String tieredItemChargeAbove;
	@Column(name="TIERED_ITEM_CHARGE_BELOW")
	private String tieredItemChargeBelow;
	
	public MonthEndEntity(){
		
	}

	public String getMonth() {
		return month;
	}

	public MonthEndEntityKey getEntityId() {
		return entityId;
	}

	public String getValueAbove() {
		return valueAbove;
	}

	public String getValueBelow() {
		return valueBelow;
	}

	public String getVolumeAbove() {
		return volumeAbove;
	}

	public String getVolumeBelow() {
		return volumeBelow;
	}

	public String getChargeAbove() {
		return chargeAbove;
	}

	public String getChargeBelow() {
		return chargeBelow;
	}

	public String getTotalCharge() {
		return totalCharge;
	}

	public String getTieredItemChargeAbove() {
		return tieredItemChargeAbove;
	}

	public String getTieredItemChargeBelow() {
		return tieredItemChargeBelow;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setEntityId(MonthEndEntityKey entityId) {
		this.entityId = entityId;
	}

	public void setValueAbove(String valueAbove) {
		this.valueAbove = valueAbove;
	}

	public void setValueBelow(String valueBelow) {
		this.valueBelow = valueBelow;
	}

	public void setVolumeAbove(String volumeAbove) {
		this.volumeAbove = volumeAbove;
	}

	public void setVolumeBelow(String volumeBelow) {
		this.volumeBelow = volumeBelow;
	}

	public void setChargeAbove(String chargeAbove) {
		this.chargeAbove = chargeAbove;
	}

	public void setChargeBelow(String chargeBelow) {
		this.chargeBelow = chargeBelow;
	}

	public void setTotalCharge(String totalCharge) {
		this.totalCharge = totalCharge;
	}

	public void setTieredItemChargeAbove(String tieredItemChargeAbove) {
		this.tieredItemChargeAbove = tieredItemChargeAbove;
	}

	public void setTieredItemChargeBelow(String tieredItemChargeBelow) {
		this.tieredItemChargeBelow = tieredItemChargeBelow;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chargeAbove == null) ? 0 : chargeAbove.hashCode());
		result = prime * result + ((chargeBelow == null) ? 0 : chargeBelow.hashCode());
		result = prime * result + ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((tieredItemChargeAbove == null) ? 0 : tieredItemChargeAbove.hashCode());
		result = prime * result + ((tieredItemChargeBelow == null) ? 0 : tieredItemChargeBelow.hashCode());
		result = prime * result + ((totalCharge == null) ? 0 : totalCharge.hashCode());
		result = prime * result + ((valueAbove == null) ? 0 : valueAbove.hashCode());
		result = prime * result + ((valueBelow == null) ? 0 : valueBelow.hashCode());
		result = prime * result + ((volumeAbove == null) ? 0 : volumeAbove.hashCode());
		result = prime * result + ((volumeBelow == null) ? 0 : volumeBelow.hashCode());
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
		MonthEndEntity other = (MonthEndEntity) obj;
		if (chargeAbove == null) {
			if (other.chargeAbove != null)
				return false;
		}
		else if (!chargeAbove.equals(other.chargeAbove))
			return false;
		if (chargeBelow == null) {
			if (other.chargeBelow != null)
				return false;
		}
		else if (!chargeBelow.equals(other.chargeBelow))
			return false;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		}
		else if (!entityId.equals(other.entityId))
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		}
		else if (!month.equals(other.month))
			return false;
		if (tieredItemChargeAbove == null) {
			if (other.tieredItemChargeAbove != null)
				return false;
		}
		else if (!tieredItemChargeAbove.equals(other.tieredItemChargeAbove))
			return false;
		if (tieredItemChargeBelow == null) {
			if (other.tieredItemChargeBelow != null)
				return false;
		}
		else if (!tieredItemChargeBelow.equals(other.tieredItemChargeBelow))
			return false;
		if (totalCharge == null) {
			if (other.totalCharge != null)
				return false;
		}
		else if (!totalCharge.equals(other.totalCharge))
			return false;
		if (valueAbove == null) {
			if (other.valueAbove != null)
				return false;
		}
		else if (!valueAbove.equals(other.valueAbove))
			return false;
		if (valueBelow == null) {
			if (other.valueBelow != null)
				return false;
		}
		else if (!valueBelow.equals(other.valueBelow))
			return false;
		if (volumeAbove == null) {
			if (other.volumeAbove != null)
				return false;
		}
		else if (!volumeAbove.equals(other.volumeAbove))
			return false;
		if (volumeBelow == null) {
			if (other.volumeBelow != null)
				return false;
		}
		else if (!volumeBelow.equals(other.volumeBelow))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(month);
		builder.append(entityId);
		builder.append(valueAbove);
		builder.append(valueBelow);
		builder.append(volumeAbove);
		builder.append(volumeBelow);
		builder.append(chargeAbove);
		builder.append(chargeBelow);
		builder.append(totalCharge);
		builder.append(tieredItemChargeAbove);
		builder.append(tieredItemChargeBelow);
		return builder.toString();
	}

}

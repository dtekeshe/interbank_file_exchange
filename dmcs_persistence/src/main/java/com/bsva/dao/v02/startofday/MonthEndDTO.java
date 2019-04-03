package com.bsva.dao.v02.startofday;


public class MonthEndDTO {

	private String month;
	private String valueAbove;
	private String valueBelow;
	private String volumeAbove;
	private String volumeBelow;
	private String chargeAbove;
	private String chargeBelow;
	private String totalCharge;
	private String tieredItemChargeAbove;
	private String tieredItemChargeBelow;
	private String MnemonicMemberName;
	private String subService;
	private String cardDescription;
	private String product;
	
	public String getMonth() {
		return month;
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
	public String getMnemonicMemberName() {
		return MnemonicMemberName;
	}
	public String getSubService() {
		return subService;
	}
	public String getCardDescription() {
		return cardDescription;
	}
	public String getProduct() {
		return product;
	}
	public void setMonth(String month) {
		this.month = month;
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
	public void setMnemonicMemberName(String mnemonicMemberName) {
		MnemonicMemberName = mnemonicMemberName;
	}
	public void setSubService(String subService) {
		this.subService = subService;
	}
	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MnemonicMemberName == null) ? 0 : MnemonicMemberName.hashCode());
		result = prime * result + ((cardDescription == null) ? 0 : cardDescription.hashCode());
		result = prime * result + ((chargeAbove == null) ? 0 : chargeAbove.hashCode());
		result = prime * result + ((chargeBelow == null) ? 0 : chargeBelow.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((subService == null) ? 0 : subService.hashCode());
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
		MonthEndDTO other = (MonthEndDTO) obj;
		if (MnemonicMemberName == null) {
			if (other.MnemonicMemberName != null)
				return false;
		}
		else if (!MnemonicMemberName.equals(other.MnemonicMemberName))
			return false;
		if (cardDescription == null) {
			if (other.cardDescription != null)
				return false;
		}
		else if (!cardDescription.equals(other.cardDescription))
			return false;
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
		if (month == null) {
			if (other.month != null)
				return false;
		}
		else if (!month.equals(other.month))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		}
		else if (!product.equals(other.product))
			return false;
		if (subService == null) {
			if (other.subService != null)
				return false;
		}
		else if (!subService.equals(other.subService))
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
		builder.append(product);
		builder.append(MnemonicMemberName);
		builder.append(subService);
		builder.append(cardDescription);
		builder.append(volumeBelow);
		builder.append(valueBelow);
		builder.append(volumeAbove);
		builder.append(valueAbove);
		builder.append(chargeBelow);
		builder.append(chargeAbove);
		builder.append(totalCharge);
		builder.append(tieredItemChargeBelow);
		builder.append(tieredItemChargeAbove);
		return builder.toString();
	}
}

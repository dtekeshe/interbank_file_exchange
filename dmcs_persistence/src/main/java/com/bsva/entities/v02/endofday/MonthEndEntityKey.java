package com.bsva.entities.v02.endofday;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MonthEndEntityKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="MNEMONIC_MEMBER_NAME")
	private String MnemonicMemberName;
	@Column(name="SUB_SERVICE")
	private String subService;
	@Column(name="CARD_DESCRIPTION")
	private String cardDescription;
	
	public MonthEndEntityKey(){
		
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

	public void setMnemonicMemberName(String mnemonicMemberName) {
		MnemonicMemberName = mnemonicMemberName;
	}

	public void setSubService(String subService) {
		this.subService = subService;
	}

	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MnemonicMemberName == null) ? 0 : MnemonicMemberName.hashCode());
		result = prime * result + ((cardDescription == null) ? 0 : cardDescription.hashCode());
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
		MonthEndEntityKey other = (MonthEndEntityKey) obj;
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
		if (subService == null) {
			if (other.subService != null)
				return false;
		}
		else if (!subService.equals(other.subService))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MonthEndEntityKey [MnemonicMemberName=");
		builder.append(MnemonicMemberName);
		builder.append(", subService=");
		builder.append(subService);
		builder.append(", cardDescription=");
		builder.append(cardDescription);
		builder.append("]");
		return builder.toString();
	}
	
	
}

package com.bsva.entities.v02.settlement;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author AugustineA
 *
 */
@Embeddable
public class CsrlkUpEntityKey implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name="POS_ENTRY_MODE")
	private String postEntryMode;
	@Column(name="CHIP_CARD")
	private String chipCard;
	@Column(name="TERMINAL_CAPABILITY")
	private String terminalcapability;
	@Column(name="CARD_PRESENT")
	private String cardPresent;
	@Column(name="E_COMM_IND")
	private String ecommIndicator;
	@Column(name="RATE_DESCRIPTOR")
	private String rateDescriptor;
	
	public CsrlkUpEntityKey(){
		
	}

	public String getPostEntryMode() {
		return postEntryMode;
	}

	public String getChipCard() {
		return chipCard;
	}

	public String getTerminalcapability() {
		return terminalcapability;
	}

	public String getCardPresent() {
		return cardPresent;
	}

	public String getEcommIndicator() {
		return ecommIndicator;
	}

	public String getRateDescriptor() {
		return rateDescriptor;
	}

	public void setPostEntryMode(String postEntryMode) {
		this.postEntryMode = postEntryMode;
	}

	public void setChipCard(String chipCard) {
		this.chipCard = chipCard;
	}

	public void setTerminalcapability(String terminalcapability) {
		this.terminalcapability = terminalcapability;
	}

	public void setCardPresent(String cardPresent) {
		this.cardPresent = cardPresent;
	}

	public void setEcommIndicator(String ecommIndicator) {
		this.ecommIndicator = ecommIndicator;
	}

	public void setRateDescriptor(String rateDescriptor) {
		this.rateDescriptor = rateDescriptor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardPresent == null) ? 0 : cardPresent.hashCode());
		result = prime * result + ((chipCard == null) ? 0 : chipCard.hashCode());
		result = prime * result + ((ecommIndicator == null) ? 0 : ecommIndicator.hashCode());
		result = prime * result + ((postEntryMode == null) ? 0 : postEntryMode.hashCode());
		result = prime * result + ((rateDescriptor == null) ? 0 : rateDescriptor.hashCode());
		result = prime * result + ((terminalcapability == null) ? 0 : terminalcapability.hashCode());
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
		CsrlkUpEntityKey other = (CsrlkUpEntityKey) obj;
		if (cardPresent == null) {
			if (other.cardPresent != null)
				return false;
		}
		else if (!cardPresent.equals(other.cardPresent))
			return false;
		if (chipCard == null) {
			if (other.chipCard != null)
				return false;
		}
		else if (!chipCard.equals(other.chipCard))
			return false;
		if (ecommIndicator == null) {
			if (other.ecommIndicator != null)
				return false;
		}
		else if (!ecommIndicator.equals(other.ecommIndicator))
			return false;
		if (postEntryMode == null) {
			if (other.postEntryMode != null)
				return false;
		}
		else if (!postEntryMode.equals(other.postEntryMode))
			return false;
		if (rateDescriptor == null) {
			if (other.rateDescriptor != null)
				return false;
		}
		else if (!rateDescriptor.equals(other.rateDescriptor))
			return false;
		if (terminalcapability == null) {
			if (other.terminalcapability != null)
				return false;
		}
		else if (!terminalcapability.equals(other.terminalcapability))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsrlkUpEntityKey [postEntryMode=");
		builder.append(postEntryMode);
		builder.append(", chipCard=");
		builder.append(chipCard);
		builder.append(", terminalcapability=");
		builder.append(terminalcapability);
		builder.append(", cardPresent=");
		builder.append(cardPresent);
		builder.append(", ecommIndicator=");
		builder.append(ecommIndicator);
		builder.append(", rateDescriptor=");
		builder.append(rateDescriptor);
		builder.append("]");
		return builder.toString();
	}
}

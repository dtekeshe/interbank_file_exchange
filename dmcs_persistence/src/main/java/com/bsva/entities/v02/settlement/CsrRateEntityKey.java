package com.bsva.entities.v02.settlement;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author AugustineA
 *
 */
@Embeddable
public class CsrRateEntityKey implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(name="TRANSACTION_CODE")
	private String transactionCode;
	@Column(name="RATE_DESC")
	private String rateDescriptor;
	@Column(name="POS_ENTRY_MODE")
	private String posEntryMode;
	@Column(name="CHIP_CARD")
	private String chipCard;
	@Column(name="TERMINAL_CAPABILITY")
	private String terminalCapability;
	@Column(name="ECOMM_IND")
	private String ecommerceInd;
	@Column(name="CARD_PRESENT")
	private String cardPresent;
	@Column(name="VOLUME")
	private String volume;
	
	public CsrRateEntityKey(){
		
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public String getRateDescriptor() {
		return rateDescriptor;
	}

	public String getPosEntryMode() {
		return posEntryMode;
	}

	public String getChipCard() {
		return chipCard;
	}

	public String getTerminalCapability() {
		return terminalCapability;
	}

	public String getEcommerceInd() {
		return ecommerceInd;
	}

	public String getCardPresent() {
		return cardPresent;
	}

	public String getVolume() {
		return volume;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public void setRateDescriptor(String rateDescriptor) {
		this.rateDescriptor = rateDescriptor;
	}

	public void setPosEntryMode(String posEntryMode) {
		this.posEntryMode = posEntryMode;
	}

	public void setChipCard(String chipCard) {
		this.chipCard = chipCard;
	}

	public void setTerminalCapability(String terminalCapability) {
		this.terminalCapability = terminalCapability;
	}

	public void setEcommerceInd(String ecommerceInd) {
		this.ecommerceInd = ecommerceInd;
	}

	public void setCardPresent(String cardPresent) {
		this.cardPresent = cardPresent;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardPresent == null) ? 0 : cardPresent.hashCode());
		result = prime * result + ((chipCard == null) ? 0 : chipCard.hashCode());
		result = prime * result + ((ecommerceInd == null) ? 0 : ecommerceInd.hashCode());
		result = prime * result + ((posEntryMode == null) ? 0 : posEntryMode.hashCode());
		result = prime * result + ((rateDescriptor == null) ? 0 : rateDescriptor.hashCode());
		result = prime * result + ((terminalCapability == null) ? 0 : terminalCapability.hashCode());
		result = prime * result + ((transactionCode == null) ? 0 : transactionCode.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
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
		CsrRateEntityKey other = (CsrRateEntityKey) obj;
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
		if (ecommerceInd == null) {
			if (other.ecommerceInd != null)
				return false;
		}
		else if (!ecommerceInd.equals(other.ecommerceInd))
			return false;
		if (posEntryMode == null) {
			if (other.posEntryMode != null)
				return false;
		}
		else if (!posEntryMode.equals(other.posEntryMode))
			return false;
		if (rateDescriptor == null) {
			if (other.rateDescriptor != null)
				return false;
		}
		else if (!rateDescriptor.equals(other.rateDescriptor))
			return false;
		if (terminalCapability == null) {
			if (other.terminalCapability != null)
				return false;
		}
		else if (!terminalCapability.equals(other.terminalCapability))
			return false;
		if (transactionCode == null) {
			if (other.transactionCode != null)
				return false;
		}
		else if (!transactionCode.equals(other.transactionCode))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		}
		else if (!volume.equals(other.volume))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsrrateEntityKey [transactionCode=");
		builder.append(transactionCode);
		builder.append(", rateDescriptor=");
		builder.append(rateDescriptor);
		builder.append(", posEntryMode=");
		builder.append(posEntryMode);
		builder.append(", chipCard=");
		builder.append(chipCard);
		builder.append(", terminalCapability=");
		builder.append(terminalCapability);
		builder.append(", ecommerceInd=");
		builder.append(ecommerceInd);
		builder.append(", cardPresent=");
		builder.append(cardPresent);
		builder.append(", volume=");
		builder.append(volume);
		builder.append("]");
		return builder.toString();
	}
}

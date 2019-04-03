package com.bsva.entities.v02.startofday;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CsfBinsEntityPK implements Serializable {
	
	
	@Column(name="BIN_NO")
	private String binNum;
	@Column(name="BANK_CODE")
	private String bankCode;
	@Column(name="CARD_TYPE")
	private String cardType;
	
	public CsfBinsEntityPK(){
		
	}
	
	public String getBinNum() {
		return binNum;
	}
	public String getBankCode() {
		return bankCode;
	}
	public String getCardType() {
		return cardType;
	}
	public void setBinNum(String binNum) {
		this.binNum = binNum;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankCode == null) ? 0 : bankCode.hashCode());
		result = prime * result + ((binNum == null) ? 0 : binNum.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
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
		CsfBinsEntityPK other = (CsfBinsEntityPK) obj;
		if (bankCode == null) {
			if (other.bankCode != null)
				return false;
		}
		else if (!bankCode.equals(other.bankCode))
			return false;
		if (binNum == null) {
			if (other.binNum != null)
				return false;
		}
		else if (!binNum.equals(other.binNum))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		}
		else if (!cardType.equals(other.cardType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsfBinsEntityPK [binNum=");
		builder.append(binNum);
		builder.append(", bankCode=");
		builder.append(bankCode);
		builder.append(", cardType=");
		builder.append(cardType);
		builder.append("]");
		return builder.toString();
	}

}

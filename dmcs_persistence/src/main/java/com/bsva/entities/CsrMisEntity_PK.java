package com.bsva.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CsrMisEntity_PK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "PROCESS_DATE")
	private String processDate;
	@Column(name = "SUB_SERVICE")
	private String serviceCode;
	@Column(name = "CARD_TYPE")
	private String cardType;
	@Column(name="ISSUING_MEMBER")
	private String issuingMember;
	
	public CsrMisEntity_PK() {
	}

	public CsrMisEntity_PK(String processDate, String serviceCode, String issuingMember,
			String cardType) {
		super();
		this.processDate = processDate;
		this.serviceCode = serviceCode;
		this.cardType = cardType;
		this.issuingMember = issuingMember;
	}

	public String getProcessDate() {
		return processDate;
	}

	public String getServiceCode() {
		return serviceCode;
	}


	public String getCardType() {
		return cardType;
	}

	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getIssuingMember() {
		return issuingMember;
	}

	public void setIssuingMember(String issuingMember) {
		this.issuingMember = issuingMember;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((issuingMember == null) ? 0 : issuingMember.hashCode());
		result = prime * result + ((processDate == null) ? 0 : processDate.hashCode());
		result = prime * result + ((serviceCode == null) ? 0 : serviceCode.hashCode());
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
		CsrMisEntity_PK other = (CsrMisEntity_PK) obj;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		}
		else if (!cardType.equals(other.cardType))
			return false;
		if (issuingMember == null) {
			if (other.issuingMember != null)
				return false;
		}
		else if (!issuingMember.equals(other.issuingMember))
			return false;
		if (processDate == null) {
			if (other.processDate != null)
				return false;
		}
		else if (!processDate.equals(other.processDate))
			return false;
		if (serviceCode == null) {
			if (other.serviceCode != null)
				return false;
		}
		else if (!serviceCode.equals(other.serviceCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsrMisEntity_PK [processDate=");
		builder.append(processDate);
		builder.append(", serviceCode=");
		builder.append(serviceCode);
		builder.append(", cardType=");
		builder.append(cardType);
		builder.append(", issuingMember=");
		builder.append(issuingMember);
		builder.append("]");
		return builder.toString();
	}

	

}

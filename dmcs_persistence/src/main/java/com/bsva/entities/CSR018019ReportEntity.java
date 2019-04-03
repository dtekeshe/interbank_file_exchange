package com.bsva.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class CSR018019ReportEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CSR018019ReportEntityKey Id;
	
	@Column(name="ISSUER_MEMBER")
	private String issuerMember;
	@Column(name="ACQUIRER_MEMBER")
	private String acquirerMember;
	@Column(name="CARD_TYPE")
	private String cardType;
	@Column(name="TRANSACTION_CODE")
	private String transCode;
	@Column(name="ACQ_BIN")
	private String acqBin;
	
	public CSR018019ReportEntity(){
		
	}

	public CSR018019ReportEntityKey getId() {
		return Id;
	}

	public String getIssuerMember() {
		return issuerMember;
	}

	public String getAcquirerMember() {
		return acquirerMember;
	}

	public String getCardType() {
		return cardType;
	}

	public String getTransCode() {
		return transCode;
	}

	public String getAcqBin() {
		return acqBin;
	}

	public void setId(CSR018019ReportEntityKey id) {
		Id = id;
	}

	public void setIssuerMember(String issuerMember) {
		this.issuerMember = issuerMember;
	}

	public void setAcquirerMember(String acquirerMember) {
		this.acquirerMember = acquirerMember;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	public void setAcqBin(String acqBin) {
		this.acqBin = acqBin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((acqBin == null) ? 0 : acqBin.hashCode());
		result = prime * result + ((acquirerMember == null) ? 0 : acquirerMember.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((issuerMember == null) ? 0 : issuerMember.hashCode());
		result = prime * result + ((transCode == null) ? 0 : transCode.hashCode());
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
		CSR018019ReportEntity other = (CSR018019ReportEntity) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		}
		else if (!Id.equals(other.Id))
			return false;
		if (acqBin == null) {
			if (other.acqBin != null)
				return false;
		}
		else if (!acqBin.equals(other.acqBin))
			return false;
		if (acquirerMember == null) {
			if (other.acquirerMember != null)
				return false;
		}
		else if (!acquirerMember.equals(other.acquirerMember))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		}
		else if (!cardType.equals(other.cardType))
			return false;
		if (issuerMember == null) {
			if (other.issuerMember != null)
				return false;
		}
		else if (!issuerMember.equals(other.issuerMember))
			return false;
		if (transCode == null) {
			if (other.transCode != null)
				return false;
		}
		else if (!transCode.equals(other.transCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CSR018019ReportEntity [Id=");
		builder.append(Id);
		builder.append(", issuerMember=");
		builder.append(issuerMember);
		builder.append(", acquirerMember=");
		builder.append(acquirerMember);
		builder.append(", cardType=");
		builder.append(cardType);
		builder.append(", transCode=");
		builder.append(transCode);
		builder.append(", acqBin=");
		builder.append(acqBin);
		builder.append("]");
		return builder.toString();
	}
	
}

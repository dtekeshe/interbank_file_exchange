package com.bsva.entities.v02;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author AugustineA
 *
 */
@Embeddable
public class ChargeBacksEntity_PK implements Serializable{

	 private static final long serialVersionUID = 1L;
	 @Column(name = "ACQUIRER_MEMBER")
	 private String acquirerMember;
	 @Column(name = "ISSUER_MEMBER")
	 private String issuerMember;
	 @Column(name = "TRANSACTION_CODE")
	 private String transactionCode;
	 @Column(name = "SYSTEM_SEQ_NUMBER2")
	 private String systemSeqNumber;
	 
	 public ChargeBacksEntity_PK(){
		 
	 }

	public String getAcquirerMember() {
		return acquirerMember;
	}

	public String getIssuerMember() {
		return issuerMember;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public String getSystemSeqNumber() {
		return systemSeqNumber;
	}

	public void setAcquirerMember(String acquirerMember) {
		this.acquirerMember = acquirerMember;
	}

	public void setIssuerMember(String issuerMember) {
		this.issuerMember = issuerMember;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public void setSystemSeqNumber(String systemSeqNumber) {
		this.systemSeqNumber = systemSeqNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquirerMember == null) ? 0 : acquirerMember.hashCode());
		result = prime * result + ((issuerMember == null) ? 0 : issuerMember.hashCode());
		result = prime * result + ((systemSeqNumber == null) ? 0 : systemSeqNumber.hashCode());
		result = prime * result + ((transactionCode == null) ? 0 : transactionCode.hashCode());
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
		ChargeBacksEntity_PK other = (ChargeBacksEntity_PK) obj;
		if (acquirerMember == null) {
			if (other.acquirerMember != null)
				return false;
		} else if (!acquirerMember.equals(other.acquirerMember))
			return false;
		if (issuerMember == null) {
			if (other.issuerMember != null)
				return false;
		} else if (!issuerMember.equals(other.issuerMember))
			return false;
		if (systemSeqNumber == null) {
			if (other.systemSeqNumber != null)
				return false;
		} else if (!systemSeqNumber.equals(other.systemSeqNumber))
			return false;
		if (transactionCode == null) {
			if (other.transactionCode != null)
				return false;
		} else if (!transactionCode.equals(other.transactionCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChargeBacksEntity_PK [acquirerMember=");
		builder.append(acquirerMember);
		builder.append(", issuerMember=");
		builder.append(issuerMember);
		builder.append(", transactionCode=");
		builder.append(transactionCode);
		builder.append(", systemSeqNumber=");
		builder.append(systemSeqNumber);
		builder.append("]");
		return builder.toString();
	}
	 
}

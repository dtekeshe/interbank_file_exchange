package com.bsva.entities.v02.settlement;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CsoCCR030AcqIssEntityKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="ACQUIRER_MEMBER")
	private String acquirerMember;
	@Column(name="ISSUER_MEMBER")
	private String issuerMember;
	
	public CsoCCR030AcqIssEntityKey(){
		
	}

	public String getAcquirerMember() {
		return acquirerMember;
	}

	public String getIssuerMember() {
		return issuerMember;
	}

	public void setAcquirerMember(String acquirerMember) {
		this.acquirerMember = acquirerMember;
	}

	public void setIssuerMember(String issuerMember) {
		this.issuerMember = issuerMember;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquirerMember == null) ? 0 : acquirerMember.hashCode());
		result = prime * result + ((issuerMember == null) ? 0 : issuerMember.hashCode());
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
		CsoCCR030AcqIssEntityKey other = (CsoCCR030AcqIssEntityKey) obj;
		if (acquirerMember == null) {
			if (other.acquirerMember != null)
				return false;
		}
		else if (!acquirerMember.equals(other.acquirerMember))
			return false;
		if (issuerMember == null) {
			if (other.issuerMember != null)
				return false;
		}
		else if (!issuerMember.equals(other.issuerMember))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsoCCR030AcqIssMcardEntityKey [acquirerMember=");
		builder.append(acquirerMember);
		builder.append(", issuerMember=");
		builder.append(issuerMember);
		builder.append("]");
		return builder.toString();
	}

}

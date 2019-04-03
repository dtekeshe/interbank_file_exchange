package com.bsva.entities.v02;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class IssuerAcquirerEntity_PK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ISSUER_MEMBER")
	private String issuerMember;
	@Column(name = "ACQUIRER_MEMBER")
	private String acquirerMember;
	
	public IssuerAcquirerEntity_PK(){
		
	}

	/**
	 * @param issuerMember
	 * @param acquirerMember
	 */
	public IssuerAcquirerEntity_PK(String issuerMember, String acquirerMember) {
		this.issuerMember = issuerMember;
		this.acquirerMember = acquirerMember;
	}

	public String getIssuerMember() {
		return issuerMember;
	}

	public String getAcquirerMember() {
		return acquirerMember;
	}

	public void setIssuerMember(String issuerMember) {
		this.issuerMember = issuerMember;
	}

	public void setAcquirerMember(String acquirerMember) {
		this.acquirerMember = acquirerMember;
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
		IssuerAcquirerEntity_PK other = (IssuerAcquirerEntity_PK) obj;
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
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(issuerMember);
		builder.append(acquirerMember);
		return builder.toString();
	}
	
}

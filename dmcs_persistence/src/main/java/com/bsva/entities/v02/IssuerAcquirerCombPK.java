package com.bsva.entities.v02;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class IssuerAcquirerCombPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "ISSUER_MEMBER")
	private String issuermember;
	@Column(name = "ACQUIRER_MEMBER")
	private String acquirer;
	
	public IssuerAcquirerCombPK(String issuermember, String acquirer) {
		super();
		this.issuermember = issuermember;
		this.acquirer = acquirer;
	}

	public IssuerAcquirerCombPK(){
		
	}
	
	public String getIssuermember() {
		return issuermember;
	}
	public String getAcquirer() {
		return acquirer;
	}
	public void setIssuermember(String issuermember) {
		this.issuermember = issuermember;
	}
	public void setAcquirer(String acquirer) {
		this.acquirer = acquirer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquirer == null) ? 0 : acquirer.hashCode());
		result = prime * result + ((issuermember == null) ? 0 : issuermember.hashCode());
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
		IssuerAcquirerCombPK other = (IssuerAcquirerCombPK) obj;
		if (acquirer == null) {
			if (other.acquirer != null)
				return false;
		} else if (!acquirer.equals(other.acquirer))
			return false;
		if (issuermember == null) {
			if (other.issuermember != null)
				return false;
		} else if (!issuermember.equals(other.issuermember))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IssuerAcquirerCombPK [issuermember=");
		builder.append(issuermember);
		builder.append(", acquirer=");
		builder.append(acquirer);
		builder.append("]");
		return builder.toString();
	}

}

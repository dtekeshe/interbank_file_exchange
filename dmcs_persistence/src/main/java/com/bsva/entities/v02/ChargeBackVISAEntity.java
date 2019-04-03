package com.bsva.entities.v02;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "CSO_PAYMENT_INSTRUCTIONS_VISA")
@DynamicUpdate
public class ChargeBackVISAEntity {

	@Column(name = "ACQUIRER_MEMBER")
	private String acquirerMember;

	@Column(name = "ISSUER_MEMBER")
	private String issuerMember;

	@Column(name = "TRANSACTION_CODE")
	private String transactionCode;

	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;

	@Id
	@Column(name = "SYSTEM_GEN_SEQ_NUMBER")
	private String systemGenSeqNumber;

	@Column(name = "USAGE_CODE")
	private String usageCode;

	public ChargeBackVISAEntity() {

	}

	public ChargeBackVISAEntity(String acquirerMember, String issuerMember, String transactionCode, String accountNumber,
			String systemGenSeqNumber, String usageCode) {
		super();
		this.acquirerMember = acquirerMember;
		this.issuerMember = issuerMember;
		this.transactionCode = transactionCode;
		this.accountNumber = accountNumber;
		this.systemGenSeqNumber = systemGenSeqNumber;
		this.usageCode = usageCode;
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

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getSystemGenSeqNumber() {
		return systemGenSeqNumber;
	}

	public String getUsageCode() {
		return usageCode;
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

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setSystemGenSeqNumber(String systemGenSeqNumber) {
		this.systemGenSeqNumber = systemGenSeqNumber;
	}

	public void setUsageCode(String usageCode) {
		this.usageCode = usageCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((acquirerMember == null) ? 0 : acquirerMember.hashCode());
		result = prime * result + ((issuerMember == null) ? 0 : issuerMember.hashCode());
		result = prime * result + ((systemGenSeqNumber == null) ? 0 : systemGenSeqNumber.hashCode());
		result = prime * result + ((transactionCode == null) ? 0 : transactionCode.hashCode());
		result = prime * result + ((usageCode == null) ? 0 : usageCode.hashCode());
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
		ChargeBackVISAEntity other = (ChargeBackVISAEntity) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
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

		if (systemGenSeqNumber == null) {
			if (other.systemGenSeqNumber != null)
				return false;
		} else if (!systemGenSeqNumber.equals(other.systemGenSeqNumber))
			return false;
		if (transactionCode == null) {
			if (other.transactionCode != null)
				return false;
		} else if (!transactionCode.equals(other.transactionCode))
			return false;
		if (usageCode == null) {
			if (other.usageCode != null)
				return false;
		} else if (!usageCode.equals(other.usageCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(acquirerMember);
		builder.append(issuerMember);
		builder.append(transactionCode);
		builder.append(accountNumber);
		builder.append(systemGenSeqNumber);
		builder.append(usageCode);
		return builder.toString();
	}

}

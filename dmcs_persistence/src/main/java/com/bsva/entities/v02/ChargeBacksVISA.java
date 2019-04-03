package com.bsva.entities.v02;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "CSO_PAYMENT_INSTRUCTIONS_VISA")
@DynamicUpdate
public class ChargeBacksVISA {

	@Id
	@Column(name="SYSTEM_GEN_SEQ_NUMBER")
	private String systemGenSeqNumber;
	@Column(name="ACQUIRER_MEMBER")
	private String acquirerMember;	
	@Column(name="ISSUER_MEMBER")
	private String issuerMember;	
	@Column(name="TRANSACTION_CODE")
	private String transactionCode;	
	@Column(name="ACCOUNT_NUMBER")
	private String accountNumber;	
	@Column(name = "MF_FORMAT")
	private String mfFormat;
	@Column(name = "MF_ACQUIRER")
	private String mfAcquirer;
	@Column(name = "MF_DATE")
	private String mfDate;
	@Column(name = "MF_BATCHNO")
	private String mfBatchNo;
	@Column(name = "CHECK_DIGIT")
	private String checkDigit;
	@Column(name = "PURCHASE_DATE")
	private String purchaseDate;
	@Column(name = "AMOUNT")
	private String amount;
	@Column(name = "AUTH_1")
	private String auth_1;
	@Column(name = "AUTH_2")
	private String auth2;
	@Column(name = "MERCHANT_NAME")
	private String merchantName;
	@Column(name = "MERCHANT_CITY")
	private String merchntCity;
	@Column(name = "MERCHANT_COUNTRY")
	private String merchantCountry;
	@Column(name = "MERCHANT_TYPE")
	private String merchantType;
	@Column(name = "REASON")
	private String reason;
	@Column(name = "REASON_CODE")
	private String reasonCode;
	//@Column(name = "AMOUNT_2")
	//private String amount2;
	@Column(name = "USAGE_CODE")
	private String usageCode;
	
	
	public ChargeBacksVISA(){
		
	}


	public String getSystemGenSeqNumber() {
		return systemGenSeqNumber;
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


	public String getMfFormat() {
		return mfFormat;
	}


	public String getMfAcquirer() {
		return mfAcquirer;
	}


	public String getMfDate() {
		return mfDate;
	}


	public String getMfBatchNo() {
		return mfBatchNo;
	}


	public String getCheckDigit() {
		return checkDigit;
	}


	public String getPurchaseDate() {
		return purchaseDate;
	}


	public String getAmount() {
		return amount;
	}


	public String getAuth_1() {
		return auth_1;
	}


	public String getAuth2() {
		return auth2;
	}


	public String getMerchantName() {
		return merchantName;
	}


	public String getMerchntCity() {
		return merchntCity;
	}


	public String getMerchantCountry() {
		return merchantCountry;
	}


	public String getMerchantType() {
		return merchantType;
	}


	public String getReason() {
		return reason;
	}


	public String getReasonCode() {
		return reasonCode;
	}


	/*public String getAmount2() {
		return amount2;
	}*/


	public String getUsageCode() {
		return usageCode;
	}


	public void setSystemGenSeqNumber(String systemGenSeqNumber) {
		this.systemGenSeqNumber = systemGenSeqNumber;
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


	public void setMfFormat(String mfFormat) {
		this.mfFormat = mfFormat;
	}


	public void setMfAcquirer(String mfAcquirer) {
		this.mfAcquirer = mfAcquirer;
	}


	public void setMfDate(String mfDate) {
		this.mfDate = mfDate;
	}


	public void setMfBatchNo(String mfBatchNo) {
		this.mfBatchNo = mfBatchNo;
	}


	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
	}


	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public void setAuth_1(String auth_1) {
		this.auth_1 = auth_1;
	}


	public void setAuth2(String auth2) {
		this.auth2 = auth2;
	}


	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}


	public void setMerchntCity(String merchntCity) {
		this.merchntCity = merchntCity;
	}


	public void setMerchantCountry(String merchantCountry) {
		this.merchantCountry = merchantCountry;
	}


	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}


	/*public void setAmount2(String amount2) {
		this.amount2 = amount2;
	}*/


	public void setUsageCode(String usageCode) {
		this.usageCode = usageCode;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((acquirerMember == null) ? 0 : acquirerMember.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		//result = prime * result + ((amount2 == null) ? 0 : amount2.hashCode());
		result = prime * result + ((auth2 == null) ? 0 : auth2.hashCode());
		result = prime * result + ((auth_1 == null) ? 0 : auth_1.hashCode());
		result = prime * result + ((checkDigit == null) ? 0 : checkDigit.hashCode());
		result = prime * result + ((issuerMember == null) ? 0 : issuerMember.hashCode());
		result = prime * result + ((merchantCountry == null) ? 0 : merchantCountry.hashCode());
		result = prime * result + ((merchantName == null) ? 0 : merchantName.hashCode());
		result = prime * result + ((merchantType == null) ? 0 : merchantType.hashCode());
		result = prime * result + ((merchntCity == null) ? 0 : merchntCity.hashCode());
		result = prime * result + ((mfAcquirer == null) ? 0 : mfAcquirer.hashCode());
		result = prime * result + ((mfBatchNo == null) ? 0 : mfBatchNo.hashCode());
		result = prime * result + ((mfDate == null) ? 0 : mfDate.hashCode());
		result = prime * result + ((mfFormat == null) ? 0 : mfFormat.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((reasonCode == null) ? 0 : reasonCode.hashCode());
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
		ChargeBacksVISA other = (ChargeBacksVISA) obj;
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
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		/*if (amount2 == null) {
			if (other.amount2 != null)
				return false;
		} else if (!amount2.equals(other.amount2))
			return false;*/
		if (auth2 == null) {
			if (other.auth2 != null)
				return false;
		} else if (!auth2.equals(other.auth2))
			return false;
		if (auth_1 == null) {
			if (other.auth_1 != null)
				return false;
		} else if (!auth_1.equals(other.auth_1))
			return false;
		if (checkDigit == null) {
			if (other.checkDigit != null)
				return false;
		} else if (!checkDigit.equals(other.checkDigit))
			return false;
		if (issuerMember == null) {
			if (other.issuerMember != null)
				return false;
		} else if (!issuerMember.equals(other.issuerMember))
			return false;
		if (merchantCountry == null) {
			if (other.merchantCountry != null)
				return false;
		} else if (!merchantCountry.equals(other.merchantCountry))
			return false;
		if (merchantName == null) {
			if (other.merchantName != null)
				return false;
		} else if (!merchantName.equals(other.merchantName))
			return false;
		if (merchantType == null) {
			if (other.merchantType != null)
				return false;
		} else if (!merchantType.equals(other.merchantType))
			return false;
		if (merchntCity == null) {
			if (other.merchntCity != null)
				return false;
		} else if (!merchntCity.equals(other.merchntCity))
			return false;
		if (mfAcquirer == null) {
			if (other.mfAcquirer != null)
				return false;
		} else if (!mfAcquirer.equals(other.mfAcquirer))
			return false;
		if (mfBatchNo == null) {
			if (other.mfBatchNo != null)
				return false;
		} else if (!mfBatchNo.equals(other.mfBatchNo))
			return false;
		if (mfDate == null) {
			if (other.mfDate != null)
				return false;
		} else if (!mfDate.equals(other.mfDate))
			return false;
		if (mfFormat == null) {
			if (other.mfFormat != null)
				return false;
		} else if (!mfFormat.equals(other.mfFormat))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (reasonCode == null) {
			if (other.reasonCode != null)
				return false;
		} else if (!reasonCode.equals(other.reasonCode))
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
		builder.append(systemGenSeqNumber);
		builder.append(acquirerMember);
		builder.append(issuerMember);
		builder.append(transactionCode);
		builder.append(accountNumber);
		builder.append(mfFormat);
		builder.append(mfAcquirer);
		builder.append(mfDate);
		builder.append(mfBatchNo);
		builder.append(checkDigit);
		builder.append(purchaseDate);
		builder.append(amount);
		builder.append(auth_1);
		builder.append(auth2);
		builder.append(merchantName);
		builder.append(merchntCity);
		builder.append(merchantCountry);
		builder.append(merchantType);
		builder.append(reason);
		builder.append(reasonCode);
		//builder.append(amount2);
		builder.append(usageCode);
		return builder.toString();
	}


	
}

	
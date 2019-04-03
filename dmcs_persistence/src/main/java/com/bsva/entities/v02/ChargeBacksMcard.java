package com.bsva.entities.v02;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table (name = "CSO_PAYMENT_INSTRUCTIONS_MCARD")
@DynamicUpdate
public class ChargeBacksMcard {
	//Used and working version.
	@Id
	@Column(name = "SYSTEM_SEQ_NUMBER2")
	private String systemSeqNumber;
	@Column(name = "ACQUIRER_MEMBER")
	private String acquirer;
	@Column(name = "ISSUER_MEMBER")
	private String issuer;
	@Column(name = "TRANSACTION_CODE")
	private String  transactionCode;
	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;
	@Column(name = "MF_FORMAT")
	private String mfFormat;
	@Column(name = "MF_ACQUIRER")
	private String mfAcquirer;
	@Column(name = "MF_DATE")
	private String mfDate;
	@Column(name = "MF_BATCHNO")
    private String 	mfBatchNo;
	@Column(name = "CHECK_DIGIT")
	private String chheckDigit;
	@Column(name = "PURCHASE_DATE")
	private String purchaseDate;
	@Column(name = "AMOUNT")
	private String amount;
	@Column(name = "MCARD_AUTH")
	private String mcardAuth;
	@Column(name = "CARD_ACCEPTOR_NAME")
	private String cardAccptorName;
	@Column(name = "MERCHANT_TYPE")
	private String merchantType;
	@Column(name = "REASON")
	private String reason;
	@Column(name = "USAGE_CODE")
	private String usageCode;
	
	
	public ChargeBacksMcard(){
		
	}


	public ChargeBacksMcard(String systemSeqNumber, String acquirer, String issuer, String transactionCode,
			String accountNumber, String mfFormat, String mfAcquirer, String mfDate, String mfBatchNo,
			String chheckDigit, String purchaseDate, String amount, String mcardAuth, String cardAccptorName,
			String merchantType, String reason, String usageCode) {
		super();
		this.systemSeqNumber = systemSeqNumber;
		this.acquirer = acquirer;
		this.issuer = issuer;
		this.transactionCode = transactionCode;
		this.accountNumber = accountNumber;
		this.mfFormat = mfFormat;
		this.mfAcquirer = mfAcquirer;
		this.mfDate = mfDate;
		this.mfBatchNo = mfBatchNo;
		this.chheckDigit = chheckDigit;
		this.purchaseDate = purchaseDate;
		this.amount = amount;
		this.mcardAuth = mcardAuth;
		this.cardAccptorName = cardAccptorName;
		this.merchantType = merchantType;
		this.reason = reason;
		this.usageCode = usageCode;
	}


	public String getSystemSeqNumber() {
		return systemSeqNumber;
	}


	public String getAcquirer() {
		return acquirer;
	}


	public String getIssuer() {
		return issuer;
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


	public String getChheckDigit() {
		return chheckDigit;
	}


	public String getPurchaseDate() {
		return purchaseDate;
	}


	public String getAmount() {
		return amount;
	}
	
	public String getMcardAuth() {
		return mcardAuth;
	}


	public String getCardAccptorName() {
		return cardAccptorName;
	}


	public String getMerchantType() {
		return merchantType;
	}


	public String getReason() {
		return reason;
	}


	public String getUsageCode() {
		return usageCode;
	}


	public void setSystemSeqNumber(String systemSeqNumber) {
		this.systemSeqNumber = systemSeqNumber;
	}


	public void setAcquirer(String acquirer) {
		this.acquirer = acquirer;
	}


	public void setIssuer(String issuer) {
		this.issuer = issuer;
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


	public void setChheckDigit(String chheckDigit) {
		this.chheckDigit = chheckDigit;
	}


	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}
	


	public void setMcardAuth(String mcardAuth) {
		this.mcardAuth = mcardAuth;
	}


	public void setCardAccptorName(String cardAccptorName) {
		this.cardAccptorName = cardAccptorName;
	}


	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public void setUsageCode(String usageCode) {
		this.usageCode = usageCode;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((acquirer == null) ? 0 : acquirer.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((cardAccptorName == null) ? 0 : cardAccptorName.hashCode());
		result = prime * result + ((chheckDigit == null) ? 0 : chheckDigit.hashCode());
		result = prime * result + ((issuer == null) ? 0 : issuer.hashCode());
		result = prime * result + ((mcardAuth == null) ? 0 : mcardAuth.hashCode());
		result = prime * result + ((merchantType == null) ? 0 : merchantType.hashCode());
		result = prime * result + ((mfAcquirer == null) ? 0 : mfAcquirer.hashCode());
		result = prime * result + ((mfBatchNo == null) ? 0 : mfBatchNo.hashCode());
		result = prime * result + ((mfDate == null) ? 0 : mfDate.hashCode());
		result = prime * result + ((mfFormat == null) ? 0 : mfFormat.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((systemSeqNumber == null) ? 0 : systemSeqNumber.hashCode());
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
		ChargeBacksMcard other = (ChargeBacksMcard) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (acquirer == null) {
			if (other.acquirer != null)
				return false;
		} else if (!acquirer.equals(other.acquirer))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		
		if (cardAccptorName == null) {
			if (other.cardAccptorName != null)
				return false;
		} else if (!cardAccptorName.equals(other.cardAccptorName))
			return false;
		if (chheckDigit == null) {
			if (other.chheckDigit != null)
				return false;
		} else if (!chheckDigit.equals(other.chheckDigit))
			return false;
		if (issuer == null) {
			if (other.issuer != null)
				return false;
		} else if (!issuer.equals(other.issuer))
			return false;
		if (mcardAuth == null) {
			if (other.mcardAuth != null)
				return false;
		} else if (!mcardAuth.equals(other.mcardAuth))
			return false;
		if (merchantType == null) {
			if (other.merchantType != null)
				return false;
		} else if (!merchantType.equals(other.merchantType))
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
		builder.append(systemSeqNumber);
		builder.append(acquirer);
		builder.append(issuer);
		builder.append(transactionCode);
		builder.append(accountNumber);
		builder.append(mfFormat);
		builder.append(mfAcquirer);
		builder.append(mfDate);
		builder.append(mfBatchNo);
		builder.append(chheckDigit);
		builder.append(purchaseDate);
		builder.append(amount);
		builder.append(mcardAuth);
		builder.append(cardAccptorName);
		builder.append(merchantType);
		builder.append(reason);
		builder.append(usageCode);
		return builder.toString();
	}
	

}

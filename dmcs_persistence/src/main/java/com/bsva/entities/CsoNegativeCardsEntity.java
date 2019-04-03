package com.bsva.entities;

import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class CsoNegativeCardsEntity {

	@Column(name = "FILE_REF_NUMBER")
	private String fileRefNumber;
	@Id
	@Column(name = "SYSTEM_SEQ_NUMBER")
	private String systemSeqNumber;
	@Column(name = "TRANSACTION_CODE")
	private String transactoionCode;
	@Column(name = "DEST_BIN_NUMBER")
	private String destBinNumber;
	@Column(name = "SOURCE_BIN_NUMBER")
	private String sourceBinNumber;
	@Column(name = "TRANS_SEQ_NUMBER")
	private String transSeqNumber;
	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;
	@Column(name = "AUTH_CENTRE")
	private String authCenter;
	@Column(name = "NEGATIVE_ACC_NUMBER")
	private String negativeAccNumber;
	@Column(name = "RESPONSE_CODE")
	private String responseCode;
	@Column(name = "PURGE_DATE")
	private String purgeDate;
	@Column(name = "REGION_CODE")
	private String regionCode;
	@Column(name = "CARDHOLDER_NAME")
	private String cardHolderName;
	@Column(name = "ACQUIRER")
	private String acquirer;
	
	
	public CsoNegativeCardsEntity() {
		
	}
	public String getFileRefNumber() {
		return fileRefNumber;
	}
	public String getSystemSeqNumber() {
		return systemSeqNumber;
	}
	public String getTransactoionCode() {
		return transactoionCode;
	}
	public String getDestBinNumber() {
		return destBinNumber;
	}
	public String getSourceBinNumber() {
		return sourceBinNumber;
	}
	public String getTransSeqNumber() {
		return transSeqNumber;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public String getAuthCenter() {
		return authCenter;
	}
	public String getNegativeAccNumber() {
		return negativeAccNumber;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public String getPurgeDate() {
		return purgeDate;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public String getAcquirer() {
		return acquirer;
	}
	public void setFileRefNumber(String fileRefNumber) {
		this.fileRefNumber = fileRefNumber;
	}
	public void setSystemSeqNumber(String systemSeqNumber) {
		this.systemSeqNumber = systemSeqNumber;
	}
	public void setTransactoionCode(String transactoionCode) {
		this.transactoionCode = transactoionCode;
	}
	public void setDestBinNumber(String destBinNumber) {
		this.destBinNumber = destBinNumber;
	}
	public void setSourceBinNumber(String sourceBinNumber) {
		this.sourceBinNumber = sourceBinNumber;
	}
	public void setTransSeqNumber(String transSeqNumber) {
		this.transSeqNumber = transSeqNumber;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public void setAuthCenter(String authCenter) {
		this.authCenter = authCenter;
	}
	public void setNegativeAccNumber(String negativeAccNumber) {
		this.negativeAccNumber = negativeAccNumber;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public void setPurgeDate(String purgeDate) {
		this.purgeDate = purgeDate;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public void setAcquirer(String acquirer) {
		this.acquirer = acquirer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquirer == null) ? 0 : acquirer.hashCode());
		result = prime * result + ((authCenter == null) ? 0 : authCenter.hashCode());
		result = prime * result + ((cardHolderName == null) ? 0 : cardHolderName.hashCode());
		result = prime * result + ((destBinNumber == null) ? 0 : destBinNumber.hashCode());
		result = prime * result + ((fileRefNumber == null) ? 0 : fileRefNumber.hashCode());
		result = prime * result + ((negativeAccNumber == null) ? 0 : negativeAccNumber.hashCode());
		result = prime * result + ((purgeDate == null) ? 0 : purgeDate.hashCode());
		result = prime * result + ((regionCode == null) ? 0 : regionCode.hashCode());
		result = prime * result + ((responseCode == null) ? 0 : responseCode.hashCode());
		result = prime * result + ((sourceBinNumber == null) ? 0 : sourceBinNumber.hashCode());
		result = prime * result + ((systemSeqNumber == null) ? 0 : systemSeqNumber.hashCode());
		result = prime * result + ((transSeqNumber == null) ? 0 : transSeqNumber.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		result = prime * result + ((transactoionCode == null) ? 0 : transactoionCode.hashCode());
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
		CsoNegativeCardsEntity other = (CsoNegativeCardsEntity) obj;
		if (acquirer == null) {
			if (other.acquirer != null)
				return false;
		} else if (!acquirer.equals(other.acquirer))
			return false;
		if (authCenter == null) {
			if (other.authCenter != null)
				return false;
		} else if (!authCenter.equals(other.authCenter))
			return false;
		if (cardHolderName == null) {
			if (other.cardHolderName != null)
				return false;
		} else if (!cardHolderName.equals(other.cardHolderName))
			return false;
		if (destBinNumber == null) {
			if (other.destBinNumber != null)
				return false;
		} else if (!destBinNumber.equals(other.destBinNumber))
			return false;
		if (fileRefNumber == null) {
			if (other.fileRefNumber != null)
				return false;
		} else if (!fileRefNumber.equals(other.fileRefNumber))
			return false;
		if (negativeAccNumber == null) {
			if (other.negativeAccNumber != null)
				return false;
		} else if (!negativeAccNumber.equals(other.negativeAccNumber))
			return false;
		if (purgeDate == null) {
			if (other.purgeDate != null)
				return false;
		} else if (!purgeDate.equals(other.purgeDate))
			return false;
		if (regionCode == null) {
			if (other.regionCode != null)
				return false;
		} else if (!regionCode.equals(other.regionCode))
			return false;
		if (responseCode == null) {
			if (other.responseCode != null)
				return false;
		} else if (!responseCode.equals(other.responseCode))
			return false;
		if (sourceBinNumber == null) {
			if (other.sourceBinNumber != null)
				return false;
		} else if (!sourceBinNumber.equals(other.sourceBinNumber))
			return false;
		if (systemSeqNumber == null) {
			if (other.systemSeqNumber != null)
				return false;
		} else if (!systemSeqNumber.equals(other.systemSeqNumber))
			return false;
		if (transSeqNumber == null) {
			if (other.transSeqNumber != null)
				return false;
		} else if (!transSeqNumber.equals(other.transSeqNumber))
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		if (transactoionCode == null) {
			if (other.transactoionCode != null)
				return false;
		} else if (!transactoionCode.equals(other.transactoionCode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsoNegativeCardsEntity [fileRefNumber=");
		builder.append(fileRefNumber);
		builder.append(", systemSeqNumber=");
		builder.append(systemSeqNumber);
		builder.append(", transactoionCode=");
		builder.append(transactoionCode);
		builder.append(", destBinNumber=");
		builder.append(destBinNumber);
		builder.append(", sourceBinNumber=");
		builder.append(sourceBinNumber);
		builder.append(", transSeqNumber=");
		builder.append(transSeqNumber);
		builder.append(", transactionType=");
		builder.append(transactionType);
		builder.append(", authCenter=");
		builder.append(authCenter);
		builder.append(", negativeAccNumber=");
		builder.append(negativeAccNumber);
		builder.append(", responseCode=");
		builder.append(responseCode);
		builder.append(", purgeDate=");
		builder.append(purgeDate);
		builder.append(", regionCode=");
		builder.append(regionCode);
		builder.append(", cardHolderName=");
		builder.append(cardHolderName);
		builder.append(", acquirer=");
		builder.append(acquirer);
		builder.append("]");
		return builder.toString();
	}
	
	
}

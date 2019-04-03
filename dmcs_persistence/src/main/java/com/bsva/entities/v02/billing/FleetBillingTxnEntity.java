package com.bsva.entities.v02.billing;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class FleetBillingTxnEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "TRAN_SYSTEM_SEQ_NUMBER")
	private Long systemSeqNumber;
    @Column(name = "CARD_TYPE")
    private  Integer cardType;
    @Column(name = "AMOUNT")
    private  Long amount;
    @Column(name = "SERVICE_ID")
    private  String serviceID;
    @Column(name = "SUB_SERVICE_ID")
    private  String subServiceID;
    @Column(name = "ISSUER_CODE")
    private  Integer issuerCode;
    @Column(name = "ACQUIRER_CODE")
    private  Integer acquirerCode;
    @Column(name = "ACCOUNT_NUMBER")
    private  String accountNumber;
    @Column(name = "TX_CDE")
    private  Integer txnCode;
    @Column(name = "TX_DATE_TIME")
    private  Long txnDateTime;
    @Column(name="ACQ_REF_NO")
    private String acquirerBin;
    
    @Transient
    private  Integer txnCount;

   

    public FleetBillingTxnEntity(){
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Long getSystemSeqNumber() {
		return systemSeqNumber;
	}



	public Integer getCardType() {
		return cardType;
	}



	public Long getAmount() {
		return amount;
	}



	public String getServiceID() {
		return serviceID;
	}



	public String getSubServiceID() {
		return subServiceID;
	}



	public Integer getIssuerCode() {
		return issuerCode;
	}



	public Integer getAcquirerCode() {
		return acquirerCode;
	}



	public String getAccountNumber() {
		return accountNumber;
	}



	public Integer getTxnCode() {
		return txnCode;
	}



	public Long getTxnDateTime() {
		return txnDateTime;
	}



	public String getAcquirerBin() {
		return acquirerBin;
	}



	public Integer getTxnCount() {
		return txnCount;
	}



	public void setSystemSeqNumber(Long systemSeqNumber) {
		this.systemSeqNumber = systemSeqNumber;
	}



	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}



	public void setAmount(Long amount) {
		this.amount = amount;
	}



	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}



	public void setSubServiceID(String subServiceID) {
		this.subServiceID = subServiceID;
	}



	public void setIssuerCode(Integer issuerCode) {
		this.issuerCode = issuerCode;
	}



	public void setAcquirerCode(Integer acquirerCode) {
		this.acquirerCode = acquirerCode;
	}



	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public void setTxnCode(Integer txnCode) {
		this.txnCode = txnCode;
	}



	public void setTxnDateTime(Long txnDateTime) {
		this.txnDateTime = txnDateTime;
	}



	public void setAcquirerBin(String acquirerBin) {
		this.acquirerBin = acquirerBin;
	}



	public void setTxnCount(Integer txnCount) {
		this.txnCount = txnCount;
	}

	 public void incrementTxnCount() {

	        if (txnCount == null) {
	            txnCount = 1;
	        } else {
	            txnCount = txnCount + 1;
	        }
	    }

	  public void addAmount(Long amount) {

	        if (amount == null) {
	            return;
	        }

	        if (this.amount == null) {
	            this.amount = 0L;
	        }

	        this.amount += amount;
	    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((acquirerBin == null) ? 0 : acquirerBin.hashCode());
		result = prime * result + ((acquirerCode == null) ? 0 : acquirerCode.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((issuerCode == null) ? 0 : issuerCode.hashCode());
		result = prime * result + ((serviceID == null) ? 0 : serviceID.hashCode());
		result = prime * result + ((subServiceID == null) ? 0 : subServiceID.hashCode());
		result = prime * result + ((systemSeqNumber == null) ? 0 : systemSeqNumber.hashCode());
		result = prime * result + ((txnCode == null) ? 0 : txnCode.hashCode());
		result = prime * result + ((txnCount == null) ? 0 : txnCount.hashCode());
		result = prime * result + ((txnDateTime == null) ? 0 : txnDateTime.hashCode());
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
		FleetBillingTxnEntity other = (FleetBillingTxnEntity) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		}
		else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (acquirerBin == null) {
			if (other.acquirerBin != null)
				return false;
		}
		else if (!acquirerBin.equals(other.acquirerBin))
			return false;
		if (acquirerCode == null) {
			if (other.acquirerCode != null)
				return false;
		}
		else if (!acquirerCode.equals(other.acquirerCode))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		}
		else if (!amount.equals(other.amount))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		}
		else if (!cardType.equals(other.cardType))
			return false;
		if (issuerCode == null) {
			if (other.issuerCode != null)
				return false;
		}
		else if (!issuerCode.equals(other.issuerCode))
			return false;
		if (serviceID == null) {
			if (other.serviceID != null)
				return false;
		}
		else if (!serviceID.equals(other.serviceID))
			return false;
		if (subServiceID == null) {
			if (other.subServiceID != null)
				return false;
		}
		else if (!subServiceID.equals(other.subServiceID))
			return false;
		if (systemSeqNumber == null) {
			if (other.systemSeqNumber != null)
				return false;
		}
		else if (!systemSeqNumber.equals(other.systemSeqNumber))
			return false;
		if (txnCode == null) {
			if (other.txnCode != null)
				return false;
		}
		else if (!txnCode.equals(other.txnCode))
			return false;
		if (txnCount == null) {
			if (other.txnCount != null)
				return false;
		}
		else if (!txnCount.equals(other.txnCount))
			return false;
		if (txnDateTime == null) {
			if (other.txnDateTime != null)
				return false;
		}
		else if (!txnDateTime.equals(other.txnDateTime))
			return false;
		return true;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FleetBillingTxnEntity [systemSeqNumber=");
		builder.append(systemSeqNumber);
		builder.append(", cardType=");
		builder.append(cardType);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", serviceID=");
		builder.append(serviceID);
		builder.append(", subServiceID=");
		builder.append(subServiceID);
		builder.append(", issuerCode=");
		builder.append(issuerCode);
		builder.append(", acquirerCode=");
		builder.append(acquirerCode);
		builder.append(", accountNumber=");
		builder.append(accountNumber);
		builder.append(", txnCode=");
		builder.append(txnCode);
		builder.append(", txnDateTime=");
		builder.append(txnDateTime);
		builder.append(", acquirerBin=");
		builder.append(acquirerBin);
		builder.append(", txnCount=");
		builder.append(txnCount);
		builder.append("]");
		return builder.toString();
	}


}

package com.bsva.entities.v02.settlement;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name="CSO_SETTLEMENT_MATRIXES")
@DynamicUpdate
public class CsoSettlementMatrixEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	CsoSettlementMatrixEntity_PK csoSettlementMatrixEntity_PK;
	@Column(name="CURRENCY_CODE")
	private String currencyCode;
	@Column(name="STATUS_CODE")
	private String statusCode;	
	@Column(name="BANK_OUTPUT_CREATED_IND")
	private String bankOutputCreatedInd;
	@Column(name="CR_VOLUME")
	private String crVolume;
	@Column(name="CR_VALUE")
	private String crValue;
	@Column(name="DR_VOLUME")
	private String drVolume;
	@Column(name="DR_VALUE")
	private String drValue;
	@Column(name="PAYMENT_STREAM")
	private String paymentStream;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public CsoSettlementMatrixEntity(){
		
	}
	public CsoSettlementMatrixEntity_PK getCsoSettlementMatrixEntity_PK() {
		return csoSettlementMatrixEntity_PK;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public String getBankOutputCreatedInd() {
		return bankOutputCreatedInd;
	}
	public String getCrVolume() {
		return crVolume;
	}
	public String getCrValue() {
		return crValue;
	}
	public String getDrVolume() {
		return drVolume;
	}
	public String getDrValue() {
		return drValue;
	}
	public String getPaymentStream() {
		return paymentStream;
	}
	public void setCsoSettlementMatrixEntity_PK(CsoSettlementMatrixEntity_PK csoSettlementMatrixEntity_PK) {
		this.csoSettlementMatrixEntity_PK = csoSettlementMatrixEntity_PK;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public void setBankOutputCreatedInd(String bankOutputCreatedInd) {
		this.bankOutputCreatedInd = bankOutputCreatedInd;
	}
	public void setCrVolume(String crVolume) {
		this.crVolume = crVolume;
	}
	public void setCrValue(String crValue) {
		this.crValue = crValue;
	}
	public void setDrVolume(String drVolume) {
		this.drVolume = drVolume;
	}
	public void setDrValue(String drValue) {
		this.drValue = drValue;
	}
	public void setPaymentStream(String paymentStream) {
		this.paymentStream = paymentStream;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankOutputCreatedInd == null) ? 0 : bankOutputCreatedInd.hashCode());
		result = prime * result + ((crValue == null) ? 0 : crValue.hashCode());
		result = prime * result + ((crVolume == null) ? 0 : crVolume.hashCode());
		result = prime * result
				+ ((csoSettlementMatrixEntity_PK == null) ? 0 : csoSettlementMatrixEntity_PK.hashCode());
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((drValue == null) ? 0 : drValue.hashCode());
		result = prime * result + ((drVolume == null) ? 0 : drVolume.hashCode());
		result = prime * result + ((paymentStream == null) ? 0 : paymentStream.hashCode());
		result = prime * result + ((statusCode == null) ? 0 : statusCode.hashCode());
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
		CsoSettlementMatrixEntity other = (CsoSettlementMatrixEntity) obj;
		if (bankOutputCreatedInd == null) {
			if (other.bankOutputCreatedInd != null)
				return false;
		} else if (!bankOutputCreatedInd.equals(other.bankOutputCreatedInd))
			return false;
		if (crValue == null) {
			if (other.crValue != null)
				return false;
		} else if (!crValue.equals(other.crValue))
			return false;
		if (crVolume == null) {
			if (other.crVolume != null)
				return false;
		} else if (!crVolume.equals(other.crVolume))
			return false;
		if (csoSettlementMatrixEntity_PK == null) {
			if (other.csoSettlementMatrixEntity_PK != null)
				return false;
		} else if (!csoSettlementMatrixEntity_PK.equals(other.csoSettlementMatrixEntity_PK))
			return false;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (drValue == null) {
			if (other.drValue != null)
				return false;
		} else if (!drValue.equals(other.drValue))
			return false;
		if (drVolume == null) {
			if (other.drVolume != null)
				return false;
		} else if (!drVolume.equals(other.drVolume))
			return false;
		if (paymentStream == null) {
			if (other.paymentStream != null)
				return false;
		} else if (!paymentStream.equals(other.paymentStream))
			return false;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsoSettlementMatrixEntity [csoSettlementMatrixEntity_PK=");
		builder.append(csoSettlementMatrixEntity_PK);
		builder.append(", currencyCode=");
		builder.append(currencyCode);
		builder.append(", statusCode=");
		builder.append(statusCode);
		builder.append(", bankOutputCreatedInd=");
		builder.append(bankOutputCreatedInd);
		builder.append(", crVolume=");
		builder.append(crVolume);
		builder.append(", crValue=");
		builder.append(crValue);
		builder.append(", drVolume=");
		builder.append(drVolume);
		builder.append(", drValue=");
		builder.append(drValue);
		builder.append(", paymentStream=");
		builder.append(paymentStream);
		builder.append("]");
		return builder.toString();
	}
	

}

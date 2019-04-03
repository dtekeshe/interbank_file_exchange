package com.bsva.entities.v02.settlement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "CSV_SETTLEMENT_VIEW")
@DynamicUpdate
public class CsvSettlementView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private CsvSettlementView_PK csvSettlementView_PK;
	
	
	@Column(name = "PAYMENT_STREAM")
	private String paymentStream;
	@Column(name = "CURRENCY_CODE")
	private String currencyCode;
	@Column(name = "STATUS_CODE")
	private String statusCode;
	@Column(name = "SETTLEMENT_IND")
	private String settlementInd;
	@Column(name = "CR_VOLUME")
	private Integer crVolume;
	@Column(name = "CR_VALUE")
	private BigDecimal crValue;
	@Column(name = "DR_VOLUME")
	private Integer drVolume;
	@Column(name = "DR_VALUE")
	private BigDecimal drValue;
	
	public CsvSettlementView(){
		
	}

	public CsvSettlementView(CsvSettlementView_PK csvSettlementView_PK, String paymentStream, String currencyCode,
			String statusCode, String settlementInd, Integer crVolume, BigDecimal crValue, Integer drVolume,
			BigDecimal drValue) {
		super();
		this.csvSettlementView_PK = csvSettlementView_PK;
		this.paymentStream = paymentStream;
		this.currencyCode = currencyCode;
		this.statusCode = statusCode;
		this.settlementInd = settlementInd;
		this.crVolume = crVolume;
		this.crValue = crValue;
		this.drVolume = drVolume;
		this.drValue = drValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CsvSettlementView_PK getCsvSettlementView_PK() {
		return csvSettlementView_PK;
	}

	public String getPaymentStream() {
		return paymentStream;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getSettlementInd() {
		return settlementInd;
	}

	public Integer getCrVolume() {
		return crVolume;
	}

	public BigDecimal getCrValue() {
		return crValue;
	}

	public Integer getDrVolume() {
		return drVolume;
	}

	public BigDecimal getDrValue() {
		return drValue;
	}

	public void setCsvSettlementView_PK(CsvSettlementView_PK csvSettlementView_PK) {
		this.csvSettlementView_PK = csvSettlementView_PK;
	}

	public void setPaymentStream(String paymentStream) {
		this.paymentStream = paymentStream;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public void setSettlementInd(String settlementInd) {
		this.settlementInd = settlementInd;
	}

	public void setCrVolume(Integer crVolume) {
		this.crVolume = crVolume;
	}

	public void setCrValue(BigDecimal crValue) {
		this.crValue = crValue;
	}

	public void setDrVolume(Integer drVolume) {
		this.drVolume = drVolume;
	}

	public void setDrValue(BigDecimal drValue) {
		this.drValue = drValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crValue == null) ? 0 : crValue.hashCode());
		result = prime * result + ((crVolume == null) ? 0 : crVolume.hashCode());
		result = prime * result + ((csvSettlementView_PK == null) ? 0 : csvSettlementView_PK.hashCode());
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((drValue == null) ? 0 : drValue.hashCode());
		result = prime * result + ((drVolume == null) ? 0 : drVolume.hashCode());
		result = prime * result + ((paymentStream == null) ? 0 : paymentStream.hashCode());
		result = prime * result + ((settlementInd == null) ? 0 : settlementInd.hashCode());
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
		CsvSettlementView other = (CsvSettlementView) obj;
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
		if (csvSettlementView_PK == null) {
			if (other.csvSettlementView_PK != null)
				return false;
		} else if (!csvSettlementView_PK.equals(other.csvSettlementView_PK))
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
		if (settlementInd == null) {
			if (other.settlementInd != null)
				return false;
		} else if (!settlementInd.equals(other.settlementInd))
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
		builder.append("CsvSettlementView [csvSettlementView_PK=");
		builder.append(csvSettlementView_PK);
		builder.append(", paymentStream=");
		builder.append(paymentStream);
		builder.append(", currencyCode=");
		builder.append(currencyCode);
		builder.append(", statusCode=");
		builder.append(statusCode);
		builder.append(", settlementInd=");
		builder.append(settlementInd);
		builder.append(", crVolume=");
		builder.append(crVolume);
		builder.append(", crValue=");
		builder.append(crValue);
		builder.append(", drVolume=");
		builder.append(drVolume);
		builder.append(", drValue=");
		builder.append(drValue);
		builder.append("]");
		return builder.toString();
	}

	
	
}

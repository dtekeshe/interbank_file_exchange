package com.bsva.dao.v02.fileextract;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class PaymentInstVISA_PK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="SYSTEM_GEN_SEQ_NUMBER")
	private String sysGenNumber;
	@Column(name="TRANSACTION_CODE_NUMBER")
	private String transCodeNumber;
	
	public PaymentInstVISA_PK(){
		
	}

	public PaymentInstVISA_PK(String sysGenNumber, String transCodeNumber) {
		super();
		this.sysGenNumber = sysGenNumber;
		this.transCodeNumber = transCodeNumber;
	}

	public String getSysGenNumber() {
		return sysGenNumber;
	}

	public String getTransCodeNumber() {
		return transCodeNumber;
	}

	public void setSysGenNumber(String sysGenNumber) {
		this.sysGenNumber = sysGenNumber;
	}

	public void setTransCodeNumber(String transCodeNumber) {
		this.transCodeNumber = transCodeNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sysGenNumber == null) ? 0 : sysGenNumber.hashCode());
		result = prime * result + ((transCodeNumber == null) ? 0 : transCodeNumber.hashCode());
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
		PaymentInstVISA_PK other = (PaymentInstVISA_PK) obj;
		if (sysGenNumber == null) {
			if (other.sysGenNumber != null)
				return false;
		} else if (!sysGenNumber.equals(other.sysGenNumber))
			return false;
		if (transCodeNumber == null) {
			if (other.transCodeNumber != null)
				return false;
		} else if (!transCodeNumber.equals(other.transCodeNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaymentInstVISA_PK [sysGenNumber=");
		builder.append(sysGenNumber);
		builder.append(", transCodeNumber=");
		builder.append(transCodeNumber);
		builder.append("]");
		return builder.toString();
	}
}

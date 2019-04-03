package com.bsva.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class CsvCcr00xDataViewPK implements Serializable{
	
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Basic(optional = false)
	    @NotNull
	    @Column(name = "ISSUER_CODE")
	    private String issuerCode;
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "ACQUIRER_CODE")
	    private String acquirerCode;
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "CARD_TYPE")
	    private String cardType;
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "TRANSACTION_CODE")
	    private String transactionCode;
	    
	    
		public CsvCcr00xDataViewPK() {
			super();
		}


		public CsvCcr00xDataViewPK(String issuerCode, String acquirerCode,
				String cardType, String transactionCode) {
			this.issuerCode = issuerCode;
			this.acquirerCode = acquirerCode;
			this.cardType = cardType;
			this.transactionCode = transactionCode;
		}
		
		
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public String getIssuerCode() {
			return issuerCode;
		}
		public String getAcquirerCode() {
			return acquirerCode;
		}
		public String getCardType() {
			return cardType;
		}
		public String getTransactionCode() {
			return transactionCode;
		}
		public void setIssuerCode(String issuerCode) {
			this.issuerCode = issuerCode;
		}
		public void setAcquirerCode(String acquirerCode) {
			this.acquirerCode = acquirerCode;
		}
		public void setCardType(String cardType) {
			this.cardType = cardType;
		}
		public void setTransactionCode(String transactionCode) {
			this.transactionCode = transactionCode;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((acquirerCode == null) ? 0 : acquirerCode.hashCode());
			result = prime * result
					+ ((cardType == null) ? 0 : cardType.hashCode());
			result = prime * result
					+ ((issuerCode == null) ? 0 : issuerCode.hashCode());
			result = prime
					* result
					+ ((transactionCode == null) ? 0 : transactionCode
							.hashCode());
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
			CsvCcr00xDataViewPK other = (CsvCcr00xDataViewPK) obj;
			if (acquirerCode == null) {
				if (other.acquirerCode != null)
					return false;
			} else if (!acquirerCode.equals(other.acquirerCode))
				return false;
			if (cardType == null) {
				if (other.cardType != null)
					return false;
			} else if (!cardType.equals(other.cardType))
				return false;
			if (issuerCode == null) {
				if (other.issuerCode != null)
					return false;
			} else if (!issuerCode.equals(other.issuerCode))
				return false;
			if (transactionCode == null) {
				if (other.transactionCode != null)
					return false;
			} else if (!transactionCode.equals(other.transactionCode))
				return false;
			return true;
		}


		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("CsvCcr00xDataViewPK [issuerCode=");
			builder.append(issuerCode);
			builder.append(", acquirerCode=");
			builder.append(acquirerCode);
			builder.append(", cardType=");
			builder.append(cardType);
			builder.append(", transactionCode=");
			builder.append(transactionCode);
			builder.append("]");
			return builder.toString();
		}

}

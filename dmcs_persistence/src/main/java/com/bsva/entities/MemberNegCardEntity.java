package com.bsva.entities;



	import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

	/**
	 * TODO Document
	 */
	@Entity
	@DynamicUpdate
	public class MemberNegCardEntity implements Serializable {
		
		private static final long serialVersionUID = 1L;
		@Id
	    @Column(name = "BANK_CODE")
	    private Integer bankCode;
	    @Column(name = "NEG_CARD_DATA_REQUIRED")
	    private String negCardDataRequired;
	    
		public MemberNegCardEntity() {
		}

		public MemberNegCardEntity(Integer bankCode, String negCardDataRequired) {
			super();
			this.bankCode = bankCode;
			this.negCardDataRequired = negCardDataRequired;
		}
		
		public Integer getBankCode() {
			return bankCode;
		}
		public String getNegCardDataRequired() {
			return negCardDataRequired;
		}
		public void setBankCode(Integer bankCode) {
			this.bankCode = bankCode;
		}
		public void setNegCardDataRequired(String negCardDataRequired) {
			this.negCardDataRequired = negCardDataRequired;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((bankCode == null) ? 0 : bankCode.hashCode());
			result = prime * result + ((negCardDataRequired == null) ? 0 : negCardDataRequired.hashCode());
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
			MemberNegCardEntity other = (MemberNegCardEntity) obj;
			if (bankCode == null) {
				if (other.bankCode != null)
					return false;
			} else if (!bankCode.equals(other.bankCode))
				return false;
			if (negCardDataRequired == null) {
				if (other.negCardDataRequired != null)
					return false;
			} else if (!negCardDataRequired.equals(other.negCardDataRequired))
				return false;
			return true;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("MemberNegCardDAO [bankCode=");
			builder.append(bankCode);
			builder.append(", negCardDataRequired=");
			builder.append(negCardDataRequired);
			builder.append("]");
			return builder.toString();
		}


}


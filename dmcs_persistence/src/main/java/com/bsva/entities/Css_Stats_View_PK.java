package com.bsva.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Css_Stats_View_PK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	    @Column(name = "ISSUER_BIN")
	    private String issuerBin;	    
	    @Column(name = "ISSUING_MEMBER")	    
	    private Short issuingMember;	    
	    @Column(name = "ISSUING_MEMBER_NAME")
	    private String issuingMemberName;
	    @Column(name = "CARD_TYPE")
	    private String cardType;
	    @Column(name = "CARD_DESCRIPTION")
	    private String cardDescription;
	    @Column(name = "ACQUIRING_MEMBER")	    
	    private Short acquiringMember;
	    @Column(name = "ACQUIRING_MEMBER_NAME")
	    private String acquiringMemberName;	    
	    @Column(name = "ITEM_CHARGE")
	    private BigDecimal itemCharge;	    
	    @Column(name = "ITEM_CHARGE_AMOUNT")
	    private BigDecimal itemChargeAmount;
	    
	    public Css_Stats_View_PK(){
	    	
	    }

		public Css_Stats_View_PK(String issuerBin, Short issuingMember, String issuingMemberName, String cardType,
				String cardDescription, Short acquiringMember, String acquiringMemberName, BigDecimal itemCharge,
				BigDecimal itemChargeAmount) {
			super();
			this.issuerBin = issuerBin;
			this.issuingMember = issuingMember;
			this.issuingMemberName = issuingMemberName;
			this.cardType = cardType;
			this.cardDescription = cardDescription;
			this.acquiringMember = acquiringMember;
			this.acquiringMemberName = acquiringMemberName;
			this.itemCharge = itemCharge;
			this.itemChargeAmount = itemChargeAmount;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public String getIssuerBin() {
			return issuerBin;
		}

		public Short getIssuingMember() {
			return issuingMember;
		}

		public String getIssuingMemberName() {
			return issuingMemberName;
		}

		public String getCardType() {
			return cardType;
		}

		public String getCardDescription() {
			return cardDescription;
		}

		public Short getAcquiringMember() {
			return acquiringMember;
		}

		public String getAcquiringMemberName() {
			return acquiringMemberName;
		}

		public BigDecimal getItemCharge() {
			return itemCharge;
		}

		public BigDecimal getItemChargeAmount() {
			return itemChargeAmount;
		}

		public void setIssuerBin(String issuerBin) {
			this.issuerBin = issuerBin;
		}

		public void setIssuingMember(Short issuingMember) {
			this.issuingMember = issuingMember;
		}

		public void setIssuingMemberName(String issuingMemberName) {
			this.issuingMemberName = issuingMemberName;
		}

		public void setCardType(String cardType) {
			this.cardType = cardType;
		}

		public void setCardDescription(String cardDescription) {
			this.cardDescription = cardDescription;
		}

		public void setAcquiringMember(Short acquiringMember) {
			this.acquiringMember = acquiringMember;
		}

		public void setAcquiringMemberName(String acquiringMemberName) {
			this.acquiringMemberName = acquiringMemberName;
		}

		public void setItemCharge(BigDecimal itemCharge) {
			this.itemCharge = itemCharge;
		}

		public void setItemChargeAmount(BigDecimal itemChargeAmount) {
			this.itemChargeAmount = itemChargeAmount;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((acquiringMember == null) ? 0 : acquiringMember.hashCode());
			result = prime * result + ((acquiringMemberName == null) ? 0 : acquiringMemberName.hashCode());
			result = prime * result + ((cardDescription == null) ? 0 : cardDescription.hashCode());
			result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
			result = prime * result + ((issuerBin == null) ? 0 : issuerBin.hashCode());
			result = prime * result + ((issuingMember == null) ? 0 : issuingMember.hashCode());
			result = prime * result + ((issuingMemberName == null) ? 0 : issuingMemberName.hashCode());
			result = prime * result + ((itemCharge == null) ? 0 : itemCharge.hashCode());
			result = prime * result + ((itemChargeAmount == null) ? 0 : itemChargeAmount.hashCode());
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
			Css_Stats_View_PK other = (Css_Stats_View_PK) obj;
			if (acquiringMember == null) {
				if (other.acquiringMember != null)
					return false;
			} else if (!acquiringMember.equals(other.acquiringMember))
				return false;
			if (acquiringMemberName == null) {
				if (other.acquiringMemberName != null)
					return false;
			} else if (!acquiringMemberName.equals(other.acquiringMemberName))
				return false;
			if (cardDescription == null) {
				if (other.cardDescription != null)
					return false;
			} else if (!cardDescription.equals(other.cardDescription))
				return false;
			if (cardType == null) {
				if (other.cardType != null)
					return false;
			} else if (!cardType.equals(other.cardType))
				return false;
			if (issuerBin == null) {
				if (other.issuerBin != null)
					return false;
			} else if (!issuerBin.equals(other.issuerBin))
				return false;
			if (issuingMember == null) {
				if (other.issuingMember != null)
					return false;
			} else if (!issuingMember.equals(other.issuingMember))
				return false;
			if (issuingMemberName == null) {
				if (other.issuingMemberName != null)
					return false;
			} else if (!issuingMemberName.equals(other.issuingMemberName))
				return false;
			if (itemCharge == null) {
				if (other.itemCharge != null)
					return false;
			} else if (!itemCharge.equals(other.itemCharge))
				return false;
			if (itemChargeAmount == null) {
				if (other.itemChargeAmount != null)
					return false;
			} else if (!itemChargeAmount.equals(other.itemChargeAmount))
				return false;
			return true;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Css_Stats_View_PK [issuerBin=");
			builder.append(issuerBin);
			builder.append(", issuingMember=");
			builder.append(issuingMember);
			builder.append(", issuingMemberName=");
			builder.append(issuingMemberName);
			builder.append(", cardType=");
			builder.append(cardType);
			builder.append(", cardDescription=");
			builder.append(cardDescription);
			builder.append(", acquiringMember=");
			builder.append(acquiringMember);
			builder.append(", acquiringMemberName=");
			builder.append(acquiringMemberName);
			builder.append(", itemCharge=");
			builder.append(itemCharge);
			builder.append(", itemChargeAmount=");
			builder.append(itemChargeAmount);
			builder.append("]");
			return builder.toString();
		}
	   
}

package com.bsva.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CsvCcr015View_PK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Size(max = 6)
	@Column(name = "PROCESS_MONTH")
	private String processMonth;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ISSUER_BIN")
    private String issuerBin;
	@Column(name = "ISSUER_MEMBER")
    private Long issuerMember;
	@Size(max = 30)
    @Column(name = "CARD_DESCRIPTION")
    private String cardDescription;
    @Column(name = "CARD_TYPE")
    private Long cardType;
    @Column(name = "ACQUIRING_MEMBER")
    private Long acquiringMember;
    @Size(max = 4)
    @Column(name = "MERCHANT_CAT_CODE")
    private String merchantCatCode;
    @Column(name = "INTERCHANGE_RATE_DESIGNATOR")
    private Long interchangeRateDesignator;
    @Column(name = "ITEM_CHARGE")
    private Long itemCharge;
    @Size(max = 30)
    @Column(name = "TRANSACTION_DESCRIPTION")
    private String transactionDescription;
    
	public CsvCcr015View_PK() {
		super();
	}
	public CsvCcr015View_PK(String processMonth, String issuerBin, Long issuerMember, String cardDescription,
			Long cardType, Long acquiringMember, String merchantCatCode,
			Long interchangeRateDesignator, Long itemCharge, String transactionDescription) {
		super();
		this.processMonth = processMonth;
		this.issuerBin = issuerBin;
		this.issuerMember = issuerMember;
		this.cardDescription = cardDescription;
		this.cardType = cardType;
		this.acquiringMember = acquiringMember;
		this.merchantCatCode = merchantCatCode;
		this.interchangeRateDesignator = interchangeRateDesignator;
		this.itemCharge = itemCharge;
		this.transactionDescription = transactionDescription;
	}
	public String getProcessMonth() {
		return processMonth;
	}
	public String getIssuerBin() {
		return issuerBin;
	}
	public Long getIssuerMember() {
		return issuerMember;
	}
	public String getCardDescription() {
		return cardDescription;
	}
	public Long getCardType() {
		return cardType;
	}
	public Long getAcquiringMember() {
		return acquiringMember;
	}
	public String getMerchantCatCode() {
		return merchantCatCode;
	}
	public Long getInterchangeRateDesignator() {
		return interchangeRateDesignator;
	}
	public Long getItemCharge() {
		return itemCharge;
	}
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public void setProcessMonth(String processMonth) {
		this.processMonth = processMonth;
	}
	public void setIssuerBin(String issuerBin) {
		this.issuerBin = issuerBin;
	}
	public void setIssuerMember(Long issuerMember) {
		this.issuerMember = issuerMember;
	}
	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}
	public void setCardType(Long cardType) {
		this.cardType = cardType;
	}
	public void setAcquiringMember(Long acquiringMember) {
		this.acquiringMember = acquiringMember;
	}
	public void setMerchantCatCode(String merchantCatCode) {
		this.merchantCatCode = merchantCatCode;
	}
	public void setInterchangeRateDesignator(Long interchangeRateDesignator) {
		this.interchangeRateDesignator = interchangeRateDesignator;
	}
	public void setItemCharge(Long itemCharge) {
		this.itemCharge = itemCharge;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquiringMember == null) ? 0 : acquiringMember.hashCode());
		result = prime * result + ((cardDescription == null) ? 0 : cardDescription.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((interchangeRateDesignator == null) ? 0 : interchangeRateDesignator.hashCode());
		result = prime * result + ((issuerBin == null) ? 0 : issuerBin.hashCode());
		result = prime * result + ((issuerMember == null) ? 0 : issuerMember.hashCode());
		result = prime * result + ((itemCharge == null) ? 0 : itemCharge.hashCode());
		result = prime * result + ((merchantCatCode == null) ? 0 : merchantCatCode.hashCode());
		result = prime * result + ((processMonth == null) ? 0 : processMonth.hashCode());
		result = prime * result + ((transactionDescription == null) ? 0 : transactionDescription.hashCode());
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
		CsvCcr015View_PK other = (CsvCcr015View_PK) obj;
		if (acquiringMember == null) {
			if (other.acquiringMember != null)
				return false;
		} else if (!acquiringMember.equals(other.acquiringMember))
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
		if (interchangeRateDesignator == null) {
			if (other.interchangeRateDesignator != null)
				return false;
		} else if (!interchangeRateDesignator.equals(other.interchangeRateDesignator))
			return false;
		if (issuerBin == null) {
			if (other.issuerBin != null)
				return false;
		} else if (!issuerBin.equals(other.issuerBin))
			return false;
		if (issuerMember == null) {
			if (other.issuerMember != null)
				return false;
		} else if (!issuerMember.equals(other.issuerMember))
			return false;
		if (itemCharge == null) {
			if (other.itemCharge != null)
				return false;
		} else if (!itemCharge.equals(other.itemCharge))
			return false;
		if (merchantCatCode == null) {
			if (other.merchantCatCode != null)
				return false;
		} else if (!merchantCatCode.equals(other.merchantCatCode))
			return false;
		if (processMonth == null) {
			if (other.processMonth != null)
				return false;
		} else if (!processMonth.equals(other.processMonth))
			return false;
		if (transactionDescription == null) {
			if (other.transactionDescription != null)
				return false;
		} else if (!transactionDescription.equals(other.transactionDescription))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsvCcr015View_PK [processMonth=");
		builder.append(processMonth);
		builder.append(", issuerBin=");
		builder.append(issuerBin);
		builder.append(", issuerMember=");
		builder.append(issuerMember);
		builder.append(", cardDescription=");
		builder.append(cardDescription);
		builder.append(", cardType=");
		builder.append(cardType);
		builder.append(", acquiringMember=");
		builder.append(acquiringMember);
		builder.append(", merchantCatCode=");
		builder.append(merchantCatCode);
		builder.append(", interchangeRateDesignator=");
		builder.append(interchangeRateDesignator);
		builder.append(", itemCharge=");
		builder.append(itemCharge);
		builder.append(", transactionDescription=");
		builder.append(transactionDescription);
		builder.append("]");
		return builder.toString();
	}
	

}

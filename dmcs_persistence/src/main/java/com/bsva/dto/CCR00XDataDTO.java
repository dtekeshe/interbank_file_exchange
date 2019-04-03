package com.bsva.dto;

public class CCR00XDataDTO {

	private Integer issuerCode;
	private Integer acquirerCode;
	private String subService;
	private Integer txnCode;
	private String issuerMember;
	private String acquirerMember;
	private String txnDescription;
	private Integer cardType;
	private String cardDescription;
	private Long volume;
	private Double tranValue;
	private Double billingFee;
	private Double billingFeeAmount;
	private Double billingVAT;
	private Long reportSortSequence;
	
	public CCR00XDataDTO(){
		
	}

	public Integer getIssuerCode() {
		return issuerCode;
	}

	public Integer getAcquirerCode() {
		return acquirerCode;
	}

	public String getSubService() {
		return subService;
	}

	public Integer getTxnCode() {
		return txnCode;
	}

	public String getIssuerMember() {
		return issuerMember;
	}

	public String getAcquirerMember() {
		return acquirerMember;
	}

	public String getTxnDescription() {
		return txnDescription;
	}

	public Integer getCardType() {
		return cardType;
	}

	public String getCardDescription() {
		return cardDescription;
	}

	public Long getVolume() {
		return volume;
	}

	public Double getTranValue() {
		return tranValue;
	}

	public Double getBillingFee() {
		return billingFee;
	}

	public Double getBillingFeeAmount() {
		return billingFeeAmount;
	}

	public Double getBillingVAT() {
		return billingVAT;
	}

	public Long getReportSortSequence() {
		return reportSortSequence;
	}

	public void setIssuerCode(Integer issuerCode) {
		this.issuerCode = issuerCode;
	}

	public void setAcquirerCode(Integer acquirerCode) {
		this.acquirerCode = acquirerCode;
	}

	public void setSubService(String subService) {
		this.subService = subService;
	}

	public void setTxnCode(Integer txnCode) {
		this.txnCode = txnCode;
	}

	public void setIssuerMember(String issuerMember) {
		this.issuerMember = issuerMember;
	}

	public void setAcquirerMember(String acquirerMember) {
		this.acquirerMember = acquirerMember;
	}

	public void setTxnDescription(String txnDescription) {
		this.txnDescription = txnDescription;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public void setTranValue(Double tranValue) {
		this.tranValue = tranValue;
	}

	public void setBillingFee(Double billingFee) {
		this.billingFee = billingFee;
	}

	public void setBillingFeeAmount(Double billingFeeAmount) {
		this.billingFeeAmount = billingFeeAmount;
	}

	public void setBillingVAT(Double billingVAT) {
		this.billingVAT = billingVAT;
	}

	public void setReportSortSequence(Long reportSortSequence) {
		this.reportSortSequence = reportSortSequence;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CCR00XDataDTO [issuerCode=");
		builder.append(issuerCode);
		builder.append(", acquirerCode=");
		builder.append(acquirerCode);
		builder.append(", subService=");
		builder.append(subService);
		builder.append(", txnCode=");
		builder.append(txnCode);
		builder.append(", issuerMember=");
		builder.append(issuerMember);
		builder.append(", acquirerMember=");
		builder.append(acquirerMember);
		builder.append(", txnDescription=");
		builder.append(txnDescription);
		builder.append(", cardType=");
		builder.append(cardType);
		builder.append(", cardDescription=");
		builder.append(cardDescription);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", tranValue=");
		builder.append(tranValue);
		builder.append(", billingFee=");
		builder.append(billingFee);
		builder.append(", billingFeeAmount=");
		builder.append(billingFeeAmount);
		builder.append(", billingVAT=");
		builder.append(billingVAT);
		builder.append(", reportSortSequence=");
		builder.append(reportSortSequence);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquirerCode == null) ? 0 : acquirerCode.hashCode());
		result = prime * result + ((acquirerMember == null) ? 0 : acquirerMember.hashCode());
		result = prime * result + ((billingFee == null) ? 0 : billingFee.hashCode());
		result = prime * result + ((billingFeeAmount == null) ? 0 : billingFeeAmount.hashCode());
		result = prime * result + ((billingVAT == null) ? 0 : billingVAT.hashCode());
		result = prime * result + ((cardDescription == null) ? 0 : cardDescription.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((issuerCode == null) ? 0 : issuerCode.hashCode());
		result = prime * result + ((issuerMember == null) ? 0 : issuerMember.hashCode());
		result = prime * result + ((reportSortSequence == null) ? 0 : reportSortSequence.hashCode());
		result = prime * result + ((subService == null) ? 0 : subService.hashCode());
		result = prime * result + ((tranValue == null) ? 0 : tranValue.hashCode());
		result = prime * result + ((txnCode == null) ? 0 : txnCode.hashCode());
		result = prime * result + ((txnDescription == null) ? 0 : txnDescription.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
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
		CCR00XDataDTO other = (CCR00XDataDTO) obj;
		if (acquirerCode == null) {
			if (other.acquirerCode != null)
				return false;
		}
		else if (!acquirerCode.equals(other.acquirerCode))
			return false;
		if (acquirerMember == null) {
			if (other.acquirerMember != null)
				return false;
		}
		else if (!acquirerMember.equals(other.acquirerMember))
			return false;
		if (billingFee == null) {
			if (other.billingFee != null)
				return false;
		}
		else if (!billingFee.equals(other.billingFee))
			return false;
		if (billingFeeAmount == null) {
			if (other.billingFeeAmount != null)
				return false;
		}
		else if (!billingFeeAmount.equals(other.billingFeeAmount))
			return false;
		if (billingVAT == null) {
			if (other.billingVAT != null)
				return false;
		}
		else if (!billingVAT.equals(other.billingVAT))
			return false;
		if (cardDescription == null) {
			if (other.cardDescription != null)
				return false;
		}
		else if (!cardDescription.equals(other.cardDescription))
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
		if (issuerMember == null) {
			if (other.issuerMember != null)
				return false;
		}
		else if (!issuerMember.equals(other.issuerMember))
			return false;
		if (reportSortSequence == null) {
			if (other.reportSortSequence != null)
				return false;
		}
		else if (!reportSortSequence.equals(other.reportSortSequence))
			return false;
		if (subService == null) {
			if (other.subService != null)
				return false;
		}
		else if (!subService.equals(other.subService))
			return false;
		if (tranValue == null) {
			if (other.tranValue != null)
				return false;
		}
		else if (!tranValue.equals(other.tranValue))
			return false;
		if (txnCode == null) {
			if (other.txnCode != null)
				return false;
		}
		else if (!txnCode.equals(other.txnCode))
			return false;
		if (txnDescription == null) {
			if (other.txnDescription != null)
				return false;
		}
		else if (!txnDescription.equals(other.txnDescription))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		}
		else if (!volume.equals(other.volume))
			return false;
		return true;
	}
	
	
}

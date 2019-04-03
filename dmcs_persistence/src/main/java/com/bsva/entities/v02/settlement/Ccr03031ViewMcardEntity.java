package com.bsva.entities.v02.settlement;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="CSV_CCR03_VIEW_VISA")
public class Ccr03031ViewMcardEntity {
	
	@Column(name="ACQUIRER")
	private Integer acquirer;
	@Column(name="ISSUER")
	private Integer issuer;
	@Column(name="CARD_TYPE")
	private Integer cardType;
	@Column(name="REPORT_STRING")
	private String reportString;
	
	public Ccr03031ViewMcardEntity(){
		
	}

	public Integer getAcquirer() {
		return acquirer;
	}

	public Integer getIssuer() {
		return issuer;
	}

	public Integer getCardType() {
		return cardType;
	}

	public String getReportString() {
		return reportString;
	}

	public void setAcquirer(Integer acquirer) {
		this.acquirer = acquirer;
	}

	public void setIssuer(Integer issuer) {
		this.issuer = issuer;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public void setReportString(String reportString) {
		this.reportString = reportString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquirer == null) ? 0 : acquirer.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((issuer == null) ? 0 : issuer.hashCode());
		result = prime * result + ((reportString == null) ? 0 : reportString.hashCode());
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
		Ccr03031ViewMcardEntity other = (Ccr03031ViewMcardEntity) obj;
		if (acquirer == null) {
			if (other.acquirer != null)
				return false;
		}
		else if (!acquirer.equals(other.acquirer))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		}
		else if (!cardType.equals(other.cardType))
			return false;
		if (issuer == null) {
			if (other.issuer != null)
				return false;
		}
		else if (!issuer.equals(other.issuer))
			return false;
		if (reportString == null) {
			if (other.reportString != null)
				return false;
		}
		else if (!reportString.equals(other.reportString))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ccr03031ViewMcardEntity [acquirer=");
		builder.append(acquirer);
		builder.append(", issuer=");
		builder.append(issuer);
		builder.append(", cardType=");
		builder.append(cardType);
		builder.append(", reportString=");
		builder.append(reportString);
		builder.append("]");
		return builder.toString();
	}

	

}

package com.bsva.entities;

import java.io.Serializable;

import javax.persistence.Column;

public class CsvFleetBillViewPK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2384181533917253094L;
	
	@Column(name = "ACQUIRER")
	private String acquirer;
	@Column(name = "ISSUER")
	private String issuer; 
    @Column(name = "CARD_TYPE")
    private Integer cardType;
    @Column(name = "CARD_DESCRIPTION")
    private String cardDescription;
    @Column(name = "TRANSACTION_CODE")
    private Integer transactionCode;
    @Column(name = "TRANSACTION_DESCRIPTION")
    private String transactionDescription;
    @Column(name = "REPORT_SORT_SEQUENCE")
    private String reportSortSequence;
    @Column(name = "SERVICE")
    private String service;
    @Column(name = "SUB_SERVICE")
    private String subService;
    
    public String getAcquirer() {
		return acquirer;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setAcquirer(String acquirer) {
		this.acquirer = acquirer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public CsvFleetBillViewPK(){
    	
    }
    
	/*public String getAcquirerMember() {
		return acquirerMember;
	}
	public String getIssuerMember() {
		return issuerMember;
	}*/
	public Integer getCardType() {
		return cardType;
	}
	public String getCardDescription() {
		return cardDescription;
	}
	public Integer getTransactionCode() {
		return transactionCode;
	}
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public String getReportSortSequence() {
		return reportSortSequence;
	}
	public String getService() {
		return service;
	}
	public String getSubService() {
		return subService;
	}
/*	public void setAcquirerMember(String acquirerMember) {
		this.acquirerMember = acquirerMember;
	}
	public void setIssuerMember(String issuerMember) {
		this.issuerMember = issuerMember;
	}*/
	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}
	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}
	public void setTransactionCode(Integer transactionCode) {
		this.transactionCode = transactionCode;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	public void setReportSortSequence(String reportSortSequence) {
		this.reportSortSequence = reportSortSequence;
	}
	public void setService(String service) {
		this.service = service;
	}
	public void setSubService(String subService) {
		this.subService = subService;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquirer == null) ? 0 : acquirer.hashCode());
		result = prime * result + ((cardDescription == null) ? 0 : cardDescription.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((issuer == null) ? 0 : issuer.hashCode());
		result = prime * result + ((reportSortSequence == null) ? 0 : reportSortSequence.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result + ((subService == null) ? 0 : subService.hashCode());
		result = prime * result + ((transactionCode == null) ? 0 : transactionCode.hashCode());
		result = prime * result + ((transactionDescription == null) ? 0 : transactionDescription.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CsvFleetBillViewPK other = (CsvFleetBillViewPK) obj;
		if (acquirer == null) {
			if (other.acquirer != null)
				return false;
		} else if (!acquirer.equals(other.acquirer))
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
		if (issuer == null) {
			if (other.issuer != null)
				return false;
		} else if (!issuer.equals(other.issuer))
			return false;
		if (reportSortSequence == null) {
			if (other.reportSortSequence != null)
				return false;
		} else if (!reportSortSequence.equals(other.reportSortSequence))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (subService == null) {
			if (other.subService != null)
				return false;
		} else if (!subService.equals(other.subService))
			return false;
		if (transactionCode == null) {
			if (other.transactionCode != null)
				return false;
		} else if (!transactionCode.equals(other.transactionCode))
			return false;
		if (transactionDescription == null) {
			if (other.transactionDescription != null)
				return false;
		} else if (!transactionDescription.equals(other.transactionDescription))
			return false;
		return true;
	}
    
    

}

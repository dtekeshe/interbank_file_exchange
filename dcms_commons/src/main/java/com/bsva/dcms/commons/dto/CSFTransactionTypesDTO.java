package com.bsva.dcms.commons.dto;

import java.io.Serializable;
import java.util.Date;

public class CSFTransactionTypesDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int transactionCode;
	private String transactionDescription;
	private int reportSortSequence;
	private String financialInd;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDate;        
        private Integer amountDirection;    
        private Integer feeDirection;
        private Integer vatDirection;

    public int getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(int transactionCode) {
        this.transactionCode = transactionCode;
    }
        
        
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	public int getReportSortSequence() {
		return reportSortSequence;
	}
	public void setReportSortSequence(int reportSortSequence) {
		this.reportSortSequence = reportSortSequence;
	}
	public String getFinancialInd() {
		return financialInd;
	}
	public void setFinancialInd(String financialInd) {
		this.financialInd = financialInd;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

    public Integer getAmountDirection() {
        return amountDirection;
    }

    public void setAmountDirection(Integer amountDirection) {
        this.amountDirection = amountDirection;
    }

    public Integer getFeeDirection() {
        return feeDirection;
    }

    public void setFeeDirection(Integer feeDirection) {
        this.feeDirection = feeDirection;
    }

    public Integer getVatDirection() {
        return vatDirection;
    }

    public void setVatDirection(Integer vatDirection) {
        this.vatDirection = vatDirection;
    }
        
        

}

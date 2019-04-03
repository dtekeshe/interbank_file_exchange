package com.bsva.entities.v02.settlement;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class CCR00XDataKey implements Serializable {

    @Column(name = "ISSUER_CODE")
    private Integer issuerCode;
    @Column(name = "ACQUIRER_CODE")
    private Integer acquirerCode;
    @Column(name = "SUB_SERVICE")
    private String subService;
    @Column(name = "TRANSACTION_CODE")
    private Integer txnCode;

    public Integer getIssuerCode() {
        return issuerCode;
    }

    public void setIssuerCode(Integer issuerCode) {
        this.issuerCode = issuerCode;
    }

    public Integer getAcquirerCode() {
        return acquirerCode;
    }

    public void setAcquirerCode(Integer acquirerCode) {
        this.acquirerCode = acquirerCode;
    }

    public String getSubService() {
        return subService;
    }

    public void setSubService(String subService) {
        this.subService = subService;
    }

    public Integer getTxnCode() {
        return txnCode;
    }

    public void setTxnCode(Integer txnCode) {
        this.txnCode = txnCode;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquirerCode == null) ? 0 : acquirerCode.hashCode());
		result = prime * result + ((issuerCode == null) ? 0 : issuerCode.hashCode());
		result = prime * result + ((subService == null) ? 0 : subService.hashCode());
		result = prime * result + ((txnCode == null) ? 0 : txnCode.hashCode());
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
		CCR00XDataKey other = (CCR00XDataKey) obj;
		if (acquirerCode == null) {
			if (other.acquirerCode != null)
				return false;
		} else if (!acquirerCode.equals(other.acquirerCode))
			return false;
		if (issuerCode == null) {
			if (other.issuerCode != null)
				return false;
		} else if (!issuerCode.equals(other.issuerCode))
			return false;
		if (subService == null) {
			if (other.subService != null)
				return false;
		} else if (!subService.equals(other.subService))
			return false;
		if (txnCode == null) {
			if (other.txnCode != null)
				return false;
		} else if (!txnCode.equals(other.txnCode))
			return false;
		return true;
	}
}

package com.bsva.entities.v02.settlement;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class CCR00XSummaryDataKey implements Serializable {

    @Column(name = "ISSUER_CODE")
    private Integer issuerCode;
    @Column(name = "ACQUIRER_CODE")
    private Integer acquirerCode;
    @Column(name = "SUB_SERVICE")
    private String subService;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CCR00XSummaryDataKey that = (CCR00XSummaryDataKey) o;

		if (issuerCode != null ? !issuerCode.equals(that.issuerCode) : that.issuerCode != null) return false;
		if (acquirerCode != null ? !acquirerCode.equals(that.acquirerCode) : that.acquirerCode != null) return false;
		return !(subService != null ? !subService.equals(that.subService) : that.subService != null);

	}

	@Override
	public int hashCode() {
		int result = issuerCode != null ? issuerCode.hashCode() : 0;
		result = 31 * result + (acquirerCode != null ? acquirerCode.hashCode() : 0);
		result = 31 * result + (subService != null ? subService.hashCode() : 0);
		return result;
	}
}

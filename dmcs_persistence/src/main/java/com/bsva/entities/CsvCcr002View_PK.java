package com.bsva.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CsvCcr002View_PK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "ISSUER_MEMBER")
    private String issuerMember;
    @Column(name = "ISSUER_CODE")
    private String issuerCode;
    @Column(name = "ACQUIRER_MEMBER")
    private String acquireMember;
    @Column(name = "ACQUIRER_CODE")
    private String acquireCode;
    @Column(name = "SERVICE")
    private String service;
    @Column(name = "SUB_SERVICE")
    private String subService;
    
    public CsvCcr002View_PK(){
    	
    }
    
	public CsvCcr002View_PK(String issuerMember, String issuerCode, String acquireMember, String acquireCode,
			String service, String subService) {
		super();
		this.issuerMember = issuerMember;
		this.issuerCode = issuerCode;
		this.acquireMember = acquireMember;
		this.acquireCode = acquireCode;
		this.service = service;
		this.subService = subService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIssuerMember() {
		return issuerMember;
	}

	public String getIssuerCode() {
		return issuerCode;
	}

	public String getAcquireMember() {
		return acquireMember;
	}

	public String getAcquireCode() {
		return acquireCode;
	}

	public String getService() {
		return service;
	}

	public String getSubService() {
		return subService;
	}

	public void setIssuerMember(String issuerMember) {
		this.issuerMember = issuerMember;
	}

	public void setIssuerCode(String issuerCode) {
		this.issuerCode = issuerCode;
	}

	public void setAcquireMember(String acquireMember) {
		this.acquireMember = acquireMember;
	}

	public void setAcquireCode(String acquireCode) {
		this.acquireCode = acquireCode;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setSubService(String subService) {
		this.subService = subService;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquireCode == null) ? 0 : acquireCode.hashCode());
		result = prime * result + ((acquireMember == null) ? 0 : acquireMember.hashCode());
		result = prime * result + ((issuerCode == null) ? 0 : issuerCode.hashCode());
		result = prime * result + ((issuerMember == null) ? 0 : issuerMember.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result + ((subService == null) ? 0 : subService.hashCode());
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
		CsvCcr002View_PK other = (CsvCcr002View_PK) obj;
		if (acquireCode == null) {
			if (other.acquireCode != null)
				return false;
		} else if (!acquireCode.equals(other.acquireCode))
			return false;
		if (acquireMember == null) {
			if (other.acquireMember != null)
				return false;
		} else if (!acquireMember.equals(other.acquireMember))
			return false;
		if (issuerCode == null) {
			if (other.issuerCode != null)
				return false;
		} else if (!issuerCode.equals(other.issuerCode))
			return false;
		if (issuerMember == null) {
			if (other.issuerMember != null)
				return false;
		} else if (!issuerMember.equals(other.issuerMember))
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
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsvCcr002View_PK [issuerMember=");
		builder.append(issuerMember);
		builder.append(", issuerCode=");
		builder.append(issuerCode);
		builder.append(", acquireMember=");
		builder.append(acquireMember);
		builder.append(", acquireCode=");
		builder.append(acquireCode);
		builder.append(", service=");
		builder.append(service);
		builder.append(", subService=");
		builder.append(subService);
		builder.append("]");
		return builder.toString();
	}
    
	

}

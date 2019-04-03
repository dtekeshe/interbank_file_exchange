package com.bsva.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class CsvDefaultFilesViewPK implements Serializable{
	 private static final long serialVersionUID = 1L;
	@Size(max = 4)
    @Column(name = "SERVICE")
    private String service;
	
    @Size(max = 10)
    @Column(name = "SUB_SERVICE")
    private String subService;
    
    @Column(name = "DEST_BANK_CODE")
    private Short destBankCode;

    @Column(name = "ORIGINATING_BANK")
    private Short originatingBank;

	public CsvDefaultFilesViewPK() {
	}

	public String getService() {
		return service;
	}

	public String getSubService() {
		return subService;
	}

	public Short getDestBankCode() {
		return destBankCode;
	}

	public Short getOriginatingBank() {
		return originatingBank;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setSubService(String subService) {
		this.subService = subService;
	}

	public void setDestBankCode(Short destBankCode) {
		this.destBankCode = destBankCode;
	}

	public void setOriginatingBank(Short originatingBank) {
		this.originatingBank = originatingBank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destBankCode == null) ? 0 : destBankCode.hashCode());
		result = prime * result + ((originatingBank == null) ? 0 : originatingBank.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result + ((subService == null) ? 0 : subService.hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsvDefaultFilesViewPK [service=");
		builder.append(service);
		builder.append(", subService=");
		builder.append(subService);
		builder.append(", destBankCode=");
		builder.append(destBankCode);
		builder.append(", originatingBank=");
		builder.append(originatingBank);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CsvDefaultFilesViewPK other = (CsvDefaultFilesViewPK) obj;
		if (destBankCode == null) {
			if (other.destBankCode != null)
				return false;
		} else if (!destBankCode.equals(other.destBankCode))
			return false;
		if (originatingBank == null) {
			if (other.originatingBank != null)
				return false;
		} else if (!originatingBank.equals(other.originatingBank))
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

}

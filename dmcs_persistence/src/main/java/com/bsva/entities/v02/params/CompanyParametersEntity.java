package com.bsva.entities.v02.params;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class CompanyParametersEntity {

    @Id
    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "FULL_REPORT_NAME")
    private String fullReportName;

    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;

    @Column(name = "VALIDATION_CODE")
    private String validationCode;

    @Column(name = "VAT_PERCENT")
    private BigDecimal vatPercentage;
    
    @Column(name="CURRENCY_CODE_NUMBER")
    private Integer currencyCodeNumber;
    

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFullReportName() {
        return fullReportName;
    }

    public void setFullReportName(String fullReportName) {
        this.fullReportName = fullReportName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public BigDecimal getVatPercentage() {
        return vatPercentage;
    }

    public void setVatPercentage(BigDecimal vatPercentage) {
        this.vatPercentage = vatPercentage;
    }

	public Integer getCurrencyCodeNumber() {
		return currencyCodeNumber;
	}

	public void setCurrencyCodeNumber(Integer currencyCodeNumber) {
		this.currencyCodeNumber = currencyCodeNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((currencyCodeNumber == null) ? 0 : currencyCodeNumber.hashCode());
		result = prime * result + ((fullReportName == null) ? 0 : fullReportName.hashCode());
		result = prime * result + ((registrationNumber == null) ? 0 : registrationNumber.hashCode());
		result = prime * result + ((validationCode == null) ? 0 : validationCode.hashCode());
		result = prime * result + ((vatPercentage == null) ? 0 : vatPercentage.hashCode());
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
		CompanyParametersEntity other = (CompanyParametersEntity) obj;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		}
		else if (!companyName.equals(other.companyName))
			return false;
		if (currencyCodeNumber == null) {
			if (other.currencyCodeNumber != null)
				return false;
		}
		else if (!currencyCodeNumber.equals(other.currencyCodeNumber))
			return false;
		if (fullReportName == null) {
			if (other.fullReportName != null)
				return false;
		}
		else if (!fullReportName.equals(other.fullReportName))
			return false;
		if (registrationNumber == null) {
			if (other.registrationNumber != null)
				return false;
		}
		else if (!registrationNumber.equals(other.registrationNumber))
			return false;
		if (validationCode == null) {
			if (other.validationCode != null)
				return false;
		}
		else if (!validationCode.equals(other.validationCode))
			return false;
		if (vatPercentage == null) {
			if (other.vatPercentage != null)
				return false;
		}
		else if (!vatPercentage.equals(other.vatPercentage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompanyParametersEntity [companyName=");
		builder.append(companyName);
		builder.append(", fullReportName=");
		builder.append(fullReportName);
		builder.append(", registrationNumber=");
		builder.append(registrationNumber);
		builder.append(", validationCode=");
		builder.append(validationCode);
		builder.append(", vatPercentage=");
		builder.append(vatPercentage);
		builder.append(", currencyCodeNumber=");
		builder.append(currencyCodeNumber);
		builder.append("]");
		return builder.toString();
	}

	
}

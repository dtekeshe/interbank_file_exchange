package com.bsva.entities.v02.outputcontrols;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class OutputControlKey implements Serializable {

    @Column(name = "SERVICE")
    private String serviceID;
    @Column(name = "SUB_SERVICE")
    private String subServiceID;
    @Column(name = "ACQUIRING_BANK_CODE")
    private Integer acquiringBankCode;
    @Column(name = "ISSUING_BANK_CODE")
    private Integer issuingBankCode;

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getSubServiceID() {
        return subServiceID;
    }

    public void setSubServiceID(String subServiceID) {
        this.subServiceID = subServiceID;
    }

    public Integer getAcquiringBankCode() {
        return acquiringBankCode;
    }

    public void setAcquiringBankCode(Integer acquiringBankCode) {
        this.acquiringBankCode = acquiringBankCode;
    }

    public Integer getIssuingBankCode() {
        return issuingBankCode;
    }

    public void setIssuingBankCode(Integer issuingBankCode) {
        this.issuingBankCode = issuingBankCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OutputControlKey that = (OutputControlKey) o;

        if (serviceID != null ? !serviceID.equals(that.serviceID) : that.serviceID != null) return false;
        if (subServiceID != null ? !subServiceID.equals(that.subServiceID) : that.subServiceID != null) return false;
        if (acquiringBankCode != null ? !acquiringBankCode.equals(that.acquiringBankCode) : that.acquiringBankCode != null)
            return false;
        return !(issuingBankCode != null ? !issuingBankCode.equals(that.issuingBankCode) : that.issuingBankCode != null);

    }

    @Override
    public int hashCode() {
        int result = serviceID != null ? serviceID.hashCode() : 0;
        result = 31 * result + (subServiceID != null ? subServiceID.hashCode() : 0);
        result = 31 * result + (acquiringBankCode != null ? acquiringBankCode.hashCode() : 0);
        result = 31 * result + (issuingBankCode != null ? issuingBankCode.hashCode() : 0);
        return result;
    }
}

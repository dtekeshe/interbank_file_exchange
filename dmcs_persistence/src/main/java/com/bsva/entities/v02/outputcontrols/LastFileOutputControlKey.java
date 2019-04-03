package com.bsva.entities.v02.outputcontrols;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class LastFileOutputControlKey implements Serializable {

    @Column(name = "SERVICE")
    private String serviceID;
    @Column(name = "SUB_SERVICE")
    private String subServiceID;
    @Column(name = "DISTRIBUTION_CODE")
    private String distributionCode;
    @Column(name = "ISSUING_BANK_CODE")
    private Integer issuingBankCode;
    @Column(name = "FILENAME_PREFIX")
    private String filenamePrefix;

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

    public String getDistributionCode() {
        return distributionCode;
    }

    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }

    public Integer getIssuingBankCode() {
        return issuingBankCode;
    }

    public void setIssuingBankCode(Integer issuingBankCode) {
        this.issuingBankCode = issuingBankCode;
    }

    public String getFilenamePrefix() {
        return filenamePrefix;
    }

    public void setFilenamePrefix(String filenamePrefix) {
        this.filenamePrefix = filenamePrefix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LastFileOutputControlKey that = (LastFileOutputControlKey) o;

        if (serviceID != null ? !serviceID.equals(that.serviceID) : that.serviceID != null) return false;
        if (subServiceID != null ? !subServiceID.equals(that.subServiceID) : that.subServiceID != null) return false;
        if (distributionCode != null ? !distributionCode.equals(that.distributionCode) : that.distributionCode != null)
            return false;
        if (issuingBankCode != null ? !issuingBankCode.equals(that.issuingBankCode) : that.issuingBankCode != null)
            return false;
        return !(filenamePrefix != null ? !filenamePrefix.equals(that.filenamePrefix) : that.filenamePrefix != null);

    }

    @Override
    public int hashCode() {
        int result = serviceID != null ? serviceID.hashCode() : 0;
        result = 31 * result + (subServiceID != null ? subServiceID.hashCode() : 0);
        result = 31 * result + (distributionCode != null ? distributionCode.hashCode() : 0);
        result = 31 * result + (issuingBankCode != null ? issuingBankCode.hashCode() : 0);
        result = 31 * result + (filenamePrefix != null ? filenamePrefix.hashCode() : 0);
        return result;
    }
}

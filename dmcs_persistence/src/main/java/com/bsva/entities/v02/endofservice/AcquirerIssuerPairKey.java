package com.bsva.entities.v02.endofservice;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class AcquirerIssuerPairKey implements Serializable {

    @Column(name = "ORIGINATING_MEMBER")
    private Integer acquirerCode;
    @Column(name = "BANK_CODE")
    private Integer issuerCode;
    @Column(name = "SERVICE")
    private String serviceID;
    @Column(name = "SUB_SERVICE")
    private String subServiceID;

    public Integer getAcquirerCode() {
        return acquirerCode;
    }

    public void setAcquirerCode(Integer acquirerCode) {
        this.acquirerCode = acquirerCode;
    }

    public Integer getIssuerCode() {
        return issuerCode;
    }

    public void setIssuerCode(Integer issuerCode) {
        this.issuerCode = issuerCode;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AcquirerIssuerPairKey that = (AcquirerIssuerPairKey) o;

        if (acquirerCode != null ? !acquirerCode.equals(that.acquirerCode) : that.acquirerCode != null) return false;
        if (issuerCode != null ? !issuerCode.equals(that.issuerCode) : that.issuerCode != null) return false;
        if (serviceID != null ? !serviceID.equals(that.serviceID) : that.serviceID != null) return false;
        return !(subServiceID != null ? !subServiceID.equals(that.subServiceID) : that.subServiceID != null);

    }

    @Override
    public int hashCode() {
        int result = acquirerCode != null ? acquirerCode.hashCode() : 0;
        result = 31 * result + (issuerCode != null ? issuerCode.hashCode() : 0);
        result = 31 * result + (serviceID != null ? serviceID.hashCode() : 0);
        result = 31 * result + (subServiceID != null ? subServiceID.hashCode() : 0);
        return result;
    }
}

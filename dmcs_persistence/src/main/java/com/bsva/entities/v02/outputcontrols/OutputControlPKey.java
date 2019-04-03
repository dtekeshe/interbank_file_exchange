package com.bsva.entities.v02.outputcontrols;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class OutputControlPKey implements Serializable {

    @Column(name = "ACQUIRING_BANK_CODE")
    private Integer acquiringBankCode;
    @Column(name = "ISSUING_BANK_CODE")
    private Integer issuingBankCode;
    @Column(name = "SERVICE")
    private String serviceID;
    @Column(name = "SUB_SERVICE")
    private String subServiceID;
    @Column( name = "SEQ_NUMBER")
    private String seqNumber;

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

    public String getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(String seqNumber) {
        this.seqNumber = seqNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OutputControlPKey that = (OutputControlPKey) o;

        if (acquiringBankCode != null ? !acquiringBankCode.equals(that.acquiringBankCode) : that.acquiringBankCode != null)
            return false;
        if (issuingBankCode != null ? !issuingBankCode.equals(that.issuingBankCode) : that.issuingBankCode != null)
            return false;
        if (serviceID != null ? !serviceID.equals(that.serviceID) : that.serviceID != null) return false;
        if (subServiceID != null ? !subServiceID.equals(that.subServiceID) : that.subServiceID != null) return false;
        return !(seqNumber != null ? !seqNumber.equals(that.seqNumber) : that.seqNumber != null);

    }

    @Override
    public int hashCode() {
        int result = acquiringBankCode != null ? acquiringBankCode.hashCode() : 0;
        result = 31 * result + (issuingBankCode != null ? issuingBankCode.hashCode() : 0);
        result = 31 * result + (serviceID != null ? serviceID.hashCode() : 0);
        result = 31 * result + (subServiceID != null ? subServiceID.hashCode() : 0);
        result = 31 * result + (seqNumber != null ? seqNumber.hashCode() : 0);
        return result;
    }
}

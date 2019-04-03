package com.bsva.entities.v02.extract;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class OutputFilePK implements Serializable {

    @Column(name = "ORIGIN_BANK_CODE")
    private Integer originBankCode;
    @Column(name = "DEST_BANK_CODE")
    private Integer destBankCode;
    @Column(name = "SERVICE_ID")
    private String serviceID;
    @Column(name = "SUB_SERVICE_ID")
    private String subServiceID;
    @Column(name = "SEQ_NUMBER")
    private String seqNumber;

    public Integer getOriginBankCode() {
        return originBankCode;
    }

    public void setOriginBankCode(Integer originBankCode) {
        this.originBankCode = originBankCode;
    }

    public Integer getDestBankCode() {
        return destBankCode;
    }

    public void setDestBankCode(Integer destBankCode) {
        this.destBankCode = destBankCode;
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

        OutputFilePK that = (OutputFilePK) o;

        if (originBankCode != null ? !originBankCode.equals(that.originBankCode) : that.originBankCode != null)
            return false;
        if (destBankCode != null ? !destBankCode.equals(that.destBankCode) : that.destBankCode != null) return false;
        if (serviceID != null ? !serviceID.equals(that.serviceID) : that.serviceID != null) return false;
        if (subServiceID != null ? !subServiceID.equals(that.subServiceID) : that.subServiceID != null) return false;
        return !(seqNumber != null ? !seqNumber.equals(that.seqNumber) : that.seqNumber != null);

    }

    @Override
    public int hashCode() {
        int result = originBankCode != null ? originBankCode.hashCode() : 0;
        result = 31 * result + (destBankCode != null ? destBankCode.hashCode() : 0);
        result = 31 * result + (serviceID != null ? serviceID.hashCode() : 0);
        result = 31 * result + (subServiceID != null ? subServiceID.hashCode() : 0);
        result = 31 * result + (seqNumber != null ? seqNumber.hashCode() : 0);
        return result;
    }
}

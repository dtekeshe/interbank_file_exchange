package com.bsva.entities.v02.settlement.extract;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO Document
 */
@Embeddable
public class SettlementDataKey implements Serializable {

    @Column(name = "SERVICE_ID")
    private String serviceID;
    @Column(name = "SUB_SERVICE_ID")
    private String subServiceID;
    @Column(name = "ORIGINATING_BANK")
    private Integer originatingBankCode;
    @Column(name = "HOMING_BANK")
    private Integer homingBankCode;
    @Column(name = "PROCESS_DATE")
    private Date processDate;

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

    public Integer getOriginatingBankCode() {
        return originatingBankCode;
    }

    public void setOriginatingBankCode(Integer originatingBankCode) {
        this.originatingBankCode = originatingBankCode;
    }

    public Integer getHomingBankCode() {
        return homingBankCode;
    }

    public void setHomingBankCode(Integer homingBankCode) {
        this.homingBankCode = homingBankCode;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SettlementDataKey that = (SettlementDataKey) o;

        if (serviceID != null ? !serviceID.equals(that.serviceID) : that.serviceID != null) return false;
        if (subServiceID != null ? !subServiceID.equals(that.subServiceID) : that.subServiceID != null) return false;
        if (originatingBankCode != null ?
                !originatingBankCode.equals(that.originatingBankCode) : that.originatingBankCode != null)
            return false;
        if (homingBankCode != null ? !homingBankCode.equals(that.homingBankCode) : that.homingBankCode != null)
            return false;
        return !(processDate != null ? !processDate.equals(that.processDate) : that.processDate != null);

    }

    @Override
    public int hashCode() {
        int result = serviceID != null ? serviceID.hashCode() : 0;
        result = 31 * result + (subServiceID != null ? subServiceID.hashCode() : 0);
        result = 31 * result + (originatingBankCode != null ? originatingBankCode.hashCode() : 0);
        result = 31 * result + (homingBankCode != null ? homingBankCode.hashCode() : 0);
        result = 31 * result + (processDate != null ? processDate.hashCode() : 0);
        return result;
    }
}

package com.bsva.entities.v02.settlement;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class AcquirerKey implements Serializable {

    @Column(name = "SUB_SERVICE")
    private String subService;
    @Column(name = "ACQUIRER_CODE")
    private Integer acquirerCode;

    public String getSubService() {
        return subService;
    }

    public void setSubService(String subService) {
        this.subService = subService;
    }

    public Integer getAcquirerCode() {
        return acquirerCode;
    }

    public void setAcquirerCode(Integer acquirerCode) {
        this.acquirerCode = acquirerCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AcquirerKey that = (AcquirerKey) o;

        if (subService != null ? !subService.equals(that.subService) : that.subService != null) return false;
        return !(acquirerCode != null ? !acquirerCode.equals(that.acquirerCode) : that.acquirerCode != null);

    }

    @Override
    public int hashCode() {
        int result = subService != null ? subService.hashCode() : 0;
        result = 31 * result + (acquirerCode != null ? acquirerCode.hashCode() : 0);
        return result;
    }
}

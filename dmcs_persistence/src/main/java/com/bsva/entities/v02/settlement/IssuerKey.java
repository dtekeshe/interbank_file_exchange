package com.bsva.entities.v02.settlement;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class IssuerKey implements Serializable {

    @Column(name = "SUB_SERVICE")
    private String subServiceID;
    @Column(name = "ISSUER_CODE")
    private Integer issuerCode;

    public String getSubServiceID() {
        return subServiceID;
    }

    public void setSubServiceID(String subServiceID) {
        this.subServiceID = subServiceID;
    }

    public Integer getIssuerCode() {
        return issuerCode;
    }

    public void setIssuerCode(Integer issuerCode) {
        this.issuerCode = issuerCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IssuerKey issuerKey = (IssuerKey) o;

        if (subServiceID != null
                ? !subServiceID.equals(issuerKey.subServiceID) : issuerKey.subServiceID != null)
            return false;
        return !(issuerCode != null
                ? !issuerCode.equals(issuerKey.issuerCode) : issuerKey.issuerCode != null);

    }

    @Override
    public int hashCode() {
        int result = subServiceID != null ? subServiceID.hashCode() : 0;
        result = 31 * result + (issuerCode != null ? issuerCode.hashCode() : 0);
        return result;
    }
}

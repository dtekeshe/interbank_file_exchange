package com.bsva.entities.v02.loader;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class LastSeqNumberKey implements Serializable {

    @Column(name = "EXTERNAL_FILENAME_PREFIX")
    private String externalFilenamePrefix;
    @Column(name = "DISTRIBUTION_CODE")
    private String distributionCode;

    public String getExternalFilenamePrefix() {
        return externalFilenamePrefix;
    }

    public void setExternalFilenamePrefix(String externalFilenamePrefix) {
        this.externalFilenamePrefix = externalFilenamePrefix;
    }

    public String getDistributionCode() {
        return distributionCode;
    }

    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LastSeqNumberKey that = (LastSeqNumberKey) o;

        if (externalFilenamePrefix != null
                ? !externalFilenamePrefix.equals(that.externalFilenamePrefix) : that.externalFilenamePrefix != null)
            return false;
        return !(distributionCode != null
                ? !distributionCode.equals(that.distributionCode) : that.distributionCode != null);

    }

    @Override
    public int hashCode() {
        int result = externalFilenamePrefix != null ? externalFilenamePrefix.hashCode() : 0;
        result = 31 * result + (distributionCode != null ? distributionCode.hashCode() : 0);
        return result;
    }
}

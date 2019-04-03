package com.bsva.dto;

import com.bsva.entities.v02.outputcontrols.OutputControlEntity;

/**
 * Pairing necessary for filename generation.
 * Could be used for other use cases in future.
 *
 */
public class OriginDestinationPair {

    private final Integer originBankCode;
    private final Integer destinationBankCode;
    private final String distributionCode;
    private final String serviceID;
    private final String subServiceID;
    private final String filenamePrefix;

    public OriginDestinationPair(Integer originBankCode,
                                 Integer destinationBankCode,
                                 String distributionCode,
                                 String serviceID,
                                 String subServiceID,
                                 String filenamePrefix) {
        this.originBankCode = originBankCode;
        this.destinationBankCode = destinationBankCode;
        this.distributionCode = distributionCode;
        this.serviceID = serviceID;
        this.subServiceID = subServiceID;
        this.filenamePrefix = filenamePrefix;
    }

    public Integer getOriginBankCode() {
        return originBankCode;
    }

    public Integer getDestinationBankCode() {
        return destinationBankCode;
    }

    public String getDistributionCode() {
        return distributionCode;
    }

    public String getServiceID() {
        return serviceID;
    }

    public String getSubServiceID() {
        return subServiceID;
    }

    public String getFilenamePrefix() {
        return filenamePrefix;
    }

    public static OriginDestinationPair instance(OutputControlEntity input) {

        return new OriginDestinationPair( input.getId().getAcquiringBankCode(),
                                        input.getId().getIssuingBankCode(),
                                        input.getDistributionCode(),
                                        input.getId().getServiceID(),
                                        input.getId().getSubServiceID(),
                                        input.getFilenamePrefix());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OriginDestinationPair that = (OriginDestinationPair) o;

        if (originBankCode != null ? !originBankCode.equals(that.originBankCode) : that.originBankCode != null)
            return false;
        if (destinationBankCode != null ? !destinationBankCode.equals(that.destinationBankCode) : that.destinationBankCode != null)
            return false;
        if (distributionCode != null ? !distributionCode.equals(that.distributionCode) : that.distributionCode != null)
            return false;
        if (serviceID != null ? !serviceID.equals(that.serviceID) : that.serviceID != null) return false;
        return !(subServiceID != null ? !subServiceID.equals(that.subServiceID) : that.subServiceID != null);

    }

    @Override
    public int hashCode() {
        int result = originBankCode != null ? originBankCode.hashCode() : 0;
        result = 31 * result + (destinationBankCode != null ? destinationBankCode.hashCode() : 0);
        result = 31 * result + (distributionCode != null ? distributionCode.hashCode() : 0);
        result = 31 * result + (serviceID != null ? serviceID.hashCode() : 0);
        result = 31 * result + (subServiceID != null ? subServiceID.hashCode() : 0);
        return result;
    }
}

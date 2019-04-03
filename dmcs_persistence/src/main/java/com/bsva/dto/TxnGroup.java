package com.bsva.dto;

/**
 * TODO Document
 */
public class TxnGroup {

    private final String serviceID;
    private final String subServiceID;
    private final Integer issuerBankCode;
    private final Integer acquirerBankCode;
    private final Integer txnGroupCode;

    public TxnGroup(String serviceID,
                    String subServiceID,
                    Integer issuerBankCode,
                    Integer acquirerBankCode,
                    Integer txnGroupCode) {
        this.serviceID = serviceID;
        this.subServiceID = subServiceID;
        this.issuerBankCode = issuerBankCode;
        this.acquirerBankCode = acquirerBankCode;
        this.txnGroupCode = txnGroupCode;
    }

    public String getServiceID() {
        return serviceID;
    }

    public String getSubServiceID() {
        return subServiceID;
    }

    public Integer getIssuerBankCode() {
        return issuerBankCode;
    }

    public Integer getAcquirerBankCode() {
        return acquirerBankCode;
    }

    public Integer getTxnGroupCode() {
        return txnGroupCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TxnGroup that = (TxnGroup) o;

        if (serviceID != null ? !serviceID.equals(that.serviceID) : that.serviceID != null) return false;
        if (subServiceID != null ? !subServiceID.equals(that.subServiceID) : that.subServiceID != null) return false;
        if (issuerBankCode != null ? !issuerBankCode.equals(that.issuerBankCode) : that.issuerBankCode != null)
            return false;
        if (acquirerBankCode != null ? !acquirerBankCode.equals(that.acquirerBankCode) : that.acquirerBankCode != null)
            return false;
        return !(txnGroupCode != null ? !txnGroupCode.equals(that.txnGroupCode) : that.txnGroupCode != null);

    }

    @Override
    public int hashCode() {
        int result = serviceID != null ? serviceID.hashCode() : 0;
        result = 31 * result + (subServiceID != null ? subServiceID.hashCode() : 0);
        result = 31 * result + (issuerBankCode != null ? issuerBankCode.hashCode() : 0);
        result = 31 * result + (acquirerBankCode != null ? acquirerBankCode.hashCode() : 0);
        result = 31 * result + (txnGroupCode != null ? txnGroupCode.hashCode() : 0);
        return result;
    }
}

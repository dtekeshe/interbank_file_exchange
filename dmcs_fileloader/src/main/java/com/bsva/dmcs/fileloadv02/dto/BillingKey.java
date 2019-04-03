package com.bsva.dmcs.fileloadv02.dto;

/**
 * TODO Document
 */
public class BillingKey {

    private final Integer issuerBankCode;
    private final Integer acquirerBankCode;
    private Integer transactionCode;
    private final Integer cardType;

    public BillingKey(Integer issuerBankCode,
                      Integer acquirerBankCode,
                      Integer transactionCode,
                      Integer cardType) {

        this.issuerBankCode = issuerBankCode;
        this.acquirerBankCode = acquirerBankCode;
        this.transactionCode = transactionCode;
        this.cardType = cardType;
    }

    public Integer getIssuerBankCode() {
        return issuerBankCode;
    }

    public Integer getAcquirerBankCode() {
        return acquirerBankCode;
    }

    public Integer getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(Integer transactionCode) {
        this.transactionCode = transactionCode;
    }

    public Integer getCardType() {
        return cardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillingKey that = (BillingKey) o;

        if (issuerBankCode != null ? !issuerBankCode.equals(that.issuerBankCode) : that.issuerBankCode != null)
            return false;
        if (acquirerBankCode != null ? !acquirerBankCode.equals(that.acquirerBankCode) : that.acquirerBankCode != null)
            return false;
        if (transactionCode != null ? !transactionCode.equals(that.transactionCode) : that.transactionCode != null)
            return false;
        return !(cardType != null ? !cardType.equals(that.cardType) : that.cardType != null);

    }

    @Override
    public int hashCode() {
        int result = issuerBankCode != null ? issuerBankCode.hashCode() : 0;
        result = 31 * result + (acquirerBankCode != null ? acquirerBankCode.hashCode() : 0);
        result = 31 * result + (transactionCode != null ? transactionCode.hashCode() : 0);
        result = 31 * result + (cardType != null ? cardType.hashCode() : 0);
        return result;
    }

    public static BillingKey parse( String issuingBankCode,
                                    String acquiringBankCode,
                                    String transactionCode,
                                    Short cardType) {
        return new BillingKey(
                    Integer.parseInt(issuingBankCode),
                    Integer.parseInt(acquiringBankCode),
                    Integer.parseInt(transactionCode),
                    Integer.parseInt("" + cardType));
    }
}

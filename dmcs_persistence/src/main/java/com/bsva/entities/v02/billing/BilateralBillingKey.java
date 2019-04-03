package com.bsva.entities.v02.billing;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class BilateralBillingKey implements Serializable {

    @Column(name = "ISSUING_MEMBER")
    private Integer issuerBankCode;

    @Column(name = "ACQUIRING_MEMBER")
    private Integer acquirerBankCode;

    @Column(name = "TRANSACTION_CODE")
    private Integer transactionCode;

    @Column(name = "CARD_TYPE")
    private Integer cardType;

    public BilateralBillingKey() {
    }

    public BilateralBillingKey(Integer issuerBankCode,
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

    public void setIssuerBankCode(Integer issuerBankCode) {
        this.issuerBankCode = issuerBankCode;
    }

    public Integer getAcquirerBankCode() {
        return acquirerBankCode;
    }

    public void setAcquirerBankCode(Integer acquirerBankCode) {
        this.acquirerBankCode = acquirerBankCode;
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

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BilateralBillingKey that = (BilateralBillingKey) o;

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

    public static BilateralBillingKey parse( String issuingBankCode,
                                    String acquiringBankCode,
                                    String transactionCode,
                                    Short cardType) {
        return new BilateralBillingKey(
                    Integer.parseInt(issuingBankCode),
                    Integer.parseInt(acquiringBankCode),
                    Integer.parseInt(transactionCode),
                    Integer.parseInt("" + cardType));
    }
}

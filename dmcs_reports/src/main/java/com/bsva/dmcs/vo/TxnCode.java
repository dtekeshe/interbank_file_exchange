package com.bsva.dmcs.vo;

/**
 * TODO Document
 */
public class TxnCode {

    private final Integer txnCode;

    public TxnCode(Integer txnCode) {
        this.txnCode = txnCode;
    }

    public Integer getTxnCode() {
        return txnCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TxnCode txnCode1 = (TxnCode) o;

        return !(txnCode != null ? !txnCode.equals(txnCode1.txnCode) : txnCode1.txnCode != null);

    }

    @Override
    public int hashCode() {
        return txnCode != null ? txnCode.hashCode() : 0;
    }
}

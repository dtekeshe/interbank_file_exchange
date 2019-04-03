package com.bsva.dmcs.dto;

import com.bsva.dto.TxnGroup;

/**
 * TODO Document
 */
public class TxnGroupTotals {

    private final TxnGroup txnGroupCode;
    private final Long count;
    private final Double amount;
    private final Double interchange;
    private final Double vat;
    private final Double totalCharges;
    private final Double nettAmount;

    public TxnGroupTotals(TxnGroup txnGroupCode,
                          Long count,
                          Double amount,
                          Double interchange,
                          Double vat,
                          Double totalCharges,
                          Double nettAmount) {

        this.txnGroupCode = txnGroupCode;
        this.count = count;
        this.amount = amount;
        this.interchange = interchange;
        this.vat = vat;
        this.totalCharges = totalCharges;
        this.nettAmount = nettAmount;
    }

    public TxnGroup getTxnGroupCode() {
        return txnGroupCode;
    }

    public Long getCount() {
        return count;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getInterchange() {
        return interchange;
    }

    public Double getVat() {
        return vat;
    }

    public Double getTotalCharges() {
        return totalCharges;
    }

    public Double getNettAmount() {
        return nettAmount;
    }
}

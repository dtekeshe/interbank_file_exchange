package com.bsva.entities.v02.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
public class TxnGroupCodeEntity implements Serializable {

    @Id
    @Column(name = "TRANSACTION_CODE")
    private Integer txnCode;

    @Column(name = "TRANSACTION_GROUP_CODE")
    private Integer txnGroupCode;

    public Integer getTxnCode() {
        return txnCode;
    }

    public void setTxnCode(Integer txnCode) {
        this.txnCode = txnCode;
    }

    public Integer getTxnGroupCode() {
        return txnGroupCode;
    }

    public void setTxnGroupCode(Integer txnGroupCode) {
        this.txnGroupCode = txnGroupCode;
    }
}

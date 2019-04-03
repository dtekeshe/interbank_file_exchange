package com.bsva.entities.v02.loader;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class TxnCodeMappingEntity implements Serializable {

    @Id
    @Column(name = "TXN_CODE")
    private String txnCode;
    @Column(name = "STANDARD_TXN_CODE")
    private Integer standardTxnCode;

    public String getTxnCode() {
        return txnCode;
    }

    public void setTxnCode(String txnCode) {
        this.txnCode = txnCode;
    }

    public Integer getStandardTxnCode() {
        return standardTxnCode;
    }

    public void setStandardTxnCode(Integer standardTxnCode) {
        this.standardTxnCode = standardTxnCode;
    }
}

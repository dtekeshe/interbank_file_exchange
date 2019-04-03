package com.bsva.entities.v02.billing;

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
public class CashbackAcceptorEntity implements Serializable {

    @Id
    @Column(name = "CB_MCC")
    private Integer cbMcc;

    public Integer getCbMcc() {
        return cbMcc;
    }

    public void setCbMcc(Integer cbMcc) {
        this.cbMcc = cbMcc;
    }
}

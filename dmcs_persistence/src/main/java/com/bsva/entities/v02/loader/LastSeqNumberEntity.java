package com.bsva.entities.v02.loader;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class LastSeqNumberEntity {

    @EmbeddedId
    private LastSeqNumberKey id;

    @Column(name = "LAST_SEQ_NUMBER_USED")
    private Long lastSeqNumber;

    public LastSeqNumberKey getId() {
        return id;
    }

    public void setId(LastSeqNumberKey id) {
        this.id = id;
    }

    public Long getLastSeqNumber() {
        return lastSeqNumber;
    }

    public void setLastSeqNumber(Long lastSeqNumber) {
        this.lastSeqNumber = lastSeqNumber;
    }
}

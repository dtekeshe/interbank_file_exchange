package com.bsva.entities.v02.outputcontrols;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class LastFileOutputControlEntity implements Cloneable {

    @EmbeddedId
    private LastFileOutputControlKey id;

    @Column( name = "SEQ_NUMBER")
    private String seqNumber;

    public LastFileOutputControlKey getId() {
        return id;
    }

    public void setId(LastFileOutputControlKey id) {
        this.id = id;
    }

    public String getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(String seqNumber) {
        this.seqNumber = seqNumber;
    }
}

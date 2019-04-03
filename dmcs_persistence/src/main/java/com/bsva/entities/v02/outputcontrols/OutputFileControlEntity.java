package com.bsva.entities.v02.outputcontrols;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class OutputFileControlEntity implements Serializable {

    @EmbeddedId
    private OutputControlKey id;

    public OutputControlKey getId() {
        return id;
    }

    public void setId(OutputControlKey id) {
        this.id = id;
    }
}

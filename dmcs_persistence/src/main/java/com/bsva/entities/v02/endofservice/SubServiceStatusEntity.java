package com.bsva.entities.v02.endofservice;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
public class SubServiceStatusEntity implements Serializable {

    @EmbeddedId
    private SubServiceStatusKey id;
    @Column(name = "ACTIVE_INDICATOR")
    private String statusCode;

    public SubServiceStatusKey getId() {
        return id;
    }

    public void setId(SubServiceStatusKey id) {
        this.id = id;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}

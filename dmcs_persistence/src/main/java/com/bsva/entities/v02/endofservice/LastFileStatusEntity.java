package com.bsva.entities.v02.endofservice;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
public class LastFileStatusEntity implements Serializable {

    @EmbeddedId
    private AcquirerIssuerPairKey id;
    @Column(name = "FULLFILEIND")
    private String fileStatus;

    public AcquirerIssuerPairKey getId() {
        return id;
    }

    public void setId(AcquirerIssuerPairKey id) {
        this.id = id;
    }

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }
}

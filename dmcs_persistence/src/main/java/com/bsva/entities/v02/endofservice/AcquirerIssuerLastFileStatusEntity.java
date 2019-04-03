package com.bsva.entities.v02.endofservice;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class AcquirerIssuerLastFileStatusEntity implements Serializable {

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

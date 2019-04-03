package com.bsva.entities.v02.loader;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class PendingFileCountEntity {

    @Id
    @Column(name = "SUB_SERVICE")
    private String subServiceID;

    @Column(name = "UN_EXTRACTED_FILE_COUNT")
    private Integer unExtractFileCount;

    public String getSubServiceID() {
        return subServiceID;
    }

    public void setSubServiceID(String subServiceID) {
        this.subServiceID = subServiceID;
    }

    public Integer getUnExtractFileCount() {
        return unExtractFileCount;
    }

    public void setUnExtractFileCount(Integer unExtractFileCount) {
        this.unExtractFileCount = unExtractFileCount;
    }
}

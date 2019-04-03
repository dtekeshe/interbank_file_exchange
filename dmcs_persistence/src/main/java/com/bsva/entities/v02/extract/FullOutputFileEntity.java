package com.bsva.entities.v02.extract;

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
public class FullOutputFileEntity implements Serializable {

    @Id
    @Column(name = "FILENAME")
    private String filename;
    @Column(name = "FILENAME_PREFIX")
    private String filenamePrefix;
    @Column(name = "SUB_SERVICE_ID")
    private String subServiceID;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilenamePrefix() {
        return filenamePrefix;
    }

    public void setFilenamePrefix(String filenamePrefix) {
        this.filenamePrefix = filenamePrefix;
    }

    public String getSubServiceID() {
        return subServiceID;
    }

    public void setSubServiceID(String subServiceID) {
        this.subServiceID = subServiceID;
    }
}

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
public class FilenamePrefixEntity implements Serializable {

    @Id
    @Column(name = "SUB_SERVICE")
    private String subService;
    @Column(name = "FILENAME_PREFIX")
    private String filenamePrefix;

    public String getSubService() {
        return subService;
    }

    public void setSubService(String subService) {
        this.subService = subService;
    }

    public String getFilenamePrefix() {
        return filenamePrefix;
    }

    public void setFilenamePrefix(String filenamePrefix) {
        this.filenamePrefix = filenamePrefix;
    }
}

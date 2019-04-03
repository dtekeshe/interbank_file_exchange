package com.bsva.entities.v02.extract;

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
public class OutputControlsEntity implements Serializable {

    @EmbeddedId
    private OutputFilePK id;

    @Column(name = "FILENAME")
    private String filename;
    @Column(name = "FILENAME_PREFIX")
    private String filenamePrefix;
    @Column(name = "LAST_FILE_INDICATOR")
    private String lastFileIndicator;
    @Column(name = "RECORD_COUNT")
    private Long recordCount;
    @Column(name = "DISTRIBUTION_CODE")
    private String distributionCode;

    public OutputFilePK getId() {
        return id;
    }

    public void setId(OutputFilePK id) {
        this.id = id;
    }

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

    public String getLastFileIndicator() {
        return lastFileIndicator;
    }

    public void setLastFileIndicator(String lastFileIndicator) {
        this.lastFileIndicator = lastFileIndicator;
    }

    public Long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Long recordCount) {
        this.recordCount = recordCount;
    }

    public String getDistributionCode() {
        return distributionCode;
    }

    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }

    public boolean isLastFile() {
        return "Y".equalsIgnoreCase(lastFileIndicator);
    }
}

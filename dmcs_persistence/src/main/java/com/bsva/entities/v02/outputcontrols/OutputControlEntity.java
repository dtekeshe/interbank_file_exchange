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
public class OutputControlEntity implements Cloneable {

    @EmbeddedId
    private OutputControlKey id;

    @Column(name = "DISTRIBUTION_CODE")
    private String distributionCode;
    @Column(name = "FILENAME_DESCRIPTION")
    private String filenameDescription;
    @Column(name = "FILENAME_PREFIX")
    private String filenamePrefix;
    @Column( name = "SEQ_NUMBER")
    private String seqNumber;
    @Column(name = "RECORD_COUNT")
    private Long recordCount;
    @Column(name = "FULLFILEIND")
    private String fullFileIndicator;
    @Column(name = "CR_VOLUME")
    private Long outputFileCrVolume;
    @Column(name = "CR_VALUE")
    private Double outputFileCrValue;
    @Column(name = "DR_VOLUME")
    private Long outputFileDrVolume;
    @Column(name = "DR_VALUE")
    private Double outputFileDrValue;

    @Transient
    private String actionRequired;

    public OutputControlKey getId() {
        return id;
    }

    public void setId(OutputControlKey id) {
        this.id = id;
    }

    public String getDistributionCode() {
        return distributionCode;
    }

    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }

    public String getFilenameDescription() {
        return filenameDescription;
    }

    public void setFilenameDescription(String filenameDescription) {
        this.filenameDescription = filenameDescription;
    }

    public String getFilenamePrefix() {
        return filenamePrefix;
    }

    public void setFilenamePrefix(String filenamePrefix) {
        this.filenamePrefix = filenamePrefix;
    }

    public String getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(String seqNumber) {
        this.seqNumber = seqNumber;
    }

    public Long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Long recordCount) {
        this.recordCount = recordCount;
    }

    public String getFullFileIndicator() {
        return fullFileIndicator;
    }

    public void setFullFileIndicator(String fullFileIndicator) {
        this.fullFileIndicator = fullFileIndicator;
    }

    public OutputControlEntity clone() {
        try {
            return (OutputControlEntity)super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getActionRequired() {
        return actionRequired;
    }

    public void setActionRequired(String actionRequired) {
        this.actionRequired = actionRequired;
    }

    public Long getOutputFileCrVolume() {
        return outputFileCrVolume;
    }

    public void setOutputFileCrVolume(Long outputFileCrVolume) {
        this.outputFileCrVolume = outputFileCrVolume;
    }

    public Double getOutputFileCrValue() {
        return outputFileCrValue;
    }

    public void setOutputFileCrValue(Double outputFileCrValue) {
        this.outputFileCrValue = outputFileCrValue;
    }

    public Long getOutputFileDrVolume() {
        return outputFileDrVolume;
    }

    public void setOutputFileDrVolume(Long outputFileDrVolume) {
        this.outputFileDrVolume = outputFileDrVolume;
    }

    public Double getOutputFileDrValue() {
        return outputFileDrValue;
    }

    public void setOutputFileDrValue(Double outputFileDrValue) {
        this.outputFileDrValue = outputFileDrValue;
    }
}

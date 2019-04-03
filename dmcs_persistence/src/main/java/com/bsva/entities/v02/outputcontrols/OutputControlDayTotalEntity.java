package com.bsva.entities.v02.outputcontrols;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class OutputControlDayTotalEntity implements Serializable {

    @EmbeddedId
    private LastFileOutputControlKey id;

    @Column(name = "FILE_COUNT")
    private Integer fileCount;
    @Column(name = "CR_VOLUME")
    private Long crVolume;
    @Column(name = "CR_VALUE")
    private Double crValue;
    @Column(name = "DR_VOLUME")
    private Long drVolume;
    @Column(name = "DR_VALUE")
    private Double drValue;

    // calculate field
    @Transient
    private String seqNumber;

    public LastFileOutputControlKey getId() {
        return id;
    }

    public void setId(LastFileOutputControlKey id) {
        this.id = id;
    }

    public Integer getFileCount() {
        return fileCount;
    }

    public void setFileCount(Integer fileCount) {
        this.fileCount = fileCount;
    }

    public Long getCrVolume() {
        return crVolume;
    }

    public void setCrVolume(Long crVolume) {
        this.crVolume = crVolume;
    }

    public Double getCrValue() {
        return crValue;
    }

    public void setCrValue(Double crValue) {
        this.crValue = crValue;
    }

    public Long getDrVolume() {
        return drVolume;
    }

    public void setDrVolume(Long drVolume) {
        this.drVolume = drVolume;
    }

    public Double getDrValue() {
        return drValue;
    }

    public void setDrValue(Double drValue) {
        this.drValue = drValue;
    }

    public String getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(String seqNumber) {
        this.seqNumber = seqNumber;
    }
}

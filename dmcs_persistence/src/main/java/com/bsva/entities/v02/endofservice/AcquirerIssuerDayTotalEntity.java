package com.bsva.entities.v02.endofservice;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class AcquirerIssuerDayTotalEntity {

    @EmbeddedId
    private AcquirerIssuerPairKey id;
    @Column(name = "RECORD_COUNT_FOR_DAY")
    private Long RecordCountForDay;
    @Column(name = "DR_VALUE_FOR_DAY")
    private double DrValueForDay;

    public AcquirerIssuerPairKey getId() {
        return id;
    }

    public void setId(AcquirerIssuerPairKey id) {
        this.id = id;
    }

    public Long getRecordCountForDay() {
        return RecordCountForDay;
    }

    public void setRecordCountForDay(Long recordCountForDay) {
        RecordCountForDay = recordCountForDay;
    }

    public double getDrValueForDay() {
        return DrValueForDay;
    }

    public void setDrValueForDay(double drValueForDay) {
        DrValueForDay = drValueForDay;
    }
}

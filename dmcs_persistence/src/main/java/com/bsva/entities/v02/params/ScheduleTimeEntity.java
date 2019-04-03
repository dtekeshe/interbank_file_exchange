package com.bsva.entities.v02.params;

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
public class ScheduleTimeEntity implements Serializable {

    @Id
    @Column(name = "SUB_SERVICE")
    private String subServiceID;
    @Column(name = "START_TIME")
    private String startTimeString;
    @Column(name = "END_TIME")
    private String endTimeString;
    @Column(name = "ACTIVE_IND")
    private String activeIndicatorString;

    public String getSubServiceID() {
        return subServiceID;
    }

    public void setSubServiceID(String subServiceID) {
        this.subServiceID = subServiceID;
    }

    public String getStartTimeString() {
        return startTimeString;
    }

    public void setStartTimeString(String startTimeString) {
        this.startTimeString = startTimeString;
    }

    public String getEndTimeString() {
        return endTimeString;
    }

    public void setEndTimeString(String endTimeString) {
        this.endTimeString = endTimeString;
    }

    public String getActiveIndicatorString() {
        return activeIndicatorString;
    }

    public void setActiveIndicatorString(String activeIndicatorString) {
        this.activeIndicatorString = activeIndicatorString;
    }
}

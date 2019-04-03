/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;


/**
 * @author AugustineA
 *
 */
@Entity
@Table(name = "CSO_SCHEDULE_TIMES")
@NamedQueries({
    @NamedQuery(name = "CsfScheduleTimes.findAll", query = "SELECT c FROM CsfScheduleTimes c"),
    @NamedQuery(name = "CsfScheduleTimes.findByProcess", query = "SELECT c FROM CsfScheduleTimes c WHERE c.csfScheduleTimesPK.process = :process"),
    @NamedQuery(name = "CsfScheduleTimes.findByService", query = "SELECT c FROM CsfScheduleTimes c WHERE c.csfScheduleTimesPK.service = :service"),
    @NamedQuery(name = "CsfScheduleTimes.findBySubService", query = "SELECT c FROM CsfScheduleTimes c WHERE c.csfScheduleTimesPK.subService = :subService"),
    @NamedQuery(name = "CsfScheduleTimes.findByActiveInd", query = "SELECT c FROM CsfScheduleTimes c WHERE c.activeInd = :activeInd"),
    @NamedQuery(name = "CsfScheduleTimes.findByBusyInd", query = "SELECT c FROM CsfScheduleTimes c WHERE c.busyInd = :busyInd"),
    @NamedQuery(name = "CsfScheduleTimes.findByCheckPoint", query = "SELECT c FROM CsfScheduleTimes c WHERE c.checkPoint = :checkPoint"),
    @NamedQuery(name = "CsfScheduleTimes.findByCheckpointname", query = "SELECT c FROM CsfScheduleTimes c WHERE c.checkpointname = :checkpointname"),
    @NamedQuery(name = "CsfScheduleTimes.findByEndTime", query = "SELECT c FROM CsfScheduleTimes c WHERE c.endTime = :endTime"),
    @NamedQuery(name = "CsfScheduleTimes.findByLastRunTime", query = "SELECT c FROM CsfScheduleTimes c WHERE c.lastRunTime = :lastRunTime"),
    @NamedQuery(name = "CsfScheduleTimes.findByStartTime", query = "SELECT c FROM CsfScheduleTimes c WHERE c.startTime = :startTime"),
    @NamedQuery(name = "CsfScheduleTimes.findByProcessDate", query = "SELECT c FROM CsfScheduleTimes c WHERE c.processDate = :processDate")})
@DynamicUpdate
public class CsfScheduleTimes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsfScheduleTimesPK csfScheduleTimesPK;
    @Column(name = "ACTIVE_IND")
    private String activeInd;
    @Column(name = "BUSY_IND")
    private String busyInd;
    @Column(name = "CHECK_POINT")
    private String checkPoint;
    @Column(name = "CHECK_POINT_NAME")
    private String checkpointname;
    @Column(name = "END_TIME")
    private String endTime;
    @Column(name = "LAST_RUN_TIME")
    private String lastRunTime;
    @Column(name = "START_TIME")
    private String startTime;
    @Column(name = "PROCESS_DATE")
    private String processDate;

    public CsfScheduleTimes() {
    }

    public CsfScheduleTimes(CsfScheduleTimesPK csfScheduleTimesPK) {
        this.csfScheduleTimesPK = csfScheduleTimesPK;
    }

    public CsfScheduleTimes(CsfScheduleTimesPK csfScheduleTimesPK, String activeInd, String busyInd, String checkPoint) {
        this.csfScheduleTimesPK = csfScheduleTimesPK;
        this.activeInd = activeInd;
        this.busyInd = busyInd;
        this.checkPoint = checkPoint;
    }

    public CsfScheduleTimes(String process, String service, String subService) {
        this.csfScheduleTimesPK = new CsfScheduleTimesPK(process, service, subService);
    }

    public CsfScheduleTimesPK getCsfScheduleTimesPK() {
        return csfScheduleTimesPK;
    }

    public void setCsfScheduleTimesPK(CsfScheduleTimesPK csfScheduleTimesPK) {
        this.csfScheduleTimesPK = csfScheduleTimesPK;
    }

    public String getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(String activeInd) {
        this.activeInd = activeInd;
    }

    public String getBusyInd() {
        return busyInd;
    }

    public void setBusyInd(String busyInd) {
        this.busyInd = busyInd;
    }

    public String getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(String checkPoint) {
        this.checkPoint = checkPoint;
    }

    public String getCheckpointname() {
        return checkpointname;
    }

    public void setCheckpointname(String checkpointname) {
        this.checkpointname = checkpointname;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLastRunTime() {
        return lastRunTime;
    }

    public void setLastRunTime(String lastRunTime) {
        this.lastRunTime = lastRunTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csfScheduleTimesPK != null ? csfScheduleTimesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfScheduleTimes)) {
            return false;
        }
        CsfScheduleTimes other = (CsfScheduleTimes) object;
        if ((this.csfScheduleTimesPK == null && other.csfScheduleTimesPK != null) || (this.csfScheduleTimesPK != null && !this.csfScheduleTimesPK.equals(other.csfScheduleTimesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.entities.CsfScheduleTimes[ csfScheduleTimesPK=" + csfScheduleTimesPK + " ]";
    }
    
}

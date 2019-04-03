package com.bsva.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSO_SCHEDULE_TIMES")
@NamedQueries({
    @NamedQuery(name = "CsoScheduleTimes.findAll", query = "SELECT c FROM CsoScheduleTimes c"),
    @NamedQuery(name = "CsoScheduleTimes.findByProcess", query = "SELECT c FROM CsoScheduleTimes c WHERE c.csoScheduleTimesPK.process = :process"),
    @NamedQuery(name = "CsoScheduleTimes.findByService", query = "SELECT c FROM CsoScheduleTimes c WHERE c.csoScheduleTimesPK.service = :service"),
    @NamedQuery(name = "CsoScheduleTimes.findBySubService", query = "SELECT c FROM CsoScheduleTimes c WHERE c.csoScheduleTimesPK.subService = :subService"),
    @NamedQuery(name = "CsoScheduleTimes.findByStartTime", query = "SELECT c FROM CsoScheduleTimes c WHERE c.startTime = :startTime"),
    @NamedQuery(name = "CsoScheduleTimes.findByEndTime", query = "SELECT c FROM CsoScheduleTimes c WHERE c.endTime = :endTime"),
    @NamedQuery(name = "CsoScheduleTimes.findByLastRunTime", query = "SELECT c FROM CsoScheduleTimes c WHERE c.lastRunTime = :lastRunTime"),
    @NamedQuery(name = "CsoScheduleTimes.findByActiveInd", query = "SELECT c FROM CsoScheduleTimes c WHERE c.activeInd = :activeInd"),
    @NamedQuery(name = "CsoScheduleTimes.findByBusyInd", query = "SELECT c FROM CsoScheduleTimes c WHERE c.busyInd = :busyInd"),
    @NamedQuery(name = "CsoScheduleTimes.findByCheckPoint", query = "SELECT c FROM CsoScheduleTimes c WHERE c.checkPoint = :checkPoint")})
@DynamicUpdate
public class CsoScheduleTimes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsoScheduleTimesPK csoScheduleTimesPK;
    @Column(name = "START_TIME")
    private String startTime;
    @Column(name = "END_TIME")
    private String endTime;
    @Column(name = "LAST_RUN_TIME")
    private String lastRunTime;
    @Basic(optional = false)
    @Column(name = "ACTIVE_IND")
    private String activeInd;
    @Basic(optional = false)
    @Column(name = "BUSY_IND")
    private String busyInd;
    @Basic(optional = false)
    @Column(name = "CHECK_POINT")
    private String checkPoint;
    @Basic(optional = false)
    @Column(name = "CHECK_POINT_NAME")
    private String checkPointName;    
    @Column(name = "PROCESS_DATE")
    private String processDate;

    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCheckPointName() {
		return checkPointName;
	}

	public void setCheckPointName(String checkPointName) {
		this.checkPointName = checkPointName;
	}

	public CsoScheduleTimes() {
    }

    public CsoScheduleTimes(CsoScheduleTimesPK csoScheduleTimesPK) {
        this.csoScheduleTimesPK = csoScheduleTimesPK;
    }

    public CsoScheduleTimes(CsoScheduleTimesPK csoScheduleTimesPK, String activeInd, String busyInd, String checkPoint) {
        this.csoScheduleTimesPK = csoScheduleTimesPK;
        this.activeInd = activeInd;
        this.busyInd = busyInd;
        this.checkPoint = checkPoint;
    }

    public CsoScheduleTimes(String process, String service, String subService) {
        this.csoScheduleTimesPK = new CsoScheduleTimesPK(process, service, subService);
    }

    public CsoScheduleTimesPK getCsoScheduleTimesPK() {
        return csoScheduleTimesPK;
    }

    public void setCsoScheduleTimesPK(CsoScheduleTimesPK csoScheduleTimesPK) {
        this.csoScheduleTimesPK = csoScheduleTimesPK;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
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
    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csoScheduleTimesPK != null ? csoScheduleTimesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoScheduleTimes)) {
            return false;
        }
        CsoScheduleTimes other = (CsoScheduleTimes) object;
        if ((this.csoScheduleTimesPK == null && other.csoScheduleTimesPK != null) || (this.csoScheduleTimesPK != null && !this.csoScheduleTimesPK.equals(other.csoScheduleTimesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoScheduleTimes[ csoScheduleTimesPK=" + csoScheduleTimesPK + " ]";
    }
    
}

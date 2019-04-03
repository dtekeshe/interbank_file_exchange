package com.bsva.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSO_SCHEDULED_PROCESSES")
//@NamedQueries({
    //@NamedQuery(name = "CsoScheduledProcesses.findAll", query = "SELECT c FROM CsoScheduledProcesses c"),
    //@NamedQuery(name = "CsoScheduledProcesses.findByProcessName", query = "SELECT c FROM CsoScheduledProcesses c WHERE c.processName = :processName"),
    //@NamedQuery(name = "CsoScheduledProcesses.findByProcessFrequency", query = "SELECT c FROM CsoScheduledProcesses c WHERE c.processFrequency = :processFrequency"),
    //@NamedQuery(name = "CsoScheduledProcesses.findByClassPath", query = "SELECT c FROM CsoScheduledProcesses c WHERE c.classPath = :classPath"),
    //@NamedQuery(name = "CsoScheduledProcesses.findByActiveInd", query = "SELECT c FROM CsoScheduledProcesses c WHERE c.activeInd = :activeInd")})
public class CsoScheduledProcesses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PROCESS_NAME")
    private String processName;
    @Column(name = "PROCESS_FREQUENCY")
    private Long processFrequency;
    @Column(name = "CLASS_PATH")
    private String classPath;
    @Column(name = "ACTIVE_IND")
    private String activeInd;

    public CsoScheduledProcesses() {
    }

    public CsoScheduledProcesses(String processName) {
        this.processName = processName;
    }

    public CsoScheduledProcesses(String processName, String classPath) {
        this.processName = processName;
        this.classPath = classPath;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Long getProcessFrequency() {
        return processFrequency;
    }

    public void setProcessFrequency(Long processFrequency) {
        this.processFrequency = processFrequency;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(String activeInd) {
        this.activeInd = activeInd;
    }

   

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (processName != null ? processName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoScheduledProcesses)) {
            return false;
        }
        CsoScheduledProcesses other = (CsoScheduledProcesses) object;
        if ((this.processName == null && other.processName != null) || (this.processName != null && !this.processName.equals(other.processName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoScheduledProcesses[ processName=" + processName + " ]";
    }
    
}

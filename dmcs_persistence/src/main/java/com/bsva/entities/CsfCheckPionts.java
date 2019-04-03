
package com.bsva.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSF_CHECK_PIONTS")
@NamedQueries({
    @NamedQuery(name = "CsfCheckPionts.findAll", query = "SELECT c FROM CsfCheckPionts c"),
    @NamedQuery(name = "CsfCheckPionts.findByCheckPointName", query = "SELECT c FROM CsfCheckPionts c WHERE c.checkPointName = :checkPointName"),
    @NamedQuery(name = "CsfCheckPionts.findByCheckPointDescription", query = "SELECT c FROM CsfCheckPionts c WHERE c.checkPointDescription = :checkPointDescription")})
@DynamicUpdate
public class CsfCheckPionts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CHECK_POINT_NAME")
    private String checkPointName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CHECK_POINT_DESCRIPTION")
    private String checkPointDescription;

//    private List<CsoScheduleTimes> csoScheduleTimesList = new ArrayList<CsoScheduleTimes>();

//    public List<CsoScheduleTimes> getCsoScheduleTimesList() {
//		return csoScheduleTimesList;
//	}
//
//	public void setCsoScheduleTimesList(List<CsoScheduleTimes> csoScheduleTimesList) {
//		this.csoScheduleTimesList = csoScheduleTimesList;
//	}

	public CsfCheckPionts() {
    }

    public CsfCheckPionts(String checkPointName) {
        this.checkPointName = checkPointName;
    }

    public CsfCheckPionts(String checkPointName, String checkPointDescription) {
        this.checkPointName = checkPointName;
        this.checkPointDescription = checkPointDescription;
    }

    public String getCheckPointName() {
        return checkPointName;
    }

    public void setCheckPointName(String checkPointName) {
        this.checkPointName = checkPointName;
    }

    public String getCheckPointDescription() {
        return checkPointDescription;
    }

    public void setCheckPointDescription(String checkPointDescription) {
        this.checkPointDescription = checkPointDescription;
    }

   


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checkPointName != null ? checkPointName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfCheckPionts)) {
            return false;
        }
        CsfCheckPionts other = (CsfCheckPionts) object;
        if ((this.checkPointName == null && other.checkPointName != null) || (this.checkPointName != null && !this.checkPointName.equals(other.checkPointName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfCheckPionts[ checkPointName=" + checkPointName + " ]";
    }
    
}

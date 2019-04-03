/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSF_PROCESS_SCHEDULE")
@NamedQueries({
    @NamedQuery(name = "CsfProcessSchedule.findAll", query = "SELECT c FROM CsfProcessSchedule c"),
    @NamedQuery(name = "CsfProcessSchedule.findByDayNumber", query = "SELECT c FROM CsfProcessSchedule c WHERE c.dayNumber = :dayNumber"),
    @NamedQuery(name = "CsfProcessSchedule.findByProcessIndicator", query = "SELECT c FROM CsfProcessSchedule c WHERE c.processIndicator = :processIndicator")})
@DynamicUpdate
public class CsfProcessSchedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DAY_NUMBER")
    private Short dayNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PROCESS_INDICATOR")
    private String processIndicator;

    public CsfProcessSchedule() {
    }

    public CsfProcessSchedule(Short dayNumber) {
        this.dayNumber = dayNumber;
    }

    public CsfProcessSchedule(Short dayNumber, String processIndicator) {
        this.dayNumber = dayNumber;
        this.processIndicator = processIndicator;
    }

    public Short getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(Short dayNumber) {
        this.dayNumber = dayNumber;
    }

    public String getProcessIndicator() {
        return processIndicator;
    }

    public void setProcessIndicator(String processIndicator) {
        this.processIndicator = processIndicator;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dayNumber != null ? dayNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfProcessSchedule)) {
            return false;
        }
        CsfProcessSchedule other = (CsfProcessSchedule) object;
        if ((this.dayNumber == null && other.dayNumber != null) || (this.dayNumber != null && !this.dayNumber.equals(other.dayNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfProcessSchedule[ dayNumber=" + dayNumber + " ]";
    }
    
}

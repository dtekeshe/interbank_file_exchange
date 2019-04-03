/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSF_PUBLIC_HOLIDAYS")
@NamedQueries({
    @NamedQuery(name = "CsfPublicHolidays.findAll", query = "SELECT c FROM CsfPublicHolidays c"),
    @NamedQuery(name = "CsfPublicHolidays.findByProcessDate", query = "SELECT c FROM CsfPublicHolidays c WHERE c.processDate = :processDate"),
    @NamedQuery(name = "CsfPublicHolidays.findByPublicHolidayIndicator", query = "SELECT c FROM CsfPublicHolidays c WHERE c.publicHolidayIndicator = :publicHolidayIndicator")})
@DynamicUpdate
public class CsfPublicHolidays implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROCESS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date processDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PUBLIC_HOLIDAY_INDICATOR")
    private String publicHolidayIndicator;

    public CsfPublicHolidays() {
    }

    public CsfPublicHolidays(Date processDate) {
        this.processDate = processDate;
    }

    public CsfPublicHolidays(Date processDate, String publicHolidayIndicator) {
        this.processDate = processDate;
        this.publicHolidayIndicator = publicHolidayIndicator;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getPublicHolidayIndicator() {
        return publicHolidayIndicator;
    }

    public void setPublicHolidayIndicator(String publicHolidayIndicator) {
        this.publicHolidayIndicator = publicHolidayIndicator;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (processDate != null ? processDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfPublicHolidays)) {
            return false;
        }
        CsfPublicHolidays other = (CsfPublicHolidays) object;
        if ((this.processDate == null && other.processDate != null) || (this.processDate != null && !this.processDate.equals(other.processDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfPublicHolidays[ processDate=" + processDate + " ]";
    }
    
}

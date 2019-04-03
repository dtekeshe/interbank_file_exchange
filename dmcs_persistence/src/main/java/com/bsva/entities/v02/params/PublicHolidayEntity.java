package com.bsva.entities.v02.params;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * TODO Document
 */
@Entity
public class PublicHolidayEntity {

    @Id
    @Column(name = "CALENDAR_DATE")
    private Date calendarDate;

    public Date getCalendarDate() {
        return calendarDate;
    }

    public void setCalendarDate(Date calendarDate) {
        this.calendarDate = calendarDate;
    }
}

package com.bsva.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfPublicHolidays;

/**
 * @author AugustineA
 *
 */
public class CsfPublicHolidaysDao extends AbstractDao<CsfPublicHolidays, Date> {

    public CsfPublicHolidaysDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfPublicHolidays
     */
    public void create(CsfPublicHolidays csfPublicHolidays) {
        super.saveOrUpdate(csfPublicHolidays);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfPublicHolidays
     */
    public void delete(CsfPublicHolidays csfPublicHolidays) {
        super.delete(csfPublicHolidays);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param date
     * @return
     */
    public CsfPublicHolidays find(Date date) {
        return (CsfPublicHolidays) super.find(CsfPublicHolidays.class, date);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfPublicHolidays
     */
    public void update(CsfPublicHolidays csfPublicHolidays) {
        super.saveOrUpdate(csfPublicHolidays);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfPublicHolidays.class);
    }

    @Override
    public CsfPublicHolidays executeQueryParametersSingleDate(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingleDate(query, parameters);
    }

}

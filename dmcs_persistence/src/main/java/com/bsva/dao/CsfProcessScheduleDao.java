package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfProcessSchedule;

/**
 * @author AugustineA
 *
 */
public class CsfProcessScheduleDao extends AbstractDao<CsfProcessSchedule, Short> {

    public CsfProcessScheduleDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfProcessSchedule
     */
    public void create(CsfProcessSchedule csfProcessSchedule) {
        super.saveOrUpdate(csfProcessSchedule);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfProcessSchedule
     */
    public void delete(CsfProcessSchedule csfProcessSchedule) {
        super.delete(csfProcessSchedule);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsfProcessSchedule find(Short string) {
        return (CsfProcessSchedule) super.find(CsfProcessSchedule.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfProcessSchedule
     */
    public void update(CsfProcessSchedule csfProcessSchedule) {
        super.saveOrUpdate(csfProcessSchedule);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfProcessSchedule.class);
    }

    @Override
    public CsfProcessSchedule executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

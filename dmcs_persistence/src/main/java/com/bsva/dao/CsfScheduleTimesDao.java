package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfScheduleTimes;
import com.bsva.entities.CsfScheduleTimesPK;

/**
 * @author AugustineA
 *
 */
public class CsfScheduleTimesDao extends AbstractDao<CsfScheduleTimes, CsfScheduleTimesPK> {

    public CsfScheduleTimesDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfScheduleTimes
     */
    public void create(CsfScheduleTimes csfScheduleTimes) {
        super.saveOrUpdate(csfScheduleTimes);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfScheduleTimes
     */
    public void delete(CsfScheduleTimes csfScheduleTimes) {
        super.delete(csfScheduleTimes);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csfScheduleTimespk
     * @return
     */
    public CsfScheduleTimes find(CsfScheduleTimesPK csfScheduleTimespk) {
        return (CsfScheduleTimes) super.find(CsfScheduleTimes.class, csfScheduleTimespk);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfScheduleTimes
     */
    public void update(CsfScheduleTimes csfScheduleTimes)  {
        super.saveOrUpdate(csfScheduleTimes);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfScheduleTimes.class);
    }

    @Override
    public CsfScheduleTimes executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

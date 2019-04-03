package com.bsva.dao;

import java.util.List;
import java.util.Map;

import com.bsva.entities.CsoScheduledProcesses;

/**
 * @author AugustineA
 *
 */
public class CsoScheduledProcessesDao extends AbstractDao<CsoScheduledProcesses, String> {

    public CsoScheduledProcessesDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     * @param csoScheduledProcesses
     */
    public void create(CsoScheduledProcesses csoScheduledProcesses) {
        super.saveOrUpdate(csoScheduledProcesses);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csoScheduledProcesses
     */
    public void delete(CsoScheduledProcesses csoScheduledProcesses) {
        super.delete(csoScheduledProcesses);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsoScheduledProcesses find(CsoScheduledProcesses string) {
        return (CsoScheduledProcesses) super.find(CsoScheduledProcesses.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csoScheduledProcesses
     */
    public void update(CsoScheduledProcesses csoScheduledProcesses) {
        super.saveOrUpdate(csoScheduledProcesses);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoScheduledProcesses.class);
    }

    @Override
    public CsoScheduledProcesses executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

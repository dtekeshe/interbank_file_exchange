package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsoFleetBindResolved;
import com.bsva.entities.CsoFleetBindResolvedPK;

public class CsoFleetBindResolvedDao extends AbstractDao<CsoFleetBindResolved, CsoFleetBindResolvedPK> {

    public CsoFleetBindResolvedDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csoFleetBindResolved
     */
    public void create(CsoFleetBindResolved csoFleetBindResolved) {
        super.saveOrUpdate(csoFleetBindResolved);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csoFleetBindResolved
     */
    public void delete(CsoFleetBindResolved csoFleetBindResolved) {
        super.delete(csoFleetBindResolved);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csoFleetBindResolvedpk
     * @return
     */
    public CsoFleetBindResolved find(CsoFleetBindResolvedPK csoFleetBindResolvedpk) {
        return (CsoFleetBindResolved) super.find(CsoFleetBindResolved.class, csoFleetBindResolvedpk);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csoFleetBindResolved
     */
    public void update(CsoFleetBindResolved csoFleetBindResolved) {
        super.saveOrUpdate(csoFleetBindResolved);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoFleetBindResolved.class);
    }

    @Override
    public CsoFleetBindResolved executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }



}

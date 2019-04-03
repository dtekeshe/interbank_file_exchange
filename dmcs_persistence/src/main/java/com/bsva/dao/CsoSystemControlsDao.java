package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsoSystemControls;
import com.bsva.entities.CsoSystemControlsPK;

/**
 * @author AugustineA
 *
 */
public class CsoSystemControlsDao extends AbstractDao<CsoSystemControls, CsoSystemControlsPK> {

    public CsoSystemControlsDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csoSystemControls
     */
    public void create(CsoSystemControls csoSystemControls) {
        super.saveOrUpdate(csoSystemControls);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csoSystemControls
     */
    public void delete(CsoSystemControls csoSystemControls) {
        super.delete(csoSystemControls);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csoSystemControlspk
     * @return
     */
    public CsoSystemControls find(CsoSystemControlsPK csoSystemControlspk) {
        return (CsoSystemControls) super.find(CsoSystemControls.class, csoSystemControlspk);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csoSystemControls
     */
    public void update(CsoSystemControls csoSystemControls) {
        super.saveOrUpdate(csoSystemControls);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoSystemControls.class);
    }

    @Override
    public CsoSystemControls executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsoOutputControls;

/**
 * @author AugustineA
 *
 */
public class CsoOutputControlsDao extends AbstractDao<CsoOutputControls, String> {

    public CsoOutputControlsDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csoOutputControls
     */
    public void create(CsoOutputControls csoOutputControls) {
        super.saveOrUpdate(csoOutputControls);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csoOutputControls
     */
    public void delete(CsoOutputControls csoOutputControls) {
        super.delete(csoOutputControls);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsoOutputControls find(String string) {
        return (CsoOutputControls) super.find(CsoOutputControls.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csoOutputControls
     */
    public void update(CsoOutputControls csoOutputControls) {
        super.saveOrUpdate(csoOutputControls);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoOutputControls.class);
    }

    @Override
    public CsoOutputControls executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

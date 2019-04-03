package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsoProgramControls;
import com.bsva.entities.CsoProgramControlsPK;

/**
 * @author AugustineA
 *
 */
public class CsoProgramControlsDao extends AbstractDao<CsoProgramControls, CsoProgramControlsPK> {

    public CsoProgramControlsDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csoProgramControls
     */
    public void create(CsoProgramControls csoProgramControls) {
        super.saveOrUpdate(csoProgramControls);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csoProgramControls
     */
    public void delete(CsoProgramControls csoProgramControls) {
        super.delete(csoProgramControls);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csoProgramControlspk
     * @return
     */
    public CsoProgramControls find(CsoProgramControlsPK csoProgramControlspk) {
        return (CsoProgramControls) super.find(CsoProgramControls.class, csoProgramControlspk);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csoProgramControls
     */
    public void update(CsoProgramControls csoProgramControls) {
        super.saveOrUpdate(csoProgramControls);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoProgramControls.class);
    }

    @Override
    public CsoProgramControls executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

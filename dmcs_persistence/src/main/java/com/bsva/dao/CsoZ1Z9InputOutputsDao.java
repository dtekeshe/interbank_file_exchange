package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsoZ1Z9InputOutputs;

/**
 * @author AugustineA
 *
 */
public class CsoZ1Z9InputOutputsDao extends AbstractDao<CsoZ1Z9InputOutputs, String> {

    public CsoZ1Z9InputOutputsDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csoZ1Z9InputOutputs
     */
    public void create(CsoZ1Z9InputOutputs csoZ1Z9InputOutputs) {
        super.saveOrUpdate(csoZ1Z9InputOutputs);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csoZ1Z9InputOutputs
     */
    public void delete(CsoZ1Z9InputOutputs csoZ1Z9InputOutputs) {
        super.delete(csoZ1Z9InputOutputs);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsoZ1Z9InputOutputs find(String string) {
        return (CsoZ1Z9InputOutputs) super.find(CsoZ1Z9InputOutputs.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csoZ1Z9InputOutputs
     */
    public void update(CsoZ1Z9InputOutputs csoZ1Z9InputOutputs) {
        super.saveOrUpdate(csoZ1Z9InputOutputs);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoZ1Z9InputOutputs.class);
    }

    @Override
    public CsoZ1Z9InputOutputs executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

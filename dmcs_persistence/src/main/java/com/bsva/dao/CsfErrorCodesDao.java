package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfErrorCodes;

public class CsfErrorCodesDao extends AbstractDao<CsfErrorCodes, Integer> {

    public CsfErrorCodesDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfErrorCodes
     */
    public void create(CsfErrorCodes csfErrorCodes) {
        super.saveOrUpdate(csfErrorCodes);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfErrorCodes
     */
    public void delete(CsfErrorCodes csfErrorCodes) {
        super.delete(csfErrorCodes);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param integer
     * @return
     */
    public CsfErrorCodes find(Integer integer) {
        return (CsfErrorCodes) super.find(CsfErrorCodes.class, integer);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfErrorCodes
     */
    public void update(CsfErrorCodes csfErrorCodes) {
        super.saveOrUpdate(csfErrorCodes);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfErrorCodes.class);
    }

    @Override
    public CsfErrorCodes executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

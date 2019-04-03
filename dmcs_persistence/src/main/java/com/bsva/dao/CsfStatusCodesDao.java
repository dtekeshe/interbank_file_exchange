package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfStatusCodes;

/**
 * @author AugustineA
 *
 */
public class CsfStatusCodesDao extends AbstractDao<CsfStatusCodes, String> {

    public CsfStatusCodesDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfStatusCodes
     */
    public void create(CsfStatusCodes csfStatusCodes) {
        super.saveOrUpdate(csfStatusCodes);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfStatusCodes
     */
    public void delete(CsfStatusCodes csfStatusCodes) {
        super.delete(csfStatusCodes);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsfStatusCodes find(String string) {
        return (CsfStatusCodes) super.find(CsfStatusCodes.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfStatusCodes
     */
    public void update(CsfStatusCodes csfStatusCodes) {
        super.saveOrUpdate(csfStatusCodes);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfStatusCodes.class);
    }

    @Override
    public CsfStatusCodes executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

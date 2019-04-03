package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfFilenameLookup;

/**
 * @author AugustineA
 *
 */
public class CsfFilenameLookupDao extends AbstractDao<CsfFilenameLookup, String> {

    public CsfFilenameLookupDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfFilenameLookup
     */
    public void create(CsfFilenameLookup csfFilenameLookup) {
        super.saveOrUpdate(csfFilenameLookup);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfFilenameLookup
     */
    public void delete(CsfFilenameLookup csfFilenameLookup) {
        super.delete(csfFilenameLookup);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsfFilenameLookup find(String string) {
        return (CsfFilenameLookup) super.find(CsfFilenameLookup.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfFilenameLookup
     */
    public void update(CsfFilenameLookup csfFilenameLookup) {
        super.saveOrUpdate(csfFilenameLookup);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfFilenameLookup.class);
    }

    @Override
    public CsfFilenameLookup executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

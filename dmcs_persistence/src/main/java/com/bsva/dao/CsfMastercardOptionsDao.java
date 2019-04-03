package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfMastercardOptions;

/**
 * @author AugustineA
 *
 */
public class CsfMastercardOptionsDao extends AbstractDao<CsfMastercardOptions, Short> {

    public CsfMastercardOptionsDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfMastercardOptions
     */
    public void create(CsfMastercardOptions csfMastercardOptions) {
        super.saveOrUpdate(csfMastercardOptions);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfMastercardOptions
     */
    public void delete(CsfMastercardOptions csfMastercardOptions) {
        super.delete(csfMastercardOptions);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsfMastercardOptions find(Short string) {
        return (CsfMastercardOptions) super.find(CsfMastercardOptions.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfMastercardOptions
     */
    public void update(CsfMastercardOptions csfMastercardOptions) {
        super.saveOrUpdate(csfMastercardOptions);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfMastercardOptions.class);
    }

    @Override
    public CsfMastercardOptions executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

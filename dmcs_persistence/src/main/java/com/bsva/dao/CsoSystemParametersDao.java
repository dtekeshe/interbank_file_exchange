package com.bsva.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.bsva.entities.CsoSystemParameters;

/**
 * @author AugustineA
 *
 */
public class CsoSystemParametersDao extends AbstractDao<CsoSystemParameters, Date> {

    public CsoSystemParametersDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csoSystemParameters
     */
    public void create(CsoSystemParameters csoSystemParameters) {
        super.saveOrUpdate(csoSystemParameters);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csoSystemParameters
     */
    public void delete(CsoSystemParameters csoSystemParameters) {
        super.delete(csoSystemParameters);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param date
     * @return
     */
    public CsoSystemParameters find(Date date) {
        return (CsoSystemParameters) super.find(CsoSystemParameters.class, date);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csoSystemParameters
     */
    public void update(CsoSystemParameters csoSystemParameters) {
        super.saveOrUpdate(csoSystemParameters);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoSystemParameters.class);
    }

    @Override
    public CsoSystemParameters executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

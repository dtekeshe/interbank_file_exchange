package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfServices;
import com.bsva.entities.CsfServicesPK;

/**
 * @author AugustineA
 *
 */
public class CsfServicesDao extends AbstractDao<CsfServices, CsfServicesPK> {

    public CsfServicesDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfServices
     */
    public void create(CsfServices csfServices) {
        super.saveOrUpdate(csfServices);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfServices
     */
    public void delete(CsfServices csfServices) {
        super.delete(csfServices);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csfServicespk
     * @return
     */
    public CsfServices find(CsfServicesPK csfServicespk) {
        return (CsfServices) super.find(CsfServices.class, csfServicespk);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfServices
     */
    public void update(CsfServices csfServices) {
        super.saveOrUpdate(csfServices);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfServices.class);
    }

    @Override
    public CsfServices executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfSubServices;
import com.bsva.entities.CsfSubServicesPK;

/**
 * @author AugustineA
 *
 */
public class CsfSubServicesDao extends AbstractDao<CsfSubServices, CsfSubServicesPK> {

    public CsfSubServicesDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfSubServices
     */
    public void create(CsfSubServices csfSubServices) {
        super.saveOrUpdate(csfSubServices);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfSubServices
     */
    public void delete(CsfSubServices csfSubServices) {
        super.delete(csfSubServices);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csfSubServicesPK
     * @return
     */
    public CsfSubServices find(CsfSubServicesPK csfSubServicesPK) {
        return (CsfSubServices) super.find(CsfSubServices.class, csfSubServicesPK);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfSubServices
     */
    public void update(CsfSubServices csfSubServices) {
        super.saveOrUpdate(csfSubServices);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfSubServices.class);
    }

    @Override
    public CsfSubServices executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

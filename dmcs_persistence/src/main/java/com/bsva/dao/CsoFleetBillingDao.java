package com.bsva.dao;

import java.util.List;
import java.util.Map;

import com.bsva.entities.CsoFleetBilling;

public class CsoFleetBillingDao extends AbstractDao<CsoFleetBilling,Long> {

    public CsoFleetBillingDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfServices
     */
    public void create(CsoFleetBilling csoFleetBilling) {
        super.saveOrUpdate(csoFleetBilling);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfServices
     */
    public void delete(CsoFleetBilling csoFleetBindResolved) {
        super.delete(csoFleetBindResolved);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csfServicespk
     * @return
     */
    public CsoFleetBilling find(Long csoFleetBillingPK) {
        return (CsoFleetBilling) super.find(CsoFleetBilling.class, csoFleetBillingPK);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfServices
     */
    public void update(CsoFleetBilling csoFleetBindResolved) {
        super.saveOrUpdate(csoFleetBindResolved);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoFleetBilling.class);
    }

    @Override
    public CsoFleetBilling executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

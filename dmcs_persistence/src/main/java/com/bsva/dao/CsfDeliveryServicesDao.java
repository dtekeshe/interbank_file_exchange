package com.bsva.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfDeliveryServices;

/**
 * @author AugustineA
 *
 */
public class CsfDeliveryServicesDao extends AbstractDao<CsfDeliveryServices, BigDecimal> {

    public CsfDeliveryServicesDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfDeliveryServices
     */
    public void create(CsfDeliveryServices csfDeliveryServices) {
        super.saveOrUpdate(csfDeliveryServices);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfDeliveryServices
     */
    public void delete(CsfDeliveryServices csfDeliveryServices) {
        super.delete(csfDeliveryServices);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsfDeliveryServices find(BigDecimal string) {
        return (CsfDeliveryServices) super.find(CsfDeliveryServices.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfDeliveryServices
     */
    public void update(CsfDeliveryServices csfDeliveryServices) {
        super.saveOrUpdate(csfDeliveryServices);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfDeliveryServices.class);
    }

    @Override
    public CsfDeliveryServices executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

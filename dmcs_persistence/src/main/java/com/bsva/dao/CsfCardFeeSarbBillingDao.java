package com.bsva.dao;

import com.bsva.entities.CsfCardFeeSarbBilling;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SimphiweT
 */
public class CsfCardFeeSarbBillingDao extends AbstractDao<CsfCardFeeSarbBilling, String> {
    
    public CsfCardFeeSarbBillingDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfCardFeeSarbBilling
     */
    public void create(CsfCardFeeSarbBilling cardFeeSarbBilling) {
        super.saveOrUpdate(cardFeeSarbBilling);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfCardFeeSarbBilling
     */
    public void delete(CsfCardFeeSarbBilling csfCardFeeSarbBilling) {
        super.delete(csfCardFeeSarbBilling);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param date
     * @return
     */
    public CsfCardFeeSarbBilling find(CsfCardFeeSarbBilling csfCardFeeSarbBilling) {
        return (CsfCardFeeSarbBilling) super.find(CsfCardFeeSarbBilling.class, csfCardFeeSarbBilling);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfCardFeeSarbBilling
     */
    public void update(CsfCardFeeSarbBilling csfCardFeeSarbBilling) {
        super.saveOrUpdate(csfCardFeeSarbBilling);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfCardFeeSarbBilling.class);
    }

    @Override
    public CsfCardFeeSarbBilling executeQueryParametersSingleDate(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingleDate(query, parameters);
    }
    
}

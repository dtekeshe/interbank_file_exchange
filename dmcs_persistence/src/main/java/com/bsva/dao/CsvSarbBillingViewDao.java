
package com.bsva.dao;

import com.bsva.entities.CsvSarbBillingView;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SimphiweT
 */
public class CsvSarbBillingViewDao extends AbstractDao<CsvSarbBillingView, String> {
    
    public CsvSarbBillingViewDao() {        
    }
    
    /**
     * Insert a new Event into the database.
     *
     * @param csvSarbBillingView
     */
    public void create(CsvSarbBillingView csvSarbBillingView) {
        super.saveOrUpdate(csvSarbBillingView);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csvSarbBillingView
     */
    public void delete(CsvSarbBillingView csvSarbBillingView) {
        super.delete(csvSarbBillingView);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param date
     * @return
     */
    public CsvSarbBillingView find(CsvSarbBillingView billingView) {
        return (CsvSarbBillingView) super.find(CsvSarbBillingView.class, billingView);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csvSarbBillingView
     */
    public void update(CsvSarbBillingView csvSarbBillingView) {
        super.saveOrUpdate(csvSarbBillingView);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsvSarbBillingView.class);
    }

    @Override
    public CsvSarbBillingView executeQueryParametersSingleDate(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingleDate(query, parameters);
    }
    
}

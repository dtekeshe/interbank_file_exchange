package com.bsva.dao;

import com.bsva.entities.CsfCardFeeBilateralPK;
import com.bsva.entities.CsfCardRateLookup;
import com.bsva.entities.CsfCardRateLookupPK;
import com.bsva.utils.DataAccessLayerException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SimphiweT
 */
public class CsfCardRateLookupDao extends AbstractDao<CsfCardRateLookup, CsfCardRateLookupPK> {
   
    public CsfCardRateLookupDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfCardRateLookup
     */
    public void create(CsfCardRateLookup csfCardRateLookup) {
        super.saveOrUpdate(csfCardRateLookup);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfCardRateLookup
     */
    public void delete(CsfCardRateLookup csfCardRateLookup) {
        super.delete(csfCardRateLookup);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csfCardFeeBilateralPK     
     * @return
     */
    public CsfCardRateLookup find(CsfCardFeeBilateralPK csfCardFeeBilateralPK) {
        return (CsfCardRateLookup) super.find(CsfCardRateLookup.class, csfCardFeeBilateralPK);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfCardRateLookup
     */
    public void update(CsfCardRateLookup csfCardRateLookup) {
        super.saveOrUpdate(csfCardRateLookup);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfCardRateLookup.class);
    }

    @Override
    public CsfCardRateLookup executeQueryParametersSingleDate(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingleDate(query, parameters);
    }
    
}

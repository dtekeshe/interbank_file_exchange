package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfDistributionParameters;
import com.bsva.entities.CsfDistributionParametersPK;

/**
 * @author AugustineA
 *
 */
public class CsfDistributionParametersDao extends AbstractDao<CsfDistributionParameters, CsfDistributionParametersPK> {

    public CsfDistributionParametersDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfDistributionParameters
     */
    public void create(CsfDistributionParameters csfDistributionParameters) {
        super.saveOrUpdate(csfDistributionParameters);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfDistributionParameters
     */
    public void delete(CsfDistributionParameters csfDistributionParameters) {
        super.delete(csfDistributionParameters);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csfDistributionParameterspk
     * @return
     */
    public CsfDistributionParameters find(CsfDistributionParametersPK csfDistributionParameterspk) {
        return (CsfDistributionParameters) super.find(CsfDistributionParameters.class, csfDistributionParameterspk);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfDistributionParameters
     */
    public void update(CsfDistributionParameters csfDistributionParameters) {
        super.saveOrUpdate(csfDistributionParameters);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfDistributionParameters.class);
    }

    @Override
    public CsfDistributionParameters executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

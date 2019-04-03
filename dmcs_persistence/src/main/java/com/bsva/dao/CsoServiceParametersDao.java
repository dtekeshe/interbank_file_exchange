package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsoServiceParameters;
import com.bsva.entities.CsoServiceParametersPK;

/**
 * @author AugustineA
 *
 */
public class CsoServiceParametersDao extends AbstractDao<CsoServiceParameters, CsoServiceParametersPK> {

    public CsoServiceParametersDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csoServiceParameters
     */
    public void create(CsoServiceParameters csoServiceParameters) {
        super.saveOrUpdate(csoServiceParameters);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csoServiceParameters
     */
    public void delete(CsoServiceParameters csoServiceParameters) {
        super.delete(csoServiceParameters);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csoServiceParameterspk
     * @return
     */
    public CsoServiceParameters find(CsoServiceParametersPK csoServiceParameterspk) {
        return (CsoServiceParameters) super.find(CsoServiceParameters.class, csoServiceParameterspk);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csoServiceParameters
     */
    public void update(CsoServiceParameters csoServiceParameters) {
        super.saveOrUpdate(csoServiceParameters);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoServiceParameters.class);
    }

    @Override
    public CsoServiceParameters executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfCompanyParameters;

/**
 * @author AugustineA
 *
 */
public class CsfCompanyParametersDao extends AbstractDao<CsfCompanyParameters, String> {

    public CsfCompanyParametersDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfCompanyParameters
     */
    public void create(CsfCompanyParameters csfCompanyParameters) {
        super.saveOrUpdate(csfCompanyParameters);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfCompanyParameters
     */
    public void delete(CsfCompanyParameters csfCompanyParameters) {
        super.delete(csfCompanyParameters);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsfCompanyParameters find(String string) {
        return (CsfCompanyParameters) super.find(CsfCompanyParameters.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfCompanyParameters
     */
    public void update(CsfCompanyParameters csfCompanyParameters)  {
        super.saveOrUpdate(csfCompanyParameters);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfCompanyParameters.class);
    }

    @Override
    public CsfCompanyParameters executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

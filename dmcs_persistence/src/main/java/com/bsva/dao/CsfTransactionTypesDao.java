package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfTransactionTypes;

/**
 * @author AugustineA
 *
 */
public class CsfTransactionTypesDao extends AbstractDao<CsfTransactionTypes, Short> {

    public CsfTransactionTypesDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfTransactionTypes
     */
    public void create(CsfTransactionTypes csfTransactionTypes) {
        super.saveOrUpdate(csfTransactionTypes);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfTransactionTypes
     */
    public void delete(CsfTransactionTypes csfTransactionTypes) {
        super.delete(csfTransactionTypes);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsfTransactionTypes find(String string) {
        return (CsfTransactionTypes) super.find(CsfTransactionTypes.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfTransactionTypes
     */
    public void update(CsfTransactionTypes csfTransactionTypes) {
        super.saveOrUpdate(csfTransactionTypes);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfTransactionTypes.class);
    }

    @Override
    public CsfTransactionTypes executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

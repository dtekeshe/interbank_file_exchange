package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsoTransactions;

/**
 * @author AugustineA
 *
 */
public class CsoTransactionsDao extends AbstractDao<CsoTransactions, String> {

    public CsoTransactionsDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csoTransactions
     */
    public void create(CsoTransactions csoTransactions) {
        super.save(csoTransactions);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csoTransactions
     */
    public void delete(CsoTransactions csoTransactions) {
        super.delete(csoTransactions);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param longl
     * @return
     */
    public CsoTransactions find(Long longl) {
        return (CsoTransactions) super.find(CsoTransactions.class, longl);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csoTransactions
     */
    public void update(CsoTransactions csoTransactions) {
        super.saveOrUpdate(csoTransactions);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoTransactions.class);
    }

    @Override
    public CsoTransactions executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

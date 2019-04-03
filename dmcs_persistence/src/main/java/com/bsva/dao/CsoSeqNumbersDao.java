package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsoSeqNumbers;
import com.bsva.entities.CsoSeqNumbersPK;

/**
 * @author AugustineA
 *
 */
public class CsoSeqNumbersDao extends AbstractDao<CsoSeqNumbers, CsoSeqNumbersPK> {

    public CsoSeqNumbersDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csoSeqNumbers
     */
    public void create(CsoSeqNumbers csoSeqNumbers) {
        super.saveOrUpdate(csoSeqNumbers);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csoSeqNumbers
     */
    public void delete(CsoSeqNumbers csoSeqNumbers) {
        super.delete(csoSeqNumbers);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsoSeqNumbers find(String string) {
        return (CsoSeqNumbers) super.find(CsoSeqNumbers.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csoSeqNumbers
     */
    public void update(CsoSeqNumbers csoSeqNumbers) {
        super.saveOrUpdate(csoSeqNumbers);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoSeqNumbers.class);
    }

    @Override
    public CsoSeqNumbers executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

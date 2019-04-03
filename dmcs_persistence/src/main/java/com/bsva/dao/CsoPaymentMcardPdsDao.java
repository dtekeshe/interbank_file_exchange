package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsoPaymentMcardPds;
import com.bsva.entities.CsoPaymentMcardPdsPK;

/**
 * @author AugustineA
 *
 */
public class CsoPaymentMcardPdsDao extends AbstractDao<CsoPaymentMcardPds, CsoPaymentMcardPdsPK> {

    public CsoPaymentMcardPdsDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csoPaymentMcardPds
     */
    public void create(CsoPaymentMcardPds csoPaymentMcardPds) {
        super.saveOrUpdate(csoPaymentMcardPds);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csoPaymentMcardPds
     */
    public void delete(CsoPaymentMcardPds csoPaymentMcardPds) {
        super.delete(csoPaymentMcardPds);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csoPaymentMcardPdspk
     * @return
     */
    public CsoPaymentMcardPds find(CsoPaymentMcardPds csoPaymentMcardPdspk) {
        return (CsoPaymentMcardPds) super.find(CsoPaymentMcardPds.class, csoPaymentMcardPdspk);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csoPaymentMcardPds
     */
    public void update(CsoPaymentMcardPds csoPaymentMcardPds) {
        super.saveOrUpdate(csoPaymentMcardPds);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoPaymentMcardPds.class);
    }

    @Override
    public CsoPaymentMcardPds executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

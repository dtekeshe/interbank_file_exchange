package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsoPaymentInstructionsVisa;
import com.bsva.entities.CsoPaymentInstructionsVisaPK;

/**
 * @author AugustineA
 *
 */
public class CsoPaymentInstructionsVisaDao extends AbstractDao<CsoPaymentInstructionsVisa, CsoPaymentInstructionsVisaPK> {

    public CsoPaymentInstructionsVisaDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csoPaymentInstructionsVisa
     */
    public void create(CsoPaymentInstructionsVisa csoPaymentInstructionsVisa) {
        super.saveOrUpdate(csoPaymentInstructionsVisa);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csoPaymentInstructionsVisa
     */
    public void delete(CsoPaymentInstructionsVisa csoPaymentInstructionsVisa) {
        super.delete(csoPaymentInstructionsVisa);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csoPaymentInstructionsVisapk
     * @return
     */
    public CsoPaymentInstructionsVisa find(CsoPaymentInstructionsVisaPK csoPaymentInstructionsVisapk) {
        return (CsoPaymentInstructionsVisa) super.find(CsoPaymentInstructionsVisa.class, csoPaymentInstructionsVisapk);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csoPaymentInstructionsVisa
     */
    public void update(CsoPaymentInstructionsVisa csoPaymentInstructionsVisa) {
        super.saveOrUpdate(csoPaymentInstructionsVisa);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoPaymentInstructionsVisa.class);
    }

    @Override
    public CsoPaymentInstructionsVisa executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

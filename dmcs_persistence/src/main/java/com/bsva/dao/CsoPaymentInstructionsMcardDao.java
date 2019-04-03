package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsoPaymentInstructionsMcard;
import com.bsva.entities.CsoPaymentInstructionsMcardPK;
import java.util.ArrayList;
import org.hibernate.Query;

/**
 * @author AugustineA
 *
 */
public class CsoPaymentInstructionsMcardDao extends AbstractDao<CsoPaymentInstructionsMcard, CsoPaymentInstructionsMcardPK> {

    public CsoPaymentInstructionsMcardDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csoPaymentInstructionsMcard
     */
    public void create(CsoPaymentInstructionsMcard csoPaymentInstructionsMcard) {
        super.saveOrUpdate(csoPaymentInstructionsMcard);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csoPaymentInstructionsMcard
     */
    public void delete(CsoPaymentInstructionsMcard csoPaymentInstructionsMcard) {
        super.delete(csoPaymentInstructionsMcard);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csoPaymentInstructionsMcardpk
     * @return
     */
    public CsoPaymentInstructionsMcard find(CsoPaymentInstructionsMcardPK csoPaymentInstructionsMcardpk) {
        return (CsoPaymentInstructionsMcard) super.find(CsoPaymentInstructionsMcard.class, csoPaymentInstructionsMcardpk);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csoPaymentInstructionsMcard
     */
    public void update(CsoPaymentInstructionsMcard csoPaymentInstructionsMcard) {
        super.saveOrUpdate(csoPaymentInstructionsMcard);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoPaymentInstructionsMcard.class);
    }

    @Override
    public CsoPaymentInstructionsMcard executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

    public List getList(String fileRefNumber) {

//        List<CsoPaymentInstructionsMcard> csoPaymentInstructionsMcardList = new ArrayList<>();
//
//        try {
//            startOperation();
//
//            Query query = getSession().getNamedQuery("CsoPaymentInstructionsMcard.findByFileRefNumber1");
//            query.setParameter("fileRefNumber1", fileRefNumber);
//            csoPaymentInstructionsMcardList = query.list();
//
//            getTx().commit();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            getSession().close();
//        }
//
//        return csoPaymentInstructionsMcardList;
        return null;
    }
}

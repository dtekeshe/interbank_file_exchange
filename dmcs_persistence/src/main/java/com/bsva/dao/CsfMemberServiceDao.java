package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfMemberService;
import com.bsva.entities.CsfMemberServicePK;

/**
 * @author AugustineA
 *
 */
public class CsfMemberServiceDao extends AbstractDao<CsfMemberService, CsfMemberServicePK> {

    public CsfMemberServiceDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfMemberService
     */
    public void create(CsfMemberService csfMemberService) {
        super.saveOrUpdate(csfMemberService);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfMemberService
     */
    public void delete(CsfMemberService csfMemberService) {
        super.delete(csfMemberService);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csfMemberServicepk
     * @return
     */
    public CsfMemberService find(CsfMemberServicePK csfMemberServicepk) {
        return (CsfMemberService) super.find(CsfMemberService.class, csfMemberServicepk);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfMemberService
     */
    public void update(CsfMemberService csfMemberService) {
        super.saveOrUpdate(csfMemberService);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfMemberService.class);
    }

    @Override
    public CsfMemberService executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

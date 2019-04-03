package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfMembers;


/**
 * @author AugustineA
 *
 */
public class CsfMembersDao extends AbstractDao<CsfMembers, Short> {

    public CsfMembersDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfMembers
     */
    public void create(CsfMembers csfMembers) {
        super.saveOrUpdate(csfMembers);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfMembers
     */
    public void delete(CsfMembers csfMembers) {
        super.delete(csfMembers);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsfMembers find(Short string) {
        return (CsfMembers) super.find(CsfMembers.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfMembers
     */
    public void update(CsfMembers csfMembers) {
        super.saveOrUpdate(csfMembers);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfMembers.class);
    }

    @Override
    public CsfMembers executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfCardTypes;

/**
 * @author AugustineA
 *
 */
public class CsfCardTypesDao extends AbstractDao<CsfCardTypes, Short> {

    public CsfCardTypesDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfCardTypes
     */
    public void create(CsfCardTypes csfCardTypes) {
        super.saveOrUpdate(csfCardTypes);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfCardTypes
     */
    public void delete(CsfCardTypes csfCardTypes) {
        super.delete(csfCardTypes);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsfCardTypes find(String string) {
        return (CsfCardTypes) super.find(CsfCardTypes.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfCardTypes
     */
    public void update(CsfCardTypes csfCardTypes) {
        super.saveOrUpdate(csfCardTypes);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll()  {
        return super.findAll(CsfCardTypes.class);
    }    

    @Override
    public CsfCardTypes executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

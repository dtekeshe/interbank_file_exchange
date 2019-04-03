package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfInputFileFields;

/**
 * @author AugustineA
 *
 */
public class CsfInputFileFieldsDao extends AbstractDao<CsfInputFileFields, Short> {

    public CsfInputFileFieldsDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfInputFileFields
     */
    public void create(CsfInputFileFields csfInputFileFields) {
        super.saveOrUpdate(csfInputFileFields);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfInputFileFields
     */
    public void delete(CsfInputFileFields csfInputFileFields) {
        super.delete(csfInputFileFields);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsfInputFileFields find(Short string) {
        return (CsfInputFileFields) super.find(CsfInputFileFields.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfInputFileFields
     */
    public void update(CsfInputFileFields csfInputFileFields) {
        super.saveOrUpdate(csfInputFileFields);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfInputFileFields.class);
    }

    @Override
    public CsfInputFileFields executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

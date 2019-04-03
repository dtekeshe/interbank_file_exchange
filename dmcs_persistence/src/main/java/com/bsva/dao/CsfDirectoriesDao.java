package com.bsva.dao;

import java.util.List;
import java.util.Map;

import com.bsva.entities.CsfDirectories;

/**
 * @author AugustineA
 *
 */
public class CsfDirectoriesDao extends AbstractDao<CsfDirectories, String> {

    public CsfDirectoriesDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfDirectories
     */
    public void create(CsfDirectories csfDirectories) {
        super.saveOrUpdate(csfDirectories);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfDirectories
     */
    public void delete(CsfDirectories csfDirectories) {
        super.delete(csfDirectories);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsfDirectories find(String string) {
        return (CsfDirectories) super.find(CsfDirectories.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfDirectories
     */
    public void update(CsfDirectories csfDirectories) {
        super.saveOrUpdate(csfDirectories);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfDirectories.class);
    }

    @Override
    public CsfDirectories executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

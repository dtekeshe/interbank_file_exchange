package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsoOdsFileToLoad;

/**
 * @author AugustineA
 *
 */
public class CsoOdsFileToLoadDao extends AbstractDao<CsoOdsFileToLoad, String> {

    public CsoOdsFileToLoadDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csoOdsFileToLoad
     */
    public void create(CsoOdsFileToLoad csoOdsFileToLoad) {
        super.saveOrUpdate(csoOdsFileToLoad);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csoOdsFileToLoad
     */
    public void delete(CsoOdsFileToLoad csoOdsFileToLoad) {
        super.delete(csoOdsFileToLoad);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsoOdsFileToLoad find(String string) {
        return (CsoOdsFileToLoad) super.find(CsoOdsFileToLoad.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csoOdsFileToLoad
     */
    public void update(CsoOdsFileToLoad csoOdsFileToLoad) {
        super.saveOrUpdate(csoOdsFileToLoad);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoOdsFileToLoad.class);
    }

    @Override
    public CsoOdsFileToLoad executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

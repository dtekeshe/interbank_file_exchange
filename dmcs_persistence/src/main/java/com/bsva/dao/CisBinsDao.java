package com.bsva.dao;

import java.util.List;
import java.util.Map;

import com.bsva.entities.CisBins;
import com.bsva.utils.DataAccessLayerException;

/**
 * @author AugustineA
 *
 */
public class CisBinsDao extends AbstractDao<CisBins, String> {

    public CisBinsDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param cisBins
     */
    public void create(CisBins cisBins) throws DataAccessLayerException {
        super.saveOrUpdate(cisBins);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param cisBins
     */
    public void delete(CisBins cisBins) throws DataAccessLayerException {
        super.delete(cisBins);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CisBins find(String string) throws DataAccessLayerException {
        return (CisBins) super.find(CisBins.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param cisBins
     */
    public void update(CisBins cisBins) throws DataAccessLayerException {
        super.saveOrUpdate(cisBins);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() throws DataAccessLayerException {
        return super.findAll(CisBins.class);
    }

    @Override
    public CisBins executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

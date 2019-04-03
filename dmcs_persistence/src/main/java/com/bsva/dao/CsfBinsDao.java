package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfBins;

/**
 * @author AugustineA
 *
 */
public class CsfBinsDao extends AbstractDao<CsfBins, String> {

    public CsfBinsDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfBins
     */
    public void create(CsfBins csfBins) {
        super.saveOrUpdate(csfBins);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfBins
     */
    public void delete(CsfBins csfBins) {
        super.delete(csfBins);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsfBins find(String string) {
        return (CsfBins) super.find(CsfBins.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfBins
     */
    public void update(CsfBins csfBins) {
        super.saveOrUpdate(csfBins);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfBins.class);
    }

    @Override
    public CsfBins executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

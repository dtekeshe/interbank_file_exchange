package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfSystemService;

/**
 * @author AugustineA
 *
 */
public class CsfSystemServiceDao extends AbstractDao<CsfSystemService, String> {

    public CsfSystemServiceDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfSystemService
     */
    public void create(CsfSystemService csfSystemService) {
        super.saveOrUpdate(csfSystemService);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfSystemService
     */
    public void delete(CsfSystemService csfSystemService) {
        super.delete(csfSystemService);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsfSystemService find(String string) {
        return (CsfSystemService) super.find(CsfSystemService.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfSystemService
     */
    public void update(CsfSystemService csfSystemService) {
        super.saveOrUpdate(csfSystemService);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfSystemService.class);
    }

    @Override
    public CsfSystemService executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

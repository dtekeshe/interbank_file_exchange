package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfSystemSettings;

/**
 * @author AugustineA
 *
 */
public class CsfSystemSettingsDao extends AbstractDao<CsfSystemSettings, String> {

    public CsfSystemSettingsDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfSystemSettings
     */
    public void create(CsfSystemSettings csfSystemSettings) {
        super.saveOrUpdate(csfSystemSettings);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfSystemSettings
     */
    public void delete(CsfSystemSettings csfSystemSettings)  {
        super.delete(csfSystemSettings);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsfSystemSettings find(String string) {
        return (CsfSystemSettings) super.find(CsfSystemSettings.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfSystemSettings
     */
    public void update(CsfSystemSettings csfSystemSettings) {
        super.saveOrUpdate(csfSystemSettings);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfSystemSettings.class);
    }

    @Override
    public CsfSystemSettings executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsfAsciiEbcdic;

/**
 * @author AugustineA
 *
 */
public class CsfAsciiEbcdicDao extends AbstractDao<CsfAsciiEbcdic, Short> {

    public CsfAsciiEbcdicDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param asciiEbcdic
     */
    public void create(CsfAsciiEbcdic asciiEbcdic) {
        super.saveOrUpdate(asciiEbcdic);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param asciiEbcdic
     */
    public void delete(CsfAsciiEbcdic asciiEbcdic) {
        super.delete(asciiEbcdic);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsfAsciiEbcdic find(String string) {
        return (CsfAsciiEbcdic) super.find(CsfAsciiEbcdic.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param asciiEbcdic
     */
    public void update(CsfAsciiEbcdic asciiEbcdic) {
        super.saveOrUpdate(asciiEbcdic);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsfAsciiEbcdic.class);
    }

    @Override
    public CsfAsciiEbcdic executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

package com.bsva.dao;

import java.util.List;
import java.util.Map;

import com.bsva.entities.CsfReportNames;
import com.bsva.utils.DataAccessLayerException;

/**
 * @author AugustineA
 *
 */
public class CsfReportNamesDao extends AbstractDao<CsfReportNames, String> {

    public CsfReportNamesDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csfReportNames
     */
    public void create(CsfReportNames csfReportNames) throws DataAccessLayerException {
        super.saveOrUpdate(csfReportNames);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfReportNames
     */
    public void delete(CsfReportNames csfReportNames) throws DataAccessLayerException {
        super.delete(csfReportNames);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public CsfReportNames find(String string) throws DataAccessLayerException {
        return (CsfReportNames) super.find(CsfReportNames.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfReportNames
     */
    public void update(CsfReportNames csfReportNames) throws DataAccessLayerException {
        super.saveOrUpdate(csfReportNames);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() throws DataAccessLayerException {
        return super.findAll(CsfReportNames.class);
    }

    @Override
    public Object executeQuery(String query, Object... params) {
        return super.executeQuery(query, params);
    }

    @Override
    public Object executeCountQuery(String string) {
        return super.executeCountQuery(string);
    }

    @Override
    public Object executeMaxQuary(String string) {
        return super.executeMaxQuary(string);
    }

    @Override
    public List<Object[]> executeNamedQueryList(String query, Class class1) {

        return super.executeNamedQueryList(query, class1);
    }

    @Override
    public List<Object[]> executeNamedQueryObject(String query) {

        return super.executeNamedQueryObject(query);
    }

    @Override
    public List executeTypeQuery(String string) {

        return super.executeTypeQuery(string);
    }

    @Override
    public Object executeNativeQuery(String query, Object... params) {
        return super.executeNativeQuery(query, params);
    }

    @Override
    public void deleteBulk(String deletequery) {
        super.deleteBulk(deletequery);
    }

    @Override
    public List executeQueryParameters(String query, Map<String, Object> parameters) {
        return super.executeQueryParameters(query, parameters);
    }

    @Override
    public CsfReportNames executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

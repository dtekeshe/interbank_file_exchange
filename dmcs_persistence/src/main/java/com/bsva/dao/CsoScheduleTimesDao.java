package com.bsva.dao;

import java.util.List;
import java.util.Map;

import com.bsva.entities.CsoScheduleTimes;
import com.bsva.entities.CsoScheduleTimesPK;
import com.bsva.utils.DataAccessLayerException;

/**
 * @author AugustineA
 *
 */
public class CsoScheduleTimesDao extends AbstractDao<CsoScheduleTimes, CsoScheduleTimesPK> {

    public CsoScheduleTimesDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csoScheduleTimes
     */
    public void create(CsoScheduleTimes csoScheduleTimes) throws DataAccessLayerException {
        super.saveOrUpdate(csoScheduleTimes);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csoScheduleTimes
     */
    public void delete(CsoScheduleTimes csoScheduleTimes) throws DataAccessLayerException {
        super.delete(csoScheduleTimes);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csoScheduleTimespk
     * @return
     */
    public CsoScheduleTimes find(CsoScheduleTimesPK csoScheduleTimespk) throws DataAccessLayerException {
        return (CsoScheduleTimes) super.find(CsoScheduleTimes.class, csoScheduleTimespk);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csoScheduleTimes
     */
    public void update(CsoScheduleTimes csoScheduleTimes) throws DataAccessLayerException {
        super.saveOrUpdate(csoScheduleTimes);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() throws DataAccessLayerException {
        return super.findAll(CsoScheduleTimes.class);
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
    public CsoScheduleTimes executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

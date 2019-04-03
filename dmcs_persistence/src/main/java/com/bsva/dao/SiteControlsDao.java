package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.SiteControls;

/**
 * @author AugustineA
 *
 */
public class SiteControlsDao extends AbstractDao<SiteControls, String> {

    public SiteControlsDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param siteControls
     */
    public void create(SiteControls siteControls) {
        super.saveOrUpdate(siteControls);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param siteControls
     */
    public void delete(SiteControls siteControls) {
        super.delete(siteControls);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param string
     * @return
     */
    public SiteControls find(String string) {
        return (SiteControls) super.find(SiteControls.class, string);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param siteControls
     */
    public void update(SiteControls siteControls) {
        super.saveOrUpdate(siteControls);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(SiteControls.class);
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
    public SiteControls executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

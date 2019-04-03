package com.bsva.dao;

import java.util.List;
import java.util.Map;

import com.bsva.entities.CsfCardFeeBilateral;
import com.bsva.entities.CsfCardFeeBilateralPK;
import com.bsva.utils.DataAccessLayerException;
import org.hibernate.Query;

/**
 * @author AugustineA
 *
 */
public class CsfCardFeeBilateralDao extends AbstractDao<CsfCardFeeBilateral, CsfCardFeeBilateralPK> {

    public CsfCardFeeBilateralDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param obj
     */
    public void create(CsfCardFeeBilateral obj) throws DataAccessLayerException {
        super.saveOrUpdate(obj);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param obj
     */
    public void delete(CsfCardFeeBilateral obj) throws DataAccessLayerException {
        super.delete(obj);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csfCardFeeBilateralpk
     * @return
     */
    public CsfCardFeeBilateral find(CsfCardFeeBilateralPK csfCardFeeBilateralpk) throws DataAccessLayerException {
        return (CsfCardFeeBilateral) super.find(CsfCardFeeBilateral.class, csfCardFeeBilateralpk);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param obj
     */
    public void update(CsfCardFeeBilateral obj) throws DataAccessLayerException {
        super.saveOrUpdate(obj);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() throws DataAccessLayerException {
        return super.findAll(CsfCardFeeBilateral.class);
    }

    @Override
    public CsfCardFeeBilateral executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

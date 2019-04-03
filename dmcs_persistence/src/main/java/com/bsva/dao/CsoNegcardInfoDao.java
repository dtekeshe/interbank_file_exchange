package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsoNegcardInfo;
import com.bsva.entities.CsoNegcardInfoPK;

/**
 * @author AugustineA
 *
 */
public class CsoNegcardInfoDao extends AbstractDao<CsoNegcardInfo, CsoNegcardInfoPK> {

    public CsoNegcardInfoDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csoNegcardInfo
     */
    public void create(CsoNegcardInfo csoNegcardInfo) {
        super.saveOrUpdate(csoNegcardInfo);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csoNegcardInfo
     */
    public void delete(CsoNegcardInfo csoNegcardInfo) {
        super.delete(csoNegcardInfo);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csoNegcardInfopk
     * @return
     */
    public CsoNegcardInfo find(CsoNegcardInfoPK csoNegcardInfopk) {
        return (CsoNegcardInfo) super.find(CsoNegcardInfo.class, csoNegcardInfopk);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csoNegcardInfo
     */
    public void update(CsoNegcardInfo csoNegcardInfo) {
        super.saveOrUpdate(csoNegcardInfo);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoNegcardInfo.class);
    }

    @Override
    public CsoNegcardInfo executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

package com.bsva.dao;

import com.bsva.entities.CsoBillingSummary;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SimphiweT
 */
public class CsoBillingSummaryDao extends AbstractDao<CsoBillingSummary, Integer> {

    public CsoBillingSummaryDao() {
        super();
    }

    public void create(CsoBillingSummary csoBillingSummary) {
        super.save(csoBillingSummary);
    }

    public void delete(CsoBillingSummary csoBillingSummary) {
        super.delete(csoBillingSummary);
    }

    public CsoBillingSummary find(String string) {
        return (CsoBillingSummary) super.find(CsoBillingSummary.class, string);
    }

    public List findAll() {
        return super.findAll(CsoBillingSummary.class);
    }

    @Override
    public CsoBillingSummary executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}

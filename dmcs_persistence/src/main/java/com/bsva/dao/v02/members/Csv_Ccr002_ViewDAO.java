package com.bsva.dao.v02.members;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.CsvCcr002View;
import com.bsva.entities.CsvCcr002View_PK;
import com.bsva.entities.v02.members.MemberAddressEntity;

public class Csv_Ccr002_ViewDAO extends AbstractDao<CsvCcr002View,Void> {

	private static final String CSV_CCR002_VIEW_SQL =
            " SELECT ISSUER_MEMBER, ISSUER_CODE, ACQUIRER_MEMBER, ACQUIRER_CODE ,SERVICE,SUB_SERVICE,ACQ_FEES,ISS_FEES,NETT_FEES,INVOICE_NO_CCR001" +
            "   FROM CSV_CCR002_VIEW  WHERE SUB_SERVICE = :subServiceID ";

    public List<CsvCcr002View> getCsvViewList() {

        // execute
        List<CsvCcr002View> entities
                = list(CSV_CCR002_VIEW_SQL, CsvCcr002View.class);

        // prepare result
        List<CsvCcr002View> params = new ArrayList<>();
        for (CsvCcr002View entity : entities) {
            params.add(entity);
        }

        return params;
    }
    
    public Map<Integer, CsvCcr002View> getCCR002Reports(String subServiceID) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("subServiceID", subServiceID);

        // execute
        List<CsvCcr002View> entities
                = list(CSV_CCR002_VIEW_SQL, params, CsvCcr002View.class);

        // prepare result
        Map<Integer, CsvCcr002View> addresses = new HashMap<>();

        for ( CsvCcr002View entity : entities ) {
            addresses.put(Integer.valueOf(entity.getCsvCcr015ViewPK().getAcquireCode()), entity);
        }

        return addresses;
    }

}

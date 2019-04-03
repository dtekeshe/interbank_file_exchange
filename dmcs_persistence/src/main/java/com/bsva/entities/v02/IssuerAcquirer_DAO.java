package com.bsva.entities.v02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;

public class IssuerAcquirer_DAO extends AbstractDao<Void, Void> {

    private final static String INSERT_ACQUIRER_ISSUER =
            "   INSERT INTO CSO_ACQUIRER_ISSUER_PAIR ( " +
                    " ISSUER_MEMBER, ACQUIRER_MEMBER)    " +
            "   VALUES ( :issuerMember, :acquirerMember)";
    
    private final static String INSERT_ACQUIRER_ISSUERS = "INSERT INTO CSO_ACQUIRER_ISSUER_PAIR(ISSUER_MEMBER,ACQUIRER_MEMBER,STATUS) "+
    "SELECT :issuerMember, :acquirerMember ,:status FROM dual MINUS  "+
   "SELECT ISSUER_MEMBER,ACQUIRER_MEMBER,STATUS FROM CSO_ACQUIRER_ISSUER_PAIR ";

    public void insert(List<IssuerAcquirerEntity> issAqcpair) {

        // prepare params
        List<Map<String, Object>> payload = new ArrayList<>();
        for (IssuerAcquirerEntity issAcq : issAqcpair) {
            Map<String, Object> params = new HashMap<>();
            params.put("status", issAcq.getStatus());
            params.put("issuerMember",Integer.valueOf(issAcq.getId().getIssuerMember()));
            params.put("acquirerMember",Integer.valueOf(issAcq.getId().getAcquirerMember()));
            payload.add(params);
        }

        // execute
        executeUpdate(INSERT_ACQUIRER_ISSUERS, payload);
    }

}

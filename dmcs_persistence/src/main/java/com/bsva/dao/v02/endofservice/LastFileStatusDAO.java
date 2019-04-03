package com.bsva.dao.v02.endofservice;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.endofservice.LastFileStatusEntity;
import com.bsva.entities.v02.endofservice.AcquirerIssuerPairKey;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Document
 */
public class LastFileStatusDAO extends AbstractDao<LastFileStatusEntity, Void> {

    // get last file status
    private final static String LAST_FILE_STATUS_SQL =
            
          " SELECT ORIGINATING_MEMBER, BANK_CODE, SERVICE, SUB_SERVICE, FULLFILEIND " +
          "  FROM  CSO_OUTPUT_CONTROLS  " +
          " WHERE ORIGINATING_MEMBER = :acquirerCode " +
          "   AND BANK_CODE = :issuerCode " +
          "   AND SERVICE = :serviceID " +
          "   AND SUB_SERVICE = :subServiceID " +
          "   AND SEQ_NUMBER = :seqNumber ";

    public String fileStatus(AcquirerIssuerPairKey id, String seqNumber ) {

        // prepare params
        Map<String, Object> params = new HashMap<>();

        params.put("acquirerCode", id.getAcquirerCode());
        params.put("issuerCode",   id.getIssuerCode());
        params.put("serviceID",    id.getServiceID());
        params.put("subServiceID", id.getSubServiceID());
        params.put("seqNumber",    seqNumber);

        // execute
        LastFileStatusEntity entity
                = uniqueResult(LAST_FILE_STATUS_SQL,params, LastFileStatusEntity.class);

        // prepare result
        String fileStatus = entity.getFileStatus();

        return fileStatus;
    }
}

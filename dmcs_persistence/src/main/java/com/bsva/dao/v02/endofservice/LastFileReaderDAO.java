package com.bsva.dao.v02.endofservice;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.outputcontrols.OutputControlDayTotalEntity;
import com.bsva.entities.v02.outputcontrols.OutputControlEntity;
import com.bsva.entities.v02.outputcontrols.OutputControlKey;
import com.bsva.entities.v02.outputcontrols.OutputControlPKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class LastFileReaderDAO extends AbstractDao<OutputControlEntity, Void> {

    private final static String LAST_FILE_SQL =
            
            " SELECT SERVICE, SUB_SERVICE,                                                                          " +
            "        MAX(ORIGINATING_MEMBER) AS ACQUIRING_BANK_CODE, BANK_CODE AS ISSUING_BANK_CODE,                " +
            "        MAX(DISTRIBUTION_CODE) AS DISTRIBUTION_CODE, FILENAME_PREFIX,                                  " +
            "        MAX(FILENAME_DESCRIPTION) AS FILENAME_DESCRIPTION, MAX(RECORD_COUNT) AS RECORD_COUNT,          " +
            "        SUM(DR_VALUE) AS DR_VALUE, MAX(FULLFILEIND) AS FULLFILEIND,                                    " +
            "        MAX(SEQ_NUMBER) AS SEQ_NUMBER                                                                  " +
            "    FROM CSO_OUTPUT_CONTROLS                                                                           " +
            "    WHERE BANK_CODE          = :issuingBankCode                                                        " +
            "      AND SERVICE            = :serviceID                                                              " +
            "      AND SUB_SERVICE        = :subServiceID                                                           " +
            " GROUP BY BANK_CODE, SERVICE, SUB_SERVICE, FILENAME_PREFIX                                             ";

    /**
     * Last file to this issuer regardless of acquirer
     */
    public OutputControlEntity read(OutputControlDayTotalEntity dayTotal) {

        System.out.println("EOSERVICE 20 GET LAST FILE TO ISSUER : " + dayTotal.getId().getIssuingBankCode());

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("issuingBankCode",   dayTotal.getId().getIssuingBankCode());
        params.put("serviceID",         dayTotal.getId().getServiceID());
        params.put("subServiceID",      dayTotal.getId().getSubServiceID());

        // execute
        OutputControlEntity lastFile
                = uniqueResult(LAST_FILE_SQL, params, OutputControlEntity.class);

        return lastFile != null ? lastFile : null;
    }
}

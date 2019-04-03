package com.bsva.dao.v02.endofservice;

import com.bsva.dao.AbstractDao;
import com.bsva.dto.Justification;
import com.bsva.entities.v02.outputcontrols.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bsva.dao.v02.util.StringUtils.format;

/**
 * TODO Document
 */
public class Record98BuilderLastFilesReaderDAO extends AbstractDao<LastFileOutputControlEntity, Void> {

    private final static String READ_LAST_FILES_SQL =
            "   SELECT SERVICE, SUB_SERVICE, DISTRIBUTION_CODE, BANK_CODE AS ISSUING_BANK_CODE, FILENAME_PREFIX,    " +
            "          MAX(SEQ_NUMBER) AS SEQ_NUMBER                                                                " +
            "     FROM CSO_OUTPUT_CONTROLS                                                                          " +
            "    WHERE SERVICE      = :serviceID                                                                    " +
            "      AND SUB_SERVICE  = :subServiceID                                                                 " +
            "      AND FULLFILEIND  IN ('N', 'D')                                                                   " +
            "    GROUP BY SERVICE, SUB_SERVICE, DISTRIBUTION_CODE, BANK_CODE, FILENAME_PREFIX                       ";

    /*
    private final static String READ_LAST_FULL_FILE_SQL =
            "   SELECT SERVICE, SUB_SERVICE, DISTRIBUTION_CODE, BANK_CODE AS ISSUING_BANK_CODE, FILENAME_PREFIX,    " +
                    "          MAX(SEQ_NUMBER) AS SEQ_NUMBER                                                        " +
                    "     FROM CSO_OUTPUT_CONTROLS                                                                  " +
                    "    WHERE SERVICE      = :serviceID                                                            " +
                    "      AND SUB_SERVICE  = :subServiceID                                                         " +
                    "      AND DISTRIBUTION_CODE = :distributionCode                                                " +
                    "      AND FULLFILEIND  = 'F'                                                                   " +
                    "    GROUP BY SERVICE, SUB_SERVICE, DISTRIBUTION_CODE, BANK_CODE, FILENAME_PREFIX               ";

    private final static String READ_DEFAULT_FILE_SQL =
            "   SELECT SERVICE, SUB_SERVICE, DISTRIBUTION_CODE, BANK_CODE AS ISSUING_BANK_CODE, FILENAME_PREFIX,    " +
            "          MIN(SEQ_NUMBER) AS SEQ_NUMBER                                                                " +
            "     FROM CSO_OUTPUT_CONTROLS                                                                          " +
            "    WHERE SERVICE           = :serviceID                                                               " +
            "      AND SUB_SERVICE       = :subServiceID                                                            " +
            "      AND FULLFILEIND       = 'D'                                                                      " +
            "      AND DISTRIBUTION_CODE = :distributionCode                                                        " +
            "      AND SEQ_NUMBER        > :minSeqNumber                                                            " +
            "    GROUP BY SERVICE, SUB_SERVICE, DISTRIBUTION_CODE, BANK_CODE, FILENAME_PREFIX                       ";
    */

    public Map<LastFileOutputControlKey, String> readLastFileSeqNumbers( String serviceID,
                                                                         String subServiceID) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("serviceID", serviceID);
        params.put("subServiceID", subServiceID);

        // execute
        List<LastFileOutputControlEntity> files
                = list(READ_LAST_FILES_SQL, params, LastFileOutputControlEntity.class);

        // prepare result
        Map<LastFileOutputControlKey, String> seqNumbers = new HashMap<>();
        for (LastFileOutputControlEntity file : files) {
            seqNumbers.put(file.getId(), file.getSeqNumber());
        }

        return seqNumbers;
    }

    /*
    public String readDefaultFile(LastFileOutputControlKey file) {

        // Default file lookup means there is no partial file to carry Rec 98
        // We look for a Default File, fullFileIndicator = 'D' that is after the last full file.
        String serviceID = file.getServiceID();
        String subServiceID = file.getSubServiceID();
        String distributionCode = file.getDistributionCode();

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("serviceID", serviceID);
        params.put("subServiceID", subServiceID);
        params.put("distributionCode", distributionCode);

        // execute
        LastFileOutputControlEntity fullFile = null;
        try {
            fullFile = uniqueResult(READ_LAST_FULL_FILE_SQL, params, LastFileOutputControlEntity.class);
        } catch (Exception e) {
        }

        // set seq number to minimum.
        int minSeqNumber = 0;

        if (fullFile != null) {
            minSeqNumber = Integer.parseInt(fullFile.getSeqNumber());
        }

        // prepare params for get default file
        params.put("minSeqNumber", format("" + minSeqNumber, 3, '0', Justification.RIGHT));

        // execute
        LastFileOutputControlEntity defaultFile = null;
        try {
            defaultFile = uniqueResult(READ_DEFAULT_FILE_SQL, params, LastFileOutputControlEntity.class);
        } catch (Exception e) {
        }


        return defaultFile != null ? defaultFile.getSeqNumber() : null;
    }
    */
}

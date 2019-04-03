package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.dto.Filename;
import com.bsva.dto.Justification;
import com.bsva.dto.OriginDestinationPair;
import com.bsva.entities.v02.outputcontrols.OutputControlEntity;
import com.bsva.entities.v02.outputcontrols.OutputControlKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class OutputControlUpdateDAO extends AbstractDao<OutputControlEntity, Void> {
    
    private static final String OUTPUT_CONTROL_UPDATE_SQL =

            "       UPDATE CSO_OUTPUT_CONTROLS                                                                      " +
            "          SET  RECORD_COUNT = :recordCount,                                                            " +
            "               CR_VOLUME    = :crVolume,                                                               " +
            "               CR_VALUE     = :crValue,                                                                " +
            "               DR_VOLUME    = :drVolume,                                                               " +
            "               DR_VALUE     = :drValue,                                                                " +
            "               FULLFILEIND  = :fullFileInd                                                             " +
           // "               WHERE FILENAME_DESCRIPTION = :filename                                                  ";
            "        WHERE BANK_CODE = :destCode                                                                    " +
            "          AND ORIGINATING_MEMBER = :originCode                                                         " +
            "          AND SERVICE = :serviceID                                                                     " +
            "          AND SUB_SERVICE = :subServiceID                                                              " +
            "          AND SEQ_NUMBER = :seqNumber                                                                  ";
    
    private static final String OUTPUT_CONTROL_INSERT_SQL =

            "       INSERT INTO CSO_OUTPUT_CONTROLS ( " +
            "               SERVICE, SUB_SERVICE, ORIGINATING_MEMBER, BANK_CODE,  DISTRIBUTION_CODE,                " +
            "               FILENAME_DESCRIPTION, FILENAME_PREFIX, SEQ_NUMBER,  FULLFILEIND,                        " +
            "               LAST_FILE_INDICATOR, NEG_CARD_COUNT, STATUS_CODE,                                       " +
            "               RECORD_COUNT, CR_VOLUME, CR_VALUE, DR_VOLUME, DR_VALUE  )                               " +
            "       VALUES( :serviceID, :subServiceID, :originCode,  :destCode, :distCode, :filename,               " +
            "               :filePrefix,:seqNumber,    :fullFileInd,                                                " +
            "               :lastFileIndicator, :negCardCount, :statusCode,                                         " +
            "               :recordCount, :crVolume,  :crValue, :drVolume, :drValue )                               ";

    public void updateOutputControls(Map<OriginDestinationPair, List<Filename>> outputControls) {

        for (OriginDestinationPair pair : outputControls.keySet()) {

            List<Filename> files = outputControls.get(pair);
            for (Filename file : files) {

                Long limit = file.getMaxTransactionCount();
                Long count = file.getTransactionCount();
                Long seqNumber = file.getSeqNumber();

                Map<String, Object> params = new HashMap<>();
                params.put("recordCount",  file.getTransactionCount());
                params.put("fullFileInd",  count >= limit ? "F" : (count > 0 ? "N" : "D"));
                params.put("destCode",     pair.getDestinationBankCode());
                params.put("originCode",   pair.getOriginBankCode());
                params.put("serviceID",    pair.getServiceID());
                params.put("subServiceID", pair.getSubServiceID());
                params.put("seqNumber",    format("" + seqNumber, 3, '0', Justification.RIGHT));
                params.put("crVolume",     file.getOutputFileCrVolume());
                params.put("crValue",      file.getOutputFileCrValue());
                params.put("drVolume",     file.getOutputFileDrVolume());
                params.put("drValue",      file.getOutputFileDrValue());
                //params.put("filename",     file.getFilename());

                String action = file.getActionRequired();
                if (action == null) {
                    continue;
                }
                switch(action) {
                    case "UPDATE":
                        executeUpdate(OUTPUT_CONTROL_UPDATE_SQL, params);
                        break;
                    case "INSERT":
                        params.put("filename",     file.getFilename());
                        params.put("filePrefix",   pair.getFilenamePrefix());
                        params.put("distCode",     pair.getDistributionCode() );
                        params.put("lastFileIndicator", "N");
                        params.put("negCardCount",    0);
                        params.put("statusCode",     "O" );
                        executeUpdate(OUTPUT_CONTROL_INSERT_SQL, params);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /*
    public void updateOutputControls(List<OutputControlEntity> entities) {

        // update if exists
        for (OutputControlEntity entity : entities) {

            // is this entity marked for update
            if (! "UPDATE".equals(entity.getActionRequired())) {
                continue;
            }

            OutputControlKey id = entity.getId();

            Map<String, Object> params = new HashMap<>();
            params.put("recordCount",  entity.getRecordCount());
            params.put("txnAmount",    entity.getTxnAmount());
            params.put("fullFileInd",  entity.getFullFileIndicator());
            params.put("destCode",     id.getIssuingBankCode());
            params.put("originCode",   id.getAcquiringBankCode());
            params.put("serviceID",    id.getServiceID());
            params.put("subServiceID", id.getSubServiceID());
            params.put("filename",     entity.getFilenameDescription());

            executeUpdate(OUTPUT_CONTROL_UPDATE_SQL, params);
        }

        // insert if not exist
        for (OutputControlEntity entity : entities) {

            // is this entity marked for insert
            if (! "INSERT".equals(entity.getActionRequired())) {
                continue;
            }

            // params
            OutputControlKey id = entity.getId();

            Map<String, Object> params = new HashMap<>();
            params.put("serviceID",    id.getServiceID());
            params.put("subServiceID", id.getSubServiceID() );
            params.put("originCode",   id.getAcquiringBankCode());
            params.put("destCode",     id.getIssuingBankCode());
            params.put("distCode",     entity.getDistributionCode() );
            params.put("filename",     entity.getFilenameDescription() );
            params.put("filePrefix",   entity.getFilenamePrefix());
            params.put("seqNumber",    entity.getSeqNumber());
            params.put("recordCount",  entity.getRecordCount());
            params.put("txnAmount",    entity.getTxnAmount());
            params.put("fullFileInd",  entity.getFullFileIndicator());

            // execute
            executeUpdate( OUTPUT_CONTROL_INSERT_SQL, params );
        }
    }
    */

    private static String format(String data, int len, char padChar, Justification justification) {
        if (data == null) {
            data = "";
        }

        if (data.length() > len) {
            return data.substring(0, len);
        }

        StringBuilder sb = new StringBuilder("" + data);
        while (sb.length() < len) {
            if (justification == Justification.RIGHT) {
                sb.insert(0, padChar);
            } else {
                sb.append(padChar);
            }
        }
        return sb.toString();
    }
}

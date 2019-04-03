package com.bsva.dao.v02.endofservice;

import com.bsva.dao.AbstractDao;
import com.bsva.dto.Justification;
import com.bsva.entities.v02.outputcontrols.*;

import java.util.HashMap;
import java.util.Map;

import static com.bsva.dao.v02.util.StringUtils.format;

/**
 * TODO Document
 */
public class OutputControlRecordDAO extends AbstractDao<Void, Void> {

    private static final String OUTPUT_CONTROL_INSERT_SQL =

            "       INSERT INTO CSO_OUTPUT_CONTROLS (                                                               " +
            "               SERVICE, SUB_SERVICE, ORIGINATING_MEMBER, BANK_CODE,  DISTRIBUTION_CODE,                " +
            "               FILENAME_DESCRIPTION, FILENAME_PREFIX, SEQ_NUMBER, RECORD_COUNT, DR_VALUE, FULLFILEIND, " +
            "               LAST_FILE_INDICATOR, NEG_CARD_COUNT, STATUS_CODE )                                      " +
            "       VALUES( :serviceID, :subServiceID, :originCode,  :destCode, :distCode, :filename,               " +
            "               :filePrefix,:seqNumber,    :recordCount, :txnAmount, :fullFileInd,                      " +
            "               :lastFileIndicator, :negCardCount, :statusCode ) ";

    public String insert( OutputControlDayTotalEntity outputControlEntity,
                          OutputControlEntity lastFile) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        LastFileOutputControlKey id = outputControlEntity.getId();
        params.put("serviceID",         id.getServiceID());
        params.put("subServiceID",      id.getSubServiceID());
        params.put("originCode",        0);
        params.put("destCode",          id.getIssuingBankCode());
        params.put("distCode",          id.getDistributionCode() );
        params.put("filePrefix",        outputControlEntity.getId().getFilenamePrefix() );
        params.put("recordCount",       "1" );
        params.put("txnAmount",         "0" );
        params.put("fullFileInd",       "N" );
        params.put("lastFileIndicator", "N" );
        params.put("negCardCount",      "0" );
        params.put("statusCode",        "O" );
        String lastFileSeqNumber = lastFile.getSeqNumber();
        String seqNumber = nextSeqNumber(lastFileSeqNumber);
        params.put("seqNumber",         seqNumber );
        String filename = filename(outputControlEntity, seqNumber);
        params.put("filename",          filename);

        executeUpdate(OUTPUT_CONTROL_INSERT_SQL, params);

        return seqNumber;
    }

    private String nextSeqNumber(String seqNumber) {
        Integer i = Integer.parseInt(seqNumber);
        String nextSeqNumber = format("" + (++i), 3, '0', Justification.RIGHT);

        return nextSeqNumber;
    }

    private String filename(OutputControlDayTotalEntity outputControlEntity, String seqNumber) {

        StringBuilder builder = new StringBuilder();
        builder
            .append(outputControlEntity.getId().getFilenamePrefix())
            .append(outputControlEntity.getId().getDistributionCode())
            .append(seqNumber)
            .append('D');

        return builder.toString();
    }
}

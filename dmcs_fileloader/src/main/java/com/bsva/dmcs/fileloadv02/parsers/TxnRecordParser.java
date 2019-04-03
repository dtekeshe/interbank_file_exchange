package com.bsva.dmcs.fileloadv02.parsers;

import com.bsva.dmcs.fileloadv02.dto.SubService;
import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.dmcs.fileloadv02.model.MemberInfoBean;
import com.bsva.dto.ErrorCode;
import com.bsva.dto.ErrorDTO;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO Document
 */
public abstract class TxnRecordParser {

    public abstract FileDetailDTO parse(
            AtomicLong fileSeqNumber,
            AtomicLong txnSeqNumber,
            String line,
            Long lineID,
            MemberInfoBean memberInfoBean,
            SubService subService,
            List<ErrorDTO> errors);

    protected void error( List<ErrorDTO> errors,
                        String recordID,
                        Long seq,
                        ErrorCode errorCode,
                        Integer fieldNumber,
                        String contents) {

        errors.add(new ErrorDTO(recordID, seq, errorCode, fieldNumber, contents));
    }

    protected void error( List<ErrorDTO> errors,
                          String recordID,
                          Long seq,
                          ErrorCode errorCode,
                          Integer fieldNumber,
                          String contents,
                          Double txnAmount) {

        errors.add(new ErrorDTO(recordID, seq, errorCode, fieldNumber, contents, txnAmount));
    }

    protected boolean hasErrors(Integer initErrorCount, Integer errorCount) {
        return errorCount > initErrorCount;
    }
}

package com.bsva.dmcs.fileloadv02.validators;

import com.bsva.dmcs.fileloadv02.dto.MemberRole;
import com.bsva.dmcs.fileloadv02.dto.SubService;
import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.dmcs.fileloadv02.model.MemberInfoBean;
import com.bsva.dmcs.fileloadv02.parsers.TxnRecordParser;
import com.bsva.dto.ErrorDTO;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.bsva.dto.ErrorCode.ACQ_BIN_DELETED;
import static com.bsva.dto.ErrorCode.ISS_BIN_DELETED;

/**
 *
 */
public class BINDatingValidator extends TxnRecordParser {

    public void validate(
                        FileDetailDTO record,
                        Integer txnCode,
                        MemberRole memberRole,
                        List<ErrorDTO> errors ) {

        Long daysBeforeFirst = record.getDaysBeforefirstDeletionDate();
        Long daysBeforeFinal = record.getDaysBeforefinalDeletionDate();
        if (daysBeforeFirst < 0 && daysBeforeFinal > 0 && ! "2".equals(record.getUsageCode()) ) {
            error(errors, null, record.getLineID(),
                    (memberRole == MemberRole.ACQUIRER ? ACQ_BIN_DELETED : ISS_BIN_DELETED ), 4, "" + txnCode);
        }

        if (daysBeforeFirst < 0 && daysBeforeFinal < 0) {
            error(errors, null, record.getLineID(),
                    (memberRole == MemberRole.ACQUIRER ? ACQ_BIN_DELETED : ISS_BIN_DELETED ), 4, "" + txnCode);
        }
    }

    @Override
    public FileDetailDTO parse( AtomicLong fileSeqNumber,
                                AtomicLong txnSeqNumber,
                                String line,
                                Long lineID,
                                MemberInfoBean memberInfoBean,
                                SubService subService,
                                List<ErrorDTO> errors) {
        return null;
    }
}

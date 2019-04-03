package com.bsva.dmcs.fileloadv02.validators;

import com.bsva.dmcs.fileloadv02.dto.SubService;
import com.bsva.dmcs.fileloadv02.model.MemberInfoBean;
import com.bsva.dmcs.fileloadv02.parsers.TxnRecordParser;
import com.bsva.dmcs.fileloadv02.dto.MemberRole;
import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.dto.ErrorDTO;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.bsva.dto.ErrorCode.*;

/**
 *
 */
public class BINValidator extends TxnRecordParser {

    private final BINDatingValidator binDatingValidator;

    public BINValidator() {
        binDatingValidator = new BINDatingValidator();
    }

    public boolean validate(FileDetailDTO record, List<ErrorDTO> errors) {

        int initErrorCount = errors.size();

        Integer txnCode = record.getTxnCode();
        Long lineID = record.getLineID();

        if ("-1".equals(record.getIssuerBin())  || "0".equals(record.getIssuerBin())){
            error(errors, null, lineID, INVALID_ISSUER_BIN, 4, "" + txnCode);
        }

        if ("-1".equals(record.getAcquirerBin())  || "0".equals(record.getAcquirerBin())){
            error(errors, null, lineID, INVALID_ACQUIRER_BIN, 4, "" + txnCode);
        }

        if ( ! "-1".equals(record.getIssuerBin()) && ! "0".equals(record.getIssuerBin())){

            // is this BIN allowed to issue
            if (record.getMemberRole() != MemberRole.ISSUER && record.getMemberRole() != MemberRole.ACQUIRER_ISSUER) {
                error(errors, null, lineID, BIN_IS_ONLY_ACQUIRING_BIN, 4, "" + txnCode);
            }
        }

        // BIN dating validation
        if (! "-1".equals(record.getAcquirerBin())  && ! "0".equals(record.getAcquirerBin()) &&
                ( record.getMemberRole() == MemberRole.ACQUIRER_ISSUER
                        || record.getMemberRole() == MemberRole.ACQUIRER) ) {

            binDatingValidator.validate(record, txnCode, MemberRole.ACQUIRER, errors);
        }

        if ( ! "-1".equals(record.getIssuerBin()) && !"0".equals(record.getIssuerBin()) &&
                ( record.getMemberRole() == MemberRole.ACQUIRER_ISSUER
                        || record.getMemberRole() == MemberRole.ISSUER) ) {

            binDatingValidator.validate(record, txnCode, MemberRole.ISSUER, errors);
        }

        return hasErrors(initErrorCount, errors.size());
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

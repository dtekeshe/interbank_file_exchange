package com.bsva.dmcs.fileloadv02.billing;

import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.dmcs.fileloadv02.model.TCRCode;
import com.bsva.dmcs.reportv02.util.Justification;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.bsva.dmcs.reportv02.util.StringUtils.*;

/**
 * TODO Document
 */
public class VISATCR5Constructor {

    private final static String TCR5_TEMPLATE =
            "000000000000000000000000000000000000        0000 000000000000                              000000000000000C";

    public static void addTCR5Record( List<FileDetailDTO> payLines) {

        FileDetailDTO payLine = findTCR5Record(payLines);
        FileDetailDTO tcr0PayLine = payLines.get(0);

        if (tcr0PayLine.getBillingData() == null) {
            return;
        }

        if (payLine == null) {
            // TCR5 not present, construct one
            // Get properties from TCR0. Not ideal. TODO fix
            AtomicLong fileSeqNumber = tcr0PayLine.getFileSeqNumber();
            AtomicLong txnSeqNumber = tcr0PayLine.getTxnSeqNumber();
            Long lineID = tcr0PayLine.getLineID() + 2;
            Integer txnCode = tcr0PayLine.getTxnCode();
            payLine = new FileDetailDTO(fileSeqNumber, txnSeqNumber, TCR5_TEMPLATE, lineID, txnCode, TCRCode.TCR5);
        }

        String line = payLine.getInput();

        /*
        TCR5Record tcr5 = new TCR5Record();
        tcr5.setTxnCode(         substring(line, 0, 2));
        tcr5.setTxnNumber(       substring(line, 2, 4));
        tcr5.setAuthAmount(      parseLong(line, 19, 31));
        tcr5.setAuthCurrency(    substring(line, 31, 34));
        tcr5.setInterchangeFee(  parseLong(line,  91, 104));
        tcr5.setInterchangeSign( substring(line, 106, 107));
        */

        // prima TCR5 record
        line = replace(line, format(payLine.getTxnCode(), 2, '0', Justification.RIGHT), 0, 2);
        line = replace(line, "05", 2, 4);
        line = replace(line, format(tcr0PayLine.getAmount().longValue(), 12, '0', Justification.RIGHT), 19, 31);
        line = replace(line, "710", 31, 34);
        line = replace(line, format(
                                tcr0PayLine.getBillingData().getTransactionFee().longValue(),
                                12, '0', Justification.RIGHT), 91, 104);
        line = replace(line, "C", 106, 107);

        payLine.setInput(line);
    }

    private static FileDetailDTO findTCR5Record(List<FileDetailDTO> payLines) {

        for (FileDetailDTO payLine : payLines) {
            if (payLine.getTcrCode() == TCRCode.TCR5) {
                return payLine;
            }
        }

        return null;
    }
}

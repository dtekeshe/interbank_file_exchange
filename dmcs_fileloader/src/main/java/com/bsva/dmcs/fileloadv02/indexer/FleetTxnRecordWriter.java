package com.bsva.dmcs.fileloadv02.indexer;

import com.bsva.dmcs.fileloadv02.dto.Justification;
import com.bsva.dto.FleetBindResolvedDTO;
import com.bsva.entities.v02.billing.FleetBillingTxnEntity;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.bsva.dmcs.fileloadv02.util.StringUtils.format;

/**
 * TODO Document
 */
public class FleetTxnRecordWriter {

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void write(PrintWriter out,
                             Long fileSystemSeqNumber,
                             AtomicLong lineID, List<FleetBillingTxnEntity> txns) {

        for (FleetBillingTxnEntity txn : txns) {

            lineID.incrementAndGet();

            Date processDate = new Date(txn.getTxnDateTime());

            String s =
                    format(txn.getServiceID(),              4,  ' ', Justification.LEFT) +
                    format(txn.getSubServiceID(),           10, ' ', Justification.LEFT) +
                    format(txn.getIssuerCode(),             4,  ' ', Justification.LEFT) +
                    format(txn.getAcquirerCode(),           4,  ' ', Justification.LEFT) +
                    format(txn.getAccountNumber(),          19, ' ', Justification.LEFT) +
                    format(txn.getTxnCode(),                2,  ' ', Justification.LEFT) +
                    format(txn.getTxnDateTime(),    14, ' ', Justification.LEFT) +
                    format(txn.getCardType(),               2,  ' ', Justification.LEFT) +
                    format(fileSystemSeqNumber,             11, ' ', Justification.LEFT) +
                    format(txn.getSystemSeqNumber(),        11, ' ', Justification.LEFT) +
                    DATE_FORMAT.format(processDate)                                      +
                    format(txn.getAmount(),                 12, ' ', Justification.LEFT) +
                    format(txn.getTxnCount(),               3,  ' ', Justification.LEFT) +
            		format(txn.getAcquirerBin(),            6,  ' ', Justification.LEFT);

            out.println(s);
        }
    }
}

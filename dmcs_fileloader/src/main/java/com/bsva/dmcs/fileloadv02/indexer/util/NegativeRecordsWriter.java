package com.bsva.dmcs.fileloadv02.indexer.util;

import com.bsva.dmcs.fileloadv02.dto.Justification;
import com.bsva.dmcs.fileloadv02.dto.NegativeRecordDTO;
import com.bsva.dmcs.fileloadv02.model.BillingData;
import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.dmcs.fileloadv02.model.TerminalInfo;
import com.bsva.dto.FileHeaderDTO;

import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import static com.bsva.dmcs.fileloadv02.util.StringUtils.format;
import static com.bsva.dmcs.fileloadv02.util.StringUtils.replace;

/**
 * TODO Document
 */
public class NegativeRecordsWriter {

    public void write(PrintWriter out,
                      final long fileSeqNumber,
                      Set<NegativeRecordDTO> negativeRecords) {

        int idx = 1;
        for (NegativeRecordDTO record : negativeRecords) {

            String s =
                    format(fileSeqNumber, 16, ' ', Justification.LEFT) +
                    format((++idx),       10, ' ', Justification.LEFT) +
                    format(record.getTransactionCode(),    2, ' ', Justification.LEFT) +
                    format(record.getDestBinNumber(),      6, ' ', Justification.LEFT) +
                    format(record.getSourceBinNumber(),    6, ' ', Justification.LEFT) +
                    format(idx,                            6, ' ', Justification.LEFT) +
                    format(record.getTransactionType(),    1, ' ', Justification.LEFT) +
                    format(record.getAuthCentre(),         4, ' ', Justification.LEFT) +
                    format(record.getNegativeAccNumber(), 16, ' ', Justification.LEFT) +
                    format(record.getResponseCode(),       2, ' ', Justification.LEFT) +
                    format(record.getPurgeDate(),          4, ' ', Justification.LEFT) +
                    format(record.getRegionCode(),         2, ' ', Justification.LEFT) +
                    format(record.getCardHolderName(),    72, ' ', Justification.LEFT) +
                    format(record.getAcquirer(),           4, ' ', Justification.LEFT);

            out.println(s);
        }
    }
}
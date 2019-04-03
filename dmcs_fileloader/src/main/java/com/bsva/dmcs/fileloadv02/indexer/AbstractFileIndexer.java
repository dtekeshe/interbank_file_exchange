package com.bsva.dmcs.fileloadv02.indexer;

import com.bsva.dao.v02.SequenceReaderDAO;
import com.bsva.dao.v02.SequenceUpdateDAO;
import com.bsva.dao.v02.TransactionTypesDAO;
import com.bsva.dmcs.fileloadv02.dto.SubService;
import com.bsva.dmcs.fileloadv02.dto.TCRType;
import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.dmcs.fileloadv02.util.BinarySearch;
import com.bsva.dmcs.fileloadv02.util.Counter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import java.util.concurrent.atomic.AtomicLong;

import static com.bsva.dmcs.fileloadv02.util.StringUtils.parseInt;
import static com.bsva.dmcs.fileloadv02.util.DateUtils.dateFromMonthDay;

/**
 * TODO Document
 */
public abstract class AbstractFileIndexer {

    private final Integer[] txnTypes;
    private final Integer[] headerRecs;
    private final Integer[] trailerRecs;
    private final Integer[] secondaryHeaderRecs;
    // sequence reader and updater
    private SequenceReaderDAO sequenceReaderDAO;
    private SequenceUpdateDAO sequenceUpdateDAO;

    private Map<String, AtomicLong> sequences;

    protected AtomicLong fileSeqNumber;
    protected AtomicLong txnSeqNumber;

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmSS");

    public AbstractFileIndexer() {
        sequenceReaderDAO = new SequenceReaderDAO();
        sequenceUpdateDAO = new SequenceUpdateDAO();
        headerRecs = new Integer[]{1};
        secondaryHeaderRecs = new Integer[]{90};
        trailerRecs = new Integer[]{91,92, 98, 99};
        txnTypes = new TransactionTypesDAO().txnTypes();
    }

    protected void readSequences() {

        sequences = sequenceReaderDAO.sequences();

        fileSeqNumber = sequences.get("IN_FILE_CONT.SYSTEM_SEQ_NUMBER");
        txnSeqNumber  = sequences.get("TRANSACTIONS.SYSTEM_SEQ_NUMBER");
    }

    protected void updateSequences() {

        // update sequences
        sequenceUpdateDAO.update(sequences);
    }

    protected TCRType tcrType(String subServiceID, String line) {

        if (line == null) {
            return TCRType.END_OF_FILE;
        }

        Integer txnCode = line.length() > 1  ? parseInt(line.substring(0, 2).trim()) : -1;

        // is this a txn
        if (BinarySearch.search(txnCode, txnTypes)) {

            if ("MASTERCARD".equals(subServiceID)) {
                return TCRType.FINANCIAL;
            } else {
                String txnQualifier = line.length() > 3 ? line.substring(2, 4).trim()  : "";


                switch (txnQualifier) {
                    case "00":
                        return TCRType.FINANCIAL;
                    case "01":
                    case "99":
                    case "03":
                    case "05":
                    case "07":
                        return TCRType.NON_FINANCIAL;
                    default:
                        return TCRType.INVALID_TXN;
                }
            }
        }

        // is this a header record
        if ( BinarySearch.search(txnCode, headerRecs)) {
            return TCRType.HEADER;
        }

        // is this a secondary header record
        if ( BinarySearch.search(txnCode, secondaryHeaderRecs)) {
            return TCRType.SECONDARY_HEADER;
        }

        // is this a trailer record
        if ( BinarySearch.search(txnCode, trailerRecs)) {
            return TCRType.TRAILER;
        }
        if ("MASTERCARD".equals(subServiceID)) {
        	Integer zero = new Integer(0);
        	if(txnCode.intValue() == zero.intValue()){
        		return TCRType.INVALID_TXN;
        	}else{
        		return TCRType.FINANCIAL;
        	}
        }

        return TCRType.INVALID_REC;
    }

    protected Date getDateTime(List<FileDetailDTO> payLines) {

        String monthDayString = payLines.get(0).getMonthDay();
        String timeString = payLines.get(2).getTimeString();

        try {
            return dateFromMonthDay(monthDayString, timeString);
        } catch (ParseException e) {
            return null;
        }
    }

    protected void resetCounters() {
        Counter.reset();
    }
}

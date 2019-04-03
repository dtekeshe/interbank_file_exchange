package com.bsva.dmcs.operations.utils;

import com.bsva.dao.v02.endofservice.*;
import com.bsva.entities.v02.outputcontrols.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class Record98Builder {

    public static Map<LastFileOutputControlKey, OutputControlDayTotalEntity>
                    build(String serviceID, String subServiceID) {

        System.out.println("EOSERVICE 20 DAY TOTALS CALCULATOR STARTED");
        Record98BuilderUpdateDAO updateDAO
                = new Record98BuilderUpdateDAO();
        OutputControlRecordDAO recordDAO
                = new OutputControlRecordDAO();
        LastFileReaderDAO lastFileReaderDAO
                = new LastFileReaderDAO();

        // Flag all LAST_FILE_INDICATOR = 'N' for this sub service
        System.out.println("EOSERVICE 20 SETTING LAST_FILE_INDICATOR=N FOR ALL RECS.");
        updateDAO.setDefaultLastFileIndicators(serviceID, subServiceID);
        System.out.println("EOSERVICE 20 ALL RECS SET.");

        // Read last files
        System.out.println("EOSERVICE 20 READING LAST FILES FOR ACQUIRER/ISSUER PAIR.");
        Map<LastFileOutputControlKey, String> lastFileSeqNumbers
                = new Record98BuilderLastFilesReaderDAO()
                        .readLastFileSeqNumbers(serviceID, subServiceID);
        System.out.println("EOSERVICE 20 LAST FILES READ.");

        // Read day totals
        System.out.println("EOSERVICE 20 CALCULATING DAY TOTALS FOR EACH PAIR.");
        List<OutputControlDayTotalEntity> dayTotalsList
                = new Record98BuilderDayTotalsDAO()
                        .daysTotals(serviceID, subServiceID);
        System.out.println("EOSERVICE 20 CALCULATIONS DONE.");

        // Set last file seq numbers. Create new file is not found
        System.out.println("EOSERVICE 20 SETTING LAST SEQ NUMBERS / CREATING NEW FILES IF NONE");
        Map<LastFileOutputControlKey, OutputControlDayTotalEntity> dayTotals = new HashMap<>();
        for (OutputControlDayTotalEntity dayTotal : dayTotalsList ) {

            // set last file seq number for a pair
            LastFileOutputControlKey pair = dayTotal.getId();
            String seqNumber = lastFileSeqNumbers.get(pair);
            if (seqNumber == null) {

                // create a file for this pair
                OutputControlEntity lastFile
                        = lastFileReaderDAO.read(dayTotal);
                seqNumber =
                        recordDAO.insert(dayTotal, lastFile);
            }

            dayTotal.setSeqNumber(seqNumber);

            dayTotals.put(pair, dayTotal);
        }

        // Update each last file with day totals
        System.out.println("EOSERVICE 20 UPDATING CSO_OUTPUT_CONTROLS WITH REC 98 INFO.");
        updateDAO.updateDayTotals( dayTotalsList );
        System.out.println("EOSERVICE 20 DAY TOTALS UPDATE COMPLETED.");

        return dayTotals;
    }

    public static void main(String[] args) {
        Record98Builder.build("CARD", "MASTERCARD");
    }
}

package com.bsva.dmcs.reportv02.loader;

import static com.bsva.dmcs.reportv02.util.StringUtils.format;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bsva.dmcs.reportv02.util.Justification;
import com.bsva.dto.ErrorDTO;
import com.bsva.dto.FileHeaderDTO;
import com.bsva.dto.FileStats;
import com.bsva.entities.v02.params.CompanyParametersEntity;

public class CR023VetFileWriter extends  CRVetFileWriter {

    private final static String REPORT_ID = "023";

    public CR023VetFileWriter(
            CompanyParametersEntity params,
            Date processDate,
            String serviceID,
            String subServiceID,
            String reportFolder,
            Map<Integer, String> errorCodes) {

        super(  params,
                processDate,
                serviceID,
                subServiceID,
                reportFolder,
                REPORT_ID,
                errorCodes );
    }

    public void writeData(Integer issuerMemberCode,
                      String filename,
                      FileHeaderDTO header,
                      List<ErrorDTO> errors,
                      FileStats fileStats)
                throws FileNotFoundException {

        writeData(issuerMemberCode, filename, header, errors, fileStats, 100, "VET REPORT");
    }

    protected void writerHeaderData( PrintWriter out,
                                 String filename,
                                 String subServiceID,
                                 String reportName,
                                 Integer issuerMemberCode) {

        pageNumber = 0;

        // header line 1

        String s =
                format( "BNK",                            8, ' ', Justification.LEFT) +
                        format( "CR" +
                                reportId +
                                SUB_SERVICE_MNEMONICS
                                        .get(subServiceID),      10, ' ', Justification.LEFT) +
                        "TIME: " +
                        format( TIME_FORMAT.format(new Date()),  11, ' ', Justification.LEFT) +
                        format( params.getCompanyName(),         71, ' ', Justification.LEFT) +
                        format( DATE_FORMAT.format(processDate), 14, ' ', Justification.LEFT) +
                        "PAGE: " +
                        format( (++pageNumber),                   6, ' ', Justification.RIGHT);

        out.println( s + LINE_SEPARATOR + LINE_SEPARATOR );

        // header line 2
        s =
                format( "REG.NO.",                       60, ' ', Justification.RIGHT) +
                        format( params.getRegistrationNumber(),  14, ' ', Justification.RIGHT);
        out.println( s + LINE_SEPARATOR);

        // header line 3
        s =
                format( ("MASTERCARD".equals(subServiceID) ? "MASTERCARD" : subServiceID) + " " +reportName,
                                                        65, ' ', Justification.RIGHT);
        out.println( s + LINE_SEPARATOR + LINE_SEPARATOR);

        // header line 4
        s =
                "BSV. FILE REFERENCE: " +
                        format( filename,                        22, ' ', Justification.LEFT) +
                        "***  REJECTIONS  ***";
        out.println( s );

        // header line 5
        s =
                "ACQ. FILE REFERENCE: " +
                        format( filename,                  22, ' ', Justification.LEFT);
        out.println( s + LINE_SEPARATOR );

        // header line 6
        s =
                "SERVICE : " +
                        format( serviceID,                        24, ' ', Justification.LEFT) +
                        "SUB SERVICE : " +
                        subServiceID;
        out.println( s + LINE_SEPARATOR );

        // header line 7
        s =
                format("REC ID",               10, ' ', Justification.LEFT) +
                format("REC SEQ",              10, ' ', Justification.LEFT) +
                format("REJ NO",               10, ' ', Justification.LEFT) +
                format("ERROR DESCRIPTION ",  43, ' ', Justification.LEFT) +
                format("FIELD CONTENTS",      14, ' ', Justification.RIGHT);
        out.println( s );

        // header line 8
        s =
                format("------",               10, ' ', Justification.LEFT) +
                        format("-------",              10, ' ', Justification.LEFT) +
                        format("------",               10, ' ', Justification.LEFT) +
                        format("----------------- ",  43, ' ', Justification.LEFT) +
                        format("--------------",      14, ' ', Justification.RIGHT);
        out.println( s + LINE_SEPARATOR );
    }

    protected void writeFileStatsData(PrintWriter out, FileStats stats) {

        String s =
                format("VOLUME",            42, ' ', Justification.RIGHT) +
                        format("VALUE",             22, ' ', Justification.RIGHT);

        out.println( LINE_SEPARATOR + s );

        s =
                "TOTAL ACCEPTED - DEBITS_: " +
                        format(NUMBER_FORMAT.format(Double.parseDouble( "" + stats.getAcceptedDebitsVolume())),
                                16, ' ', Justification.RIGHT) +
                        format(DECIMAL_FORMAT.format( stats.getAcceptedDebitsValue() / 100 ), 22, ' ', Justification.RIGHT);
        out.println( s );

        s =     format("CREDITS:",                            25, ' ', Justification.RIGHT) +
                format(NUMBER_FORMAT.format(Double.parseDouble( "" + stats.getAcceptedCreditsVolume())),
                        17, ' ', Justification.RIGHT) +
                format(DECIMAL_FORMAT.format( stats.getAcceptedCreditsValue() / 100 ), 22, ' ', Justification.RIGHT);
        out.println(s + LINE_SEPARATOR);

        //System.out.format(Locale.FRANCE, "%-16.2f", pi); // -->  "3,1416"

        s =
                "TOTAL REJECTED - DEBITS_: " +
                        format(NUMBER_FORMAT.format(Double.parseDouble( "" + stats.getRejectedDebitsVolume())),
                                16, ' ', Justification.RIGHT) +
                        format( DECIMAL_FORMAT.format( stats.getRejectedDebitsValue() / 100 ),  22, ' ', Justification.RIGHT);
        out.println( s );

        s =     format("CREDITS:",                            25, ' ', Justification.RIGHT) +
                format(NUMBER_FORMAT.format(Double.parseDouble( "" + stats.getRejectedCreditsVolume())),
                        17, ' ', Justification.RIGHT) +
                format(DECIMAL_FORMAT.format( stats.getRejectedCreditsValue() / 100 ),  22, ' ', Justification.RIGHT);

        out.println(s + LINE_SEPARATOR);

        s =
                format("ACCEPTED",                            55, ' ', Justification.RIGHT) +
                        format("REJECTED",                            26, ' ', Justification.RIGHT);

        out.println( s );

        s =
                format("TOTAL NUMBER OF FINANCIAL RECORDS____:",  40, ' ', Justification.RIGHT) +
                        format(NUMBER_FORMAT.format(Double.parseDouble( "" + stats.getAcceptedFinRecCount())),
                                15, ' ', Justification.RIGHT) +
                        format(NUMBER_FORMAT.format(Double.parseDouble("" + stats.getRejectedFinRecCount())),
                                26, ' ', Justification.RIGHT);
        out.println( s );

        s =
                format("NON FINANCIAL RECORDS:",                  40, ' ', Justification.RIGHT) +
                        format(NUMBER_FORMAT.format(Double.parseDouble( "" + stats.getAcceptedNonFinRecCount())),
                                15, ' ', Justification.RIGHT) +
                        format(NUMBER_FORMAT.format(Double.parseDouble("" + stats.getRejectedNonFinRecCount())),
                                26, ' ', Justification.RIGHT);
        out.println( s );

        s =
                format("NEGATIVE CARD RECORDS:",                  40, ' ', Justification.RIGHT) +
                        format(NUMBER_FORMAT.format(Double.parseDouble( "" + stats.getAcceptedNegativeCardRecCount())),
                                15, ' ', Justification.RIGHT) +
                        format(NUMBER_FORMAT.format(Double.parseDouble("" + stats.getRejectedNegativeCardRecCount())),
                                26, ' ', Justification.RIGHT);
        out.println( s );

        s =
                format("CONTROL RECORDS______:",                  40, ' ', Justification.RIGHT) +
                        format(NUMBER_FORMAT.format(Double.parseDouble( "" + stats.getAcceptedControlRecCount())),
                                15, ' ', Justification.RIGHT) +
                        format(NUMBER_FORMAT.format(Double.parseDouble("" + stats.getRejectedControlRecCount())),
                                26, ' ', Justification.RIGHT);
        out.println(s + LINE_SEPARATOR);

        s =
                format("* TOTAL RECORDS______:",                  40, ' ', Justification.RIGHT) +
                        format(NUMBER_FORMAT.format(Double.parseDouble( "" + totalAcceptedRecCount(stats))),
                                15, ' ', Justification.RIGHT) +
                        format(NUMBER_FORMAT.format(Double.parseDouble("" + totalRejectedRecCount(stats))),
                                26, ' ', Justification.RIGHT);
        out.println( s );
    }
}


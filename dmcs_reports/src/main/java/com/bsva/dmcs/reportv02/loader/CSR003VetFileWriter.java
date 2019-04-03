package com.bsva.dmcs.reportv02.loader;

import com.bsva.dao.v02.members.MemberAddressDAO;
import com.bsva.dmcs.reportv02.util.Justification;
import com.bsva.dto.ErrorDTO;
import com.bsva.dto.FileHeaderDTO;
import com.bsva.dto.FileStats;
import com.bsva.entities.v02.params.CompanyParametersEntity;
import com.bsva.entities.v02.members.MemberAddressEntity;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import static com.bsva.dmcs.reportv02.util.StringUtils.format;

/**
 * TODO Document
 */
public class CSR003VetFileWriter extends VetFileWriter {

    private final static String REPORT_ID = "003";
    private final Map<Integer, MemberAddressEntity> addresses;

    public CSR003VetFileWriter(
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

        // get member addresses
        addresses  = new MemberAddressDAO().memberAddresses(subServiceID);
    }

    public void write(Integer issuerMemberCode,
                      String filename,
                      FileHeaderDTO header,
                      List<ErrorDTO> errors,
                      FileStats fileStats)
                throws FileNotFoundException {

        write(issuerMemberCode, filename, header, errors, fileStats, null, "VALIDATION REPORT");
    }

    protected void writerHeader( PrintWriter out,
                                 String filename,
                                 String subServiceID,
                                 String reportName,
                                 Integer acquirerCode) {

        pageNumber = 0;

        // header line 1

        String s =
                format( "BNK",                            8, ' ', Justification.LEFT) +
                        format( "CSR" +
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
        String reportNarrative = ("MASTERCARD".equals(subServiceID) ? "MASTERCARD" : subServiceID) + " " + reportName;
        s =
                format( reportNarrative,    65, ' ', Justification.RIGHT);
        out.println( s );

        // header line 4
        s =
                format( "",    reportNarrative.length(), '-', Justification.RIGHT);
        out.println( s + LINE_SEPARATOR );

        // header line 5
        s =
                "FOR FILE: " + filename + " (" + filename + ")";
        out.println( s  + LINE_SEPARATOR);

        // header line 6
        MemberAddressEntity address = addresses.get(acquirerCode);
        s =
                "TO:-  " + address.getContactName();
        out.println( s );
        s =        "      " + address.getMemberAddress1();
        out.println( s );
        s =        "      " + address.getMemberAddress2();
        out.println( s );
        s =        "      " + address.getMemberAddress1();
        s =        "      " + address.getMemberAddress2();
        s =        "      " + address.getMemberAddress3();
        /*s =        "      " + address.getMemberAddress4();*/
        out.println( s + LINE_SEPARATOR );

        // header line 6
        s = "TRANSACTION REJECTIONS ";
        out.println( s );

        s = "---------------------- ";
        out.println( s + LINE_SEPARATOR );

        // header line 7
        s =
                format("INPUT",     9, ' ', Justification.LEFT) +
                format("PRCHAS",    7, ' ', Justification.LEFT) +
                format("AQUIRER",   24, ' ', Justification.LEFT) +
                format("PRIMARY",   17, ' ', Justification.LEFT) +
                format("TRAN",      5, ' ', Justification.LEFT) +
                format("REAS",      4, ' ', Justification.LEFT);
        out.println( s );

        s =
                format("FILE ID",           9, ' ', Justification.LEFT) +
                format("DATE",              7, ' ', Justification.LEFT) +
                format("REFERENCE NUMBER", 24, ' ', Justification.LEFT) +
                format("ACCOUNT NUMBER",   17, ' ', Justification.LEFT) +
                format("CODE",              5, ' ', Justification.LEFT) +
                format("CODE",              5, ' ', Justification.LEFT) +
                format("MERCHANT NAME",    35, ' ', Justification.LEFT) +
                format("AMOUNT",            7, ' ', Justification.LEFT) +
                "REASON FOR REJECTION";
        out.println( s + LINE_SEPARATOR);
    }

    protected void writeDetail(PrintWriter out, List<ErrorDTO> errors, Integer errorLimit, String filename) {

        Double totalTxnAmount = 0.0;

        Map<Long, List<ErrorDTO>> lineIDErrors
                = groupErrorByLineID(errors);

        Set<Long> lineIDs = lineIDErrors.keySet();
        for (Long lineID : lineIDs ) {

            List<ErrorDTO> errorList = lineIDErrors.get(lineID);

            // file error for this line
            ErrorDTO error = errorList.get(0);
            Integer errorCode = error.getErrorCode().getCode();
            Double txnAmount = getTxnAmount(errorList);
            totalTxnAmount += txnAmount;

            String s =
                    format(filename,             9, ' ', Justification.LEFT) +
                    format("000000",             7, ' ', Justification.LEFT) +
                    format(error.getRecordSequence(), 24, ' ', Justification.LEFT) +
                    format("",                  17, ' ', Justification.LEFT) +
                    format(error.getRecordID(),  5, ' ', Justification.LEFT) +
                    format(errorCode,            5, ' ', Justification.LEFT) +
                    format("",                  34, ' ', Justification.LEFT) +
                    format(txnAmount,            7, ' ', Justification.RIGHT) +
                    " " + errorCodes.get(errorCode);
            out.println( s );

            // additional error narratives
            for ( int idx = 1; idx < errorList.size(); ++idx) {

                error = errorList.get( idx );
                errorCode = error.getErrorCode().getCode();

                s = format("",             109, ' ', Justification.LEFT) +
                    errorCodes.get(errorCode);

                out.println( s );
            }
        }

        if (errors.size() == 0 && "003".equals(reportId)) {
            String s = "   **** N O   E R R O R S   D E T E C T E D   O N   F I L E:  " + filename;
            out.println( LINE_SEPARATOR + s  + LINE_SEPARATOR );
        }

        // print trailer
        String s =
                format("===============",             108, ' ', Justification.RIGHT);
                out.println( s );
        s = format("TOTAL VALUE OF REJECTIONS",      81, ' ', Justification.RIGHT) +
            format(totalTxnAmount,             26, ' ', Justification.RIGHT);
        out.println( s );

        s = format("===============",         108, ' ', Justification.RIGHT);
        out.println( s );
    }

    @Override
    protected void writeFileStats(PrintWriter out, FileStats stats) {
    }

    private Map<Long, List<ErrorDTO>> groupErrorByLineID(List<ErrorDTO> errors) {

        Map<Long, List<ErrorDTO>> groupedErrors = new HashMap<>();

        for (ErrorDTO error : errors) {
            Long lineID = error.getRecordSequence();

            List<ErrorDTO> lineErrors = groupedErrors.get(lineID);
            if (lineErrors == null) {
                lineErrors = new ArrayList<>();
                groupedErrors.put(lineID, lineErrors);
            }
            lineErrors.add(error);
        }

        return groupedErrors;
    }

    private Double getTxnAmount(List<ErrorDTO> errorList) {
        for (ErrorDTO error : errorList ) {
            if ( ( error.getTxnAmount() != null )
                    && error.getTxnAmount() > 0.0) {
                return error.getTxnAmount();
            }
        }

        return 0.0;
    }
}

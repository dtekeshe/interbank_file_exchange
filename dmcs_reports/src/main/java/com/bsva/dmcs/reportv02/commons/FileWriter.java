package com.bsva.dmcs.reportv02.commons;

import com.bsva.dmcs.reportv02.util.Justification;
import com.bsva.dto.*;
import com.bsva.entities.v02.params.CompanyParametersEntity;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.bsva.dmcs.reportv02.util.StringUtils.format;

/**
 * TODO Document
 */
public abstract class FileWriter {

    private final static String FILE_SEPARATOR = System.getProperty("file.separator");
    private final static String LINE_SEPARATOR = System.getProperty("line.separator");

    protected final static Map<String, String> SUB_SERVICE_MNEMONICS;
    static {
        SUB_SERVICE_MNEMONICS = new HashMap<>();
        SUB_SERVICE_MNEMONICS.put("VISA CARD",       "V");
        SUB_SERVICE_MNEMONICS.put("MASTERCARD",        "M");
        SUB_SERVICE_MNEMONICS.put("DINERS",     "D");
        SUB_SERVICE_MNEMONICS.put("AMEX",       "A");
        SUB_SERVICE_MNEMONICS.put("FLEET CARD", "F");
    }

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyMMdd.HHmmssSSS");
    private final static SimpleDateFormat DATE_FORMAT_2 = new SimpleDateFormat("yyyy/MM/dd");
    private final static SimpleDateFormat FULL_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
    private final static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("HHmmssSSS");

    private final String subServiceID;
    private final String reportFolder;
    protected final String reportId;

    public FileWriter(String subServiceID,
                      String reportFolder,
                      String reportId) {

        this.subServiceID = subServiceID;
        this.reportFolder = reportFolder;
        this.reportId = reportId;
    }

    protected String csr00xFilename(Integer issuerMemberCode, String filename) {

        return reportFolder +
                FILE_SEPARATOR +
                "CSR" +
                reportId +
                SUB_SERVICE_MNEMONICS.get(subServiceID) +  "." +
                filename.trim() + "." +
                DATE_FORMAT.format(new Date()) + "." +
                issuerMemberCode;
    }
    
    public String ccr00xFilename( String subServiceID,
                                 Integer issuerMemberCode) {
        return  "CCR" +
                reportId +
                SUB_SERVICE_MNEMONICS.get(subServiceID) +  "." +
                TIMESTAMP_FORMAT.format(new Date()) + "." +
                issuerMemberCode;
    }

    public String ccr00xFilepath( String filename ) {
        return  reportFolder +
                FILE_SEPARATOR +
                filename;
    }

    /**
     * Writes file header record
     *
     * @param header
     * @param out
     */
    protected void writeControlHeader(FileHeaderDTO header, PrintWriter out) {
        writeControlHeader(null, header, out);
    }

    /**
     * Writes file header record
     *
     * @param header
     * @param out
     */
    protected void writeControlHeader(Date processDate, FileHeaderDTO header, PrintWriter out) {

        Date date = header.getFileDate() != null ? header.getFileDate() : processDate;
        String formattedDate = FULL_DATE_FORMAT.format( date );

        String direction = header.getDirection() != null ?
                                header.getDirection().toString() : "OUT";
        String environment = header.getEnvironment() != null ?
                                header.getEnvironment().toString() : "LIVE";
        String s =
                format( header.getRecordID(),                 2, '0', Justification.RIGHT) +
                formattedDate +
                format( header.getServiceID(),                4, ' ', Justification.LEFT) +
                format( header.getSubServiceID(),            10, ' ', Justification.LEFT) +
                format( header.getOriginatorID(),             4, '0', Justification.RIGHT) +
                format( header.getValidationCode(),           4, ' ', Justification.LEFT) +
                format( "",                                   8, ' ', Justification.LEFT) +
                format( header.getOriginatorID(),             4, '0', Justification.RIGHT) +
                header.getContentType() +
                format( direction,                            3, ' ', Justification.LEFT) +
                formattedDate +
                format( environment,                          4, ' ', Justification.LEFT) +
                format( header.getRecordNumber(),             4, ' ', Justification.LEFT) +
                format( header.getAcquirer(),                 4, '0', Justification.RIGHT) +
                format( header.getReportName(),               6, '0', Justification.RIGHT);

        out.println( s );
    }

    /**
     * Writes file header record
     *
     * @param header
     * @param out
     */
    protected void writeFileHeader( CompanyParametersEntity params,
                                    FileHeaderDTO header,
                                    String cardDescription,
                                    Integer pageNumber,
                                    PrintWriter out) {

        String s =
                format( params.getCompanyName(),                    17, ' ', Justification.LEFT) +
                format( header.getReportName(),                      9, ' ', Justification.LEFT) +
                format( ":",                                        21, ' ', Justification.LEFT) +
                format( params.getFullReportName(),                 59, ' ', Justification.LEFT) +
                format( DATE_FORMAT_2.format(header.getFileDate()), 14, ' ', Justification.LEFT) +
                format( "PAGE:-",                                    7, ' ', Justification.LEFT) +
                format( "" + pageNumber,                             5, ' ', Justification.RIGHT);

        out.println( s + LINE_SEPARATOR);

        s =
                format( "TAX INVOICE NUMBER: ",                     20, ' ', Justification.LEFT) +
                format( "00030427",                                 30, ' ', Justification.LEFT) +
                format( "REG.NO.",                                   9, ' ', Justification.LEFT) +
                format( params.getRegistrationNumber(),             15, ' ', Justification.LEFT);

        out.println( s + LINE_SEPARATOR + LINE_SEPARATOR + LINE_SEPARATOR );

        s =
                format( cardDescription,                            25, ' ', Justification.RIGHT) +
                format( "",                                         18, ' ', Justification.RIGHT) +
                format( "C R E D I T   C A R D   F E E   C A L C U L A T I O N   R E P O R T",
                                                                    68, ' ', Justification.LEFT);
        out.println( s );
        s =
                format( "------------------",                       18, ' ', Justification.RIGHT) +
                format( "-------------------------",                25, ' ', Justification.RIGHT) +
                format( "-------------------------------------------------------------------",
                        68, ' ', Justification.LEFT);

        out.println( s + LINE_SEPARATOR);
    }

    protected void writeControlTrailer(FileHeaderDTO header, PrintWriter out) {
        writeControlTrailer(null, header, out);
    }
    /**
     * Writes file trailer record of id 99
     *
     * @param out
     */
    protected void writeControlTrailer(Date processDate, FileHeaderDTO header, PrintWriter out) {

        Date date = header.getFileDate() != null ? header.getFileDate() : processDate;
        String formattedDate = FULL_DATE_FORMAT.format( date );

        String s =
                format( "99",                                 2, '0', Justification.RIGHT) +
                formattedDate +
                format( header.getServiceID(),                4, ' ', Justification.LEFT) +
                format( header.getSubServiceID(),            10, ' ', Justification.LEFT) +
                format( header.getOriginatorID(),             4, '0', Justification.RIGHT) +
                format( header.getRecordCount(),              6, '0', Justification.RIGHT) +
                format( "",                                   8, '0', Justification.RIGHT) +
                format( "",                                  32, ' ', Justification.RIGHT) +
                format( "",                                  58, '0', Justification.RIGHT);

        out.println( s );
    }

    protected FileHeaderDTO defaultFileHeader() {

        FileHeaderDTO header = new FileHeaderDTO();
        header.setRecordID(1);
        header.setServiceID("CARD");
        header.setSubServiceID("REPORTS");
        header.setValidationCode("ACBJ");
        header.setFilename("");
        header.setContentType(ContentType.DATA);
        header.setDirection(Direction.OUT);
        header.setEnvironment(Environment.LIVE);

        return header;
    }
}

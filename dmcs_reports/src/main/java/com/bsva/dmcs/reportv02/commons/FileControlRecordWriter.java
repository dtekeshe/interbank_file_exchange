package com.bsva.dmcs.reportv02.commons;

import com.bsva.dmcs.reportv02.util.Justification;
import com.bsva.dto.FileTrailerRecordDTO;
import com.bsva.dto.FileHeaderDTO;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import static com.bsva.dmcs.reportv02.util.StringUtils.format;

/**
 * TODO Document
 */
public class FileControlRecordWriter {

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

    /**
     * Writes file header record
     *
     * @param header
     * @param out
     */
    public static void write(FileHeaderDTO header, PrintWriter out) {

        String s =
                format( header.getRecordID(),                 2, '0', Justification.RIGHT) +
                DATE_FORMAT.format(header.getFileDate()) +
                format( header.getServiceID(),                4, ' ', Justification.LEFT) +
                format( header.getSubServiceID(),            10, ' ', Justification.LEFT) +
                format( header.getOriginatorID(),             4, '0', Justification.RIGHT) +
                format( header.getValidationCode(),           4, ' ', Justification.LEFT) +
                format( "",                                   8, ' ', Justification.LEFT) +
                format( header.getDestinationID(),            4, '0', Justification.RIGHT) +
                "4" +
                header.getContentType() +
                format( header.getDirection().toString(),     3, ' ', Justification.LEFT) +
                DATE_FORMAT.format(header.getFileDate()) +
                format( header.getEnvironment().toString(),   4, ' ', Justification.LEFT) +
                format( header.getRecordLength(),             4, '0', Justification.RIGHT);

        out.println( s + "\n");
    }

    /**
     * Writes file trailer record of id 99
     *
     * @param trailer
     * @param out
     */
    public static void write(FileTrailerRecordDTO trailer, PrintWriter out) {

        String s =
                format( trailer.getRecordID(),                 2, '0', Justification.RIGHT) +
                DATE_FORMAT.format(trailer.getProcessDate()) +
                format( trailer.getServiceID(),                4, ' ', Justification.LEFT) +
                format( trailer.getSubServiceID(),            10, ' ', Justification.LEFT) +
                format( trailer.getOriginatorID(),             4, '0', Justification.RIGHT) +
                format( trailer.getRecordCount(),              6, '0', Justification.RIGHT) +
                format( "",                                  197, '0', Justification.RIGHT);

        out.println( s + "\n");
    }
}

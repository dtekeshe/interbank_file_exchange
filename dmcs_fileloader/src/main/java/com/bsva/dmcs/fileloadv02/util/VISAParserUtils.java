package com.bsva.dmcs.fileloadv02.util;

import com.bsva.dmcs.fileloadv02.dto.Justification;
import com.bsva.dmcs.fileloadv02.dto.SubService;
import com.bsva.dto.FileHeaderDTO;

import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.bsva.dmcs.fileloadv02.util.StringUtils.format;
import static com.bsva.dmcs.fileloadv02.util.VISAParserUtils.toString;

/**
 * TODO Document
 */
public class VISAParserUtils {

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

    public static String getChipCardNormalized(String chipCard) {

        switch (chipCard) {
            case "2":
            case "6":
            case "SA1":
                return "1";
            default:
                return "0";
        }
    }

    public static List<SubService> excludedSubServices() {
        List<SubService> excludedSubServices = new ArrayList<>();
        excludedSubServices = new ArrayList<>();
        excludedSubServices.add(SubService.FLEET);
        excludedSubServices.add(SubService.AMEX);
        excludedSubServices.add(SubService.DINERS);

        return excludedSubServices;
    }

    public static void updateFileHeaderRecord(FileHeaderDTO fileHeader, String indexpath, String filename) {
        try {
                RandomAccessFile file = new RandomAccessFile(indexpath, "rw");
                file.seek(0);
                if (fileHeader != null) {
                    String headerString = toString(fileHeader, filename);
                    file.write(headerString.getBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static String toString(FileHeaderDTO header, String filename) {

        Date fileDate = header.getFileDate();
        String serviceId = header.getServiceID();
        String subServiceId = header.getSubServiceID();
        Integer originatingMemberId = header.getOriginatorID();
        Long fileSeqNumber = header.getFileSeqNumber();
        String processStatus = header.getStatus();
        header.setFileRefNumber(
                StringUtils.format(filename.trim() + DATE_FORMAT.format(fileDate), 30, ' ', Justification.LEFT));
        
        Long totalRejected = Counter.numberOfRejectedDebits + Counter.numberOfRejectedCredits ;
        Long numberOfRecs = Counter.numberOfRecs;
        
        Long totNum = numberOfRecs - totalRejected;

        String s = "01" +
                header.getFileRefNumber() +
                format(serviceId.trim(), 4, ' ',Justification.LEFT) +
                format(subServiceId.trim(), 10, ' ',Justification.LEFT) +
                format("" + originatingMemberId, 4, ' ',Justification.LEFT) +
                format("" + fileSeqNumber, 10, ' ',Justification.RIGHT) +
                format("" + totNum, 11, ' ',Justification.RIGHT) +
                format("" + Counter.numberOfDebits, 11, ' ',Justification.RIGHT) +
                format("" + Counter.numberOfCredits, 11, ' ',Justification.RIGHT) +
                format("" + Counter.debitValue, 11, ' ',Justification.RIGHT) +
                format("" + Counter.creditValue, 11, ' ',Justification.RIGHT) +
                format("" + Counter.numberOfRejectedDebits, 11, ' ',Justification.RIGHT) +
                format("" + Counter.numberOfRejectedCredits, 11, ' ',Justification.RIGHT) +
                format("" + Counter.debitRejectedValue, 11, ' ',Justification.RIGHT) +
                format("" + Counter.creditRejectedValue, 11, ' ',Justification.RIGHT) +
                processStatus +
                format("" + Counter.negativeCardCount, 11, ' ',Justification.RIGHT) +
                format("" + Counter.negativeDuplicateCount, 11, ' ',Justification.RIGHT) +
                format("" + totalRejected , 11, ' ',Justification.RIGHT);
        return s;
    }
}

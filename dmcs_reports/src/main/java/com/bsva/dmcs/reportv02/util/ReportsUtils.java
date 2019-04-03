package com.bsva.dmcs.reportv02.util;

import com.bsva.dao.v02.DirectoryDAO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO Document
 *
 * TODO Make this class injectable
 */
public class ReportsUtils {

    private final static String FILE_SEPARATOR = System.getProperty("file.separator");

    private final static Map<String, String> SUB_SERVICE_MNEMONICS;
    static {
        SUB_SERVICE_MNEMONICS = new HashMap<>();
        SUB_SERVICE_MNEMONICS.put("VISA CARD",       "V");
        SUB_SERVICE_MNEMONICS.put("MASTERCARD",        "M");
        SUB_SERVICE_MNEMONICS.put("DINERS",     "D");
        SUB_SERVICE_MNEMONICS.put("AMEX",       "A");
        SUB_SERVICE_MNEMONICS.put("FLEET CARD", "F");
    }

    private final static String REPORTS_FOLDER;
    static {
        REPORTS_FOLDER = new DirectoryDAO().directory("REPORTS");
    }

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HHmmssSSS");

    public static String csr021Filename(String filename, String subServiceID) {
        return "CSR021" + subServiceID.substring(0, 1) + "." + filename + ".xml";
    }

    public static String ccr00xFilename( Byte reportId,
                                         String subServiceID,
                                         Integer issuerMemberCode) {
        return  "CCR00" +
                reportId +
                SUB_SERVICE_MNEMONICS.get(subServiceID) +  "." +
                DATE_FORMAT.format(new Date()) + "." +
                issuerMemberCode;
    }

    public static String ccr00xFilepath( String filename ) {
        return  REPORTS_FOLDER +
                FILE_SEPARATOR +
                filename;
    }
}

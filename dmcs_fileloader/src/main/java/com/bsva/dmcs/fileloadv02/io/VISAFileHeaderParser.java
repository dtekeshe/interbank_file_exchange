package com.bsva.dmcs.fileloadv02.io;

import com.bsva.dmcs.fileloadv02.parsers.FileHeaderParser;
import com.bsva.dto.Environment;

import java.util.Date;
import java.util.Set;

/**
 * TODO Document
 */
public class VISAFileHeaderParser extends FileHeaderParser {

    public VISAFileHeaderParser(Date processDate,
                                Boolean isPublicHoliday,
                                String serviceID,
                                String subServiceID,
                                Set<Integer> memberBankCodes,
                                String validationCode,
                                Environment environment
                                ) {

        super(  processDate,
                isPublicHoliday,
                serviceID,
                subServiceID,
                memberBankCodes,
                validationCode,
                environment);
    }
}

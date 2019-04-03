package com.bsva.dmcs.fileloadv02.parsers;

import com.bsva.dmcs.fileloadv02.model.VISAFileHeader;

import java.io.IOException;

/**
 * TODO documentation
 */
public class VISAFileHeaderParser {

    public static VISAFileHeader parse(Long fileSystemSeqNumber, String headerRecord )
            throws IOException {

        return
                new VISAFileHeader (
                        fileSystemSeqNumber,
                        headerRecord.substring(2, 10).trim(),
                        headerRecord.substring(10, 14).trim(),
                        headerRecord.substring(14, 24).trim(),
                        headerRecord.substring(24, 28).trim(),
                        headerRecord.substring(28, 32).trim(),
                        headerRecord.substring(32, 40).trim(),
                        headerRecord.substring(44, 48).trim(),
                        headerRecord.substring(48, 50).trim(),
                        headerRecord.substring(59, 63).trim(),
                        headerRecord.substring(63, 67).trim() );
    }
}

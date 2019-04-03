package com.bsva.dmcs.fileloadv02.validators;

import static com.bsva.dmcs.fileloadv02.util.FileUtils.tail;
import static com.bsva.dmcs.fileloadv02.util.FileStructureComparator.compare;

import com.bsva.dto.ErrorCode;
import com.bsva.dto.ErrorDTO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

/**
 *
 */
public class FileStructureVerification {

    public static void verify(  String path,
                                int recordLength,
                                String[] expectedHeaderIds,
                                String[] expectedTrailerIds,
                                String filename,
                                List<ErrorDTO> errors)
            throws IOException {

        System.out.println(filename);
        RandomAccessFile in = new RandomAccessFile(path + filename, "r");
        long fileLength = in.length();
        long lines = fileLength / recordLength;
        System.out.println("lines : " + lines);

        int numberOfHeaderIDs = expectedHeaderIds.length;
        int numberOfTrailerIDs = expectedTrailerIds.length;

        String[] headerIds = readIDs(in, numberOfHeaderIDs);

        long startOfTrailer = fileLength - ( numberOfTrailerIDs * recordLength);
        in.seek(startOfTrailer);
        String[] trailerIds = tail(in, numberOfTrailerIDs);
        for (String trailer : trailerIds) {
            System.out.println("trailerIds : " + trailer);
        }
        // verify headers
        compare(headerIds, expectedHeaderIds, errors, 1, ErrorCode.HEADER_RECORD_NOT_FIRST_REC);

        // verify trailers
        compare(trailerIds, expectedTrailerIds, errors, (int)(lines - numberOfTrailerIDs),
                ErrorCode.TRAILER_RECORD_NOT_LAST_REC);
    }

    public static String[] readIDs(RandomAccessFile in, int count) throws IOException {
        String[] result = new String[ count ];
        for (int idx = 0; idx < count; ++idx) {
            String line = in.readLine();
            System.out.println("line : " + line);
            result[ idx ] = line.substring(0, 2);
        }

        long length = in.length();
        in.seek(length);
        in.readLine();
        return result;
    }
}

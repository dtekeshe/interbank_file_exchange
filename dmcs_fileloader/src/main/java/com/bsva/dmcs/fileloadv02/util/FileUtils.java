package com.bsva.dmcs.fileloadv02.util;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 */
public class FileUtils {

    public static String[] tail(RandomAccessFile in, int size) throws IOException {

        String[] result = new String[size];
        long pointer = in.length();
        //in.seek(--pointer);
        while(size > 0 ) {
            Character c = null;
            Long mark = in.getFilePointer();
            try {

                c = (char)in.readByte();
                in.seek(mark);
            } catch (Exception e) {
            }

            if (c == null) {
                in.seek(--pointer);
                continue;
            }

            if (c == '\n') {
                in.seek(--pointer);
                mark = in.getFilePointer();
                String line = in.readLine();
                in.seek(mark);
                if (line == null || line.trim().isEmpty()) {
                    continue;
                }
                result[--size] = line;
            }
        }

        return size == 0 ? result : null;
    }
}

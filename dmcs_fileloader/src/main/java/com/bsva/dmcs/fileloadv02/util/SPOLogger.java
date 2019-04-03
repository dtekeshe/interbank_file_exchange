package com.bsva.dmcs.fileloadv02.util;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class SPOLogger {

    private final String path;
    private final String FILE_SEPARATOR = System.getProperty("file.separator");

    public SPOLogger(String path) {
        this.path = path;
    }

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    public void log(String processName, String version, String message) {

        PrintWriter out = null;
        try {
            out = new PrintWriter(new File(path + FILE_SEPARATOR + "DMC.spo"));
            out.println(DATE_FORMAT.format(new Date()) + " " +
                    processName + " " + version + " " + message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {out.flush();} catch (Exception e){}
            try {out.close();} catch (Exception e){}
        }
    }
}

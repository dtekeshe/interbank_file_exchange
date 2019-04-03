package com.bsva.dmcs.fileloadv02.loaders;

import com.bsva.dcms.commons.util.Utils;

import static com.bsva.dmcs.fileloadv02.util.SPOLOGUtils.logDuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 */
public class OracleSQLLoader implements FileLoader {

    private final String controlFileFolder;
    private final String indexFileFolder;
    private final String logFileFolder;

    public OracleSQLLoader(String controlFileFolder, String indexFileFolder, String logFileFolder) {
        this.controlFileFolder = controlFileFolder;
        this.indexFileFolder = indexFileFolder;
        this.logFileFolder = logFileFolder;
    }

    private static final String SQL_LOAD_CMD;

    public final static String FILE_SEPARATOR = System.getProperty("file.separator");
    private final static String ORACLE_USER_ID;

    static {
        // move to property files
        SQL_LOAD_CMD = "sqlldr_exec";//rename remote_exec to sqlldr_exec
        ORACLE_USER_ID = "CCCOWNER/cccowner@172.16.163.172/cccd";
    }

    public void load(String filename, String controlFilename, String subServiceID) {

        String indexFilePath = indexFileFolder.trim() + FILE_SEPARATOR + filename.trim() + ".idx";
        String controlFilePath = controlFileFolder.trim() + FILE_SEPARATOR + controlFilename.trim();
        String logFilePath = logFileFolder.trim() + FILE_SEPARATOR + filename.trim() + ".log";

        long startedAt = System.currentTimeMillis();
        /*
        String sqlldrCmd =
                SQL_LOAD_CMD +
                " CONTROL=" + controlFilePath +
                " LOG=" + logFilePath +
                " DATA=" + indexFilePath +
                " USERID=" + ORACLE_USER_ID +
                " bindsize=512000 rows=1024";
        */
        String sqlldrCmd =
                SQL_LOAD_CMD + " " + controlFilename.trim() + " " + filename.trim() + " " + subServiceID;
        System.out.println("sqlldrCmd " + sqlldrCmd );
        try {
            Process process = Runtime.getRuntime().exec(sqlldrCmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            long count = 0;
            while (reader.readLine() != null) {
                ++count;
                if (count % 50000 == 0) {
                    spolog(count + " RECS LOADED");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            logDuration(" ", startedAt);
        }
    }

    private void spolog(String message) {
        Utils.logSpolog(message, "LOAD");
    }
}

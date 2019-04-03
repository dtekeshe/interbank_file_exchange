package com.bsva.dmcs.fileloadv02.util;

import java.io.*;

/**
 * TODO Document
 */
public class ReportUtils {

    private final static String FILE_PATH_SEPARATOR = System.getProperty("file.separator");

    /**
     * TODO Document
     *
     * @param reportFolder
     * @param filename
     * @return
     * @throws FileNotFoundException
     */
    public static PrintWriter printWriterForCSR021(String reportFolder, String filename)
            throws FileNotFoundException {

        String path =  reportFolder + FILE_PATH_SEPARATOR + "CSR021." + filename + ".xml";

        return new PrintWriter(new File(path));
    }

    /**
     * Decides whether to create a file rejected report or normal VET report
     *
     * @param reportFolder
     * @param filename
     * @param isValidFile
     * @return
     * @throws FileNotFoundException
     */
    public static PrintWriter printWriter(String reportFolder, String filename, Boolean isValidFile)
            throws FileNotFoundException {

        String path =  reportFolder + FILE_PATH_SEPARATOR + (isValidFile ? "CSR023." : "CSR021.") + filename + ".xml";

        return new PrintWriter(new File(path));
    }

    public static PrintWriter printWriterForCSR024( String reportFolder, String filename)
            throws IOException {

        // copy CSR023 to CSR024
        String from =  reportFolder + FILE_PATH_SEPARATOR + "CSR023." + filename + ".xml";
        String to   =  reportFolder + FILE_PATH_SEPARATOR + "CSR024." + filename + ".xml";

        BufferedReader in = new BufferedReader(new FileReader( from ));
        PrintWriter out = new PrintWriter(to);

        try {
            String line = null;
            while ((line = in.readLine()) != null) {
                out.println(line);
            }
        } finally {
            try { out.flush(); } catch (Exception e){}
            try { out.close(); } catch (Exception e){}
            try { in.close(); } catch (Exception e){}
        }

        return new PrintWriter(new File(to));
    }
}

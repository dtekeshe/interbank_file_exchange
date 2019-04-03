package com.bsva.dmcs.fileloadv02.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO Document
 */
public class DeliveredFilesReader {

    private final String receiveFolder;
    private final static String FILE_SEPARATOR = System.getProperty("file.separator");

    public DeliveredFilesReader(String receiveFolder) {
        this.receiveFolder = receiveFolder;
    }


    public List<String> deliveredFiles() {

        List<String> filenames = new ArrayList<>();

        File[] listing = new File( receiveFolder ).listFiles();
        for (File file : listing) {
            if (file.isFile()) {
                filenames.add(file.getName());
            }
        }

        return filenames;
    }

    public void moveFile(String filename, String newFolder) {

        File file = new File( receiveFolder + FILE_SEPARATOR + filename );
        file.renameTo(new File(receiveFolder + FILE_SEPARATOR + newFolder + FILE_SEPARATOR + filename));
    }
}

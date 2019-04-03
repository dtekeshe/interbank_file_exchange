package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.commons.DeliveredFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Delivered file reader
 */
public class DeliveredFilesReaderDAO extends AbstractDao<DeliveredFile, Void> {

    public DeliveredFilesReaderDAO() {
        super();
    }

    private final static String DELIVERED_FILES_SQL =
            " SELECT FILENAME " +
                    "   FROM DEL_DELIVERY_FILES_CCC " +
                    "  WHERE QUEUE_FILE_NAME = 'INQUE' " +
                    "    AND XMIT_IND = 'Y' " +
                    "  ORDER BY POSITION ";

    public List<DeliveredFile> deliveredFiles() {

        // execute
        List<DeliveredFile> deliveredFiles = list(DELIVERED_FILES_SQL, DeliveredFile.class);
//        List<DeliveredFile> deliveredFiles = new ArrayList<>();
//        DeliveredFile test = new DeliveredFile();
//        test.setFilename("CLB0001D");
//        deliveredFiles.add(test);

//        test = new DeliveredFile();
//        test.setFilename("CCJ0003D");
//        deliveredFiles.add(test);

//        test = new DeliveredFile();
//        test.setFilename("CVA0002D");
//        deliveredFiles.add(test);
//
//        test = new DeliveredFile();
//        test.setFilename("CVA0003D");
//        deliveredFiles.add(test);

//        test = new DeliveredFile();
//        test.setFilename("CVB0001D");
//        deliveredFiles.add(test);

        return deliveredFiles;
    }

    public boolean pendingDeliveredFiles(String subServicePrefix) {

        List<DeliveredFile> files = deliveredFiles();
        for (int idx = files.size() - 1; idx >= 0; --idx) {
            if ( subServicePrefix.equals(files.get(idx).getFilename())) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }
}
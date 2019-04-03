package com.bsva.dao.v02.startofday;

import com.bsva.dao.v02.util.DatabaseException;
import com.bsva.entities.v02.startofday.DefaultOutputFileEntity;
import com.bsva.entities.v02.startofday.SubServiceKey;

import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class DefaultOutputFilesCheckDAO {

    // Metadata
    private final static String PROCESS_NAME = "SODAY";
    private final static String VERSION = "20";

    public boolean defaultFilesLoaded() {

        spolog("READING DEFAULT FILE COUNTS.");
        // get default file count
        Map<SubServiceKey, Integer> defaultFileCount
                = new DefaultOutputFileCountDAO().defaultFileCountForSubService();

        spolog("READING FILE COUNTS.");
        // get file count
        Map<SubServiceKey, Integer> fileCount
                = new OutputFilesCountDAO().fileCountForSubService();

        // check
        boolean isCorrect = defaultFilesLoaded(defaultFileCount, fileCount);

        spolog("OUTPUT FILE COUNT CHECK COMPLETED. RESULT: "
                    + (isCorrect ? "PASSED" : "FAILED") );
        return isCorrect;
    }

    public boolean outputFileTableEmpty()
                    throws DatabaseException {

        spolog("READING FILE COUNTS.");
        // get file count
        Map<SubServiceKey, Integer> fileCount
                = new OutputFilesCountDAO().fileCountForSubService();

        // check
        Integer count = safeSize(fileCount);
        if (count > 0) {
            for (SubServiceKey subService : fileCount.keySet()) {
                spolog(fileCount.get(subService) + " " + subService.getSubServiceID()
                        + " OUTPUT FILE NAMES FOUND" );
            }
            return false;
        }

        spolog("OUTPUT FILES TABLE IS EMPTY" );
        return true;
    }

    private boolean defaultFilesLoaded( Map<SubServiceKey, Integer> defaultFileCount,
                                        Map<SubServiceKey, Integer> fileCount ) {

        boolean isCorrect = true;

        // for each sub service
        for (SubServiceKey subService : defaultFileCount.keySet()) {

            Integer defaultCount = defaultFileCount.get(subService);
            Integer count = fileCount.get(subService);

            if (defaultCount != count ) {
                spolog("*** COUNT MISMATCH FOUND. SUB SERVICE : " + subService.getSubServiceID() +
                            ". DEFAULT: " + defaultCount + ", COUNT: " + count + " ***");
                isCorrect = false;
            }
        }

        return isCorrect;
    }

    /**
     * TODO Move to Util
     * @return
     */
    public static Integer safeSize(Map<SubServiceKey, Integer> fileCount)
            throws DatabaseException {
        try {

            return fileCount.size();
        } catch (Exception e) {
            throw new DatabaseException("FAILED TO COUNT DEFAULT FILES.", null);
        }
    }

    /**
     * TODO Move to Util
     * @return
     */
    public void spolog(String message) {

        // spoLog.log(PROCESS_NAME, VERSION, message);
        System.out.println(PROCESS_NAME + " " + VERSION + " " + message);
    }
}

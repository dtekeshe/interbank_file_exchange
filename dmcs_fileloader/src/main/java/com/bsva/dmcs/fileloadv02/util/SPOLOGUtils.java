package com.bsva.dmcs.fileloadv02.util;

import java.text.SimpleDateFormat;

/**
 * TODO Document
 */
public class SPOLOGUtils {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    public static void logDuration(String processName, long startedAt) {
        long finishedAt = System.currentTimeMillis();
        long timeTakenInMillis = finishedAt - startedAt;
        long timeTakenInSeconds = (timeTakenInMillis) / 1000;
        long timeTakenInMinutes = timeTakenInSeconds / 60;

        System.out.println( processName + " completed in : " +
                timeTakenInMillis + " millis / " + timeTakenInSeconds + " secs / " + timeTakenInMinutes + " mins " );
    }
}

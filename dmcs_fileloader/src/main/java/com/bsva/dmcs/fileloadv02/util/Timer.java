package com.bsva.dmcs.fileloadv02.util;

/**
 * TODO document
 */
public class Timer {

    private static long startedAt;

    public static void start() {
        startedAt = System.currentTimeMillis();
    }

    public static String end() {
        long finishedAt = System.currentTimeMillis();
        long timeTakenInMillis = finishedAt - startedAt;
        long timeTakenInSeconds = (timeTakenInMillis) / 1000;
        long timeTakenInMinutes = timeTakenInSeconds / 60;

        startedAt = 0L;

        String result = "";
        if ( timeTakenInMillis < 1000 ) {
            result = timeTakenInMillis + " millis";
        } else {
            result = timeTakenInMinutes + " mins " + timeTakenInSeconds + " secs";
        }
        return result;
    }
}

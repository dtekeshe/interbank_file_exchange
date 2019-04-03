package com.bsva.dmcs.fileloadv02.util;

/**
 * Fast search for validation of transaction types.
 */
public class BinarySearch {

    public static boolean search(int search, Integer[] searchFrom) {
        // return search(search, searchFrom, searchFrom.length);
        for (Integer item : searchFrom) {
            if (search == item) {
                return true;
            }
        }

        return false;
    }

    public static boolean search(int search, Integer[] searchFrom, int size) {

        for (Integer item : searchFrom) {
            if (search == item) {
                return true;
            }
        }
        return false;
    }
}
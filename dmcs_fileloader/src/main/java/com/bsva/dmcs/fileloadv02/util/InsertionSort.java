package com.bsva.dmcs.fileloadv02.util;

/**
 * Fast sorter
 */
public class InsertionSort {

    public static int[] sort(int[] input) {

        int n = input.length;

        for (int j = 1; j < n; j++) {
            int key = input[j];
            int i = j-1;
            while ( (i >= 0) && ( input [i] > key ) ) {
                input [i+1] = input [i];
                i--;
            }
            input[i+1] = key;
        }

        return input;
    }
}

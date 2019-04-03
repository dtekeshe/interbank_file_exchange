package com.bsva.dmcs.fileloadv02.parsers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {

    public final static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("/home/jboss/dmcs/ccc/receive/CCB0003D"));
        String line = null;
        while ((line = in.readLine()) != null) {
            if (line.length() > 200) {
                String txnCode = line.substring(175, 177);
                if ("09".equals(txnCode)) {
                    String p54 = line.substring(1121, 1132);
                    System.out.println(p54);
                }
            }
        }
    }
}

package com.bsva.dmcs.fileloadv02.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Test {

    private static void editFile() {
        try {
            RandomAccessFile writer
                    = new RandomAccessFile("c:\\\\tana54\\\\ccc\\\\export\\\\CDT0005D.idx", "rw");
            String header = "0120170329CARDMASTERCARD0016ACBJCDT0008DCDT0DATAOUT20170329LIVE21640009";
            writer.write(header.getBytes());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        editFile();
    }
}

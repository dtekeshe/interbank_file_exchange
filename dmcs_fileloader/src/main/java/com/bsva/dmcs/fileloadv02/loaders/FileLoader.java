package com.bsva.dmcs.fileloadv02.loaders;

import java.io.FileNotFoundException;

/**
 * TODO Document
 */
public interface FileLoader {

    void load(String filename, String controlFile, String subServiceID)
                throws FileNotFoundException;
}

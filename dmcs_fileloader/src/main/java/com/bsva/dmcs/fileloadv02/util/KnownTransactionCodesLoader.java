package com.bsva.dmcs.fileloadv02.util;

import static com.bsva.dmcs.fileloadv02.util.CollectionUtils.toTransactionCodeArray;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 *
 */
public class KnownTransactionCodesLoader {

    public static int[] loadFrom(String path) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(path)));

        /* You can't cast a generic type of one parameter to another.
         * This casting has to be done through an intermediate wildcard type
         */
        Set<String> keySet = (Set<String>)(Set<?>) properties.keySet();
        return toTransactionCodeArray(keySet);
    }
}

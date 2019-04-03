package com.bsva.dmcs.fileloadv02.util;

/**
 * Will be raised if processing of a file has to be aborted
 */
public class SystemConfigurationException extends Exception {

    public SystemConfigurationException(String message) {
        super(message);
    }
}

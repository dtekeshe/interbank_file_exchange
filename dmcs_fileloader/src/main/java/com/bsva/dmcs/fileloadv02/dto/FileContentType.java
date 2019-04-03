package com.bsva.dmcs.fileloadv02.dto;

/**
 *
 */
public enum FileContentType {
    DATA("DATA");

    private final String type;

    FileContentType(String type) {
        this.type = type;
    }

    public static FileContentType fromType(String type) {
        for ( FileContentType item : values() ) {
            if ( item.type.equalsIgnoreCase(type)) {
                return item;
            }
        }
        return null;
    }
}

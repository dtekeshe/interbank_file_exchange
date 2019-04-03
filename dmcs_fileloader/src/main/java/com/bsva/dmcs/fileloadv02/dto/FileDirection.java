package com.bsva.dmcs.fileloadv02.dto;

/**
 *
 */

public enum FileDirection {
    IN("IN");

    private final String direction;

    FileDirection(String direction) {
        this.direction = direction;
    }

    public static FileDirection fromDirection(String direction) {
        for ( FileDirection item : values() ) {
            if ( item.direction.equalsIgnoreCase(direction)) {
                return item;
            }
        }
        return null;
    }
}
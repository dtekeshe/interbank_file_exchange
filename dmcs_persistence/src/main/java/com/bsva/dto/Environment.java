package com.bsva.dto;

/**
 *
 */
public enum Environment {
    LIVE("L"), TEST("T");

    private final String environment;

    Environment(String environment) {
        this.environment = environment;
    }

    public static Environment environment(String environment) {
        for (Environment e : values()) {
            if ( e.environment.equalsIgnoreCase(environment)) {
                return e;
            }
        }

        return null;
    }
}

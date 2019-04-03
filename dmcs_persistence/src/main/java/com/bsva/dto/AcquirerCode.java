package com.bsva.dto;

/**
 * A Value Object that makes read map structure easier
 */
public class AcquirerCode {

    private final Integer acquirerCode;

    public AcquirerCode(Integer acquirerCode) {
        this.acquirerCode = acquirerCode;
    }

    public static AcquirerCode acquirerCode(Integer acquirerCode) {
        return new AcquirerCode(acquirerCode);
    }

    public Integer getAcquirerCode() {
        return acquirerCode;
    }
}

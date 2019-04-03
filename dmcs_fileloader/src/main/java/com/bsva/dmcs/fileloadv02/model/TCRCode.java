package com.bsva.dmcs.fileloadv02.model;

/**
 * Represents TCR0, TCR1, TCR5, TCR7
 */
public enum TCRCode {

    TCR0(0), TCR1(1),TCR3(3), TCR5(5), TCR7(7), UNKNOWN(-1);

    private final Integer id;

    TCRCode(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static TCRCode instance(Integer id) {
        for (TCRCode value : values()) {
            if (value.getId() == id) {
                return value;
            }
        }

        return UNKNOWN;
    }
}

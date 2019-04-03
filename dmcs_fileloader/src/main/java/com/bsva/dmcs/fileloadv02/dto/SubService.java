package com.bsva.dmcs.fileloadv02.dto;

public enum SubService {
    VISA("VISA CARD"), MCI("MASTERCARD"), DINERS("DINERS"), AMEX("AMEX"), FLEET("FLEET CARD"), ALL("ALL");

    private final String description;

    SubService(String description) {
        this.description = description;
    }

    public static SubService getEnum(String description) {
        for (SubService value : values()) {
            if (value.getDescription().equalsIgnoreCase(description)) {
                return value;
            }
        }

        if (description.equals("FLEET")) {
            return getEnum("FLEET CARD");
        }
        return null;
    }

    public String getDescription() {
        return description;
    }
}

package com.bsva.settlementv02.utils;

import java.util.Arrays;
import java.util.List;

/**
 * TODO Document
 */
public class SettlementUtils {

    public static List<String> subServices() {
        return Arrays.asList(
                new String[]
                        {"VISA CARD", "MASTERCARD", "AMEX", "DINERS", "FLEET CARD"});
    }
}

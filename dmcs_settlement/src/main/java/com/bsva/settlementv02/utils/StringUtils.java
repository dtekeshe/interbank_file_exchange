package com.bsva.settlementv02.utils;

import com.bsva.settlementv02.dto.Justification;

import java.math.BigDecimal;

/**
 *
 */
public class StringUtils {

    public static Integer parseInt(String value) {
        Integer intValue = null;
        try {
            intValue = Integer.parseInt(value);
        } catch (Exception e) {
        }

        return intValue;
    }

    public static String substring(String input, Integer start, Integer end) {
        String substring = null;
        try {
            substring = input.substring(start, end).trim();
        } catch (Exception e) {
        }

        return substring;
    }

    public static Boolean parseBoolean(String string) {
        Boolean value = null;
        try {
            value = "Y".equalsIgnoreCase(string);
        } catch (Exception e) {
        }

        return value;
    }

    public static BigDecimal parseBigDecimal(String string) {
        BigDecimal value = null;
        try {
            value = new BigDecimal("" + Long.parseLong(string));
        } catch (Exception e) {
        }

        return value;
    }

    public static String format(long data, int len, char padChar, boolean rightAlign) {
        StringBuilder sb = new StringBuilder("" + data);
        while (sb.length() < len) {
            if (rightAlign) {
                sb.insert(0, padChar);
            } else {
                sb.append(padChar);
            }
        }
        return sb.toString();
    }

    public static String format(String data, int len, char padChar, Justification justification) {
        if (data == null) {
            data = "";
        }

        if (data.length() > len) {
            return data.substring(0, len);
        }

        StringBuilder sb = new StringBuilder("" + data);
        while (sb.length() < len) {
            if (justification == Justification.RIGHT) {
                sb.insert(0, padChar);
            } else {
                sb.append(padChar);
            }
        }
        return sb.toString();
    }
}

package com.bsva.dao.v02.util;

import com.bsva.dto.Justification;

/**
 * TODO Document
 */
public class StringUtils {

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

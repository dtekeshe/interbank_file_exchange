package com.bsva.dmcs.reportv02.util;

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

    public static String format(Long data, int len, char padChar, Justification justification) {

        return format("" + (data != null ? data : "0"), len, padChar, justification);
    }

    public static String format(Integer data, int len, char padChar, Justification justification) {

        return format("" + (data != null ? data : "0"), len, padChar, justification);
    }

    public static String format(Double data, int len, char padChar, Justification justification) {

        return format("" + (data != null ? data : "0"), len, padChar, justification);
    }

    public static String substring(String s, int from, int to) {
        if (s == null || s.length() < to) {
            return null;
        }

        return s.substring(from, to);
    }

    public static Integer parseInt(String s, int from, int to) {
        s = substring(s, from, to);
        if (s == null) {
            return null;
        }

        try {
            return Integer.parseInt(s);
        } catch(Exception e) {
            return null;
        }
    }

    public static Long parseLong(String s, int from, int to) {
        s = substring(s, from, to);
        if (s == null) {
            return null;
        }

        try {
            return Long.parseLong(s);
        } catch(Exception e) {
            return null;
        }
    }

    public static String replace(String input, String replacement, Integer start, Integer end) {
        String result = null;
        try {
            result = (start > 0 ? input.substring(0, start ) : "") + replacement + input.substring(end);
        } catch (Exception e) {
        }

        return result;
    }
}

package com.tistory.hskimsky.utils;

import com.google.common.base.Joiner;

import java.util.Collection;

/**
 * String Utility.
 *
 * @author Byoung Gon, Kim
 * @since 2.0
 */
public class StringUtils {

    public static boolean isEmpty(String str) {
        return (str == null || str.trim().length() < 1);
    }

    public static String join(Collection<?> collection, String delimiter) {
        return Joiner.on(delimiter).join(collection);
    }

    public static String replace(String inString, String oldPattern, String newPattern) {
        return org.springframework.util.StringUtils.replace(inString, oldPattern, newPattern);
    }

    /**
     * Escape 처리한 문자열을 unescape처리한다.
     *
     * @param string Escape 처리한 문자열
     * @return escape Unescape 처리한 문자열
     */
    public static String unescape(String string) {
        StringBuilder builder = new StringBuilder();
        builder.ensureCapacity(string.length());
        int lastPos = 0, pos;
        char ch;
        while (lastPos < string.length()) {
            pos = string.indexOf("%", lastPos);
            if (pos == lastPos) {
                if (string.charAt(pos + 1) == 'u') {
                    ch = (char) Integer.parseInt(string
                            .substring(pos + 2, pos + 6), 16);
                    builder.append(ch);
                    lastPos = pos + 6;
                } else {
                    ch = (char) Integer.parseInt(string
                            .substring(pos + 1, pos + 3), 16);
                    builder.append(ch);
                    lastPos = pos + 3;
                }
            } else {
                if (pos == -1) {
                    builder.append(string.substring(lastPos));
                    lastPos = string.length();
                } else {
                    builder.append(string.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return builder.toString();
    }

    /**
     * 지정한 문자열을 escape 처리한다.
     *
     * @param string Escape 처리할 문자열
     * @return escape 처리한 문자열
     */
    public static String escape(String string) {
        int i;
        char j;
        StringBuilder builder = new StringBuilder();
        builder.ensureCapacity(string.length() * 6);
        for (i = 0; i < string.length(); i++) {
            j = string.charAt(i);
            if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j))
                builder.append(j);
            else if (j < 256) {
                builder.append("%");
                if (j < 16)
                    builder.append("0");
                builder.append(Integer.toString(j, 16));
            } else {
                builder.append("%u");
                builder.append(Integer.toString(j, 16));
            }
        }
        return builder.toString();
    }
}

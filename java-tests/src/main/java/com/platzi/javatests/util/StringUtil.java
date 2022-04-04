package com.platzi.javatests.util;

public class StringUtil {

    public static String repeat(String str, int time) {
        if (time < 0) {
            throw new IllegalArgumentException("negative times  not allowed");
        }

        String result = "";

        for (int i = 0; i < time; i++) {
            result += str;
        }
        return result;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

}

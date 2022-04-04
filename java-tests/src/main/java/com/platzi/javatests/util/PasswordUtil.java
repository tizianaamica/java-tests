package com.platzi.javatests.util;

import static com.platzi.javatests.util.PasswordUtil.SecurityLevel.MEDIUM;
import static com.platzi.javatests.util.PasswordUtil.SecurityLevel.WEAK;

public class PasswordUtil {

    public enum SecurityLevel{
        WEAK, MEDIUM, STRONG
    }

    public static SecurityLevel assessPassword(String password) {

        if(password.length() <  8 ) {
            return WEAK;
        }

        if(password.matches("[a-zA-Z]+")) {
            return WEAK;
        }

        if(password.matches("[a-zA-Z0-9]+")) {
            return MEDIUM;
        }

        return MEDIUM;
    }
}

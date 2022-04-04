package com.platzi.javatests.util;

import org.junit.Test;

import static com.platzi.javatests.util.PasswordUtil.SecurityLevel.MEDIUM;
import static com.platzi.javatests.util.PasswordUtil.SecurityLevel.WEAK;
import static org.junit.Assert.assertEquals;

public class PasswordUtilTest {

    @Test
    public void weak_when_has_less_that_8_letters() {
        assertEquals(WEAK,PasswordUtil.assessPassword("123aa!"));
    }

    @Test
    public void weak_when_has_only_letters() {
        assertEquals(WEAK,PasswordUtil.assessPassword("abcdefghjk"));
    }

    @Test
    public void weak_when_has_letters_and_numbers() {
        assertEquals(MEDIUM,PasswordUtil.assessPassword("abcdefgh123"));
    }

}
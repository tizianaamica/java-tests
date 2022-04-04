package com.platzi.javatests.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void repeat_string_once() {
        assertEquals("Hola",StringUtil.repeat("Hola", 1));
    }

    @Test
    public void repeat_string_multiple_times() {
        assertEquals("HolaHolaHola", StringUtil.repeat("Hola", 3));
    }

    @Test
    public void repeat_string_zero_times() {
        assertEquals("", StringUtil.repeat("Hola", 0) );
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times() {
        StringUtil.repeat("Hola", -1);
    }

    @Test
    public void any_string_is_not_empty() {
        assertFalse(StringUtil.isEmpty("Not null"));
    }

    @Test
    public void string_is_empty() {
        assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void string_null_is_empty() {
        assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void string_spaces_is_empty() {
        assertTrue(StringUtil.isEmpty(" "));
    }

}
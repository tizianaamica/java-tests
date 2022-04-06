package com.platzi.javatests.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FizzBuzzShould {

    @Test
    public void return_number_divisible_for_3() {
        assertThat(FizzBuzz.fizzBuzz(3), is("Fizz"));
    }

    @Test
    public void return_number_divisible_for_5() {
        assertThat(FizzBuzz.fizzBuzz(5), is("Buzz"));
    }

    @Test
    public void return_number_divisible_for_3_and_5() {
        assertThat(FizzBuzz.fizzBuzz(15), is("FizzBuzz"));
    }

    @Test
    public void return_number_divisible() {
        assertThat(FizzBuzz.fizzBuzz(16), is("16"));
    }


}
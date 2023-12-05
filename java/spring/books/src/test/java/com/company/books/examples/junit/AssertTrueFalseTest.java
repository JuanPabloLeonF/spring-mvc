package com.company.books.examples.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertTrueFalseTest {

    @Test
    public void test1() {
        assertTrue(true);
        assertFalse(false);
    }

    @Test
    public void test2() {
        Boolean expresion = 4 != 3;

        assertTrue(expresion);
    }
}

package com.company.books.examples.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AssertNotEqualsTest {

    @Test
    public void miTest2() {
        assertNotEquals(1, 2);
    }
}

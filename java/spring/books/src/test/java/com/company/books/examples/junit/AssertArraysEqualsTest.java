package com.company.books.examples.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AssertArraysEqualsTest {

    @Test
    public void assertArraysTest() {

        String[] arraysString = {"a", "b"};
        String[] arraysString2 = {"a", "b"};
        String[] arraysString3 = {"a", "b", "c"};

        assertArrayEquals(arraysString, arraysString2);
        //assertArrayEquals(arraysString, arraysString3);
    }
}

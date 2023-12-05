package com.company.books.examples.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    public static void primero() {
        System.out.println("primero");
    }

    @AfterAll
    public static void ultimo() {
        System.out.println("ultimo");
    }

    @BeforeEach
    public void instanciaObjeto() {
        calculator = new Calculator();
        System.out.println("instanciaObjeto");
    }

    @AfterEach
    public void despuesTest() {
        System.out.println("despuesTest");
    }

    @Test
    @DisplayName(value = "prueba de calculadora")
    @Disabled("esta prueba no se ejecutara")
    public void calculatorAssertEqualsTest() {
        System.out.println("segundo");
        assertEquals(2, calculator.sum(1D, 1D));
        assertEquals(2, calculator.restar(4, 2));
        assertEquals(1, calculator.dividir(2, 2));
        assertEquals(81, calculator.multiplication(9, 9));
    }

    @Test
    public void calculatorAssertTrueFalseTest() {
        System.out.println("Tercero");
        assertTrue(calculator.sum(1d,1d) == 2);
        assertFalse(calculator.multiplication(3,3) == 1);
    }
}

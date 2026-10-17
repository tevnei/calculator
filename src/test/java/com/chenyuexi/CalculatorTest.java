package com.chenyuexi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void addWorks() {
        assertEquals(5.0, calculator.eval("2", "+", "2"));
    }

    @Test
    void divideWorks() {
        assertEquals(2.0, calculator.eval("10", "/", "5"));
    }

    @Test
    void blankInputThrows() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.eval("", "+", "2")
        );
    }

    @Test
    void multiplyWorks() {
        assertEquals(6.0, calculator.eval("2", "*", "3"));
    }
@Test
void divideByZeroThrows() {
    assertThrows(
            IllegalArgumentException.class,
            () -> calculator.eval("10", "/", "0")
    );
}
@ParameterizedTest
@CsvSource({
    "2, +, 3, 5",
    "9, -, 4, 5",
    "3, *, 4, 12",
    "10, /, 5, 2",
    "-2, +, 5, 3",
    "0.1, +, 0.2, 0.3"
})
void calculationWorks(String a, String op, String b, double expected) {
    assertEquals(expected, calculator.eval(a, op, b), 0.000001);
}
@Test
void blankSecondInputThrows() {
    assertThrows(
            IllegalArgumentException.class,
            () -> calculator.eval("2", "+", " ")
    );
}

@Test
void unknownOperatorThrows() {
    assertThrows(
            IllegalArgumentException.class,
            () -> calculator.eval("2", "?", "3")
    );
}

@Test
void nonNumericFirstInputThrows() {
    assertThrows(
            NumberFormatException.class,
            () -> calculator.eval("abc", "+", "2")
    );
}

@Test
void nonNumericSecondInputThrows() {
    assertThrows(
            NumberFormatException.class,
            () -> calculator.eval("2", "+", "abc")
    );
}
    @Test
    void nullOperatorThrowsClearException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.eval("2", null, "3")
        );
    }
    @Test void powerWorks() {
        assertEquals(8.0, calculator.eval("2", "^", "3"));
    }
    @Test void moduloWorks() {
        assertEquals(1.0, calculator.eval("10", "%", "3"));
    }
}

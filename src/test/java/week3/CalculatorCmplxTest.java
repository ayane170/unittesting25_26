package week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorCmplxTest {

    private final CalculatorCmplx calc = new CalculatorCmplx();

    @Test
    void simpleAddition() {
        assertEquals(10, calc.calculate("4+6"));
    }

    @Test
    void multiDigitAndNegatives() {
        assertEquals(-810, calc.calculate("-60+250-1000"));
    }

    @Test
    void spacesAreIgnored() {
        assertEquals(0, calc.calculate("  12   -   5 - 7 "));
    }

    @Test
    void leadingUnaryMinusWithSpaces() {
        assertEquals(-3, calc.calculate(" -   5 + 2 "));
    }

    @Test
    void noUnaryPlusAllowed() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> calc.calculate("+3"));
        assertTrue(ex.getMessage().contains("Unary '+' is not allowed"));
    }

    @Test
    void doublePlusIsInvalid() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> calc.calculate("1++2"));
        assertTrue(ex.getMessage().contains("Unary '+' is not allowed")
                || ex.getMessage().contains("Expected a digit"));
    }

    @Test
    void trailingOperatorIsInvalid() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> calc.calculate("3+"));
        assertTrue(ex.getMessage().toLowerCase().contains("missing number"));
    }

    @Test
    void invalidCharacterWithPosition() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> calc.calculate("1b+5"));
        assertTrue(ex.getMessage().contains("position"));
    }

    @Test
    void emptyOrNullAreInvalid() {
        assertThrows(IllegalArgumentException.class, () -> calc.calculate("   "));
        assertThrows(IllegalArgumentException.class, () -> calc.calculate(null));
    }

    @Test
    void leadingZeros() {
        assertEquals(7, calc.calculate("0010-3"));
    }

    @Test
    void minusThenMinusNumberWithSpaceIsValid() {
        // "3- -5" = 3 - (-5) = 8
        assertEquals(8, calc.calculate("3- -5"));
    }
}
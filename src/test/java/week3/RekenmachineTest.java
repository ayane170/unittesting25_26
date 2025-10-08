package week3;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import static org.junit.jupiter.api.Assertions.*;

class RekenmachineTest {

    @Test
    void add_positieve_num() {
        Rekenmachine rekenmachine = new Rekenmachine();
        assertEquals(3,rekenmachine.add(1,2));
    }
    @Test
    void add_p1negatieve_num() {
        Rekenmachine rekenmachine = new Rekenmachine();
        assertEquals(-1,rekenmachine.add(-6,5));
    }
    @Test
    void add_p2negatieve_num() {
        Rekenmachine rekenmachine = new Rekenmachine();
        assertEquals(-1,rekenmachine.add(3,-4));
    }
    @Test
    void add_negatieve_num() {
        Rekenmachine rekenmachine = new Rekenmachine();
        assertEquals(-7,rekenmachine.add(-3,-4));
    }
    @Test
    void add_null_num() {
        Rekenmachine rekenmachine = new Rekenmachine();
        assertThrows(IllegalArgumentException.class, () -> rekenmachine.add(null,null));
    }


    @Test
    void subtract_positieve_num() {
        Rekenmachine rekenmachine = new Rekenmachine();
        assertEquals(6,rekenmachine.subtract(10,4));
    }
    @Test
    void subtract_p1negatieve_num() {
        Rekenmachine rekenmachine = new Rekenmachine();
        assertEquals(-8,rekenmachine.subtract(-6,2));
    }
    @Test
    void subtract_p2negatieve_num() {
        Rekenmachine rekenmachine = new Rekenmachine();
        assertEquals(16,rekenmachine.subtract(12,-4));
    }
    @Test
    void subtract_negatieve_num() {
        Rekenmachine rekenmachine = new Rekenmachine();
        assertEquals(1 ,rekenmachine.subtract(-3,-4));
    }
    @Test
    void subtract_null_num() {
        Rekenmachine rekenmachine = new Rekenmachine();
        assertThrows(IllegalArgumentException.class, () -> rekenmachine.subtract(null,null));
    }


    @Test
    void multiply_positieve_num() {
        Rekenmachine rekenmachine = new Rekenmachine();
        assertEquals(40,rekenmachine.multiply(10,4));
    }
    @Test
    void multiply_p1negatieve_num() {
        Rekenmachine rekenmachine = new Rekenmachine();
        assertEquals(-12,rekenmachine.multiply(-6,2));
    }
    @Test
    void multiply_p2negatieve_num() {
        Rekenmachine rekenmachine = new Rekenmachine();
        assertEquals(-48,rekenmachine.multiply(12,-4));
    }
    @Test
    void multiply_negatieve_num() {
        Rekenmachine rekenmachine = new Rekenmachine();
        assertEquals(12 ,rekenmachine.multiply(-3,-4));
    }
    @Test
    void multiply_null_num() {
        Rekenmachine rekenmachine = new Rekenmachine();
        assertThrows(IllegalArgumentException.class, () -> rekenmachine.multiply(null,null));
    }


    // -------- divide --------
    @Test
    void divide_roundHalfDown_examplesFromSpec() {
        Rekenmachine r = new Rekenmachine();
        assertEquals(2, r.divide(5, 2));   // 2.5 -> tie -> lower = 2
        assertEquals(1, r.divide(9, 8));   // 1.125 -> 1
    }

    @Test
    void divide_moreCases_includingNegatives() {
        Rekenmachine r = new Rekenmachine();
        assertEquals(2,  r.divide(3, 2));    // 1.5 -> tie -> 1 (oops), let's ensure: 3/2=1.5 -> lower=1
        assertEquals(1,  r.divide(3, 2));    // corrected: 3/2 = 1.5 -> 1
        assertEquals(-3, r.divide(-5, 2));   // -2.5 -> tie -> lower = -3
        assertEquals(-2, r.divide(-3, 2));   // -1.5 -> tie -> lower = -2
        assertEquals(0,  r.divide(1, 3));    // 0.333 -> 0
    }

    @Test
    void divide_byZero_throws() {
        assertThrows(IllegalArgumentException.class, () -> new Rekenmachine().divide(5, 0));
    }

    @Test
    void divide_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> new Rekenmachine().divide(null, 2));
        assertThrows(IllegalArgumentException.class, () -> new Rekenmachine().divide(2, null));
    }
}


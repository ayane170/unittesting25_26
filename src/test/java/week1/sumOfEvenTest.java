package week1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class sumOfEvenTest {

    @Test
    void sumOfEven_Array_returnsPositiveInt() {
        ArrayOfInts even = new ArrayOfInts();
        assertEquals(8,even.sumOfEven(new int[]{2,5,6,1}));
    }
    @Test
    void sumOfEven_Array_returnsNegativeInt() {
        ArrayOfInts even = new ArrayOfInts();
        assertEquals(-4,even.sumOfEven(new int[]{-3,-4,5}));
    }
    @Test
    void sumOfEven_emptyArray() {
        ArrayOfInts even = new ArrayOfInts();
        assertEquals(0,even.sumOfEven(new int[]{}));
    }
    @Test
    void sumOfEven__nullArray() {
        ArrayOfInts even = new ArrayOfInts();
        assertEquals(0,even.sumOfEven(null));
    }

}
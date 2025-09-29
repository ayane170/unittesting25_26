package week1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ArrayOfIntsTest {

    @Test
    void sumOfInts_nullArray_returnsZero() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(0, a.sumOfInts(null));
    }
    @Test
    void sumOfInts_emptyArray_returnsZero() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(0, a.sumOfInts(new int[]{}));
    }
    @Test
    void sumOfInts_Array_returnsPositiveInt8() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(8, a.sumOfInts(new int[]{4,-6,10}));
    }
    @Test
    void sumOfInts_Array_returnsPositiveInt6() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(6, a.sumOfInts(new int[]{1,2,3}));
    }
    @Test
    void sumOfInts_Array_returnsNegativeInt2() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(-2, a.sumOfInts(new int[]{5,-3,-4}));
    }



}
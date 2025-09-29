package week1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfSmallestIntsTest {

    @Test
    void sumOf3SmallestInts_arrayWithPositiveNumbers_returns() {
        ArrayOfInts c = new ArrayOfInts();
        assertEquals(9, c.sumOf3SmallestInts(new int[]{2, 3, 5, 4, 7}));
    }
    @Test
    void sumOf3SmallestInts_withMixedOrder_returns() {
        ArrayOfInts c = new ArrayOfInts();
        assertEquals(6, c.sumOf3SmallestInts(new int[]{-5,3,8,10,9}));
    }
    @Test
    void sumOf3SmallestInts_emptyArray() {
        ArrayOfInts c = new ArrayOfInts();
        assertEquals(0, c.sumOf3SmallestInts(new int[]{}));
    }
    @Test
    void sumOf3SmallestInts_nullArray() {
        ArrayOfInts c = new ArrayOfInts();
        assertEquals(0, c.sumOf3SmallestInts(null));
    }

}
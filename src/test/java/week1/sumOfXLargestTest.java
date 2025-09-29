package week1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class sumOfXLargestTest {
    ArrayOfInts a = new ArrayOfInts();
    @Test
    void sumOfXLargest_withX3() {
        assertEquals(9,a.sumOfXLargest(new int[]{4,1,3,2},3));
    }
    @Test
    void sumOfXLargest_biggerX() {
        assertEquals(10,a.sumOfXLargest(new int[]{1,2,3,4},5));
    }
    @Test
    void sumOfXLargest_emptyArray() {
        assertEquals(0,a.sumOfXLargest(new int[]{},2));
    }
    @Test
    void sumOfXLargest_nullArray() {
        assertEquals(0,a.sumOfXLargest(null,2));
    }
    @Test
    void sumOfXLargest_negativeX() {
        assertEquals(0,a.sumOfXLargest(new int[]{1,2,3,4},-1));
    }
    @Test
    void sumOfXLargest_emptyX() {
        assertEquals(0,a.sumOfXLargest(new int[]{1,2,3,4},0));
    }
}
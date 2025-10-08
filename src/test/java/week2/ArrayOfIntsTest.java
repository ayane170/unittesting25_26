package week2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayOfIntsTest {
ArrayOfInts a = new ArrayOfInts();
    @Test
    void sumOfUniqueValidNumbers_nullArray() {
        assertThrows(IllegalArgumentException.class, () ->a.sumOfUniqueValidNumbers(null));
    }
    @Test
    void sumOfUniqueValidNumbers_emptyArray() {
        assertEquals(0,a.sumOfUniqueValidNumbers(new int[0]));
    }
    @Test
    void sumOfUniqueValidNumbers_doubleElementArray() {
        assertEquals(6,a.sumOfUniqueValidNumbers(new int[]{1,5,5}));
    }
    @Test
    void sumOfUniqueValidNumbers_negativeNumbersArray() {
        assertThrows(IllegalArgumentException.class, () ->a.sumOfUniqueValidNumbers(new int[]{1,-2,3}));
    }
    @Test
    void sumOfUniqueValidNumbers_NumbersPlusThousandArray() {
        assertEquals(1005,a.sumOfUniqueValidNumbers(new int[]{2,1001,3,1000}));
    }
    @Test
    void sumOfUniqueValidNumbers_mixArray() {
        assertEquals(1005,a.sumOfUniqueValidNumbers(new int[]{0,0,1001,1000,5,5}));
    }
    @Test
    void findUniqueElements_nullArray_EmptyArray() {
        assertThrows(IllegalArgumentException.class, () ->a.findUniqueElements(null,new int[0]));
    }
    @Test
    void findUniqueElements_identiqueArray() {
        assertArrayEquals(new int[]{}, a.findUniqueElements(new int[]{1,2},new int[]{1,2}));
    }
}
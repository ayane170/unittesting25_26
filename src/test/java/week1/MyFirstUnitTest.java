package week1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyFirstUnitTest {
    @Test
    public void test() {
        Assertions.assertEquals(150, 50 * 3);
    }

    @Test
    public void test2() {
        Assertions.assertEquals("abc","dit is abc teskt".substring(7,10));
    }
}

package theorie.functionalprogramming;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Level1Test {
    private static final String DUMMY_TEXT = "DUMMY TEXT";
    private static final int TEXT_LENGTH = 123;
    Level1 level1 = new Level1();

    @Test
    void executeTheFunction_text_returnsStringLength() {
        int length = level1.executeTheFunction(new Function<String, Integer>() {
            @Override
            public Integer apply(String text) {
                assertEquals(DUMMY_TEXT, text);
                return TEXT_LENGTH;
            }
        }, DUMMY_TEXT);

        assertEquals(TEXT_LENGTH, length);
    }
}
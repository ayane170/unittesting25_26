package week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void correctGuess() {
        Game g = new Game();
        g.setNumberToGuess(50, 3);
        assertEquals("CORRECT", g.guess(50));
    }

    @Test
    void higherLower() {
        Game g = new Game();
        g.setNumberToGuess(50, 3);
        assertEquals("LOWER", g.guess(70));
        assertEquals("HIGHER", g.guess(30));
    }

    @Test
    void lostAfterExceedingMax() {
        Game g = new Game();
        g.setNumberToGuess(40, 2);
        g.guess(10); // 1
        g.guess(20); // 2
        assertEquals("LOST", g.guess(30)); // 3 -> LOST
    }

    @Test
    void resetCounterAfterSetNumberToGuess() {
        Game g = new Game();
        g.setNumberToGuess(10, 1);
        g.guess(0); // use 1 attempt
        g.setNumberToGuess(60, 2); // reset
        assertEquals("HIGHER", g.guess(50));
    }

    @Test
    void invalidGuessBelowZero() {
        Game g = new Game();
        g.setNumberToGuess(50, 3);
        assertThrows(IllegalArgumentException.class, () -> g.guess(-1));
    }

    @Test
    void invalidGuessAboveHundred() {
        Game g = new Game();
        g.setNumberToGuess(50, 3);
        assertThrows(IllegalArgumentException.class, () -> g.guess(101));
    }

    @Test
    void invalidMaxGuesses() {
        Game g = new Game();
        assertThrows(IllegalArgumentException.class, () -> g.setNumberToGuess(50, 0));
        assertThrows(IllegalArgumentException.class, () -> g.setNumberToGuess(50, 11));
    }

    @Test
    void invalidNumberToGuess() {
        Game g = new Game();
        assertThrows(IllegalArgumentException.class, () -> g.setNumberToGuess(-1, 3));
        assertThrows(IllegalArgumentException.class, () -> g.setNumberToGuess(101, 3));
    }
}
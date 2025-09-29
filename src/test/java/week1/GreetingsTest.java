package week1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingsTest {

    @Test
    void sayHello_namesHasValue_returnsHello() {
        Greetings greetings = new Greetings();
        assertEquals("Hello world!",greetings.sayHello("world"));
    }

    @Test
    void sayHello_namesEmpty_returnsHelloThere() {
        Greetings greetings = new Greetings();
        assertEquals("Hello there!",greetings.sayHello(""));
    }

    @Test
    void sayHello_namesNull_returnsHellothere() {
        Greetings greetings = new Greetings();
        assertEquals("Hello there!",greetings.sayHello(null));
    }
}
package week1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingsTest2 {

    @Test
    void sayHello_With_English() {
            Greetings greetings = new Greetings();
            assertEquals("Hello peter!",greetings.sayHello("peter","English"));
    }

    @Test
    void sayHello_With_English_nameNull() {
        Greetings greetings = new Greetings();
        assertEquals("Hello !",greetings.sayHello(null,"English"));
    }

    @Test
    void sayHello_With_Spanish() {
        Greetings greetings = new Greetings();
        assertEquals("Hola pedro!",greetings.sayHello("pedro","Spanish"));
    }

    @Test
    void sayHello_With_Dutch() {
        Greetings greetings = new Greetings();
        assertEquals("Hallo aan!",greetings.sayHello("aan","Dutch"));
    }

    @Test
    void sayHello_With_String() {
        Greetings greetings = new Greetings();
        assertEquals("I don't know how to say hello to you, peter",greetings.sayHello("peter",""));
    }

}
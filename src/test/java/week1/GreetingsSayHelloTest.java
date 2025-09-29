package week1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingsSayHelloTest {

    @Test
    void sayHelloHasName() {
        Greetings greetings = new Greetings();
        assertEquals("Hello aya!", greetings.sayHello("aya"));
    }
    @Test
    void sayHelloIsEmptyNameAndSayHelloThere() {
        Greetings greetings = new Greetings();
        assertEquals("Hello there",greetings.sayHello(""));
    }

    @Test
    void sayHelloHasNoNameAndSayHelloThere() {
        Greetings greetings = new Greetings();
        assertEquals("Hello there",greetings.sayHello(null));
    }

    @Test
    void sayHello_onlySpaces_returnsHelloThere(){
        Greetings greetings = new Greetings();
        assertEquals("Hello there",greetings.sayHello("   "));
    }
    @Test
    void sayHello_tab_returnsHelloThere(){
        Greetings greetings = new Greetings();
        assertEquals("Hello there",greetings.sayHello("\t\t\t"));
    }
    @Test
    void sayHello_newLines_returnsHelloThere(){
        Greetings greetings = new Greetings();
        assertEquals("Hello there",greetings.sayHello("\n\n\n"));
    }

//    language

    @Test
    void sayHello_With_English(){
        Greetings greetings = new Greetings();
        assertEquals("Hello Eric!",greetings.sayHello("Eric","English"));
    }
    @Test
    void sayHello_With_spanish(){
        Greetings greetings = new Greetings();
        assertEquals("Hola Pedro!",greetings.sayHello("Pedro","Spanish"));
    }

    @Test
    void sayHello_With_Dutch(){
        Greetings greetings = new Greetings();
        assertEquals("Hey Jonas!",greetings.sayHello("Jonas","Dutch"));
    }
    @Test
    void sayHello_With_Empty_Language(){
        Greetings greetings = new Greetings();
        assertEquals("I don't know how to say hello to you, Jonas",greetings.sayHello("Jonas"," "));
    }

    @Test
    void sayHello_With_English_EmptyName(){
        Greetings greetings = new Greetings();
        assertEquals("Hello!",greetings.sayHello("","English"));
    }
    @Test
    void sayHello_With_spanish_EmptyName(){
        Greetings greetings = new Greetings();
        assertEquals("Hola!",greetings.sayHello("","Spanish"));
    }

    @Test
    void sayHello_With_Dutch_EmptyName(){
        Greetings greetings = new Greetings();
        assertEquals("Hey!",greetings.sayHello("","Dutch"));
    }
    @Test
    void sayHello_With_Empty_Language_EmptyName(){
        Greetings greetings = new Greetings();
        assertEquals("I don't know how to say hello to you",greetings.sayHello(" "," "));
    }

}
package week1;

public class Greetings {
    public String sayHello(String name) {
        if ( name == null || name.trim().isEmpty()) return "Hello there" ;
        return "Hello " + name + "!";
    }

    public String sayHello(String name, String language) {
       if ( name == null || name.trim().isEmpty())
        {
            return switch (language) {
                case "English" -> "Hello!";
                case "Spanish" -> "Hola!";
                case "Dutch"   -> "Hey!";
                default -> "I don't know how to say hello to you";
            };
        }
        return switch (language) {
            case "English" -> "Hello " + name + "!";
            case "Spanish" -> "Hola " + name + "!";
            case "Dutch"   -> "Hey " + name + "!";
            default -> "I don't know how to say hello to you, " + name;
        };
    }

}

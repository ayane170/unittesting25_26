package theorie.functionalprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Level4 {
    List<String> l1 = List.of("Brugge", "Antwerpen", "Mechelen", "Kortrijk");

    // Consumer is also an interface, with only an INPUT type (String) and no OUTPUT type
    public void explicitConsumer() {
        l1.forEach(new Consumer<String>() {
            @Override
            public void accept(String stad) {
                System.out.println(stad.toUpperCase());
            }
        });
    }

    // Using a lambda expression for the short notation
    public void lambdaConsumer() {
        l1.forEach(stad -> System.out.println(stad.toUpperCase()));
    }

    public void lambdaConsumerWithCustomCode() {
        l1.forEach(stad -> {
            String stadUpper = stad.toUpperCase();
            System.out.println(stadUpper);
        });
    }

    // Using mapping and method references combined
    public void methodReferenceConsumer() {
        l1.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Level4 level4 = new Level4();
        level4.explicitConsumer();
        level4.lambdaConsumer();
        level4.lambdaConsumerWithCustomCode();
        level4.methodReferenceConsumer();
    }
}
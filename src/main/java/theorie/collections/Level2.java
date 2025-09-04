package theorie.collections;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Level2 {

    void filter_foreach() {
        List<String> l1 = new ArrayList();
        l1.add("Brugge");
        l1.add("Antwerpen");
        l1.add("Mechelen");
        l1.add("Kortrijk");

        for (String stad : l1) {
            if (stad.contains("en")) {
                System.out.println(stad.toUpperCase());
            }
        }

    }

    void filter_Map_ForEach__NoLambda() {
        List<String> l1 = new ArrayList<>();
        l1.add("Brugge");
        l1.add("Antwerpen");
        l1.add("Mechelen");
        l1.add("Kortrijk");

        l1.stream().filter(new Predicate<String>() {
                    @Override
                    public boolean test(String stad) {
                        return stad.contains("en");
                    }
                })
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String stad) {
                        return stad.toUpperCase();
                    }
                })
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String stad) {
                        System.out.println(stad);
                    }
                });
    }

    void filter_Map_ForEach__Lambda() {
        List<String> l1 = new ArrayList<>();
        l1.add("Brugge");
        l1.add("Antwerpen");
        l1.add("Mechelen");
        l1.add("Kortrijk");

        l1.stream().filter(stad -> stad.contains("en"))
                .map(stad -> stad.toUpperCase())
                .forEach(stad -> System.out.println(stad));
    }

    void filter_Map_ForEach__MethodReference() {
        List<String> l1 = new ArrayList<>();
        l1.add("Brugge");
        l1.add("Antwerpen");
        l1.add("Mechelen");
        l1.add("Kortrijk");

        l1.stream().filter(stad -> stad.contains("en"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

}

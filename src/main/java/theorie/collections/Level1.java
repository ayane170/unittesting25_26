package theorie.collections;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Level1 {
    void collections() {
        // Basis klasse voor alle verzamelingen: Collection

        Collection c1 = new ArrayList();
        Collection c2 = new HashSet();
        Collection c3 = new TreeSet();
        Collection c4 = new PriorityQueue();
        Collection c5 = new Stack();
    }

    void list() {
        List<String> l1 = new ArrayList<>();
        l1.add("First element in the list");
        System.out.println(l1.get(0));
    }

    void list_createFromArray() {
        String[] cities = {"Brugge", "Antwerpen", "Mechelen", "Kortrijk"};
        List<String> myList = new ArrayList<>();
        myList.addAll(List.of("Brugge", "Antwerpen", "Mechelen", "Kortrijk"));
        myList.add(10, "Leuven");
    }

    void list_adding() {
        String[] cities = {"Brugge", "Antwerpen", "Mechelen", "Kortrijk"};
        List<String> myList = new ArrayList<>();
        myList.addAll(List.of("Brugge", "Antwerpen", "Mechelen", "Kortrijk"));
        myList.add(10, "Leuven");
    }

    void map() {
        Map<String, Integer> m1 = new HashMap<>();
        m1.put("First element in the map", 1);
        m1.put("Second element in the map", 2);
        m1.put("Third element in the map", 3);

        System.out.println(m1.get("First element in the map"));                                 // 1
        System.out.println(m1.getOrDefault("May be not in the list", 100));     // 100

        for (Integer value : m1.values()) System.out.println(value);
        for (String key : m1.keySet()) System.out.println(key);

        for (Map.Entry<String, Integer> entry : m1.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    void set() {
        Set<String> l2 = new HashSet<>();
        l2.add("Value 1");
        l2.add("Value 2");
        l2.add("Value 1");
        // PRINTF, not PRINT !!
        System.out.printf("The set contains %d unique values%n", l2.size());
    }

    void stack() {
        Stack<BigDecimal> l3 = new Stack<>();
        l3.push(BigDecimal.ONE);
        l3.push(BigDecimal.TWO);
        l3.push(BigDecimal.valueOf(12345.6789));
        System.out.print("First element in the stack: ");
        System.out.println(l3.pop());
    }

}

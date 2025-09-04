package theorie.optional;

import java.util.List;
import java.util.Optional;

record Person(Long id, String name, int age) {
}

public class MyDataLayer {
    public Person getPersonById(Long id) {
        if (id == 1L) {
            return new Person(1L, "John Doe", 30);
        } else if (id == 2L) {
            return new Person(2L, "Jane Smith", 25);
        } else {
            throw new RuntimeException("No person with id " + id);
        }
    }

    public Optional<Person> findPersonByName(String name) {
        if ("John Doe".equals(name)) {
            return Optional.of(new Person(1L, "John Doe", 30));
        } else if ("Jane Smith".equals(name)) {
            return Optional.of(new Person(2L, "Jane Smith", 25));
        } else {
            return Optional.empty();
        }
    }
}

class DataLayerClient {
    public static void main(String[] args) {
        MyDataLayer dataLayer = new MyDataLayer();

        // Using getPersonById
        Person personOne = dataLayer.getPersonById(1L);
        System.out.println("Found person: " + personOne);

        // Using findPersonByName
        Optional<Person> optionalPerson = dataLayer.findPersonByName("Jane Smith");

        optionalPerson.ifPresentOrElse(
                person -> System.out.println("Found person: " + person),
                () -> System.out.println("No person found")
        );
    }
}
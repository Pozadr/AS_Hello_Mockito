package pl.pozadr.hellomockito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.pozadr.hellomockito.model.Person;
import pl.pozadr.hellomockito.model.Sex;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    private final List<Person> people;

    public PersonController() {
        people = new ArrayList<>();
        people.add(new Person("Anna", "Nowak", Sex.FEMALE));
        people.add(new Person("Andrzej", "Cyrkowiec", Sex.MALE));
        people.add(new Person("Olaf", "Norweg", Sex.MALE));
        people.add(new Person("Maurycy", "Marcepan", Sex.MALE));
        people.add(new Person("Katarzyna", "Okrasa", Sex.FEMALE));
        people.add(new Person("Aleksandra", "Kwas", Sex.FEMALE));
    }

    @GetMapping("/people/{limit}")
    public List<Person> getPeopleLimited(@PathVariable ("limit") int limit) {
        return people.subList(0, limit);
    }

    @GetMapping("/people/hello")
    public String getHello() {
        return "Hello from people API!";
    }
}

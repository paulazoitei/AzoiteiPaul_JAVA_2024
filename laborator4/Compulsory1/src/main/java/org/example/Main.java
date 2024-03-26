package org.example;

import com.github.javafaker.Faker;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();
        String name = faker.name().fullName();
        System.out.println(name);
        List<Person> persons = generateRandomPersons(10);
        List<Driver> drivers = persons.stream()
                .filter(person -> person instanceof Driver)
                .map(person -> (Driver) person)
                .collect(Collectors.toList());

        LinkedList<Driver> driverList = new LinkedList<>(drivers);
        driverList.sort(Comparator.comparingInt(Driver::getAge));

        TreeSet<Passenger> passengerSet = new TreeSet<>(Comparator.comparing(Person::getName));
        persons.stream()
                .filter(person -> person instanceof Passenger)
                .map(person -> (Passenger) person)
                .forEach(passengerSet::add);

        System.out.println("Drivers sorted by age:");
        driverList.forEach(System.out::println);

        System.out.println("Passengers sorted by name:");
        passengerSet.forEach(System.out::println);
    }

    private static List<Person> generateRandomPersons(int count) {
        List<Person> persons = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            String name = "Person" + i;
            int age = random.nextInt(40) + 20; // Random age between 20 and 59
            String destination = "Destination" + random.nextInt(3); // Adjust range as needed
            if (random.nextBoolean()) {
                persons.add(new Driver(name, age));
            } else {
                persons.add(new Passenger(name, age));
            }
        }

        return persons;
    }


    


        }




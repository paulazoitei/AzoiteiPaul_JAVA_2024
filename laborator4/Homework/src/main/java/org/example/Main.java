package org.example;

import com.github.javafaker.Faker;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) {



        List<String> commonDestinations = generateCommonDestinations(4); // Generăm 3 destinații comune

        List<Person> persons = generateRandomPersons(10, commonDestinations);
        /**
         * Folosind Stream API, vom filtra persoanele care sunt șoferi și le vom sorta după vârstă.
         */

        List<Driver> drivers = persons.stream()
                .filter(person -> person instanceof Driver)
                .map(person -> (Driver) person)
                .collect(Collectors.toList());
        /**
         * Folosind Stream API, vom filtra persoanele care sunt pasageri și le vom sorta după nume.
         */

        LinkedList<Driver> driverList = new LinkedList<>(drivers);
        driverList.sort(Comparator.comparingInt(Driver::getAge));


        List<Passenger> passengers = persons.stream()
                .filter(person -> person instanceof Passenger)
                .map(person -> (Passenger) person)
                .collect(Collectors.toList());

        TreeSet<Passenger> passengerSet = passengers.stream()
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getName))));

        System.out.println("Drivers sorted by age:");
        driverList.forEach(System.out::println);

        System.out.println("Passengers sorted by name:");
        passengerSet.forEach(System.out::println);
        /**
         * Folosind Stream API, vom obține toate destinațiile prin care au trecut șoferii, fără duplicate.
         */

        List<String> allDestinations = drivers.stream()
                .flatMap(driver -> driver.getDestinations().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Destinations passed through by drivers: " + allDestinations);
        /**
         * Folosind Stream API, vom obține toate destinațiile la care vor să ajungă pasagerii, fără duplicate.
         */

        Map<String, List<String>> destinationMap = new HashMap<>();
        for (Person passenger : persons) {
            for (String destination : passenger.getDestinations()) {
                destinationMap.computeIfAbsent(destination, k -> new ArrayList<>()).add(passenger.getName());
            }
        }

        System.out.println("Map of destinations and people: " + destinationMap);
        /**
         * Folosind Stream API, vom obține toate destinațiile la care vor să ajungă pasagerii, plus soferii care ii duc in acele destinatii
         */
        List<String> matches = matchDriversWithPassengers(drivers, passengers);

        // Afisam match-urile gasite
        matches.forEach(System.out::println);


    }


    /**
     * Metoda generateCommonDestinations() generează o listă de destinații comune astfel incat unii dintre pasageri si soferi sa meaarga in aceleasi destinatii
     * @param count
     * @return
     */
    private static List<String> generateCommonDestinations(int count) {
        Faker faker = new Faker();
        List<String> commonDestinations = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            commonDestinations.add(faker.address().cityName());
        }
        return commonDestinations;
    }

    /**
     * Metoda generateRandomPersons() generează o listă de persoane cu nume ,varsta si destinatie aletaorie,astfel incat destinatiile unui sofer sa fie unice
     * @param count
     * @param commonDestinations
     * @return
     */

    private static List<Person> generateRandomPersons(int count, List<String> commonDestinations) {
        Faker faker = new Faker();
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String name = faker.name().fullName();
            int age = faker.number().numberBetween(18, 70);
            List<String> destinations = new ArrayList<>();
            if (faker.bool().bool()) {
                int numDestinations = faker.number().numberBetween(1, 5);
                Set<String> uniqueDestinations = new HashSet<>();
                while (uniqueDestinations.size() < numDestinations) {
                    uniqueDestinations.add(getRandomElement(commonDestinations));
                }
                destinations.addAll(uniqueDestinations);
                persons.add(new Driver(name, age, destinations));
            } else {
                destinations.add(getRandomElement(commonDestinations));
                persons.add(new Passenger(name, age, destinations));
            }
        }
        return persons;
    }

    /**
     * Metoda getRandomElement() returnează un element aleator dintr-o listă
     * @param list
     * @return
     * @param <T>
     */

    private static <T> T getRandomElement(List<T> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    /**
     * Metoda matchDriversWithPassengers() aloca unui sofer un singur pasager astfel incat sa ajunga mai rapid la destinatie si astfel numarul de
     * potriviri sa fie maxim
     * @param drivers
     * @param passengers
     * @return
     */
    private static List<String> matchDriversWithPassengers(List<Driver> drivers, List<Passenger> passengers) {
        List<String> matches = new ArrayList<>();
        Map<String, List<Passenger>> passengerDestMap = new HashMap<>();

        // Mapeaza fiecare destinatie cu pasagerii care doresc sa mearga acolo
        for (Passenger passenger : passengers) {
            for (String destination : passenger.getDestinations()) {
                passengerDestMap.computeIfAbsent(destination, k -> new ArrayList<>()).add(passenger);
            }
        }

        // Parcurgem fiecare sofer si incercam sa facem o potrivire
        for (Driver driver : drivers) {
            for (String destination : driver.getDestinations()) {
                List<Passenger> potentialPassengers = passengerDestMap.getOrDefault(destination, new ArrayList<>());
                if (!potentialPassengers.isEmpty()) {
                    Passenger matchedPassenger = potentialPassengers.remove(0); // Luam primul pasager disponibil pentru aceasta destinatie
                    matches.add("Driver " + driver.getName() + " matched with passenger " + matchedPassenger.getName() + " for the destination " + destination);
                    break; // Trecem la urmatoarea destinatie pentru acest sofer
                }
            }
        }

        return matches;
    }

}










package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
/**
 * Clasa Person reprezinta o persoana cu un nume, varsta si o lista de destinatii
 */
public class Person {
    private String name;

    private int age;

    private List<String> destinations;

    /**
     * Metoda getName() returneaza numele persoanei
     * @return numele persoanei
     */

    public String getName() {
        return name;
    }

    /**
     * Metoda setName() seteaza numele persoanei
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metoda getAge() returneaza varsta persoanei
     * @return
     */

    public int getAge() {
        return age;
    }

    /**
     * Metoda setAge() seteaza varsta persoanei
     * @param age
     */

    public void setAge(int age) {
        this.age = age;
    }
    /**
     * Constructorul clasei Person
     * @return o persoana cu un nume, varsta si o lista de destinatii
     */

    public Person(String name, int age,List<String> destinations) {
        this.name = name;
        this.age = age;
        this.destinations=destinations;
    }

    /**
     * Metoda getDestinations() returneaza destinatiile persoanei
     * @return destinatiile persoanei
     */
    public List<String> getDestinations() {
        return destinations;
    }


}
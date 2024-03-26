package org.example;

import java.util.List;

/**
 * Clasa Passenger reprezinta un pasager cu un nume, varsta si o lista de destinatii

 */
public class Driver extends Person{

    /**
     * Constructorul clasei Passenger
     * @param name
     * @param age
     * @param destinations
     */
    public Driver(String name, int age, List<String> destinations) {
        super(name, age, destinations);

    }

   /**
     * Metoda toString() returneaza un string cu informatiile despre pasager
     * @return un string cu informatiile despre pasager
     */
    @Override
    public String toString() {
        return "Driver{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge()  +
                ", destinations=" + getDestinations() +
                '}';
    }
}

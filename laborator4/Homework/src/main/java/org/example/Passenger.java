package org.example;

import java.util.List;

/**
 * Clasa Passenger reprezinta un pasager cu un nume, varsta si o lista de destinatii
 * @param <getName>
 */
public class Passenger<getName> extends Person implements Comparable<Passenger>{
    /**
     * Constructorul clasei Passenger
     * @param name
     * @param age
     * @param destinations
     */

    public Passenger(String name, int age, List<String> destinations) {
        super(name, age, destinations);

    }

    /**
     * Metoda compareTo() compara doua obiecte de tip Passenger
     * @param otherPassenger obiectul care este comparat
     * @return
     */


    @Override
    public int compareTo(Passenger otherPassenger)  {
        return this.getName().compareTo(otherPassenger.getName());
    }

    /**
     * Metoda toString() returneaza un string cu informatiile despre pasager
     * @return un string cu informatiile despre pasager
     */
    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", destinations=" + getDestinations() +
                '}';
    }
}

package org.example;

/**
    * Person class
 * @param id
 * @param name
 */
public record Person(int id,String name) {

    /**
     * Constructorul lui Person care arunca exceptii daca id este negativ sau daca name este nul sau gol
     * @param id
     * @param name
     */
    public Person {
        if (id < 0) {
            throw new IllegalArgumentException("id must be positive");
        }
        if (name == null || name.isBlank() ) {
            throw new IllegalArgumentException("name must be non-null");
        }
    }

    /**
     * Metoda toString pentru a afisa  informatii despre o persoana (id si nume)
     * @return
     */

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

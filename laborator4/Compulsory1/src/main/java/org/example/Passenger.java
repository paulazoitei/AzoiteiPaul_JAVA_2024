package org.example;

public class Passenger<getName> extends Person implements Comparable<Passenger>{

    public Passenger(String name, int age) {
        super(name, age);

    }


    @Override
    public int compareTo(Passenger otherPassenger)  {
        return this.getName().compareTo(otherPassenger.getName());
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}

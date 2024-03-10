import java.util.HashSet;
import java.util.Set;

public class Drone extends Vehicle{
    private int flightDuration;

    /**
     * metoda pentru a obtine durata de zbor a unei drone
     * @return durata de zbor a dronei de tip int
     */
    public int getFlightDuration() {
        return flightDuration;
    }


    private static Set<String> droneNames = new HashSet<>();

    /**
     * metoda pentru a seta numele unei drone astfel incat sa fie unic daca numele nu exista se adauga si se seteaza si pentru clasa parinte
     * daca exista se returneaza o exceptie
     * @param name numele dronei de tip String
     */

    @Override
    public void setName(String name) {
        if (!droneNames.contains(name)) {
            droneNames.add(name);
            super.setName(name);
        } else {
            throw new IllegalArgumentException("Drone name must be unique.");
        }
    }

    /**
     * metoda pentru a seta durata de zbor a unei drone
     * @param flightDuration durata de zbor de tip int
     */

    public void setFlightDuration(int flightDuration) {
        if(flightDuration<50) {
            this.flightDuration = flightDuration;
        }
    }
}

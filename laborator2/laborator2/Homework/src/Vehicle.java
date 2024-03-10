import java.time.LocalTime;
import java.util.Random;

public abstract class Vehicle {
    protected String name;
    private Depot depot;
    private LocalTime startTime;
    private LocalTime endTime;

    /**
     * metoda pentru a obtine ora de la care poate merge clientul cu o masina
     * @return ora de la care poate merge clientul cu masina de tip LocalTime
     */
    public LocalTime getStartTime() {
        return startTime;
    }
    /**
     * metoda pentru a obtine ora de la care poate merge clientul cu o masina
     * @return ora de pana la care  merge clientul cu masina de tip LocalTime
     */

    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * constructor  pentru a crea un nou obiect Vehicul și pentru a inițializa numele vehiculului
     * @param name numele vehiculului
     */
    public Vehicle(String name) {
        this.name = name;
    }

    /**
     * metoda pentru a obtine numele vehicului
     * @return numele vehiculului de tip String
     */

    public String getName() {
        return name;
    }

    /**
     * metoda pentru a seta membrul privat cu numele din parametru
     * @param name numele vehiculului
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Constructor pentru  a genera aleatoriu ore și minute pentru startTime și endTime,construiesc obiectele LocalTime pentru startTime și endTime
     * verific dacă endTime este înainte de startTime și inversăm, dacă este cazul
     *
     */

    public Vehicle() {

        Random random = new Random();
        int startHour = random.nextInt(24);
        int startMinute = random.nextInt(60);
        int endHour = random.nextInt(24);
        int endMinute = random.nextInt(60);


        this.startTime = LocalTime.of(startHour, startMinute);
        this.endTime = LocalTime.of(endHour, endMinute);


        if (endTime.isBefore(startTime)) {
            LocalTime temp = startTime;
            startTime = endTime;
            endTime = temp;
        }
    }

    /**
     * metoda pentru a obtine depoul
     * @return obiect de tip depou
     */
    public Depot getDepot() {
        return depot;
    }

    /**
     * metoda pentru obtine numele depoului al unui vehicul
     * @return numele depoului
     */
    public String getDepotName(){ return depot.getName();}

    /**
     * metoda pentru a seta depoul pentru un vehicul
     * @param depot obiectul de tip depou
     */
    public void setDepot(Depot depot) {
        this.depot = depot;
    }
/**
 * metoda pentru a returna detaliile despre un vehicul ,numele si depoul acestuia daca are un depou
 */
    @Override
    public String toString() {
        if (depot == null) {
            return "Vehicle{" +
                    "name='" + name + '\'' +
                    ", depot=" + "it has no depot" +
                    '}';

        } else {
            return "Vehicle{" +
                    "name='" + name + '\'' +
                    ", depot=" + depot.getName() +
                    '}';
        }
    }

    /**
     * metoda pentru a verifica egalitatea intre 2 obiecte de tip Vehicle
     * @param obj vehiculul pentru care se verifica egalitatea
     * @return true daca cele 2 obiecte sun egale ,false daca nu
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return name.equals(other.name);
    }
}


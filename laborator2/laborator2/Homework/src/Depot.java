import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

public class Depot {
    private String name;
    private Vehicle[] vehicles;

    /**
     *constructorul implicit al clasei Depot
     */
    public Depot(){};

    /**
     *
     acest constructor creează o nouă instanță a clasei Depot și îi setează numele folosind valoarea furnizată ca argument name
     * @param name numele depoului
     */
    public Depot(String name) {
        this.name = name;
    }


    /**
     *acest constructor este folosit pentru a crea un nou obiect Depot și pentru a inițializa vehiculele asociate depoului.
     * @param vehicles vehiculele care trebuie initializate in depozit
     */
    public Depot(Vehicle ... vehicles) {
        this.vehicles = vehicles.clone();
        for (Vehicle v : vehicles) {
            v.setDepot(this);
        }
    }

    /**
     * metoda pentru a obtine numelui depoului
     * @return numele depoului
     */
    public String getName() {
        return name;
    }




    private static Set<String> uniqueDepotNames = new HashSet<>();

    /**
     * metoda pentru a seta numele depourilor astfel incat acestea sa fie unice, daca numele adaugat este deja luat atunci se va arunca o exceptie,
     * daca un depou incearca sa si schimbe numele cu numele altui depou atunci acesta va fi sters
     * @param name
     */
    public void setName(String name) {
        if (!uniqueDepotNames.contains(name)) {
            uniqueDepotNames.remove(this.name);
            this.name = name;
            uniqueDepotNames.add(name);
        } else {
            throw new IllegalArgumentException("Depot name must be unique.");
        }
    }

    /**
     * metoda pentru a introduce vehiculele intr un depou,fac un vector de vehicule unice ,verific daca vehiculul este deja asociat cu alt depou
     * daca da ,sarim la urmatorul vehicul,iterez prin vectorul de vehicule daca vehiculul exista se seteaza exists la true,apoi daca
     * exists este fals vehiculul este adaugat la vectorul de vehicule unice
     *
     * @param vehicles
     */
    public void setVehicles(Vehicle... vehicles) {
        if (vehicles == null || vehicles.length == 0) {
            this.vehicles = new Vehicle[0];
            return;
        }

        int uniqueCount = 0;
        Vehicle[] uniqueVehicles = new Vehicle[vehicles.length];

        for (Vehicle v : vehicles) {
            if (v.getDepot() != null && !v.getDepot().equals(this) ) {

                continue;
            }

            boolean exists = false;
            for (int i = 0; i < uniqueCount; i++) {
                if (uniqueVehicles[i].equals(v) ) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                uniqueVehicles[uniqueCount++] = v;
                v.setDepot(this);
            }
        }

        this.vehicles = Arrays.copyOf(uniqueVehicles, uniqueCount);
    }


    /**
     * metoda pentru a obtine vehiculele din vectorul de vehicule
     * @return vehicule din vector
     */

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    /**
     * metoda pentru a afisa depouri si vehiculele din aceste depouri sau daca aceste nu au vehicule
     * @return un String cu numele depoului si vehiculele lui
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Depot's name is ").append(name);
        sb.append(" and the vehicles from it are: ");
        if (vehicles != null) {
            for (Vehicle v : vehicles) {
                sb.append(v.getName()).append(" ");
            }
        } else {
            sb.append("No vehicles");
        }
        return sb.toString();
    }


    /**
     * metoda pentru a verifica egalitatea intre 2 obiecte de tip Depot
     * @param o depoul pentru care se verifica egalitatea
     * @return true daca cele 2 obiecte sun egale ,false daca nu
     */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return Objects.equals(name, depot.name);
    }


}


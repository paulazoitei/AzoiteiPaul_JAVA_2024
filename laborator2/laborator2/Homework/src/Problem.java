import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem {

    private Depot[] depots = new Depot[100];

    private Client[] clients;

    private int size;

    /**
     * metoda pentru a seta depouri si verifica daca nu cumva sunt 2 depouri identice in vectorul de depouri
     * @param newDepot este un obiect de ti depou
     */
    public void setDepot(Depot newDepot) {
        for (int i = 0; i < size; i++) {
            if (depots[i].equals(newDepot)) {
                return;
            }
        }
        depots[size++] = newDepot;
    }

    /**
     * metoda pentru a afisa depourile ,un depou se va afisa doar daca nu este duplicat al altuia
     */
    public void displayDepots() {
        System.out.print("Depots:");
        for (int i = 0; i < size; i++) {
            System.out.println(depots[i].getName());
        }
    }

    /**
     * metoda pentru a obtine depourile implicate in problema
     * @return vector de depouri
     */
    public Depot[] getDepots() {
        return depots;
    }

    /**
     * metoda pentru a obtine clientii care circula cu vehicule
     * @return vector de clienti
     */

    public Client[] getClients() {
        return clients;
    }

    /**
     * metoda pentru a asigna membrului privat clients clientii respectivi
     * @param clients vectorul de clienti
     */

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    /**
     * metoda pentru a obtine toate vehiculele din toate depourile implicate in problema ,am facut o lista pentru toate vehiculele,parcurg
     * toate depourile existente si obtin vehiculele asociate fiecarui depou si le adaug in lista de vehicule
     * @return lista de vehicule convertita intr-un array
     */
    public Vehicle[] getVehicle() {
        List<Vehicle> allVehicles = new ArrayList<>();


        for (int i = 0; i < size; i++) {
            Depot depot = depots[i];

            Vehicle[] depotVehicles = depot.getVehicles();
            if(depotVehicles != null) {
                for (Vehicle vehicle : depotVehicles) {
                    allVehicles.add(vehicle);
                }
            }
        }


        return allVehicles.toArray(new Vehicle[0]);
    }
}


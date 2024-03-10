
import java.util.ArrayList;
import java.util.List;
public class Solution
{
    /**
     * parcurgem lista de vehicule,parcurg lista de clienti,verific daca clientul nu a fost deja asignat,verific disponibilitatea vehiculului in intervalul
     * de timp al clientului,verific ca timpul de inceput sa fie inainte de timpul de final,asignez clientul vehiculului,marchez clientul ca asignat
     * apoi la break trecem la urmatorul nivel
     * acesta metoda asigneaza clientilor vehicule dupa intervalele de timp
     * @param problem obiectul de timp problema unde sunt stocate depourile,vehiculele si clientii aferenti
     */
    public void allocateClients(Problem problem) {
    Depot[] depots = problem.getDepots();
    Client[] clients = problem.getClients();
    Vehicle[] vehicles = problem.getVehicle();


    for (Vehicle vehicle : vehicles) {

        for (Client client : clients) {

            if (!client.isAssigned()) {

                if (client.getMinTime() == null || client.getMaxTime() == null ||
                        (client.getMinTime().isAfter(vehicle.getStartTime()) &&
                                client.getMaxTime().isBefore(vehicle.getEndTime()))) {

                    System.out.println("Assigning client " + client.getName() + " to vehicle " + vehicle.getName());
                    client.setAssigned(true);
                    break;
                }
            }
        }
    }
}
}


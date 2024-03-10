public class Vehicle {
    private String name;
    private Depot depot;
    public Vehicle(){};


    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

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
}
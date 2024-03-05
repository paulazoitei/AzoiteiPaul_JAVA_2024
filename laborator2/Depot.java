public class Depot {
    private String name;
    private Vehicle[] vehicles;
    public Depot(){};
    public Depot(String name) {
        this.name = name;
    }

    public Depot(Vehicle ... vehicles) {
        this.vehicles = vehicles.clone();
        for (Vehicle v : vehicles) {
            v.setDepot(this);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setVehicles(Vehicle ... vehicles) {
        this.vehicles = vehicles;
        for(Vehicle v : vehicles) {
            v.setDepot(this);
        }
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

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


}
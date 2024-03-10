import java.util.HashSet;
import java.util.Set;

public class Truck extends Vehicle{
 private int capacity;

    private static Set<String> truckNames = new HashSet<>();
    @Override
    public void setName(String name) {
        if (!truckNames.contains(name)) {
            truckNames.add(name);
            super.setName(name);
        } else {
            throw new IllegalArgumentException("Truck name must be unique.");
        }
    }
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


}

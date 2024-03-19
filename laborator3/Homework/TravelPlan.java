import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a travel plan, which is a list of trips.

 */
public class TravelPlan {
    private List<Trip> trips;

    /**
     * Constructor for the TravelPlan class.
     */
    public TravelPlan() {
        this.trips = new ArrayList<>();
    }

    /**
     * Adds a trip to the travel plan.
     * @param trip
     */
    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    /**
     * Returns the list of trips in the travel plan.
     * @return
     */
    public List<Trip> getTrips() {
        return trips;
    }

    /**
     * Returns a string representation of the travel plan.
     * @return
     */

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Travel Plan:\n");
        for (Trip trip : trips) {
            stringBuilder.append("City: ").append(trip.getCity()).append("\n");
            stringBuilder.append("Start Date: ").append(trip.getStart()).append("\n");
            stringBuilder.append("End Date: ").append(trip.getEnd()).append("\n");
            stringBuilder.append("Attractions:\n");
            for (Attraction attraction : trip.getAttractions()) {
                stringBuilder.append("\tAttraction Name: ").append(attraction.getName()).append("\n");
                stringBuilder.append("\tVisiting Dates: ");
                List<LocalDate> visitingDates = trip.getVisitingDates(attraction);
                if (visitingDates.isEmpty()) {
                    stringBuilder.append("No visiting dates available\n");
                } else {
                    for (LocalDate date : visitingDates) {
                        stringBuilder.append(date).append(" ");
                    }
                    stringBuilder.append("\n");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
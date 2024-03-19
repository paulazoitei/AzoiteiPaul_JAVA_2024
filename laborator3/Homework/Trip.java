//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.*;

/**
 * This class is used to create a trip object.

 */
public class Trip {
    private String city;
    private LocalDate start;
    private LocalDate end;
    private List<Attraction> attractions = new ArrayList();

    /**
     * Constructor for the Trip class.
     * @param city
     * @param start
     * @param end
     * @param attractions
     */
    public Trip(String city, LocalDate start, LocalDate end, List<Attraction> attractions) {
        this.city = city;
        this.start = start;
        this.end = end;
        this.attractions = attractions;
    }

    /**
     * This method is used to get the city of the trip.
     * @return city
     */

    public String getCity() {
        return this.city;
    }

    /**
     * This method is used to set the city of the trip.
     * @param city
     */

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method is used to get the start date of the trip.
     * @return start
     */

    public LocalDate getStart() {
        return this.start;
    }

    /**
     * This method is used to set the start date of the trip.
     * @param start
     */

    public void setStart(LocalDate start) {
        this.start = start;
    }

    /**
     * This method is used to get the end date of the trip.
     * @return end
     */
    public LocalDate getEnd() {
        return this.end;
    }

    /**
     * This method is used to set the end date of the trip.
     * @param end
     */
    public void setEnd(LocalDate end) {
        this.end = end;
    }

    /**
     * This method is used to get the attractions of the trip.
     * @return
     */

    public List<Attraction> getAttractions() {
        return this.attractions;
    }

    /**
     * This method is used to set the attractions of the trip.
     * @param attractions
     */

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    /**
     * This method is used to add an attraction to the trip.
     * @return
     */

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Trip{city='").append(this.city).append('\'');
        stringBuilder.append(", start=").append(this.start);
        stringBuilder.append(", end=").append(this.end);
        stringBuilder.append(", attractions=[");
        Iterator var2 = this.attractions.iterator();

        while(var2.hasNext()) {
            Attraction attraction = (Attraction)var2.next();
            stringBuilder.append(attraction.getName1()).append(", ");
        }

        if (!this.attractions.isEmpty()) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }

        stringBuilder.append("]}");
        return stringBuilder.toString();
    }

    /**
     * This method is used to display the visitable attractions of the trip.
     */
    public void displayVisitableNonPayableAttractions() {
        List<Attraction> visitableNonPayableAttractions = new ArrayList<>(attractions);

        // Sortăm lista după ora de deschidere a fiecărei atracții
        visitableNonPayableAttractions.sort(new Comparator<Attraction>() {
            @Override
            public int compare(Attraction attraction1, Attraction attraction2) {
                LocalTime openingTime1 = getEarliestOpeningTime(attraction1);
                LocalTime openingTime2 = getEarliestOpeningTime(attraction2);

                // Comparăm orele de deschidere
                return openingTime1.compareTo(openingTime2);
            }

            /**
             * This method is used to get the earliest opening time of an attraction.
             * @param attraction
             * @return
             */
            private LocalTime getEarliestOpeningTime(Attraction attraction) {
                Map<LocalDate, Pair<LocalTime, LocalTime>> timetable = attraction.getVisitingTimetable();
                LocalTime earliestOpeningTime = LocalTime.MAX;
                if (timetable != null && !timetable.isEmpty()) {
                    for (Pair<LocalTime, LocalTime> timePair : timetable.values()) {
                        if (timePair.getFirst().compareTo(earliestOpeningTime) < 0) {
                            earliestOpeningTime = timePair.getFirst();
                        }
                    }
                }
                return earliestOpeningTime;
            }
        });

        // Afisam atracțiile sortate
        System.out.println("Visitable Non-Payable Attractions (sorted by opening hour):");
        for (Attraction attraction : visitableNonPayableAttractions) {
            System.out.println(attraction.getName());
        }
    }

    /**
     * This method is used to get the visiting dates of an attraction.
     * @param attraction
     * @return
     */
    public List<LocalDate> getVisitingDates(Attraction attraction) {
        List<LocalDate> visitingDates = new ArrayList<>();
        Map<LocalDate, Pair<LocalTime, LocalTime>> attractionTimetable = attraction.getVisitingTimetable();

        // Iterate through the attraction's timetable
        if (attractionTimetable != null && !attractionTimetable.isEmpty()) {
            for (LocalDate date : attractionTimetable.keySet()) {
                // Check if the date falls within the trip's duration
                if (!date.isBefore(start) && !date.isAfter(end)) {
                    visitingDates.add(date);
                }
            }
        }

        return visitingDates;
    }





}


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Homework {
    public static void main(String[] args)
    {
        Church c1=new Church("Santa Clara");
        Statue s1=new Statue("Statue of liberty");
        Statue s2=new Statue("Stephen the great Statue");
        Church c2=new Church("Sacre Coeur");
        Statue s3=new Statue("Ioana d'Arc's Statue");
        List<Attraction> attractions = new ArrayList<>();
        attractions.add(c1);
        attractions.add(s1);
        attractions.add(s2);
        List<Attraction> attractions1=new ArrayList<>();
        attractions1.add(c2);
        attractions1.add(s3);

        Trip trip = new Trip("Orlando", LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 7),attractions);
        Trip trip1=new Trip("Paris",LocalDate.of(2024,3,2),LocalDate.of(2024,3,30),attractions1);
        Concert cr1=new Concert("Beach Please");
        cr1.setTicketPrice(500);




        Map<LocalDate, Pair<LocalTime, LocalTime>> visitingTimetable1 = new LinkedHashMap<>();
        visitingTimetable1.put(LocalDate.of(2024, 4, 5), new Pair<>(LocalTime.of(1, 36), LocalTime.of(18, 0)));


        Map<LocalDate, Pair<LocalTime, LocalTime>> visitingTimetable2 = new LinkedHashMap<>();
        visitingTimetable2.put(LocalDate.of(2024, 4, 6), new Pair<>(LocalTime.of(5, 50), LocalTime.of(19, 30)));

        Map<LocalDate, Pair<LocalTime, LocalTime>> visitingTimetable3 = new LinkedHashMap<>();
        visitingTimetable3.put(LocalDate.of(2024, 3, 15), new Pair<>(LocalTime.of(3, 37), LocalTime.of(18, 0)));

        Map<LocalDate, Pair<LocalTime, LocalTime>> visitingTimetable4 = new LinkedHashMap<>();
        visitingTimetable4.put(LocalDate.of(2024, 5, 18), new Pair<>(LocalTime.of(1, 36), LocalTime.of(18, 0)));

        Map<LocalDate, Pair<LocalTime, LocalTime>> visitingTimetable5 = new LinkedHashMap<>();
        visitingTimetable5.put(LocalDate.of(2024, 6, 5), new Pair<>(LocalTime.of(4, 45), LocalTime.of(19, 0)));

        Map<LocalDate, Pair<LocalTime, LocalTime>> visitingTimetable6 = new LinkedHashMap<>();
        visitingTimetable6.put(LocalDate.of(2024, 8, 5), new Pair<>(LocalTime.of(6, 45), LocalTime.of(19, 0)));




        s1.setVisitingTimetable(visitingTimetable1);
        s2.setVisitingTimetable(visitingTimetable2);
        s3.setVisitingTimetable(visitingTimetable3);
        c2.setVisitingTimetable(visitingTimetable4);
        cr1.setVisitingTimetable(visitingTimetable5);
        c1.setVisitingTimetable(visitingTimetable6);


        LocalDate date = LocalDate.of(2024, 4, 2);
        LocalTime openingHour = s1.getOpeningHour(date);
        System.out.println(openingHour);
        System.out.println();


        System.out.println(s1);
        System.out.println(s2);
        System.out.println(cr1);
        System.out.println(c2);
        System.out.println();

        System.out.println(trip);

        trip.displayVisitableNonPayableAttractions();
        TravelPlan travelPlan=new TravelPlan();
        travelPlan.addTrip(trip);
        travelPlan.addTrip(trip1);
        System.out.println();
        System.out.println(travelPlan);

    }
}

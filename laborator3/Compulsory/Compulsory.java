
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Compulsory {
    public static void main(String[] args)
    {
        Church c1=new Church("Santa Clara");
        Statue s1=new Statue("Statue of liberty");
        List<Attraction> attractions = new ArrayList<>();
        attractions.add(c1);
        attractions.add(s1);
        Trip trip = new Trip("Orlando", LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 7),attractions);
       Concert cr1=new Concert("Beach Please");
       cr1.setTicketPrice(500);


        Map<DayOfWeek, Pair<LocalTime, LocalTime>> visitingTimetable = new LinkedHashMap<>();
        visitingTimetable.put(DayOfWeek.MONDAY, new Pair<>(LocalTime.of(9, 0), LocalTime.of(18, 0)));
        visitingTimetable.put(DayOfWeek.TUESDAY, new Pair<>(LocalTime.of(10, 30), LocalTime.of(18, 30)));
        visitingTimetable.put(DayOfWeek.WEDNESDAY, new Pair<>(LocalTime.of(8, 0), LocalTime.of(18, 45)));
        visitingTimetable.put(DayOfWeek.THURSDAY, new Pair<>(LocalTime.of(9, 0), LocalTime.of(18, 0)));
        visitingTimetable.put(DayOfWeek.FRIDAY, new Pair<>(LocalTime.of(9, 30), LocalTime.of(19, 30)));
        visitingTimetable.put(DayOfWeek.SATURDAY, new Pair<>(LocalTime.of(7, 0), LocalTime.of(22, 0)));
        visitingTimetable.put(DayOfWeek.SUNDAY, new Pair<>(LocalTime.of(8, 0), LocalTime.of(21, 0)));
        Map<DayOfWeek, Pair<LocalTime, LocalTime>> visitingTimetable1 = new LinkedHashMap<>();
        visitingTimetable1.put(DayOfWeek.MONDAY, new Pair<>(LocalTime.of(11, 0), LocalTime.of(18, 0)));
        visitingTimetable1.put(DayOfWeek.TUESDAY, new Pair<>(LocalTime.of(11, 30), LocalTime.of(18, 30)));
        visitingTimetable1.put(DayOfWeek.WEDNESDAY, new Pair<>(LocalTime.of(11, 0), LocalTime.of(18, 45)));
        visitingTimetable1.put(DayOfWeek.THURSDAY, new Pair<>(LocalTime.of(3, 0), LocalTime.of(18, 0)));
        visitingTimetable1.put(DayOfWeek.FRIDAY, new Pair<>(LocalTime.of(5, 30), LocalTime.of(19, 30)));
        visitingTimetable1.put(DayOfWeek.SATURDAY, new Pair<>(LocalTime.of(2, 0), LocalTime.of(22, 0)));
        visitingTimetable1.put(DayOfWeek.SUNDAY, new Pair<>(LocalTime.of(4, 0), LocalTime.of(21, 0)));
        cr1.setVisitingTimetable(visitingTimetable1);

        c1.setVisitingTimetable(visitingTimetable);
        s1.setVisitingTimetable(visitingTimetable);


        System.out.println(c1);
        System.out.println(s1);
        System.out.println(trip);
        System.out.println(cr1);
    }
}

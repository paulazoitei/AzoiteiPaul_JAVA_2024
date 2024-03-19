//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public interface Visitable {
    void setStart(LocalTime var1);

    LocalTime getStart();

    void setEnd(LocalTime var1);

    LocalTime getEnd();
    default LocalTime getOpeningHour(LocalDate date) {
        Map<LocalDate, Pair<LocalTime, LocalTime>> visitingTimetable = getVisitingTimetable();
        if (visitingTimetable != null && visitingTimetable.containsKey(date)) {
            return visitingTimetable.get(date).getFirst();
        } else {
            // If the visiting timetable doesn't contain information for the provided date,
            // return a default opening hour
            return LocalTime.of(9, 0); // Default opening hour at 9:00 AM
        }
    }

    // This is just for reference, you may need to adjust the method signature according to your actual implementation
    Map<LocalDate, Pair<LocalTime, LocalTime>> getVisitingTimetable();


}

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;


public abstract class Attraction {
    private String name;
    private LocalTime start,end;
    private Map<DayOfWeek, Pair<LocalTime, LocalTime>> visitingTimetable;

    public Attraction(){
        this.name=name;
    };

    public void setVisitingTimetable(Map<DayOfWeek, Pair<LocalTime, LocalTime>> visitingTimetable) {
        this.visitingTimetable = visitingTimetable;
    }

    public Map<DayOfWeek, Pair<LocalTime, LocalTime>> getVisitingTimetable() {
        return visitingTimetable;
    }
    public Attraction(String name) {
        this.name = name;
    }
    public void setStart(LocalTime start) {
        this.start=start;
    }


    public LocalTime getStart() {
        return start;
    }


    public void setEnd(LocalTime end) {
       this.end=end;
    }


    public LocalTime getEnd() {
        return end;
    }



public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Attraction{name='").append(name).append('\'').append(", visitingTimetable={");
    if (visitingTimetable != null) {
        visitingTimetable.forEach((day, interval) -> {
            stringBuilder.append("\n").append(day).append(": ");
            stringBuilder.append("from ").append(interval.getFirst()).append(" to ").append(interval.getSecond());
        });

        stringBuilder.append("\n}}");

        // Verificăm dacă obiectul este de tip Payable
        if (this instanceof Payable) {
            Payable payableAttraction = (Payable) this;
            stringBuilder.append(", ticketPrice=").append(payableAttraction.getTicketPrice());
        }
    }

    return stringBuilder.toString();
}


    public char[] getName1() {
        // Convertim numele într-un șir de caractere
        return name.toCharArray();
    }
}

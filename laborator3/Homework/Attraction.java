//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Map;

/**
 * This class is used to create an attraction object.

 */
public abstract class Attraction {
    private String name;
    private LocalTime start;
    private LocalTime end;
    private Map<LocalDate, Pair<LocalTime, LocalTime>> visitingTimetable;

    /**
     * This method is used to set the name of the attraction.
     * @param visitingTimetable
     */
    public void setVisitingTimetable(Map<LocalDate, Pair<LocalTime, LocalTime>> visitingTimetable) {
        this.visitingTimetable = visitingTimetable;
    }

    /**
     * This method is used to get the visiting timetable of the attraction.
     * @return
     */

    public Map<LocalDate, Pair<LocalTime, LocalTime>> getVisitingTimetable() {
        return this.visitingTimetable;
    }

    /**
     * This method is used to set the name of the attraction.
     */
    public Attraction() {
        this.name = this.name;
    }

    /**
     *  Constructor for the Attraction class.
     * @return name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * This method is used to set the name of the attraction.
     * @param name
     */
    public Attraction(String name) {
        this.name = name;
    }

    /**
     * This method is used to set the name of the attraction.
     * @param start
     */

    public void setStart(LocalTime start) {
        this.start = start;
    }

    /**
     * This method is used to get the start time of the attraction.
     * @return
     */

    public LocalTime getStart() {
        return this.start;
    }

    /**
     * This method is used to set the end time of the attraction.
     * @param end
     */

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    /**
     * This method is used to get the end time of the attraction.
     * @return
     */

    public LocalTime getEnd() {
        return this.end;
    }

    /**
     * This method is used to get the visiting timetable of the attraction.
     * @return visitingTimetable
     */

@Override
public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Attraction{name='").append(name).append('\'');

    if (this.getVisitingTimetable() != null && !this.getVisitingTimetable().isEmpty()) {
        stringBuilder.append(", visitingTimetable={");
        this.getVisitingTimetable().forEach((date, interval) -> {
            stringBuilder.append("\n").append(date).append(": ");
            stringBuilder.append("from ").append(interval.getFirst()).append(" to ").append(interval.getSecond());
        });
        stringBuilder.append("\n}");
    } else {
        stringBuilder.append(", No visiting timetable available");
    }

    // Verificăm dacă datele din visitingTimetable sunt asociate cu instanța curentă
    if (this.getVisitingTimetable() != null && this.getVisitingTimetable().containsKey(LocalDate.now())) {
        Pair<LocalTime, LocalTime> currentInterval = this.getVisitingTimetable().get(LocalDate.now());
        stringBuilder.append(", Current visiting interval: ");
        stringBuilder.append("from ").append(currentInterval.getFirst()).append(" to ").append(currentInterval.getSecond());
    }

    // Verificăm dacă este o instanță a unei subclase și adăugăm informații specifice
    if (this instanceof Payable) {
        Payable payableAttraction = (Payable) this;
        stringBuilder.append(", ticketPrice=").append(payableAttraction.getTicketPrice());
    }

    return stringBuilder.toString();
}

    /**
     * This method is used to get the name of the attraction.
     * @return
     */
    public char[] getName1() {
        return this.name.toCharArray();
    }

    /**
     * This method is used to get the visiting date of the attraction.
     * @return visitDate
     */
    public LocalDate getVisitDate() {
        // Parcurgem mapa de vizitare și returnăm prima dată de vizitare disponibilă
        if(visitingTimetable != null && !visitingTimetable.isEmpty())

        for (Map.Entry<LocalDate, Pair<LocalTime, LocalTime>> entry : visitingTimetable.entrySet()) {
            return entry.getKey();
        }
        // Dacă nu există date de vizitare, putem arunca o excepție sau returna null, în funcție de cerințe.
        // În acest exemplu, vom returna null.
        return null;

    }
}

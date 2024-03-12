import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trip {
    private String city;
    private LocalDate start, end;
    private List<Attraction> attractions = new ArrayList<>();
    public Trip(String city, LocalDate start, LocalDate end, List<Attraction> attractions) {
        this.city = city;
        this.start = start;
        this.end = end;
        this.attractions = attractions;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Trip{city='").append(city).append('\'');
        stringBuilder.append(", start=").append(start);
        stringBuilder.append(", end=").append(end);
        stringBuilder.append(", attractions=[");

        // Adăugăm numele atracțiilor la șir
        for (Attraction attraction : attractions) {
            stringBuilder.append(attraction.getName1()).append(", ");
        }

        // Ștergem ultima virgulă și spațiul după ultimul nume
        if (!attractions.isEmpty()) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }

        stringBuilder.append("]}");
        return stringBuilder.toString();
    }
}


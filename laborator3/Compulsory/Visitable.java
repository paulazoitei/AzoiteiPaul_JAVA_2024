import java.time.LocalDate;
import java.time.LocalTime;

public interface Visitable {

     void setStart(LocalTime start);
     LocalTime getStart();

     void setEnd(LocalTime end);
     LocalTime getEnd();


}

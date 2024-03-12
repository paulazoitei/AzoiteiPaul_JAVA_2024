import java.time.LocalTime;

public class Statue extends Attraction implements Visitable{
    private LocalTime start,end;
    public Statue(String name) {
        super(name);
    }

    public void setStart(LocalTime start)
    {
        this.start=start;
    }
    public LocalTime getStart()
    {
        return start;
    }
    public void setEnd(LocalTime end)
    {
        this.end=end;
    }
    public LocalTime getEnd()
    {
        return end;
    }

}

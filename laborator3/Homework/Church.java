import java.time.LocalTime;

/**
 * This class is used to create a church object.

 */
public class Church extends Attraction implements  Visitable{
    private LocalTime start,end;
    private String name;

    /**
     * Constructor for the Church class.
     * @param name
     */
    public Church(String name) {
        super(name);
    }

    /**
     * This method is used to set the start time of the church.
     * @param start
     */

    public void setStart(LocalTime start)
    {
        this.start=start;
    }

    /**
     * This method is used to get the start time of the church.
     * @return start
     */
    public LocalTime getStart()
    {
        return start;
    }

    /**
     * This method is used to set the end time of the church.
     * @param end
     */
    public void setEnd(LocalTime end)
    {
        this.end=end;
    }

    /**
     * This method is used to get the end time of the church.
     * @return end
     */
    public LocalTime getEnd()
    {
        return end;
    }
}

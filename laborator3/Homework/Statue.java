//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.LocalTime;

/**
 * This class is used to create a statue object.
 */
public class Statue extends Attraction implements Visitable {
    private LocalTime start;
    private LocalTime end;

    /**
     * Constructor for the Statue class.
     * @param name
     */
    public Statue(String name) {
        super(name);
    }

    /**
     * This method is used to set the start time of the statue.
     * @param start
     */
    public void setStart(LocalTime start) {
        this.start = start;
    }

    /**
     * This method is used to get the start time of the statue.
     * @return
     */

    public LocalTime getStart() {
        return this.start;
    }

    /**
     * This method is used to set the end time of the statue.
     * @param end
     */

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    /**
     * This method is used to get the end time of the statue.
     * @return
     */

    public LocalTime getEnd() {
        return this.end;
    }
}

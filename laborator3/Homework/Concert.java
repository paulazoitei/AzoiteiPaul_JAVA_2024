//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

/**
 * This class is used to create a concert object.

 */
public class Concert extends Attraction implements Payable, Visitable {
    private String name;
    private double ticketPrice;

    /**
     *  Constructor for the Concert class.
     * @param name
     */
    public Concert(String name) {
        super(name);
    }

    /**
     *  This method is used to set the start time of the concert.
     * @return
     */
    public double getTicketPrice() {
        return this.ticketPrice;
    }

    /**
     * This method is used to get the ticket price of the concert.
     * @param ticketPrice
     */

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    /**
     * This method is used to get the name of the concert.
     * @return
     */

    public String getName() {
        return this.name;
    }

    /**
     * This method is used to set the name of the concert.
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }
}

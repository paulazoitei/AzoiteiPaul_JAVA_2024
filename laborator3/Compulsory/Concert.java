import java.time.LocalTime;

public class Concert extends Attraction implements Payable,Visitable {
    private String name;

    private double ticketPrice;

    public Concert(String name) {
        super(name);
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}


import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;


public class Homework {
    public static void main(String[] args) {
              Truck t1=new Truck();
              t1.setName("Man");
              Truck t3=new Truck();
              t3.setName("Scania");
              Drone dr1=new Drone();
              dr1.setName("Asus");
              Depot d1 =new Depot();
              Depot d2=new Depot();
              Depot d3=new Depot();
              d1.setName("Industrial Depot");
              d2.setName("Highway Depot");
              d3.setName("Airport Depot");
              Client c1=new Client();
        c1.setName("Emil");
        c1.setMinTime(LocalTime.of(3,0));
        c1.setMaxTime(LocalTime.of(6,35));
        c1.setType(ClientType.PREMIUM);
                Client c2=new Client();
                c2.setName("Mircea");
        c2.setMinTime(LocalTime.of(5,22));
        c2.setMaxTime(LocalTime.of(8,49));
        c2.setType(ClientType.REGULAR);
        Client c3=new Client();
        c3.setName("Gorcea");
        c2.setMinTime(LocalTime.of(4,21));
        c2.setMaxTime(LocalTime.of(6,45));
        c2.setType(ClientType.REGULAR);

        System.out.println(c1);
        System.out.println(c2);
              d1.setVehicles(t1,t3);
              d2.setVehicles(t3,t1,dr1);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);


        Problem p1=new Problem();
        p1.setDepot(d1);
        p1.setDepot(d2);
        p1.setDepot(d3);
        p1.setClients(new Client[] {c1, c2,c3});

        p1.displayDepots();
        System.out.println(Arrays.toString(p1.getVehicle()));
        Solution s1=new Solution();
        s1.allocateClients(p1);





        }
    }

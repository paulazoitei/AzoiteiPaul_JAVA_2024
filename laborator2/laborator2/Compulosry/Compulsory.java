import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;


public class Compulsory {
    public static void main(String[]args)
    {
      Client c1=new Client();
      c1.setName("Paul");
      c1.setMinTime(LocalTime.of(6,0));
      c1.setMaxTime(LocalTime.of(9,45));
      c1.setType(ClientType.PREMIUM);

        System.out.println(c1);

      Client c2=new Client();
      c2.setName("Alex");
      c2.setMinTime(LocalTime.of(3,35));
      c2.setMaxTime(LocalTime.of(12,22));
      c2.setType(ClientType.REGULAR);
        System.out.println(c2);



        Vehicle v1=new Vehicle();
        v1.setName("Bentley");
        System.out.println(v1);

        Vehicle v2=new Vehicle();
        v2.setName("Aston Martin");
        System.out.println(v2);

        Vehicle v3=new Vehicle();
        v3.setName("Lamborghini");
        System.out.println(v3);

     Depot d1=new Depot();
     d1.setName("Station Depot");
     d1.setVehicles(v1,v2);
        System.out.println(d1);

        Depot d2=new Depot();
        d2.setName("Airport Depot");
        d2.setVehicles(v3);
        System.out.println(d2);
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

    }
}


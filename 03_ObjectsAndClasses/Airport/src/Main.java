import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        airport.getAllAircrafts();
        System.out.println( airport.getAllAircrafts() );
        airport.getAllAircrafts().size();

        int i = airport.getAllAircrafts().size();
        System.out.println(i);






    }
}

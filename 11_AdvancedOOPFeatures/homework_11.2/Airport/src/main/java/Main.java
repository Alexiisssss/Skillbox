import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    Airport airport = Airport.getInstance();
    findPlanesLeavingInTheNextTwoHours(airport);
  }

  public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
    LocalDateTime dateNow = LocalDateTime.now();
    return airport.getTerminals().stream().flatMap(terminal -> terminal.getFlights().stream())
        .filter(flight -> flight.getType() == Flight.Type.DEPARTURE)
        .filter(flight -> (changedDateTime(flight.getDate()).isAfter(dateNow)
            && (changedDateTime(flight.getDate()).isBefore(dateNow.plusHours(2)))))
        .collect(Collectors.toList());
  }

  public static LocalDateTime changedDateTime(Date date) {
    return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
  }
}



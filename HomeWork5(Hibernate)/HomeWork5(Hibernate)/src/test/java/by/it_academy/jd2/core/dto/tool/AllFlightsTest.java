package by.it_academy.jd2.core.dto.tool;


import by.it_academy.jd2.core.dto.tool.api.AllFlightsInt;
import by.it_academy.jd2.core.dto.view.Flights;
import by.it_academy.jd2.data.ConnectionBase;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AllFlightsTest {
    private final String ORDER_BY = " order by scheduled_departure";
    private final String PAGE = " offset %d fetch next 25 rows only";
    private final String CHOICE_FLIGHTS = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city"
            + " from flights_v "
            + " WHERE ( departure_city='%s') and ( arrival_city='%s')";
    private final String CHOICE_FLIGHTS_TEST = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city"
            + " from flights_v "
            + " WHERE ( departure_city='Москва') and ( arrival_city='Воронеж')" ;
    private final String SCH_DEP_NON_NULL = " and (scheduled_departure BETWEEN '2017-07-04' AND '2017-07-05')";
    private final String SCH_ARR_NON_NULL = " and (scheduled_arrival BETWEEN '2017-07-04' AND '2017-07-05')";
    private final String PAGE_TEST = " offset 25 fetch next 25 rows only";
    private final String DEP_CITY ="Москва";
    private final String ARR_CITY = "Воронеж";
    private final String SCH_DEP = "2017-07-04";
    private final String SCH_ARR = "2017-07-04";


    @Test
    void classDefinition() {
        AllFlights flights = new AllFlights();
        Assert.assertTrue(flights instanceof AllFlights);
    }

    @Test
    void getChoiceFlights() {
        AllFlightsInt allFlightsInt = new AllFlights();
        String actual = allFlightsInt.getChoiceFlights(DEP_CITY, ARR_CITY, SCH_DEP, SCH_ARR).toString();
        String select = CHOICE_FLIGHTS_TEST+SCH_ARR_NON_NULL+SCH_DEP_NON_NULL+ORDER_BY;
        List<Flights> allFlight = getFlightsList(select);
        String ex = allFlight.toString();
        assertEquals(ex, actual);


    }

    @Test
    void getChoiceFlightsNoSchDep() {
        AllFlightsInt allFlightsInt = new AllFlights();
        String actual = allFlightsInt.getChoiceFlights(DEP_CITY, ARR_CITY, "", SCH_ARR).toString();
        String select = CHOICE_FLIGHTS_TEST+SCH_ARR_NON_NULL+ORDER_BY;
        List<Flights> AllFlight = getFlightsList(select);
        String ex = AllFlight.toString();
        assertEquals(ex, actual);

    }

    @Test
    void getChoiceFlightsNoSchArr() {
        AllFlightsInt allFlightsInt = new AllFlights();
        String actual = allFlightsInt.getChoiceFlights(DEP_CITY, ARR_CITY, SCH_DEP, "").toString();
        String select = CHOICE_FLIGHTS_TEST+SCH_DEP_NON_NULL+ORDER_BY;
        List<Flights> AllFlight = getFlightsList(select);
        String ex = AllFlight.toString();
        assertEquals(ex, actual);
    }

    @Test
    void getChoiceFlightsNoTime() {
        AllFlightsInt allFlightsInt = new AllFlights();
        String actual = allFlightsInt.getChoiceFlights(DEP_CITY, ARR_CITY, "", "").toString();
        String select = CHOICE_FLIGHTS_TEST+ORDER_BY;
        List<Flights> AllFlight = getFlightsList(select);
        String ex = AllFlight.toString();
        assertEquals(ex, actual);
    }

    @Test
    void getChoiceFlightsNoDateWithPage() {
        AllFlightsInt allFlightsInt = new AllFlights();
        String ac = allFlightsInt.getChoiceFlightsNoDateWithPage(DEP_CITY, ARR_CITY, 2).toString();
        String select =CHOICE_FLIGHTS_TEST+ORDER_BY+PAGE_TEST;
        List<Flights> AllFlight = getFlightsList(select);
        String ex = AllFlight.toString();
        assertEquals(ex, ac);


    }

    @Test
    void selectGetChoiceFlightsNoDateWithPage() {
        String depAirport = DEP_CITY;
        String arrAirport = ARR_CITY;
        Integer page = 2;
        String ex = CHOICE_FLIGHTS_TEST+ORDER_BY+PAGE_TEST;
        String ac = String.format(CHOICE_FLIGHTS + ORDER_BY + PAGE, depAirport, arrAirport, 25 * (page.intValue() - 1));
        assertEquals(ex, ac);
    }

    @Test
    void getChoiceFlightsExperement() {
        AllFlightsInt allFlightsInt = new AllFlights();
        String ac = allFlightsInt.getChoiceFlightsExperement().toString();
        String select = CHOICE_FLIGHTS_TEST+SCH_DEP_NON_NULL+SCH_ARR_NON_NULL;
        List<Flights> AllFlight = getFlightsList(select);
        String ex = AllFlight.toString();
        assertEquals(ex, ac);


    }

    @Test
    void listOfTitlesForFlightsWhithAllParam() {
        AllFlightsInt allFlightsInt = new AllFlights();
        String ex = "Flights{flight_no='flight_no', status='status', scheduled_departure='scheduled_departure', scheduled_arrival='scheduled_arrival', departure_airport='(departure_airport)departure_city', arrival_airport='(arrival_airport)arrival_city'}";
        String ac = allFlightsInt.ListOfTitlesForFlightsWhithAllParam().toString();
        assertEquals(ex, ac);

    }


    private static List<Flights> getFlightsList(String select) {
        List<Flights> AllFlight = new ArrayList<>();
        try (Connection connection = ConnectionBase.getInstance().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(select);
             ResultSet rs = pStatement.executeQuery()) {

            while (rs.next()) {
                Flights flights = new Flights();
                flights.setFlight_no(rs.getString(1));
                flights.setStatus(rs.getString(2));


                flights.setScheduled_departure(rs.getString(3));
                flights.setScheduled_arrival(rs.getString(4));
                flights.setDeparture_airport("(" + rs.getString(5) + ")" + rs.getString(6));
                flights.setArrival_airport("(" + rs.getString(7) + ")" + rs.getString(8));
                AllFlight.add(flights);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return AllFlight;
    }
}
package by.it_academy.jd2.core.dto.tool;

import by.it_academy.jd2.core.dto.view.Flights;
import by.it_academy.jd2.data.ConnectionBase;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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
    private static String OrderBy = " order by scheduled_departure";
    private static String Page = " offset %d fetch next 25 rows only";
    private static String ChoiceFlights = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city"
            + " from flights_v "
            + " WHERE ( departure_airport='%s') and ( arrival_airport='%s')";

    private Connection connection;

    @BeforeAll
    private void connectionBase() {
        try {
            connection = new ConnectionBase().getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void classDefinition() {
        AllFlights flights = new AllFlights();
        Assert.assertTrue(flights instanceof AllFlights);
    }

    @Test
    void getChoiceFlights() {
        String actual = AllFlights.getChoiceFlights(connection, "DSE", "SER", "2017-07-04", "2017-07-04").toString();
        String select = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city" +
                " from flights_v  " +
                "WHERE ( departure_airport='DSE') and ( arrival_airport='SER') " +
                "and (scheduled_departure BETWEEN '2017-07-04' AND '2017-07-05') " +
                "and (scheduled_arrival BETWEEN '2017-07-04' AND '2017-07-05')" +
                " order by scheduled_departure";
        List<Flights> AllFlight = getFlightsList(connection, select);
        String ex = AllFlight.toString();
        assertEquals(ex, actual);


    }
    @Test
    void getChoiceFlightsNoSchDep() {
        String actual = AllFlights.getChoiceFlights(connection, "DSE", "SER", "1900-01-01", "2017-07-04").toString();
        String select = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city" +
                " from flights_v  " +
                "WHERE ( departure_airport='DSE') and ( arrival_airport='SER') " +
                "and (scheduled_arrival BETWEEN '2017-07-04' AND '2017-07-05')" +
                " order by scheduled_departure";
        List<Flights> AllFlight = getFlightsList(connection, select);
        String ex = AllFlight.toString();
        assertEquals(ex, actual);

    }

    @Test
    void getChoiceFlightsNoSchArr() {
        String actual = AllFlights.getChoiceFlights(connection, "DSE", "SER", "2017-07-04", "1900-01-01").toString();
        String select = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city" +
                " from flights_v  " +
                "WHERE ( departure_airport='DSE') and ( arrival_airport='SER') " +
                "and (scheduled_departure BETWEEN '2017-07-04' AND '2017-07-05') " +
                " order by scheduled_departure";
        List<Flights> AllFlight = getFlightsList(connection, select);
        String ex = AllFlight.toString();
        assertEquals(ex, actual);
    }
    @Test
    void getChoiceFlightsNoTime() {
        String actual = AllFlights.getChoiceFlights(connection, "DSE", "SER", "1900-01-01", "1900-01-01").toString();
        String select = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city" +
                " from flights_v  " +
                "WHERE ( departure_airport='DSE') and ( arrival_airport='SER') " +
                " order by scheduled_departure";
        List<Flights> AllFlight = getFlightsList(connection, select);
        String ex = AllFlight.toString();
        assertEquals(ex, actual);
    }

    @Test
    void getChoiceFlightsNoDateWithPage() {
        String ac = AllFlights.getChoiceFlightsNoDateWithPage(connection, "DSE", "SER", 2).toString();
        String select = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city from flights_v  WHERE ( departure_airport='DSE') and ( arrival_airport='SER') order by scheduled_departure offset 25 fetch next 25 rows only";
        List<Flights> AllFlight = getFlightsList(connection, select);
        String ex = AllFlight.toString();
        assertEquals(ex, ac);


    }

    @Test
    void selectGetChoiceFlightsNoDateWithPage() {
        String depAirport = "DSE";
        String arrAirport = "SER";
        Integer page = 2;
        String ex = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city from flights_v  WHERE ( departure_airport='DSE') and ( arrival_airport='SER') order by scheduled_departure offset 25 fetch next 25 rows only";
        String ac = String.format(ChoiceFlights + OrderBy + Page, depAirport, arrAirport, 25 * (page.intValue() - 1));
        assertEquals(ex, ac);
    }

    @Test
    void getChoiceFlightsExperement() {
        String ac = AllFlights.getChoiceFlightsExperement(connection).toString();
        String select = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city from flights_v"
                + " WHERE (scheduled_departure BETWEEN '2017-08-19' AND '2017-08-23')"
                + " and (scheduled_arrival BETWEEN '2017-08-21' AND '2017-08-23')"
                + " and ( departure_airport='DME') and ( arrival_airport='UUS')";
        List<Flights> AllFlight = getFlightsList(connection, select);
        String ex = AllFlight.toString();
        assertEquals(ex, ac);


    }

    @Test
    void listOfTitlesForFlightsWhithAllParam() {
        String ex = "Flights{flight_no='flight_no', status='status', scheduled_departure='scheduled_departure', scheduled_arrival='scheduled_arrival', departure_airport='(departure_airport)departure_city', arrival_airport='(arrival_airport)arrival_city'}";
        String ac = AllFlights.ListOfTitlesForFlightsWhithAllParam(connection).toString();
        assertEquals(ex, ac);

    }

    @AfterAll
    private void closeConnected() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static List<Flights> getFlightsList(Connection connection, String select) {
        List<Flights> AllFlight = new ArrayList<>();
        try (PreparedStatement pStatement = connection.prepareStatement(select);
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
package by.it_academy.jd2.core.dto.tool;

import by.it_academy.jd2.core.utils.CheckString;
import by.it_academy.jd2.core.utils.Constants;
import by.it_academy.jd2.core.dto.tool.api.AllFlightsInt;
import by.it_academy.jd2.core.dto.view.Flights;
import by.it_academy.jd2.data.ConnectionBase;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AllFlights implements AllFlightsInt {

    private final String ALL_FLIGTH = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city"
            + " from flights_v";

    private final String SELECT_EXPEREMENT = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city from flights_v"
            + " WHERE (scheduled_departure BETWEEN '2017-07-04' AND '2017-07-05')"
            + " and (scheduled_arrival BETWEEN '2017-07-04' AND '2017-07-05')"
            + " and ( departure_city='Москва') and ( arrival_city='Воронеж')";

    private final String FLIGHTS = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city"
            + " from flights_v "
            + " WHERE ( departure_city='%s') and ( arrival_city='%s')";
    private final String SCH_DEP_NON_NULL = " and (scheduled_departure BETWEEN '%s' AND '%s')";
    private final String SCH_ARR_NON_NULL = " and (scheduled_arrival BETWEEN '%s' AND '%s')";
    private final String ORDER_BY = " order by scheduled_departure";
    private final String PAGE = " offset %d fetch next 25 rows only";


    private final String CHOISE_FLIGHTS_EXPEREMENT = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, arrival_airport from flights WHERE (departure_airport='DME') and (arrival_airport='LED')";

    @Override
    public List<Flights> getChoiceFlights(String depCity, String arrCity, String scheduledDep, String scheduledArr) {
        //Determine the time intervals
        String select = "";
        if ((!CheckString.isNullOrEmptyOrBlank(scheduledDep)) && (!CheckString.isNullOrEmptyOrBlank(scheduledArr))) {
            String scheduledDepEnd = LocalDate.parse(scheduledDep).plusDays(1).toString();
            String scheduledArrEnd = LocalDate.parse(scheduledArr).plusDays(1).toString();
            select = String.format(FLIGHTS + SCH_DEP_NON_NULL + SCH_ARR_NON_NULL + ORDER_BY, depCity, arrCity, scheduledDep, scheduledDepEnd, scheduledArr, scheduledArrEnd);
        } else if ((CheckString.isNullOrEmptyOrBlank(scheduledDep)) && (CheckString.isNullOrEmptyOrBlank(scheduledArr))) {
            select = String.format(FLIGHTS + ORDER_BY, depCity, arrCity);
        } else if ((!CheckString.isNullOrEmptyOrBlank(scheduledDep)) && (CheckString.isNullOrEmptyOrBlank(scheduledArr))) {
            String scheduledDepEnd = LocalDate.parse(scheduledDep).plusDays(1).toString();
            select = String.format(FLIGHTS + SCH_DEP_NON_NULL + ORDER_BY, depCity, arrCity, scheduledDep, scheduledDepEnd);
        } else {
            String scheduledArrEnd = LocalDate.parse(scheduledArr).plusDays(1).toString();
            select = String.format(FLIGHTS + SCH_ARR_NON_NULL + ORDER_BY, depCity, arrCity, scheduledArr, scheduledArrEnd);
        }

        //Fill in the list with flights

        return getFlightsList(select);
    }

    @Override
    public List<Flights> getChoiceFlightsNoDateWithPage
            (String depCity, String arrCity, Integer page) {

        //Determine the time intervals

        String select = String.format(FLIGHTS + ORDER_BY + PAGE, depCity, arrCity, 25 * (page.intValue() - 1));


        //Fill in the list with flights

        return getFlightsList(select);
    }

    @Override
    public List<Flights> getChoiceFlightsExperement() {
        String select = SELECT_EXPEREMENT;
        return getFlightsList(select);
    }

    @Override
    public List<Flights> getFlightsList(String select) {
        List<Flights> allFlight = new ArrayList<>();

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
                allFlight.add(flights);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return allFlight;
    }

    @Override
    public Flights ListOfTitlesForFlightsWhithAllParam() {

        Flights flights = new Flights();
        String select = ALL_FLIGTH;
        try (Connection connection = ConnectionBase.getInstance().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(select);
             ResultSet rs = pStatement.executeQuery()) {
            ResultSetMetaData metaData = rs.getMetaData();

            flights.setFlight_no(metaData.getColumnName(1));
            flights.setStatus(metaData.getColumnName(2));
            flights.setScheduled_departure(metaData.getColumnName(3));
            flights.setScheduled_arrival(metaData.getColumnName(4));
            flights.setDeparture_airport("(" + metaData.getColumnName(5) + ")" + metaData.getColumnName(6));
            flights.setArrival_airport("(" + metaData.getColumnName(7) + ")" + metaData.getColumnName(8));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flights;
    }


}

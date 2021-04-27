package by.it_academy.jd2.core.dto.tool;

import by.it_academy.jd2.core.dto.Constants;
import by.it_academy.jd2.core.dto.tool.api.AllFlightsInt;
import by.it_academy.jd2.core.dto.view.Flights;
import by.it_academy.jd2.data.ConnectionBase;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AllFlights implements AllFlightsInt {

    private String listAllFligthOrderByCity = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city"
            + " from flights_v";

    private String SelectExperement = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city from flights_v"
            + " WHERE (scheduled_departure BETWEEN '2017-08-19' AND '2017-08-23')"
            + " and (scheduled_arrival BETWEEN '2017-08-21' AND '2017-08-23')"
            + " and ( departure_airport='DME') and ( arrival_airport='UUS')";

    private String ChoiceFlights = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city"
            + " from flights_v "
            + " WHERE ( departure_airport='%s') and ( arrival_airport='%s')";
    private String SchDEPNonNuul = " and (scheduled_departure BETWEEN '%s' AND '%s')";
    private String SchArrNonNuul = " and (scheduled_arrival BETWEEN '%s' AND '%s')";
    private String OrderBy = " order by scheduled_departure";
    private String Page = " offset %d fetch next 25 rows only";


    private String ChoiceFlights1 = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, arrival_airport from flights WHERE (departure_airport='DME') and (arrival_airport='LED')";

    @Override
    public List<Flights> getChoiceFlights(String depAirport, String arrAirport, String scheduledDep, String scheduledArr) {
        //Determine the time intervals
        String select = "";
        if ((!scheduledDep.equals(Constants.DEFAULT_DATE)) && (!scheduledArr.equals(Constants.DEFAULT_DATE))) {
            String scheduledDepEnd = LocalDate.parse(scheduledDep).plusDays(1).toString();
            String scheduledArrEnd = LocalDate.parse(scheduledArr).plusDays(1).toString();
            select = String.format(ChoiceFlights + SchDEPNonNuul + SchArrNonNuul + OrderBy, depAirport, arrAirport, scheduledDep, scheduledDepEnd, scheduledArr, scheduledArrEnd);
        } else if ((scheduledDep.equals(Constants.DEFAULT_DATE)) && (scheduledArr.equals(Constants.DEFAULT_DATE))) {
            select = String.format(ChoiceFlights + OrderBy, depAirport, arrAirport);
        } else if ((!scheduledDep.equals(Constants.DEFAULT_DATE)) && (scheduledArr.equals(Constants.DEFAULT_DATE))) {
            String scheduledDepEnd = LocalDate.parse(scheduledDep).plusDays(1).toString();
            select = String.format(ChoiceFlights + SchDEPNonNuul + OrderBy, depAirport, arrAirport, scheduledDep, scheduledDepEnd);
        } else {
            String scheduledArrEnd = LocalDate.parse(scheduledArr).plusDays(1).toString();
            select = String.format(ChoiceFlights + SchArrNonNuul + OrderBy, depAirport, arrAirport, scheduledArr, scheduledArrEnd);
        }

        //Fill in the list with flights

        return getFlightsList(select);
    }

    @Override
    public List<Flights> getChoiceFlightsNoDateWithPage
            (String depAirport, String arrAirport, Integer page) {

        //Determine the time intervals

        String select = String.format(ChoiceFlights + OrderBy + Page, depAirport, arrAirport, 25 * (page.intValue() - 1));


        //Fill in the list with flights

        return getFlightsList(select);
    }

    @Override
    public List<Flights> getChoiceFlightsExperement() {
        String select = SelectExperement;
        return getFlightsList(select);
    }

    @Override
    public List<Flights> getFlightsList(String select) {
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

    @Override
    public Flights ListOfTitlesForFlightsWhithAllParam() {

        Flights flights = new Flights();
        String select = listAllFligthOrderByCity;
        try (Connection connection = ConnectionBase.getInstance().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(listAllFligthOrderByCity);
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

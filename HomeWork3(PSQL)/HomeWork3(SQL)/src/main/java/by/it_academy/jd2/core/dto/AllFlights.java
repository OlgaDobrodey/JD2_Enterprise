package by.it_academy.jd2.core.dto;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AllFlights {

    private static String listAllFligthOrderByCity = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city"
            + " from flights_v";

    private static String SelectExperement = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city from flights_v"
            + " WHERE (scheduled_departure BETWEEN '2017-08-19' AND '2017-08-23')"
            + " and (scheduled_arrival BETWEEN '2017-08-21' AND '2017-08-23')"
            + " and ( departure_airport='DME') and ( arrival_airport='UUS')";

    private static String ChoiceFlights = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, departure_city, arrival_airport, arrival_city"
            + " from flights_v "
            + " WHERE ( departure_airport='%s') and ( arrival_airport='%s')";
    private static String SchDEPNonNuul = " and (scheduled_departure BETWEEN '%s' AND '%s')";
    private static String SchArrNonNuul =" and (scheduled_arrival BETWEEN '%s' AND '%s')";
    private static String OrderBy = " order by scheduled_departure";
     private static String Page =" offset %d fetch next 25 rows only";


    private static String ChoiceFlights1 = "SELECT flight_no, status, scheduled_departure, scheduled_arrival, departure_airport, arrival_airport from flights WHERE (departure_airport='DME') and (arrival_airport='LED')";

    public static List<Flights> getChoiceFlights(Connection connection, String depAirport, String arrAirport, String scheduledDep, String scheduledArr) {
        //Determine the time intervals
        String select="";
        if((!scheduledDep.equals("1900-01-01"))&&(!scheduledArr.equals("1900-01-01"))){
            String scheduledDepEnd = LocalDate.parse(scheduledDep).plusDays(1).toString();
            String scheduledArrEnd = LocalDate.parse(scheduledArr).plusDays(1).toString();
            select = String.format(ChoiceFlights+SchDEPNonNuul+SchArrNonNuul+OrderBy ,depAirport, arrAirport, scheduledDep, scheduledDepEnd, scheduledArr, scheduledArrEnd );
        }
        else if((scheduledDep.equals("1900-01-01"))&&(scheduledArr.equals("1900-01-01"))){
            select = String.format(ChoiceFlights+OrderBy,depAirport,arrAirport);
        }
        else if((!scheduledDep.equals("1900-01-01"))&&(scheduledArr.equals("1900-01-01"))){
            String scheduledDepEnd = LocalDate.parse(scheduledDep).plusDays(1).toString();
            select = String.format(ChoiceFlights+SchDEPNonNuul+OrderBy,depAirport,arrAirport,scheduledDep,scheduledDepEnd);
        }
        else{
            String scheduledArrEnd = LocalDate.parse(scheduledArr).plusDays(1).toString();
            select = String.format(ChoiceFlights+SchArrNonNuul+OrderBy,depAirport,arrAirport,scheduledArr,scheduledArrEnd);
        }

        //Fill in the list with flights

        return getFlightsList(connection, select);
    }

    public static List<Flights> getChoiceFlightsNoDateWithPage
            (Connection connection, String depAirport, String arrAirport,Integer page) {

        //Determine the time intervals

        String select = String.format(ChoiceFlights+OrderBy+Page,depAirport,arrAirport,25*(page.intValue()-1));


        //Fill in the list with flights

        return getFlightsList(connection, select);
    }





    public static List<Flights> getChoiceFlightsExperement(Connection connection) {
        String select = SelectExperement;
        return getFlightsList(connection, select);
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


    public static Flights ListOfTitlesForFlightsWhithAllParam(Connection connection) {

        Flights flights = new Flights();
        String select = listAllFligthOrderByCity;
        try (PreparedStatement pStatement = connection.prepareStatement(listAllFligthOrderByCity);
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

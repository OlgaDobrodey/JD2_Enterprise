package by.it_academy.jd2.core.dto;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * application memory containing messages
 */
public class AllAirports {
    private static List<Airports> AllAirport;

    private static String listAllAirportsOrderByCity ="Select * from airports order by city";
    private AllAirports()  {
    }


    public static List<Airports> getAllAirports(Connection connection) {
        String AllAirports = listAllAirportsOrderByCity;
        List<Airports> AllAirport=new ArrayList<>();
        try (PreparedStatement pStatement = connection.prepareStatement(AllAirports);
             ResultSet rs = pStatement.executeQuery()) {

            while (rs.next()) {
                final Airports airports = new Airports();
                airports.setAirport_code(rs.getString(1));
                airports.setAirport_name(rs.getString(2));
                airports.setCity(rs.getString(3));
                airports.setCoordinates(rs.getString(4));
                airports.setTimesone(rs.getString(5));
                AllAirport.add(airports);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return AllAirport;
    }



    public static Airports ListOfTitlesForAirports(Connection connection) {

        Airports title = new Airports();
        String AllAirports = listAllAirportsOrderByCity;
         try (PreparedStatement pStatement = connection.prepareStatement(AllAirports);
                 ResultSet rs = pStatement.executeQuery()) {
             ResultSetMetaData metaData = rs.getMetaData();

            title.setAirport_code(metaData.getColumnName(1));
            title.setAirport_name(metaData.getColumnName(2));
            title.setCity(metaData.getColumnName(3));
            title.setCoordinates(metaData.getColumnName(4));
            title.setTimesone(metaData.getColumnName(5));


        } catch (SQLException e) {
            e.printStackTrace();

        } return title;
    }
}


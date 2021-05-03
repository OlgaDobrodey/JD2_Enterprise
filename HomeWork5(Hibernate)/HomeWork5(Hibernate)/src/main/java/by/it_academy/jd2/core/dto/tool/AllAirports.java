package by.it_academy.jd2.core.dto.tool;


import by.it_academy.jd2.core.dto.tool.api.AllAirportsInt;
import by.it_academy.jd2.core.dto.view.Airports;
import by.it_academy.jd2.data.ConnectionBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * application memory containing messages
 */
public class AllAirports implements AllAirportsInt {

    private final String LIST_ALL_AIRPOTS = "Select * from airports order by city";
    private final String LIST_CITY_NAME= "Select city from airports order by city";

    public AllAirports() {
    }

    /**
     * <p>The method returns a list of all airports in the database</p>
     * <p>@param connection</p>
     * <p>@return list of all airports </p>
     */

    public List<Airports> getAllAirports() {

        String allAirports = LIST_ALL_AIRPOTS;
        List<Airports> allAirport = new ArrayList<>();
        try (Connection connection = ConnectionBase.getInstance().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(allAirports);
             ResultSet rs = pStatement.executeQuery()) {

            while (rs.next()) {
                final Airports airports = new Airports();
                airports.setAirport_code(rs.getString(1));
                airports.setAirport_name(rs.getString(2));
                airports.setCity(rs.getString(3));
                airports.setCoordinates(rs.getString(4));
                airports.setTimesone(rs.getString(5));
                allAirport.add(airports);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allAirport;
    }

    /**
     * The method returns list of titles for table airports
     *
     * @return object airports
     */

    public Airports ListOfTitlesForAirports() {

        Airports title = new Airports();
        String allAirports = LIST_ALL_AIRPOTS;
        try (Connection connection = ConnectionBase.getInstance().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(allAirports);
             ResultSet rs = pStatement.executeQuery()) {
            ResultSetMetaData metaData = rs.getMetaData();

            title.setAirport_code(metaData.getColumnName(1));
            title.setAirport_name(metaData.getColumnName(2));
            title.setCity(metaData.getColumnName(3));
            title.setCoordinates(metaData.getColumnName(4));
            title.setTimesone(metaData.getColumnName(5));


        } catch (SQLException e) {
            e.printStackTrace();

        }
        return title;
    }

    @Override
    public List<String> getListNameCity() {
        String AllAirports = LIST_CITY_NAME;
        List<String> allAirport = new ArrayList<>();
        try (Connection connection = ConnectionBase.getInstance().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(AllAirports);
             ResultSet rs = pStatement.executeQuery()) {
            while (rs.next()) {
                allAirport.add(rs.getString("city"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<String> list = allAirport.stream().distinct().collect(Collectors.toList());
        return list;
    }
}



package by.it_academy.jd2.core.dto.tool.hibernate;

import by.it_academy.jd2.core.dto.tool.api.AllAirportsInt;
import by.it_academy.jd2.core.dto.view.Airports;
import by.it_academy.jd2.data.ConnectionBase;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class AllAirportsHibernateTest {

    @Test
    void getAllAirports() {
        String select = "Select * from airports order by city";
        List<Airports> AllAirport = new ArrayList<>();
        try (Connection connection = ConnectionBase.getInstance().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(select);
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
            AllAirportsInt airportsInt = new AllAirportsHibernate();
            List<Airports> actual = AllAirport;
            List<Airports> expected = airportsInt.getAllAirports();
            assertEquals(expected.toString(), actual.toString());

        } catch (SQLException | IllegalAccessException throwables) {
            throwables.printStackTrace();
        }
    }


    @Test
    void listOfTitlesForAirports() {
        try {
            AllAirportsInt airportsInt = new AllAirportsHibernate();
            String ex = "airport_code airport_name city coordinates timezone";
            String ac = airportsInt.listOfTitlesForAirports().toString();
            assertEquals(ex, ac);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Test
    void getListNameCity() {
        String select = "Select city from airports order by city";
        List<String> allAirport = new ArrayList<>();
        try (Connection connection = ConnectionBase.getInstance().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(select);
             ResultSet rs = pStatement.executeQuery()) {
            while (rs.next()) {
                allAirport.add(rs.getString("city"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            List<String> actual = allAirport.stream().distinct().collect(Collectors.toList());
            AllAirportsInt airportsInt = new AllAirportsHibernate();
            List<String> expected = airportsInt.getListNameCity();
            assertEquals(expected.toString(), actual.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }



    }
}
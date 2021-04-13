package by.it_academy.jd2.core.dto.tool;

import by.it_academy.jd2.core.dto.view.Airports;
import by.it_academy.jd2.data.ConnectionBase;
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
class AllAirportsTest {
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
    void getAllAirports() {
        String select = "Select * from airports order by city";
        List<Airports> AllAirport=new ArrayList<>();
        try (PreparedStatement pStatement = connection.prepareStatement(select);
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
            List<Airports> actual = AllAirport;
            List<Airports> expected = AllAirports.getAllAirports(connection);
            assertEquals(expected.toString(),actual.toString());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    void listOfTitlesForAirports() {
        String ex = "airport_code airport_name city coordinates timezone";
        String ac = AllAirports.ListOfTitlesForAirports(connection).toString();
        assertEquals(ex,ac);

    }

    @AfterAll
    private void closeConnected(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
package by.it_academy.jd2.data;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionBaseTest {

    @Test
    void getConnection() {
        String expected = "";
        String actual = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "124");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
           // throwables.printStackTrace();
            expected = null;
            System.out.println(throwables.getSQLState());
        }
        assertEquals(expected,actual);


    }
}
package by.it_academy.jd2.core.dto;

import java.sql.*;

public class ConnectionBase {

    public Connection getConnection() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "123");
            return conn;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }



}

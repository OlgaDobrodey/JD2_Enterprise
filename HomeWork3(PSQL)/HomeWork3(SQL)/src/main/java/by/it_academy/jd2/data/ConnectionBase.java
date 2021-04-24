package by.it_academy.jd2.data;

import java.sql.*;

public class ConnectionBase {

    public Connection getConnection() throws ClassNotFoundException {
        Class.forName(ParamConnectionBase.DRIVER);
        try {
            Connection conn = DriverManager.getConnection(ParamConnectionBase.URL, ParamConnectionBase.USER, ParamConnectionBase.PSW);
            return conn;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }



}

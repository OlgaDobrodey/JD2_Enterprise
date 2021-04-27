package by.it_academy.jd2.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.*;

public class ConnectionBase {

    private Connection conn;

    /**
     * реализация паттерна синглтон получение объекта
     */
    public static ConnectionBase getInstance() {
        return new ConnectionBase();
    }

    public Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName(ParamConnectionBase.DRIVER);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                conn = DriverManager.getConnection(ParamConnectionBase.URL,
                        ParamConnectionBase.USER, ParamConnectionBase.PSW);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }


}






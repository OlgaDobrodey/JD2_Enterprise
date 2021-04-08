package by.it_academy.jd2;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class JdbcMainTwo {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/edu", "postgres", "123");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM edu.employees");)
        {

            ResultSetMetaData metaData =rs.getMetaData();
            int iColumnCount = metaData.getColumnCount();
            for(int i =1 ; i<=iColumnCount;i++){
                System.out.println("Column Name: "+ metaData.getColumnName(i));
                System.out.println("Column Type: "+ metaData.getColumnType(i));
                System.out.println("Display Size: "+ metaData.getColumnDisplaySize(i));
                System.out.println("Precision: "+ metaData.getPrecision(i));
                System.out.println("Scale: "+ metaData.getScale(i));
                System.out.println();
            }
            while (rs.next()){
                for (int i = 1; i <= iColumnCount; i++) {
                    System.out.println(metaData.getColumnName(i)+": "+rs.getObject(i));

                }
                System.out.println();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

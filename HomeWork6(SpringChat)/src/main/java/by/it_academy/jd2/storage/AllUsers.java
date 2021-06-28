package by.it_academy.jd2.storage;

import by.it_academy.jd2.core.model.User;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Application memory containing users
 */
public class AllUsers {

    private static String select = "select * from chat.users";
   // private static Set<User> AllUser;


    private AllUsers() {
    }


    /**
     *
     * @param connection -connection with Base Data
     * @return set all users chat
     */
    public static Set<User> getAllUsers(Connection connection) {
        Set<User> AllUser = new HashSet<>();
        try (PreparedStatement pStatement = connection.prepareStatement(select);

             ResultSet resultSet = pStatement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("psw"));
                user.setName(resultSet.getString("name_user"));
                user.setBirthday(resultSet.getString("birthday"));
                AllUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return AllUser;
    }
}

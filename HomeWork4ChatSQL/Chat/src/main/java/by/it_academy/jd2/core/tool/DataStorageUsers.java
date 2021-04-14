package by.it_academy.jd2.core.tool;

import by.it_academy.jd2.core.storage.AllUsers;
import by.it_academy.jd2.core.tool.api.DataStorageUsersInt;
import by.it_academy.jd2.core.view.User;
import by.it_academy.jd2.data.DaoFactory;
import by.it_academy.jd2.data.DatabaseName;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Class contains method work with users
 */
public class DataStorageUsers implements DataStorageUsersInt {
    private Connection connection;
    private String insert = "INSERT INTO chat.users(login, psw, name_user, birthday)" +
                            "VALUES (?, ?, ?, ?)";
private String delete = "DELETE FROM chat.users" +
                        " WHERE login=?";

    public DataStorageUsers(Connection connection) {
        this.connection = connection;
    }

    /**
     * Method save users in application memory
     *
     * @param user User
     */
    public void saveUsers(User user) {
        try(PreparedStatement ps = connection.prepareStatement(insert)){
            ps.setString(1,user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setDate(4, Date.valueOf(user.getBirthday()));
            int affected = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Method search user whith PSW and login in application memory
     *
     * @param login user String
     * @param psw   user String
     * @return user User
     */

    public User searchUserLoginAndPsw(String login, String psw) {
        Set<User> setAllUser = AllUsers.getAllUsers(connection);
        for (User allUser : setAllUser ) {
            if (((allUser.getLogin().trim()).equals(login) )&& ((allUser.getPassword().trim()).equals(psw))) {
                return allUser;
            }

        }
        return null;
    }

    /**
     * Method search user with  and login in application memory
     *
     * @param login user String
     * @return user User
     */


    public User searchUserLogin(String login) {
        Set<User> setAllUser = AllUsers.getAllUsers(connection);
        for (User allUser : setAllUser) {
            if ((allUser.getLogin().trim()).equals(login)) {
                return allUser;
            }
        }
        return null;
    }

    /**
     * Method gets all user logins of the application
     *
     * @return users Set
     */
    public Set<String> getUsersLogin() {
        HashSet<String> usersLogin = new HashSet<>();
        for (User user : AllUsers.getAllUsers(connection)) {
            usersLogin.add(user.getLogin());
        }
        return usersLogin;
    }
    public int deleteUser(String login){
        try(
            PreparedStatement ps = connection.prepareStatement(delete)) {
            ps.setString(1,login);
            int result =ps.executeUpdate();
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
            }

    }

}

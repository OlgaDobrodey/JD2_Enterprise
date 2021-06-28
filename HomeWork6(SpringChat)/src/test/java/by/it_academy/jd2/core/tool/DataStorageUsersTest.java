package by.it_academy.jd2.core.tool;


import by.it_academy.jd2.storage.AllUsers;
import by.it_academy.jd2.core.model.User;
import by.it_academy.jd2.data.DaoFactory;
import by.it_academy.jd2.data.DatabaseName;
import org.junit.Assert;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.stream.Collectors;


import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DataStorageUsersTest {

    private User userSender;
    private User userReceiver;


    @BeforeAll
    private void createUsers() {
        try {
            connection = DaoFactory.getInstance(DatabaseName.POSTGRES).getConnectionBase();
            dSUsers = new DataStorageUsers(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        userSender = new User();
        userSender.setName("Olga");
        userSender.setLogin("Dobrodey");
        userSender.setPassword("123");
        userSender.setBirthday("2021-03-25");
        dSUsers.saveUsers(userSender);

        userReceiver = new User();
        userReceiver.setName("Sasha");
        userReceiver.setLogin("Hurkovskii");
        userReceiver.setPassword("456");
        userReceiver.setBirthday("2021-03-25");
        dSUsers.saveUsers(userReceiver);
    }

    private Connection connection;
    private DataStorageUsers dSUsers;

    @Test
    void classDefinition() {
        DataStorageUsers dsu = new DataStorageUsers(connection);
        Assert.assertTrue(dsu instanceof DataStorageUsers);
    }

    @Test
    void searchUserLoginNull() {
        //  System.out.println(AllUsers.getAllUsers());
        User actual = dSUsers.searchUserLogin("Non Existing User Name");
        User expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void searchUserLogin() {
        String actual = dSUsers.searchUserLogin(userSender.getLogin()).getLogin();
        String expected = userSender.getLogin();
        assertEquals(expected, actual);
    }

    @Test
    void searchUserLoginAndPswNull() {
        User actual = dSUsers.searchUserLoginAndPsw("Non Existing User Name", "Non Existing User PSW");
        User expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void saveUsers() {
        User newUser = new User();
        newUser.setName("Test");
        newUser.setLogin("User");
        newUser.setPassword("456");
        newUser.setBirthday("2021-03-25");
        dSUsers.saveUsers(newUser);
        assertEquals(
                newUser.getName(),
                dSUsers.searchUserLogin(newUser.getLogin()).getName()
        );
    }

    @Test
    void searchUserLoginAndPsw() {
        User userActual = dSUsers.searchUserLoginAndPsw(userReceiver.getLogin(), userReceiver.getPassword());
        boolean test = ((userActual.getLogin().equals(userReceiver.getLogin())) && (userActual.getPassword().equals(userReceiver.getPassword())));
        assertEquals(true, test);
    }

    @Test
    void searchUserLoginAndPswPSW() {
        User userActual = dSUsers.searchUserLoginAndPsw(userReceiver.getLogin(), userReceiver.getPassword());
        String actual = userActual.getPassword();
        String expected = userReceiver.getPassword();
        assertEquals(expected, actual);
    }


    @Test
    void getUsersLogin() {
        HashSet<String> usersLogin = new HashSet<>();
        for (User user : AllUsers.getAllUsers(connection)) {
            usersLogin.add(user.getLogin());
        }
        String actual = dSUsers.getUsersLogin().stream().sorted().collect(Collectors.joining());
        String expected = usersLogin.stream().sorted().collect(Collectors.joining());
        assertEquals(expected, actual);


    }

    @Test
    void deleteUser() {
        final int ex = dSUsers.deleteUser("User");
        int actual = 1;
        assertEquals(ex, actual);


    }

    @AfterAll
    void connectionClose() {
        dSUsers.deleteUser("Dobrodey");
        dSUsers.deleteUser("Hurkovskii");

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
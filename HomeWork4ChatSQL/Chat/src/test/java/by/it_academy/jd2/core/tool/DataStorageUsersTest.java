package by.it_academy.jd2.core.tool;


import by.it_academy.jd2.core.view.User;
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
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DataStorageUsersTest {
    private Connection connection;
    private User userSender;
    private User userReceiver;
    private DataStorageUsers dSUsers = new DataStorageUsers(connection);

    @BeforeAll
    private void createUsers() {
        try {
            connection = DaoFactory.getInstance(DatabaseName.POSTGRES).getConnectionBase();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        userSender = new User();
        userSender.setName("Olga");
        userSender.setLogin("Dobrodey");
        userSender.setPassword("123");
        userSender.setBirthday("25.03.2021");
        dSUsers.saveUsers(userSender);

        userReceiver = new User();
        userReceiver.setName("Sasha");
        userReceiver.setLogin("Hurkovskii");
        userReceiver.setPassword("456");
        userReceiver.setBirthday("12.04.2011");
        dSUsers.saveUsers(userReceiver);
    }

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
        newUser.setBirthday("12.04.2011");
        dSUsers.saveUsers(newUser);
        assertEquals(
                newUser.getName(),
                dSUsers.searchUserLogin(newUser.getLogin()).getName()
        );
    }

    @Test
    void searchUserLoginAndPsw() {
        User userActual = dSUsers.searchUserLoginAndPsw(userReceiver.getLogin(), userReceiver.getPassword());
        boolean test =( (userActual.getLogin().equals(userReceiver.getLogin()))&&(userActual.getPassword().equals(userReceiver.getPassword())));
        assertEquals(true, test);
    }
    @Test
    void searchUserLoginAndPswPSW() {
        User userActual = dSUsers.searchUserLoginAndPsw(userReceiver.getLogin(), userReceiver.getPassword());
        String actual=userActual.getPassword();
        String expected = userReceiver.getPassword();
        assertEquals(expected, actual);
    }


    @Test
    void getUsersLogin() {
        Set<String> set = new HashSet<>();
        set.add(userSender.getLogin());
        set.add(userReceiver.getLogin());
        Set<String> actual = dSUsers.getUsersLogin();
        Set<String> expected = set;


    }
    @AfterAll
    void connectionClose(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
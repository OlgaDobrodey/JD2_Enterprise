package by.it_academy.jd2.core.tool;


import by.it_academy.jd2.core.view.User;
import org.junit.Assert;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.HashSet;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DataStorageUsersTest {
    private User userSender;
    private User userReceiver;

    @BeforeAll
    private void createUsers() {
        userSender = new User();
        userSender.setName("Olga");
        userSender.setLogin("Dobrodey");
        userSender.setPassword("123");
        userSender.setBirthday("25.03.2021");
        DataStorageUsers.saveUsers(userSender);

        userReceiver = new User();
        userReceiver.setName("Sasha");
        userReceiver.setLogin("Hurkovskii");
        userReceiver.setPassword("456");
        userReceiver.setBirthday("12.04.2011");
        DataStorageUsers.saveUsers(userReceiver);
    }

    @Test
    void classDefinition() {
        DataStorageUsers dsu = new DataStorageUsers();
        Assert.assertTrue(dsu instanceof DataStorageUsers);
    }

    @Test
    void searchUserLoginNull() {
        //  System.out.println(AllUsers.getAllUsers());
        User actual = DataStorageUsers.searchUserLogin("Non Existing User Name");
        User expected = null;
        assertEquals(expected, actual);
    }


    @Test
    void searchUserLogin() {
        String actual = DataStorageUsers.searchUserLogin(userSender.getLogin()).getLogin();
        String expected = userSender.getLogin();
        assertEquals(expected, actual);
    }

    @Test
    void searchUserLoginAndPswNull() {
        User actual = DataStorageUsers.searchUserLoginAndPsw("Non Existing User Name", "Non Existing User PSW");
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
        DataStorageUsers.saveUsers(newUser);
        assertEquals(
                newUser.getName(),
                DataStorageUsers.searchUserLogin(newUser.getLogin()).getName()
        );
    }

    @Test
    void searchUserLoginAndPsw() {
        User userActual = DataStorageUsers.searchUserLoginAndPsw(userReceiver.getLogin(), userReceiver.getPassword());
        boolean test =( (userActual.getLogin().equals(userReceiver.getLogin()))&&(userActual.getPassword().equals(userReceiver.getPassword())));
        assertEquals(true, test);
    }
    @Test
    void searchUserLoginAndPswPSW() {
        User userActual = DataStorageUsers.searchUserLoginAndPsw(userReceiver.getLogin(), userReceiver.getPassword());
        String actual=userActual.getPassword();
        String expected = userReceiver.getPassword();
        assertEquals(expected, actual);
    }


    @Test
    void getUsersLogin() {
        Set<String> set = new HashSet<>();
        set.add(userSender.getLogin());
        set.add(userReceiver.getLogin());
        Set<String> actual = DataStorageUsers.getUsersLogin();
        Set<String> expected = set;


    }
}
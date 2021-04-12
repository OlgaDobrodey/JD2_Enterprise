package by.it_academy.jd2.core.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getName() {
        User user = new User();
        user.setName("Olga");
        String actual = user.getName();
        String expected = "Olga";
        assertEquals(expected, actual);
    }

    @Test
    void setName() {
        User user = new User();
        user.setName("Olga");
        String actual = user.getName();
        String expected = "Olga";
        assertEquals(expected, actual);
    }

    @Test
    void getLogin() {
        User user = new User();
        user.setLogin("123");
        String actual = user.getLogin();
        String expected = "123";
        assertEquals(expected, actual);
    }

    @Test
    void setLogin() {
        User user = new User();
        user.setLogin("123");
        String actual = user.getLogin();
        String expected = "123";
        assertEquals(expected, actual);
    }

    @Test
    void getPassword() {
        User user = new User();
        user.setPassword("123");
        String actual = user.getPassword();
        String expected = "123";
        assertEquals(expected, actual);
    }

    @Test
    void setPassword() {
        User user = new User();
        user.setPassword("123");
        String actual = user.getPassword();
        String expected = "123";
        assertEquals(expected, actual);
    }

    @Test
    void getBirthday() {
        User user = new User();
        user.setBirthday("25.03.2021 11:06:45");
        String actual = user.getBirthday();
        String expected = "25.03.2021 11:06:45";
        assertEquals(expected, actual);
    }

    @Test
    void setBirthday() {
        User user = new User();
        user.setBirthday("25.03.2021 11:06:45");
        String actual = user.getBirthday();
        String expected = "25.03.2021 11:06:45";
        assertEquals(expected, actual);
    }

    @Test
    void testToString() {
        User user = new User();
        user.setName("Olga");
        user.setLogin("Dobrodey");
        user.setPassword("123");
        user.setBirthday("25.03.2021 11:06:45");
        String actual = user.toString();
        String expected = " Dobrodey(имя Olga)";
        assertEquals(expected, actual);
    }
}
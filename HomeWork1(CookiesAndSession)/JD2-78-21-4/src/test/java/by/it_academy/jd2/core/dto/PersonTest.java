package by.it_academy.jd2.core.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person user = new Person();

    @Test
    void getFirstName() {
        user.setFirstName("Olga");
        String actual = user.getFirstName();
        String expected = "Olga";
        assertEquals(expected, actual);
    }

    @Test
    void setFirstName() {
        user.setFirstName("Olga");
        String actual = user.getFirstName();
        String expected = "Olga";
        assertEquals(expected, actual);
        }

    @Test
    void getLastName() {
        user.setLastName("Olga");
        String actual = user.getLastName();
        String expected = "Olga";
        assertEquals(expected, actual);
    }


    @Test
    void setLastName() {
        user.setLastName("Olga");
        String actual = user.getLastName();
        String expected = "Olga";
        assertEquals(expected, actual);
    }

    @Test
    void getAge() {
        user.setAge(4);
        int actual = user.getAge();
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void setAge() {
        user.setAge(4);
        int actual = user.getAge();
        int expected = 4;
        assertEquals(expected, actual);
    }
}
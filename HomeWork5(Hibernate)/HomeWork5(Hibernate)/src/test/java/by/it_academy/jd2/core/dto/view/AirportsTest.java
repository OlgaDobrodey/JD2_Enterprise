package by.it_academy.jd2.core.dto.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportsTest {
//    User user = new User();
//        user.setName("Olga");
//    String actual = user.getName();
//    String expected = "Olga";
//    assertEquals(expected, actual);
//}


    @Test
    void getAirport_code() {
        Airports airports = new Airports();
        airports.setAirport_code("2034");
        String actual = airports.getAirport_code();
        String expected = "2034";
        assertEquals(expected,actual);
    }

    @Test
    void setAirport_code() {
        Airports airports = new Airports();
        airports.setAirport_code("2034");
        String actual = airports.getAirport_code();
        String expected = "2034";
        assertEquals(expected,actual);
    }

    @Test
    void getAirport_name() {
        Airports airports = new Airports();
        airports.setAirport_name("DES");
        String actual = airports.getAirport_name();
        String expected = "DES";
        assertEquals(expected,actual);

    }

    @Test
    void setAirport_name() {
        Airports airports = new Airports();
        airports.setAirport_name("DES");
        String actual = airports.getAirport_name();
        String expected = "DES";
        assertEquals(expected,actual);
    }

    @Test
    void getCity() {
        Airports airports = new Airports();
        airports.setCity("Москва");
        String actual = airports.getCity();
        String expected = "Москва";
        assertEquals(expected,actual);
    }

    @Test
    void setCity() {
        Airports airports = new Airports();
        airports.setCity("Москва");
        String actual = airports.getCity();
        String expected = "Москва";
        assertEquals(expected,actual);
    }

    @Test
    void getCoordinates() {
        Airports airports = new Airports();
        airports.setCoordinates("(150.72000122070312,59.9109992980957)");
        String actual = airports.getCoordinates();
        String expected = "(150.72000122070312,59.9109992980957)";
        assertEquals(expected,actual);
    }

    @Test
    void setCoordinates() {
        Airports airports = new Airports();
        airports.setCoordinates("(150.72000122070312,59.9109992980957)");
        String actual = airports.getCoordinates();
        String expected = "(150.72000122070312,59.9109992980957)";
        assertEquals(expected,actual);
    }

    @Test
    void getTimesone() {
        Airports airports = new Airports();
        airports.setTimesone("Asia/Krasnoyarsk");
        String actual = airports.getTimesone();
        String expected = "Asia/Krasnoyarsk";
        assertEquals(expected,actual);
    }

    @Test
    void setTimesone() {
        Airports airports = new Airports();
        airports.setTimesone("Asia/Krasnoyarsk");
        String actual = airports.getTimesone();
        String expected = "Asia/Krasnoyarsk";
        assertEquals(expected,actual);
    }

    @Test
    void testToString() {
//        airport_code+" "+airport_name+" "+city+" "+coordinates+" "+timesone
        Airports airports = new Airports();
        airports.setAirport_code("2034");
        airports.setAirport_name("DES");
        airports.setCity("Москва");
        airports.setCoordinates("(150.72000122070312,59.9109992980957)");
        airports.setTimesone("Asia/Krasnoyarsk");
        String actual = airports.toString();
        String expected = "2034 DES Москва (150.72000122070312,59.9109992980957) Asia/Krasnoyarsk";
        assertEquals(expected,actual);

    }
}
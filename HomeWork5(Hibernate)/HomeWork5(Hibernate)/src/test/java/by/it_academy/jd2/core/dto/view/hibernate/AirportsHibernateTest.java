package by.it_academy.jd2.core.dto.view.hibernate;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportsHibernateTest {

    @Test
    void getAirport_code() {
        AirportsHibernate airports = new AirportsHibernate();
        airports.setAirport_code("2034");
        String actual = airports.getAirport_code();
        String expected = "2034";
        assertEquals(expected,actual);
    }

    @Test
    void setAirport_code() {
        AirportsHibernate airports = new AirportsHibernate();
        airports.setAirport_code("2034");
        String actual = airports.getAirport_code();
        String expected = "2034";
        assertEquals(expected,actual);
    }

    @Test
    void getAirport_name() {
        AirportsHibernate airports = new AirportsHibernate();
        airports.setAirport_name("DES");
        String actual = airports.getAirport_name();
        String expected = "DES";
        assertEquals(expected,actual);

    }

    @Test
    void setAirport_name() {
        AirportsHibernate airports = new AirportsHibernate();
        airports.setAirport_name("DES");
        String actual = airports.getAirport_name();
        String expected = "DES";
        assertEquals(expected,actual);
    }

    @Test
    void getCity() {
        AirportsHibernate airports = new AirportsHibernate();
        airports.setCity("Москва");
        String actual = airports.getCity();
        String expected = "Москва";
        assertEquals(expected,actual);
    }

    @Test
    void setCity() {
        AirportsHibernate airports = new AirportsHibernate();
        airports.setCity("Москва");
        String actual = airports.getCity();
        String expected = "Москва";
        assertEquals(expected,actual);
    }

    @Test
    void getCoordinates() {
        AirportsHibernate airports = new AirportsHibernate();
        airports.setCoordinates("(150.72000122070312,59.9109992980957)");
        String actual = airports.getCoordinates();
        String expected = "(150.72000122070312,59.9109992980957)";
        assertEquals(expected,actual);
    }

    @Test
    void setCoordinates() {
        AirportsHibernate airports = new AirportsHibernate();
        airports.setCoordinates("(150.72000122070312,59.9109992980957)");
        String actual = airports.getCoordinates();
        String expected = "(150.72000122070312,59.9109992980957)";
        assertEquals(expected,actual);
    }

    @Test
    void getTimezone() {
        AirportsHibernate airports = new AirportsHibernate();
        airports.setTimezone("Asia/Krasnoyarsk");
        String actual = airports.getTimezone();
        String expected = "Asia/Krasnoyarsk";
        assertEquals(expected,actual);
    }

    @Test
    void setTimezone(){
        AirportsHibernate airports = new AirportsHibernate();
        airports.setTimezone("Asia/Krasnoyarsk");
        String actual = airports.getTimezone();
        String expected = "Asia/Krasnoyarsk";
        assertEquals(expected,actual);
    }

    @Test
    void testToString() {

        AirportsHibernate airports = new AirportsHibernate();
        airports.setAirport_code("2034");
        airports.setAirport_name("DES");
        airports.setCity("Москва");
        airports.setCoordinates("(150.72000122070312,59.9109992980957)");
        airports.setTimezone("Asia/Krasnoyarsk");
        String actual = airports.toString();
        String expected = "AirportsHibernate{airport_code='2034', airport_name='DES', city='Москва', coordinates='(150.72000122070312,59.9109992980957)', timezone='Asia/Krasnoyarsk'}";

        assertEquals(expected,actual);

    }
}
package by.it_academy.jd2.core.dto.view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FlightsTest {

    @Test
    void getFlight_no() {
        Flights flights = new Flights();
        flights.setFlight_no("123");
        String actual = flights.getFlight_no();
        String expected = "123";
        assertEquals(expected, actual);
    }

    @Test
    void setFlight_no() {
        Flights flights = new Flights();
        flights.setFlight_no("123");
        String actual = flights.getFlight_no();
        String expected = "123";
        assertEquals(expected, actual);
    }

    @Test
    void getStatus() {
        Flights flights = new Flights();
        flights.setStatus("Arrived");
        String actual = flights.getStatus();
        String expected = "Arrived";
        assertEquals(expected, actual);
    }

    @Test
    void setStatus() {
        Flights flights = new Flights();
        flights.setStatus("Arrived");
        String actual = flights.getStatus();
        String expected = "Arrived";
        assertEquals(expected, actual);
    }


    @Test
    void getScheduled_departure() {
        Flights flights = new Flights();
        flights.setScheduled_departure("2016-08-30 14:35:00+03");
        String actual = flights.getScheduled_departure();
        String expected = "2016-08-30 14:35:00+03";
        assertEquals(expected, actual);
    }

    @Test
    void setScheduled_departure() {
        Flights flights = new Flights();
        flights.setScheduled_departure("2016-08-30 14:35:00+03");
        String actual = flights.getScheduled_departure();
        String expected = "2016-08-30 14:35:00+03";
        assertEquals(expected, actual);
    }

    @Test
    void getScheduled_arrival() {
        Flights flights = new Flights();
        flights.setScheduled_arrival("2016-08-30 14:35:00+03");
        String actual = flights.getScheduled_arrival();
        String expected = "2016-08-30 14:35:00+03";
        assertEquals(expected, actual);
    }

    @Test
    void setScheduled_arrival() {
        Flights flights = new Flights();
        flights.setScheduled_arrival("2016-08-30 14:35:00+03");
        String actual = flights.getScheduled_arrival();
        String expected = "2016-08-30 14:35:00+03";
        assertEquals(expected, actual);
    }


    @Test
    void getDeparture_airport() {
        Flights flights = new Flights();
        flights.setDeparture_airport("DSE");
        String actual = flights.getDeparture_airport();
        String expected = "DSE";
        assertEquals(expected, actual);
    }

    @Test
    void setDeparture_airport() {
        Flights flights = new Flights();
        flights.setDeparture_airport("DSE");
        String actual = flights.getDeparture_airport();
        String expected = "DSE";
        assertEquals(expected, actual);
    }

    @Test
    void getArrival_airport() {
        Flights flights = new Flights();
        flights.setArrival_airport("DSE");
        String actual = flights.getArrival_airport();
        String expected = "DSE";
        assertEquals(expected, actual);
    }

    @Test
    void setArrival_airport() {
        Flights flights = new Flights();
        flights.setArrival_airport("DSE");
        String actual = flights.getArrival_airport();
        String expected = "DSE";
        assertEquals(expected, actual);
    }

    @Test
    void testToString() {
        Flights flights = new Flights();
        flights.setFlight_no("123");
        flights.setStatus("Arrived");
        flights.setScheduled_departure("2016-08-30 14:35:00+03");
        flights.setScheduled_arrival("2016-08-30 16:55:00+03");
        flights.setDeparture_airport("DSE");
        flights.setArrival_airport("SED");
        String actual = flights.toString();
        String expected = "Flights{flight_no='123', status='Arrived', scheduled_departure='2016-08-30 14:35:00+03', scheduled_arrival='2016-08-30 16:55:00+03', departure_airport='DSE', arrival_airport='SED'}";
        assertEquals(expected, actual);
    }
}
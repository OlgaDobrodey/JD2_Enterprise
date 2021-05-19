package by.it_academy.jd2.core.dto.view.hibernate;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightsHibernateTest {
    @Test
    void getFlight_id() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setFlight_id(1);
        Integer actual = flights.getFlight_id();
        Integer expected = 1;
        assertEquals(expected, actual);

    }

    @Test
    void setFlight_id() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setFlight_id(1);
        Integer actual = flights.getFlight_id();
        Integer expected = 1;
        assertEquals(expected, actual);

    }


    @Test
    void getFlight_no() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setFlight_no("123");
        String actual = flights.getFlight_no();
        String expected = "123";
        assertEquals(expected, actual);
    }

    @Test
    void setFlight_no() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setFlight_no("123");
        String actual = flights.getFlight_no();
        String expected = "123";
        assertEquals(expected, actual);
    }

    @Test
    void getStatus() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setStatus("Arrived");
        String actual = flights.getStatus();
        String expected = "Arrived";
        assertEquals(expected, actual);
    }

    @Test
    void setStatus() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setStatus("Arrived");
        String actual = flights.getStatus();
        String expected = "Arrived";
        assertEquals(expected, actual);
    }


    @Test
    void getScheduled_departure() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setScheduled_departure("2016-08-30 14:35:00+03");
        String actual = flights.getScheduled_departure();
        String expected = "2016-08-30 14:35:00+03";
        assertEquals(expected, actual);
    }

    @Test
    void setScheduled_departure() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setScheduled_departure("2016-08-30 14:35:00+03");
        String actual = flights.getScheduled_departure();
        String expected = "2016-08-30 14:35:00+03";
        assertEquals(expected, actual);
    }

    @Test
    void getScheduled_arrival() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setScheduled_arrival("2016-08-30 14:35:00+03");
        String actual = flights.getScheduled_arrival();
        String expected = "2016-08-30 14:35:00+03";
        assertEquals(expected, actual);
    }

    @Test
    void setScheduled_arrival() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setScheduled_arrival("2016-08-30 14:35:00+03");
        String actual = flights.getScheduled_arrival();
        String expected = "2016-08-30 14:35:00+03";
        assertEquals(expected, actual);
    }


    @Test
    void getDeparture_airport() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setDeparture_airport("DSE");
        String actual = flights.getDeparture_airport();
        String expected = "DSE";
        assertEquals(expected, actual);
    }

    @Test
    void setDeparture_airport() {
        FlightsHibernate flights = new FlightsHibernate();
        ;
        flights.setDeparture_airport("DSE");
        String actual = flights.getDeparture_airport();
        String expected = "DSE";
        assertEquals(expected, actual);
    }

    @Test
    void getArrival_airport() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setArrival_airport("DSE");
        String actual = flights.getArrival_airport();
        String expected = "DSE";
        assertEquals(expected, actual);
    }

    @Test
    void setArrival_airport() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setArrival_airport("DSE");
        String actual = flights.getArrival_airport();
        String expected = "DSE";
        assertEquals(expected, actual);
    }

    @Test
    void getDeparture_city() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setArrival_airport("Москва");
        String actual = flights.getArrival_airport();
        String expected = "Москва";
        assertEquals(expected, actual);

    }

    @Test
    void setDeparture_city() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setArrival_airport("Москва");
        String actual = flights.getArrival_airport();
        String expected = "Москва";
        assertEquals(expected, actual);
    }


    @Test
    void getArrival_city() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setArrival_airport("Воронеж");
        String actual = flights.getArrival_airport();
        String expected = "Воронеж";
        assertEquals(expected, actual);
    }

    @Test
    void setArrival_city() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setArrival_airport("Воронеж");
        String actual = flights.getArrival_airport();
        String expected = "Воронеж";
        assertEquals(expected, actual);
    }

    @Test
    void testToString() {
        FlightsHibernate flights = new FlightsHibernate();
        flights.setFlight_id(1);
        flights.setFlight_no("123");
        flights.setStatus("Arrived");
        flights.setScheduled_departure("2016-08-30 14:35:00+03");
        flights.setScheduled_arrival("2016-08-30 16:55:00+03");
        flights.setDeparture_airport("DSE");
        flights.setDeparture_city("Москва");
        flights.setArrival_airport("SED");
        flights.setArrival_city("Воронеж");
        String actual = flights.toString();
        String expected = "FlightsHibernate{flight_id=1, flight_no='123', status='Arrived', " +
                "scheduled_departure='2016-08-30 14:35:00+03', scheduled_arrival='2016-08-30 16:55:00+03'," +
                " departure_airport='DSE', arrival_airport='SED', departure_city='Москва', " +
                "arrival_city='Воронеж'}";
        assertEquals(expected, actual);
    }
}

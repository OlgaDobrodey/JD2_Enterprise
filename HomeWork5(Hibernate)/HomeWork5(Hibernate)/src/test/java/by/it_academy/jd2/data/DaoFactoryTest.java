package by.it_academy.jd2.data;

import by.it_academy.jd2.core.dto.tool.AllAirports;
import by.it_academy.jd2.core.dto.tool.AllFlights;
import by.it_academy.jd2.core.dto.tool.api.AllAirportsInt;
import by.it_academy.jd2.core.dto.tool.api.AllFlightsInt;
import by.it_academy.jd2.core.dto.tool.hibernate.AllAirportsHibernate;
import by.it_academy.jd2.core.dto.tool.hibernate.AllFlightsHibernet;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class DaoFactoryTest {

    @Test
    void getInstanceAirport() {

        try {
            AllAirportsInt flights = DaoFactory.getInstanceAirport(DataConnectionName.POSTGRES);
            Assert.assertTrue(flights instanceof AllAirports);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Test
    void getInstanceFlights() {
        try {
            AllFlightsInt flights = DaoFactory.getInstanceFlights(DataConnectionName.POSTGRES);
            Assert.assertTrue(flights instanceof AllFlights);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getInstanceAirportForHibernate() {
        try {
            AllAirportsInt flights = DaoFactory.getInstanceAirport(DataConnectionName.HIBERNATE);
            Assert.assertTrue(flights instanceof AllAirportsHibernate);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getInstanceFlightsForHibernate() {

        try {
            AllFlightsInt flights = DaoFactory.getInstanceFlights(DataConnectionName.HIBERNATE);
            Assert.assertTrue(flights instanceof AllFlightsHibernet);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
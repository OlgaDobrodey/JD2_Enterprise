package by.it_academy.jd2.data;

import by.it_academy.jd2.core.dto.tool.AllAirports;
import by.it_academy.jd2.core.dto.tool.AllFlights;
import by.it_academy.jd2.core.dto.tool.api.AllAirportsInt;
import by.it_academy.jd2.core.dto.tool.api.AllFlightsInt;
import by.it_academy.jd2.core.dto.tool.hibernate.AllAirportsHibernate;
import by.it_academy.jd2.core.dto.tool.hibernate.AllFlightsHibernet;

public class DaoFactory {

    private static AllAirportsInt anInt;
    private static AllFlightsInt flightsInt;
    private static AllAirportsInt anIntHiber;
    private static AllFlightsInt flightsIntHiber;

    private DaoFactory() {
    }

    public static AllAirportsInt getInstanceAirport(DataConnectionName dcn) throws ClassNotFoundException {
        switch (dcn) {
            case POSTGRES: {
                if (anInt == null) {
                    anInt = new AllAirports();
                }
                return anInt;
            }
            case HIBERNATE: {
                if (anIntHiber == null) {
                    anIntHiber = new AllAirportsHibernate();
                }
                return anIntHiber;
            }
        }
        throw new IllegalArgumentException("Database connection is unknown");
    }
    public static AllFlightsInt getInstanceFlights(DataConnectionName dcn) throws ClassNotFoundException {
        switch (dcn) {
            case POSTGRES: {
                if (flightsInt == null) {
                    flightsInt = new AllFlights();
                }
                return flightsInt;
            }
            case HIBERNATE: {
                if (flightsIntHiber == null) {
                    flightsIntHiber = new AllFlightsHibernet();
                }
                return flightsIntHiber;
            }
        }
        throw new IllegalArgumentException("Database connection is unknown");
    }

}

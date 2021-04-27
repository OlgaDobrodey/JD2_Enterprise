package by.it_academy.jd2.core.dto.tool.hibernate;

import by.it_academy.jd2.core.dto.tool.api.AllAirportsInt;
import by.it_academy.jd2.core.dto.view.Airports;
import by.it_academy.jd2.core.dto.view.hibernate.AirportsHibernate;
import by.it_academy.jd2.data.ConnectionBaseHibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

public class AllAirportsHibernate implements AllAirportsInt {
    public AllAirportsHibernate() {
    }

    private final String SELECT = "From airports order by city";


    @Override
    public List<Airports> getAllAirports() {
        List<Airports> AllAirport = new ArrayList<>();
        try (Session session = ConnectionBaseHibernate.getConnectionHibernet().openSession()) {
            final Query query = session.createQuery(SELECT);
            List<AirportsHibernate> airportHibernet = (List<AirportsHibernate>) query.list();


            for (AirportsHibernate hibernate : airportHibernet) {
                final Airports airports = new Airports();
                airports.setAirport_code(hibernate.getAirport_code());
                airports.setAirport_name(hibernate.getAirport_name());
                airports.setCity(hibernate.getCity());
                airports.setCoordinates(hibernate.getCoordinates());
                airports.setTimesone(hibernate.getTimezone());
                AllAirport.add(airports);
            }
        }
        return AllAirport;
    }

    @Override
    public Airports ListOfTitlesForAirports() {
        Airports airport = new Airports();
        try (Session session = ConnectionBaseHibernate.getConnectionHibernet().openSession()) {
            Query query = session.createQuery(SELECT);
            airport.setAirport_code(ConnectionBaseHibernate.getConnectionHibernet().getClassMetadata(AirportsHibernate.class).getIdentifierPropertyName());
            String[] columnNames = ConnectionBaseHibernate.getConnectionHibernet().getClassMetadata(AirportsHibernate.class).getPropertyNames();
            airport.setAirport_name(columnNames[0]);
            airport.setCity(columnNames[1]);
            airport.setCoordinates(columnNames[2]);
            airport.setTimesone(columnNames[3]);
        }
        return airport;
    }
}

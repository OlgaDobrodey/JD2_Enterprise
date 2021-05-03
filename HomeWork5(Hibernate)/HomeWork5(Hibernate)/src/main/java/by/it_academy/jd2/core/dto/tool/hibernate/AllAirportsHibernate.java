package by.it_academy.jd2.core.dto.tool.hibernate;

import by.it_academy.jd2.core.dto.tool.api.AllAirportsInt;
import by.it_academy.jd2.core.dto.view.Airports;
import by.it_academy.jd2.core.dto.view.hibernate.AirportsHibernate;
import by.it_academy.jd2.data.ConnectionBaseHibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AllAirportsHibernate implements AllAirportsInt {
    public AllAirportsHibernate() {
    }

    private final String SELECT = "From airports order by city";


    @Override
    public List<Airports> getAllAirports() {
        List<Airports> allAirport = new ArrayList<>();
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
                allAirport.add(airports);
            }
        }
        return allAirport;
    }

    @Override
    public Airports ListOfTitlesForAirports() {
        Airports airport = new Airports();

            airport.setAirport_code(ConnectionBaseHibernate.getConnectionHibernet().getClassMetadata(AirportsHibernate.class).getIdentifierPropertyName());
            String[] columnNames = ConnectionBaseHibernate.getConnectionHibernet().getClassMetadata(AirportsHibernate.class).getPropertyNames();
            airport.setAirport_name(columnNames[0]);
            airport.setCity(columnNames[1]);
            airport.setCoordinates(columnNames[2]);
            airport.setTimesone(columnNames[3]);

        return airport;
    }

    @Override
    public List<String> getListNameCity() {
        Session session = ConnectionBaseHibernate.getConnectionHibernet().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);
        Root<AirportsHibernate> root = query.from(AirportsHibernate.class);
        query.select(root.get("city"));
        query.orderBy(builder.asc(root.get("city")));
        Query<String> q = session.createQuery(query);

        List<String> listCity = q.getResultList();
        List<String> list = listCity.stream().distinct().collect(Collectors.toList());

        return list;
    }
}

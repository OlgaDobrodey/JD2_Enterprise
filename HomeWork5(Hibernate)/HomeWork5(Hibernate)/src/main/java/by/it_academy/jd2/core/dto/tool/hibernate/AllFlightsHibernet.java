package by.it_academy.jd2.core.dto.tool.hibernate;

import by.it_academy.jd2.core.dto.Constants;
import by.it_academy.jd2.core.dto.tool.api.AllFlightsInt;
import by.it_academy.jd2.core.dto.view.Flights;
import by.it_academy.jd2.core.dto.view.hibernate.AirportsHibernate;
import by.it_academy.jd2.core.dto.view.hibernate.FlightsHibernate;
import by.it_academy.jd2.data.ConnectionBaseHibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AllFlightsHibernet implements AllFlightsInt {
    private final String SELECT = "FROM flight"
            + " WHERE (departure_airport=:depAir) and (arrival_airport=:arrAir)";
    private final String SCH_DEP_NON_NULL = " and (scheduled_departure BETWEEN '%s' AND '%s')";
    private final String SCH_ARR_NON_NULL = " and (scheduled_arrival BETWEEN '%s' AND '%s')";
    private final String ORDER_BY = " order by scheduled_departure";


    @Override
    public List<Flights> getChoiceFlights(String depAirport, String arrAirport, String scheduledDep, String scheduledArr) {
        String select = "";
        if ((!scheduledDep.equals(Constants.DEFAULT_DATE)) && (!scheduledArr.equals(Constants.DEFAULT_DATE))) {
            String scheduledDepEnd = LocalDate.parse(scheduledDep).plusDays(1).toString();
            String scheduledArrEnd = LocalDate.parse(scheduledArr).plusDays(1).toString();

            select = String.format(SELECT + SCH_ARR_NON_NULL + SCH_DEP_NON_NULL + ORDER_BY, scheduledArr, scheduledArrEnd, scheduledDep, scheduledDepEnd);
        }else if ((scheduledDep.equals(Constants.DEFAULT_DATE)) && (scheduledArr.equals(Constants.DEFAULT_DATE))) {
            select = String.format(SELECT + ORDER_BY);
        } else if ((!scheduledDep.equals(Constants.DEFAULT_DATE)) && (scheduledArr.equals(Constants.DEFAULT_DATE))) {
            String scheduledDepEnd = LocalDate.parse(scheduledDep).plusDays(1).toString();
            select = String.format(SELECT + SCH_DEP_NON_NULL + ORDER_BY, scheduledDep, scheduledDepEnd);
        } else {
            String scheduledArrEnd = LocalDate.parse(scheduledArr).plusDays(1).toString();
            select = String.format(SELECT + SCH_ARR_NON_NULL+ORDER_BY, scheduledArr, scheduledArrEnd);
        }
        Session session = ConnectionBaseHibernate.getConnectionHibernet().openSession();
        Query query = session.createQuery(select);
        query.setParameter("depAir", depAirport);
        query.setParameter("arrAir", arrAirport);
        List<FlightsHibernate> flightsHibernates = (List<FlightsHibernate>) query.list();
        return getFlightsListForHibernare(flightsHibernates);
    }




    @Override
    public List<Flights> getChoiceFlightsNoDateWithPage(String depAirport, String arrAirport, Integer page) {
        String select = SELECT + ORDER_BY;
        Session session = ConnectionBaseHibernate.getConnectionHibernet().openSession();
        Query query = session.createQuery(select);
        query.setParameter("depAir", depAirport);
        query.setParameter("arrAir", arrAirport);
        int pageSelect = (page - 1) * 25;
        query.setFirstResult(pageSelect);
        query.setMaxResults(25);

        List<FlightsHibernate> flightsHibernates = (List<FlightsHibernate>) query.list();

        return getFlightsListForHibernare(flightsHibernates);
    }

    @Override
    public List<Flights> getChoiceFlightsExperement() {
        String select = SELECT;
        Session session = ConnectionBaseHibernate.getConnectionHibernet().openSession();
        Query query = session.createQuery(select);
        query.setParameter("depAir", "DME");
        query.setParameter("arrAir", "LED");
        List<FlightsHibernate> flightsHibernates = (List<FlightsHibernate>) query.list();
        return getFlightsListForHibernare(flightsHibernates);
    }

    @Override
    public List<Flights> getFlightsList(String select) {
        Session session = ConnectionBaseHibernate.getConnectionHibernet().openSession();
        Query query = session.createQuery(select);
        List<FlightsHibernate> flightsHibernates = (List<FlightsHibernate>) query.list();
        return getFlightsListForHibernare(flightsHibernates);
    }

    public List<Flights> getFlightsListForHibernare(List<FlightsHibernate> flightsHibernates) {
        List<Flights> AllFlight = new ArrayList<>();
        for (FlightsHibernate hibernate : flightsHibernates) {
            final Flights flights = new Flights();
            flights.setFlight_no(hibernate.getFlight_no());
            flights.setStatus(hibernate.getStatus());
            flights.setDeparture_airport("(" + hibernate.getDeparture_airport() + ")" + hibernate.getDeparture_city());
            flights.setArrival_airport("(" + hibernate.getArrival_airport() + ")" + hibernate.getArrival_city());
            flights.setScheduled_arrival(hibernate.getScheduled_arrival());
            flights.setScheduled_departure(hibernate.getScheduled_departure());
            AllFlight.add(flights);
        }
        return AllFlight;
    }


    @Override
    public Flights ListOfTitlesForFlightsWhithAllParam() {
        Flights flights = new Flights();
        String[] columnNames = ConnectionBaseHibernate.getConnectionHibernet().getClassMetadata(FlightsHibernate.class).getPropertyNames();
        for (String name : columnNames) {
            System.out.println(name);
        }
        flights.setFlight_no(columnNames[4]);
        flights.setStatus(columnNames[7]);
        flights.setScheduled_departure(columnNames[6]);
        flights.setScheduled_arrival(columnNames[5]);
        flights.setDeparture_airport("(" + columnNames[2] + ")" + columnNames[3]);
        flights.setArrival_airport("(" + columnNames[0] + ")" + columnNames[1]);
        return flights;
    }
}

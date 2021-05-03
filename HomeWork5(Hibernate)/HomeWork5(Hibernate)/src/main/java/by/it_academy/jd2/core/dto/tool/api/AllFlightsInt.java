package by.it_academy.jd2.core.dto.tool.api;

import by.it_academy.jd2.core.dto.view.Flights;

import java.util.List;

public interface AllFlightsInt {

    List<Flights> getChoiceFlights
            (String depCity, String arrCity, String scheduledDep, String scheduledArr);

    List<Flights> getChoiceFlightsNoDateWithPage
            (String depCity, String arrCity, Integer page);

    List<Flights> getChoiceFlightsExperement();
    List<Flights> getFlightsList( String select);

    Flights ListOfTitlesForFlightsWhithAllParam();

}

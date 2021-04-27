package by.it_academy.jd2.core.dto.tool.api;

import by.it_academy.jd2.core.dto.Constants;
import by.it_academy.jd2.core.dto.view.Flights;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface AllFlightsInt {

    List<Flights> getChoiceFlights
            (String depAirport, String arrAirport, String scheduledDep, String scheduledArr);

    List<Flights> getChoiceFlightsNoDateWithPage
            (String depAirport, String arrAirport, Integer page);

    List<Flights> getChoiceFlightsExperement();
    List<Flights> getFlightsList( String select);

    Flights ListOfTitlesForFlightsWhithAllParam();

}

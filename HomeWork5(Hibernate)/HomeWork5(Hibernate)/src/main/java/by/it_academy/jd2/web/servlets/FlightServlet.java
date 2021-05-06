package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.tool.api.AllFlightsInt;
import by.it_academy.jd2.core.dto.view.Flights;
import by.it_academy.jd2.core.utils.CheckString;
import by.it_academy.jd2.core.utils.Constants;
import by.it_academy.jd2.data.DaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static by.it_academy.jd2.data.DataConnectionName.HIBERNATE;

@WebServlet(name = "Flight", urlPatterns = "/flight")
public class FlightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String departureAirport = req.getParameter(Constants.DEP_AIRPORT);
        String arrivalAirport = req.getParameter(Constants.ARR_AIRPORT);
        String scheduledDeparture = req.getParameter(Constants.SCHEDULED_DEP);
        String scheduledArrival = req.getParameter(Constants.SCHEDULED_ARR);


        AllFlightsInt allFlightsInt = null;
        try {
            allFlightsInt = DaoFactory.getInstanceFlights(HIBERNATE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Flights flights = allFlightsInt.ListOfTitlesForFlightsWhithAllParam();
        final HttpSession session = req.getSession();
        //req.setAttribute("title", flights);
        session.setAttribute("title", flights);
        session.setAttribute(Constants.DEP_AIRPORT, departureAirport);
        session.setAttribute(Constants.ARR_AIRPORT, arrivalAirport);
        req.setAttribute(Constants.SCHEDULED_DEP, scheduledDeparture);
        req.setAttribute(Constants.SCHEDULED_ARR, scheduledArrival);
        List<Flights> choiceFlights = allFlightsInt.getChoiceFlights(departureAirport, arrivalAirport, scheduledDeparture, scheduledArrival);

        if (CheckString.isNullOrEmptyOrBlank(scheduledDeparture) && CheckString.isNullOrEmptyOrBlank(scheduledArrival)) {

            req.setAttribute("page", 1);
            int ceil = (int) Math.ceil(choiceFlights.size() / 25.0);
            session.setAttribute("sizelist", ceil);
            req.getRequestDispatcher("/flightArport.jsp").forward(req, resp);

        } else {

            req.setAttribute("list", choiceFlights);
            req.getRequestDispatcher("/flight.jsp").forward(req, resp);
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("page", Integer.parseInt(req.getParameter("page")));
        req.getRequestDispatcher("/flightArport.jsp").forward(req, resp);
    }
}

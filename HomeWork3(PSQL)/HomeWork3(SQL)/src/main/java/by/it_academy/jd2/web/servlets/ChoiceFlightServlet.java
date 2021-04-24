package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.Constants;
import by.it_academy.jd2.core.dto.tool.AllAirports;
import by.it_academy.jd2.core.dto.tool.AllFlights;
import by.it_academy.jd2.core.dto.tool.api.AllAirportsInt;
import by.it_academy.jd2.core.dto.tool.api.AllFlightsInt;
import by.it_academy.jd2.core.dto.view.Airports;
import by.it_academy.jd2.core.dto.view.Flights;
import by.it_academy.jd2.data.ConnectionBase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Choice", urlPatterns = "/choice")

public class ChoiceFlightServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = new ConnectionBase().getConnection()) {
            AllAirportsInt airportsInt =new AllAirports();
            List<Airports> allAirports = airportsInt.getAllAirports(connection);
            req.setAttribute("listB", allAirports);

            req.getRequestDispatcher("/choice.jsp").forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = new ConnectionBase().getConnection()) {
            String departureAirport = req.getParameter(Constants.DEP_AIRPORT);
            String arrivalAirport = req.getParameter(Constants.ARR_AIRPORT);
            String scheduledDeparture = req.getParameter(Constants.SCHEDULED_DEP);
            String scheduledArrival = req.getParameter(Constants.SCHEDULED_ARR);

            AllFlightsInt allFlightsInt = new AllFlights();
            Flights flights = allFlightsInt.ListOfTitlesForFlightsWhithAllParam(connection);

            req.setAttribute("title", flights);

            req.setAttribute(Constants.DEP_AIRPORT, departureAirport);
            req.setAttribute(Constants.ARR_AIRPORT, arrivalAirport);
            req.setAttribute(Constants.SCHEDULED_DEP, scheduledDeparture);
            req.setAttribute(Constants.SCHEDULED_ARR, scheduledArrival);
            List<Flights> choiceFlights = allFlightsInt.getChoiceFlights(connection, departureAirport, arrivalAirport, scheduledDeparture, scheduledArrival);

            if ((scheduledDeparture.equals(Constants.DEFAULT_DATE)) && (scheduledArrival.equals(Constants.DEFAULT_DATE))) {
                final HttpSession session = req.getSession();
                req.setAttribute("page", 1);
                session.setAttribute("title", flights);

                session.setAttribute(Constants.DEP_AIRPORT, departureAirport);
                session.setAttribute(Constants.ARR_AIRPORT, arrivalAirport);
                int ceil = (int) Math.ceil(choiceFlights.size() / 25.0);

                session.setAttribute("sizelist", ceil);
                req.getRequestDispatcher("/flightArport.jsp").forward(req, resp);
            } else {

                req.setAttribute("list", choiceFlights);
                req.getRequestDispatcher("/flight.jsp").forward(req, resp);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


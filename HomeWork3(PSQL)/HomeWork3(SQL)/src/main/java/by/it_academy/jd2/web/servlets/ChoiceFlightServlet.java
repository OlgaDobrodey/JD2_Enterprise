package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.tool.AllAirports;
import by.it_academy.jd2.core.dto.tool.AllFlights;
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
            List<Airports> allAirports = AllAirports.getAllAirports(connection);
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
            String departureAirport = req.getParameter("departureAirport");
            String arrivalAirport = req.getParameter("arrivalAirport");
            String scheduledDeparture = req.getParameter("scheduledDeparture");
            String scheduledArrival = req.getParameter("scheduledArrival");


            Flights flights = AllFlights.ListOfTitlesForFlightsWhithAllParam(connection);

            req.setAttribute("title", flights);

            req.setAttribute("departureAirport", departureAirport);
            req.setAttribute("arrivalAirport", arrivalAirport);
            req.setAttribute("scheduledDeparture", scheduledDeparture);
            req.setAttribute("scheduledArrival", scheduledArrival);
            List<Flights> choiceFlights = AllFlights.getChoiceFlights(connection, departureAirport, arrivalAirport, scheduledDeparture, scheduledArrival);

            if ((scheduledDeparture.equals("1900-01-01")) && (scheduledArrival.equals("1900-01-01"))) {
                final HttpSession session = req.getSession();
                req.setAttribute("page", 1);
                session.setAttribute("title", flights);

                session.setAttribute("departureAirport", departureAirport);
                session.setAttribute("arrivalAirport", arrivalAirport);
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


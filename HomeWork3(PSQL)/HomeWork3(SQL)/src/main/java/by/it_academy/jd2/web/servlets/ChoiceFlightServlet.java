package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.*;
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
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "Choice", urlPatterns = "/choice")

public class ChoiceFlightServlet extends HttpServlet {
    private Connection connection;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            connection = new ConnectionBase().getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Airports> allAirports = AllAirports.getAllAirports(connection);
        req.setAttribute("listB",allAirports);

        req.getRequestDispatcher("/choice.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String departureAirport = req.getParameter("departureAirport");
        String arrivalAirport = req.getParameter("arrivalAirport");
        String scheduledDeparture = req.getParameter("scheduledDeparture");
        String scheduledArrival = req.getParameter("scheduledArrival");

        Flights flights = AllFlights.ListOfTitlesForFlightsWhithAllParam(connection);

        req.setAttribute("title", flights);
        req.setAttribute("conn", connection);
        req.setAttribute("departureAirport", departureAirport);
        req.setAttribute("arrivalAirport", arrivalAirport);
        req.setAttribute("scheduledDeparture", scheduledDeparture);
        req.setAttribute("scheduledArrival", scheduledArrival);

 if ((scheduledDeparture.equals("1900-01-01")) && (scheduledArrival.equals("1900-01-01"))) {
    req.getRequestDispatcher("/flightArport.jsp").forward(req, resp);
} else {
    List<Flights> choiceFlights = AllFlights.getChoiceFlights(connection, departureAirport, arrivalAirport, scheduledDeparture, scheduledArrival);
    req.setAttribute("list", choiceFlights);
    req.getRequestDispatcher("/flight.jsp").forward(req, resp);
}

    }
}


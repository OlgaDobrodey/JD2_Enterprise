package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.AllAirports;
import by.it_academy.jd2.core.dto.ConnectionBase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet(name = "Choice", urlPatterns = "/choice")
//SELECT * from flights
//WHERE (scheduled_departure BETWEEN '2017-08-19' AND '2017-08-22') and
//(scheduled_arrival BETWEEN '2017-08-21' AND '2017-08-23') and
//( departure_airport='DME') and
//( arrival_airport='UUS')
public class ChoiceFlightServlet extends HttpServlet {
    private Connection connection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            connection = new ConnectionBase().getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        AllAirports.getAllAirports();
        AllAirports.sendAllAirports(connection);
        req.getRequestDispatcher("/choice.jsp").forward(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String departureAirport = req.getParameter("departureAirport");
        String arrivalAirport = req.getParameter("arrivalAirport");
        LocalDate scheduledDeparture = LocalDate.parse(req.getParameter("scheduledDeparture"));
        LocalDate scheduledArrival = LocalDate.parse(req.getParameter("scheduledArrival"));
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write( departureAirport+" "+arrivalAirport+" "+scheduledDeparture+" "+scheduledArrival);


        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

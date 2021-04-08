package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.Airports;
import by.it_academy.jd2.core.dto.AllAirports;
import by.it_academy.jd2.core.dto.ConnectionBase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet(name = "Airports", urlPatterns = "/airports")
public class AirportsServlet extends HttpServlet {
    private Connection connection;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            connection = new ConnectionBase().getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        AllAirports.getAllAirports();
        Airports airports = AllAirports.ListOfTitlesForAirports(connection);
        req.setAttribute("title",airports);
        AllAirports.sendAllAirports(connection);
        req.getRequestDispatcher("/airports.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

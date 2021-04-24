package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.view.Flights;
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

@WebServlet(name = "Flight", urlPatterns = "/flight")
public class FlightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("page",  Integer.parseInt(req.getParameter("page")));
        req.getRequestDispatcher("/flightArport.jsp").forward(req, resp);

    }
}

package by.it_academy.jd2.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "Flight", urlPatterns = "/flight")
public class FlightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter writer = resp.getWriter();
//
//
//        writer.write("<p>"+req.getSession().getAttribute("conn")+"</p>");
//        writer.write("<p>"+req.getSession().getAttribute("departureAirport")+"</p>");
//        writer.write("<p>"+req.getSession().getAttribute("arrivalAirport")+"</p>");
//        writer.write("<p>"+req.getSession().getAttribute("title")+"</p>");
//        writer.write("<p>"+req.getSession().getAttribute("page")+"</p>");

        req.getSession().setAttribute("page", (int) req.getSession().getAttribute("page") + 1);
        req.getRequestDispatcher("/flightArport.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Connection conn = (Connection) req.getAttribute("conn");
//
//        try {
//            conn.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

        req.getSession().setAttribute("page", (int) req.getSession().getAttribute("page") - 1);
        req.getRequestDispatcher("/flightArport.jsp").forward(req, resp);
    }
}

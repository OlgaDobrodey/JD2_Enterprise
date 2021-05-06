package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.utils.CheckString;
import by.it_academy.jd2.core.utils.Constants;
import by.it_academy.jd2.core.dto.tool.api.AllAirportsInt;
import by.it_academy.jd2.core.dto.tool.api.AllFlightsInt;

import by.it_academy.jd2.core.dto.view.Flights;
import by.it_academy.jd2.data.DaoFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import static by.it_academy.jd2.data.DataConnectionName.HIBERNATE;

@WebServlet(name = "Choice", urlPatterns = "/choice")
public class ChoiceFlightServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AllAirportsInt airportsInt = null;
        try {
            airportsInt = DaoFactory.getInstanceAirport(HIBERNATE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            List<String> allAirports = airportsInt.getListNameCity();
            req.setAttribute("listNameAirports", allAirports);
            req.getRequestDispatcher("/choice.jsp").forward(req, resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

}}


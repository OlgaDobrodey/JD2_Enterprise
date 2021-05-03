package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.tool.api.AllAirportsInt;

import by.it_academy.jd2.core.dto.view.Airports;

import by.it_academy.jd2.data.DaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static by.it_academy.jd2.data.DataConnectionName.HIBERNATE;


@WebServlet(name = "Airports", urlPatterns = "/airports")
public class AirportsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AllAirportsInt airportsInt = null;
        try {
            airportsInt = DaoFactory.getInstanceAirport(HIBERNATE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Airports> allAirports = airportsInt.getAllAirports();
            Airports airports = airportsInt.ListOfTitlesForAirports();
            req.setAttribute("title",airports);
            req.setAttribute("listAirports",allAirports );
            req.getRequestDispatcher("/airports.jsp").forward(req, resp);


    }


}

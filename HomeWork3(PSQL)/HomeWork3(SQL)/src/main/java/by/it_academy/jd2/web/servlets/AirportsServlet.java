package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.tool.api.AllAirportsInt;
import by.it_academy.jd2.core.dto.view.Airports;
import by.it_academy.jd2.core.dto.tool.AllAirports;
import by.it_academy.jd2.data.ConnectionBase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "Airports", urlPatterns = "/airports")
public class AirportsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = new ConnectionBase().getConnection()) {
            AllAirportsInt airportsInt =new AllAirports();
            List<Airports> allAirports = airportsInt.getAllAirports(connection);
            Airports airports = airportsInt.ListOfTitlesForAirports(connection);
            req.setAttribute("title",airports);
            req.setAttribute("listA",allAirports );
            req.getRequestDispatcher("/airports.jsp").forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}

package by.it_academy.jd2.web.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ServletSessia", urlPatterns = "/session")
public class ServletSessiaa extends HttpServlet {
    private final String FIRST_NAME = "firstName";
    private final String LAST_NAME = "lastName";
    private final String message = "parameters are not in cookies and are not entered";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);

        String parameterOne;
        String parameterTwo;

        try {
            parameterOne = getStringFromParameterOrSessia(req, firstName, FIRST_NAME);
            parameterTwo = getStringFromParameterOrSessia(req, lastName, LAST_NAME);
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.write("<p> Hello, " + parameterOne + " " + parameterTwo + "!<p>");
        } catch (Exception e) {
            PrintWriter writer = resp.getWriter();
            writer.println("Error: " + message);
            writer.println(e.toString());
        }
    }

    private String getStringFromParameterOrSessia(HttpServletRequest req, String parameterValue, String parameterName) throws Exception {
        HttpSession session = req.getSession();

        if (parameterValue != null && parameterValue.trim().length() > 0) {
            String printParametrValue = parameterValue;
            session.setAttribute(parameterName, parameterValue);
            return printParametrValue;
        }
        if (!session.isNew()) {
            String printParametrValue = session.getAttribute(parameterName).toString();
            return printParametrValue;
        }

        throw new Exception();
    }
}



package by.it_academy.jd2.web.servlets;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * Class ServletWithCookies  (name = "ServletWithCookies", urlPatterns = "/cookies")
 * Class print key and value parameters view "key=parameter"
 * Key name: firstName, lastName
 * Save parameter in session or cookies (the value is set in header)
 */
@WebServlet(name = "ServletWithCookies", urlPatterns = "/cookies")
public class ServletWithCookies extends HttpServlet {
    private final String FIRST_NAME = "firstName";
    private final String LAST_NAME = "lastName";
    private final String message = "parameters are not in cookies and are not entered";

    /**
     * Override method doGet print key and value parameters view "key=parameter"
     * @param req
     * @param resp
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        String parameterOne;
        String parameterTwo;
        try {
            parameterOne = getStringFromParameterOrCookies(req, resp, firstName, FIRST_NAME);
            parameterTwo = getStringFromParameterOrCookies(req, resp, lastName, LAST_NAME);
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.write("<p> Hello, " + parameterOne + " " + parameterTwo + "!<p>");
        } catch (Exception e) {
            //e.printStackTrace();
            PrintWriter writer = resp.getWriter();
            writer.println("Error: " + message);
            writer.println(e.toString());
        }
    }

    /**
     * Metod getStringFromParameterOrCookies get parameter from request or cookies.
     * Throws an error if there are no parameters
     * @param req
     * @param resp
     * @param parameterName
     * @return printParametrValue
     * @throws IllegalArgumentException
     */
    private String getStringFromParameterOrCookies(HttpServletRequest req, HttpServletResponse resp, String parameterValue, String parameterName) throws Exception {

        String printParametrValue = "";

        if (parameterValue != null && parameterValue.trim().length() > 0) {
            printParametrValue = parameterValue;
            Cookie cookie = new Cookie(parameterName, parameterValue);
            cookie.setMaxAge(Math.toIntExact(TimeUnit.MINUTES.toSeconds(5)));
            resp.addCookie(cookie);

            return printParametrValue;
        }

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(parameterName)) {
                printParametrValue = cookie.getValue();

                return printParametrValue;
            }
        }
        throw new Exception();
    }
}





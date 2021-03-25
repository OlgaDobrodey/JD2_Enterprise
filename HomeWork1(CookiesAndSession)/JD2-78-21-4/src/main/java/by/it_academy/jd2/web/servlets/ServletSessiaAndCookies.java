package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.Person;
import by.it_academy.jd2.web.servlets.api.ViewSave;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "ServletS", urlPatterns = "/workclass")
public class ServletSessiaAndCookies extends HttpServlet {
    private final String FIRST_NAME = "firstName";
    private final String LAST_NAME = "lastName";
    private final String AGE = "age";
    private String TYPE_SAVE = "ARRAY_NAME_PARAM";
    private final String MESSAGE_EXCEPTION = "parameters are not in cookies and are not entered";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Person person = new Person();
        String header = req.getHeader(TYPE_SAVE);

        try {
            if (ViewSave.COOKIES == ViewSave.valueOf(header)) {
                person.setFirstName(getStringFromParameterOrCookies(req, resp, FIRST_NAME));
                person.setLastName(getStringFromParameterOrCookies(req, resp, LAST_NAME));
                person.setAge(Integer.parseInt(getStringFromParameterOrCookies(req, resp, AGE)));

            } else if (ViewSave.SESSION == ViewSave.valueOf(header)) {
                person.setFirstName(getStringFromParameterOrSessia(req, FIRST_NAME));
                person.setLastName(getStringFromParameterOrSessia(req, LAST_NAME));
                person.setAge(Integer.parseInt(getStringFromParameterOrSessia(req, AGE)));
            }

            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.write("<p> Hello, " + person.getFirstName() + " " + person.getLastName()
                    + " this age=" + person.getAge() + "!<p>");
        } catch (Exception e) {
            PrintWriter writer = resp.getWriter();
            writer.write("Error: " + e.toString());

        }
    }

    private String getStringFromParameterOrSessia(HttpServletRequest req, String parameterName) throws IllegalArgumentException {
        String parameterValue = req.getParameter(parameterName);
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
        throw new IllegalArgumentException(MESSAGE_EXCEPTION);
    }

    private String getStringFromParameterOrCookies(HttpServletRequest req, HttpServletResponse resp, String parameterName) throws IllegalArgumentException {
        String parameterValue = req.getParameter(parameterName);
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
        throw new IllegalArgumentException(MESSAGE_EXCEPTION);
    }
}








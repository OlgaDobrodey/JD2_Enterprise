package by.it_academy.jd2.web;

import by.it_academy.jd2.Person;
import by.it_academy.jd2.ViewSave;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "ServletS", urlPatterns = "/workclass")
public class ServletSessiaAndCookies extends HttpServlet {
//    private final String FIRST_NAME = "firstName";
//    private final String LAST_NAME = "lastName";
//    private final String AGE = "age";
    private final String message = "parameters are not in cookies and are not entered";
    private String param_save = "ARRAY_NAME_PARAM";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Person person = new Person();
        String header = req.getHeader(param_save);
        Boolean save=true;
        if(header.equals("cookies")){save = true;}
         else save = false;




        String firstName = req.getParameter(person.getFIRST_NAME());
        String lastName = req.getParameter(person.getLAST_NAME());
        String ageName = req.getParameter(person.getAGE());
        String parameterOne;
        String parameterTwo;
        String parameterThree;
        try {
            if(save){ parameterOne = getString(req, resp, firstName, person.getFIRST_NAME());
                parameterTwo = getString(req, resp, lastName, person.getLAST_NAME());
                parameterThree = getString(req,resp,ageName, person.getAGE());}
            else
            {parameterOne = getSession(req, resp, firstName, person.getFIRST_NAME());
                parameterTwo = getSession(req, resp, lastName, person.getLAST_NAME());
                parameterThree = getSession(req,resp,ageName, person.getAGE());}
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.write("<p> Hello, " + parameterOne + " " + parameterTwo +" this age="+parameterThree+ "!<p>");
        } catch (Exception e) {

            PrintWriter writer = resp.getWriter();
            writer.println("Error: " + message);
            writer.println(e.toString());
        }
    }

    private String getSession(HttpServletRequest req, HttpServletResponse resp, String parameterValue, String parameterName) throws Exception {
        HttpSession session = req.getSession();
        String printParametrValue = "";

        if (parameterValue != null && parameterValue.trim().length() > 0) {
            printParametrValue = parameterValue;
            session.setAttribute(parameterName,parameterValue);

            String parameter = printParametrValue;
            return parameter;
        }


        if(session.getAttribute(parameterName)!=null){
            printParametrValue = session.getAttribute(parameterName).toString();
            String parameter =  printParametrValue;
            return parameter;
        }

        throw new Exception();
    }

    private String getString(HttpServletRequest req, HttpServletResponse resp, String parameterValue, String parameterName) throws Exception {

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








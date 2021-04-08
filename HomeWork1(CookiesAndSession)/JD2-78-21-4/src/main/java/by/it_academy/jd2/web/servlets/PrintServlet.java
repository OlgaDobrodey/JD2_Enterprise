package by.it_academy.jd2.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Class PrintServlet(name = "PrintServlet", urlPatterns = "/print");
 * Class print key and value parameters view "key=parameter"
 * Note:  names of all keys are different
 * */
@WebServlet(name = "PrintServlet", urlPatterns = "/print")
public class PrintServlet extends HttpServlet {
    /**
     *Override metod doGet print key and value parameters view "key=parameter"
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        Enumeration<String> params = req.getParameterNames();

        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            writer.write("<p>" + paramName + ": " + req.getParameter(paramName) + "</p>");
        }
    }
}


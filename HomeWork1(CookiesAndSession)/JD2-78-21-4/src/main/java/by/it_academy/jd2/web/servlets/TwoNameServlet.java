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
 * Class TwoNameServlet  (name = "TwoNameServlet", urlPatterns = "/name")
 * Class print key and value parameters view "key=parameter"
 */
@WebServlet(name = "TwoNameServlet", urlPatterns = "/name")
public class TwoNameServlet extends HttpServlet {
    private String name = "ARRAY_NAME_PARAM";

    /**
     * Override method doGet print key and value parameters view "key=parameter"
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String header = req.getHeader(name);
        String[] strings = req.getParameterMap().get(header);
        if (strings != null) {
            for (String string : strings) {
                writer.write("<p>" + header + ": " + string + "</p>");
            }
        }
    }
}



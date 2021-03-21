package by.it_academy.jd2.web;

import by.it_academy.jd2.core.dto.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ServletSingUp",urlPatterns = "/hello")
public class ServletSingUp extends HttpServlet {
    private final String LOGIN = "login";
    private final String PASSWORD = "psw";
    private final String NAME = "name";
    private final String BIRTHDAY = "birthday";
    //private final String TYPE_SAVE = "ARRAY_NAME_PARAM";
    private final String MESSAGE_EXCEPTION = "parameters are not in cookies and are not entered";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        saveUser(LOGIN,PASSWORD,NAME,BIRTHDAY,req,resp);



    }

    private void saveUser(String login, String password, String name, String birthday, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = new User();
        user.setLogin(req.getParameter(login));
        user.setPassword(req.getParameter(password));
        user.setName(req.getParameter(name));

        user.setBirthday(req.getParameter(birthday));

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.write("<p><span style='color: black;'>Hello, "+user.toString()+"!</span></p>");
        writer.write("<p><span style='color: black;'>User зарегистрирован!</span></p>");
    }
}

package by.it_academy.jd2.web;

import by.it_academy.jd2.core.dto.DataStorageUsers;
import by.it_academy.jd2.core.dto.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ServletSingUp",urlPatterns = "/hello")
public class ServletSingUp extends HttpServlet {
    private final String LOGIN = "login";
    private final String PASSWORD = "psw";
    private final String NAME = "name";
    private final String BIRTHDAY = "birthday";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setLogin(req.getParameter(LOGIN));
        user.setPassword(req.getParameter(PASSWORD));
        user.setName(req.getParameter(NAME));
        user.setBirthday(req.getParameter(BIRTHDAY));
        DataStorageUsers.saveUsers(user);

        HttpSession session = req.getSession();
        session.setAttribute("userSender",user);
        String path = req.getContextPath() + "/menu";
        resp.sendRedirect(path);
    }
}

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

@WebServlet(name = "ServletSignIn", urlPatterns = "/servletSignIn")
public class ServletSignIn extends HttpServlet {

    private final String LOGIN = "login";
    private final String PASSWORD = "psw";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN);
        String psw = req.getParameter(PASSWORD);
        User user = DataStorageUsers.searchUserLoginAndPsw(login, psw);
        if (user != null) {
            req.setAttribute("user", user.getName());
            HttpSession session = req.getSession();
            session.setAttribute("userSender", user);
            String path = req.getContextPath() + "/menu";
            resp.sendRedirect(path);
        } else {
            getServletContext().getRequestDispatcher("/indexSignInException.jsp").forward(req, resp);
        }
    }
}


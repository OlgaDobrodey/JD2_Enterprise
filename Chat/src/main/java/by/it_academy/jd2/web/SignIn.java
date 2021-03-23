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

@WebServlet(name = "SignIn", urlPatterns = "/signIn")
public class SignIn extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getContextPath()+"/signIn";
        resp.sendRedirect(path);
    }

}

package by.it_academy.jd2.web;

import by.it_academy.jd2.core.Constants;
import by.it_academy.jd2.core.tool.DataStorageUsers;
import by.it_academy.jd2.core.view.User;
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
        HttpSession session = req.getSession();
        if(!session .isNew()){ session.removeAttribute(Constants.USER_SENDER);}
        getServletContext().getRequestDispatcher("/indexSignIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(Constants.LOGIN);
        String psw = req.getParameter(Constants.PASSWORD);
        User user = DataStorageUsers.searchUserLoginAndPsw(login, psw);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute(Constants.USER_SENDER, user);
            String path = req.getContextPath() + "/menu";
            resp.sendRedirect(path);
        } else {
            req.setAttribute("invalidUserLogin",true);      // Дополнительного комментарий "Не верный логин или пароль"                                      // Авторизация не выполнена, попробуйте снова!
            getServletContext().getRequestDispatcher("/indexSignIn.jsp").forward(req, resp);
        }
    }
}


package by.it_academy.jd2.web;

import by.it_academy.jd2.core.dto.Constants;
import by.it_academy.jd2.core.dto.DataStorageUsers;
import by.it_academy.jd2.core.dto.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "SignUp", urlPatterns = "/signUp")
public class SignUp extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/indexSignUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setLogin(req.getParameter(Constants.LOGIN));
        user.setPassword(req.getParameter(Constants.PASSWORD));
        user.setName(req.getParameter(Constants.NAME));
        user.setBirthday(req.getParameter(Constants.BIRTHDAY));
        User userSearch = DataStorageUsers.searchUserLogin(user.getLogin());
        if(userSearch!=null){
            req.setAttribute("userNo",true);
            getServletContext().getRequestDispatcher("/indexSignUp.jsp").forward(req, resp);
        }
        DataStorageUsers.saveUsers(user);
        HttpSession session = req.getSession();
        session.setAttribute(Constants.USER_SENDER,user);
        String path = req.getContextPath() + "/menu";
        resp.sendRedirect(path);
    }
}

